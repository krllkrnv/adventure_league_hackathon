<template>
  <not-allowed class="allowed-class" v-if="this.$store.getters.GET_USER.role !== 'Администратор'"></not-allowed>
  <div v-else class="container py-3">
    <div class="main-container">
      <v-card>
          <v-card-actions>
            <v-btn
                :variant="active_statuses.active_abitur ? 'outlined' : 'text'"
                 @click="buttonClick(0)" rounded="5" prepend-icon="mdi: mdi-human-child">Абитуриенты</v-btn>
            <v-btn
                :variant="active_statuses.active_students ? 'outlined' : 'text'"
                 @click="buttonClick(1)" rounded="5" prepend-icon="mdi: mdi-account-school-outline">Студенты</v-btn>
            <v-btn
                :variant="active_statuses.active_curators ? 'outlined' : 'text'"
                 @click="buttonClick(2)" rounded="5" prepend-icon="mdi: mdi-account-group-outline">Кураторы</v-btn>
            <v-btn
                :variant="active_statuses.active_teachers ? 'outlined' : 'text'"
                 @click="buttonClick(3)" rounded="5" prepend-icon="mdi: mdi-human-male-board">Преподаватели</v-btn>
            <v-btn
                :variant="active_statuses.active_committee ? 'outlined' : 'text'"
                 @click="buttonClick(4)" rounded="5" prepend-icon="mdi: mdi-gavel">Приемная комиссия</v-btn>

            <v-btn @click="showDialog = true" variant="outlined" rounded="5" icon="mdi: mdi-plus"></v-btn>
          </v-card-actions>
      </v-card>
      <v-dialog
          persistent
          max-width="650px"
          v-model="showDialog">
        <admin-person-adding
            @close-dialog="this.showDialog = false"
        ></admin-person-adding></v-dialog>
    </div>
    <v-card  align="center" elevation="0" vatiant="text" class="cards-list">
      <v-list v-for="person in filtered_study_subjects_list">
        <v-card width="80%" class="list-element ma-2 pa-2">
          <v-card-title class="text-center">{{person.user_surname}} {{person.user_name}} {{person.user_patronymic}}</v-card-title>
          <v-card-subtitle class="text-center">{{person.role}}</v-card-subtitle>
          <div class="text-left">
            <v-card-text>
              Логин: {{person.login}}
              <v-spacer></v-spacer>
              Почта: {{person.email}}
              <v-spacer></v-spacer>
              Номер: {{person.phone_number}}
              <v-spacer></v-spacer>
              Телеграм: {{person.tg}}
              <v-spacer></v-spacer>
            </v-card-text>
          </div>
        </v-card>
      </v-list>
    </v-card>
  </div>
</template>

<script>
import notAllowed from "../components/UI/notAllowed.vue";
import adminPersonAdding from "../components/UI/adminPersonAdding.vue";
import axios from "axios";
export default {
  components: {
    adminPersonAdding, notAllowed
  },

  data(){
    return{
      showDialog: false,
      study_subjects_list: [
        {
          id: 0,
          user_name: 'Иван',
          user_surname: 'Иванов',
          user_patronymic: 'Иванович',
          login: 'ivanovii',
          email: 'ivanovii@mail.com',
          phone_number: '+7 (902) 123-45-67',
          tg: '@ivanovii',
          role: 'Куратор'
        },
        {
          id: 1,
          user_name: 'Пупа',
          user_surname: 'Пупупа',
          user_patronymic: 'Пупупупа',
          login: 'ivanovii',
          email: 'ivanovii@mail.com',
          phone_number: '+7 (902) 123-45-67',
          tg: '@ivanovii',
          role: 'Преподаватель'
        },
        {
          id: 2,
          user_name: 'name',
          user_surname: 'surname',
          user_patronymic: 'patronymic',
          login: 'ivanovii',
          email: 'ivanovii@mail.com',
          phone_number: '+7 (902) 123-45-67',
          tg: '@ivanovii',
          role: 'Студент'
        },
        {
          id: 3,
          user_name: 'name1',
          user_surname: 'surname2',
          user_patronymic: 'patronymic3',
          login: 'ivanovii',
          email: 'ivanovii@mail.com',
          phone_number: '+7 (902) 123-45-67',
          tg: '@ivanovii',
          role: 'Студент'
        }
      ],
      active_statuses:
        {
          active_curators: false,
          active_teachers: false,
          active_students: false,
          active_committee: false,
          active_abitur: false
        }

    }
  },
  methods: {
    buttonClick(index) {
      switch (index) {
        case 0:
          this.active_statuses.active_abitur = !this.active_statuses.active_abitur;
            this.active_statuses.active_committee = false;
            this.active_statuses.active_curators = false
            this.active_statuses.active_teachers = false;
            this.active_statuses.active_students = false;
          break;
        case 1:
          this.active_statuses.active_students = !this.active_statuses.active_students;
          this.active_statuses.active_committee = false;
          this.active_statuses.active_curators = false
          this.active_statuses.active_teachers = false;
          this.active_statuses.active_abitur = false;

          break;
        case 2:
          this.active_statuses.active_curators = !this.active_statuses.active_curators;
          this.active_statuses.active_committee = false;
          this.active_statuses.active_abitur = false
          this.active_statuses.active_teachers = false;
          this.active_statuses.active_students = false;

          break;
        case 3:
          this.active_statuses.active_teachers = !this.active_statuses.active_teachers;
          this.active_statuses.active_committee = false;
          this.active_statuses.active_curators = false
          this.active_statuses.active_abitur = false;
          this.active_statuses.active_students = false;

          break;
        case 4:
          this.active_statuses.active_committee = !this.active_statuses.active_committee;
          this.active_statuses.active_abitur = false;
          this.active_statuses.active_curators = false
          this.active_statuses.active_teachers = false;
          this.active_statuses.active_students = false;

          break;
        default:
          break;
      }
    }
  },
  computed: {
    filtered_study_subjects_list() {
      if (
          !this.active_statuses.active_curators &&
          !this.active_statuses.active_teachers &&
          !this.active_statuses.active_students &&
          !this.active_statuses.active_abitur &&
          !this.active_statuses.active_committee
      ) {
        return this.study_subjects_list;
      } else if (this.active_statuses.active_curators) {
        return [...this.study_subjects_list].filter((person => person.role === 'Куратор'));
      } else if (this.active_statuses.active_teachers) {
        return [...this.study_subjects_list].filter((person => person.role === 'Преподаватель'));
      } else if (this.active_statuses.active_students) {
        return [...this.study_subjects_list].filter((person => person.role === 'Студент'));
      } else if (this.active_statuses.active_abitur) {
        return [...this.study_subjects_list].filter((person => person.role === 'Абитуриент'));
      } else if (this.active_statuses.active_committee) {
        return [...this.study_subjects_list].filter((person => person.role === 'Член приемной комиссии'));
      }
    }
  },
  mounted() {
    if (this.$store.getters.GET_USER.role !== 'Администратор') {
      setTimeout(() => {
        this.$router.push('/');
      }, 2000);
    }
  }

};
</script>

<style scoped>
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 0.3rem;
}
.v-card {
  flex-shrink: 0;
  border-radius: 1.5rem;
  background: #d3e0f5;
}

.v-card-title {
  color: #5A5A5A;
  font-size: 1.25rem;
  font-style: normal;
  font-weight: 600;
  line-height: normal;
}

.v-card-text {
  color: #020B3B;
  font-size: 0.875rem;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}
.v-list {
  background-color: #F3F1F1;
}
.list-element{
  transition: transform 0.3s ease-in-out;
}
.list-element:hover{
  transform: scale(1.05);
}
.cards-list{
  flex-direction: column;
}
</style>
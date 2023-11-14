<template>
  <h1 class="blue-scheme ml-2 my-2">
    Группа {{ group.number }}
  </h1>
  <div class="main-container">
    <v-list class="description-block">
      <v-list-subheader class="description__title mx-4 mb-2">
        Список группы
      </v-list-subheader>
      <div class="description__body">
        <v-list-item
          v-for="(student, index) in group.students"
          :key="group.id + 'student_' + index"
        >
          <template v-slot:prepend>
            <v-icon icon="mdi-account-outline"></v-icon>
          </template>
          <v-list-item-title>{{ student.studentName }}</v-list-item-title>
        </v-list-item>
      </div>
    </v-list>
  </div>
</template>

<script>
import router from '../router/router.js'
import { mapState } from 'vuex'
export default {
  data() {
    return {
      group: {
        id: 0,
        number: '0375',
        students: [
          {
            studentId: 0,
            studentName: 'Федотов Максим'
          },
          {
            studentId: 1,
            studentName: 'Мишин Дмитрий'
          },
          {
            studentId: 4,
            studentName: 'Горюнов Олег'
          },
          {
            studentId: 2,
            studentName: 'Юшин Максим'
          },
          {
            studentId: 7,
            studentName: 'Шпрингер Дмитрий'
          },
          {
            studentId: 3,
            studentName: 'Михайлов Олег'
          }
        ]
      }
    }
  },
  mounted() {
    //this.data.push(this.$route.params.data);
  },
  methods: {
  },
  computed: {
  }
}
</script>

<style lang="scss" scoped>

.main-container {
  background-color: #F3F1F1;
}

.description-block {
  background-color: #F3F1F1;
  .v-icon {
    color: #020B3B;
  } 

  .description__title {
    color: #020B3B;
    font-size: 1.75rem;
    font-style: normal;
    font-weight: 200;
    line-height: normal;
    }

  .description__body {
    margin-left: 3rem;
    color: #5A5A5A;
    font-size: 1rem;
    font-style: normal;
    font-weight: 400;
    line-height: 1.5rem; /* 150% */
    letter-spacing: 0.01rem;
  }
}
</style>
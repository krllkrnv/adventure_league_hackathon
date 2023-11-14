<template>
  <div>
    <v-card variant="text">
      <v-layout>
        <v-app-bar prominent :elevation="0" color="#8EB0E4" >
          <v-app-bar-nav-icon color="#F3F1F1" icon="mdi:mdi-menu"
                              @click.stop="showSidebar = !showSidebar"></v-app-bar-nav-icon>
          <router-link class="ma-5" style="text-decoration: none; color: #F3F1F1;" to="/">
            <v-toolbar-title>Корпоративный институт</v-toolbar-title>
          </router-link>
          <v-spacer></v-spacer>
          <v-spacer></v-spacer>
            <div v-if="this.$store.getters.GET_USER.role">
          <v-btn
                  class="ma-5"
                 variant="tonal" rounded="5" color="#F3F1F1" prepend-icon="mdi:mdi-newspaper" :to="{name: 'news'}">Новости</v-btn>
          <v-btn class="ma-5"
                 variant="tonal" rounded="5" color="#F3F1F1" prepend-icon="mdi:mdi-calendar" :to="{name: 'timetable'}">Расписание</v-btn>
            </div>
          <v-btn v-if="!user.role"
              class="ma-5"
              variant="tonal" rounded="5" color="#F3F1F1" append-icon="mdi:mdi-account" :to="{name: 'login'}">Войти</v-btn>
          <v-btn v-else class="ma-5"
                 variant="tonal" rounded="5" color="#F3F1F1" prepend-icon="mdi:mdi-account" :to="{name: 'user'}">{{buttonName}}</v-btn>
        </v-app-bar>
        <v-navigation-drawer
            class="elevation-0"
            location="left"
            temporary
            v-model="showSidebar"
            width="500px"
        >
          <v-list>
              <v-list-item>
                  <v-btn :to="'/courses'" prepend-icon="mdi: mdi-book-open-page-variant-outline" variant="text">Все курсы</v-btn>
              </v-list-item>
              <v-list-item>
                  <v-btn :to="'/myAllCourses'" prepend-icon="mdi: mdi-book-account-outline" variant="text">Мои курсы</v-btn>
              </v-list-item>
              <v-list-item>
                  <v-btn :to="'/requestForAdmCom'" prepend-icon="mdi: mdi-note-multiple-outline" variant="text">Заявки</v-btn>
              </v-list-item>
              <v-list-item>
                  <v-btn prepend-icon="mdi: mdi-chart-box-outline" variant="text">Статистика</v-btn>
              </v-list-item>
            <v-list-item>
              <v-btn :to="'/allGroupsForTutor'" prepend-icon="mdi: mdi-account-group-outline" variant="text">Мои группы</v-btn>
            </v-list-item>
              <v-list-item>
                  <v-btn :to="'/admin'" prepend-icon="mdi: mdi-security" variant="text">Администрирование</v-btn>
              </v-list-item>


            <v-list-item><v-spacer></v-spacer></v-list-item>
              <v-list-item>
                  <v-btn @click="logOut" prepend-icon="mdi: mdi-logout" color="error" variant="text">Выйти</v-btn>
              </v-list-item>
          </v-list>
        </v-navigation-drawer>
        <v-main class="v-main-class">
          <v-app>
            <slot></slot>
          </v-app>
        </v-main>
      </v-layout>
    </v-card>
  </div>
</template>

<script>

import {mapGetters} from "vuex";

export default {
  data(){
    return{
      showSidebar: false,
      user: this.$store.getters.GET_USER
    }
  },
  computed: {
    buttonName(){
      return `${this.user.lastname} ${this.user.firstname.charAt()}.`
    },
    ...mapGetters(['GET_USER'])
  },
  methods: {
    logOut(){
      localStorage.removeItem('token');
      this.$store.dispatch('DISPATCH_SET_USER', {
        userId: 0,
        firstname: '',
        lastname: '',
        patronymic: '',
        login: '',
        email: '',
        phoneNumber: '',
        telegram: '',
        role: ''
      });
      this.$router.go('/')
    }
  },
  watch: {
    '$store.getters.GET_USER': function (state){
      this.user = state
    }
  }
}
</script>

<style scoped>
.v-btn{
    color: #5A5A5A;
}

</style>
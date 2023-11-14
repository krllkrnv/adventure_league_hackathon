<template>
  <div class="container">
    <div class="main-container">
  <v-card class="user-card ma-2 pa-5" v-if="user" color="5A5A5A" variant="text">
    <v-card-title class="text-h5">{{ fullName }}</v-card-title>
    <v-card-subtitle class="text-subtitle-1">{{user.role}}</v-card-subtitle>
    <v-list>
      <v-list-item prepend-icon="mdi: mdi-account" :title="user.login"></v-list-item>
      <v-list-item prepend-icon="mdi: mdi-at" :title="user.email"></v-list-item>
      <v-list-item prepend-icon="mdi: mdi-phone" :title="user.phoneNumber"></v-list-item>
    </v-list>
  </v-card>
  <v-card color="5A5A5A" v-if="!user.role" variant="text" class="form-class ma-2 pa-5">Необходима авторизация</v-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import {mapGetters} from 'vuex'
export default {
data(){
  return{
    user: this.$store.getters.GET_USER
  }
},

  computed: {
  fullName(){
    return `${this.user.firstname} ${this.user.lastname} ${this.user.patronymic}`
  },
    ...mapGetters(['GET_USER'])
  },
  watch: {
    '$store.getters.GET_USER': function (state){
      this.user = state
    }
  },
  methods: {
  }
  ,
}
</script>

<style scoped>
.v-list{
  background-color: #F3F1F1;
}
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
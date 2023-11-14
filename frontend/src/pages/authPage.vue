<template>
  <v-card variant="text" class="form-class ma-2 pa-5">
    <v-card variant="tonal" class="error-msg ma-1" v-if="errorMessage" rounded="5" color="red">{{ errorMessage }}</v-card>

    <form @submit.prevent="submitUser">
      <input required
             v-model="login"
             type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Логин"
      >
      <br>
      <input required v-model="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Пароль">

      <br>
      <div class="text-center">
        <v-btn variant="tonal" rounded="5" color="#8EB0E4" type="submit">Войти</v-btn>
      </div>
    </form>
  </v-card>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      login: '',
      password: '',
      errorMessage: null
    }
  },
  methods: {
    async submitUser() {
      try {
        const response = await axios.post('api/v1/auth/authenticate', {
          email: this.login,
          password: this.password
        });
        if (response.status === 200) {
          console.log(this.$store.getters.GET_USER)
          localStorage.setItem('token', response.data.access_token)
          console.log(response.data.access_token)
          this.$store.dispatch('DISPATCH_SET_USER', {
            userId: response.data.userId,
            firstname: response.data.firstname,
            lastname: response.data.lastname,
            patronymic: response.data.patronymic,
            login: response.data.login,
            email: '',
            phoneNumber: response.data.phoneNumber,
            telegram: response.data.telegram,
            role: response.data.role
          })
          console.log(this.$store.getters.GET_USER)
          this.$router.push('/user')
        }
      } catch (error) {
        this.handleError(error)
      }
    }
    ,
    handleError(error) {
      if (error.response) {
        if (error.response.status === 403) {
          this.errorMessage = "Не найдено или введены некорректные данные";
        } else if (error.response.status === 500) {
          this.errorMessage = "Ошибка сервера";
        }
      } else {
        this.errorMessage = "Произошла ошибка при отправке запроса";
      }
    }
  }
}
</script>

<style scoped>
.form-class{
  width: 35%;
  align-self: center;
}
.error-msg {
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
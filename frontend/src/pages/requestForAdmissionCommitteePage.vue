<template>
  <not-allowed class="allowed-class" v-if="this.$store.getters.GET_USER.role !== 'Член приемной комиссии'"></not-allowed>
  <div v-else class="container py-3">
    <div class="main-container">
      <v-card
          elevation="5"
          v-for="(request, index) in requests"
          :key="'request__' + index"
      >
        <v-card-title class="mb-2 text-center">
          {{ request.headName }}
        </v-card-title>
        <v-card-text>
          <div class="my-1">
            <div class="title-item ml-4 mr-2">Наименование подразделения:</div> {{ request.division }}
          </div>
          <div class="my-1">
            <div class="title-item ml-4 mr-2">Текущая должность:</div> {{ request.position }}
          </div>
          <div class="my-1">
            <div class="title-item ml-4 mr-2">Стаж работы:</div> {{ request.seniority }}
          </div>
          <div class="my-1">
            <div class="title-item ml-4 mr-2">Личные достижения:</div> {{ request.achievements }}
          </div>
          <div class="my-1">
            <div class="title-item ml-4 mr-2">Мотивационное письмо:</div> {{ request.letter }}
          </div>
        </v-card-text>
        <v-card-actions class="justify-content-around">
          <v-btn @click="solutionAboutRequest(false)" color="error" variant="tonal"  rounded="5" >Отклонить</v-btn>
          <v-btn @click="solutionAboutRequest(true)" color="#006400" variant="tonal"  rounded="5">Одобрить</v-btn>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<script>
import router from '../router/router.js'
import notAllowed from "../components/UI/notAllowed.vue";
import axios from "axios";
export default {
  components: {notAllowed},

  data() {
    return {
      requests: null
    }
  },
  methods: {
    beforeRouteEnter() {
      this.getAllRequests();
    },
    async getAllRequests() {
      try {
        const response = await axios.get('/getAllRequests', {
        });
      } catch (error) {
        this.handleError(error);
      }
    },
    async fetchRequests() {
      try {
        const response = await axios.get('/api/v1/application', {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        });
        if (response.status === 200) {
          this.requests = response.data;
          console.log(response)
        }
      } catch (error) {
        this.handleError(error);
      }
    },
    handleError(error) {
      if (error.response) {
        if (error.response.status === 404) {
          console.log("Страница не найдена");
        } else if (error.response.status === 500) {
          console.log("Ошибка сервера");
        }
      } else {
        console.log("Произошла ошибка при отправке запроса");
      }
    },
  },
  created(){
    if (this.$store.getters.GET_USER.role === 'Член приемной комиссии') {
    this.fetchRequests()
      }
  },
  mounted() {
    if (this.$store.getters.GET_USER.role !== 'Член приемной комиссии') {
      setTimeout(() => {
        this.$router.push('/');
      }, 2000);
    }
  }
}
</script>

<style lang="scss" scoped>

.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.blue-scheme{
  color: #020B3B;
}

.v-card {
  width: 50%;
  flex-shrink: 0;
  border-radius: 1.5rem;
  margin: 2rem;
  background: #d3e0f5;
}

.v-card-title {
  color: #5A5A5A;
  font-size: 1.25rem;
  font-style: normal;
  font-weight: 600;
  line-height: normal;
}

.title-item {
  display: inline-block;
  color: #020B3B;
  font-size: 1rem;
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

</style>

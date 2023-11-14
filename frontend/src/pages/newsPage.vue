<template>
  <not-allowed class="allowed-class" v-if="this.$store.getters.GET_USER.role === 'Гость'"></not-allowed>
  <div v-else class="container py-3">
    <div class="main-container">
      <v-card
          elevation="5"
      v-for="(newItem, index) in news"
      :key="'newItem_' + index"
      >
        <v-card-title>{{newItem.title}}</v-card-title>
        <v-card-subtitle>{{newItem.date}}</v-card-subtitle>
        <v-card-text>{{newItem.text}}</v-card-text>
        <v-card-actions>
          <v-btn
              @click="transitionToNew(newItem.id)"
              width="100%"
             color="#5A5A5A" variant="outlined" class="mx-auto" rounded="5" append-icon="mdi: mdi-arrow-right">Читать</v-btn>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<script>
import notAllowed from "../components/UI/notAllowed.vue";
import axios from "axios";
export default {
  components: {
    notAllowed
  },
  data() {
    return {
      news: null
    }
  },
  methods: {
    async fetchNews() {
      try {
        const response = await axios.get('/api/v1/news');
        if (response.status === 200) {
          this.news = response.data;
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
  mounted() {
    if (!this.$store.getters.GET_USER.role) {
      setTimeout(() => {
        this.$router.push('/');
      }, 2000);
    }
  },
  created() {
    if (this.$store.getters.GET_USER.role) {
      this.fetchNews()
    }
  }
}
</script>

<style scoped>
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.v-card {
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

.v-card-text {
  color: #020B3B;
  font-size: 0.875rem;
  font-style: normal;
  font-weight: 400;
  line-height: normal;
}

</style>
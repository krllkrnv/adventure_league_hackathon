<template>
  <not-allowed class="allowed-class" v-if="this.$store.getters.GET_USER.role !== 'Студент'"></not-allowed>
  <div v-else class="main-container">
		<h1 class="blue-scheme ml-2 my-2">
			Мои курсы
		</h1>
		<v-card
			elevation="5"
      v-for="(course, index) in courses"
      :key="'course_' + index"
     >
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="156px"
        cover
      ></v-img>
      <v-card-title>
        {{ course.name }}
      </v-card-title>
      <v-card-text>
        <h4>Рассчетное время прохождения: <span style="color: #5A5A5A;">{{ course.body.duration }}</span></h4>
	        <h4>Пройдено:</h4>
	        <v-progress-linear 
	        	class="blue-scheme" 
	        	:model-value="course.body.passingPercent" 
	        	:height="12" 
	        	rounded
	        >
	        	<strong v-if=" Math.ceil(course.body.passingPercent) <= 49">{{ Math.ceil(course.body.passingPercent) }}%</strong>
	        	<strong v-else style="color: #F3F1F1">{{ Math.ceil(course.body.passingPercent) }}%</strong>
	        </v-progress-linear>
      </v-card-text>
      <v-card-actions class="justify-content-around">
          <v-btn @click.stop="transitionToCourse(course.id)" color="#5A5A5A" variant="outlined" class="ma-2 pa-2 mr-auto" rounded="5" append-icon="mdi: mdi-arrow-right">Перейти на страницу курса</v-btn>
        </v-card-actions>
      </v-card>
	</div>
</template>

<script>
import router from '../router/router.js'
import { mapState } from 'vuex'
import notAllowed from "../components/UI/notAllowed.vue";
import courseRegistration from "../components/UI/courseRegistration.vue";
export default {
	components: {
		courseRegistration, notAllowed
	},
	data() {
		return {
			courses: [
				{
          id: 0,
          name: 'Экономика',
          body: {
          	duration: 14,
          	passingPercent: 18
          }
        },
        {
          id: 1,
          name: 'Маркетинг',
          body: {
          	duration: 60,
          	passingPercent: 90
          } 
        }
			]
		}
	},
	methods: {
		async transitionToCourse(id) {
      try {
        const response = await axios.get('/course', {
          userId: this.userId,
          courseId: id
        });
        if (response.status === 200) {
          router.push({
            name: '/course',
            params: {
              data: response.data
            }
          });
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
	computed: {
		computed: {
			...mapState({userId: state => state.user.user_id})
		}

	},
  mounted() {
    if (this.$store.getters.GET_USER.role !== 'Администратор') {
      setTimeout(() => {
        this.$router.push('/');
      }, 2000);
    }
  }
}
</script>

<style lang="scss" scoped>

.blue-scheme{
	color: #020B3B;
}

.main-container {
	background-color: #F3F1F1;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.v-card {
  width: 80%;
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

	  .v-progress-linear {
	  	width: 80%;
	  }
}

</style>

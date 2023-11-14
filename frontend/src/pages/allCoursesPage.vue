<template>
  <not-allowed class="allowed-class" v-if="!this.$store.getters.GET_USER.role"></not-allowed>
  <div v-else class="container py-3">
        <div class="main-container">
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
                    {{ course.courseName }}
                </v-card-title>
                <v-card-text>
                    {{ course.description }}
                </v-card-text>
                <v-card-actions class="justify-content-around">
                    <v-btn
                            @click.stop="openDialog(index)" color="#5A5A5A" variant="outlined" class="ma-2 pa-2" rounded="5" prepend-icon="mdi: mdi-plus-circle-outline">Записаться</v-btn>
                    <v-btn  color="#5A5A5A" variant="outlined" class="ma-2 pa-2" rounded="5" append-icon="mdi: mdi-arrow-right">Перейти на страницу курса</v-btn>
                </v-card-actions>
                <v-dialog
                        persistent
                        max-width="650px"
                        v-model="showDialog[index]">
                    <course-registration
                            @close-dialog="closeDialog"
                            :course-name="course.courseName"></course-registration></v-dialog>
            </v-card>
        </div>
    </div>

</template>

<script>
import notAllowed from "../components/UI/notAllowed.vue";
import router from '../router/router.js'
import { mapState } from 'vuex'
import axios from 'axios'

import courseRegistration from "../components/UI/courseRegistration.vue";
export default {
    components: {
        courseRegistration, notAllowed
    },
    data() {
        return {
            courses: null,
            showDialog: [],
        }
    },
    methods: {
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
        openDialog(index){
            this.showDialog = [];
            this.showDialog[index] = true;
        },
        closeDialog() {
            // Закрываем текущее окно
            this.showDialog = [];
        },
       async fetchCourses(){
          try {
            const response = await axios.get('/api/v1/courses', {
              headers: {
                Authorization: `Bearer ${localStorage.getItem('token')}`
              }
            });
            if (response.status === 200) {
              this.courses = response.data
              console.log(response)
            }
          } catch (error) {
            this.handleError(error)
          }
        }
    },
    created() {
      if (this.$store.getters.GET_USER.role) {
        this.fetchCourses()
      }
    },
  mounted() {
    if (!this.$store.getters.GET_USER.role) {
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
}

</style>

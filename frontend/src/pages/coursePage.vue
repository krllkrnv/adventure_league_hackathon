<template>
  <div class="main-container">
    <v-img
        src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
        height="14.875rem"
        cover
    >
      <div class="title">
        {{ courseName }}
      </div>
      <button v-if="courseStatus === false" class="sign-up-btn" @click="signUpOnCourse">
        Записаться
      </button>
      <button v-else class="sign-up-btn success">
        Записан на курс!
      </button>
    </v-img>
    <div class="description-block">
      <div class="description__title mx-4 mt-4 mb-2">
        <v-icon
            v-if="flagOpenInfo.about === false"
            icon="mdi-chevron-down"
            size="x-large"
            class="mr-3"
            @click="closeOpenInfo('about')"
        />
        <v-icon
            v-else
            icon="mdi-chevron-up"
            size="x-large"
            class="mr-3"
            @click="closeOpenInfo('about')"
        />
        <div class="part-name m-0">О курсе</div>
      </div>
      <transition name="fade">
        <div v-if="flagOpenInfo.about === true" class="description-body mx-4 mt-2">
          {{ description.about }}
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import router from '../router/router.js'
import { mapState } from 'vuex'
export default {
  data() {
    return {
      flagOpenInfo: {},
      courseId: 0,
      courseName: 'Экономика',
      courseStatus: false,
      description: {
        about: 'Цель онлайн-курса, созданного специалистами ВШЭ, одного из ведущих экономических вузов России — познакомить слушателя с ключевыми экономическим понятиями, заинтересовать предметом и, возможно, стимулировать к дальнейшему его изучению. Курс может быть успешно пройден без каких-либо начальных экономических знаний, хотя будут полезны математические знания уровня 10–11 классов средней школы. Курс делится на 10 фрагментов, каждый из которых содержит материал, который можно комфортно изучить в дистанционном формате за одну неделю. В конце каждого фрагмента слушателю предлагается тренировочное и контрольное тестовое задания. Также большие итоговые тесты предусмотрены в середине и в конце курса. Курс содержит большое количество визуальной информации, сопровождающей и дополняющей текст лектора, анимацию и другие технические средства, позволяющие повысить его интерактивность. Теоретический материал тесно связан с дополняющими его практическими заданиями. После каждого фрагмента слушателям, заинтересованным в более углубленном обучении, предлагается большой набор дополнительных материалов и источников дополнительной информации.'
      }
    }
  },
  mounted() {
    //this.data.push(this.$route.params.data);
    for (let key in this.description) {
      this.flagOpenInfo[key] = true;
    }
  },
  methods: {
    closeOpenInfo(key) {
      this.flagOpenInfo[key] = !this.flagOpenInfo[key];
    },
    async signUpOnCourse() {
      try {
        const response = await axios.post('/signUpCourse', {
          userId: this.userId,
          courseId: this.courseId
        });
        if (response.status === 200) {
          this.courseStatus = true;
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
    }
  },
  computed: {
    ...mapState({userId: state => state.user.user_id})
  }
}
</script>

<style lang="scss" scoped>

.main-container {
  background-color: #9CCAF0;
}

.sign-up-btn {
  margin-left: 2.5rem;
  width: 11.9375rem;
  height: 2.5rem;
  flex-shrink: 0;
  border-radius: 1.25rem;
  border: 2px solid #020B3B;
  background: #F3F1F1;
  color: #020B3B;
  font-size: 1.25rem;
  font-style: normal;
  font-weight: 500;
  line-height: normal;
}

.success {
  background-color: #9CCAF0;
}

.title {
  margin-top: 3.5rem;
  margin-left: 2.5rem;
  color: #020B3B;
  font-size: 3.75rem;
  font-style: normal;
  font-weight: 600;
  line-height: normal;
}

.description-block {

  .description__title {
    display: flex;
    align-items: center;
    justify-content: start;

    .v-icon {
      color: #F3F1F1;
    }

    .part-name {
      color: #F3F1F1;
      color: #F3F1F1;
      font-size: 2rem;
      font-style: normal;
      font-weight: 600;
      line-height: normal;
    }
  }

  .description-body {
    color: #020B3B;
    font-size: 1rem;
    font-style: normal;
    font-weight: 400;
    line-height: 1.5rem; /* 150% */
    letter-spacing: 0.01rem;
  }
}

.title {
  margin-top: 3.5rem;
  margin-left: 2.5rem;
  color: #020B3B;
  font-size: 3.75rem;
  font-style: normal;
  font-weight: 600;
  line-height: normal;
}

</style>

<style type="css">
.fade-enter-from{
  opacity: 0;
  transform: translateY(-30px);
}
.fade-enter-active{
  transition: all 0.5s;
}

.fade-leave-active{
  transition: all 0.5s;
  display: none;
}

.fade-leave-to{
  transform: translateY(-30px);
  opacity: 0;
  transition: all 0.5s;
}

.fade-move{
  transition: all 0.5s;
}
</style>

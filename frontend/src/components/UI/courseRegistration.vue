<template>
  <v-card rounded="5" variant="text" class="form-class pa-5">
    <v-card-title class="text-center">Запись на курс {{courseName}}</v-card-title>
    <br>
    <form @submit.prevent="submitRequest">
      <div class="input-container">
        <input required v-model="curatorFullName" type="text" class="form-control" id="curatorFullName" placeholder="ФИО непосредственного руководителя">
      </div>

      <div class="input-container">
        <input required v-model="subdivisionName" type="text" class="form-control" id="subdivisionName" placeholder="Наименование подразделения">
      </div>

      <div class="input-container">
        <input required v-model="currentJobTitle" type="text" class="form-control" id="currentJobTitle" placeholder="Текущая должность ">
      </div>

      <div class="input-container">
        <input required v-model="workExperience" type="text" class="form-control" id="workExperience" placeholder="Стаж работы">
      </div>

      <div class="input-container">
        <input required v-model="personalAchievements" type="text" class="form-control" id="personalAchievements" placeholder="Личные достижения">
      </div>

      <div class="input-container">
        <textarea required v-model="motivationLetter" type="text" class="form-control" id="motivationLetter" placeholder="Мотивационное письмо"></textarea>
      </div>

      <v-card-actions class="justify-content-around">
        <v-btn
            @click="closeForm"
             color="error" variant="tonal"  rounded="5" >Отменить</v-btn>
        <v-btn type="submit"  color="success" variant="tonal"  rounded="5" append-icon="mdi: mdi-arrow-right">Подтвердить</v-btn>
      </v-card-actions>
    </form>
  </v-card>
</template>

<script>
import axios from 'axios'

export default {
  props: {
    courseName: {
      type: String,
      required: true
    }
  },
  data(){
    return{
      curatorFullName: '',
      subdivisionName: '',
      currentJobTitle: '',
      workExperience: '',
      personalAchievements: '',
      motivationLetter: '',
    }
  },
  methods: {
    async submitRequest(){
      try {
        const response = await axios.post('/course-request', {
          curatorFullName: this.curatorFullName,
              subdivisionName: this.subdivisionName,
              currentJobTitle: this.currentJobTitle,
              workExperience: this.workExperience,
              personalAchievements: this.personalAchievements,
              motivationLetter: this.motivationLetter,
        });
        if (response.status === 200) {
          console.log('Success!');
          this.$emit('close-dialog')
        }
      } catch (error){
        this.handleError(error)
        console.log('Oops!');
        this.$emit('close-dialog')
      }
    },
    handleError(error) {
      if (error.response) {
        if (error.response.status === 401) {
          this.errorMessage = "Не найдено или введены некорректные данные";
        } else if (error.response.status === 500) {
          this.errorMessage = "Ошибка сервера";
        }
      } else {
        this.errorMessage = "Произошла ошибка при отправке запроса";
      }
    },
    closeForm(){
      this.$emit('close-dialog');
    }
  }
}
</script>
<!-- Всплывающее окно наследует цвет v-card, интересно -->
<style scoped>
.form-class{
  align-self: center;
}

.input-container {
  margin-bottom: 1em;
}
textarea {
  resize: none;
  width: 100%;
  height: 5em;
}
</style>
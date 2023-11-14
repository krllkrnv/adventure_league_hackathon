<template>
  <v-card rounded="5" variant="text" class="form-class pa-5">
    <v-card-title class="text-center">Добавление пользователя</v-card-title>
    <br>
    <form @submit.prevent="submitRequest">
      <div class="input-container">
        <input required v-model="curatorFullName" type="text" class="form-control" id="curatorFullName" placeholder="Фамилия Имя Отчество">
      </div>

      <div class="input-container">
        <input required v-model="subdivisionName" type="text" class="form-control" id="subdivisionName" placeholder="Наименование подразделения">
      </div>

      <div class="input-container">
        <select
            v-model="selectedOption" @change="toggleAdditionalInput"
            class="form-select" aria-label="Default select example">
          <option selected value="">Выберите категорию</option>
          <option value="1">Член приемной комиссии</option>
          <option value="2">Преподаватель</option>
          <option value="3">Куратор</option>
        </select>
      </div>
      <div v-if="showAdditionalInput" class="input-container">
        <input type="text" class="form-control" placeholder="Группа">
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
  data(){
    return{
      curatorFullName: '',
      subdivisionName: '',
      currentJobTitle: '',
      workExperience: '',
      personalAchievements: '',
      motivationLetter: '',
      selectedOption: '',
      showAdditionalInput: false
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
    },
    toggleAdditionalInput() {
      this.showAdditionalInput = this.selectedOption === '3';
    },
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
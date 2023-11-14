<template>
  <h1 class="blue-scheme ml-2 mb-4">
    Расписание
  </h1>
  <div class="main-container">
    <div 
      v-for="(day, index) in timetable" 
      class="timetable-item" 
      :key="day.day"
    >
      <div class="timetable-item__title">
        {{ day.day }}
      </div>
      <div class="timetable-item__body">
        <div 
          v-for="(lesson, index) in day.lessons" 
          class="timetable-item__body__item" 
          :key="day + 'lesson_' + index"
        >
          <div class="timestamp">
            {{ lesson.timestamp }}
          </div>
          <div class="item-info">
            <div class="name-course">
              {{ lesson.nameCourse }}
            </div>
            <div class="more-info">
              <v-icon icon="mdi-bookshelf"/>
              {{ lesson.typeLesson }}
            </div>
            <div class="more-info">
              <v-icon icon="mdi-account-school-outline"/>
              {{ lesson.teacher }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import router from '../router/router.js'
export default {
  data() {
    return {
      timetable: [
        {
          day: 'Понедельник',
          lessons: [
            {
              nameCourse: 'Экономика',
              timestamp: '9.50',
              typeLesson: 'Лекция',
              teacher: 'Бабенков Олег Михайлович'
            },
            {
              nameCourse: 'Маркетинг',
              timestamp: '11.40',
              typeLesson: 'Практика',
              teacher: 'Клионский Дмитрий Михайлович'
            },
            {
              nameCourse: 'Программирование',
              timestamp: '13.40',
              typeLesson: 'Лекция',
              teacher: 'Иванов Дмитрий Михайлович'
            },
            {
              nameCourse: 'Администрирование',
              timestamp: '15.30',
              typeLesson: 'Лекция',
              teacher: 'Клионский Дмитрий Михайлович'
            }
          ]
        },
        {
          day: 'Вторник',
          lessons: [
            {
              nameCourse: 'Программирование',
              timestamp: '9.50',
              typeLesson: 'Практика',
              teacher: 'Клионский Дмитрий Михайлович'
            },
            {
              nameCourse: 'Маркетинг',
              timestamp: '11.40',
              typeLesson: 'Практика',
              teacher: 'Клионский Дмитрий Михайлович'
            },
          ]
        }
      ]
    }
  },
  mounted() {
    //this.data.push(this.$route.params.data);
  },
  methods: {

  },
  computed: {
    
  }
}
</script>

<style lang="scss" scoped>

.main-container {
  background-color: #F3F1F1;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.blue-scheme{
  color: #020B3B;
}

.timetable-item__title {
  color: #020B3B;
  font-size: 1.75rem;
  font-style: normal;
  font-weight: 200;
  line-height: normal;
}

.timetable-item__body {
  background: #d3e0f5;
  border-radius: 1.5rem;
  margin-top: 1rem;
  margin-bottom: 1rem;
  padding: 1rem;
  width: 35rem;
  display: flex;
  flex-direction: column;

  .timestamp {
    color: #020B3B;
    width: 9rem;
    font-size: 3.75rem;
    font-style: italic;
    font-weight: 200;
    line-height: normal;
  }

  .timetable-item__body__item {
    display: inline-flex;
    padding: 0.25rem;
    align-items: center;
  }

  .item-info {
    display: flex;
    flex-direction: column;
  }

  .name-course {
    color: #020B3B;
    font-size: 1.5rem;
    font-style: normal;
    font-weight: 200;
    line-height: normal;
  }

  .more-info{
    font-size: 0.75rem;
    font-style: normal;
    font-weight: 200;
    line-height: normal;
  }
}

</style>
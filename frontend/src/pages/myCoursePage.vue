<template>
	<div class="main-container">
		<h1 class="blue-scheme ml-2 mb-4">
			Экономика
		</h1>
		<h2 class="blue-scheme ml-4 border-bottom">
			Учебные материалы
		</h2>
		<div v-for="(lesson, index) in lessons" class="lesson-item">
			<h3 
				:key="'lesson_material_' + index"
				@click="flagOpenInfoMatrial[index] = !flagOpenInfoMatrial[index]" 
				class="lesson-name ml-4"
			>
				<v-icon
					icon="mdi-folder-outline"
					size="small"
					class="mr-3"
				/>
				{{ lesson.lessonName }}
			</h3>
			<div v-if="flagOpenInfoMatrial[index] === true" class="lesson-body">
				<video controls width="600" height="300">
					<source src="" type="" />
				</video>
				<h5 
					class="d-flex justify-content-center blue-scheme" 
					@click="onSaveSummary(lesson.id)"
				>
					Здесь можно скачать конспект
				</h5>
			</div>
		</div>

		<h2 class="blue-scheme ml-4 border-bottom">
			Домашние задания
		</h2>
		<div v-for="(lesson, index) in lessons" class="lesson-item">
			<h3 
				:key="'lesson_task_' + index" 
				@click="flagOpenInfoTasks[index] = !flagOpenInfoTasks[index]" 
				class="lesson-name ml-4"
			>
				<v-icon
					icon="mdi-lead-pencil"
					size="small"
					class="mr-3"
				/>
				{{ lesson.lessonName }}
			</h3>
			<div v-if="flagOpenInfoTasks[index] === true" class="lesson-body">
				<p>{{ lesson.task }}</p>
				<v-file-input 
					v-model="taskAnswers[index]"
					label="Прикрепить файл" 
					variant="outlined" 
					accept=".jpg, .jpeg, .png" 
				/>
				<v-btn 
					rounded="5" 
					append-icon="mdi: mdi-arrow-right" 
					@click="submitTask(lesson.id, index)"
				>
					Отправить
				</v-btn>
			</div>
		</div>
	</div>
</template>

<script>
import router from '../router/router.js'
import { mapState } from 'vuex'
export default {
	data() {
		return {
			courseId: -1,
			courseName: 'Экономика',
			lessons: [
				{
					id: 0,
					lessonName: 'Введение',
					video: 'тут будет видео',
					task: 'Написать сочинение на тему "Как я провел лето"',
					taskStatus: false
				},
				{
					id: 1,
					lessonName: 'Анализ рынка',
					video: 'тут будет видео',
					task: 'Написать сочинение на тему "Кем я хочу стать, когда вырасту"',
					taskStatus: true
				}
			],
			flagOpenInfoMatrial: [],
			flagOpenInfoTasks: [],
			taskAnswers: []
		}
	},
	mounted() {
		//this.data.push(this.$route.params.data);
		for (let lesson in this.lessons) {
			this.flagOpenInfoTasks.push(true);
			this.flagOpenInfoMatrial.push(true);
		}
	},
	methods: {
		async onSaveSummary(lessonId) {
			try {
			const response = await axios.get('/getSummary', {
				userId: this.userId,
				courseId: this.courseId,
				lessonId: lessonId
			});
			if (response.status === 200) {
				//сохранение данных response.data
			}
			} catch (error) {
				this.handleError(error);
			}
		},
		async submitTask(lessonId, index) {
			console.log(this.taskAnswers[index]);
			try {
				const response = await axios.post('/submitTask', {
					userId: this.userId,
					courseId: this.courseId,
					lessonId: lessonId,
					file: this.taskAnswers[index]
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
  background-color: #F3F1F1;
}

.blue-scheme{
	color: #020B3B;
}

.lesson-name {
	cursor: pointer;
	display: flex;
	align-items: center;
	justify-content: start;
}

.lesson-body{
	cursor: pointer;
	p {
		text-align: start;
		margin: 1rem 3rem
	}
	h5:hover {
		text-decoration: underline;
	}
	video {
		margin: 2.5rem auto;
		display: block;
	}
	.v-file-input {
		margin: 2rem 0 0.25rem 5rem ;
		width: 30rem;
	}
	.v-btn {
		margin: 0 0 2rem 7rem;
		text-align: start;
	}
}

</style>

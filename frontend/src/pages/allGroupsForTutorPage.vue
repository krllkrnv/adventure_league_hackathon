<template>
  <not-allowed class="allowed-class" v-if="this.$store.getters.GET_USER.role !== 'Куратор'"></not-allowed>
  <div v-else>
	<h1 class="blue-scheme ml-2 my-2">
		Мое кураторство
	</h1>
  <div class="main-container">
		<v-card
			elevation="5"
      		v-for="(group, index) in groups"
      		:key="'group_' + index"
     	>
      <v-card-title>
        {{ group.number }}
      </v-card-title>
      <v-card-text>
        <h5>Количество студентов в группе: <span style="color: #5A5A5A;">{{ group.countOfStudent }}</span></h5>
      </v-card-text>
      <v-card-actions class="justify-content-around">
          <v-btn @click.stop="transitionToGroupPage(group.id)" color="#5A5A5A" variant="outlined" class="ma-2 pa-2 mr-auto" rounded="5" append-icon="mdi: mdi-arrow-right">Перейти на страницу группы</v-btn>
        </v-card-actions>
      </v-card>
	</div>
  </div>
</template>

<script>
import notAllowed from "../components/UI/notAllowed.vue";
import router from '../router/router.js'
import { mapState } from 'vuex'

export default {
  components: {
    notAllowed
  },
	data() {
		return {
			groups: [
				{
		          id: 0,
		          number: '0375',
		          countOfStudent: 4
		        },
		        {
		          id: 1,
		          number: '0371',
		          countOfStudent: 7
		        }
			]
		}
	},
	methods: {
		transitionToGroupPage(groupId) {
			router.push('/groupForTutor');
		}
	},
  mounted() {
    if (this.$store.getters.GET_USER.role !== 'Куратор') {
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
  font-size: 1.6rem;
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

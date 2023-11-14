import {createStore} from 'vuex'
import axios from 'axios'
export default createStore({
    state: {
        user: {
            userId: 0,
            firstname: '',
            lastname: '',
            patronymic: '',
            login: '',
            email: '',
            phoneNumber: '',
            telegram: '',
            role: ''
        }
    },
    getters: {
        GET_USER: state => {
            return state.user
        }
    },
    mutations: {
        SET_USER: (state, payload) => {
            state.user = payload
        }
    },
    actions: {
        DISPATCH_SET_USER: (context, payload) => {
            context.commit('SET_USER', payload)
        }
    }
})

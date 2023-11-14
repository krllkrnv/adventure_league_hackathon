import { createApp } from 'vue'
import App from './App.vue'
import './axios.js'
import 'vuetify/dist/vuetify.min.css' // Ensure you are using css-loader
import store from './storage/storage.js'
import router from "./router/router.js";
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap"
import '@mdi/font/css/materialdesignicons.css'


const vuetify = createVuetify({
    components,
    directives,
    theme: {
        themes: {
            light: {
                primary: '#3f51b5',
                secondary: '#b0bec5',
                accent: '#8c9eff',
                error: '#ca09d0',
            },
        },
    },
})



createApp(App)
    .use(store)
    .use(vuetify)
    .use(router)
    .mount('#app')

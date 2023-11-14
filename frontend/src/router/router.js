import {createRouter, createWebHistory} from "vue-router";
import mainPage from "../pages/mainPage.vue";
import authPage from "../pages/authPage.vue";
import userPage from "../pages/userPage.vue";
import coursePage from "../pages/coursePage.vue";
import myCoursePage from "../pages/myCoursePage.vue";
import newsPage from "../pages/newsPage.vue";
import newItemPage from "../pages/newItemPage.vue";
import myAllCoursesPage from "../pages/myAllCoursesPage.vue";
import requestForAdmissionCommitteePage from "../pages/requestForAdmissionCommitteePage.vue";
import allCoursesPage from "../pages/allCoursesPage.vue";
import timeTablePage from "../pages/timeTablePage.vue";
import adminPage from "../pages/adminPage.vue";
import groupForTutorPage from "../pages/groupForTutorPage.vue";
import allGroupsForTutorPage from "../pages/allGroupsForTutorPage.vue";

const routes = [
    {
        path: '/',
        component: mainPage
    },
    {
        path: '/login',
        name: 'login',
        component: authPage
    },
    {
        path: '/user',
        name: 'user',
        component: userPage
    },
    {
        path: '/course:data',
        name: 'course',
        component: coursePage,
        props: true
    },
    {
        path: '/myCourse:data',
        name: 'myCourse',
        component: myCoursePage,
        props: true
    },
    {
        path: '/myAllCourses',
        name: 'myAllCourses',
        component: myAllCoursesPage,
        props: true
    },
    {
        path: '/news',
        name: 'news',
        component: newsPage
    },
    {
        path: '/news:data',
        name: 'course',
        component: newItemPage
    },
    {
        path: '/requestForAdmCom',
        name: 'requestForAdmissionCommitteePage',
        component: requestForAdmissionCommitteePage
    },
    {
        path: '/courses',
        name: 'courses',
        component: allCoursesPage
    },
    {
        path: '/timetable',
        name: 'timetable',
        component: timeTablePage
    },
    {
        path: '/admin',
        name: 'admin',
        component: adminPage
    },
    {
        path: '/groupForTutor',
        name: 'groupForTutor',
        component: groupForTutorPage
    },
    {
        path: '/allGroupsForTutor',
        name: 'allGroupsForTutor',
        component: allGroupsForTutorPage
    }

]

const router = createRouter({
    routes,
    history: createWebHistory()
})

export default router;
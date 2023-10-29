import {createWebHistory, createRouter} from "vue-router";

const routes = [
    {
        path: "/login",
        component: () => import('../components/LoginView.vue'),
    },
    {
        path: "/register",
        component: () => import('../components/RegisterView.vue'),
    },
    {
        path: "/",
        component: () => import('../components/WelcomeView.vue'),
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes: routes,
    linkActiveClass: 'active'
})


export default router;
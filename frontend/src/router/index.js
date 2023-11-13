import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/HomeView.vue'),
        },

        // member
        {
            path: '/login',
            name: 'login',
            component: () => import('../views/LoginView.vue'),
        },
        {
            path: '/signup',
            name: 'signup',
            component: () => import('../views/SignUpView.vue'),
        },
        {
            path: '/info',
            name: 'userinfo',
            component: () => import('../views/UserInfoView.vue'),
        },

        // TODO: notice view 만들기
        // notice
        {
            path: '/notice',
            name: 'notice',
            component: () => import('../views/HomeView.vue'),
        },
    ],
});

export default router;

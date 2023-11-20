import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/HomeView.vue'),
        },

        // attraction
        {
            path: '/attraction',
            name: 'attraction',
            component: () => import('@/views/AttractionView.vue'),
        },

        // member
        {
            path: '/member',
            name: 'member',
            component: () => import('@/views/TheMemberView.vue'),
            children: [
                {
                    path: 'register',
                    name: 'user-register',
                    component: () => import('@/components/member/Register.vue'),
                },
                {
                    path: 'login',
                    name: 'user-login',
                    component: () => import('@/components/member/Login.vue'),
                },
                {
                    path: '/info',
                    name: 'userinfo',
                    component: () => import('../views/UserInfoView.vue'),
                },
            ],
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

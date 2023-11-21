import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/HomeView.vue'),
        },
        {
            path: "/register",
            name: 'register',
            component: () => import("@/views/Register.vue"),
        },
        {
            path: "/login",
            name: 'login',
            component: () => import("@/views/Login.vue"),
        },
        {
            path: "/board",
            name: 'board',
            component: () => import("@/views/BoardView.vue"),
        },

        // 혹시 구조를 바꾸게 될 예비용 주석! 
        // {
        //     path: "/board",
        //     name: 'board',
        //     component: () => import("@/views/board"),
        //     children: [
        //         {
        //             path: 'list',
        //             name: 'board-list',
        //             component: () => import('@/views/board/BoardView.vue'),
        //         },
                
        //     ]
        // },

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

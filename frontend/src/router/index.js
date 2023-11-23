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
            path: '/register',
            name: 'register',
            component: () => import('@/views/Register.vue'),
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/LoginView.vue'),
        },
        {
            path: '/board',
            name: 'board',
            component: () => import('@/views/BoardView.vue'),
            // component: () => import('@/views/BoardView.vue'),
        },
        {
            path: '/board-detail/:postId',
            name: 'board-detail',
            component: () => import('@/views/BoardDetail.vue'),
        },
        {
            path: '/board-write',
            name: 'board-write',
            component: () => import('@/views/BoardWrite.vue'),
        },
        {
            path: '/board-modify/:postId',
            name: 'board-modify',
            component: () => import('@/views/BoardModify.vue'),
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

        // attraction
        {
            path: '/attraction',
            name: 'attraction',
            component: () => import('@/views/AttractionView.vue'),
        },

        // TODO: notice view 만들기
        // notice
        {
            path: '/notice',
            name: 'notice',
            component: () => import('../views/HomeView.vue'),
        },

        // plan
        {
            path: '/plan',
            name: 'plan',
            component: () => import('../views/PlanView.vue'),
        },

        // hot place
        {
            path: '/hotplace',
            name: 'hotplace',
            component: () => import('../views/HotPlaceView.vue'),
        },
    ],
});

export default router;

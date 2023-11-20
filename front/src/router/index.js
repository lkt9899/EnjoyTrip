import { createRouter, createWebHistory } from 'vue-router';
import TheMainView from '../views/TheMainView.vue'


const routes = [
    { path: '/', name:'main', component: TheMainView },
    { path: '/main', name:'main',component: TheMainView }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

export default router;

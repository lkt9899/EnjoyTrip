import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

// bootstrap
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import 'bootstrap-vue-next/dist/bootstrap-vue-next.css';

const app = createApp(App);

// router & pinia
app.use(createPinia());
app.use(router);

app.mount('#app');

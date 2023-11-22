import { createApp } from 'vue';
import { createPinia } from 'pinia';
import { Quasar } from 'quasar';
import quasarLang from 'quasar/lang/ko-KR';

// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css';

// Import Quasar css
import 'quasar/src/css/index.sass';

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
app.use(Quasar, {
    plugins: {}, // import Quasar plugins and add here
    lang: quasarLang,
});

app.mount('#app');

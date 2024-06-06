import { createApp } from 'vue';
import App from './app.vue';
import router from './router';
import VueCookies from 'vue-cookies';
import store from './store'; 

const app = createApp(App); 
app.use(VueCookies); 
app.use(router); 
app.use(store);
app.mount('#app');
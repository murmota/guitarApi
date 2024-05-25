import { createRouter, createWebHistory } from 'vue-router';
import Registration from './components/registration.vue';
import Login from './components/login.vue';
import Basket from'./components/basket.vue';
import Product from './components/product.vue';
import Home from './components/home.vue';
import Profile from './components/Profile.vue';

export default createRouter({ 
  history: createWebHistory(), 
  routes: [ 
    { path: '/registration', component: Registration, alias: '/' }, 
    { path: '/login', component: Login },
    { path: '/profile', component: Profile},
    { path: '/basket', component: Basket },
    { path: '/home', component: Home },
    { path: '/product/:id', component: Product } 
  ], 
});
import { createRouter, createWebHistory } from 'vue-router';
import Registration from './components/registration.vue';
import Login from './components/login.vue';
import Basket from './components/basket.vue';
import Product from './components/product.vue';
import Home from './components/home.vue';
import Profile from './components/Profile.vue';
import Order from './components/order.vue';
import Admin from './components/Admin.vue';
import store from './store';

const routes = [
  { path: '/registration', component: Registration, alias: '/' },
  { path: '/login', component: Login },
  { path: '/profile', component: Profile },
  { path: '/basket', component: Basket },
  { path: '/home', component: Home },
  { path: '/product/:id', component: Product },
  { path: '/order/:orderId', component: Order },
  { path: '/admin', component: Admin, meta: { requiresAuth: true, role: 'ROLE_ADMIN' } }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

router.beforeEach((to, from, next) => {
  const loggedIn = store.getters.isLoggedIn;
  const userRoles = store.getters.userRoles;

  if (to.matched.some(record => record.meta.requiresAuth)) {
    if (!loggedIn) {
      next('/login');
    } else if (to.matched.some(record => record.meta.role)) {
      if (!userRoles.includes(to.meta.role)) {
        next('/login');
      } else {
        next();
      }
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;

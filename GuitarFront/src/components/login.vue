<template>
  <div>
    <h2>Login Form</h2>
    <form @submit.prevent="loginUser">
      <input type="userName" v-model="userName" placeholder="user name" required>
      <input type="password" v-model="password" placeholder="Password" required>
      <button type="submit">Login</button>
      <router-link to="/registration">Create account</router-link>
    </form> 
  </div>
</template>

<script>
import Api from '@/api.js';

export default {
  data() {
    return {
      userName: '',
      password: '',
      jwt: null
    };
  },
  methods: {
    loginUser() {
      const loginData = {
        userName: this.userName,
        password: this.password
      };

      Api.post('/secured/signin', loginData)
        .then(response => {
          this.jwt = response.data;
          this.$cookies.remove('jwt');
          this.$cookies.set('jwt', this.jwt, '1h');
          
          const tokenParts = this.jwt.split('.');
          const tokenPayload = JSON.parse(atob(tokenParts[1]));

          this.$store.dispatch('login', { token: this.jwt, roles: tokenPayload.roles });

          this.checkUserRole(tokenPayload.roles);
        })
        .catch(error => {
          console.error('Login failed:', error.data);
        });
    },
    checkUserRole(roles) {
      if (roles.includes('ROLE_ADMIN')) {
        this.$router.push('/admin');
      } else {
        this.$router.push('/home');
      }
    }
  }
};
</script>

<style scoped>
</style>

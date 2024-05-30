<template>
    <div>
      <h2>Login Form</h2>
      <form @submit.prevent="loginUser">
        <input type="userName" v-model="userName" placeholder="user name" required>
        <input type="password" v-model="password" placeholder="Password" required>
        <button type="submit"   >Login</button>
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
      }
      Api.post('/secured/signin', loginData)
        .then(response => { 
          this.jwt = response.data; 
              this.$cookies.remove('jwt'); 
              this.$cookies.set('jwt', this.jwt, '1h');
              window.location.href='/home'
              // console.log(document.cookie);
        })
        .catch(error => {
          // Обработка ошибок
          console.error('Login failed:', error.response.data);

        });
        
      }
      
    }
  }
  </script>
  
  <style scoped>
  /* Ваши стили здесь */
  </style>
  
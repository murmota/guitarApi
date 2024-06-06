<template>
    <div>
<<<<<<< HEAD
      <h2>Registration Form</h2>
      <form @submit.prevent="signupAdmin">
        <input type="text" v-model="userName" placeholder="Username" required>
        <input type="email" v-model="email" placeholder="Email" required>
        <input type="password" v-model="password" placeholder="Password" required>
        <input type="tel" v-model="phoneNumber" placeholder="Phone Number" required>
        <button type="submit" @click="setlogin()">Register</button>
        <router-link to="/login">Login</router-link>
      </form>
    </div>
  </template>
  
  
  <script>
  import Api from '@/api.js';
  export default {
    data() {
      return {
        userName: '',
        email: '',
        password: '',
        phoneNumber: ''
      };
    },
    methods: {
      setlogin(){
          window.location.href='/login';
        },
      
        async signupAdmin() {
        const registerData = {
          userName: this.userName,
          email: this.email,
          password: this.password,
          phoneNumber: this.phoneNumber,
        }
        
        Api.post('/admin/create', registerData)
          .then(response => {
            // Обработка успешного ответа от сервера
            console.log('Registration successful!', response.data);
          })
          .catch(error => {
            // Обработка ошибок
            console.error('Registration failed:', error.response.data);
          });
        
      
        }
      },
  }
  </script>
  
  <style scoped>
  /* Ваши стили здесь */
=======
      <nav>
        <router-link to="/home">Home</router-link>
        <router-link to="/admin">Admin</router-link>
      </nav>
      <h2>Admin Panel</h2>
      <div v-if="!isAdmin">
        <p>You do not have access to this page.</p>
      </div>
      <div v-else>
        <p>Welcome to the Admin Panel!</p>
        <!-- Add admin functionalities here -->
      </div>
    </div>
  </template>
  
  <script>
  import Api from '@/api.js';
  import jwt_decode from 'vue-jwt-decode';
  
  export default {
    data() {
      return {
        isAdmin: false,
      };
    },
    created() {
      this.checkAdmin();
    },
    methods: {
      checkAdmin() {
        const token = this.$cookies.get('jwt');
        if (token) {
          const decodedToken = jwt_decode.decode(token);
          if (decodedToken && decodedToken.role === 'admin') {
            this.isAdmin = true;
          } else {
            this.isAdmin = false;
          }
        } else {
          this.isAdmin = false;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  nav {
    display: flex;
    justify-content: center;
    margin-top: 10px;
  }
>>>>>>> origin/master
  </style>
  
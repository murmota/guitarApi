<template>
    <div>
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
  </style>
  
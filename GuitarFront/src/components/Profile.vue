<template>
    <div>
      <h2>User Profile</h2>
      <div v-if="user">
        <p><strong>Username:</strong> {{ this.user }}</p>
        <p><strong>Email:</strong> {{ this.email }}</p>
        <!-- Другие данные профиля -->
      </div>
      <div v-else>
        <p>No user data available.</p>
      </div>
    </div>
  </template>
  <script>
  import Api from '@/api.js';
  import jwt_decode from 'vue-jwt-decode';
  export default {
    data() {
      return {
        user: null,
        UserId:null,
        email: null
      };
      
    },
    
    mounted() {
      this.fetchUserProfile();
    },
    methods: {
      
      fetchUserProfile() {
        const token = this.$cookies.get('jwt'); 
        const decodedToken = jwt_decode.decode(token);

    if (decodedToken) {
        this.userId = decodedToken.id;
        console.log(decodedToken); // Вывод id пользователя
    } else {
        console.log('Неверный токен');
    }
        Api.get('/auth/get/user/'+this.userId, { 
          
  headers: { 
    'Authorization': 'Bearer ' + this.$cookies.get('jwt') // Получаем JWT токен из cookie 
  } 
})
          .then(response => {
            this.user = response.data.userName;
            this.email = response.data.email;
          })
          .catch(error => {
            console.error('Failed to fetch user profile:', error.response.data);
          });
      }
    }
  }
  </script>
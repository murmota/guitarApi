<template>
  <div>
    <h2>Profile</h2>
    <div v-if="user">
      <p><strong>Username:</strong> {{ user }}</p>
      <p><strong>Email:</strong> {{ email }}</p>
      <button class="b_logout" @click="logOut">Выйти из аккаунта</button>
    </div>
    <div v-else>
      <p>You are unauthorized</p>
      <h5>login to see your profile</h5>
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
      email: null
    };
  },
  created() {
    const token = this.$cookies.get('jwt');
    if (token) {
      const decodedToken = jwt_decode.decode(token);
      if (decodedToken) {
        console.log('Decoded token:', decodedToken);
        const userId = decodedToken.id;
        Api.get('/secured/get/user/' + userId, {
          headers: {
            'Authorization': 'Bearer ' + token
          }
        })
          .then(response => {
            this.user = response.data.userName;
            this.email = response.data.email;
          })
          .catch(error => {
            console.error('Failed to fetch user profile:', error.response.data);
          });
      } else {
        console.log('Invalid token');
      }
    } else {
      console.log('Token not found');
    }
  },
  methods: {
    logOut() {
      this.$cookies.remove('jwt');
      window.location.href = "/login";
    }
  }
};
</script>

<style scoped>
</style>

<template>
  <div>
    <nav>
      <router-link to="/home">Home</router-link>
    </nav>
    <h2>Your Basket</h2>
    <div v-if="basketItems.length === 0">
      <p>Your basket is empty.</p>
    </div>
    <div v-else>
      <div class="basket-item" v-for="(item, index) in basketItems" :key="index">
        <div>
          <h3>{{ item.product.name }}</h3>
          <p>Company: {{ item.product.company }}</p>
          <p>Price: {{ item.product.price }}</p>
          <p>Description: {{ item.product.description }}</p>
        </div>
      </div>
      <button @click="createOrder">Оформить заказ</button>
    </div>
  </div>
</template>

<script>
import Api from '@/api.js';
import jwt_decode from 'vue-jwt-decode';

export default {
  data() {
    return {
      basketItems: [],
      userId: null
    };
  },
  created() {
    this.initializeUserId();
  },
  methods: {
    initializeUserId() {
      const token = this.$cookies.get('jwt');
      if (token) {
        const decodedToken = jwt_decode.decode(token);
        if (decodedToken && decodedToken.id) {
          this.userId = decodedToken.id;
          console.log('User ID:', this.userId);
          this.loadBasketItems();
        } else {
          console.log('Invalid token');
        }
      } else {
        console.log('Token not found');
      }
    },
    async loadBasketItems() {
      try {
        const response = await Api.get(`secured/get/baskets/${this.userId}`);
        this.basketItems = response.data.filter(item => item.product); // Фильтруем элементы без информации о продукте
      } catch (error) {
        console.error('Failed to load basket items:', error);
      }
    },
    async createOrder() {
    const userId = this.userId;
    try {
        const response = await Api.post(`secured/create/order/${userId}`);
        const order = response.data;
        console.log('Order ID:', order.id);
        // this.$router.push( { id: order.id }  );
        this.$router.push(`/order/${order.id}`);
    } catch (error) {
        console.error('Failed to create order:', error);
    }
}

  }
}
</script>

<style scoped>
.basket-item {
  margin-bottom: 20px;
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}
nav {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}
</style>

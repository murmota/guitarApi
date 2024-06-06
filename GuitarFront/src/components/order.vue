<template>
    <div>
      <h2>Order Details</h2>
      <div v-if="!order">
        <p>Loading...</p>
      </div>
      <div v-else>
        <div>
          <h3>Order ID: {{ order.id }}</h3>
          <p>Status: {{ order.status ? 'Completed' : 'Pending' }}</p>
          <h4>Items:</h4>
          <ul>
            <li v-for="(item, index) in order.baskets" :key="index">
              {{ item.product.name }} - {{ item.product.company }} - ${{ item.product.price }}
            </li>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Api from '@/api.js';
  
  export default {
    data() {
      return {
        order: null
      };
    },
    created() {
      this.loadOrder();
    },
    methods: {
      async loadOrder() {
        const orderId = this.$route.params.orderId;
        try {
          const response = await Api.get(`secured/get/order/${orderId}`);
          this.order = response.data;
        } catch (error) {
          console.error('Failed to load order:', error);
        }
      }
    }
  }
  </script>
  
<template>
  <div>
    <p><strong>Name:</strong> {{ product.name }}</p>
    <p><strong>Company:</strong> {{ product.company }}</p>
    <p><strong>Articule:</strong> {{ product.articule }}</p>
    <p><strong>Price:</strong> {{ product.price }}</p>
    <p><strong>Description:</strong> {{ product.description }}</p>
  </div>
</template>

<script>
import Api from '@/api.js';

export default {
  data() {
    return {
      product: {
        name: "",
        company: "",
        articule: "",
        price: "",
        description: ""
      }
    };
  },
  created() {
    const productId = this.$route.params.id;
    this.getProductById(productId);
  },
  methods: {
    getProductById(id) {
      try {
        Api.get('/get/product/' + id, {
          headers: {
            'Authorization': 'Bearer ' + this.$cookies.get('jwt') 
          }
        })
        .then(response => {
          this.product = response.data;
        });
      } catch (error) {
        console.error("There was an error fetching the product:", error);
      }
    }
  }
};
</script>

<style>
</style>

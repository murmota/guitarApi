<template>
  <div>
    <!-- Header -->
    <header>
      <h1>Welcome to our store!</h1>
      <nav>
        <router-link to="/login">Login</router-link>
        <router-link to="/basket">Basket</router-link>
      </nav>
    </header>
    <!-- Body - Product Cards -->
    <main>
      <div class="product-card" v-for="product in products" :key="product.id" @click="goToProduct(product.id)">
        <h3>{{ product.name }}</h3>
        <p>{{ product.price }}</p>
        <button @click.stop="addToBasket(product)">Add to Basket</button>
      </div>
    </main>

    <!-- Footer -->
    <footer>
      <p>&copy; 2024 MyStore. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
  import Api from '@/api.js';

export default {
  data() {
    return {
      products: []
    };
  },
  mounted() {
    this.fetchProducts();
  },
  methods: {
    goToProduct(productId) {
      this.$router.push(`/product/${productId}`);
    },
    addToBasket(product) {
      this.$root.$emit('add-to-basket', product);
    },
     fetchProducts() {
      try {
        // const token = this.$cookies.get('jwt');
        // const decodedToken = jwt_decode(token);

        // Важно: убедитесь, что у вас правильный URL для вашего бэкенда
       Api.get('/get/products', {
          headers: {
            'Authorization': 'Bearer ' + this.$cookies.get('jwt') 
          }
        })
        .then(response => {this.products = response.data});
        

      } catch (error) {
        console.error("There was an error fetching the products:", error);
      }
    }
  }
};
</script>

<style scoped>
/* Стили для header, main и footer */
header {
  background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;
}

nav {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}

nav a {
  margin: 0 10px;
  color: #fff;
  text-decoration: none;
}

main {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
}

.product-card {
  width: 200px;
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  cursor: pointer;
}

.product-card img {
  width: 100%;
  border-radius: 5px;
}

footer {
  background-color: #333;
  color: #fff;
  text-align: center;
  padding: 20px;
}
</style>

<template>
  <div>
    <!-- Header -->
    <header>
      <h1>Welcome to our store!</h1>
      <nav>
        <router-link to="/login">Login</router-link>
        <router-link to="/basket">Basket</router-link>
        <router-link to="/Profile">Profile</router-link>
      </nav>
    </header>
    <!-- Body - Product Cards -->
    <main>
      <div class="product-card" v-for="product in products" :key="product.id" @click="goToProduct(product.id)">
        <h3>{{ product.name }}</h3>
        <p>{{ product.price }}</p>
        <!-- <div class="quantity-control">
          <button @click.stop="decreaseQuantity(product.id)">-</button>
          <span>{{ quantities[product.id] || 1 }}</span>
          <button @click.stop="increaseQuantity(product.id)">+</button>
        </div> -->
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
import jwt_decode from 'vue-jwt-decode';

export default {
  data() {
    return {
      products: [],
      // quantities: {} // Счетчики для каждого продукта
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
      const token = this.$cookies.get('jwt'); 
      const decodedToken = jwt_decode.decode(token);

      if (decodedToken) {
        this.userId = decodedToken.id;
        Api.post('secured/create/basket', {
          user: {id: this.userId},
          product:{id: product.id}
        })
        .then(response => {
          console.log('Product added to basket:', product.id, this.userId);
        })
        .catch(error => {
          console.error('Error adding product to basket:', error);
        });
      } else {
        console.log('Invalid token');
      }
    },

    fetchProducts() {
      try {
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

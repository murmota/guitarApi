<template>
  <div>
    <h2>Your Basket</h2>
    <div v-if="basketItems.length === 0">
      <p>Your basket is empty.</p>
    </div>
    <div v-else>
      <div class="basket-item" v-for="item in basketItems" :key="item.id">
        <img :src="item.image" :alt="item.name">
        <div>
          <h3>{{ item.name }}</h3>
          <p>Price: {{ item.price }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      basketItems: [] // Здесь будут данные о товарах в корзине
    };
  },
  created() {
    // Здесь можно добавить логику для загрузки данных о товарах в корзине
    // Например, загрузка данных из localStorage или из API
    this.loadBasketItems();
  },
  methods: {
    loadBasketItems() {
      // В реальном приложении эти данные обычно загружаются из localStorage или из API
      // Здесь просто пример статических данных
      this.basketItems = [
        { id: 1, name: 'Product 1', price: '$10', image: 'product1.jpg' },
        { id: 2, name: 'Product 2', price: '$20', image: 'product2.jpg' },
        // Добавьте свои товары, добавленные в корзину, здесь
      ];
    }
  }
}
</script>

<style scoped>
/* Стили для страницы корзины */
.basket-item {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.basket-item img {
  width: 100px;
  height: 100px;
  margin-right: 20px;
}

.basket-item div {
  flex: 1;
}
</style>

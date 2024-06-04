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
    this.loadBasketItems();

    // Слушаем событие о добавлении товара в корзину
    this.$root.$on('add-to-basket', this.addToBasket);
  },
  destroyed() {
    // Убираем слушателя при уничтожении компонента
    this.$root.$off('add-to-basket', this.addToBasket);
  },
  methods: {
    // ...
    addToBasket(product) {
      this.basketItems.push(product); // Добавляем товар в корзину
    },
    // ...
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

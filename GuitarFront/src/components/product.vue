<template>
    <div>
      <h2>{{ product.name }}</h2>
      <img :src="product.image" :alt="product.name">
      <p>Price: {{ product.price }}</p>
      <p>Description: {{ product.description }}</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        product: {} // Здесь будут данные о выбранном товаре
      };
    },
    created() {
      // Здесь можно добавить логику для загрузки данных о товаре
      const productId = this.$route.params.id;
      this.product = this.getProductById(productId); // Функция для загрузки товара по его id
    },
    methods: {
      getProductById(id) {
        // В реальном приложении эти данные обычно загружаются из API или базы данных
        // Здесь просто пример статических данных
        return {
          id: id,
          name: 'Product ' + id,
          price: '$' + (10 * id),
          image: 'product' + id + '.jpg',
          description: 'This is a description for Product ' + id
        };
      }
    }
  }
  </script>
  
  <style>
  /* Стили для страницы товара */
  </style>
  
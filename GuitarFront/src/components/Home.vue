<script>
export default {
  data() {
    return {
      products: [
        {
          id: 1,
          name: 'Product 1',
          description: 'Description of Product 1',
          price: '$19.99',
          image: 'https://via.placeholder.com/300'
        },
        {
          id: 2,
          name: 'Product 2',
          description: 'Description of Product 2',
          price: '$29.99',
          image: 'https://via.placeholder.com/300'
        },
        // Добавьте еще товаров при необходимости
      ]
    }
  }
}
</script>
<template>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=K2D:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
<header class="header">
    <div class="navigationHeader">
        <h1>dsicount</h1>
        <h1>shops</h1>
        <h1>delivery</h1>
        <h1>sellary</h1>
        <h1>vacancies</h1>
    </div>
</header>
</head>
<body class="bodyClass">
    <div id="carouselExampleControls" class="carousel" data-bs-ride="carousel">
        <div class="carousel-inner">

          <div class="carousel-itemactive">

            <div class="card1">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name 1</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <button class="btn btn-primary">Add to Cart</button>
              </div>    
            </div>

            <div class="card2">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name 1</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <button class="btn btn-primary">Add to Cart</button>
              </div>    
            </div>

            <div class="card3">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name 1</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <button class="btn btn-primary">Add to Cart</button>
              </div> 

            </div>
            <div class="card4">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name 1</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <button class="btn btn-primary">Add to Cart</button>
              </div>    
            </div>

            <div class="card5">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name 1</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <button class="btn btn-primary">Add to Cart</button>
              </div>    
            </div>

          </div>
          <!-- Добавьте еще карточки с товарами, повторяя блок выше -->
        </div >
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    <!-- <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card">
              <img src="https://via.placeholder.com/300" class="card-img-top" alt="Product Image">
              <div class="card-body">
                <h5 class="card-title">Product Name</h5>
                <p class="card-text">Description of the product goes here.</p>
                <p class="card-text">$19.99</p>
                <a href="#" class="btn btn-primary">Add to Cart</a>
              </div>
            </div>
          </div>
          
           Добавьте еще карточки с товарами, повторяя блок выше 
        </div>
      </div> -->
</body>
<footer class="footer">
<div class="navigationFooter">
    <div><h4>Company</h4>
        <h5>about</h5>
        <h5>contacts</h5>
        <h5>careers</h5>
        <h5>news</h5>
    </div>
    <div><h4>Care product</h4>
        <h5>cleaner</h5>
        <h5>microfiber</h5>
        <h5>oils</h5>
    </div>
    <div><h4>Effects</h4>
        <h5>pedals</h5>
        <h5>processor</h5>
        <h5>combo amplifier</h5>
    </div>
    <div><h4>Accessories</h4>
        <h5>pick</h5>
        <h5>tuner</h5>
        <h5>capo</h5>
        <h5>metronome</h5>
    </div>
</div>
<div class="end">
    <h8>© 2024 GFL.</h8>
</div>

</footer>
</template>
<style scoped>
.carousel-control-prev-icon,
.carousel-control-next-icon {
    background-color: rgb(68, 67, 67); /* Устанавливаем желаемый цвет фона */
    border-radius: 50%; /* Делаем иконки круглыми */
    width: 40px; /* Устанавливаем ширину */
    height: 40px; /* Устанавливаем высоту */
    padding: 20px; /* Отступ вокруг иконки */
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}
.carousel-itemactive{
  display: flex;
  justify-content:center;
  column-count: 2; /* Указываем количество колонок */
  column-gap: 10px; /* Расстояние между колонками */
}
.carousel-inner{
  width: 100%;
  margin-top: 3%;
}
.navigationHeader{
    color: #FFFFFF;
    opacity: 0.8;
    display: flex;
    justify-content:center; /* Равномерное распределение между элементами */
    font-family: "K2D", sans-serif;
    font-style: normal;
    gap: 150px;
    font-size: 10px;
}
.header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    background-color: #191919;
}
.footer {
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    background-color: #191919;
}
.navigationFooter{
    color: #FFFFFF;
    opacity: 0.8;
    display: flex;
    justify-content:center; /* Равномерное распределение между элементами */
    column-count: 4; /* Указываем количество колонок */
    column-gap: 190px; /* Расстояние между колонками */
    font-family: "K2D", sans-serif;
    font-weight: 500;
    font-style: normal;
}
.navigationFooter div {
    margin-bottom: 0; /* Сначала убедитесь, что отступы сброшены */
    line-height: 0.1; /* Уменьшение высоты строки */
}
.end{
    color: #FFFFFF;
    opacity: 0.8;
    display: flex;
    justify-content:center;
    font-family: "K2D", sans-serif;
    font-weight: 100;
    font-style: nor1mal;
}

</style>
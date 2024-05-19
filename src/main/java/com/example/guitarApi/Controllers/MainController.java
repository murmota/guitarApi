package com.example.guitarApi.Controllers;
import com.example.guitarApi.dal.DataAccessLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/unauthorized")
public class MainController {
        private final DataAccessLayer dataAccessLayer;
        @Autowired
        public MainController(DataAccessLayer dataAccessLayer) {
            this.dataAccessLayer = dataAccessLayer;
        }
    @GetMapping("/hello")
    public void hello(){
        log.info("Gracias Senior Pumba");
    }
    @GetMapping("/user")
    public void user(){
        log.info("Gracias Senior user");
    }
    @GetMapping("/admin")
    public void admin(){
        log.info("Gracias Senior admin");
    }
    @GetMapping("/get/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getProductById(id));
    }
    @GetMapping("/get/products")
    public ResponseEntity getProducts(){
        return ResponseEntity.ok(dataAccessLayer.getProducts());
    }

    @GetMapping("/get/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(dataAccessLayer.getUsers());
    }
    @GetMapping("/get/basket/{id}")
    public ResponseEntity getBasketById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getBasketById(id));
    }
    @GetMapping("/get/baskets")
    public ResponseEntity getBaskets(){
        return ResponseEntity.ok(dataAccessLayer.getBaskets());
    }
    @GetMapping("/get/discount/{id}")
    public ResponseEntity getDiscountById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getDiscountById(id));
    }
    @GetMapping("/get/discounts")
    public ResponseEntity getDiscounts(){
        return ResponseEntity.ok(dataAccessLayer.getDiscounts());
    }
    @GetMapping("/get/order/{id}")
    public ResponseEntity getOrderById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getOrderById(id));
    }
    @GetMapping("/get/orders")
    public ResponseEntity getOrders(){
        return ResponseEntity.ok(dataAccessLayer.getOrders());
    }
    @GetMapping("/get/point/{id}")
    public ResponseEntity getPointById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getPointById(id));
    }
    @GetMapping("/get/points")
    public ResponseEntity getPoints(){
        return ResponseEntity.ok(dataAccessLayer.getPoints());
    }
    @GetMapping("/get/review/{id}")
    public ResponseEntity getReviewById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getReviewById(id));
    }
    @GetMapping("/get/reviews")
    public ResponseEntity getReviews(){
        return ResponseEntity.ok(dataAccessLayer.getReviews());
    }
}
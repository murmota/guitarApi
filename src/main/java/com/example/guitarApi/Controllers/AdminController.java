package com.example.guitarApi.Controllers;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/admin")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") long id){
        dataAccessLayer.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }
    @PutMapping("/update/product/{id}")
    public ResponseEntity updateProductById(@PathVariable("id") long id, @RequestBody Product updatedProduct){
        dataAccessLayer.updateProductById(id, updatedProduct);
        return ResponseEntity.ok("Product updated successfully!");
    }
    @PostMapping("/create/user")
    public ResponseEntity createUser(@RequestBody User user){
        dataAccessLayer.createUser(user);
        return ResponseEntity.ok("User added successfully!");
    }
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long id){
        dataAccessLayer.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
    @PutMapping("/update/user/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User updatedUser){
        dataAccessLayer.updateUser(id, updatedUser);
        return ResponseEntity.ok("User updated successfully!");
    }
    @PostMapping("/create/basket")
    public ResponseEntity createUser(@RequestBody Basket basket){
        dataAccessLayer.createBasket(basket);
        return ResponseEntity.ok("Basket added successfully!");
    }
    @DeleteMapping("/delete/basket/{id}")
    public ResponseEntity deleteBasketById(@PathVariable("id") long id){
        dataAccessLayer.deleteBasketById(id);
        return ResponseEntity.ok("Basket deleted successfully!");
    }
    @PutMapping("/update/basket/{id}")
    public ResponseEntity updateBasketById(@PathVariable("id") long id, @RequestBody Basket updatedBasket){
        dataAccessLayer.updateBasket(id, updatedBasket);
        return ResponseEntity.ok("Basket updated successfully!");
    }

    @DeleteMapping("/delete/discount/{id}")
    public ResponseEntity deleteDiscountById(@PathVariable("id") long id){
        dataAccessLayer.deleteDiscountById(id);
        return ResponseEntity.ok("Discount deleted successfully!");
    }
    @PutMapping("/update/discount/{id}")
    public ResponseEntity updateDiscountById(@PathVariable("id") long id, @RequestBody Discount updatedDiscount){
        dataAccessLayer.updateDiscount(id, updatedDiscount);
        return ResponseEntity.ok("Discount updated successfully!");
    }
    @PostMapping("/create/order")
    public ResponseEntity createOreder(@RequestBody Order order){
        dataAccessLayer.createOrder(order);
        return ResponseEntity.ok("Order added successfully!");
    }
    @DeleteMapping("/delete/order/{id}")
    public ResponseEntity deleteOrderById(@PathVariable("id") long id){
        dataAccessLayer.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }
    @PutMapping("/update/order/{id}")
    public ResponseEntity updateOrderById(@PathVariable("id") long id, @RequestBody Order updatedOrder){
        dataAccessLayer.updateOrder(id, updatedOrder);
        return ResponseEntity.ok("Order updated successfully!");
    }
    @PostMapping("/create/point")
    public ResponseEntity createPoint(@RequestBody Point point){
        dataAccessLayer.createPoint(point);
        return ResponseEntity.ok("Point added successfully!");
    }
    @DeleteMapping("/delete/point/{id}")
    public ResponseEntity deletePointById(@PathVariable("id") long id){
        dataAccessLayer.deletePointById(id);
        return ResponseEntity.ok("Point deleted successfully!");
    }
    @PutMapping("/update/point/{id}")
    public ResponseEntity updatePointById(@PathVariable("id") long id, @RequestBody Point updatedPoint){
        dataAccessLayer.updatePoint(id, updatedPoint);
        return ResponseEntity.ok("Point updated successfully!");
    }
    @PostMapping("/create/review")
    public ResponseEntity createReview(@RequestBody Review review){
        dataAccessLayer.createReview(review);
        return ResponseEntity.ok("Review added successfully!");
    }
    @DeleteMapping("/delete/review/{id}")
    public ResponseEntity deleteReviewById(@PathVariable("id") long id){
        dataAccessLayer.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
    @PutMapping("/update/review/{id}")
    public ResponseEntity updateReviewById(@PathVariable("id") long id, @RequestBody Review updatedReview){
        dataAccessLayer.updateReview(id, updatedReview);
        return ResponseEntity.ok("Review updated successfully!");
    }
}
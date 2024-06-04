package com.example.guitarApi.Controllers;

import com.example.guitarApi.GuitarApiApplication;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.dto.SigninRequest;
import com.example.guitarApi.dto.SignupRequest;
import com.example.guitarApi.models.*;
import com.example.guitarApi.security.JwtCore;
import com.example.guitarApi.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/secured")
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {
    private final UserDetailsServiceImpl userService;
    private final DataAccessLayer dataAccessLayer;
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
    public void someMethod() {
        logger.debug("Debug message");
//        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
    @Autowired
    public SecurityController(UserDetailsServiceImpl userService, DataAccessLayer dataAccessLayer) {
        this.userService = userService;
        this.dataAccessLayer = dataAccessLayer;
    }
    @Autowired
    private JwtCore jwtCore;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        signupRequest.setRoles(Set.of("ROLE_USER"));
        String serviceResult = userService.newUser(signupRequest);
        if (Objects.equals(serviceResult, "Выберите другое имя")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        if (Objects.equals(serviceResult, "Выберите другую почту")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResult);
        }
        return ResponseEntity.ok("Вы успешно зарегистрированы. Теперь можете войти в свой аккаунт.");
    }

    @PostMapping("/signin")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
     @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());
//        String hashedPassword = passwordEncoder.encode(signinRequest.getPassword());       // Сравниваем хешированный пароль из запроса с хешированным паролем пользователя из базы данных
        if (Objects.equals(user, null) || !passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String jwt = jwtCore.generateToken(user);
        GuitarApiApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        log.info("Вход прошёл успешно");
        return ResponseEntity.ok(jwt);
    }
    @DeleteMapping("/delete/baskets/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteBasketsByUserId(@PathVariable("userId") long userId) {
        dataAccessLayer.deleteBasketsByUserId(userId);
        return ResponseEntity.ok("baskets");
    }

    @PostMapping("/create/review")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity createReview(@RequestBody Review review){
        dataAccessLayer.createReview(review);
        return ResponseEntity.ok("Review added successfully!");
    }
    @DeleteMapping("/delete/review/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteReviewById(@PathVariable("id") long id){
        dataAccessLayer.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }
    @PutMapping("/update/review/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateReviewById(@PathVariable("id") long id, @RequestBody Review updatedReview){
        dataAccessLayer.updateReview(id, updatedReview);
        return ResponseEntity.ok("Review updated successfully!");
    }
    @PostMapping("/create/order")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity createOreder(@RequestBody Order order){
        dataAccessLayer.createOrder(order);
        return ResponseEntity.ok("Order added successfully!");
    }
    @DeleteMapping("/delete/order/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity deleteOrderById(@PathVariable("id") long id){
        dataAccessLayer.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }
    @PostMapping("/create/basket")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity createUser(@RequestBody Basket basket){
        dataAccessLayer.createBasket(basket);
        return ResponseEntity.ok("Basket added successfully!");
    }
    @GetMapping("/get/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getUserById(id));
    }
    @GetMapping("/get/baskets/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Basket>> getBasketsByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(dataAccessLayer.getBasketsByUserId(userId));
    }
    @PutMapping("/update/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User updatedUser){
        dataAccessLayer.updateUser(id, updatedUser);
        return ResponseEntity.ok("User updated successfully!");
    }
    @GetMapping("/get/order/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity getOrderById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getOrderById(id));
    }
}

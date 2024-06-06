package com.example.guitarApi.Controllers;

import com.example.guitarApi.GuitarApiApplication;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.dto.SigninRequest;
import com.example.guitarApi.dto.SignupRequest;
import com.example.guitarApi.exception.UnauthorizedException;
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
    private static final Logger errorLogger = LoggerFactory.getLogger("ERROR_LOGGER");

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
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
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
    public ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());
        if (user == null || !passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            logger.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            throw new UnauthorizedException("Ошибка авторизации пользователя " + signinRequest.getUserName());
        }
        String jwt = jwtCore.generateToken(user);
        GuitarApiApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        logger.info("Вход прошёл успешно");
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
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        dataAccessLayer.createReview(review);
        return ResponseEntity.ok("Review added successfully!");
    }

    @DeleteMapping("/delete/review/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteReviewById(@PathVariable("id") long id) {
        dataAccessLayer.deleteReviewById(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }

    @PutMapping("/update/review/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateReviewById(@PathVariable("id") long id, @RequestBody Review updatedReview) {
        dataAccessLayer.updateReview(id, updatedReview);
        return ResponseEntity.ok("Review updated successfully!");
    }

    @PostMapping("/create/order/{userId}")
    public Order createOrder(@PathVariable("userId") long userId) {
        List<Basket> baskets = dataAccessLayer.getBasketsByUserId(userId);
        Order order = new Order();
        for (Basket basket : baskets) {
            basket.setOrder(order);
        }
        order.setBaskets(baskets);
        dataAccessLayer.createOrder(order);
        return order;
    }

    @DeleteMapping("/delete/order/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteOrderById(@PathVariable("id") long id) {
        dataAccessLayer.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }

    @PostMapping("/create/basket")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createUser(@RequestBody Basket basket) {
        dataAccessLayer.createBasket(basket);
        return ResponseEntity.ok("Basket added successfully!");
    }

    @GetMapping("/get/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getUserById(id));
    }

    @GetMapping("/get/baskets/{userId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Basket>> getBasketsByUserId(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(dataAccessLayer.getBasketsByUserId(userId));
    }

    @PutMapping("/update/user/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateUserById(@PathVariable("id") long id, @RequestBody User updatedUser) {
        dataAccessLayer.updateUser(id, updatedUser);
        return ResponseEntity.ok("User updated successfully!");
    }

    @GetMapping("/secured/get/order/{orderId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") long orderId) {
        Order order = dataAccessLayer.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

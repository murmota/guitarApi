package com.example.guitarApi.Controllers;

import com.example.guitarApi.GuitarApiApplication;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.dto.SigninRequest;
import com.example.guitarApi.dto.SignupRequest;
import com.example.guitarApi.security.JwtCore;
import com.example.guitarApi.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class SecurityController {
    private final UserDetailsServiceImpl userService;
    private final DataAccessLayer dataAccessLayer;
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
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
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
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest) {
        UserDetails user = userService.loadUserByUsername(signinRequest.getUserName());
        String hashedPassword = passwordEncoder.encode(signinRequest.getPassword());        // Сравниваем хешированный пароль из запроса с хешированным паролем пользователя из базы данных
        if (Objects.equals(user, null) || !passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            log.info("Ошибка авторизации пользователя " + signinRequest.getUserName());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String jwt = jwtCore.generateToken(user);
        GuitarApiApplication.currentUser = userService.loadUserEntityByUsername(signinRequest.getUserName());
        log.info("Вход прошёл успешно");
        return ResponseEntity.ok(jwt);
    }
    @GetMapping("/get/user/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getUserById(id));
    }
}

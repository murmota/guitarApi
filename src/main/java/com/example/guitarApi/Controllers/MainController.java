package com.example.guitarApi.Controllers;

import com.example.guitarApi.GuitarApiApplication;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.modules.entities.productEntities.Guitars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@CrossOrigin(origins = "http://localhost:6000")
@RequestMapping("/products")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }
    @PostMapping("/new")
    public ResponseEntity<String> newGuitar(@RequestBody Guitars guitars) {
        try {
            dataAccessLayer.newGuitar(guitars);
            return ResponseEntity.ok("Guitar added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add guitar: " + e.getMessage());
        }
    }
}

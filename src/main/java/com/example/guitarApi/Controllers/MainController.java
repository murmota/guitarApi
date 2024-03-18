package com.example.guitarApi.Controllers;
import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.modules.entities.productEntities.UsersPackage.Admin;
import com.example.guitarApi.modules.entities.productEntities.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
public class MainController {
        private final DataAccessLayer dataAccessLayer;
        @Autowired
        public MainController(DataAccessLayer dataAccessLayer) {
            this.dataAccessLayer = dataAccessLayer;
        }
    @PostMapping("/new/product")
    public ResponseEntity<String> newGuitar(@RequestBody Product product) {
        try {
            dataAccessLayer.createProductToDatabase(product);
            return ResponseEntity.ok("Product added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product: " + e.getMessage());
        }
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
    @GetMapping("/get/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getProductById(id));
    }
    @PostMapping("/new/admin")
    public ResponseEntity newAdmin(@RequestBody Admin admin){
        dataAccessLayer.newAdmin(admin);
        return ResponseEntity.ok("Admin added successfully!");
    }
    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity deleteAdminById(@PathVariable("id") long id){
        dataAccessLayer.deleteAdminById(id);
        return ResponseEntity.ok("Admin deleted successfully!");
    }
    @PutMapping("/update/admin/{id}")
    public ResponseEntity updateAdminById(@PathVariable("id") long id, @RequestBody Admin updatedAdmin){
        dataAccessLayer.updateAdmin(id, updatedAdmin);
        return ResponseEntity.ok("Admin updated successfully!");
    }
    @GetMapping("/get/admin/{id}")
    public ResponseEntity getAdminById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getAdminBuId(id));

    }
}

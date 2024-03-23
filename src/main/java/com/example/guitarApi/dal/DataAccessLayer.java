package com.example.guitarApi.dal;
import com.example.guitarApi.modules.entities.productEntities.UsersPackage.Admin;
import com.example.guitarApi.modules.entities.productEntities.UsersPackage.User;
import com.example.guitarApi.modules.entities.productEntities.products.Product;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;
    public void createProductToDatabase(Product newProduct) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newProduct);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteProductById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.remove(product);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateProductById(Long id, Product UpdatedProduct){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setArticul(UpdatedProduct.getArticul());
        product.setCompany(UpdatedProduct.getCompany());
        product.setName(UpdatedProduct.getName());
        product.setColor(UpdatedProduct.getColor());
        product.setPrice(UpdatedProduct.getPrice());
        product.setDescription(UpdatedProduct.getDescription());
        product.setWeight(UpdatedProduct.getWeight());
        product.setStringQuantity(UpdatedProduct.getStringQuantity());
        session.merge(product);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Product getProductById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return product;
    }

    public void newAdmin(Admin admin){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(admin);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteAdminById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateAdmin(Long id, Admin updatedAdmin){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        admin.setName(updatedAdmin.getName());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setPassword(updatedAdmin.getPassword());
        admin.setPhoneNumber(updatedAdmin.getPhoneNumber());
        session.merge(admin);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Admin getAdminById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Admin admin = session.get(Admin.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return admin;
    }
    public void createUser(User user){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteUserById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateUser(Long id, User updatedUser){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        session.merge(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public User getUserById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return user;
    }
}

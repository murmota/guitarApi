package com.example.guitarApi.dal;


import com.example.guitarApi.models.*;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;
    public void createProduct(Product newProduct) {
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
    public void updateProductById(Long id, Product updatedProduct){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setCompany(updatedProduct.getCompany());
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
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
    public List<Product> getProducts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);
        List<Product> resultList = session.createQuery(query).getResultList();
        return resultList;
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
        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setRole(updatedUser.getRole());
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
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getUserName();

        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Pabeda)";
    }
    public User getUserFromDatabaseByUsername(String name) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
    public void createBasket(Basket basket){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(basket);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteBasketById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Basket basket = session.get(Basket.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateBasket(Long id, Basket updatedBasket){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Basket basket = session.get(Basket.class, id);
        basket.setUser(updatedBasket.getUser());
        basket.setProduct(updatedBasket.getProduct());
        session.merge(basket);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Basket getBasketById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Basket basket = session.get(Basket.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return basket;
    }
    public List<Basket> getBaskets(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Basket> query = builder.createQuery(Basket.class);
        Root<Basket> root = query.from(Basket.class);
        query.select(root);
        List<Basket> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createDiscount(Discount newDiscount) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(newDiscount);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteDiscountById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Discount discount = session.get(Discount.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateDiscount(Long id, Discount updatedDiscount){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Discount discount = session.get(Discount.class, id);
        discount.setProduct(updatedDiscount.getProduct());
        discount.setPercent(updatedDiscount.getPercent());
        session.merge(discount);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Discount getDiscountById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Discount discount = session.get(Discount.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return discount;
    }
    public List<Discount> getDiscounts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Discount> query = builder.createQuery(Discount.class);
        Root<Discount> root = query.from(Discount.class);
        query.select(root);
        List<Discount> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createOrder(Order order){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(order);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteOrderById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateOrder(Long id, Order updatedorder){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        order.setBasket(updatedorder.getBasket());
        order.setStatus(updatedorder.isStatus());
        session.merge(order);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Order getOrderById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return order;
    }
    public List<Order> getOrders(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> query = builder.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);
        query.select(root);
        List<Order> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createPoint(Point point){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(point);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deletePointById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Point point = session.get(Point.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updatePoint(Long id, Point updatedPoint){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Point point = session.get(Point.class, id);
        point.setAddress(updatedPoint.getAddress());
        point.setEmployeeQuantity(updatedPoint.getEmployeeQuantity());
        point.setPhoneNumber(updatedPoint.getPhoneNumber());
        session.merge(point);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Point getPointById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Point point = session.get(Point.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return point;
    }
    public List<Point> getPoints(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Point> query = builder.createQuery(Point.class);
        Root<Point> root = query.from(Point.class);
        query.select(root);
        List<Point> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createReview(Review review){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(review);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteReviewById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.remove(id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateReview(Long id, Review updatedReview){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        review.setProduct(updatedReview.getProduct());
        review.setMark(updatedReview.getMark());
        review.setContent(updatedReview.getContent());
        review.setDate(updatedReview.getDate());
        session.merge(review);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Review getReviewById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return review;
    }
    public List<Review> getReviews(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Review> query = builder.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);
        query.select(root);
        List<Review> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
}
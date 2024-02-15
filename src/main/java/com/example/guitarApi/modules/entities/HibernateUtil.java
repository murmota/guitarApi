package com.example.guitarApi.modules.entities;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure(new File("C:\\Users\\Burbon\\IdeaProjects\\guitarApi\\src\\main\\resources\\application.properties")).buildSessionFactory();
        }
        catch (Throwable ex){
            System.err.println("failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void close(){
        getSessionFactory().close();
    }

}

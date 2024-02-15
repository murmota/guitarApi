package com.example.guitarApi.dal;

import com.example.guitarApi.modules.entities.HibernateUtil;
import com.example.guitarApi.modules.entities.productEntities.Guitars;
import lombok.Getter;
import org.hibernate.Session;

@Getter
public class DataAccessLayer {
    private Session session;
    public void newGuitar(Guitars guitars){
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Guitars guitars1 = session.get(Guitars.class, guitars.getID());
        guitars1.setGuitarType(guitars1.getGuitarType());
        session.persist(guitars1);
        session.getTransaction().commit();
        session.close();
    }
}

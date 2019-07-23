package com.jpademo;

import com.jpademo.bean.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        try (Session session = HibernateUtil.getSession()){
//            OrderEntity orderEntity = new OrderEntity();
//            orderEntity.setId(1);
//            orderEntity.setNum("111111111111");
//            session.save(orderEntity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try (Session session = HibernateUtil.getSession()){
//            OrderItemEntity orderItem = new OrderItemEntity();
//            orderItem.setId(1);
//            orderItem.setOrderId(3);
//            orderItem.setNum(100);
//            session.save(orderItem);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try (Session session = HibernateUtil.getSession()) {
            Query query = session.createNativeQuery("select  o.*,i.* from t_order o,t_order_item i where o.id = i.order_id");
            List students = query.list();
            StringBuilder str = new StringBuilder();
            Iterator iter = students.iterator();
            for (; iter.hasNext(); ) {
                Object[] obj = (Object[]) iter.next();
                for (int i = 0; i < obj.length; i++) {
                    System.out.println(obj[i].getClass());
                }
//                System.out.println(obj.getClass());
            }
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Session session = null;
//        Transaction tx = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tx = session.beginTransaction();
//
//            UserEntity user = new UserEntity();
//            user.setAge(10);
//            user.setUsername("zhangsan333");
//            user.setPassword("123456");
//            session.save(user);
//
//            user = new UserEntity();
//            user.setAge(10);
//            user.setUsername("zhangsan");
//            user.setPassword("123456");
//            session.save(user);
//
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (tx != null) {
//                tx.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
    }


    private static void persistence() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {

//            EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("PersistenceUnit");
//            entityManager= entityManagerfactory.createEntityManager();

            factory = Persistence.createEntityManagerFactory("PersistenceUnit");
            entityManager = factory.createEntityManager();
            persistPerson(entityManager);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }

    private static void persistPerson(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserEntity user = new UserEntity();
            user.setAge(10);
            user.setUsername("zhangsan");
            user.setPassword("123456");
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}

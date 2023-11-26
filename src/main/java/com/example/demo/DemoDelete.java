package com.example.demo;

import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.example.entity.db.RecipeDB;
import com.example.entity.db.RecipeIngredientDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoDelete {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MeasureDB.class)
                .addAnnotatedClass(IngredientDB.class)
                .addAnnotatedClass(RecipeIngredientDB.class)
                .addAnnotatedClass(RecipeDB.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            RecipeDB recipe = session.get(RecipeDB.class, 11);
            session.remove(recipe);

            session.getTransaction().commit();
        }
    }
}

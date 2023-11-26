package com.example.demo;

import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.example.entity.db.RecipeDB;
import com.example.entity.db.RecipeIngredientDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoPersistIngredients {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MeasureDB.class)
                .addAnnotatedClass(IngredientDB.class)
                .addAnnotatedClass(RecipeIngredientDB.class)
                .addAnnotatedClass(RecipeDB.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            MeasureDB gram = new MeasureDB("грам");
            MeasureDB teaspoon = new MeasureDB("чайна ложка");
            MeasureDB tablespoon = new MeasureDB("столова ложка");
            MeasureDB milliliters = new MeasureDB("мілілітр");
            MeasureDB thing = new MeasureDB("штука");

            IngredientDB flour = new IngredientDB("борошно", false, gram);
            IngredientDB salt = new IngredientDB("сіль", false, teaspoon);
            IngredientDB sunflowerOil = new IngredientDB("соняшникова олія", false, tablespoon);
            IngredientDB boilingWater = new IngredientDB("окріп", false, milliliters);
            IngredientDB onion =  new IngredientDB("цибуля", false, thing);
            IngredientDB beef =  new IngredientDB("яловичина", true, gram);
            IngredientDB water =  new IngredientDB("вода", false, milliliters);
            IngredientDB blackPepper = new IngredientDB("чорний перець", false);

            session.beginTransaction();

            session.persist(flour);
            session.persist(salt);
            session.persist(sunflowerOil);
            session.persist(boilingWater);
            session.persist(onion);
            session.persist(beef);
            session.persist(water);
            session.persist(blackPepper);

            session.getTransaction().commit();
        }
    }
}

package com.example.demo;

import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.example.entity.db.RecipeDB;
import com.example.entity.db.RecipeIngredientDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoPersistRecipe {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MeasureDB.class)
                .addAnnotatedClass(IngredientDB.class)
                .addAnnotatedClass(RecipeIngredientDB.class)
                .addAnnotatedClass(RecipeDB.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            RecipeDB recipe = new RecipeDB(
                    "Кримськотатарські чібереки (чебуреки)",
                    "https://www.youtube.com/watch?v=YhCDGHlw7Po",
                    "Простий рецепт хрумких та соковитих кримськотатарських чібереків (чебуреків). Впевнений, більшість з вас їли саме такі десь на березі моря. Вдома вони вийдуть такими ж чудовими. Тісто на чебуреки зробимо заварне. З ним немає мороки, воно еластичне, добре зліплюється, а при обсмажених з’являються бульбашки. Також розкрию секрет соковитості начинки. Дивіться та готуйте, щоб думками перенестися в Крим.",
                    true
            );

            session.beginTransaction();

            IngredientDB flour = session.get(IngredientDB.class, 2);
            IngredientDB salt = session.get(IngredientDB.class, 3);
            IngredientDB sunflowerOil = session.get(IngredientDB.class, 4);
            IngredientDB boilingWater = session.get(IngredientDB.class, 5);
            IngredientDB onion = session.get(IngredientDB.class, 6);
            IngredientDB beef = session.get(IngredientDB.class, 7);
            IngredientDB water = session.get(IngredientDB.class, 8);
            IngredientDB blackPepper = session.get(IngredientDB.class, 9);

            recipe.addRecipeIngredient(new RecipeIngredientDB(flour, 250));
            recipe.addRecipeIngredient(new RecipeIngredientDB(salt, 0.5));
            recipe.addRecipeIngredient(new RecipeIngredientDB(sunflowerOil, 2));
            recipe.addRecipeIngredient(new RecipeIngredientDB(boilingWater, 120));
            recipe.addRecipeIngredient(new RecipeIngredientDB(onion, 1));
            recipe.addRecipeIngredient(new RecipeIngredientDB(beef, 300));
            recipe.addRecipeIngredient(new RecipeIngredientDB(water, 50));
            recipe.addRecipeIngredient(new RecipeIngredientDB(blackPepper, 0));

            session.persist(recipe);

            session.getTransaction().commit();
        }
    }
}

package com.example.demo;

import com.example.entity.db.IngredientDB;
import com.example.entity.db.MeasureDB;
import com.example.entity.db.RecipeDB;
import com.example.entity.db.RecipeIngredientDB;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoGet {
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
//            Recipe recipe = session.get(Recipe.class, 15);
//
//            System.out.println(recipe);
//
//            recipe.getRecipeIngredients()
//                    .forEach(re -> System.out.println("{" +
//                            re.getIngredient().getName() + ", " +
//                            re.getAmount() + " " +
//                            re.getIngredient().getMeasure().getName() +
//                            "}"));

            IngredientDB ingredient = session.get(IngredientDB.class, 2);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(ingredient));

//            System.out.println(ingredient);
//            ingredient.getRecipeIngredients().forEach(re -> System.out.println(re.getRecipe().getName()));

//            List<Ingredient> ingredients =  session
//                    .createNativeQuery("select * from ingredients", Ingredient.class)
//                    .getResultList();
//            ingredients.forEach(System.out::println);

            session.getTransaction().commit();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

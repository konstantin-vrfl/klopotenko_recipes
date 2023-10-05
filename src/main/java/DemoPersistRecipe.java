
import entity.Ingredient;
import entity.Measure;
import entity.Recipe;
import entity.RecipeIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoPersistRecipe {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Measure.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(RecipeIngredient.class)
                .addAnnotatedClass(Recipe.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            Recipe recipe = new Recipe(
                    "Кримськотатарські чібереки (чебуреки)",
                    "https://www.youtube.com/watch?v=YhCDGHlw7Po",
                    "Простий рецепт хрумких та соковитих кримськотатарських чібереків (чебуреків). Впевнений, більшість з вас їли саме такі десь на березі моря. Вдома вони вийдуть такими ж чудовими. Тісто на чебуреки зробимо заварне. З ним немає мороки, воно еластичне, добре зліплюється, а при обсмажених з’являються бульбашки. Також розкрию секрет соковитості начинки. Дивіться та готуйте, щоб думками перенестися в Крим.",
                    true
            );

            session.beginTransaction();

            Ingredient flour = session.get(Ingredient.class, 2);
            Ingredient salt = session.get(Ingredient.class, 3);
            Ingredient sunflowerOil = session.get(Ingredient.class, 4);
            Ingredient boilingWater = session.get(Ingredient.class, 5);
            Ingredient onion = session.get(Ingredient.class, 6);
            Ingredient beef = session.get(Ingredient.class, 7);
            Ingredient water = session.get(Ingredient.class, 8);
            Ingredient blackPepper = session.get(Ingredient.class, 9);

            recipe.addRecipeIngredient(new RecipeIngredient(flour, 250));
            recipe.addRecipeIngredient(new RecipeIngredient(salt, 0.5));
            recipe.addRecipeIngredient(new RecipeIngredient(sunflowerOil, 2));
            recipe.addRecipeIngredient(new RecipeIngredient(boilingWater, 120));
            recipe.addRecipeIngredient(new RecipeIngredient(onion, 1));
            recipe.addRecipeIngredient(new RecipeIngredient(beef, 300));
            recipe.addRecipeIngredient(new RecipeIngredient(water, 50));
            recipe.addRecipeIngredient(new RecipeIngredient(blackPepper, 0));

            session.persist(recipe);

            session.getTransaction().commit();
        }
    }
}

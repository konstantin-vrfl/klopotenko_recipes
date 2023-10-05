
import entity.Ingredient;
import entity.Measure;
import entity.Recipe;
import entity.RecipeIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoGet {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Measure.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(RecipeIngredient.class)
                .addAnnotatedClass(Recipe.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            Recipe recipe = session.get(Recipe.class, 15);

            System.out.println(recipe);

            recipe.getRecipeIngredients()
                    .forEach(re -> System.out.println("{" +
                            re.getIngredient().getName() + ", " +
                            re.getAmount() + " " +
                            re.getIngredient().getMeasure().getName() +
                            "}"));

//            Ingredient ingredient = session.get(Ingredient.class, 2);
//            ingredient.getRecipeIngredients().forEach(re -> System.out.println(re.getRecipe().getName()));

            session.getTransaction().commit();
        }
    }
}

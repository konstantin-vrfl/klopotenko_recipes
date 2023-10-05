
import entity.Ingredient;
import entity.Measure;
import entity.Recipe;
import entity.RecipeIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoDelete {
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
            Recipe recipe = session.get(Recipe.class, 11);
            session.remove(recipe);

            session.getTransaction().commit();
        }
    }
}


import entity.Ingredient;
import entity.Measure;
import entity.Recipe;
import entity.RecipeIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoPersistIngredients {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Measure.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(RecipeIngredient.class)
                .addAnnotatedClass(Recipe.class)
                .buildSessionFactory();

             Session session = sessionFactory.getCurrentSession()) {

            Measure gram = new Measure("грам");
            Measure teaspoon = new Measure("чайна ложка");
            Measure tablespoon = new Measure("столова ложка");
            Measure milliliters = new Measure("мілілітр");
            Measure thing = new Measure("штука");

            Ingredient flour = new Ingredient("борошно", false, gram);
            Ingredient salt = new Ingredient("сіль", false, teaspoon);
            Ingredient sunflowerOil = new Ingredient("соняшникова олія", false, tablespoon);
            Ingredient boilingWater = new Ingredient("окріп", false, milliliters);
            Ingredient onion =  new Ingredient("цибуля", false, thing);
            Ingredient beef =  new Ingredient("яловичина", true, gram);
            Ingredient water =  new Ingredient("вода", false, milliliters);
            Ingredient blackPepper = new Ingredient("чорний перець", false);

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

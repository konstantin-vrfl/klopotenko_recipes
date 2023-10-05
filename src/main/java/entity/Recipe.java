package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "is_hot_dish")
    private boolean hot_dish;
    @Column(name = "is_vegetarian_dish")
    private boolean vegetarian_dish;
    @Column(name = "cooking_time")
    private int cooking_time;

    @OneToMany(mappedBy = "recipe",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<RecipeIngredient> recipeIngredients;

    public Recipe() {
    }

    public Recipe(String name, String url, String description, boolean hot_dish) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.hot_dish = hot_dish;
        this.vegetarian_dish = true;
    }

    public Recipe(String name, String url, String description, boolean hot_dish, int cooking_time) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.hot_dish = hot_dish;
        this.vegetarian_dish = true;
        this.cooking_time = cooking_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHot_dish() {
        return hot_dish;
    }

    public void setHot_dish(boolean hot_dish) {
        this.hot_dish = hot_dish;
    }

    public boolean isVegetarian_dish() {
        return vegetarian_dish;
    }

    public void setVegetarian_dish(boolean vegetarian_dish) {
        this.vegetarian_dish = vegetarian_dish;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (this.recipeIngredients == null) {
            this.recipeIngredients = new ArrayList<>();
        }

        recipeIngredient.setRecipe(this);
        recipeIngredients.add(recipeIngredient);
    }

    @Override
    public String toString() {
        return "Recipe{\n\r" +
                "  name='" + name + "'\n\r" +
                "  url='" + url + "'\n\r" +
                "  description='" + description + "'\n\r" +
                "  hot_dish=" + hot_dish + "\n\r" +
                "  vegetarian_dish=" + vegetarian_dish + "\n\r" +
                "  cooking_time=" + cooking_time + "\n\r" +
                '}';
    }
}

package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_vegetarian")
    private boolean vegetarian;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
               fetch = FetchType.EAGER)
    @JoinColumn(name = "measure_id")
    private Measure measure;

    @OneToMany(mappedBy = "ingredient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<RecipeIngredient> recipeIngredients;

    public Ingredient() {
    }

    public Ingredient(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    public Ingredient(String name, boolean vegetarian, Measure measure) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.measure = measure;
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

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean is_vegetarian) {
        this.vegetarian = is_vegetarian;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", measure=" + measure +
                '}';
    }
}

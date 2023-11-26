package com.example.dao;

import com.example.entity.db.*;
import com.example.entity.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<RecipeDTO> getAllRecipes() {
        Session session = sessionFactory.getCurrentSession();
        List<RecipeDB> recipesDB =  session.createNativeQuery("select * from recipes", RecipeDB.class)
                .getResultList();

        return recipesDB.stream().map(RecipeDTO::new).collect(Collectors.toList());
    }

    @Override
    public RecipeDB getRecipe(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(RecipeDB.class, id);
        //TODO
//        RecipeDB recipeDB = session.get(RecipeDB.class, id);
//
//        return recipeDB != null ? new RecipeDTO(recipeDB) : null;
    }

    @Override
    public void saveRecipe(RecipeDB recipe) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(recipe);
    }

    @Override
    public void deleteRecipe(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<RecipeDB> query = session.createNativeQuery("delete from recipes where id = :recipesId", RecipeDB.class);
        query.setParameter("recipesId", id);
        query.executeUpdate();
    }
}

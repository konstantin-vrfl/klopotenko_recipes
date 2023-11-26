package com.example.dao;

import com.example.entity.db.IngredientDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<IngredientDB> getAllIngredients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createNativeQuery("select * from ingredients", IngredientDB.class)
                .getResultList();
    }

    @Override
    public IngredientDB getIngredient(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(IngredientDB.class, id);
    }

    @Override
    public void saveIngredient(IngredientDB ingredientDB) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(ingredientDB
        );
    }

    @Override
    public void deleteIngredient(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<IngredientDB> query = session.createNativeQuery("delete from ingredients where id = :ingredientId", IngredientDB.class);
        query.setParameter("ingredientId", id);
        query.executeUpdate();
    }
}

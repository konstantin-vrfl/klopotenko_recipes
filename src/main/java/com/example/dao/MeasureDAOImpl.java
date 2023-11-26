package com.example.dao;

import com.example.entity.db.MeasureDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeasureDAOImpl implements MeasureDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<MeasureDB> getAllMeasures() {
        Session session = sessionFactory.getCurrentSession();
        return session.createNativeQuery("select * from measures", MeasureDB.class)
                .getResultList();
    }

    @Override
    public MeasureDB getMeasure(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MeasureDB.class, id);
    }

    @Override
    public void saveMeasure(MeasureDB measureDB) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(measureDB);
    }

    @Override
    public void deleteMeasure(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery<MeasureDB> query = session
                .createNativeQuery("delete from measures where id = :measureId", MeasureDB.class);
        query.setParameter("measureId", id);
        query.executeUpdate();
    }
}

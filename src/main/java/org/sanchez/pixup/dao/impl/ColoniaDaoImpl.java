package org.sanchez.pixup.dao.impl;

import org.sanchez.pixup.dao.ColoniaDao;
import org.sanchez.pixup.hibernate.HibernateUtil;
import org.sanchez.pixup.model.Colonia;
import org.hibernate.Session;

import java.util.List;

public class ColoniaDaoImpl implements ColoniaDao {

    private static volatile ColoniaDao coloniaDao;

    private ColoniaDaoImpl() {}

    public static ColoniaDao getInstance() {
        if (coloniaDao == null) {
            synchronized (ColoniaDaoImpl.class) {
                if (coloniaDao == null) {
                    coloniaDao = new ColoniaDaoImpl();
                }
            }
        }
        return coloniaDao;
    }

    @Override
    public List<Colonia> findAll() {
        List<Colonia> colonias = null;
        Session session = HibernateUtil.getSession();
        colonias = session.createQuery("from Colonia", Colonia.class).getResultList();
        session.close();
        return colonias;
    }

    @Override
    public boolean save(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Colonia colonia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(colonia);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Colonia findById(int id) {
        Session session = HibernateUtil.getSession();
        Colonia colonia = session.get(Colonia.class, id);
        session.close();
        return colonia;
    }
}

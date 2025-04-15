package org.sanchez.pixup.dao.impl;

import org.sanchez.pixup.dao.OrdenDao;
import org.sanchez.pixup.hibernate.HibernateUtil;
import org.sanchez.pixup.model.Orden;
import org.hibernate.Session;

import java.util.List;

public class OrdenDaoImpl implements OrdenDao {

    private static volatile OrdenDao ordenDao;

    private OrdenDaoImpl() {}

    public static OrdenDao getInstance() {
        if (ordenDao == null) {
            synchronized (OrdenDaoImpl.class) {
                if (ordenDao == null) {
                    ordenDao = new OrdenDaoImpl();
                }
            }
        }
        return ordenDao;
    }

    @Override
    public List<Orden> findAll() {
        List<Orden> ordenes = null;
        Session session = HibernateUtil.getSession();
        ordenes = session.createQuery("from Orden", Orden.class).getResultList();
        session.close();
        return ordenes;
    }

    @Override
    public boolean save(Orden orden) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(orden);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Orden orden) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(orden);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Orden orden) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(orden);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Orden findById(int id) {
        Session session = HibernateUtil.getSession();
        Orden orden = session.get(Orden.class, id);
        session.close();
        return orden;
    }
}

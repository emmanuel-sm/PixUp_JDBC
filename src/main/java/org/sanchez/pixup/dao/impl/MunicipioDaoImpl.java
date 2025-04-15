package org.sanchez.pixup.dao.impl;

import org.sanchez.pixup.dao.MunicipioDao;
import org.sanchez.pixup.hibernate.HibernateUtil;
import org.sanchez.pixup.model.Municipio;
import org.hibernate.Session;

import java.util.List;

public class MunicipioDaoImpl implements MunicipioDao {

    private static volatile MunicipioDao municipioDao;

    private MunicipioDaoImpl() {}

    public static MunicipioDao getInstance() {
        if (municipioDao == null) {
            synchronized (MunicipioDaoImpl.class) {
                if (municipioDao == null) {
                    municipioDao = new MunicipioDaoImpl();
                }
            }
        }
        return municipioDao;
    }

    @Override
    public List<Municipio> findAll() {
        List<Municipio> municipios = null;
        Session session = HibernateUtil.getSession();
        municipios = session.createQuery("from Municipio", Municipio.class).getResultList();
        session.close();
        return municipios;
    }

    @Override
    public boolean save(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Municipio municipio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(municipio);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Municipio findById(int id) {
        Session session = HibernateUtil.getSession();
        Municipio municipio = session.get(Municipio.class, id);
        session.close();
        return municipio;
    }
}

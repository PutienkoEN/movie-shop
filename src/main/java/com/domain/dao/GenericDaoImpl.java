package com.domain.dao;

import com.domain.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class GenericDaoImpl <T> implements GenericDao<T> {
    private Class<T> type;
    private Session currentSession;
    private Transaction currentTransaction;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    public void create(T newInstance) {
        getCurrentSession().save(newInstance);
    }

    public T read(Long id) {
        return getCurrentSession().get(type, id);
    }

    public void update(T transientObject) {
        getCurrentSession().update(transientObject);
    }

    public void delete(T persistentObject) {
        getCurrentSession().delete(persistentObject);
    }

    public List<T> getAll() {
        return currentSession.createCriteria(type).list();
    }

    public static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
}

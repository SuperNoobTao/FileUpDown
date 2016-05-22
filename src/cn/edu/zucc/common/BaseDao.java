package cn.edu.zucc.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by shentao on 2016/5/18.
 */


public abstract class BaseDao<T> {
    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public BaseDao() {
        Type type=getClass().getGenericSuperclass();
        entityClass=(Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public List<T> getList() {
            Session session = sessionFactory.getCurrentSession();
            List<T> list=null;
            try {
                list=session.createCriteria(entityClass).list();
            } catch (HibernateException e) {
            e.printStackTrace();
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public T getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (T) session.get(entityClass, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int add(T t) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(t);

            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }



    public int delete(T t) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(t);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(T t) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(t);
            return 1;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public long count(){
        Session session = sessionFactory.getCurrentSession();
        return (Long)session.createCriteria(entityClass)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

}
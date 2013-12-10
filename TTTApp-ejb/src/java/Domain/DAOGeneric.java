/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

/**
 *
 * Bürgi • Dietrich  • Federova  • Shabanova
 */
import Exceptions.SaveFailedException;
import Hibernate.konfiguration.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;



public abstract class DAOGeneric<T, ID extends Serializable> {
	
	private Class<T> _hibernateClass;
	private Session _session;

	
	@SuppressWarnings("unchecked")
	public DAOGeneric() {
		this._hibernateClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	public void setSession(Session s) {
		_session = s;
	}

	protected Session getSession() {
		if (_session == null)
			throw new IllegalStateException(
					"Session has not been set on DAO before usage");
		return _session;
	}

	
	public Class<T> getHibernateClass() {
		return _hibernateClass;
	}

        
	@SuppressWarnings({ "unchecked", "deprecation" })
	public T findById(int id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().get(getHibernateClass(), id,
					LockMode.UPGRADE);
		else
			entity = (T) getSession().get(getHibernateClass(), id);

		return entity;
	}

	
	public List<T> findAll() {
		return findByCriteria();
	}

	
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getHibernateClass());
		Example example = Example.create(exampleInstance);
		if (excludeProperty != null) {
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);example.excludeProperty(exclude);example.excludeProperty(exclude);
			}
		}
		crit.add(example);
		return crit.list();
	}

	
	public List<T> findByExample(T exampleInstance) {
		return findByExample(exampleInstance, null);
	}

	
	public T saveORupdate(T entity) throws SaveFailedException {
		try {
			
			HibernateUtil.currentSession().beginTransaction();
			getSession().saveOrUpdate(entity);
			HibernateUtil.currentSession().getTransaction().commit();
		} catch (HibernateException e) {
			HibernateUtil.currentSession().getTransaction().rollback();
                        throw new SaveFailedException();		
		}
		return entity;
	}

	
        /*
	public void makeTransient(T entity) {
		try {
			HibernateUtil.currentSession().beginTransaction();
			getSession().delete(entity);
			HibernateUtil.currentSession().getTransaction().commit();
		} catch (HibernateException e) {
			HibernateUtil.currentSession().getTransaction().rollback();
			
                }
	}

	
	public void makeTransientWithoutCommit(T entity) {
		try {
			getSession().delete(entity);
		} catch (HibernateException e) {
			
		}
	}
        */

	
	public void flush() {
		getSession().flush();
	}

	
	public void clear() {
		getSession().clear();
	}

	
        
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getHibernateClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	
	public void refresh(T entity) {
		getSession().refresh(entity);
	}
}

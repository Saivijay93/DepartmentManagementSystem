package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResultsDao {

	@Autowired
	  private  SessionFactory sessionFactory;
	  
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Results results) {
	    getSession().save(results);
	    return;
	  }
	  
	  public void delete(Results results) {
	    getSession().delete(results);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Results > getAll() {
	    return getSession().createQuery("from Results").list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Results> getByThree(String rollno, String sem, String mid) {
			  System.out.println("in getRollno(), getSem(), getMid()");
		  
	  return getSession().createQuery("from Results where rollno=:rollno and sem=:sem and mid=:mid")
					 .setParameter("rollno", rollno)
					 .setParameter("sem", sem)
	                 .setParameter("mid", mid).list();
	  }

	  public Results  getById(long id) {
	    return (Results) getSession().load(Results.class, id);
	  }

	  public void update(Results results) {
	    getSession().update(results);
	    return;
	  }

	
}

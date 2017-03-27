package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class AdminstudentDao {

	@Autowired
	  private SessionFactory sessionFactory;
	  
	  private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Adminstudent adminstudent) {
	    getSession().save(adminstudent);
	    return;
	  }
	  
	  public  void delete(Adminstudent adminstudent) {
		  System.out.println("delete dao called");
		  getSession().delete(adminstudent);
	   return;

	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstudent > getAll() {
	    return getSession().createQuery("from Adminstudent").list();
	  }
	  
	 public Adminstudent getByStudRoll(String studRoll) {
		  System.out.println("in getStudRoll()");
	    return  (Adminstudent) getSession().createQuery(
	        "from Adminstudent where studRoll = :studRoll")
	        .setParameter("studRoll", studRoll)
	        .uniqueResult();
	  }
	  
	  
	 public Adminstudent getByTwo(String studRoll,String mobile) {
		  System.out.println("in getStudRoll() and getMobile()");
	    return  (Adminstudent) getSession().createQuery(
	        "from Adminstudent where studRoll = :studRoll and mobile = :mobile")
	        .setParameter("studRoll", studRoll)
	        .setParameter("mobile", mobile)
	        .uniqueResult();
	  }
	 
	 @SuppressWarnings("unchecked")
	 public List<Adminstudent> getByBatch(String batch) {
		  System.out.println("in getBatch()");
	  
		  return getSession().createQuery("from Adminstudent where batch = :batch").setParameter("batch", batch).list();
		  
		  /*return  (List<Adminstudent>)   getSession().createQuery(
	        "from Adminstudent where batch = :batch")
	        .setParameter("batch", batch)
	        .setMaxResults(1)
	        .uniqueResult();
	  */}
	 
	  public Adminstudent  getById(long id) {
	    return (Adminstudent) getSession().load(Adminstudent.class, id);
	  }

	  public void update(Adminstudent adminstudent) {
		  System.out.println("Update dao called");
	    getSession().update(adminstudent);
	    return;
	  }
	
}

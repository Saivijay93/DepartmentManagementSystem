package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TimetableDao {

	@Autowired
	  private  SessionFactory sessionFactory;
	  
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Timetable timetable) {
	    getSession().save(timetable);
	    return;
	  }
	  
	  public void delete(Timetable timetable) {
	    getSession().delete(timetable);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Timetable > getAll() {
	    return getSession().createQuery("from Timetable").list();
	  }
	  
	  
	  @SuppressWarnings("unchecked")
	  public List<Timetable> getBySem(String sem) {
			  System.out.println("in getSem()"+sem);
		  
		 return getSession().createQuery("from Timetable where sem = :sem").setParameter("sem", sem).list();
			}

	  
	  public Timetable  getById(long id) {
	    return (Timetable) getSession().load(Timetable.class, id);
	  }

	  public void update(Timetable timetable) {
	    getSession().update(timetable);
	    return;
	  }
}

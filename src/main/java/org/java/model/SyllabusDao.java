package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SyllabusDao {

	@Autowired
	  private  SessionFactory sessionFactory;
	  
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Syllabus syllabus) {
	    getSession().save(syllabus);
	    return;
	  }
	  
	  public void delete(Syllabus syllabus) {
	    getSession().delete(syllabus);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Syllabus > getAll() {
	    return getSession().createQuery("from Syllabus").list();
	  }

	  
	  public Syllabus  getById(long id) {
	    return (Syllabus) getSession().load(Syllabus.class, id);
	  }

	  public void update(Syllabus syllabus) {
	    getSession().update(syllabus);
	    return;
	  }
	
}

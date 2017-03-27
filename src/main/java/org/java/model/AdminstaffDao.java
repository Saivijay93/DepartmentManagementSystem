package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AdminstaffDao {

	@Autowired
	  private SessionFactory sessionFactory;
	  
	  private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Adminstaff adminstaff) {
	    getSession().save(adminstaff);
	    return;
	  }
	  
	  public void delete(Adminstaff adminstaff) {
	    getSession().delete(adminstaff);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstaff > getAll() {
	    return getSession().createQuery("from Adminstaff").list();
	  }
	  
	  public Adminstaff getByStaffId(String staffId) {
	     System.out.println("in getStaffId()");
	  return  (Adminstaff) getSession().createQuery(
		      "from Adminstaff where staffId = :staffId")
		      .setParameter("staffId", staffId)
		      .uniqueResult();
		  }

	  public Adminstaff  getById(long id) {
	    return (Adminstaff) getSession().load(Adminstaff.class, id);
	  }

	  public void update(Adminstaff adminstaff) {
	    getSession().update(adminstaff);
	    return;
	  }
}

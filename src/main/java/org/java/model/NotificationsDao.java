package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class NotificationsDao {
	
	@Autowired
	  private  SessionFactory sessionFactory;
	  
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Notifications notifications) {
	    getSession().save(notifications);
	    return;
	  }
	  
	  public void delete(Notifications notifications) {
	    getSession().delete(notifications);
	    return;
	  }
	  
	  /*@SuppressWarnings("unchecked")
	  public List<Notifications > getAll() {
	    return getSession().createQuery("from Notifications").list();
	  }*/
	  
	  @SuppressWarnings("unchecked")
	  public List<Notifications> getByStaffMsgs(String staff) {
		//System.out.println("in getByStaffMsgs()");
		return getSession().createQuery("from Notifications where per = :staff").setParameter("staff", staff).list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Notifications> getByStudentMsgs(String student) {
		//System.out.println("in getByStudentMsgs()");
		return getSession().createQuery("from Notifications where per = :student").setParameter("student", student).list();
	  }
	  
	//testing 
	  /*public Notifications getByPerson(String per) {
		  System.out.println("in getPerson()");
	    return  (Notifications) getSession().createQuery(
	        "from Notifications where per = :per")
	        .setParameter("per", per)
	        .uniqueResult();
	  }*/
	  
	    
	  /*public User getByEmail(String email) {
	    return (User) getSession().createQuery(
	        "from User where email = :email")
	        .setParameter("email", email)
	        .uniqueResult();
	  }
	 */

	  public Notifications  getById(long id) {
	    return (Notifications) getSession().load(Notifications.class, id);
	  }

	  public void update(Notifications notifications) {
	    getSession().update(notifications);
	    return;
	  }

}

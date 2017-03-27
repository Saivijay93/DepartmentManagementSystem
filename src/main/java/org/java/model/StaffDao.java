package org.java.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StaffDao {

	@Autowired
	  private  SessionFactory sessionFactory;
	  
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Staff staff) {
	    getSession().save(staff);
	    return;
	  }
	  
	  public void delete(Staff staff) {
	    getSession().delete(staff);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Staff > getAll() {
	    return getSession().createQuery("from Staff").list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstaff> getByIdNo(String idno) {
		System.out.println("in getIdNo()");
		  
	    return getSession().createQuery("from Adminstaff where staffId = :idno").setParameter("idno", idno).list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Staff> getStaffIdNo(String idno) {
		System.out.println("in getstaffIdNo()");
		  
	    return getSession().createQuery("from Staff where idno = :idno").setParameter("idno", idno).list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstaff> getByRecoveryAdminIdno(String idno) {
		System.out.println("in getStaffIdNo()");
		  
	    return getSession().createQuery("from Adminstaff where staffId = :idno").setParameter("idno",idno).list();	  
	  }
	    
	  /*public User getByEmail(String email) {
	    return (User) getSession().createQuery(
	        "from User where email = :email")
	        .setParameter("email", email)
	        .uniqueResult();
	  }
	 */
	  
	  public Staff getStaffNumber(String number) {
			System.out.println("in getStaffNumber()");
			  
		    return (Staff) getSession().createQuery("from Staff where idno = :number")
		    		.setParameter("number", number).uniqueResult();	  
		  }

	  public Staff  getById(long id) {
	    return (Staff) getSession().load(Staff.class, id);
	  }

	  public void update(Staff staff) {
	    getSession().update(staff);
	    return;
	  }

	public boolean logOut() {
		/*getSession().close();*/
		getSession().disconnect();
		return true;
	}


	
}

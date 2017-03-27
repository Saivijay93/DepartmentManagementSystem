package org.java.model;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentDao {
	
	 @Autowired
	  private  SessionFactory sessionFactory;
	  
	 SendMail sendMail=new SendMail();
	 SendContactEmail sendContactEmail=new SendContactEmail();
	 
	  private  Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Student student) {
	    getSession().save(student);
	    return;
	  }
	  
	  public void delete(Student student) {
	    getSession().delete(student);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Student > getAll() {
	    return getSession().createQuery("from Student").list();
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstudent> getByRollNo(String rollno) {
		System.out.println("in getRollNo()");
		  
	    return getSession().createQuery("from Adminstudent where studRoll = :rollno").setParameter("rollno", rollno).list();	  
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Student> getStudentRollNo(String rollno) {
		System.out.println("in getStudentRollNo()");
		  
	    return getSession().createQuery("from Student where rollno = :rollno").setParameter("rollno", rollno).list();	  
	  }
	  
	  public Student getStudentNumber(String number) {
		System.out.println("in getStudentNumber()");
		  
	    return (Student) getSession().createQuery("from Student where rollno = :number")
	    		.setParameter("number", number).uniqueResult();	  
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Adminstudent> getByRecoveryAdminRollno(String studRoll) {
		System.out.println("in getStudentRollNo()");
		  
	    return getSession().createQuery("from Adminstudent where studRoll = :studRoll").setParameter("studRoll",studRoll).list();	  
	  }  
	    
	  /*public User getByEmail(String email) {
	    return (User) getSession().createQuery(
	        "from User where email = :email")
	        .setParameter("email", email)
	        .uniqueResult();
	  }
	 */

	  public Student  getById(long id) {
	    return (Student) getSession().load(Student.class, id);
	  }

	  public void update(Student student) {
	    getSession().update(student);
	    return;
	  }


	public boolean sendMail(int randomInt,String email) {
		//System.out.println("in getByMail()");
		boolean flag=false;
		flag=sendMail.getBysendMail(randomInt,email);
		return flag;
	}
	
	public boolean sendContactMail(String message, String email) {
		System.out.println("in getByMail()");
		boolean flag=false;
		flag=sendContactEmail.getBysendMail(message,email);
		return flag;
	}

	public Student getByStudRoll(String rollno) {
		  System.out.println("in getStudRoll()");
	    return  (Student) getSession().createQuery(
	        "from Student where rollno = :rollno")
	        .setParameter("rollno", rollno)
	        .uniqueResult();
	  }


}

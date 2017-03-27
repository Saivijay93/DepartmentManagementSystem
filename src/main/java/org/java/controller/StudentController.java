package org.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.java.model.StudentDao;
import org.java.model.StudentOtp;
import org.java.model.StudentUpdatePswd;
import org.java.model.SendContactDetails;
import org.java.model.Student;
import org.java.model.Adminstudent;

import org.java.model.SigninStudent;

@Component
@Path("/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@POST
	@Path("/StudentRegister")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StudentDao(Student student) {
		System.out.println("In side StudentDao " + student);
		List<Adminstudent> adminstudent = new ArrayList<Adminstudent>();
		List<Student> allStudents = new ArrayList<Student>();
		boolean flag = false;
		try {
			adminstudent = studentDao.getByRollNo(student.getRollno());
			allStudents = studentDao.getStudentRollNo(student.getRollno());

			System.out.println("admin" + adminstudent);
			System.out.println("student" + allStudents);
			if (!adminstudent.isEmpty()) {
				if (allStudents.isEmpty()) {
					studentDao.save(student);
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			return Response.status(200).entity("You are registerd").build();
		} else {
			return Response.status(400).entity("You are not registered").build();
		}
	}

	@GET
	@Path("/getRegisteredStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRegisteredStudents() {
		List<Student> allStudents = new ArrayList<Student>();
		try {
			allStudents = studentDao.getAll();
			return Response.status(200).entity(allStudents).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(allStudents).build();

	}

	@POST
	@Path("/SinginStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StudentDao1(SigninStudent signin) {

		// System.out.println("In side StudentDao " + signin.getStdName() + " "
		// + signin.getRollNO());
		List<Student> allStudents = new ArrayList<Student>();
		try {
			allStudents = studentDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean small = false;
		for (Student students : allStudents) {
			if (students.getRollno().equalsIgnoreCase(signin.getRollno())
					&& students.getPassword().equalsIgnoreCase(signin.getPassword())) {
				small = true;
				break;
			}
		}

		if (small) {
			return Response.status(200).entity("You are Verified").build();

		} else {
			return Response.status(400).entity("Enter correct Username and Password").build();
		}
	}

	
	
	@POST
	@Path("/sendStudentOTPWS")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StudentDao3(StudentOtp studentOtp) {
		boolean flag=false;
		List<Adminstudent> adminstudent = new ArrayList<Adminstudent>();
		List<Student> allStudents = new ArrayList<Student>();
		String email=null;
		int randomInt=0;
		
			allStudents = studentDao.getStudentRollNo(studentOtp.getRollno());
			if(!allStudents.isEmpty()){
				adminstudent = studentDao.getByRecoveryAdminRollno(studentOtp.getRollno());
				for (Adminstudent adminstuds : adminstudent) {
					 email=adminstuds.getEmail();
					 System.out.println("Email : " +email );
				    }
				Random randomGenerator = new Random();
			    for (int idx = 10000; idx <= 10000; ++idx){
			      randomInt = randomGenerator.nextInt(100000);}
			    System.out.println("Random Number : "+randomInt);
			    //flag=studentDao.sendMail(randomInt,email);
				flag=true;
			   }
			if(flag){
				//return Response.status(200).entity(adminstudent).build();
				return Response.ok(randomInt).build();
			} else{
				return Response.status(400).entity("OTP sending failed").build();
			}
	}
	
	
	
	@POST
	@Path("/updateStudentPswd")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StudentUpdatePass(StudentUpdatePswd studentUpdatePswd) {
		System.out.println("In side recovery StudentDao " + studentUpdatePswd.getNumber());
		Student allStudents = new Student();
		allStudents = studentDao.getStudentNumber(studentUpdatePswd.getNumber());
		boolean flag=false;
		try {
			if(allStudents != null){
				allStudents.setPassword(studentUpdatePswd.getPassword());
				allStudents.setPassword2(studentUpdatePswd.getPassword());
				studentDao.update(allStudents);
			   }
			flag=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	if(flag){
		return Response.status(200).entity("Successfully updated your password").build();
	} else{
		return Response.status(400).entity("Password updating failed").build();
	}
}
	
	
	@POST
	@Path("/studentContact")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StudentDao5(SendContactDetails verifyOtp) {
		System.out.println("Contact : "+verifyOtp.getName()+" "+verifyOtp.getMail()+" "+verifyOtp.getMsg());
		boolean flag=false;
		String message=verifyOtp.getMsg();
		String email=verifyOtp.getMail();
		
			    flag=studentDao.sendContactMail(message,email);
				flag=true;
			if(flag){
				return Response.status(200).entity("Your mail has been sent").build();
				//return Response.ok(randomInt).build();
			} else{
				return Response.status(400).entity("Sending mail failed").build();
			}
	}
	

/*
 * @RequestMapping(value="/delete")
 * 
 * @ResponseBody public String delete(long id) { try { Student student = new
 * Student(id); studentDao.delete(student); } catch(Exception ex) { return
 * ex.getMessage(); } return "Student succesfully deleted!"; }
 * 
 * @RequestMapping(value="/get-by-email")
 * 
 * @ResponseBody public String getByEmail(String email) { String userId; try {
 * User user = _userDao.getByEmail(email); userId =
 * String.valueOf(user.getId()); } catch(Exception ex) { return "User not found"
 * ; } return "The user id is: " + userId; }
 * 
 * @RequestMapping(value="/save")
 * 
 * @ResponseBody public String create(String email, String name) { try {
 * System.out.println("save method in"); User user = new User(email, name);
 * _userDao.save(user); } catch(Exception ex) { return ex.getMessage(); } return
 * "User succesfully saved!"; }
 */
/*
 * for (char ch: "xyz".toCharArray()) { }
 */

}

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

import org.java.model.Adminstaff;
import org.java.model.SigninStaff;
import org.java.model.Staff;
import org.java.model.StaffDao;
import org.java.model.StaffOtp;
import org.java.model.StaffUpdatePswd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/staff")
public class StaffController {

	@Autowired
	private StaffDao staffDao;

	@POST
	@Path("/StaffRegister")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StaffDao(Staff staff) {
		System.out.println("In side StaffDao " + staff);
		List<Adminstaff> adminStaff = new ArrayList<Adminstaff>();
		List<Staff> allStaff=new ArrayList<Staff>();
		boolean flag = false;
		try {
			adminStaff = staffDao.getByIdNo(staff.getIdno());
			allStaff=staffDao.getStaffIdNo(staff.getIdno());

			System.out.println("admin"+adminStaff);
			System.out.println("staff"+allStaff);			
			if(!adminStaff.isEmpty()){
				if(allStaff.isEmpty()){
					staffDao.save(staff);
					flag=true;
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
	@Path("/getRegisteredStaff")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRegisteredStaff() {
		List<Staff> allStaff = new ArrayList<Staff>();
		try {
			allStaff = staffDao.getAll();
			return Response.status(200).entity(allStaff).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(allStaff).build();

	}
	
	@POST
	@Path("/SinginStaff")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StaffDao1(SigninStaff signin) {
		
		//System.out.println("In side StaffDao " + signin.getStfName() + " " + signin.getIdNO());
		List<Staff> allStaff = new ArrayList<Staff>();
		try {
			allStaff = staffDao.getAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean log = false;
		for (Staff stf : allStaff) {
			if (stf.getIdno().equalsIgnoreCase(signin.getIdno())
					&& stf.getPassword().equalsIgnoreCase(signin.getPassword())) {
				log = true;
				break;
			}
		}
		if (log) {
			System.out.println("sssss"+allStaff);
			return Response.status(200).entity(allStaff).build();
			
		} else {
			return Response.status(400).entity("Enter correct Username and Password").build();
		}
	}
	
	@POST
	@Path("/sendStaffOTP")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StaffDao2(StaffOtp staffOtp) {
		boolean flag=false;
		List<Adminstaff> adminstaff = new ArrayList<Adminstaff>();
		List<Staff> allStaff = new ArrayList<Staff>();
		String email=null;
		int staffRandomInt=0;
		allStaff = staffDao.getStaffIdNo(staffOtp.getIdno());
		try{
			if(!allStaff.isEmpty()){
				adminstaff = staffDao.getByRecoveryAdminIdno(staffOtp.getIdno());
				for (Adminstaff adminstaffs : adminstaff) {
					 email=adminstaffs.getEmail();
					 System.out.println("Email : " +email );
				    }
				Random randomGenerator = new Random();
			    for (int idx = 10000; idx <= 10000; ++idx){
			    	staffRandomInt = randomGenerator.nextInt(100000);}
			    System.out.println("Random Number : "+staffRandomInt);
			    //flag=studentDao.sendMail(randomInt,email);
				flag=true;
			   }
		}catch(Exception e){
			e.printStackTrace();
		}
			if(flag){
				//return Response.status(200).entity(adminstudent).build();
				return Response.ok(staffRandomInt).build();
			} else{
				return Response.status(400).entity("You are not verified").build();
			}	
	}
	
	
	@POST
	@Path("/updatePass")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response StaffUpdatePass(StaffUpdatePswd staffUpdatePswd) {
		System.out.println("In side recovery StaffDao " + staffUpdatePswd.getNumber());
		Staff allStaff = new Staff();
		allStaff = staffDao.getStaffNumber(staffUpdatePswd.getNumber());
		boolean flag=false;
		try {
			if(allStaff != null){
				allStaff.setPassword(staffUpdatePswd.getPassword());
				allStaff.setPassword2(staffUpdatePswd.getPassword());
				staffDao.update(allStaff);
			   }
			flag=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	if(flag){
		return Response.status(200).entity("Password successfully updated").build();
	} else{
		return Response.status(400).entity("Updating password failed").build();
	}
}
	
	
}

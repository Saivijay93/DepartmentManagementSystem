package org.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.java.model.Adminstudent;
import org.java.model.AdminstudentDao;
@Component
@Path("/adminstudent")
public class AdminstudentController {
	
	@Autowired
	  private AdminstudentDao adminstudentDao;
	  
	  @POST
		@Path("/StudentRegister")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstudentDao(Adminstudent adminstudent) {
			System.out.println("In side AdminstudentDao "+adminstudent);
			try{
				if(adminstudent.getStudName()!= null ){
					adminstudentDao.save(adminstudent);
				}
			return Response.status(200).entity("Successfully Registered").build();	
			}catch(Exception e){
				System.out.println("Enter correct email id");
				e.printStackTrace();
			}
			
			return Response.status(400).entity("Error adding Student").build();
		}
	  
	  @GET
		@Path("/getRegisteredStudents")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAllAdminStudents() {
			List<Adminstudent> allAdminstudents=new ArrayList<Adminstudent>();
			try{
			allAdminstudents =adminstudentDao.getAll();
			
			 return Response.status(200).entity(allAdminstudents).build();
			}catch(Exception e){
			e.printStackTrace();
			}
			 return Response.status(400).entity(allAdminstudents).build();
	  
	  }	  
	  
		@POST
		@Path("/deleteStud")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstudentDao1(Adminstudent adminstudent) {
		
			try {
				Adminstudent allAdminstudents=new Adminstudent();
				allAdminstudents=adminstudentDao.getByStudRoll(adminstudent.getStudRoll());
				//System.out.println(allAdminstudents.getId());				
				
				adminstudent.setId(allAdminstudents.getId());
				adminstudentDao.delete(adminstudent);
				//System.out.println("After delete function");
			return Response.status(200).entity("Sucesfully deleted").build();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return Response.status(400).entity("Enter valid Roll No. and Mobile").build();
		
		}
		
		
		@POST
		@Path("/updateStud")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstudentDao2(Adminstudent adminstudent) {
		
			try {
				Adminstudent allAdminupdates=new Adminstudent();
				allAdminupdates = adminstudentDao.getByStudRoll(adminstudent.getStudRoll());
				allAdminupdates.setStudRoll(adminstudent.getStudRoll());
				allAdminupdates.setEmail(adminstudent.getEmail());
				allAdminupdates.setMobile(adminstudent.getMobile());
				
				adminstudentDao.update(allAdminupdates);
				//System.out.println("After update function");
				return Response.status(200).entity("Sucesfully updated").build();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return Response.status(400).entity("Enter valid Roll No. ,Gmail and Mobile").build();
		
		}
		
		@POST
		@Path("/retrievingAlumnistudents")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstudentDao3(Adminstudent adminstudent) {
		
			try {
				List<Adminstudent> allAlumniStudents=new ArrayList<Adminstudent>();
				allAlumniStudents =  adminstudentDao.getByBatch(adminstudent.getBatch());
								
				//System.out.println("After get function "+allAlumniStudents.getStudRoll());
				
				System.out.println("After get function "+allAlumniStudents);
				
				return Response.status(200).entity(allAlumniStudents).build();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return Response.status(400).entity("getting students failed").build();
		
		}
	
}
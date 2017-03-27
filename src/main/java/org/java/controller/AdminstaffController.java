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

import org.java.model.Adminstaff;
import org.java.model.AdminstaffDao;

@Component
@Path("/adminstaff")
public class AdminstaffController {

	@Autowired
	private AdminstaffDao adminstaffDao;
	
	  @POST
		@Path("/StaffRegister")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstaffDao(Adminstaff adminstaff) {
			System.out.println("In side AdminstaffDao "+adminstaff);
			
			try{
				if(adminstaff.getStaffName()!= null ){
					adminstaffDao.save(adminstaff);
				}
			return Response.status(200).entity("Successfully Registered").build();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return Response.status(400).entity("Error adding Staff").build();
		}
	  
	  @GET
		@Path("/getRegisteredStaff")
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAllAdminStaff() {
			List<Adminstaff> allAdminstaff=new ArrayList<Adminstaff>();
			try{
			allAdminstaff =adminstaffDao.getAll();
			 return Response.status(200).entity(allAdminstaff).build();
			}catch(Exception e){
			e.printStackTrace();
			}
			 return Response.status(400).entity(allAdminstaff).build();
	  
	  }
	  
	  @POST
		@Path("/updateStaff")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstaffDao1(Adminstaff adminstaff) {
			
			try{
				Adminstaff allAdminupdates=new Adminstaff();
				allAdminupdates = adminstaffDao.getByStaffId(adminstaff.getStaffId());
				//allAdminupdates.setStaffId(adminstaff.getStaffId());
				allAdminupdates.setMobile(adminstaff.getMobile());
				allAdminupdates.setEmail(adminstaff.getEmail());
				
				adminstaffDao.update(allAdminupdates);
			return Response.status(200).entity("Sucesfully updated").build();	
			}catch(Exception e){
				e.printStackTrace();
			}
			return Response.status(400).entity("Enter valid ID No. ,Gmail and Mobile").build();
		}
	  
	  @POST
		@Path("/deleteStaff")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response AdminstaffDao2(Adminstaff adminstaff) {
			
			try{
				Adminstaff allAdmindeletes=new Adminstaff();
				allAdmindeletes = adminstaffDao.getByStaffId(adminstaff.getStaffId());
			    //System.out.println(allAdminupdates.getId());
				
				adminstaff.setId(allAdmindeletes.getId());
				adminstaffDao.delete(adminstaff);
			return Response.status(200).entity("Sucesfully deleted").build();	
			}catch(Exception e){
				e.printStackTrace();
			}
			return Response.status(400).entity("Enter valid ID No. ,Gmail and Mobile").build();
		}
	  
}

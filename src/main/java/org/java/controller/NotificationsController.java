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

import org.java.model.Notifications;
import org.java.model.NotificationsDao;

@Component
@Path("/message")
public class NotificationsController {
	
	@Autowired
    private NotificationsDao notificationsDao;
	
	@POST
	@Path("/addMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response NotificationsDao(Notifications notifications) {
		System.out.println("In side NotificationsDao " + notifications);
		try {
			if (notifications.getMsg() != null) {
				notificationsDao.save(notifications);
			}
		return Response.status(200).entity("Successfully Registered").build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Error adding notifications").build();
	}
	
	
	@GET
	@Path("/getStaffMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStaffMessages() {
		List<Notifications> getStaffMsgs = new ArrayList<Notifications>();
		String staff= "Staff";
		try {
			getStaffMsgs = notificationsDao.getByStaffMsgs(staff);
			return Response.status(200).entity(getStaffMsgs).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(getStaffMsgs).build();

	}
	
	
	@GET
	@Path("/getStudentMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentMessages() {
		List<Notifications> getStudentMsgs = new ArrayList<Notifications>();
		String student= "Student";
		try {
			getStudentMsgs = notificationsDao.getByStudentMsgs(student);
			return Response.status(200).entity(getStudentMsgs).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(getStudentMsgs).build();

	}
	
}

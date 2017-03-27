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

import org.java.model.Timetable;
import org.java.model.TimetableDao;

@Component
@Path("/timetable")
public class TimetableController {
	
	@Autowired
	private TimetableDao timetableDao;
	
	@POST
	@Path("/newTimetable")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response TimetableDao(Timetable timetable) {
		System.out.println("In side TimetableDao " +timetable);
		try {
			if (timetable.getNordays() != null) {
				timetableDao.save(timetable);
			}
		return Response.status(200).entity("Successfully Registered").build();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Adding Timetable failed").build();
	}
	
	@GET
	@Path("/getAdminTimetable")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUpdateStudents() {
		List<Timetable> allTimetables = new ArrayList<Timetable>();
		try {
			allTimetables = timetableDao.getAll();
			return Response.status(200).entity(allTimetables).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(allTimetables).build();

	}
	
	@POST
	@Path("/getTimetable")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response TimetableDao1(Timetable timetable) {
		try {
			List<Timetable> allTimetablelist=new ArrayList<Timetable>();
			allTimetablelist = timetableDao.getBySem(timetable.getSem());
			
			System.out.println("After get function "+allTimetablelist);
			
		return Response.status(200).entity(allTimetablelist).build();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("getting timetable error").build();
	}

}

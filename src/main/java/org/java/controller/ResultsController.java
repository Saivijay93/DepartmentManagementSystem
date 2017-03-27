package org.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.java.model.Results;
import org.java.model.ResultsDao;

@Component
@Path("/results")
public class ResultsController {

	@Autowired
	private ResultsDao resultsDao;
	
	@POST
	@Path("/addExamResults")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ResultsDao(Results results) {
		System.out.println("In side ResultsDao " + results);
		try {
			if (results.getRollno() != null) {
				resultsDao.save(results);
			}
		return Response.status(200).entity("Successfully Registered").build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Adding student results failed").build();
	}

	/*@GET
	@Path("/getExamResults")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllResults() {
		List<Results> allResults = new ArrayList<Results>();
		try {
			allResults = resultsDao.getAll();
			return Response.status(200).entity(allResults).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity(allResults).build();

	}*/
	
	@POST
	@Path("/getStudentresults")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ResultsDao1 (Results results) {
	
		try {
			List<Results> allStudentresults=new ArrayList<Results>();
			allStudentresults =  resultsDao.getByThree(results.getRollno(), results.getSem(), results.getMid());
							
			//System.out.println("After get function "+allAlumniStudents.getStudRoll());
			
			System.out.println("After get function "+allStudentresults);
			
			return Response.status(200).entity(allStudentresults).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return Response.status(400).entity("getting student results failed").build();
	
	}
	
}

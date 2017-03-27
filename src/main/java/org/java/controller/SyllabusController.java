package org.java.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.java.model.Syllabus;
import org.java.model.SyllabusDao;

@Component
@Path("/files")
public class SyllabusController {

	@Autowired
	private SyllabusDao syllabusDao;
	
	@POST
	@Path("/addFiles")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response SyllabusDao(Syllabus syllabus) {
		System.out.println("In side SyllabusDao " + syllabus);
		
		System.out.println("Element :" + syllabus.getElement());

		try {
			if(syllabus != null ){
				syllabusDao.save(syllabus);
			}
			return Response.status(200).entity("You are added syllabus").build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("You are not added syllabus").build();
	}
	
}

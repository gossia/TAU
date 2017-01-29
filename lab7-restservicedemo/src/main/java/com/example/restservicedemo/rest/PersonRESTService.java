package com.example.restservicedemo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.AddressManager;
import com.example.restservicedemo.service.PersonManager;

@Path("persons")
public class PersonRESTService {	
	
	private PersonManager pm = new PersonManager();
	
	@GET
	@Path("/{personId}")
	@Produces("application/json")
	public Person getPerson(@PathParam("personId") Long id){
		Person p = pm.getPerson(id);
		return p;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person){
		System.out.println("Person" + person.getFirstName());
		pm.addPerson(person);
		return Response.status(201).entity(person).build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "REST API /person is running";
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List <Person> getAllPersons(){
		return pm.getAllPersons();
	}
	
	@DELETE
	@Path("/all")
	public Response clearPersons(){
		pm.clearPersons();
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{personId}")
	public Response deleteAddress(@PathParam("personId") Long id){
		pm.deletePersonById(id);
		return Response.status(200).build();
	}
}

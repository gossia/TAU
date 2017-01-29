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

import com.example.restservicedemo.domain.Address;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.AddressManager;
import com.example.restservicedemo.service.PersonManager;

@Path("addresses")
public class AddressRESTService {	
	
	private AddressManager am = new AddressManager();
	private PersonManager pm = new PersonManager();
	
	@GET
	@Path("/{addressId}")
	@Produces("application/json")
	public Address getAddress(@PathParam("addressId") Long id){
		Address a = am.getAddress(id);
		return a;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAddress(Address address){
		am.addAddress(address);
		return Response.status(201).entity(address).build(); 
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "REST API /addresses is running";
	}

	@GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAllAddresses(){
        return am.getAllAddresses();
    }

    @GET
    @Path("/resident/{residentName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAddressesByResident(@PathParam("residentName") String residentName){
        return am.getAddressesByResident(residentName);
    }

    @POST
    @Path("/change/{addressId}/{residentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeAddressResident(@PathParam("addressId") long addressId, @PathParam("residentId") long residentId){
        am.changeAddressResident(am.getAddress(addressId), pm.getPerson(residentId));
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{addressId}")
    public Response deleteAddressById(@PathParam("addressId") Long id){
        am.deleteAddressById(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("/all")
    public Response clearAddresses(){
        am.clearAddresses();
        return Response.status(200).build();
    }

}

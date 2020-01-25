package com.ats.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.exception.IllegalCitizenIdException;
import com.ats.service.SSACitizenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ssa")
@Api(value = "online store and ssa web app")
public class SSARestController {
	@Autowired
	private SSACitizenService ssaCtznSrvc;
	@ApiOperation(value="gives state code of citizen based on given ssa id",response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successfully processed request"),
			@ApiResponse(code=401,message = "you are not authorized to view the resource"),
			@ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code=404,message="The resource you are trying to reach is not found")
	})
	@GetMapping(value="/findStateCode/{ssaId}")
	public ResponseEntity<String> getStateCode(@PathVariable("ssaId") Integer ssaId) {
		String stateCode = ssaCtznSrvc.getCitizenStateCodeByCitizenId(ssaId);
		if(null != stateCode)
			return new ResponseEntity<String>(stateCode,HttpStatus.OK);
		else
			throw new IllegalCitizenIdException("No Citizen Record Found For Given Id");
	}//getStateCode(-)

	@ApiOperation(value = "welcome message",response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successfully processed request"),
			@ApiResponse(code=401,message = "you are not authorized to view the resource"),
			@ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code=404,message="The resource you are trying to reach is not found")
	})
	@GetMapping(value="/hello")
	public String practiseMethod() {
		return "Welcome to Swagger UI";
	}//practiseMethod()
	
	@ApiOperation(value = "list the products ",response=List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "successfully processed request"),
			@ApiResponse(code=401,message = "you are not authorized to view the resource"),
			@ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code=404,message="The resource you are trying to reach is not found")
	})
	@GetMapping(value="/list",produces = "application/json")
	public List<String> practiseMethod1() {
		List<String> list = new ArrayList<String>();
		list.add("Mobiles");
		list.add("KitchenItems");
		list.add("Stationay Items");
		list.add("Furniture Items");
		list.add("Machinery Items");
		return list;
	}//practiseMethod1()
	
}//class

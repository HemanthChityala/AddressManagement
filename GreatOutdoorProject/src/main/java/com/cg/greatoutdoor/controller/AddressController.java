package com.cg.greatoutdoor.controller;
import com.cg.greatoutdoor.GreatOutdoorProjectApplication;
import com.cg.greatoutdoor.dto.AddressDetails;
import com.cg.greatoutdoor.entity.Address;
import com.cg.greatoutdoor.exception.AddressException;
import com.cg.greatoutdoor.service.AddressServiceImpl;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")

public class AddressController {
	
	@Autowired
	AddressServiceImpl addressService;
	
	Logger logger = LoggerFactory.getLogger(GreatOutdoorProjectApplication.class);
	String msg;
	
	@PostMapping(value="/addAddress/{userId}")
	public void addAddress(@RequestBody Address address , @PathVariable("userId") int userId) throws AddressException
	{
		addressService.addAddress(address,userId);	
		msg = "Address Added Successfully";
		logger.info(msg);
	}
	
	@GetMapping(value = "/showById/{id}")
	public AddressDetails findAddress(@PathVariable int id)
	
	{
		return addressService.fingById(id);
	}

	
	@GetMapping(value="/showAll")
	public List<AddressDetails> fetchAddress()
	{
		return  addressService.retreive();
	}
	
	@DeleteMapping(value="/address/delete/{id}")
	public void deleteAddress(@PathVariable int id)
	{
			addressService.delete(id);
			msg = "Address deleted Successfully";
			logger.info(msg);
	}
	
	@PutMapping(value="/address/update/{id}")
	public void updateAddress(@PathVariable int id,@RequestBody Address address)
	{
			addressService.update(address, id);
			msg = "Address updated Successfully";
			logger.info(msg);
	}
}
 
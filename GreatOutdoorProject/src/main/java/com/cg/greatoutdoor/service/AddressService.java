package com.cg.greatoutdoor.service;


import java.util.List;

import com.cg.greatoutdoor.dto.AddressDetails;
import com.cg.greatoutdoor.entity.Address;
import com.cg.greatoutdoor.exception.AddressException;
import com.cg.greatoutdoor.exception.AddressNotFoundException;
import com.cg.greatoutdoor.exception.IdNotFoundException;


public interface AddressService {

	public int addAddress(Address address, int userId) throws AddressException;

	public List<AddressDetails> retreive() throws AddressNotFoundException;
	public boolean delete(int addressId) throws AddressNotFoundException;

	public AddressDetails fingById(int addressId) throws IdNotFoundException;

	public void update(Address address, int addressId) throws AddressNotFoundException;

}

package com.cg.greatoutdoor.dao;

import com.cg.greatoutdoor.entity.Address;
import java.util.List;
public interface AddressDao  {
public int insertAddress(Address address, int userId); 
	
public List<Address> retreive();
	public Address findById(int addressId);
	
	public void delete(int addressId);
	public void update(Address address,int addressId);

}

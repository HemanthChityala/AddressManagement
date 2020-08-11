package com.cg.greatoutdoor.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoor.dao.AddressDaoImpl;
import com.cg.greatoutdoor.dto.AddressDetails;
import com.cg.greatoutdoor.entity.Address;
import com.cg.greatoutdoor.exception.AddressException;
import com.cg.greatoutdoor.exception.AddressNotFoundException;
import com.cg.greatoutdoor.exception.IdNotFoundException;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {

	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	AddressDaoImpl Dao;

	@Override
	public int addAddress(Address address, int userId) throws AddressException {
    
		return Dao.insertAddress(address, userId);

	}

	@Override
	public List<AddressDetails> retreive() throws AddressNotFoundException {
			List<Address> address = Dao.retreive();
			List<AddressDetails> ad = new ArrayList<AddressDetails>();			
			
			if(address!=null)
			{
				for(Address ad1:address) {
					AddressDetails ad11 = new AddressDetails(ad1.getAddressId(),ad1.getBuildingNo(),ad1.getCity(),ad1.getState(),ad1.getField(),ad1.getZip());
				   ad.add(ad11);
				  
				}
				return  ad;
			}
			else
			{
				throw new AddressNotFoundException("Address not found");
			}
			
		}
	
	
	
	
	
	@Override
	public boolean delete(int addressId) throws AddressNotFoundException {
		
		 
			{
				Address address1 =  Dao.findById(addressId);
				if(address1!=null)
				{
					Dao.delete(addressId);
					return true;
				}
				else
				{
					throw new AddressNotFoundException("Id does Not exist or Deleted!!");
				}	
			}
			
			   
	}		

	@Override
	public void update(Address address, int id) throws AddressNotFoundException
	{
		if(id!=0)
		{
			Dao.update(address, id);
		}
		
		else
		{
			throw new AddressNotFoundException("AddressId is required for update ");
		} 

	}

	@Override
	public AddressDetails fingById(int id) throws IdNotFoundException {
		if(id!=0) {
			Address address = Dao.findById(id);
            AddressDetails ad = new AddressDetails(address.getAddressId(),address.getBuildingNo(),address.getCity(),address.getState(),address.getField(),address.getZip());
			return ad;
		}
		else
		{
			throw new IdNotFoundException("Id not found");
		}
}
}



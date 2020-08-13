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
	AddressDaoImpl addressDao;

	@Override
	public int addAddress(Address address, int userId) throws AddressException {

		return addressDao.insertAddress(address, userId);

	}

	@Override
	public List<AddressDetails> retreive() throws AddressNotFoundException {
		List<Address> address = addressDao.retreive();
		List<AddressDetails> adDetails = new ArrayList<AddressDetails>();

		if (address != null) {

			for (Address ad : address) {
				AddressDetails addressdetails = new AddressDetails(ad.getAddressId(), ad.getBuildingNo(), ad.getCity(),
						ad.getState(), ad.getField(), ad.getZip());
				adDetails.add(addressdetails);

			}

			return adDetails;

		} else {

			throw new AddressNotFoundException("Address not available,please an address!");

		}
		

	}

	@Override
	public boolean delete(int addressId) throws AddressNotFoundException {

		{
			Address address1 = addressDao.findById(addressId);
			if (address1 != null) {
				addressDao.delete(addressId);
				return true;
			} else {

				throw new AddressNotFoundException("Id does Not exist or Deleted!!");

			}
		}

	}

	@Override
	public void update(Address address, int id) throws AddressNotFoundException {

		Address address1 = addressDao.findById(id);
		// if (id != 0) {
		if (address1 != null) {

			addressDao.update(address, id);

		} else {

			throw new AddressNotFoundException("AddressId not found please check the id ");

		}

	}

	@Override
	public AddressDetails fingById(int id) throws IdNotFoundException {
		if (id != 0) {

			Address address = addressDao.findById(id);
			AddressDetails adDetails = new AddressDetails(address.getAddressId(), address.getBuildingNo(),
					address.getCity(), address.getState(), address.getField(), address.getZip());
			return adDetails;
		} else {

			throw new IdNotFoundException("Id not found");

		}
	}
}

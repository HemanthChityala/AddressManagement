package com.cg.greatoutdoor.dao;

import java.util.List;

import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.cg.greatoutdoor.entity.Address;
import com.cg.greatoutdoor.entity.User;

@Repository
@Transactional

public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public int insertAddress(Address address, int userId) {

		User user = entitymanager.find(User.class, userId);
		user.addAddress(address);
		return address.getAddressId();

	}

	@Override
	public List<Address> retreive() {
		Query query = entitymanager.createQuery("from Address address");
		return query.getResultList();
		
	}

	@Override
	public void delete(int addressId) {
		Address address = entitymanager.find(Address.class, addressId);
		entitymanager.remove(address);
	}

	@Override
	public Address findById(int id) {
		return entitymanager.find(Address.class, id);
	}

	@Override
	public void update(Address address, int addressId) {

		Address updateAddress = entitymanager.find(Address.class, addressId);
		updateAddress.setBuildingNo(address.getBuildingNo());
		updateAddress.setCity(address.getCity());
		updateAddress.setField(address.getField());
		updateAddress.setState(address.getState());
		updateAddress.setZip(address.getZip());
		entitymanager.merge(updateAddress);

	}

}

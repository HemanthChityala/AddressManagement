package com.cg.greatoutdoor.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.greatoutdoor.GreatOutdoorProjectApplication;
import com.cg.greatoutdoor.dto.AddressDetails;
import com.cg.greatoutdoor.entity.Address;
import com.cg.greatoutdoor.exception.AddressException;
import com.cg.greatoutdoor.exception.AddressNotFoundException;
import com.cg.greatoutdoor.exception.IdNotFoundException;
import com.cg.greatoutdoor.service.AddressService;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional
public class AddressManagementTest {

	@Autowired
	AddressService addressService;
	Logger logger = LoggerFactory.getLogger(GreatOutdoorProjectApplication.class);
	String msg;

	@BeforeAll
	void setUpBeforeClass() {
		msg = "All Test Cases started";
		logger.info(msg);
	}

	@BeforeEach
	void setup() {
		msg = "Test Case Started";
		logger.info(msg);
	}

	@AfterEach
	void tearDown() {
		msg = "Test Case Over";
		logger.info(msg);
	}

	@AfterAll
	void setUpAfterClass() {
		msg = "All Test Cases endedr";
		logger.info(msg);
	}

	@Test
	@DisplayName("Test for adding an address")
	public void addAddressTest() throws AddressException {
		Address address = new Address(1, "154", "HNr", "tg", "colony", "508204");
		assertEquals(1, addressService.addAddress(address, 1));

	}

	@Test
	@DisplayName("Test for retrieving Address")
	public void retrieveAddressTest() throws AddressNotFoundException {
		List<AddressDetails> list = addressService.retreive();
		assertFalse(list.isEmpty());
	}

	@Test
	@DisplayName("Test for retrieving address by id")
	public void retrieveAddressByIdTest() throws IdNotFoundException {
		AddressDetails ad = addressService.fingById(1);
		assertNotNull(ad);

		Assertions.assertThrows(IdNotFoundException.class, () -> {
			addressService.fingById(0);
		});
	}

	@Test
	@DisplayName("Test for deleting the address")
	public void deleteAddressTest() throws AddressNotFoundException {

		assertEquals(true, addressService.delete(1));
		Assertions.assertThrows(AddressNotFoundException.class, () -> {
			addressService.delete(65);
		});
	}

}

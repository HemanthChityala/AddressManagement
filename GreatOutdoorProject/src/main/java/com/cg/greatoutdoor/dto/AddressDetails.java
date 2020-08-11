package com.cg.greatoutdoor.dto;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="great_outdoor_address")
	public class AddressDetails {
		public AddressDetails(int addressId, String buildingNo, String city, String state, String field, String zip) {
			super();
			this.addressId = addressId;
			this.buildingNo = buildingNo;
			this.city = city;
			this.state = state;
			this.field = field;
			this.zip = zip;

		}

		@Id
		@Column(name="address_Id",nullable=false)
		private int addressId;
		
		@Column(name="buiding_No",length = 10)
		private String buildingNo;

		@Column(name="city",length = 20)
		private String city;

		@Column(name="state",length = 20)
		private String state;

		@Column(name="field",length = 20)
		private String field;

		@Column(name="zip",length = 6)
		private String zip;
		
		public int getAddressId() {
			return addressId;
		}




		public AddressDetails() {
			super();
		}


		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getBuildingNo() {
			return buildingNo;
		}

		public void setBuildingNo(String buildingNo) {
			this.buildingNo = buildingNo;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}



	}

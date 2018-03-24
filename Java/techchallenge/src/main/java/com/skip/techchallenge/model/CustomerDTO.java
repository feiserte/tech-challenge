package com.skip.techchallenge.model;

public class CustomerDTO {

	private Integer id;
	private String name;
	private String email;
	private String passwword;
	private String address;
	private String creationDate;
	
	public CustomerDTO() {
		super();
	}
	
	public CustomerDTO(Integer id, String name, String email, String passwword, String address, String creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.passwword = passwword;
		this.address = address;
		this.creationDate = creationDate;
	}
	
	public CustomerDTO(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswword() {
		return passwword;
	}
	public void setPasswword(String passwword) {
		this.passwword = passwword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	
}

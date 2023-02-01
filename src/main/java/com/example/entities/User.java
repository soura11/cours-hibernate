package com.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // declare cette classe comme entite a mapper en db
@Table(name = "user") // Nommera la table user en db
public class User {
	
	@Id // Declare cette attribut comme Pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT gere par le SGBD
	private Integer id;
	@Column(name = "firstname" , columnDefinition = "VARCHAR(50)", nullable = false)
	private String firstName;
	@Column(name = "lastname" , columnDefinition = "VARCHAR(50)", nullable = false)
	private String lastName;
	private int age;
	
	/* Si on suppose qu un user peut avoir une et une seul adresse*/
	//@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	
	/* Si on suppose que plusieurs users peuvent avoir la même adresse*/
//	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//	@JoinColumn(name = "id_adress", referencedColumnName = "id", nullable = false)
//	private Address address;
	
	
	// Si on suppose qu un user peur avoir une ou plsr adresses
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "user")
	private List<Address> addresses = new ArrayList<>();
	
	

	public User() {
		super();
	}
	
	public User(String firstName, String lastName, int age, List<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.addresses = addresses;
	}


	public User(Integer id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public User(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	

	public boolean addAddress(Address e) {
		return addresses.add(e);
	}

	public boolean remove(Object o) {
		return addresses.remove(o);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", addresses=" + addresses + "]";
	}


}

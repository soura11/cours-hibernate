package com.example.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne {
	@Column(name = "age" , columnDefinition = "VARCHAR(3)")
	private int age;
	@Column(name = "datedenaissance")
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, int age, Date dateDeNaissance) {
		super(nom, prenom);
		this.age = age;
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Override
	public String toString() {
		return "Client [age=" + age + ", dateDeNaissance=" + dateDeNaissance + ", toString()=" + super.toString() + "]";
	}

	
	

}

package com.example.demo.kunde;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kunden")
public class Kunde {
	
	@Id
	@SequenceGenerator(
			name = "kunde_seq",
			sequenceName = "kunde_seq",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "kunde_seq"
	)
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	
	// Konstruktoren
	
	public Kunde() {
		
	}
	public Kunde(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}
//	public Kunde(int id, String firstName, String lastName, int age) {
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.age = age;
//	}
	
	
	// Getter/Setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
	

}
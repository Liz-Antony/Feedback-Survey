package ca.sheridancollege.antonye.model;

import java.io.Serializable;

public class Participant{
	private String firstName;
	private String lastName;
	
	public Participant() {}
	
	//contructor with arguments
	public Participant(String fn, String ln) {
		this.firstName = fn;
		this.lastName = ln;
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
	
	//Get firstName
	@Override
	public String toString(){ return (this.firstName + " " + this.lastName);}
	}


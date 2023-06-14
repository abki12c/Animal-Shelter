package gr.aueb.animalshelter.domain;


import androidx.annotation.NonNull;

/** Class for address of an {@link Adopter}.
 * It can represent a chief or a subordinate staff
 * @author Komnas Kafasis
 */

public class Address {

	private String street;
	private int streetNumber;
	private String town;
	private int zipCode;


	public Address(String street, int streetNumber, String town, int zipCode){
		this.street = street;
		this.streetNumber = streetNumber;
		this.town = town;
		this.zipCode = zipCode;

	}

	public Address(){}
	
	public void setStreet(String street) {
		this.street = street;
	}

	public void setStreetNumber(int number) {
		this.streetNumber = number;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	@NonNull
	public String toString() {
		return street+" "+streetNumber+" , "+town+" , "+zipCode;
	}
	
	
}



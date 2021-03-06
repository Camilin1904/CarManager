package model;

import java.time.LocalDate;//Import LocalDate to look for the actual year acurately

/**
 * Class of the vehicles
 */
public abstract class Vehicle {

	/**
	 * The date of the day
	 */
	protected LocalDate today;
	/**
	 * An array containing all of the documents of the vehicle
	 */
	protected Document[] documents;
	/**
	 * the base price of the vehicle
	 */
	protected double basePrice;
	/**
	 * the brand of teh vehicle
	 */
	protected String brand;
	/**
	 * the model(year of production) of the vehicle
	 */
	protected int model;
	/**
	 * the cylinder capacity of teh vehicle
	 */
	protected double cylinderCapacity;
	/**
	 * the mileage of the vehicle(is only abvove 0 if isNew is false)
	 */
	protected double mileage;
	/**
	 * Whether or not the car is new
	 */
	protected boolean isNew;
	/**
	 * The license plate of the vehicle(Only filled if isNew is false)
	 */
	protected String licensePlate;
	/**
	 * The identification of the vehicle
	 */
	protected String id;

	/**
	 * Builder
	 * @param basePrice
	 * @param brand
	 * @param model
	 * @param cylinderCapacity
	 * @param mileage
	 * @param isNew
	 * @param licensePlate
	 * @param propertyCard
	 * @param soat
	 * @param rtm
	 */
	public Vehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, Document[] documents, String id) {
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
		this.isNew = isNew;
		this.licensePlate = licensePlate;
		this.documents = documents;
		this.id = id;
		today = LocalDate.now();
	}

	/**
	 * Fetches the brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Fetches the mielage
	 * @return mileage
	 */
	public double getMileage() {
		return mileage;
	}
	/**
	 * Fetches the model
	 * @return model
	 */
	public int getModel() {
		return model;
	}

	/**
	 * Fetches isNew
	 * @return isNew
	 */
	public boolean getIsNew() {
		return isNew;
	}

	/**
	 * toString
	 */
	public String toString(){
		return "\nId: " + id + "\nBrand: " + brand + "\nModel: " + model +"\nBase price: " + basePrice + "\nSale price: " + salePrice() + "\nCylinder capacity: " + cylinderCapacity + "\nMileage: " + mileage + "\nIs it new?: " + isNew + "\nLicense plate: " + licensePlate + "\nDocuments: \n" + showDocuments(); 
	}
	/**
	 * The first step in calculating the sale price of a vehicle: Checking whether the behicle has all of its documentation or not to determine if 500000 are added to the base price
	 * @return price
	 */
	public double salePrice(){
		double price = 0;
		if ((documents[1]==null||documents[1].getYear()!=today.getYear())||(documents[2]==null||documents[2].getYear()!=today.getYear())){
			price += 500000;
		}
		return price;
	}

	/**
	 * fits all of the information of the documents into a String
	 * @return a String containing all of the information for all of the documents
	 */
	public String showDocuments(){
		String message = "";
		message += " PropertyCard:\n\n";
		if(documents[0]!=null){
			message += documents[0].toString();
		}
		else{
			message += " Non existent property card.\n";
		}
		message += "\n\n Soat:\n\n";
		if(documents[1]!=null){
			message += documents[1].toString();
		}
		else{
			message += " Non existent soat.\n";
		}
		message += "\n\n Rtm:\n\n";
		if(documents[2]!=null){
			message += documents[2].toString();
		}
		else{
			message += " Non existent Rtm.\n";
		}
		return message + "\n";
	}

	/**
	 * fetches the id of the vehicle
	 * @return id
	 */
	public String getId() {
		return id;
	}

}
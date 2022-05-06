package model;

import java.time.LocalDate;

public abstract class Vehicle {

	protected LocalDate today;
	protected Document[] documents;
	protected double basePrice;
	protected String brand;
	protected int model;
	protected double cylinderCapacity;
	protected double mileage;
	protected boolean isNew;
	protected String licensePlate;

	/**
	 * 
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
	public Vehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, Document[] documents) {
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
		this.isNew = isNew;
		this.licensePlate = licensePlate;
		this.documents = documents;
		today = LocalDate.now();
	}

	public String getBrand() {
		return brand;
	}

	public double getMileage() {
		return mileage;
	}

	public int getModel() {
		return model;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public String toString(){
		String pCard = "", soat = "", rtm = "";
		if (documents[0] == null){
			pCard = "non-Existent";
		}
		else{
			pCard = documents[0].DecodeImage();
		}
		if (documents[1] == null){
			soat = "non-Existent";
		}
		else{
			soat = documents[1].DecodeImage();
		}
		if (documents[2] == null){
			pCard = "non-Existent";
		}
		else{
			rtm = documents[2].DecodeImage();
		}
		return "\nBrand: " + brand + "\nModel: " + model +"\nBase price: " + basePrice + "\nCylinder capacity: " + cylinderCapacity + "\nMileage: " + mileage + "\nIs it new?: " + isNew + "\nLicense plate: " + licensePlate + "\nPropertyCard id: " + pCard + "\nSoat id: " + soat + "\nTechnical mechanical revision id: " + rtm; 
	}
	public double SalePrice(){
		double price = 0;
		if ((documents[1]==null||documents[1].getYear()!=today.getYear())||(documents[2]==null||documents[2].getYear()!=today.getYear())){
			price += 500000;
		}
		return price;
	}

}
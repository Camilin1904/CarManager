package model;

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public abstract class Car extends Vehicle {

	private CarType carType;
	private int doorNum;
	private boolean isTinted;

	/**
	 * 
	 * @param basePrice
	 * @param brand
	 * @param model
	 * @param cylinderCapacity
	 * @param mileage
	 * @param isNew
	 * @param licensePlate
	 * @param doorNum
	 * @param isTinted
	 * @param carType
	 */
	public Car(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, documents);
		this.doorNum = doorNum;
		this.isTinted = isTinted;
		this.carType = carType;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCar type: " + carType + "\nNumber of doors: " + doorNum + "\nAre the windows tinted?: " + isTinted;
	}

	@Override
	public double SalePrice() {
		double price = basePrice;
		if(!isNew){
			price *= 0.9;
		}
		return super.SalePrice()+price;
	}

}
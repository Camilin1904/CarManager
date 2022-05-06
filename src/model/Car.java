package model;

/**
 * A Car, a type of vehicle
 */
public abstract class Car extends Vehicle {

	/**
	 * The type the car is
	 */
	private CarType carType;
	/**
	 * teh number of doors the car has
	 */
	private int doorNum;
	/**
	 * Whether or not the windows of the car are tinted
	 */
	private boolean isTinted;

	/**
	 * Builder
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

	/**
	 * Adds the data exclusive to car to the toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nCar type: " + carType + "\nNumber of doors: " + doorNum + "\nAre the windows tinted?: " + isTinted;
	}

	/**
	 * Method to calculate the sale price, substracting a 10% if the car is used
	 */
	@Override
	public double SalePrice() {
		double price = basePrice;
		if(!isNew){
			price *= 0.9;
		}
		return super.SalePrice()+price;
	}

}
package model;

public class Fuel extends Car implements MotorBearer {

	private FuelType fuelType;
	private double tankCapacity;

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
	 * @param tankCapacity
	 */
	public Fuel(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, double tankCapacity, FuelType fuelType, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents);
		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
	}
	@Override
	public double GasolineConsumption() {
		return tankCapacity*(cylinderCapacity/150);
	}

	public FuelType getFuelType() {
		return fuelType;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nFuel type: " + fuelType;
	}
}
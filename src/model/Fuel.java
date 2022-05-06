package model;

/**
 * The Fuel powered Car
 */
public class Fuel extends Car implements MotorBearer {

	/**
	 * The type of the fuel the motor uses
	 */
	private FuelType fuelType;
	/**
	 * The capacit of the fuel tank of the car
	 */
	private double tankCapacity;

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
	 * @param tankCapacity
	 */
	public Fuel(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, double tankCapacity, FuelType fuelType, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents);
		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
	}
	/**
	 * The consumption of gasoline per kilometer for the Fuel powered Car
	 */
	@Override
	public double GasolineConsumption() {
		return tankCapacity*(cylinderCapacity/150);
	}

	/**
	 * Fetches the type of Fuel the motor uses
	 */
	public FuelType getFuelType() {
		return fuelType;
	}
	
	/**
	 * Adds the data exclusive to the Fuel powered Car
	 */
	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nFuel type: " + fuelType;
	}
}
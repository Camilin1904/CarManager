package model;

/**
 * Bikes
 */
public class Motorcycle extends Vehicle implements MotorBearer {

	/**
	 * The type of bike of the bike
	 */
	private BikeType bikeType;
	/**
	 * The capacity of the fule tank of the bike
	 */
	private double tankCapacity;
	/**
	 * the type of fuel the bike uses
	 */
	private FuelType fuelType;

	/**
	 * 	Builder
	 * @param basePrice
	 * @param brand
	 * @param model
	 * @param cylinderCapacity
	 * @param mileage
	 * @param isNew
	 * @param licensePlate
	 * @param tankCapacity
	 * @param bikeType
	 */
	public Motorcycle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, double tankCapacity, BikeType bikeType, FuelType fuelType, Document[] documents, String id) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, documents, id);
		this.tankCapacity = tankCapacity;
		this.bikeType = bikeType;
		this.fuelType = fuelType;
	}
	
	/**
	 * Calculates the sale price of the Bike
	 */
	public double SalePrice(){

		double price = basePrice;

		if(isNew){
			price *= 1.04;
		}
		else{
			price *= 0.98;
		}
		return price + super.SalePrice();
	}

	/**
	 * claculates the gasoline consumption per kilometer of the bike
	 */
	public double GasolineConsumption(){
		return tankCapacity*(cylinderCapacity/75);
	}
	/**
	 * fetches the fule type the bike uses
	 */
	public FuelType getFuelType() {
		return fuelType;
	}

	/**
	 * Adds the data specific to the bike to the to string
	 */
	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nBike Type: " + bikeType;
	}
}
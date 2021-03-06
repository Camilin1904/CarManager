package model;

/**
 * The hybrid car
 */
public class Hybrid extends Car implements BatteryBearer, MotorBearer {

	/**
	 * The type of fuel the Car uses in its motor
	 */
	private FuelType fuelType;
	/**
	 * The capacity of the fuel tank of the Car
	 */
	private double tankCapacity;
	/**
	 * Whether or not the car has a fast charger
	 */
	private boolean hasFastCharger;
	/**
	 * The duration of the battery
	 */
	private double batteryDuration;

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
	 * @param hasFastCharger
	 * @param batteryDuration
	 */
	public Hybrid(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, double tankCapacity, boolean hasFastCharger, double batteryDuration, FuelType fuelType, Document[] documents, String id) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents, id);
		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
		this.hasFastCharger = hasFastCharger;
		this.batteryDuration = batteryDuration;
	}

	/**
	 * Calculates the sale price taking into acount the increment in price for this being a Hybrid Car
	 */
	public double salePrice(){
		double price = basePrice;
		price += 0.15*basePrice;
		return price;
	}

	/**
	 * Calculates the consumption of gasoline per kilometer of the Car
	 */
	@Override
	public double gasolineConsumption(){
		return tankCapacity*(cylinderCapacity/180);
	}

	/**
	 * Calculates the consumption of battery per kilometer of the Car
	 */
	public double batteryConsumption(){
		double consumption = 0;
		if (hasFastCharger){
			consumption = batteryDuration*(cylinderCapacity/200);
		}
		else{
			consumption = (batteryDuration+7)*(cylinderCapacity/200);
		}
		return consumption;
	}

	/**
	 * Fetches the type of fuel the motor utilizes
	 */
	public FuelType getFuelType() {
		return fuelType;
	}

	/**
	 * Adds the data exclusive to teh Hibrid Car to the toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nFuel type: " + fuelType + "\nBattery duration: " + batteryDuration + "\nDoes it have a fast charger?: " + hasFastCharger + "\nBattery Consumption: " + batteryConsumption() + "\nGasoline Consumption: " + gasolineConsumption();
	}

}
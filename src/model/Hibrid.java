package model;

/**
 * The hibrid car
 */
public class Hibrid extends Car implements BatteryBearer, MotorBearer {

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
	public Hibrid(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, double tankCapacity, boolean hasFastCharger, double batteryDuration, FuelType fuelType, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents);
		this.tankCapacity = tankCapacity;
		this.fuelType = fuelType;
		this.hasFastCharger = hasFastCharger;
		this.batteryDuration = batteryDuration;
	}

	/**
	 * Calculates the sale price taking into acount the increment in price for this being a Hibrid Car
	 */
	public double SalePrice(){
		double price = basePrice;
		price += 0.15*basePrice;
		return price;
	}

	/**
	 * Calculates the consumption of gasoline per kilometer of the Car
	 */
	@Override
	public double GasolineConsumption(){
		return tankCapacity*(cylinderCapacity/180);
	}

	/**
	 * Calculates the consumption of battery per kilometer of the Car
	 */
	public double BatteryConsumption(){
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
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nFuel type: " + fuelType + "\nBattery duration: " + batteryDuration + "\nDoes it have a fast charger?: " + hasFastCharger;
	}

}
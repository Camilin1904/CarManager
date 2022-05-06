package model;

public class Hibrid extends Car implements BatteryBearer, MotorBearer {

	private FuelType fuelType;
	private double tankCapacity;
	private boolean hasFastCharger;
	private double batteryDuration;

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

	public double SalePrice(){
		double price = basePrice;
		price += 0.15*basePrice;
		return price;
	}

	public double GasolineConsumption(){
		return tankCapacity*(cylinderCapacity/180);
	}

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

	public FuelType getFuelType() {
		return fuelType;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nFuel type: " + fuelType + "\nBattery duration: " + batteryDuration + "\nDoes it have a fast charger?: " + hasFastCharger;
	}

}
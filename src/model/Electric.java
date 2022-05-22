package model;

/**
 * Electric powered car
 */
public class Electric extends Car implements BatteryBearer {

	/**
	 * Whether or not the Electric Car has a fast charger
	 */
	private boolean hasFastCharger;
	/**
	 * The duration of the battery. 
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
	 * @param hasFastCharger
	 * @param batteryDuration
	 */
	public Electric(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, boolean hasFastCharger, double batteryDuration, Document[] documents, String id) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents, id);
		this.hasFastCharger = hasFastCharger;
		this.batteryDuration = batteryDuration;
	}

	/**
	 * The price at which the Electric car will be sold, it takes into acount the 20% increment in price it gets for being an Electric Car
	 */
	@Override
	public double salePrice() {
		double price = super.salePrice();
		price += 0.20*basePrice;
		return price;
	}

	/**
	 * The consumption of battery per kilometer of the Car
	 */
	@Override
	public double batteryConsumption() {
		double consumption = 0;
		if(hasFastCharger){
			consumption = (batteryDuration+13)*(cylinderCapacity/100);
		}
		else{
			consumption = (batteryDuration+18)*(cylinderCapacity/100);
		}
		return consumption;
	}

	/**
	 * Adds the data exclusive to the Electric Car to the toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nBattery duration: " + batteryDuration + "\nBattery consumption: " + batteryConsumption() + "\nDoes it have a fast charger?: " + hasFastCharger;
	}

}
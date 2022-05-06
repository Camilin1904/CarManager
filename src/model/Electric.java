package model;

public class Electric extends Car implements BatteryBearer {

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
	 * @param hasFastCharger
	 * @param batteryDuration
	 */
	public Electric(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, CarType carType, boolean hasFastCharger, double batteryDuration, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, documents);
		this.hasFastCharger = hasFastCharger;
		this.batteryDuration = batteryDuration;
	}

	@Override
	public double SalePrice() {
		double price = super.SalePrice();
		price += 0.20*basePrice;
		return price;
	}

	@Override
	public double BatteryConsumption() {
		double consumption = 0;
		if(hasFastCharger){
			consumption = (batteryDuration+13)*(cylinderCapacity/100);
		}
		else{
			consumption = (batteryDuration+18)*(cylinderCapacity/100);
		}
		return consumption;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBattery duration: " + batteryDuration + "\nBattery consumption: " + BatteryConsumption() + "\nDoes it have a fast charger?: " + hasFastCharger;
	}

}
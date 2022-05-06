package model;


public class Motorcycle extends Vehicle implements MotorBearer {

	private BikeType bikeType;
	private double tankCapacity;
	private FuelType fuelType;

	/**
	 * 
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
	public Motorcycle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, double tankCapacity, BikeType bikeType, FuelType fuelType, Document[] documents) {
		super(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, documents);
		this.tankCapacity = tankCapacity;
		this.bikeType = bikeType;
		this.fuelType = fuelType;
	}
	
	public double SalePrice(){

		double price = basePrice;

		if(isNew){
			price *= 1.04;
		}
		else{
			price *= 0.98;
		}
		if ((documents[1]==null||documents[1].getYear()==today.getYear())||(documents[2]==null||documents[2].getYear()==today.getYear())){
			price += 500000;
		}
		return price;
	}

	public double GasolineConsumption(){
		return tankCapacity*(cylinderCapacity/75);
	}
	public FuelType getFuelType() {
		return fuelType;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTank capacity: " + tankCapacity + "\nBike Type: " + bikeType;
	}
}
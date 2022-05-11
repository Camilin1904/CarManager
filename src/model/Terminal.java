package model;

import java.util.ArrayList;

public class Terminal {

	/**
	 * Colection of vehicles
	 */
	private ArrayList<Vehicle> vehicles;
	/**
	 * The parking lot where older cars go to be stored
	 */
	private OldVehicleParkingLot parkingLot;

	/**
	 * Builder
	 */
	public Terminal(){
		vehicles = new ArrayList<Vehicle>();
		parkingLot = new OldVehicleParkingLot();
	}

	/**
	 * Method to add an electric car
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
	 */
	public String AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, boolean hasFastCharger, double batteryDuration, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels, String id) {
		String message = "";
		int pos = 0;
		Document[] documents = new Document[3];
		CarType cType = null;
		switch (carType){
			case(1):
				cType = CarType.SEDAN;
				break;
			case(2):
				cType = CarType.VAN;
				break;
		}

		if(!isNew){
			documents[0] = new PropertyCard(pCost, pYear);
		}
		else{
			documents[0] = null;
		}
		if (sCost>0){
			documents[1] = new Soat(sCost, sYear, sMaxCoverage);
		}
		else{
			documents[1] = null;
		}
		if (rCost>=0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Electric(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, hasFastCharger, batteryDuration, documents, id));
		
		if(model<=2015){
			switch (model){
				case(2015):
					pos = parkingLot.FindFirstemptyForLane(0);
					if (pos>=0){
						parkingLot.AddCar(0, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2014):
					pos = parkingLot.FindFirstemptyForLane(1);
					if (pos>=0){
						parkingLot.AddCar(1, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2013):
					pos = parkingLot.FindFirstemptyForLane(2);
					if (pos>=0){
						parkingLot.AddCar(2, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2012):
					pos = parkingLot.FindFirstemptyForLane(3);
					if (pos>=0){
						parkingLot.AddCar(3, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				default:
					pos = parkingLot.FindFirstemptyForLane(4);
					if (pos>=0){
						parkingLot.AddCar(4, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
			}
		}
		return message;
	}

	/**
	 * Method to add a hibrid car.
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
	public String AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, double tankCapacity, boolean hasFastCharger, double batteryDuration, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels, String id) {
		String message = "";
		int pos = 0;
		Document[] documents = new Document[3];
		CarType cType = null;
		FuelType fType = null;
		switch (carType){
			case(1):
				cType = CarType.SEDAN;
				break;
			case(2):
				cType = CarType.VAN;
				break;
		}
		switch (fuelType){
			case(1):
				fType = FuelType.DIESEL;
				break;
			case(2):
				fType = FuelType.PLUS_GASOLINE;
				break;
			case(3):
				fType = FuelType.STANDARD_GASOLINE;
				break;
		}

		if(!isNew){
			documents[0] = new PropertyCard(pCost, pYear);
		}
		else{
			documents[0] = null;
		}
		if (sCost>0){
			documents[1] = new Soat(sCost, sYear, sMaxCoverage);
		}
		else{
			documents[1] = null;
		}
		if (rCost>=0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Hibrid(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, tankCapacity, hasFastCharger, batteryDuration, fType, documents, id));
		if(model<=2015){
			switch (model){
				case(2015):
					pos = parkingLot.FindFirstemptyForLane(0);
					if (pos>=0){
						parkingLot.AddCar(0, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2014):
					pos = parkingLot.FindFirstemptyForLane(1);
					if (pos>=0){
						parkingLot.AddCar(1, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2013):
					pos = parkingLot.FindFirstemptyForLane(2);
					if (pos>=0){
						parkingLot.AddCar(2, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2012):
					pos = parkingLot.FindFirstemptyForLane(3);
					if (pos>=0){
						parkingLot.AddCar(3, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				default:
					pos = parkingLot.FindFirstemptyForLane(4);
					if (pos>=0){
						parkingLot.AddCar(4, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
			}
		}
		return message;
	}

	/**
	 * Method to add a fuel Car.
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
	public String AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, double tankCapacity, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels, String id) {
		String message = "";
		int pos = 0;
		Document[] documents = new Document[3];
		CarType cType = null;
		FuelType fType = null;
		switch (carType){
			case(1):
				cType = CarType.SEDAN;
				break;
			case(2):
				cType = CarType.VAN;
				break;
		}
		switch (fuelType){
			case(1):
				fType = FuelType.DIESEL;
				break;
			case(2):
				fType = FuelType.PLUS_GASOLINE;
				break;
			case(3):
				fType = FuelType.STANDARD_GASOLINE;
				break;
		}

		if(!isNew){
			documents[0] = new PropertyCard(pCost, pYear);
		}
		else{
			documents[0] = null;
		}
		if (sCost>0){
			documents[1] = new Soat(sCost, sYear, sMaxCoverage);
		}
		else{
			documents[1] = null;
		}
		if (rCost>=0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Fuel(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted,cType, tankCapacity, fType, documents, id));
		if(model<=2015){
			switch (model){
				case(2015):
					pos = parkingLot.FindFirstemptyForLane(0);
					if (pos>=0){
						parkingLot.AddCar(0, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2014):
					pos = parkingLot.FindFirstemptyForLane(1);
					if (pos>=0){
						parkingLot.AddCar(1, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2013):
					pos = parkingLot.FindFirstemptyForLane(2);
					if (pos>=0){
						parkingLot.AddCar(2, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2012):
					pos = parkingLot.FindFirstemptyForLane(3);
					if (pos>=0){
						parkingLot.AddCar(3, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				default:
					pos = parkingLot.FindFirstemptyForLane(4);
					if (pos>=0){
						parkingLot.AddCar(4, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
			}
		}
		return message;
	}

	/**
	 * Shows all of the types of cars.
	 * @return A list with the car types enumerated in order
	 */
	public String showCarTypes(){
		return "1). " + CarType.SEDAN + "\n2). " + 	CarType.VAN;
	}
	/**
	 * Shows all of the types of fuels a vehicle may use.
	 * @return A list with the fuel types enumerated in order
	 */
	public String showFuelTypes(){
		return "1). " + FuelType.DIESEL + "\n2). " + FuelType.PLUS_GASOLINE + "\n3). " + FuelType.STANDARD_GASOLINE;
	}

	/**
	 * Method to add a Motorcycle.
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
	public String AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, double tankCapacity, int bikeType, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels, String id) {
		String message = "";
		int pos = 0;
		Document[] documents = new Document[3];
		BikeType bType = null;
		FuelType fType = null;
		switch (bikeType){
			case(1):
				bType = BikeType.CROSS;
				break;
			case(2):
				bType = BikeType.SCOOTER;
				break;
			case(3):
				bType = BikeType.SPORT;
				break;
			case(4):
				bType = BikeType.STANDARD;
				break;
		}
		switch (fuelType){
			case(1):
				fType = FuelType.DIESEL;
				break;
			case(2):
				fType = FuelType.PLUS_GASOLINE;
				break;
			case(3):
				fType = FuelType.STANDARD_GASOLINE;
				break;
		}

		if(!isNew){
			documents[0] = new PropertyCard(pCost, pYear);
			if (sCost>0){
				documents[1] = new Soat(sCost, sYear, sMaxCoverage);
			}
			else{
				documents[1] = null;
			}
			if (rCost>0){
				documents[2] = new Rtm(rCost, rYear, rGasLevels);
			}
			else{
				documents[2] = null;
			}
		}
		else{
			for(int counter=0; counter<3; counter++){
				documents[counter] = null;
			}
		}

		vehicles.add(new Motorcycle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, tankCapacity, bType, fType, documents, id));
		if(model<=2015){
			switch (model){
				case(2015):
					pos = parkingLot.FindFirstemptyForLane(0);
					if (pos>=0){
						parkingLot.AddCar(0, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2014):
					pos = parkingLot.FindFirstemptyForLane(1);
					if (pos>=0){
						parkingLot.AddCar(1, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2013):
					pos = parkingLot.FindFirstemptyForLane(2);
					if (pos>=0){
						parkingLot.AddCar(2, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				case(2012):
					pos = parkingLot.FindFirstemptyForLane(3);
					if (pos>=0){
						parkingLot.AddCar(3, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
				default:
					pos = parkingLot.FindFirstemptyForLane(4);
					if (pos>=0){
						parkingLot.AddCar(4, pos, vehicles.get(vehicles.size()-1));
					}
					else{
						message = "Parking lot out of space";
					}
					break;
			}
		}
		return message;
	}
	/**
	 * Shows all of the types of bikes.
	 * @return A list with the bike types enumerated in order.
	 */
	public String showBikeTypes(){
		return "1). " + BikeType.CROSS + "\n2). " + BikeType.SCOOTER + "\n3). " + BikeType.SPORT + "\n4). " + BikeType.STANDARD;
	}

	/**
	 * Returns a string with all of the vehicle's main data (brand/model/mileage)
	 * @return brand/model/mileage
	 */
	public String DisplayVehicles(){
		String message = "";

		for (int counter=0; counter<vehicles.size(); counter++){
			message += "\n" +(counter+1) + "). " + vehicles.get(counter).getBrand() + "/" + vehicles.get(counter).getModel() + "/" + vehicles.get(counter).getMileage() + "\n";
		}

		return message;
	}

	/**
	 * Fetches the sale price of a given vehicle
	 * @param vehicleIndex
	 * @return SalePrice
	 */
	public double getSalePrice(int vehicleIndex){
		return vehicles.get(vehicleIndex-1).SalePrice();
	}
	/**
	 * 
	 * @param vehicleIndex
	 */
	public void RegisterSale(int vehicleIndex) {
		// TODO - implement Terminal.RegisterSale
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vehicleIndex
	 */
	public void MoveVehicleToParkingLot(int vehicleIndex) {
		// TODO - implement Terminal.MoveVehicleToParkingLot
		throw new UnsupportedOperationException();
	}

	public String DisplayParkingLot() {
		return parkingLot.toString();
	}

	public String DisplayDocuments() {
		// TODO - implement Terminal.DisplayDocuments
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param year
	 */
	public String DisplayVehicleYearRange(int year) {
		// TODO - implement Terminal.DisplayVehicleYearRange
		throw new UnsupportedOperationException();
	}

	public String DisplayOldestVehicle() {
		// TODO - implement Terminal.DisplayOldestVehicle
		throw new UnsupportedOperationException();
	}

	public String DisplayNewestVehicle() {
		// TODO - implement Terminal.DisplayNewestVehicle
		throw new UnsupportedOperationException();
	}

	public double ParkingLotOcupationPercentage() {
		// TODO - implement Terminal.ParkingLotOcupationPercentage
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a string with all of the "toString()" methods of the vehicles that are an instance of Car.
	 * @return a String with the "Cars".
	 */
	public String DisplayCars() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof Car){
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * Returns a String with all of the "toString()" methods of the vehicles who are an instance of MotorBearer and whose fuel type are STANDARD_GASOLINE
	 * @return a String with the vehicles whose fuel is STANDARD_GASOLINE
	 */
	public String DisplayGasoline() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof MotorBearer){
				if(((MotorBearer)vehicles.get(counter)).getFuelType().equals(FuelType.STANDARD_GASOLINE))
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * Returns a String with all of the "toString()" methods of the vehicles who are an instance of MotorBearer and whose fuel type are PLUS_GASOLINE
	 * @return a String with the vehicles whose fuel is PLUS_GASOLINE
	 */
	public String DisplayExtra() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof MotorBearer){
				if(((MotorBearer)vehicles.get(counter)).getFuelType().equals(FuelType.PLUS_GASOLINE))
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * Returns a string with all of the "toString()" methods of the vehicles that are an instance of Motorcycles.
	 * @return a String with the "Bikes".
	 */
	public String DisplayBikes() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof Motorcycle){
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}
	/**
	 * Returns a String with all of the "toString()" methods of the vehicles who are an instance of MotorBearer and whose fuel type are DIESEL
	 * @return a String with the vehicles whose fuel is DIESEL
	 */
	public String DisplayDiesel() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof MotorBearer){
				if(((MotorBearer)vehicles.get(counter)).getFuelType().equals(FuelType.DIESEL))
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}
	/**
	 * Returns a String with all of the "toString()" methods of the vehicles who are an instance of BateryBearer
	 * @return a String with the vehicles whose "fuel" is Electricity
	 */
	public String DisplayElectricity() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter) instanceof BatteryBearer){
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * Returns a String with all of the New vehicles
	 * @return A String with the vehicles whose "isNew" atribute is true
	 */
	public String DisplayNew() {
		String message = "";
		int realCounter = 0;	
		for (int counter=0; counter<vehicles.size(); counter++){
			if(vehicles.get(counter).getIsNew()){
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * Returns a String with all of the Used vehicles
	 * @return A String with the vehicles whose "isNew" atribute is false
	 */
	public String DisplayUsed() {
		String message = "";
		int realCounter = 0;

		for (int counter=0; counter<vehicles.size(); counter++){
			if(!vehicles.get(counter).getIsNew()){
				message += "\n" +(realCounter+1) + "). " + vehicles.get(counter).toString() +"\n";
				realCounter++;		
			}
		}
		return message;
	}

	/**
	 * 
	 * @param propertyCardCost
	 * @param propertyCardYear
	 */
	public void AddDocument(double propertyCardCost, int propertyCardYear) {
		// TODO - implement Terminal.AddDocument
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param soatCost
	 * @param soatYear
	 * @param soatMaxCV
	 */
	public void AddDocument(double soatCost, int soatYear, double soatMaxCV) {
		// TODO - implement Terminal.AddDocument
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rtmCost
	 * @param rtmYear
	 * @param rtmGasLevels
	 */
	public void AddDocument(double rtmCost, int rtmYear, double[] rtmGasLevels) {
		// TODO - implement Terminal.AddDocument
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the number of registered vehicle
	 * @return the size of the ArrayList vehicles	
	 */
	public int getNumVehicles(){
		return vehicles.size();
	}

	public boolean getIsNew(int index){
		return vehicles.get(index).getIsNew();
	}

	public int FindVehicleIndex(String id){
		for (int counter=0; counter<vehicles.size(); counter++){
			if (id.equals(vehicles.get(counter).getId())){
				return counter;
			}
		}
		return -1;
	}

	public String getAllDocumentation(int vehicleIndex){
		return vehicles.get(vehicleIndex).ShowDocuments();
	}

	public String allToStringLane(int lane){
		return parkingLot.allToStringLane(lane);
	}

	public double getOcupationPercentage(){
		return parkingLot.OcupationPercentage();
	}
}
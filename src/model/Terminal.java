package model;

import java.util.ArrayList;

/**
 * Class that manages all of the objects in the program, a sort of terminal where all of the information is sent to the Ui
 */
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
		int pos = 0, lane = 0;
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

		if(!isNew){//Checks if the vehicle is new to fill the data of the property card, which wouldn't exist if the vehicle were to be a new one
			documents[0] = new PropertyCard(pCost, pYear);
		}
		else{
			documents[0] = null;
		}
		if (sCost>=0){//Checks fot the existance of a soat
			documents[1] = new Soat(sCost, sYear, sMaxCoverage);
		}
		else{
			documents[1] = null;
		}
		if (rCost>=0){//Checks for the existance of a Rtm
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Electric(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, hasFastCharger, batteryDuration, documents, id));
		
		if(model<=2015){//checks if the vehicle has to be added to the parking lot
			lane = Math.abs(model-2015);//checks the difference in years to 2015 to determine the lane it will be at
			if (lane>3){// if the difference is higher than 3 years (2012) it means teh car is older than 2012, as such it will go in the last column
				lane = 4;
			}
			pos = parkingLot.FindFirstemptyForLane(lane);
			if (pos>=0){//Checks if there is an empty position
				parkingLot.AddCar(lane, pos, vehicles.get(vehicles.size()-1));
			}
			else{
				message = "Lane " + (lane+1) + " out of space";
			}
		}
		return message;
	}

	/**
	 * Method to add a hybrid car.
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
		int pos = 0, lane = 0;
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

		vehicles.add(new Hybrid(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, tankCapacity, hasFastCharger, batteryDuration, fType, documents, id));
		if(model<=2015){//checks if the vehicle has to be added to the parking lot
			lane = Math.abs(model-2015);//checks the difference in years to 2015 to determine the lane it will be at
			if (lane>3){// if the difference is higher than 3 years (2012) it means teh car is older than 2012, as such it will go in the last column
				lane = 4;
			}
			pos = parkingLot.FindFirstemptyForLane(lane);
			if (pos>=0){
				parkingLot.AddCar(lane, pos, vehicles.get(vehicles.size()-1));
			}
			else{
				message = "Lane " + (lane+1) + " out of space";
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
		int pos = 0, lane = 0;
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
		if(model<=2015){//checks if the vehicle has to be added to the parking lot
			lane = Math.abs(model-2015);//checks the difference in years to 2015 to determine the lane it will be at
			if (lane>3){// if the difference is higher than 3 years (2012) it means teh car is older than 2012, as such it will go in the last column
				lane = 4;
			}
			pos = parkingLot.FindFirstemptyForLane(lane);
			if (pos>=0){
				parkingLot.AddCar(lane, pos, vehicles.get(vehicles.size()-1));
			}
			else{
				message = "Lane " + (lane+1) + " out of space";
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
		int pos = 0, lane = 0;
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
		if(model<=2015){//checks if the vehicle has to be added to the parking lot
			lane = Math.abs(model-2015);//checks the difference in years to 2015 to determine the lane it will be at
			if (lane>3){// if the difference is higher than 3 years (2012) it means teh car is older than 2012, as such it will go in the last column
				lane = 4;
			}
			pos = parkingLot.FindFirstemptyForLane(lane);
			if (pos>=0){
				parkingLot.AddCar(lane, pos, vehicles.get(vehicles.size()-1));
			}
			else{
				message = "Lane " + (lane+1) + " out of space";
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

	public String DisplayParkingLot() {
		return parkingLot.toString();
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
	 * Returns the number of registered vehicle
	 * @return the size of the ArrayList vehicles	
	 */
	public int getNumVehicles(){
		return vehicles.size();
	}

	/**
	 * gets the variable taht holds the answer to wheter the vehicle is new or not
	 * @param index
	 * @return isNew
	 */
	public boolean getIsNew(int index){
		return vehicles.get(index).getIsNew();
	}

	/**
	 * Searches for a vehicle given an index
	 * @param id
	 * @return the index of the vehice or -1 if teh vehicle does not exist
	 */
	public int FindVehicleIndex(String id){
		for (int counter=0; counter<vehicles.size(); counter++){
			if (id.equals(vehicles.get(counter).getId())){
				return counter;
			}
		}
		return -1;
	}

	/**
	 * gets all of the documentation for a given vehicle
	 * @param vehicleIndex
	 * @return a String containing all of the toString()s of a vehicle
	 */
	public String getAllDocumentation(int vehicleIndex){
		return vehicles.get(vehicleIndex).ShowDocuments();
	}

	/**
	 * Calls all of the methods toString() of a given column of the parking lot
	 * @param lane
	 * @return A String containing all of the information of the vehicles on the given lane
	 */
	public String allToStringLane(int lane){
		return parkingLot.allToStringLane(lane);
	}

	/**
	 * fetches the percentage the parking lot has been ocupied
	 * @return the percentage th eparking lot has been ocupied
	 */
	public double getOcupationPercentage(){
		return parkingLot.OcupationPercentage();
	}
}
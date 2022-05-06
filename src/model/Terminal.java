package model;

import java.util.ArrayList;

public class Terminal {

	ArrayList<Vehicle> vehicles;
	OldVehicleParkingLot parkingLot;

	public Terminal(){
		vehicles = new ArrayList<Vehicle>();
		parkingLot = new OldVehicleParkingLot();
	}

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
	public void AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, boolean hasFastCharger, double batteryDuration, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels) {
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
		if (rCost>0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Electric(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, hasFastCharger, batteryDuration, documents));
	}

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
	public void AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, double tankCapacity, boolean hasFastCharger, double batteryDuration, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels) {
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
		if (rCost>0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Hibrid(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, cType, tankCapacity, hasFastCharger, batteryDuration, fType, documents));
	}

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
	 */
	public void AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, int doorNum, boolean isTinted, int carType, double tankCapacity, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels) {
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
		if (rCost>0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Fuel(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted,cType, tankCapacity, fType, documents));
	}

	public String showCarTypes(){
		return "1). " + CarType.SEDAN + "\n2). " + 	CarType.VAN;
	}

	public String showFuelTypes(){
		return "1). " + FuelType.DIESEL + "\n2). " + FuelType.PLUS_GASOLINE + "\n3). " + FuelType.STANDARD_GASOLINE;
	}

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
	public void AddVehicle(double basePrice, String brand, int model, double cylinderCapacity, double mileage, boolean isNew, String licensePlate, double tankCapacity, int bikeType, int fuelType, double sCost, int sYear, double  sMaxCoverage, double pCost, int pYear, double rCost, int rYear, double rGasLevels) {
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
		if (rCost>0){
			documents[2] = new Rtm(rCost, rYear, rGasLevels);
		}
		else{
			documents[2] = null;
		}

		vehicles.add(new Motorcycle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, tankCapacity, bType, fType, documents));
	}

	public String showBikeTypes(){
		return "1). " + BikeType.CROSS + "\n2). " + BikeType.SCOOTER + "\n3). " + BikeType.SPORT + "\n4). " + BikeType.STANDARD;
	}

	public String DisplayVehicles(){
		String message = "";

		for (int counter=0; counter<vehicles.size(); counter++){
			message += "\n" +(counter+1) + "). " + vehicles.get(counter).getBrand() + "/" + vehicles.get(counter).getModel() + "/" + vehicles.get(counter).getMileage() + "\n";
		}

		return message;
	}

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
		// TODO - implement Terminal.DisplayParkingLot
		throw new UnsupportedOperationException();
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

	public int getNumVehicles(){
		return vehicles.size();
	}

}
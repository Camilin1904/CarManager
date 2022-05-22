
package ui;

import model.Terminal;
import java.util.Scanner;
import java.time.LocalDate;
/**
 * Program desogne to keep an invetory of the vehicles in a dealership.
 */
public class CarManager {

	/**
	 * The class that contain all of the logic for the program.
	 */
	private Terminal terminal;
	/**
	 * Scanner
	 */
	private Scanner scan = new Scanner(System.in);
	/**
	 * the actual date
	 */
	private LocalDate today;
	/**
	 * the cases that come preloaded into the program
	 */
	private TestCases cases;

	/**
	 * Main
	 * @param args
	 */
	public static void main(String args[]){
		CarManager main = new CarManager();
		main.terminal = new Terminal();
		main.today = LocalDate.now();
		main.cases = new TestCases();
		main.cases.CreateTestCases(main.terminal);
		main.Menu();
	}

	/**
	 * Method that displays a menu and starts the method in charge of performing the action chosen.
	 */
	public void Menu(){
		String menu = "";
		boolean exit = false;

		System.out.println("\n\nInitializing...\n\n\n\nVehicle Management program: \n");
		do{
			System.out.println("\nChoose an option:\n\n1) Register a vehicle.\n2) Calculate sale price of a vehicle\n3) General Vehicle Data \n4) Check the state of the documentation of a vehicle.\n5) Check the population of the old vehicle parking lot. \n6) Parquing lot operations. \nN) Exit");
			menu = scan.nextLine();
			menu = menu.toUpperCase();//Used so that a lower case N closes the program
			switch (menu){
				case ("1"):
					do{
						System.out.println("\nWhat kind of vehicle will be registered?: \n1)Car. \n2)Motorcycle \nN)Back.");
						menu = scan.nextLine();
						menu = menu.toUpperCase();
						switch (menu){
							case ("1"):
								do{
									System.out.println("\nWhat kind of car will be registered?: \n1)Fuel. \n2)Hybrid. \n3)Electric. \nN)Back.");
									menu = scan.nextLine();
									menu = menu.toUpperCase();
									switch (menu){
										case ("1"):
											addVehicle(Integer.parseInt(menu));
											exit = false;
											break;
										case("2"):
											addVehicle(Integer.parseInt(menu));
											exit = false;
											break;
										case("3"):
											addVehicle(Integer.parseInt(menu));
											exit = false;
											break;
										case("N"):
											exit = true;
											break;
										default:
											System.out.println("\nInvalid input");
									}
								}while(!exit);
								exit = false;
								break;
							case("2"):
								addVehicle(4);
								exit = false;
								break;
							case("N"):
								exit = true;
								break;
							default:
								System.out.println("\nInvalid input");
						}
					}while(!exit);
					exit = false;
					break;
				case("2"):
					getSalePrice();
					break;
				case("3"):
					displayVehicles();
					break;
				case ("4"):
					documentsState();
					break;
				case ("5"):
					displayParkingLot();
					break;
				case ("6"):
					do{
						System.out.println("\nWhat would you like to do?: \n1) Look for the info of the vehicles in a given period of years. \n2) Look at the newest vehicles. \n3) Look at the oldest vehicles. \n4) Look at the ocupation percentage of the parking lot. \nN) Exit");
						menu = scan.nextLine();
						menu = menu.toUpperCase();
						switch (menu){
							case ("1"):
								displayLotYearRange();
								exit = false;
								break;
							case("2"):
								displayLotNewest();
								exit = false;
								break;
							case("3"):
								displayLotOldest();
								exit = false;
								break;
							case ("4"):
								showLotPercentage();
								exit = false;
								break;
							case("N"):
								exit = true;
								break;
							default:
								System.out.println("\nInvalid input");
						}
					}while(!exit);
					exit = false;
					break;
				case("N"):
					System.out.println("\nClosing...");
					exit = true;
					break;
				default:
					System.out.println("Invalid input.");
					break;
			}
		}while(!exit);
	}

	/**
	 * Registers the general data all vehicles have
	 * @param vehicleType
	 */
	public void addVehicle(int vehicleType){
		double basePrice = 0, mileage = 0, cylinderCapacity = 0, sCost = -1, sMaxCoverage = 0, pCost = -1, rCost = -1, rGasLevels = 0;
		int sYear = 0, pYear = 0, rYear = 0, model = 0, menu = 0;
		String brand = "", licensePlate = "", id = "";
		boolean isNew = true;

		System.out.println("Input the brand of the vehicle:");
		brand = scan.nextLine();
		System.out.println("\nInput the model(year) of the vehicle:");
		model = scan.nextInt();
		scan.nextLine();
		System.out.println("\nInput the base price of the vehicle:");
		basePrice = scan.nextDouble();
		scan.nextLine();//Cleans the scanner
		System.out.println("\nInput the cylinder capacity of the vehicle:");
		cylinderCapacity = scan.nextDouble();
		scan.nextLine();
		do{
			System.out.println("\nIs the vehicle new?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					isNew = true;
					break;
				case(2):
					isNew = false;
					break;
				default:
					System.out.println("Invalid input.");//Check in place to avoid th input of an unsoported value
			}
		}while(menu!=1&&menu!=2);
		if(!isNew){//These values are filled if and only if the vehicle is used
			System.out.println("\nInput the mileage of the vehicle:");
			mileage = scan.nextDouble();
			scan.nextLine();
			System.out.println("\nInput the license plate of the vehicle:");
			licensePlate = scan.next();
			scan.nextLine();
			System.out.println("\nInput the cost of the property card of the vehicle:");
			pCost = scan.nextDouble();
			scan.nextLine();
			System.out.println("\nInput the year of the property card of the vehicle:");
			pYear = scan.nextInt();
			scan.nextLine();
			do{
				System.out.println("\nDoes this vehicle have a soat?: \n1) Yes. \n2) No.");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu!=1&&menu!=2){//Check in place to avoid th input of an unsoported value
						System.out.println("Invalid input.");
				}
			}while(menu!=1&&menu!=2);
			if(menu==1){//These values are filled only if there is a soat
				System.out.println("\nInput the cost of the soat of the vehicle:");
				sCost = scan.nextDouble();
				scan.nextLine();
				System.out.println("\nInput the year of the soat of the vehicle:");
				sYear = scan.nextInt();
				scan.nextLine();System.out.println("\nInput the maximum value the soat of the vehicle would cover:");
				sMaxCoverage = scan.nextDouble();
				scan.nextLine();
			}
			menu = 0;
			do{
				System.out.println("\nDoes this vehicle have a technical mechanical revision (Rtm)?: \n1) Yes. \n2) No.");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu!=1&&menu!=2){
						System.out.println("Invalid input.");
				}
			}while(menu!=1&&menu!=2);
			if(menu==1){
				System.out.println("\nInput the cost of the Rtm of the vehicle:");
				rCost = scan.nextDouble();
				scan.nextLine();
				System.out.println("\nInput the year of the Rtm of the vehicle:");
				rYear = scan.nextInt();
				if(vehicleType!=3){
					scan.nextLine();System.out.println("\nInput the gas levels of the rtm:");
					rGasLevels = scan.nextDouble();
					scan.nextLine();
				}
			}
		}
		else{
			rCost = 0;
			rYear = today.getYear();
			rGasLevels = 0;
		}
		
		for (int counter = 0; counter<10; counter++){
			id += (int)(Math.random()*(10)); 	
		}
		System.out.println("\nThis is the ID of the car: " + id);
		
		
		menu = 0;
		
		switch(vehicleType){//Decides which vehicle type to create depending on what the user wants
			case(1):
				addFuelCar(brand, model, basePrice, cylinderCapacity, isNew, sCost, sYear, sMaxCoverage, rCost, rYear, rGasLevels, pCost, pYear, mileage, licensePlate, id);
				break;
			case(2):
				addHybridCar(brand, model, basePrice, cylinderCapacity, isNew, sCost, sYear, sMaxCoverage, rCost, rYear, rGasLevels, pCost, pYear, mileage, licensePlate, id);
				break;
			case(3):
				addElectricCar(brand, model, basePrice, cylinderCapacity, isNew, sCost, sYear, sMaxCoverage, rCost, rYear, rGasLevels, pCost, pYear, mileage, licensePlate, id);
				break;
			case(4):
				addBike(brand, model, basePrice, cylinderCapacity, isNew, sCost, sYear, sMaxCoverage, rCost, rYear, rGasLevels, pCost, pYear, mileage, licensePlate, id);
				break;
		}
		
	}
	
	/**
	 * Method that adds a fuel car to the colection of vehicles, asking only for the specifi data to it
	 * @param brand
	 * @param model
	 * @param basePrice
	 * @param cylinderCapacity
	 * @param isNew
	 * @param sCost
	 * @param sYear
	 * @param sMaxCoverage
	 * @param rCost
	 * @param rYear
	 * @param rGasLevels
	 * @param pCost
	 * @param pYear
	 * @param mileage
	 * @param licensePlate
	 */
	public void addFuelCar(String brand, int model, double basePrice, double cylinderCapacity, boolean isNew, double sCost, int sYear, double sMaxCoverage, double rCost, int rYear, double rGasLevels, double pCost, int pYear, double mileage, String licensePlate, String id) {
		double tankCapacity = 0;
		int doorNum = 0, carType = 0, fuelType = 0, menu = 0;
		boolean isTinted = true;

		do{
			System.out.println("\nInput the type of the vehicle: \n");
			System.out.println(terminal.showCarTypes());
			carType = scan.nextInt();
			if(carType!=1&&carType!=2){//Check in place to avoid th input of an unsoported value
				System.out.println("Invalid input.");
			}
		}while(carType!=1&&carType!=2);
		
		System.out.println("\nInput the tank capacity of the vehicle:");
		tankCapacity = scan.nextDouble();
		scan.nextLine();
		System.out.println("\nInput the number of doors of the vehicle:");
		doorNum = scan.nextInt();
		scan.nextLine();
		do{
			System.out.println("\nInput the fuel type of the vehicle: \n");
			System.out.println(terminal.showFuelTypes());
			fuelType = scan.nextInt();
			scan.nextLine();
			if (fuelType!=1&&fuelType!=2&&fuelType!=3){//Check in place to avoid the input of an unsoported value
				System.out.println("Invalid input.");
			}
		}while(fuelType!=1&&fuelType!=2&&fuelType!=3);
		do{
			System.out.println("\nAre the windows of this vehicle tinted?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					isTinted = true;
					break;
				case(2):
					isTinted = false;
					break;
				default:
					System.out.println("Invalid input.");//Check in place to avoid th input of an unsoported value
			}
		}while(menu!=1&&menu!=2);
		
		System.out.println(terminal.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, tankCapacity, fuelType, sCost, sYear, sMaxCoverage, pCost, pYear, rCost, rYear, rGasLevels, id));//Adds fuel car
	}

	/**
	 * Adds an electric cars to the colection of vehicles, asking only for the specific data to this
	 * @param brand
	 * @param model
	 * @param basePrice
	 * @param cylinderCapacity
	 * @param isNew
	 * @param sCost
	 * @param sYear
	 * @param sMaxCoverage
	 * @param rCost
	 * @param rYear
	 * @param rGasLevels
	 * @param pCost
	 * @param pYear
	 * @param mileage
	 * @param licensePlate
	 */
	public void addElectricCar(String brand, int model, double basePrice, double cylinderCapacity, boolean isNew, double sCost, int sYear, double sMaxCoverage, double rCost, int rYear, double rGasLevels, double pCost, int pYear, double mileage, String licensePlate, String id) {
		double batteryDuration = 0;
		int doorNum = 0, carType = 0, menu = 0;
		boolean isTinted = true, hasFastCharger = false;
		rGasLevels = 0;
		do{
			System.out.println("\nInput the type of the vehicle: \n");
			System.out.println(terminal.showCarTypes());
			carType = scan.nextInt();
			if(carType!=1&&carType!=2){
				System.out.println("Invalid input.");
			}
		}while(carType!=1&&carType!=2);
		System.out.println("\nInput the battery duration of the vehicle:");
		batteryDuration = scan.nextDouble();
		scan.nextLine();
		System.out.println("\nInput the number of doors of the vehicle:");
		doorNum = scan.nextInt();
		scan.nextLine();
		do{
			System.out.println("\nDoes this vehicle have a fast charger?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					hasFastCharger = true;
					break;
				case(2):
					hasFastCharger = false;
					break;
				default:
					System.out.println("Invalid input.");
			}
		}while(menu!=1&&menu!=2);
		do{
			System.out.println("\nAre the windows of this vehicle tinted?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					isTinted = true;
					break;
				case(2):
					isTinted = false;
					break;
				default:
					System.out.println("Invalid input.");
			}
		}while(menu!=1&&menu!=2);
		
		System.out.println(terminal.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, hasFastCharger, batteryDuration, sCost, sYear, sMaxCoverage, pCost, pYear, rCost, rYear, rGasLevels, id));
	}

	/**
	 * Adds a hybrid car to the colection of vehicles, asking for the specific data for this type of car
	 * @param brand
	 * @param model
	 * @param basePrice
	 * @param cylinderCapacity
	 * @param isNew
	 * @param sCost
	 * @param sYear
	 * @param sMaxCoverage
	 * @param rCost
	 * @param rYear
	 * @param rGasLevels
	 * @param pCost
	 * @param pYear
	 * @param mileage
	 * @param licensePlate
	 */
	public void addHybridCar(String brand, int model, double basePrice, double cylinderCapacity, boolean isNew, double sCost, int sYear, double sMaxCoverage, double rCost, int rYear, double rGasLevels, double pCost, int pYear, double mileage, String licensePlate, String id) {
		double tankCapacity = 0, batteryDuration = 0;
		int doorNum = 0, carType = 0, fuelType = 0,menu = 0;
		boolean isTinted = true, hasFastCharger = false;

		do{
			System.out.println("\nInput the type of the vehicle: \n");
			System.out.println(terminal.showCarTypes());
			carType = scan.nextInt();
			if(carType!=1&&carType!=2){
				System.out.println("Invalid input.");
			}
		}while(carType!=1&&carType!=2);
		System.out.println("\nInput the tank capacity of the vehicle:");
		tankCapacity = scan.nextDouble();
		scan.nextLine();
		System.out.println("\nInput the battery duration of the vehicle:");
		batteryDuration = scan.nextDouble();
		scan.nextLine();
		System.out.println("\nInput the number of doors of the vehicle:");
		doorNum = scan.nextInt();
		scan.nextLine();
		do{
			System.out.println("\nInput the fuel type of the vehicle: \n");
			System.out.println(terminal.showFuelTypes());
			fuelType = scan.nextInt();
			scan.nextLine();
			if (fuelType!=1&&fuelType!=2&&fuelType!=3){
				System.out.println("Invalid input.");
			}
		}while(fuelType!=1&&fuelType!=2&&fuelType!=3);
		do{
			System.out.println("\nDoes this vehicle have a fast charger?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					isNew = true;
					break;
				case(2):
					isNew = false;
					break;
				default:
					System.out.println("Invalid input.");
			}
		}while(menu!=1&&menu!=2);
		do{
			System.out.println("\nAre the windows of thsi vehicle tinted?: \n1) Yes. \n2) No.");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu){
				case (1):
					isTinted = true;
					break;
				case(2):
					isTinted = false;
					break;
				default:
					System.out.println("Invalid input.");
			}
		}while(menu!=1&&menu!=2);

		System.out.println(terminal.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, doorNum, isTinted, carType, tankCapacity, hasFastCharger, batteryDuration, fuelType, sCost, sYear, sMaxCoverage, pCost, pYear, rCost, rYear, rGasLevels, id));
	}

	/**
	 * Adds a motorcycle to the colection of vehicles, asking only for the specific data for it
	 * @param brand
	 * @param model
	 * @param basePrice
	 * @param cylinderCapacity
	 * @param isNew
	 * @param sCost
	 * @param sYear
	 * @param sMaxCoverage
	 * @param rCost
	 * @param rYear
	 * @param rGasLevels
	 * @param pCost
	 * @param pYear
	 * @param mileage
	 * @param licensePlate
	 */
	public void addBike(String brand, int model, double basePrice, double cylinderCapacity, boolean isNew, double sCost, int sYear, double sMaxCoverage, double rCost, int rYear, double rGasLevels, double pCost, int pYear, double mileage, String licensePlate, String id) {
		double tankCapacity = 0;
		int fuelType = 0, bikeType = 0;

		do{
			System.out.println("\nInput the type of the vehicle: \n");
			System.out.println(terminal.showBikeTypes());
			bikeType = scan.nextInt();
			if(bikeType<1&&bikeType>4){
				System.out.println("Invalid input.");
			}
		}while(bikeType<1&&bikeType>4);
		System.out.println("\nInput the tank capacity of the vehicle:");
		tankCapacity = scan.nextDouble();
		scan.nextLine();
		do{
			System.out.println("\nInput the fuel type of the vehicle: \n");
			System.out.println(terminal.showFuelTypes());
			fuelType = scan.nextInt();
			scan.nextLine();
			if (fuelType!=1&&fuelType!=2&&fuelType!=3){
				System.out.println("Invalid input.");
			}
		}while(fuelType!=1&&fuelType!=2&&fuelType!=3);
		
		System.out.println(terminal.addVehicle(basePrice, brand, model, cylinderCapacity, mileage, isNew, licensePlate, tankCapacity, bikeType, fuelType, sCost, sYear, sMaxCoverage, pCost, pYear, rCost, rYear, rGasLevels, id));
	}
	
	/**
	 * Prints a menu where te user chooses how to segregate the vehicles to be displayed to them
	 */
	public void displayVehicles() {
		int menu = 0;
		do{
		System.out.println("\nUnder which clasification would you like to display the vehicles?: \n1) Vehicle type. \n2) Fuel type \n3) New vehicles \n4) Used vehicles");
		menu = scan.nextInt();
		scan.nextLine();
		if(menu<=0&&menu>4){
			System.out.println("\nInvalid input.");
		}
		}while(menu<=0&&menu>4);
		switch (menu){
			case(1):
				do{
					System.out.println("\nWhich vehicle type would you like to display?: \n1)Cars \n2)Bikes");
					menu = scan.nextInt();
					scan.nextLine();
					if(menu<=0&&menu>2){
						System.out.println("\nInvalid input.");
					}
				}while(menu<=0&&menu>3);
				switch (menu){
					case (1):
						System.out.println(terminal.displayCars());
						break;
					case (2):
						System.out.println(terminal.displayBikes());
						break;
				}
				break;
			case(2):
				do{
					System.out.println("\nWhich fuel type would you like to display?: \n");
					System.out.println(terminal.showFuelTypes() + "\n4) Electricity");
					menu = scan.nextInt();
					scan.nextLine();
					if(menu<=0&&menu>3){
						System.out.println("\nInvalid input.");
					}
				}while(menu<=0&&menu>3);
				switch (menu){
					case (1):
						System.out.println(terminal.displayDiesel());
						break;
					case (2):
						System.out.println(terminal.displayExtra());
						break;
					case (3):
						System.out.println(terminal.displayGasoline());
						break;
					case (4):
						System.out.println(terminal.displayElectricity());
				}
				break;
			case(3):
				System.out.println(terminal.displayNew());
				break;
			case(4):
				System.out.println(terminal.displayUsed());
				break;
		}

	}

	/**
	 * Fetches the sale price of the selected vehicle
	 */
	public void getSalePrice(){
		int vehicle = 0;
		double extraDiscount = 0;
		System.out.println("\nInput the vehicle: \n");
		System.out.println(terminal.displayVehicles());
		vehicle = scan.nextInt();
		if(vehicle<=0&&vehicle>terminal.getNumVehicles()){
			System.out.println("\nInvalid vehicle.");
		}
		else{
			System.out.println("\nInput any aditional discount: \n");
			extraDiscount = scan.nextDouble();
			System.out.println("\nThe sale price for this vehicle is: " + (terminal.getSalePrice(vehicle)*(1-(extraDiscount/100))));
		}
		scan.nextLine();

	}

	/**
	 * Checks the state of the documents of a vehicle given the id of the vehicle
	 */
	public void documentsState(){
		String id = "";
		int vehicleId;

		do{
			System.out.println("\nInput the id of the vehicle(Or exit inputing N): ");
			id = scan.nextLine();
			id = id.toUpperCase();
			vehicleId = terminal.findVehicleIndex(id);
			if(vehicleId>=0&&!id.equals("N")){//Checs the existence of the vehicle
				System.out.println(terminal.getAllDocumentation(vehicleId));
				id = "N";
			}
			else if (!id.equals("N")){//Checks that the user didn't want to exit and thats why the last conditional didn't pass
				System.out.println("Non-existent vehicle");
			}
		}while(!id.equals("N"));
		
	}

	/**
	 * Prints the visual represnetation of the parking lot
	 */
	public void displayParkingLot(){
		System.out.println(terminal.displayParkingLot());
	}

	/**
	 * Prints the information of the vehicles found in the parking lot in a given range of years.
	 */
	public void displayLotYearRange(){
		int year1 = 0, year2 = 0;
		System.out.println("Which starting year?: \n1) 2014 \n2) 2013 \n3) 2012 \n4) 2011 \n5) <2011");
		year1 = scan.nextInt()-1;
		scan.nextLine();
		System.out.println("Which finishing year?: \n1) 2014 \n2) 2013 \n3) 2012 \n4) 2011 \n5) <2011 ");
		year2 = scan.nextInt()-1;
		scan.nextLine();
		if(year1>year2){//check in place for the chance the user inputs a finishing year higher than the starting year.
			for (int counter=year2; counter<=year1; counter++){
				System.out.println("\n" + (2014-counter) + ":\n" +terminal.allToStringLane(counter));
			}
		}
		else if(year1<year2){
			for (int counter=year1; counter<=year2; counter++){
				System.out.println("\n" + (2014-counter) + ":\n" +terminal.allToStringLane(counter));
			}
		}
		else{
			System.out.println("\n" + (2014-year1) + ":\n" +terminal.allToStringLane(year1));
		}
	}

	/**
	 * Prints the vehicles found in the <2012 column of the parking lot
	 */
	public void displayLotOldest(){
		String message = "Empty parking lot";
		boolean isEmpty = true;
		for (int counter=4; counter>0&&isEmpty; counter--){
			isEmpty = terminal.IsEmpty(counter);
			if(!isEmpty){
				message = terminal.allToStringLane(counter);
			}
		}
		System.out.println(message);
	}	


	/**
	 * Prints the vehicles found int the 2015 column of the parking lot
	 */
	public void displayLotNewest(){
		String message = "Empty parking lot";
		boolean isEmpty = true;
		for (int counter=0; counter<5&&isEmpty; counter++){
			isEmpty = terminal.IsEmpty(counter);
			if(!isEmpty){
				message = terminal.allToStringLane(counter);
				break;
			}
		}
		System.out.println(message);
	}

	/**
	 * Prints the ocupation percentage of the parking lot, and informs when the parking lot id full.
	 */
	public void showLotPercentage(){
		double percentage = terminal.getOcupationPercentage();
		System.out.println("\nThe ocupation percentage for the old vehicle parking lot is: " + percentage + "%.");
		if (percentage==100){
			System.out.println("The parking lot is full, it must be expanded");
		}
	}


}



//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@%%%%&@@@@@@@@&&&&&@@@@@@@@@@@@@@@@&&&&&%%%%&&&&&&&&@@@@@@@@@@@@@@@@@@@@@&(//(%%&@@&&&@@&&%%%%&@@@@@@@@@@@@@@
//@@@@@@@@@&%%((/(#%&&&&&&%%((#%&@@@@@@@@@@@&&&%(*/#%%%%%&&%%%%&&&&@@@@@@@@@@@@@@@@@@@&**/(&&&&%%%%%%&&/*//#%&@@@@@@@@@@@@
//@@@@@@@@@&%%/*((%&###%##(((/((%%&@@@@@@@&&%%%#(((%%%%&&&&&&&%%%&&&&@@@@@@@@@@@@@@%%##&&&&##****//((&&%#####&&@@@@@@@@@@@
//@@@@@@@@%%%%##/*((****//((((#%%%%%&@@@&&&%%#%%%%%%%&&%%%&&&@@&&&&&&@@@@@@@@@@@@%%(/**/*((///////(***///((#%%%&@@@@@@@@@@
//@@@@@&%%%%((**/(#%%%%%%%%%(///#%%%%%&@&&&&&&&&&%%&&%#*/#%%%&&@@@&&&@@@@@@@@@@%#(//(%%%%%%%%%%%%%%((/(****#%%%%%&@@@@@@@@
//@@@@@@%%((**#%%%((**/(**/(#%%%%%%%&@@@@@&&&&&&&&&%%%#*/#%%%&&@@@@@@&&@@@@@@@&%#//##////////////#%%%(//(**/(#%%%&&@@@@@@@
//@@@@%%##*,#%(///**//**//**/((##%%%&@&&&&@@@&%#%%%&&%%%%%%&&&&@@&&&&&&@@&&@&%#/(%#(/////******//////##((/*//#%%%%%&@@@@@@
//@@@@%%((..#%(///******,,****//((#%&@&%(/%@&&%##//*/%%&&&&&&&&%%&&&&&&@@&&@&%%##((**//.,,,**////######%%(///#%%%%%&@@@@@@
//@@@@%%((..#%#%%%((((,.....,***/(#%&@&%%#&@&%&@%/*,..*/(%%%#/(%%&&&&@@@@&&@&%#//**((......**////##((((((////#%%%%%&&@@@@@
//@@@@%%((******&&(/**/(,.******//#%&@&&#(%@@&%#%@#...*((((((((%%&&@@@&##((@&%#//((****..**///(#%%%%%%%%%%%%%%%%%%%@@@@@@@
//@@@@%%((((****&&#(((********////#%&@@@&%%%&&&&&%%@#,/((((((%%&&@@@@&&%%%%@&%#//**//******//#%%%&@&@&&&&&&&&@@&&@@@@@@@@@
//@@@@@@&&&&&&&&&&&&%%(/****////(##%&@@@@@&%#(#&&&&&%%&@&##%&&&&&&&%%(#%&@@@@&%//////**//////#%&@&&%%#(////##%&&&&@@@@@@@@
//@@@@@@&&##((####%%&&(//(//////#%%%&@&&@@@@@@#**/(&&&%#%&&&&&&&&&%(#@@@@@@@@@&%#////(/////#%%%&@&&%#((////%&&&&&&@@@@@@@@
//@@@@@@&&((/*((#%&&&&%%(/////#%%%&@@@&&&&&@@@@@&#%&&&%#%@@@@&%*(&&@@@@&&&&@@@@@&%%%%%%%%%%%%&@@@&&%#&&&&&&&&&&&&&@@@@@@@@
//@@@@@@&&((//((#%&&@@@@%%%%%%%%&@@@&&&&&%&@&&&@@@@@@@&&%#%%&@@@@@@@@&&&&&&@@@@@@@@&&@@@@@@@@&&%###&&&@@@&&&&&&&&@@@@@@@@@
//@@@@@@&&&&&&&&&&&&&&&&&&&&&&&@@@@@&&&&&&&&&@&&&&&&&&&@@@@@@&&&&&&&&&&&&@@&&@@@@@@&&&&&%&%%%&&&&&&@&&&@&&&&&&&&&&&@@@@@@@
//@@@@@@@@@&&&@&&&@@@@@@@@@@@@@@&&&@&%%%&&&%&&&&&@&&&&&@&&&%%&&&&%%&&&&&&%%&&&&@&@@&&&&@@&&&&&%&&&@@&%%%%%%((((((#%&@@@@@@
//@@@@@@%%%%%%&&&&@@@&@@&&&@@@&&&&&@&%%#%&&&&%&&&@&%%%%%%&&&&&&%%%%&&@&%%%%&&&&&&&&&&##&&@@@@@@@@@@&&%%%%(////(**//#%&@@@@
//@@@@@@%%(///#%%%%%%%&@&&&&&@&&&&&&&%%#/*#&&&&@&&&&&&&&&&&&&%%%%&&&&%%%%&&@@@@@&@&%&((##&%@&&&@@%%%%%%%%((****,.//#%&&@@@
//@@@@@@%%(/,,#%(/#%##%&&&#(%&&&&&&&&%%#(/#%%%&&&&%%##(/(##%%%%%&&&&&%&&&@@&&@@&&%%&&&&&&@&&&&&%%##%%(/(#(((///,,//#%&&@@@
//@@@@@@%%((**#%((#%/*#%&&&&&@&%&@&&&&%%%#%%&&&%%%%%#####%%%%&&&&&&&&&&&&%%&&&&&@%%%%&&@@@@&@%%((//#%(///#%##(/////#%&&@@@
//@@@@@@@&%%((#%(/#%/*//#%%%&&@@&%&&&&&&%%%%&&&%%%%%%%%%%&&&&&&&&@@@&%%%%%%%%&&&&&&@@@@@&@@%%%%**//#%((****//#%%%%%%%&&@@@
//@@@@@@@@%%((#%(//(#%/*/(#%&&&@&%%%&@&@&&&&&&&%%&&&&&&&&&&&&&@@@@&%%(#%%%%%%%%%%@&&&&&&@%%%%((**##(//(****//////#%%%&&@@@
//@@@@@@@@@&%%%%((*,//##%%#(#%&&&&%%%%&@&&&@&@&&&&&&&&&&&&&&&&&@@&&%%&&&%%%%%%%%%&&&@@@@@@&%%//((##(/****,.**///(#%%%&&@@@
//@@@@@@@@@&%%%%((,.**//((#%%%&&&@&&&&&&%#%&&&&&&&&&&&&&&%%%&@&@&##%%&%%%&&&&&&&&&@@@@@@@@&&&&&%%##(///**,.**////((#%%%&@@
//@@@@@@@@@@%%%%((****//#%%%%%%%&@&%%%%&%%#(((*.*(#%%%%%%%&@@@&%#*/(#%%%%%%%%@@@@@@@@@@@@@@@@@&&&%%(///**,.****////#%%%&@@
//@@@@@@@@@@@&%%(//(**///(#%%%&&&@@@&%%%%%%%#(((/.*(#%%%&@@@&%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@&%%((********////#%%%&@@
//@@@@@@@@@@@&%%((/(**//##%%%%&@@@@@@@&&&%%%%%%%%%%%&@&&&@&%%%&@&&&%%%%&&@@@@@@@@@@@@@@@@@@&&%%&@@@%%((((((((((((//#%%%&@@
//@@@@@@@@@@@&%%%%(/////(##%%%&@@@@@@@&&&%#(##%%(**/(###%&%##(#%%%%%&&@@@@@@@@@@@@@@@@@@@@&//#%&&@@&&&&%%&&&&&&&&###%%%&@@
//@@@@@@@@@@@&&&%%%%%%%%%%%%%%&@@@@@@@@@&%%%#(#%#(#%%%%(#%#(#%%%%%&@&&&@@@@@@@@@@@@@@@@@@@&((#%%%&@@@&&%%((#%%%&&&&&&&&@@@
//@@@@@@@@@@@@&&&&&@@@&&%%%%&&&@@@@@@@@@@@@@&%%%%%#(((#%&@@@@@@@@@&%%&&@&@@@@@@@@@@@@@@@@&&&&&&&&%%%%&&&&(/////#%&&&&@@@@@
//@@@@@@@@@@@@&&&@&&&@@@@@&&&&@@@@@@@@@@&%%%/./%(.,*/(((#%%(#%%%%%%&&%%&&&&@@@@@@@@@@@@@&%%((****//#%%%&&&&/*////#%&&@@@@@
//@@@@@@@@&&%%&&&&%%%%&&&&&&&&&&@@@@@@@@&%%###%%%#######%%%#%%&&&&%%%%%&&&@@@@@@@@@@@@@@&&%##////#%(//((#&@#((((##%%%&&@@@
//@@@@@@&&((#%&&&&%%((%&%%%%%&&&&@@@@@&%%%%%%%#(/,,//(###(#%&@&%%%%%%%%&&&&%%@@@@@@@@@@&&((((**//#%%%//(/&&#(((((#%%%&&@@@
//@@@@&&&&((#%&&%%((/*%&#(##%&&&&&&&%%&@&%#(#%%%#(((((((#%%&%((((((%&&&&&%%%%%%%%&@@@@@@&&&&&&&(/#%%%%%(/&&/*////#%%%&@@@@
//@@@@#%&&//#%&&%%////%&#(##%&&&&@%%%%&@&%#(((#&%%%%%%%%%%%%#**((%&@&%%%#///(%%%%&@@@@@@@%%(//(**/(#%%%%%&&/*///(#%&@@@@@@
//@@@@#%&&/*#%&&%%/*#%%%((##%&&&&&%%((#&&&&%%%%%#((((######%%##&&@&&%##/////(%%&&%%&&@@@@@&&&&&%#((((#%&&&&#(((%%&&@@@@@@@
//@@@@&&%%/*%&&&%#//%&(/((##%&&&#(#%(/#&&&&&&%#(((((((/*/(((#%&@&%%%#////**#%&&%%((%%&@@@@@&&&&%%&&&&&&&&&&&&&&&@@@@@@@@@@
//@@@@&&%%((&&%#&&/*%&(/##%&&&&@(*(%((#%&&&&&%#((((((((((*(%&@@@&%#(//////(&&@&%#/(%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@&&%%&&((##/*##((%&%#@@&%(/#%/*/(%&&&&@&%#(((####((#%&@@&&%#////**%%&&%#(///((%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@%#&&((((###%##((##&@%%/*(%(//*#&&%&&&&%(((((((((#%&@&&&%#////**/(&%////**((##%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@%%%%((//###(((##%%&&#(/*(%(//*#@&%%%&&&&%#####%%%&&&&&&%%##//**((##////**(//(%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@&&%%((/*##/*((##%&%%((**(%/***#&&%%%%%%&@@&%%%%%%&&%%&&%%%#//**((##//******/(%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@&&%#((((##//((#%%&%%((**(%((*.(@&%%%%%%%%&@@&%%@&@&%&@&%%%#//**((%#(///**((%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@&&&&%%%%%%((((#%%&%%(/**(%/*,.(@&%#(#%%%&@&%&@&&&@&%&@&%%%#//**/(#%%#//**((%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@&&&&%%##((%&%%%%&&&&&&#/**(%(/,./%%%#(((#%&@&%%%%&&@&%&@&%%%#////**/(%#(///##%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@&@&&%#///(####%&&&%%((#%((/*(%%%#(((#%%%&@&%%&@@&%%@&%%%%%#//****/(%#/(%%%%&@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@&&&&%#((%&&&&&&&@@@@@&%%(/#%/***(%%%##((((#%&@&%%@@@@&&&%((%%%#//****((#%%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@&&((/***/(##%&&&&@%%((#%((/*(%%%#(#(((#%%%&@@@@@@@&%#((%%%%%#(/**((/(#%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@&&%%%%&&&&&&&&&&&&&@@@@&&%%%((/*/##%%##(((#%%%&@@@@@@@&%#(((#%#%#//****(//(%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@&&%%((//////((#%&&&@@@@@@&%%(/**/(#%%%#(#(#%%%&@@@@@@@@@&%#(((#%#(///**(//(%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@&&&&((//((((#%%&&@@@@@@@@&#/**/(#%%%#(#(#%%%&@@@@@@@@@&%#(((#%#(///**(//(%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@&&%#&&&&&&&&&&&@@@@@@@@@@&#((///#%%%#(#(#%%%&@@@@@@@@@&%#(((#%%%#(/((///(%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@%%((####%%&@@@@@@@@@@@@@&%%%#(#%%%#(#(#%%%&@@@@@@@@@@@%(((#%%%%%%%%%%%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%&&&&%%%%#(((#%%%&@@@@@@@@@@@%(((#%%&&%%%%%%&&&&%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%&&%%%%%%%%%%%%&@@@@@@@@@@@&%%%&@@&&((%%%%%%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%(/#%&&&&&%%%%%%%%%&@@@@@@@@@@@&%%@@&&(/((%%%%%%%%@&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%(/(##%&&&&&@@@@@@@@@@@@@@@@@@@@%%&&##//**##%%%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%/*//((#%&&&&&%%%%%&@@@@@@@@@@@@@&%%//****((%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%/*////#%%%%%%&&%%%%@@@@@@@@@@@@@&%#(/****((%%%%%%%%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%/*//////#%%%#(#&&%%%%&@@@@@@@@@&&%#(///****%%%%%%%%&&&&%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#(/*//#%%%#(///(#&&&&%%&@@@@@&&%%%%##((//**((%%%%&&&&&&%%&&&@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#//(##%##/**/(%#(#%%%%&&@@@@&&&&%#((%##(//((%%&&&%%%&&%%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(/#%%%(*/((%#///(%%%%&&&@@&%#((&&%%%%%%%#/(%%%#((%%&&%%&&%%&@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%(*/((%(**/(%%&&%%%%&%///(%%%#///(%%%%%%%#/(%%&&&&%%%%&@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%(/////(%(**((%%&&%%%%&%//**((&&/////(#%%%%#((%%%%&&%%&&@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%(///((%&#*/((%%&&%%%%&&((**//%#((((////##%#/(%%%%&&%%&@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%(///(%&&%/(#%%%&&%%%%&&%#//**(#&&&&##///(##/(%%%%&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%%%(*(%%&%((%%%%&&&&%%@@&&%#**/(&&((%#(//(%#/(%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%(*(%#(#&&%%%%%%&&&@@@@@@&%#((&&((%%%#/(%#((%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%(*(%#/(##%%%%%&&@@@@@@@@@@&%%&&%#/(##//##%%##%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%(/(%#///#%&&&&&@@@@@@@@@@@@@@@&&&##&&##((%#//#%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#/(%#/(%%%%%%@@@@@@@@@@@@@@@@@@@&%%&&%#/(%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#/(%#((%%%%%%@@@@@@@@@@@@@@@@@@@&%%%%&&((&&%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(/#%#/(%%%%%%&@@@@@@@@@@@@@@@@@@@@&%%&&%%&&%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#/#&%/(%%%%@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%%&&%%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#/#&%/(%%%%@@@@@@@@@@@@@@@@@@@@@@@@@&%%&&%%&@&&%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%&@&&&%%%%&%/(%%%%@@@@@@@@@@@@@@@@@@@@@@@@@&%%&&%%&&(/%%&&%%@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%&&&&&%%&%(#&&%%@@@@@@@@@@@@@@@@@@@@@@@@@&%%&&&&%%//#%&&%%@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%((#%&&&&&&&%%&&%%&@@@@@@@@@@@@@@@@@@@@@@@@&&&&%##//((%%%%&@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%((/*(%&&&&&%%&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@&&%%//#%%%((%%&&@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(//*//#%%&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@&%#((%%##(/(/%%&&&&@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%((/*/(#%&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&(//(##//**///(%%&&&@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%(/(%(//*/#%&&@&&@@@@@@@@@@@@@@@@@@@@@&&@&&&((%#////**////#%&&%%@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%/***(#(///(%%&&&&@&%%%%%%&@@@@@@@@@&&%%@&%%%%%%/(########%%&&&&&&@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%/*#&%%((/*(%#///#&&%%%%&&&&%%%%&@@@@@@@@@@&%%&&((%%%%%#(/////#%%%%%%%&@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@&@&%%%%%%/***/(%&%%%#(///#&&%#((%%%%&&%%@@@@@@@@@@@@@&&&%%%#//((((#%%%%%%#%%%%&&&&&@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@&&%%####(///((#%#((///#&%(((#%###(#%%%%%%&@@@@@@@@@@@@@@@@&%%%%%#((%%%%##**////////((#%&&&&@@@@@@@@@@@@@@@
//@@@@@@@@@@@&%%%%########((////%&%####%%%&&&%#/(%%%%%%&&&@@@@@@@@@@@@@@@@&&&%%%%&&%%((############((((#%&@@@@@@@@@@@@@@@@
//@@@@@@@@@@@&%%%%%%%%%%%%%%%%%%&@&&&@&&&&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@%%&&&&%%@&%%/(******((////////#%&@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@&&&&@@@@@@@@@&&&@@@@@@@@@@@@@@@@&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&%%%%%%%%%%%%%%%%%%&&%%&@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

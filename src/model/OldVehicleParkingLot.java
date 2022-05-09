package model;

/**
 * the parking lot where old vehicles end up
 */
public class OldVehicleParkingLot {

	/**
	 * the vehicles of the lot
	 */
	private Vehicle[][] vehicles;

	/**
	 * Builder
	 */
	public OldVehicleParkingLot() {
		vehicles = new Vehicle[10][5];
	}

	public int FindFirstemptyForLane(int lane){
		int index = -1;
		for (int counter=0; counter<10; counter++){
			if (vehicles[counter][lane]==null){
				index = counter;
			}
		}
		return index;
	}
	public void AddCar(int lane, int pos, Vehicle vehicle){
		vehicles[pos][lane] = vehicle;
	}

	public String toString(){
		String message = "  2015     2014     2013     2012     <2012   \n _______  _______  _______  _______  _______ \n";
		for (int counter=0; counter<10; counter++){
			for (int counter2=0; counter2<4; counter2++){
				for (int counter3=0; counter3<5; counter3++){
					if(vehicles[counter][counter3]==null){
						if(counter2!=3){
							message += "|       |";
						}
					}
					else if (vehicles[counter][counter3] instanceof Car){
						switch (counter2){
							case (0):
								message += "|  __   |";
								break;
							case(1):
								message += "|_|  |__|";
								break;
							case(2):
								message += "|-O---O-|";
								break;		
						}
						
					}
					else if (vehicles[counter][counter3] instanceof Motorcycle){
						switch (counter2){
							case (0):
								message += "|     _ |";
								break;
							case(1):
								message += "|   _ | |";
								break;
							case(2):
								message += "|  O--O |";
								break;		
						}
					}
					if (counter2==3){
						message += " ------- ";
					}
				}
				message += "\n";
			}
		}
		
		return message;
	}

}

/**
  2012  
 _______
|  __   |
|_|  |__|
|-O---O-|
 ------- 
|     _ |
|   _ | |
|  O--O |
 -------
|       |
|       |
|       |
 -------
*/
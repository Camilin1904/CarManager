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

	/**
	 * finds the first empty position for a given column
	 * @param lane
	 * @return the empty porsition index or -1 in case of none
	 */
	public int FindFirstemptyForLane(int lane){
		int index = -1;
		for (int counter=0; counter<10&&index==-1; counter++){
			if (vehicles[counter][lane]==null){
				index = counter;
			}
		}
		return index;
	}
	/**
	 * adds a car to a position in the matrix od the parking lot
	 * @param lane
	 * @param pos
	 * @param vehicle
	 */
	public void AddCar(int lane, int pos, Vehicle vehicle){
		vehicles[pos][lane] = vehicle;
	}

	/**
	 * toString(), creates a visual representationof the parking lot
	 * @return a visual representation of the parking lot
	 */
	public String toString(){
		String message = "  2015     2014     2013     2012     <2012   \n _______  _______  _______  _______  _______ \n";
		for (int counter=0; counter<10; counter++){//goes over the rows
			for (int counter2=0; counter2<4; counter2++){//goes over each individual line that is printed
				for (int counter3=0; counter3<5; counter3++){//goes over the columns
					if(vehicles[counter][counter3]==null){
						if(counter2!=3){//if its empty it draws it empty
							message += "|       |";
						}
					}
					else if (vehicles[counter][counter3] instanceof Car){//what to draw when there is a car
						switch (counter2){//checks whick line to draw depending on which ine it is on
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
					else if (vehicles[counter][counter3] instanceof Motorcycle){//what to draw when there is a bike
						switch (counter2){//checks whick line to draw depending on which ine it is on
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
					if (counter2==3){//what to draw when on the last line
						message += " ------- ";
					}
				}
				message += "\n";//skips over a line to continue
			}
		}
		
		return message;
	}

	/**
	 * calls all of the methods toString() for all of the member of a column
	 * @param lane
	 * @return
	 */
	public String allToStringLane(int lane){
		String message = "";
		for (int counter=0; counter<10; counter++){
			message += vehicles[counter][lane] + "\n";
		}
		return message;
	}

	/**
	 * how much of the parking lot is ocupied
	 * @return The percentage of ocupation
	 */
	public double OcupationPercentage(){
		int ocupation = 0, holder = 0;
		for (int counter=0; counter<5; counter++){
			holder = FindFirstemptyForLane(counter);
			if (holder<0){
				holder = 10;
			}
			ocupation += holder;
		}
		return (ocupation*100)/50;
	}

}

/**
  2012  
 _______
|  __   |
|_|  |__|vroom vroom motherfucker
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
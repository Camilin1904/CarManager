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

}
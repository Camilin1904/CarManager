package model;

/**
 * The Vehicles that use a Battery
 */
public interface BatteryBearer {

	/**
	 * Method to calculate the consumption of battery per kilometer
	 * @return
	 */
	double BatteryConsumption();

}
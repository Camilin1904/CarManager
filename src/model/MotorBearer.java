package model;
/**
 * Interface that dictates teh classes that consume gasoline by a motor
 */
public interface MotorBearer {

	/**
	 * calculates the consumption of gasoline of the cars that this aplies to.
	 */
	double gasolineConsumption();

	/**
	 * returns the fule type.
	 * @return
	 */
	FuelType getFuelType();

}
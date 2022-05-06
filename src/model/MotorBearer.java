package model;
/**
 * Interface that dictates teh classes that consume gasoline by a motor
 */
public interface MotorBearer {

	double GasolineConsumption();

	FuelType getFuelType();

}
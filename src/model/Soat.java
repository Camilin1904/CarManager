package model;
/**
 * The soat document
 */
public class Soat extends Document {

	/**
	 * The maximum value the soat would cover in case of an accident
	 */
	private double maxCoverageValue;

	/**
	 * Builder
	 * @param cost
	 * @param year
	 * @param maxCoverageValue
	 */
	public Soat(double cost, int year, double maxCoverageValue){
		super(cost, year);
		this.maxCoverageValue = maxCoverageValue;
	}

	/**
	 * Decodes the id of the image moving along the y axis until the end, the moving in teh x axis
	 */
	public String DecodeImage() {
		String sImage = "";
		for (int counter=0; counter<IMAGE_SIZE; counter++){
			sImage += image[counter][0];
		}
		for (int counter=1; counter<IMAGE_SIZE; counter++){
			sImage += image[IMAGE_SIZE-1][counter];
		}
		return sImage;
	}

	/**
	 * toString
	 */
	public String toString(){
		return super.toString() + "\nMAximum value covered: " +maxCoverageValue;//adds the exclusive atribute of soat to the toString() of Document
	}

}
package model;

/**
 * Technical mechanical revision
 */
public class Rtm extends Document {

	/**
	 * The gas levels the vehicle achieved in the Rtm
	 */
	private double gasLevels;

	/**
	 * Builder
	 * @param cost
	 * @param year
	 * @param gasLevels
	 */
	public Rtm(double cost, int year, double gasLevels){
		super(cost, year);
		this.gasLevels = gasLevels;
	}

	/**
	 * Decodes the image by moving along the x axis, then moves backwards on the x axis whilemoving forwards on the y axis, the movex along th x axis again
	 */
	public String DecodeImage() {
		String sImage = "";
		for (int counter=0; counter<IMAGE_SIZE; counter++){
			sImage += image[0][counter];
		}
		for (int counter=2; counter<=IMAGE_SIZE; counter++){
			sImage += image[counter][IMAGE_SIZE-counter];
		}
		for (int counter=1; counter<IMAGE_SIZE; counter++){
			sImage += image[0][counter];
		}
		return sImage;
	}

	@Override
	public String toString() {
		return super.toString() + "\nGas levels: " + gasLevels;
	}
}
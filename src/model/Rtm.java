package model;

public class Rtm extends Document {

	private double gasLevels;

	public Rtm(double cost, int year, double gasLevels){
		super(cost, year);
		this.gasLevels = gasLevels;
	}

	public String DecodeImage() {
		String sImage = "";
		for (int counter=0; counter<IMAGE_SIZE; counter++){
			sImage += image[0][counter];
		}
		for (int counter=2; counter<=IMAGE_SIZE; counter++){
			sImage += image[IMAGE_SIZE-counter][IMAGE_SIZE-counter];
		}
		for (int counter=1; counter<IMAGE_SIZE; counter++){
			sImage += image[0][counter];
		}
		return sImage;
	}

}
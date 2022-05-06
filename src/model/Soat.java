package model;

public class Soat extends Document {

	private double maxCoverageValue;

	public Soat(double cost, int year, double maxCoverageValue){
		super(cost, year);
		this.maxCoverageValue = maxCoverageValue;
	}

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

}
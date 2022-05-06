package model;

public abstract class Document {

	private double cost;
	private int year;
	protected int[][] image;
	protected final int IMAGE_SIZE = 5;

	public abstract String DecodeImage();

	/**
	 * 
	 * @param cost
	 * @param year
	 * @param image
	 */
	public Document(double cost, int year) {
		this.cost = cost;
		this.year = year;
		image = new int[IMAGE_SIZE][IMAGE_SIZE];
		for (int counter=0; counter<IMAGE_SIZE; counter++){
			for (int counter2=0; counter2<IMAGE_SIZE; counter2++){
				image[counter][counter2] = (int)(Math.random()*(10));	
			}
		}
	}

	public int getYear() {
		return year;
	}

}
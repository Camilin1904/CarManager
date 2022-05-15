package model;

/**
 * The Documnets of the vehicle
 */
public abstract class Document {

	/**
	 * The cost of the document
	 */
	private double cost;
	/**
	 * The year in which it was created
	 */
	private int year;
	/**
	 * The image from which the id will be decoded
	 */
	protected int[][] image;
	/**
	 * teh dimensions of teh square shape image
	 */
	protected final int IMAGE_SIZE = 5;

	/**
	 * Method in charge of decoding tha id from the image
	 * @return Id
	 */
	public abstract String DecodeImage();

	/**
	 * Builder
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

	/**
	 * Fetches the year of production
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * to String
	 */
	public String toString(){
		return "\nID: " + DecodeImage() +"\nCost: " + cost + "\nYear: " + year;
	}

}
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
	public abstract String decodeImage();

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
		return "\n ID: " + decodeImage() +"\n Cost: " + cost + "\n Year: " + year;
	}

	/**
	 * Method used to print a numeric matrix, currently unused
	 * @param numbers
	 * @return a String with the matrix
	 */
	public String printNumeric(int[][] numbers) {
		String print ="";
		for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
			for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
				print += numbers[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}

}
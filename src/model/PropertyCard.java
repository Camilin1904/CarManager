package model;

/**
 * The property card
 */
public class PropertyCard extends Document {
    /**
     * Builder
     * @param cost
     * @param year
     */
    public PropertyCard(double cost, int year){
        super(cost, year);
    }

    /**
     * Decodes the image by only picking the values on the cells that the sum of x and y are a pair number and not 0, going from top to bottom, from right to left
     */
    @Override
    public String decodeImage() {
        String sImage = "";
        for (int counter=1; counter<=IMAGE_SIZE; counter++){
            for (int counter2=1; counter2<=IMAGE_SIZE; counter2++){
                if((IMAGE_SIZE-counter+IMAGE_SIZE-counter2)%2==0&&(IMAGE_SIZE-counter+IMAGE_SIZE-counter2)!=0){
                    sImage += image[IMAGE_SIZE-counter][IMAGE_SIZE-counter2];
                }
            }
        }
        return sImage;
    }
}
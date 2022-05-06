package model;

public class PropertyCard extends Document {
    public PropertyCard(double cost, int year){
        super(cost, year);
    }

    @Override
    public String DecodeImage() {
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
package exercisesolutions_customerreview;

@SuppressWarnings("serial")
public class IncorrectRatingException extends Exception {
    public IncorrectRatingException(String err) {
    	super(err);
    }
}

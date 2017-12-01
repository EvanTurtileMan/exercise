package exercisesolutions_customerreview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import de.hybris.platform.customerreview.jalo.CustomerReviewManager;
import de.hybris.platform.customerreview.jalo.CustomerReview;
import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants.TC;

public class CustomerReviewCreation {
    CustomerReviewManager crm;
    ArrayList<String> curseWords = new ArrayList<>();

    public void loadCurseWords(String pathFile) throws FileNotFoundException {
    	File curseWordsFile = new File(pathFile);
    	Scanner inputScan = new Scanner(curseWordsFile);

    	/* I assume there would be a curse words file that has a curse word
    	 * on each line as opposed to being separated by spaces or commas. */
    	while(inputScan.hasNext()) {
    		curseWords.add(inputScan.nextLine());
    	}
    }

    public void createComment(Double rating, String headline, String comment, User user, Product product) {
    	if(checkContent(headline, comment)) {
    		if(checkRating(rating)) {
    			crm.createCustomerReview(rating, headline, comment, user, product);
    		} else {
    			throw new IncorrectRatingException("Rating must be greater than or equal to 0. Must not be less than 0.");
    		}
    	}

    	throw new CurseWordException("Cannot use curse words in comment.");
    }

    public boolean checkContent(String headline, String comment) {
    	String[] headlineArray = headline.split(" ");
    	String[] commentArray = comment.split(" ");

    	// Check both arrays to see if it contains swear words
    	for(int i = 0; i < headlineArray.length; i++) {
    		if(curseWords.contains(headlineArray[i])) {
    			return false;
    		}
    	}
   
    	for(int i = 0; i < commentArray.length; i++) {
    		if(curseWords.contains(commentArray[i])) {
    			return false;
    		}
    	}

    	return true;
    }

    public boolean checkRating(Double rating) {
    	return rating >= 0;
    }
}

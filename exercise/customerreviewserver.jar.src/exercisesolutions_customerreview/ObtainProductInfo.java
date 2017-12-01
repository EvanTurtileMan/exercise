package exercisesolutions_customerreview;

import java.util.ArrayList;
import java.util.Collection;

import de.hybris.platform.customerreview.constants.CustomerReviewConstants;
import de.hybris.platform.customerreview.jalo.CustomerReview;
import de.hybris.platform.customerreview.jalo.GeneratedCustomerReviewManager;

public class ObtainProductInfo {
    GeneratedCustomerReviewManager gcrm;
    ArrayList<CustomerReview> listOfCustomerReviews;

    public Integer totNumOfReviewsOnProduct(User product) {
    	listOfCustomerReviews = loadReviews(product);

    	int numOfInclusiveCustomerReviews = 0;
    	for(CustomerReview cr : listOfCustomerReviews) {
    		if(cr.getRating() <= CustomerReviewConstants.getInstance().MAXRATING &&
    				cr.getRating() >= CustomerReviewConstants.getInstance().MINRATING) {
    			numOfInclusiveCustomerReviews++;
    		}
    	}
    	return new Integer(numOfInclusiveCustomerReviews);
    }

    Collection<CustomerReview> loadReviews(User item) {
    	return gcrm.getCustomerReviews(item);
    }

    
}

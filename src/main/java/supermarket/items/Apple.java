package supermarket.items;

import supermarket.offers.BuyOneGetOneFree;
import supermarket.offers.OffersFactory;

public class Apple extends AbstractItem {

    static {
        OffersFactory.registerNewOffer(Apple.class, new BuyOneGetOneFree());
    }
    
	/**
	 * When we construct a new apple object before adding it to the basket we dont want client to be able to set the price.
	 *  
	 * Perhaps we want to sync the latest price from the underlying floating pricing service etc.
	 */
	public Apple() {
		super(0.2);
	}

}

package supermarket.offers;

import supermarket.pricing.Utils;

public class BuyOneGetOneFree extends AbstractSpecialOffer {

	public BuyOneGetOneFree() {
		super();
	}

	@Override
	public double price(int numberOfItems, double itemPrice) {
		
		validatePrice(itemPrice);
		
		if (numberOfItems <= 0) {
			return 0;
		}
		
		int discountedNo = numberOfItems / 2;
		int remaining = numberOfItems % 2;
        
		return Utils.round (discountedNo*itemPrice + remaining*itemPrice, 2);
	}

}

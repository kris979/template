package supermarket.offers;

import supermarket.pricing.Utils;

public class BuyTwoGetOneFree extends AbstractSpecialOffer {

	public BuyTwoGetOneFree() {
		super();
	}

	@Override
	public double price(int numberOfItems, double itemPrice) {
		
		validatePrice(itemPrice);
		
		if (numberOfItems <= 0) {
			return 0;
		}
		
		int discountedNo = numberOfItems / 3;
		int remaining = numberOfItems % 3;
		
		return Utils.round(discountedNo*(itemPrice*2) + remaining*itemPrice, 2);
	}

}

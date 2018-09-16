package supermarket.items;

import supermarket.offers.BuyTwoGetOneFree;
import supermarket.offers.OffersFactory;

public class Watermelon extends AbstractItem {

	static {
		OffersFactory.registerNewOffer(Watermelon.class, new BuyTwoGetOneFree());
	}

	public Watermelon() {
		super(0.8);
	}

}

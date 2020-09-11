package interviews.supermarket.items;

import interviews.supermarket.offers.BuyTwoGetOneFree;
import interviews.supermarket.offers.OffersFactory;

public class Watermelon extends AbstractItem {

	static {
		OffersFactory.registerNewOffer(Watermelon.class, new BuyTwoGetOneFree());
	}

	public Watermelon() {
		super(0.8);
	}

}

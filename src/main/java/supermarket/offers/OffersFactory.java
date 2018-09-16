package supermarket.offers;

import java.util.HashMap;
import java.util.Map;

import supermarket.items.Item;

public class OffersFactory {
	
	private static Map<Class<? extends Item>, SpecialOffer> offers = new HashMap<>();
	
	public static void registerNewOffer(Class<? extends Item> itemType, SpecialOffer instance) {
		offers.put(itemType, instance);
	}
	  
	public static SpecialOffer getSpecialOffer(Class<? extends Item> itemType) {
		return offers.get(itemType);
	}

}

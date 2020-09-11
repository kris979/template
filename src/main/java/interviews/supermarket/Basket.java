package interviews.supermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import interviews.supermarket.items.Apple;
import interviews.supermarket.items.Item;
import interviews.supermarket.items.Orange;
import interviews.supermarket.items.Watermelon;
import interviews.supermarket.offers.OffersFactory;
import interviews.supermarket.offers.SpecialOffer;
import interviews.supermarket.pricing.Utils;

/**
 * 
 * In real life we could introduce Checkout, PricingService and move basket pricing there. 
 * It would be more cohesive that way.
 *  
 * PricingService could use different pricing strategies (i.e. based on a time of a year) 
 * where you could turn on/off certain offers etc.
 *
 * There is no conditional logic. Code is Open for extension, Closed for modification.
 * 
 * We just need to create new Item, new SpecialOffer and link them via OffersFactory registration.
 * 
 * Having multiple special offers per item type also would not be a problem.  
 * 
 * I hope it makes sense. 
 * 
 * The last thing I wanted to do was if (item instanceof Apple.class) else if
 *  
 */
public class Basket {

	private Map<Class<? extends Item>, List<Item>> basket = new HashMap<>();
	
	public void add(Class<? extends Item> itemType, Item item) {
		List<Item> items = basket.get(itemType);
		if (items == null) {
			items = new ArrayList<>();
			items.add(item);
		} else {
			items.add(item);
		}
		basket.put(itemType, items);
		 
		
	}
	
	
	public double price() {
		double priceToPay = 0;
		Set<Entry<Class<? extends Item>, List<Item>>> entrySet = basket.entrySet();
		for (Entry<Class<? extends Item>, List<Item>> entry : entrySet) {
			double price = calculate(entry);
			priceToPay+=price;
		}
		return Utils.round(priceToPay, 2);
	}
	
	
	private double calculate(Entry<Class<? extends Item>, List<Item>> entry) {
		double price;
		SpecialOffer specialOffer = OffersFactory.getSpecialOffer(entry.getKey());
		List<Item> items = entry.getValue();
		if (specialOffer == null) {
			price = items.size()*items.get(0).getPrice();
		} else {
			price = specialOffer.price(items.size(), items.get(0).getPrice());
		}
		return price;
	}
	
	
	/**
	 * Added for reviewer convenience.
	 */
	public static void main(String[] args) {
		Apple apple = new Apple();
		Orange orange = new Orange();
		Watermelon watermelon = new Watermelon();
		Basket basket = new Basket();
		
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		
		double price = basket.price();
		System.out.println("Cost of apples: " + price);
		
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		price = basket.price();
		System.out.println("Cost of apples,oranges: " + price);
		
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		price = basket.price();
		System.out.println("Cost of apples,oranges and watermelons: " + price);
	}

}

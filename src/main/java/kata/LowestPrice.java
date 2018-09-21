package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * “There is a shop, where vendors sell items. They all sell same item but they
 * can change the price of the item during the day. Given intervals of time and
 * a lower price for the item during this interval for each vendor, calculate
 * the cheapest price for the item during the day within different time
 * intervals. Input data for each vendor is {startTime, endTime, price}. For
 * example for 3 vendors in the shop: [{0, 4, 5}, {2, 8, 3}, {7, 11, 10}], the
 * result should be [{0, 2, 5}, {2, 8, 3}, {8, 11, 10}]”
 *
 */
public class LowestPrice {

	class Vendor {

		public int start;
		public int end;
		public int price;

		public Vendor(int start, int end, int price) {
			super();
			this.start = start;
			this.end = end;
			this.price = price;
		}

		boolean isValid(int[] slot) {
			if (start <= slot[0] && end >= slot[1]) {
				return true;
			} else {
				return false;
			}
		}
	}

	private List<Vendor> vendors = new ArrayList<>();

	//key = 1h slot, value = prices from all vendors for that slot
	private Map<Integer, Set<Integer>> slots = new HashMap<Integer, Set<Integer>>();

	public LowestPrice() {
		vendors.add(new Vendor(0, 4, 5));
		vendors.add(new Vendor(2, 8, 3));
		vendors.add(new Vendor(7, 11, 10));
		prepareSlots();
	}

	private void prepareSlots() {
		for (int i = 0; i < 24; i++) {
			slots.put(i, new HashSet<>());
		}

		for (Vendor vendor : vendors) {
			for (int i = vendor.start; i < vendor.end; i++) {
				Set<Integer> prices = slots.get(i);
				if (prices == null) {
					HashSet<Integer> newPrices = new HashSet<Integer>();
					newPrices.add(vendor.price);
					prices = newPrices;
				} else {
					prices.add(vendor.price);
				}
				slots.put(i, prices);
			}
		}
	}
	
	public final Map<Integer, Set<Integer>> getSlots() {
		return slots;
	}

	int getLowestPrice(int[] inputSlot) {
		int lowestPrice = -1;
		int start = inputSlot[0];
		int end = inputSlot[1];

		int requiredCount = end - start; //price must be valid for the whole duration of the slot
		
		//key - price, value - count
		Map<Integer,Integer> priceCounters = new HashMap<>();

		//go through each slot and count prices
		for (int i = start; i < end; i++) {
			Set<Integer> prices = slots.get(i);
			for (Integer price : prices) {
				Integer counter = priceCounters.get(price);
				if (counter != null) {
					priceCounters.put(price, ++counter);
				} else {
					priceCounters.put(price, 1);
				}
			}
		}
		
		Set<Entry<Integer, Integer>> entrySet = priceCounters.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() == requiredCount) {
				return entry.getKey();
			}
		}
		
		return lowestPrice;
	}
	
	public static void main(String[] args) {
		LowestPrice lp = new LowestPrice();
		System.out.println(lp.getLowestPrice(new int[] {4,6}));
	}


}

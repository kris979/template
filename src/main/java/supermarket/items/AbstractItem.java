package supermarket.items;

public abstract class AbstractItem implements Item {
	
	private final double price;

	public AbstractItem(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

}

package supermarket.offers;

abstract class AbstractSpecialOffer implements SpecialOffer {

	protected void validatePrice(double itemPrice) {
		if (itemPrice < 0.0) {
			throw new IllegalArgumentException("price can not be < 0.");
		}
	}
	
}

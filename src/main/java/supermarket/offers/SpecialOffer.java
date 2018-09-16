package supermarket.offers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface SpecialOffer {

	double price(int numberOfItems, double itemPrice);

}

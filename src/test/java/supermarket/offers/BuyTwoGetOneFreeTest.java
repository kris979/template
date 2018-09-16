package supermarket.offers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import supermarket.pricing.Utils;

public class BuyTwoGetOneFreeTest {

	private BuyTwoGetOneFree offer = new BuyTwoGetOneFree();
	private double price = 0.2;

	@Test
	public void testWhenBuyingTwoWeStillPayForTwo() {
		double total = offer.price(2, price);
		assertThat(total, is(equalTo(price*2)));
	}
	
	@Test
	public void testThatWhenBuyingNothingWePayNothing() {
		double total = offer.price(0, price);
		assertThat(total, is(equalTo(0.0)));
	}

	@Test
	public void testThatWhenWeBuyOneItemWePayForOne() {
		double total = offer.price(1, price);
		assertThat(total, is(equalTo(price)));
	}
	
	@Test
	public void testThatWhenWeBuyThreeWePayForTwo() {
		double total = offer.price(3, price);
		assertThat(total, is(equalTo(price*2)));
	}
	
	@Test
	public void testThatWhenWeBuyFourWePayForThree() {
		double total = offer.price(4, price);
		assertThat(total, is(equalTo(Utils.round(price*3,2))));
	}
	
	@Test
	public void testThatWhenWeBuyForFreeWeDontPay() {
		double total = offer.price(100, 0.0);
		assertThat(total, is(equalTo(0.0)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testThatPriceCantBeNegative() { //we dont want to go out of business :)
		offer.price(100, -0.4);
	}

}

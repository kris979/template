package interviews.supermarket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import interviews.supermarket.items.Apple;
import interviews.supermarket.items.Orange;
import interviews.supermarket.items.Watermelon;

public class BasketTest {
	
	private Apple apple = new Apple();
	private Orange orange = new Orange();
	private Watermelon watermelon = new Watermelon();
	
	@Test
	public void testThatWeDontNeedToPayForEmptyBasket() {
		Basket basket = new Basket();
		double price = basket.price();
		assertThat(price, is(equalTo(0.0)));
	}

	@Test
	public void testBasketWithFourApples() {
		Basket basket = new Basket();
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		double price = basket.price();
		assertThat(price, is(equalTo(0.4)));
	}

	@Test
	public void testBasketWithThreeOranges() {
		Basket basket = new Basket();
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		double price = basket.price();
		assertThat(price, is(equalTo(1.5)));
	}
	
	@Test
	public void testBasketWithSixWatermelons() {
		Basket basket = new Basket();
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		double price = basket.price();
		assertThat(price, is(equalTo(3.2)));
	}
	
	@Test
	public void testRequestedBasket() {
		Basket basket = new Basket();
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Apple.class, apple);
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		basket.add(Orange.class, orange);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		basket.add(Watermelon.class, watermelon);
		double price = basket.price();
		assertThat(price, is(equalTo(0.4+ 1.5 + 3.2)));
	}
	
}

package supermarket.items;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class AppleTest {
	
	private Apple apple = new Apple();

	@Test
	public void test() {
		assertThat(apple.getPrice(), is(equalTo(0.2)));
	}

}

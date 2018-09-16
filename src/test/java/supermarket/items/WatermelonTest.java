package supermarket.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class WatermelonTest {

	private Watermelon watermelon = new Watermelon();

	@Test
	public void test() {
		assertThat(watermelon.getPrice(), is(equalTo(0.8)));
	}

}

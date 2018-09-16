package supermarket.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class OrangeTest {

	private Orange orange = new Orange();

	@Test
	public void test() {
		assertThat(orange.getPrice(), is(equalTo(0.5)));
	}

}

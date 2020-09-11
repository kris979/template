package challanges.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void evaluate() {
        assertThat(calculator.evaluate(2, 3, '+'), is(5L));
        assertThat(calculator.evaluate(10, 3, '-'), is(7L));
        assertThat(calculator.evaluate(10, 3, '*'), is(30L));
        assertThat(calculator.evaluate(30, 3, '/'), is(10L));
//        assertThat(challanges.calculator.evaluate("2+3")), is(5L));
    }

    @Test
    void split() {
        assertThat(calculator.convert("2 + 3"), hasItem("2"));
        assertThat(calculator.convert("2+3"), hasItem("3"));
        List<String> split = calculator.convert("2 + 3 ");
        System.out.println(split);
        System.out.println(split.size());
    }
}
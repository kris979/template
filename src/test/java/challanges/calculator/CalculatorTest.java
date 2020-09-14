package challanges.calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void evaluate() {
        assertThat(calculator.calc(2, 3, "+"), is(5L));
        assertThat(calculator.calc(10, 3, "-"), is(7L));
        assertThat(calculator.calc(10, 3, "*"), is(30L));
        assertThat(calculator.calc(30, 3, "/"), is(10L));
        assertThat(calculator.calc("2+3"), is("5"));
        assertThat(calculator.calc("(2+3)"), is("5"));
        assertThat(calculator.calc("(2+3)*4"), is("20"));
        assertThat(calculator.calc("(2+3)*4-2"), is("18"));
        assertThat(calculator.calc("(2+3)+(1+5)"), is("11"));
    }

    @Test
    void split() {
        List<String> convert = calculator.splitAndTrim("2 + 3");
        assertThat(convert, hasItems("2", "3"));
        assertThat(convert.size(), is(3));
        convert = calculator.splitAndTrim("2+3");
        assertThat(convert, hasItems("2", "3"));
        assertThat(convert.size(), is(3));
        convert = calculator.splitAndTrim("2 +3");
        assertThat(convert, hasItems("2", "3"));
        assertThat(convert.size(), is(3));
    }

    @Test
    void rearrange() {
        List<String> cmd = Arrays.asList("2", "+", "3");
        assertThat(calculator.rearrange(cmd), contains("2", "3", "+"));
        List<String> cmd1 = Arrays.asList("2", "-", "3");
        assertThat(calculator.rearrange(cmd1), contains("2", "3", "-"));
        List<String> cmd2 = Arrays.asList("(","2", "+", "3",")");
        assertThat(calculator.rearrange(cmd2), contains("(","2","3","+",")"));
        List<String> cmd3 = Arrays.asList("(","2", "+", "3",")","-","1");
        assertThat(calculator.rearrange(cmd3), contains("(","2","3","+",")","1","-"));
        List<String> cmd4 = Arrays.asList("(","2", "+", "3",")","*","5","+","2");
        assertThat(calculator.rearrange(cmd4), contains("(","2","3","+",")","5","*","2","+"));
        List<String> cmd5 = Arrays.asList("(","2", "+", "3",")","+","(","5","*","2",")");
        assertThat(calculator.rearrange(cmd5), contains("(","2","3","+",")","(","5","2","*",")","+"));
    }

}
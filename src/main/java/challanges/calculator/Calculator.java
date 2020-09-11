package challanges.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public long evaluate(final long leftOperand,final long rightOperand,final Character operator) {
        long result = 0;
        switch (operator) {
            case '+': {
                result = leftOperand + rightOperand;
            } break;
            case '-': {
                result = leftOperand - rightOperand;
            }break;
            case '*': {
                result = leftOperand * rightOperand;
            }break;
            case '/': {
                result = leftOperand / rightOperand;
            }break;
        }
        return result;
    }


    public List<String> convert(final String exp) {
        String[] chars = exp.split("");
        List<String> result = Arrays.stream(chars)
                                     .filter(aChar -> !aChar.equalsIgnoreCase(" "))
                                     .map(aChar -> aChar.trim())
                                     .collect(
                                             Collectors.toList());
        return result;
    }
}

package challanges.calculator;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {

    private static Set<String> operators = new HashSet<>();

    static {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }

    public long calc(final long leftOperand, final long rightOperand, final String operator) {
        long result = 0;
        switch (operator) {
            case "+": {
                result = leftOperand + rightOperand;
            }
            break;
            case "-": {
                result = leftOperand - rightOperand;
            }
            break;
            case "*": {
                result = leftOperand * rightOperand;
            }
            break;
            case "/": {
                result = leftOperand / rightOperand;
            }
            break;
        }
        return result;
    }

    public List<String> splitAndTrim(final String exp) {
        String[] chars = exp.split("");
        List<String> result = Arrays.stream(chars)
                                    .filter(aChar -> !aChar.equalsIgnoreCase(" "))
                                    .map(aChar -> aChar.trim())
                                    .collect(
                                            Collectors.toList());
        return result;
    }

    public String calc(final String input) {

        final List<String> exp = splitAndTrim(input);

        //rearrange expression with operator on the end i.e. 2 3 + instead of 2 + 3
        final List<String> postFixExp = rearrange(exp);

        System.out.println(postFixExp);

        //evaluate expression
        Stack<String> stack = new Stack<>();
        for (String s : postFixExp) {
            if (isClosingBracket(s)) {
                //ignore it
            } else if (isOperator(s)) {
                String rightOperand = stack.pop();
                String leftOperand = stack.pop();
                if (!stack.empty() && stack.peek()
                                           .equals("(")) {
                    stack.pop();
                }
                stack.push(Long.toString(calc(Long.parseLong(leftOperand), Long.parseLong(rightOperand), s)));
            } else {
                stack.push(s);
            }
        }
        return stack.pop();
    }

    private boolean isClosingBracket(final String s) {
        return s.equalsIgnoreCase(")");
    }

    private boolean isOpeningBracket(final String s) {
        return s.equalsIgnoreCase("(");
    }

    public List<String> rearrange(final List<String> expression) {

        LinkedList<String> rearranged = new LinkedList<>();

        String previous = null;
        String mem = null;

        for (int i = 0; i < expression.size(); i++) {
            String current = expression.get(i);
            if (isDigit(current) && isOperator(previous)) {
                String last = rearranged.removeLast();
                rearranged.addLast(current);
                rearranged.addLast(last);
            } else if (isOpeningBracket(current) && isOperator(previous)) {
                mem = previous;
                rearranged.set(i - 1, current);
            } else if (isClosingBracket(current)) {
                rearranged.add(current);
                if (mem != null) {
                    rearranged.add(mem);
                    mem = null;
                }
            } else {
                rearranged.add(current);
            }
            previous = current;
        }
        return rearranged;
    }

    private boolean isDigit(final String operand) {
        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isOperator(final String input) {
        return operators.contains(input);
    }
}

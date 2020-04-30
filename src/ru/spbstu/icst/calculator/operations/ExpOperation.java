package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.calculator.OperationFactory;
import ru.spbstu.icst.exceptions.ExecutionExceptions;
import ru.spbstu.icst.exceptions.MainExceptions;

import java.util.Map;

public class ExpOperation extends Operation {

    private String exp;
    private Map<String, Double> table;

    public ExpOperation(String exp) {
        this.exp = exp;
    }

    public void execute(ExecutionContext context) throws MainExceptions {
        table = context.getTable();
        try {
            calculateExpression(convertToRPN(), context);
        } catch (MainExceptions ex) {
            throw ex;
        }
    }

    private String convertToRPN() {

        java.util.Stack<Character> stack = new java.util.Stack<>();
        String rpn = "";

        if (!exp.startsWith("(") || !exp.endsWith(")")) {
            exp = "(" + exp + ")";
        }

            for (int i = 0; i < exp.length(); ++i) {
                Character chr = exp.charAt(i);
                if (chr >= '0' && chr <= '9' || table.containsKey(String.valueOf(chr))) {
                    rpn += chr;
                } else if (stack.empty()) {
                    stack.push(chr);
                } else {
                    switch (chr) {
                        case '(':
                            stack.push(chr);
                            break;
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            while (stack.peek() != '(') {
                                rpn += chr;
                                stack.pop();
                            }
                            stack.push(chr);
                            break;
                        case ')':
                            while (stack.peek() != '(') {
                                rpn += stack.pop();
                            }
                            stack.pop();
                        default:
                            break;
                    }
                }
            }
        return rpn;
    }

    private void calculateExpression(String input, ExecutionContext context) throws MainExceptions {
        char next;

        while(!input.isEmpty()) {
            next = input.charAt(0);

            try {
                if (next >= '0' && next <= '9' || table.containsKey(String.valueOf(next))) {
                    new PushOperation(String.valueOf(next)).execute(context);
                    input = input.substring(1);
                } else {
                    input = input.substring(1);
                    context.getFactory().create(String.valueOf(next)).execute(context);
                }
            } catch (MainExceptions ex) {
                throw ex;
            }
        }
    }
}

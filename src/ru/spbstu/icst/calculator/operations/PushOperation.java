package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.collection.ArrayStack;
import java.util.Map;

public class PushOperation extends Operation {

    private String input;

    public PushOperation(String input) {
        this.input = input;
    }

    public void execute(ExecutionContext context) {
        ArrayStack stack = context.getStack();
        Map<String, Double> table = context.getTable();

        if (table.containsKey(input)) {
            stack.push(table.get(input));
        } else {
            stack.push(Double.valueOf(input));
        }
    }
}

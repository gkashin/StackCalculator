package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.collection.ArrayStack;
import ru.spbstu.icst.exceptions.ExecutionExceptions;

public class MultiplyOperation extends Operation {

    public void execute(ExecutionContext context) throws ExecutionExceptions {

        ArrayStack stack = context.getStack();
        try {
            Double product = stack.pop() * stack.pop();
            stack.push(product);
        } catch (ExecutionExceptions ex) {
            throw ex;
        }
    }
}

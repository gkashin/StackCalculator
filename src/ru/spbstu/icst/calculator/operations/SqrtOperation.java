package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.collection.ArrayStack;
import ru.spbstu.icst.exceptions.ExecutionExceptions;

public class SqrtOperation extends Operation {

    public void execute(ExecutionContext context) throws ExecutionExceptions {
        ArrayStack stack = context.getStack();
        try {
            Double sqrt = Math.sqrt(stack.pop());
            stack.push(sqrt);
        } catch (ExecutionExceptions ex) {
            throw ex;
        }
    }
}

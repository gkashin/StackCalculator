package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.collection.ArrayStack;
import ru.spbstu.icst.exceptions.ExecutionExceptions;

public class DivideOperation extends Operation {

    public void execute(ExecutionContext context) throws ExecutionExceptions {

        ArrayStack stack = context.getStack();
        try {
            Double first = stack.pop();
            Double second = stack.pop();
            Double quotient = second / first;
            stack.push(quotient);
        } catch (ExecutionExceptions ex) {
            throw ex;
        }
    }
}

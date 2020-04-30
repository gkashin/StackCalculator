package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;

public class PrintOperation extends Operation {

    public void execute(ExecutionContext context) {
        System.out.println(context.getStack().peek());
    }
}

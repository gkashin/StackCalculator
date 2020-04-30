package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.exceptions.ExecutionExceptions;
import ru.spbstu.icst.exceptions.MainExceptions;

public class PopOperation extends Operation {

    public void execute(ExecutionContext context) throws ExecutionExceptions {

        context.getStack().pop();

    }
}

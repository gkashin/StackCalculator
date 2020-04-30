package ru.spbstu.icst.calculator;

import ru.spbstu.icst.collection.ArrayStack;
import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {

    private OperationFactory factory = new OperationFactoryImplementation();

    private final ArrayStack stack = new ArrayStack();
    private final Map<String, Double> table = new HashMap<>();

    public ArrayStack getStack() {
        return stack;
    }

    public Map<String, Double> getTable() {
        return table;
    }

    public OperationFactory getFactory() {
        return factory;
    }
}

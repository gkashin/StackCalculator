package ru.spbstu.icst.calculator.operations;

import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import java.util.Map;

public class DefineOperation extends Operation {

    private String alias;
    private Double number;

    public DefineOperation(String alias, String number) {
        this.alias = alias;
        this.number = Double.valueOf(number);
    }

    @Override
    public void execute(ExecutionContext context) {

        Map<String, Double> table = context.getTable();
        table.put(alias, number);
    }
}

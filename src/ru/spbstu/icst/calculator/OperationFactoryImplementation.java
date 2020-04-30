package ru.spbstu.icst.calculator;

import ru.spbstu.icst.calculator.operations.*;
import ru.spbstu.icst.exceptions.SyntaxExceptions;

public class OperationFactoryImplementation implements OperationFactory {

    @Override
    public Operation create(String input) throws SyntaxExceptions {

        String[] components = input.split(" ");

        switch (components[0]) {
            case "PUSH":
                if (true/*isNumeric(components[1])*/) {
                    return new PushOperation(components[1]);
                }
            case "POP":
                return new PopOperation();
            case "+":
                return new PlusOperation();
            case "-":
                return new MinusOperation();
            case "*":
                return new MultiplyOperation();
            case "/":
                return new DivideOperation();
            case "SQRT":
                return new SqrtOperation();
            case "PRINT":
                return new PrintOperation();
            case "DEFINE":
                return new DefineOperation(components[1], components[2]);
            case "EXP":
                return new ExpOperation(components[1]);
            default:
                throw new SyntaxExceptions("Operation is not found");
        }

//        Pattern pushRegExp = Pattern.compile("PUSH.*");
//        if (pushRegExp.matcher(input).find()) {
//
//        }
    }
}

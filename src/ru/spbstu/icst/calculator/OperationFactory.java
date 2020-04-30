package ru.spbstu.icst.calculator;

import ru.spbstu.icst.exceptions.SyntaxExceptions;

public interface OperationFactory {

    Operation create(String input) throws SyntaxExceptions;
}

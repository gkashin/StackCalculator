package ru.spbstu.icst.collection;

import ru.spbstu.icst.exceptions.ExecutionExceptions;
import ru.spbstu.icst.exceptions.MainExceptions;
import java.util.Iterator;

public class ArrayStack implements Iterable<Double> {

    private Double[] list = new Double[]{};
    private int top = -1;

    public ArrayStack() {}

    public void push(Double x) {
        if (top == list.length - 1) {
            Double[] tmpList = new Double[list.length + 1];
            System.arraycopy(list, 0, tmpList, 0, list.length);
            tmpList[top + 1] = x;
            list = tmpList;
        } else {
            list[top + 1] = x;
        }
        top++;
    }

    public Double pop() throws ExecutionExceptions {
        if (top == -1) {
            throw new ExecutionExceptions("Stack underflow");
        }
        return list[top--];
    }

    public Double peek() {
        return list[top];
    }

    public boolean empty() {
        return top == -1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = top; i > 0; --i) {
            builder.append(list[i]);
            if (i != 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < list.length;
            }

            @Override
            public Double next() {
                return list[index++];
            }
        };
    }
}
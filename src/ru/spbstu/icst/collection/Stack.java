package ru.spbstu.icst.collection;

import ru.spbstu.icst.exceptions.ExecutionExceptions;

public interface Stack<T> extends Iterable<T>{
    public void push(T x);

    default void addAll(Iterable<? extends T> otherStack) {
        for (T e : otherStack) {
            push(e);
        }
    }

    public T pop() throws ExecutionExceptions;

    public T peek();

    public boolean empty();
}

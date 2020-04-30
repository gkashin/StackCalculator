package ru.spbstu.icst.exceptions;

public class MainExceptions extends Exception {

    public String description;

    public MainExceptions(String description) {
        this.description = description;
    }
}

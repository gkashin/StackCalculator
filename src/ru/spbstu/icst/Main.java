package ru.spbstu.icst;

import ru.spbstu.icst.calculator.*;
import ru.spbstu.icst.exceptions.ExecutionExceptions;
import ru.spbstu.icst.exceptions.MainExceptions;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            FileHandler fh;
            fh = new FileHandler("fileHandler");
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            ExecutionContext context = new ExecutionContext();

            Scanner sc = new Scanner(System.in);
            String next = "";

            while (next != "EXIT") {
                next = sc.nextLine();
                Operation op = context.getFactory().create(next);
                op.execute(context);
            }
        } catch (MainExceptions ex) {
            System.out.println(ex.description);
            LOGGER.info(ex.description);
        } catch (IOException ex) {
            LOGGER.info(ex.getLocalizedMessage());
        }
    }
}

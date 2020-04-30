package ru.spbstu.icst.calculator.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import ru.spbstu.icst.calculator.ExecutionContext;
import ru.spbstu.icst.calculator.Operation;
import ru.spbstu.icst.exceptions.ExecutionExceptions;
import ru.spbstu.icst.exceptions.MainExceptions;

public class CalculatorTest {

    private ExecutionContext context;
    private String next;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Before
    public void initTest() {
        context = new ExecutionContext();
        next = "";
    }

    @After
    public void afterTest() {
        context = null;
        next = "";
    }

    @Test
    public void testPUSH() throws MainExceptions {
        next = "PUSH 20";
        Operation op = context.getFactory().create(next);
        op.execute(context);
        assertEquals(20, context.getStack().peek());
    }

    @Test
    public void testPLUS() throws MainExceptions {
        next = "EXP 2+4";
        Operation op = context.getFactory().create(next);
        op.execute(context);
        assertEquals(6, context.getStack().peek());
    }

    @Test
    public void testDIVIDE() throws MainExceptions {
        next = "EXP 9/3";
        Operation op = context.getFactory().create(next);
        op.execute(context);
        assertEquals(3, context.getStack().peek());
    }

    @Test (expected = ExecutionExceptions.class)
    public void testEmpty() throws ExecutionExceptions {
        context.getStack().pop();
    }

    @Test
    public void testDEFINE() throws MainExceptions {
        next = "DEFINE a 4";
        Operation op = context.getFactory().create(next);
        op.execute(context);
        assertEquals(true, context.getTable().containsKey("a"));
    }
}

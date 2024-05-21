package be.archilios.bigBank.test;

import be.archilios.bigBank.domain.Euro;
import be.archilios.bigBank.domain.EuroBalance;

public class CustomAssertion {
    public static void assertEquals(Euro check, Euro expected) {
        assertEquals(check, expected, "Got: %s while expecting %s%n");
    }
    
    public static void assertEquals(Euro check, Euro expected, String message) {
        if (check.value().equals(expected.value())) {
            System.out.println("Test passed");
        } else {
            System.out.printf(message, check, expected);
        }
    }
    
    public static void assertEquals(EuroBalance check, Euro expected) {
        assertEquals(check.getBalance(), expected);
    }
    
    public static void assertThrows(Class<? extends Exception> exceptionType, Runnable functionToTest) {
        try {
            functionToTest.run();
            System.out.printf("Test Failed: Expected an exception of type %s, but got none. %n", exceptionType);
        } catch (Exception e) {
            if (exceptionType.isAssignableFrom(e.getClass())) System.out.println("Test passed");
            else System.out.printf("Test Failed: Expected an exception of type %s, but got %s%n", exceptionType, e.getClass());
        }
    }
}

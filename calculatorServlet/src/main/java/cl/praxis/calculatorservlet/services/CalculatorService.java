package cl.praxis.calculatorservlet.services;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorService {
    private Map<Integer, String> operations = new LinkedHashMap<>();

    public CalculatorService() {
        operations.put(1, "Suma");
        operations.put(2, "Resta");
        operations.put(3, "Multiplicación");
        operations.put(4, "División");
        operations.put(5, "Ordenar ascendentemente");
        operations.put(6, "Ordenar descendentemente");
        operations.put(7, "Cuál es par e impar");
    }

    public Map<Integer, String> getOperations() {
        return operations;
    }

    public String calculate(int num1, int num2, int operation) {
        switch (operation) {
            case 1:
                return addition(num1, num2);
            case 2:
                return subtraction(num1, num2);
            case 3:
                return multiplication(num1, num2);
            case 4:
                return division(num1, num2);
            case 5:
                return ascOrder(num1, num2);
            case 6:
                return descOrder(num1, num2);
            case 7:
                return evenOdd(num1, num2);
            default:
                return "Operación no válida";
        }
    }

    private String addition(int num1, int num2) {
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    private String subtraction(int num1, int num2) {
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    private String multiplication(int num1, int num2) {
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    private String division(int num1, int num2) {
        if (num2 == 0)
            return "No se puede dividir por 0";

        return num1 + " / " + num2 + " = " + ((double) num1 / (double) num2);
    }

    private String ascOrder(int num1, int num2) {
        String str = "";
        if (num1 == num2)
            str = num1 + " y " + num2 + " son iguales, no se pueden ordenar";
        else
            str = num1 > num2 ? "El orden ascendente de los números es [" + num2 + ", " + num1 + "]" : "El orden ascendente de los números es [" + num1 + ", " + num2 + "]";
        return str;
    }

    private String descOrder(int num1, int num2) {
        String str = "";
        if (num1 == num2)
            str = "Los números " + num1 + " y " + num2 + " son iguales, no se pueden ordenar";
        else
            str = num1 > num2 ? "El orden descendente de los números es [" + num1 + ", " + num2 + "]" : "El orden descendente de los números es [" + num2 + ", " + num1 + "]";
        return str;
    }

    private String evenOdd(int num1, int num2) {

        String str = num1 % 2 == 0 ? "El número " + num1 + " es par" : "El número " + num1 + " es impar";
        str+= num2 % 2 == 0 ? " y el número " + num2 + " es par" : " y el número " + num2 + " es impar";

        return str;
    }
}
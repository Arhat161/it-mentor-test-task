package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// -------- ВТОРОЙ ВАРИАНТ РЕШЕНИЯ ЗАДАЧИ ------------------------------------------------------------------------------
// -------- Используем отдельный класс для создания калькулятора -------------------------------------------------------
public class Main2 {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in); // сканер для ввода из консоли

        while (true) { // бесконечный цикл (можно выйти по выбросу исключения)
            try {
                System.out.println("Input:");
                String userInputString = userInput.nextLine(); // ввод пользователя
                System.out.println("Output:");
                System.out.println(calc(userInputString)); // вывод результата вычислений
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // главный метод для вычислений и логики
    public static String calc(String input) throws Exception {
        // строка вывода (результат)
        String output = "";
        // если строка больше чем два символа, т.е как минимум 1+1
        if (input.trim().length() > 2) {
            // задаем нижнюю границу допустимого значения первого операнда
            int lowDivide = 1;
            // задаем верхнюю границу допустимого значения первого операнда
            int highDivide = 10;
            // задаем допустимые математические операции
            String[] validMathOperationSymbols = new String[]{"+", "-", "*", "/"};
            // создаем экземпляр калькулятора с теми требованиями, которые заданы в задаче
            Calc simpleCalc = new Calc(input, validMathOperationSymbols, lowDivide, highDivide);
            // получить числа из строки
            ArrayList<Integer> operands = new ArrayList<>(simpleCalc.getDigits());
            // получить символ(ы) операции из строки
            ArrayList<String> mathSymbols = simpleCalc.getMathSymbols();
            // проверяем количество символов операции в строке
            if (mathSymbols.size() == 1) {
                // проверяем количество операндов в строке
                if (operands.size() == 2) {
                    if (simpleCalc.isValidOperand(operands.get(0)) && simpleCalc.isValidOperand(operands.get(1))) {
                        for (Operation oneOperation : Operation.values()) { // перебираем все операции из enum и получаем их значения
                            if (Objects.equals(oneOperation.getOperationSymbol(), mathSymbols.get(0))) {
                                // производим вычисление при помощи метода из анонимного класса операнда
                                output = String.valueOf(oneOperation.getResult(operands.get(0), operands.get(1)));
                            }
                        }
                    } else {
                        throw new Exception("Значения операндов выходит за пределы допустимых : " + input);
                    }
                } else {
                    throw new Exception("Больше двух операндов в строке: " + input);
                }
            } else {
                throw new Exception("Больше одного символа математических операций в строке : " + input);
            }
        } else {
            throw new Exception("Слишком короткое выражение : " + input);
        }
        return output;
    }
}
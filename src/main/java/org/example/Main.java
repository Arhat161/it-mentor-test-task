package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in); // сканер для ввода из консоли

        while (true) { // бесконечный цикл (можно выйти по выбросу исключения)
            try {
                String userInputString = userInput.nextLine(); // ввод пользователя
                System.out.println(calc(userInputString)); // вывод результата вычислений
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // признак валидности строки по длине (без проверки операндов), максимум в строке может быть 5 символов
    public static boolean isValidStringLong(int lowDivide, int highDivide, String string) {
        return string.length() >= lowDivide && string.length() <= highDivide;
    }

    // проверка на вхождение числа в диапазон от *** и до ***
    public static boolean isValidOperand(int lowDivide, int highDivide, int operand) {
        return operand >= lowDivide && operand <= highDivide;
    }

    // подсчет количества символов в строке
    public static int getCountOfSymbolInString(String input, String symbol) {
        return input.length() - input.replace(String.valueOf(symbol), "").length();
    }

    // главный метод для вычислений и логики
    public static String calc(String input) throws Exception {
        String output = ""; // строка вывода (результат)
        if (isValidStringLong(3, 5, input)) { // если строка на входе достаточной длины (от 3-х до 5-ти символов)
            // --- Ищем знак операции ---
            boolean isOperationSymbol = false; // флаг наличия операции по умолчании false
            // --- в цикле проходим по всем доступным нам операциям из enum-a и смотрим, попадаются ли они в строке
            for (Operation oneOperation : Operation.values()) { // перебираем все операции из enum и получаем их значения
                int count = getCountOfSymbolInString(input, oneOperation.getOperationSymbol()); // сколько символов одной операции в строке, например сколько +
                // если в строке input есть значение операции и до него еще не было найдено +,-,*,/
                if (input.contains(oneOperation.getOperationSymbol()) && count == 1) {
                    isOperationSymbol = true; // флаг наличия знака операции теперь true
                    // разбиваем ввод пользователя по символу операции на первый и второй операнды
                    String[] stringOperand = input.trim().split("[+-/*\"]");
                    // преобразовываем из String в int - проверка на целые числа
                    try {
                        int[] operand = {Integer.parseInt(stringOperand[0].trim()), Integer.parseInt(stringOperand[1].trim())};
                        // оба операнда должны лежать в диапазоне от 1 до 10
                        if (isValidOperand(1, 10, operand[0]) && isValidOperand(1, 10, operand[1])) {
                            // производим вычисление при помощи метода из анонимного класса операнда
                            output = String.valueOf(oneOperation.getResult(operand[0], operand[1]));
                        } else {
                            throw new Exception("Значения операндов выходит за пределы допустимых : " + input);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    // если в строке input есть значение операции и до него УЖЕ БЫЛО найдено +, -, *, /
                } else if (input.contains(oneOperation.getOperationSymbol()) && count > 1) {
                    throw new Exception("В строке больше одного символа операции : " + input);
                }
            }
            // Если цикл прошел, но знак операции так и не нашли
            if (!isOperationSymbol) {
                throw new Exception("В строке не найден символ математической операции : " + input);
            }
        } else {
            throw new Exception("Слишком короткое/длинное выражение : " + input);
        }
        return output;
    }
}
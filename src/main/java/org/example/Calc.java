package org.example;

import java.util.ArrayList;

public class Calc {

    // входная строка
    private String inputStringForParsing;
    // список допустимых знаков математических операций, задаем в конструкторе при создании экземпляра класса
    private String[] validMathOperationSymbols;
    // нижняя граница допустимого диапазона чисел, задаем в конструкторе при создании экземпляра класса
    private int lowDivide;
    // верхняя граница допустимого диапазона чисел, задаем в конструкторе при создании экземпляра класса
    private int highDivide;
    // признак операций только с целыми числами
    private boolean onlyInteger = true;
    // текст ошибки при обнаружении дробного числа
    private String onlyIntegerErrorMessage = "Калькулятор умеет работать только с целыми числами.";
    // список операндов, получаем парсингом входной строки
    private ArrayList<Integer> digits;
    // список знаков математических операций, получаем парсингом входной строки
    private ArrayList<String> mathSymbols;

    public Calc(String inputStringForParsing, String[] validMathOperationSymbols, int lowDivide, int highDivide) throws Exception {
        this.inputStringForParsing = inputStringForParsing.trim(); // задаем при создании экземпляра класса
        this.validMathOperationSymbols = validMathOperationSymbols; // задаем при создании экземпляра класса
        this.lowDivide = lowDivide; // задаем при создании экземпляра класса
        this.highDivide = highDivide; // задаем при создании экземпляра класса
        this.digits = this.getDigits(); // получаем через вызов метода
        this.mathSymbols = this.getMathSymbols(); // получаем через вызов метода
    }

    // получить все числа из строки
    public ArrayList<Integer> getDigits() throws Exception {
        ArrayList<Integer> result = new ArrayList<>();
        char[] chars = this.inputStringForParsing.toCharArray();
        String temp = "";
        for (char ch : chars) {
            // если наткнулись на символ, который не является числом
            if (!Character.isDigit(ch)) {
                // проверяем, допустимы ли только целые числа?
                if (this.onlyInteger && (ch == '.' | ch == ',')) {
                    throw new Exception(this.onlyIntegerErrorMessage);
                }
                // добавляем в ArrayList очередной операнд
                result.add(Integer.parseInt(temp));
                // очищаем временную переменную
                temp = "";
            } else {
                // пока не дошли до какого-то символа, который не является числом
                temp = temp + ch;
            }
        }
        if (!temp.isEmpty()) {
            result.add(Integer.parseInt(temp));
        }
        return result;
    }

    // получить математические символы из строки
    // +, -, *, /
    public ArrayList<String> getMathSymbols() {
        ArrayList<String> result = new ArrayList<>(); // результирующий ArrayList
        for (String s : this.validMathOperationSymbols) {
            if (this.inputStringForParsing.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    // проверка значения на вхождение в диапазон
    public boolean isValidOperand(int operand) {
        return operand >= this.lowDivide && operand <= this.highDivide;
    }

    // сгенерировано "чтобы было"
    public String getInputStringForParsing() {
        return inputStringForParsing;
    }

    public void setInputStringForParsing(String inputStringForParsing) {
        this.inputStringForParsing = inputStringForParsing;
    }

    public String[] getValidMathOperationSymbols() {
        return validMathOperationSymbols;
    }

    public void setValidMathOperationSymbols(String[] validMathOperationSymbols) {
        this.validMathOperationSymbols = validMathOperationSymbols;
    }

    public int getLowDivide() {
        return lowDivide;
    }

    public void setLowDivide(int lowDivide) {
        this.lowDivide = lowDivide;
    }

    public int getHighDivide() {
        return highDivide;
    }

    public void setHighDivide(int highDivide) {
        this.highDivide = highDivide;
    }

    public boolean isOnlyInteger() {
        return onlyInteger;
    }

    public void setOnlyInteger(boolean onlyInteger) {
        this.onlyInteger = onlyInteger;
    }

    public String getOnlyIntegerErrorMessage() {
        return onlyIntegerErrorMessage;
    }

    public void setOnlyIntegerErrorMessage(String onlyIntegerErrorMessage) {
        this.onlyIntegerErrorMessage = onlyIntegerErrorMessage;
    }

    public void setDigits(ArrayList<Integer> digits) {
        this.digits = digits;
    }

    public void setMathSymbols(ArrayList<String> mathSymbols) {
        this.mathSymbols = mathSymbols;
    }

    @Override
    public String toString() {
        return "Calc { " +
                "inputStringForParsing = '" + inputStringForParsing + '\'' +
                ", digits = " + digits +
                " }";
    }
}
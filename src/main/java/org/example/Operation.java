package org.example;

public enum Operation {
    ADDITION("+") {
        public short getResult(int firstOperand, int secondOperand) {
            return (short)(firstOperand + secondOperand);
        }
    },
    SUBTRACTION("-") {
        public short getResult(int firstOperand, int secondOperand) {
            return (short)(firstOperand - secondOperand);
        }
    },
    MULTIPLICATION("*") {
        public short getResult(int firstOperand, int secondOperand) {
            return (short)(firstOperand * secondOperand);
        }
    },
    DIVISION("/") {
        public short getResult(int firstOperand, int secondOperand) {
            return (short)(firstOperand / secondOperand);
        }
    };

    private final String operationSymbol;

    abstract short getResult(int var1, int var2);

    Operation(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return this.operationSymbol;
    }

    public String toString() {
        return "Operation { operationSymbol = '" + this.operationSymbol + "' }";
    }
}

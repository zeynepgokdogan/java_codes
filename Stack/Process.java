//Zeynep Gokdogan

import java.io.BufferedReader;
import java.io.FileReader;

public class Process {
    public static void main(String[] args) {

        String filePath = "infix.txt";

        try (BufferedReader infixReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = infixReader.readLine()) != null) {
                double result = processStack(line);
                if (Double.isNaN(result)) {
                    System.err.println("ERROR: Invalid expresssion");
                }
                else{
                    System.out.println("Result: "+ result);
                }
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    private static double processStack(String line) {
        line = line.replaceAll("\\s", "");
        OperandStack operandStack = new OperandStack();
        OperatorStack operatorStack = new OperatorStack();

        for (int i = 0; i < line.length(); i++) {
            char element = line.charAt(i);
            if (Character.isDigit(element)) {
                StringBuilder operand = new StringBuilder();
                while (i < line.length() && Character.isDigit(line.charAt(i))) {
                    operand.append(line.charAt(i++));
                }
                i--;
                operandStack.push(Double.parseDouble(operand.toString()));
            } else if (isOperator(element)) {
                while (!operatorStack.isEmpty()
                        && TransactionPriority(operatorStack.peek()) >= TransactionPriority(element)) {
                    ResultOfProcess(operandStack, operatorStack.pop());
                }
                operatorStack.push(element);
            } else {
                return Double.NaN;
            }
        }
        while (!operatorStack.isEmpty()) {
            ResultOfProcess(operandStack, operatorStack.pop());
        }
        return operandStack.pop();
    }


    private static boolean isOperator(char element) {
        if (element == '+' || element == '-' || element == '*' || element == '/') {
            return true;
        }
        return false;
    }



    private static void ResultOfProcess(OperandStack operandStack, char operator) {
        double element_1 = operandStack.pop();
        double element_2 = operandStack.pop();
        switch (operator) {
            case '+':
                double result_addition = element_2 + element_1;
                operandStack.push(result_addition);
                break;

            case '-':
                double result_subtraction = element_2 - element_1;
                operandStack.push(result_subtraction);
                break;

            case '*':
                double result_multiplication = element_2 * element_1;
                operandStack.push(result_multiplication);
                break;

            case '/':
                if (element_2 == 0) {
                    System.out.println("ERROR");
                    operandStack.push(Double.NaN);
                } else {
                    double result_division = element_2 / element_1;
                    operandStack.push(result_division);
                }

                break;
            default:
                System.out.println("ERROR");
                break;
        }

    }


    private static int TransactionPriority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

}
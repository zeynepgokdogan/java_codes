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
    
        char[] elements = line.toCharArray();
        int i = 0;
        while (i < elements.length) {
            char element = elements[i];
            if (Character.isDigit(element)) {
                int start = i;
                while (i < elements.length && Character.isDigit(elements[i])) {
                    i++;
                }
                operandStack.push(Double.parseDouble(line.substring(start, i)));
                i--;
            } else {
                if (isOperator(element)) {
                    while (!operatorStack.isEmpty()
                            && TransactionPriority(operatorStack.peek()) >= TransactionPriority(element)) {
                        ResultOfProcess(operandStack, operatorStack.pop());
                    }
                    operatorStack.push(element);
                } else {
                    return Double.NaN;
                }
            }
            i++;
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
        double number_1 = operandStack.pop();
        double number_2 = operandStack.pop();
        switch (operator) {
            case '+':
                double result_addition = number_2 + number_1;
                operandStack.push(result_addition);
                break;

            case '-':
                double result_subtraction = number_2 - number_1;
                operandStack.push(result_subtraction);
                break;

            case '*':
                double result_multiplication = number_2 * number_1;
                operandStack.push(result_multiplication);
                break;

            case '/':
                if (number_2 == 0) {
                    System.out.println("ERROR");
                    operandStack.push(Double.NaN);
                } else {
                    double result_division = number_2 / number_1;
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
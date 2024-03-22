//Zeynep Gokdogan

public class OperatorStack {
    private char[] stack;
    private int top;
    private int size;
    private static final int MAX_SIZE = 100;

    public OperatorStack() {
        stack = new char[MAX_SIZE];
        top = -1;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void push(char Character) {
        if (top + 1 >= MAX_SIZE) {
            System.out.println("OperatorStack is full!!");
            return;
        }

        else {
            stack[++top] = Character;
            size++;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("OperatorStack is Empty!!");
            return '\0';
        }
        size--;
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("OperatorStack is Empty!!");
            return '\0';
        }
        return stack[top];
    }

}

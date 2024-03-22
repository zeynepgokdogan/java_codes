// Zeynep Gokdogan

public class OperandStack {
    private double[] stack;
    private int top;
    private int size;
    private static final int MAX_SIZE = 100;

    public OperandStack() {
        stack = new double[MAX_SIZE];
        top = -1;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void push(double d) {
        if (top + 1 >= MAX_SIZE) {
            System.out.println("OperandStack is full!!");
            return;
        }

        else {
            stack[++top] = d;
            size++;
        }
    }

    public double pop() {
        if (isEmpty()) {
            return Double.NaN;
        }
        size--;
        return stack[top--];
    }

}
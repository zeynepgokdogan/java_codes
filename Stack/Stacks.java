//Zeynep Gokdogan

public class Stacks {

    public static class OperandStack {
        private int[] stack;
        private int top;
        private int size;
        private static final int MAX_SIZE = 100;

        public OperandStack() {
            stack = new int[MAX_SIZE];
            top = -1;
            size = 0;
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        public void push(int num) {
            if (top + 1 >= MAX_SIZE) {
                System.out.println("OperandStack is full!!");
                return;
            }

            else {
                stack[++top] = num;
                size++;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("OperandStack is Empty!!");
                return -1;
            }
            size--;
            return stack[top--];
        }

    }

    public static class OperatorStack {
        private int[] stack;
        private int top;
        private int size;
        private static final int MAX_SIZE = 100;

        public OperatorStack() {
            stack = new int[MAX_SIZE];
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
                System.out.println("OperandStack is full!!");
                return;
            }

            else {
                stack[++top] = Character;
                size++;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("OperandStack is Empty!!");
                return '\0';
            }
            size--;
            return stack[top--];
        }

    }
}
package ds.stack;

import java.util.EmptyStackException;

public class x03_IntStackDynamicSize {

    public static class IntStackDynamicSize {

        int[] dataArray;
        int stackSize;
        int topStackIndex;

        int increaseSize;
        int maxLimitSize;

        public IntStackDynamicSize(int size, int incSize, int maxSize) {
            if (size < 0) {
                throw new IllegalArgumentException("size must not be negative or empty");
            }
            if (incSize < 1) {
                throw new IllegalArgumentException("additional size must not be less than 1");
            }
            if (maxSize < size) {
                throw new IllegalArgumentException("limit must not be less initial size");
            }
            dataArray = new int[size];
            stackSize = size;
            topStackIndex = -1;

            increaseSize = incSize;
            maxLimitSize = maxSize;

        }

        void increaseSizeDataArray() throws Exception {
            int newStackSize = stackSize + increaseSize;
            if (newStackSize > maxLimitSize) {
                throw new IllegalArgumentException("stack overflow");
            }
            int[] temp = new int[newStackSize];

            for (int i = 0; i < stackSize; i++) {
                temp[i] = dataArray[i];
            }

            stackSize = newStackSize;
            dataArray = temp;
            System.out.println(":: increasing stack size: new stack size: " + stackSize);
        }

        public void push(int newELement) throws Exception {
            if (topStackIndex == (stackSize - 1)) {
                increaseSizeDataArray();
            }
            topStackIndex += 1;
            dataArray[topStackIndex] = newELement;
        }

        public int pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            var result = dataArray[topStackIndex];
            topStackIndex -= 1;
            return result;
        }

        public boolean isEmpty() {
            return (topStackIndex == -1);
        }

        @Override
        public String toString() {
            var diagnostics = "stack oontent: {";
            for (int i = 0; i <= topStackIndex; i++) {
                diagnostics = diagnostics + "" + dataArray[i];
                if (i != topStackIndex)
                    diagnostics += ",";
            }
            diagnostics = diagnostics + "}" + " top stack index: " + topStackIndex;
            return diagnostics;
        }
    }

    public static void main(String[] args) {

        System.out.println("------------------------------------------------");
        System.out.println("work with stack contains int elements with dynamic size");

        IntStackDynamicSize stack = new IntStackDynamicSize(3, 2, 8);

        try {
            stack.push(100);
            stack.push(200);
            stack.push(300);
            stack.push(400);
            stack.push(500);
            stack.push(600);
            stack.push(700);
            stack.push(800);
            stack.push(900);
        } catch (Exception e) {
            System.out.println(":: got exception:" + e);
        }
        System.out.println(stack);

        try {
            stack.pop();
            stack.pop();
            var result = stack.pop();
            System.out.println("retrieved element: " + result);
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(":: got exception:" + e);
        }
        System.out.println(stack);
    }

}

/*

------------------------------------------------
work with stack contains int elements with dynamic size
:: increasing stack size: new stack size: 5
:: increasing stack size: new stack size: 7
:: got exception:java.lang.IllegalArgumentException: stack overflow
stack oontent: {100,200,300,400,500,600,700} top stack index: 6
retrieved element: 500
:: got exception:java.util.EmptyStackException
stack oontent: {} top stack index: -1

 */

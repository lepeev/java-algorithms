package ds.stack;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.EmptyStackException;

public class x02_IntStackFixSize {

    public static class IntStackFixSize {

        int[] dataArray;
        int stackSize;
        int topStackIndex;

        public IntStackFixSize(int size) {

            if (size <= 0) {
                throw new IllegalArgumentException("size could not be negative or empty");
            }

            dataArray = new int[size];
            stackSize = size;
            topStackIndex = -1;

        }

        public void push(int element) throws Exception {
            if (topStackIndex == (stackSize - 1)) {
                throw new Exception("stack overflow");
            }
            topStackIndex += 1;
            dataArray[topStackIndex] = element;
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
        System.out.println("work with stack contains int elements with fixed size");

        IntStackFixSize stack = new IntStackFixSize(3);
        try {
            stack.push(100);
            stack.push(200);
            stack.push(300);
            stack.push(400);
            stack.push(500);
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
        } catch (Exception e) {
            System.out.println(":: got exception:" + e);
        }
        System.out.println(stack);

    }

}

/*
------------------------------------------------
work with stack contains int elements with fixed size
:: got exception:java.lang.Exception: stack overflow
stack oontent: {100,200,30} top stack index: 2
retrieved element: 100
:: got exception:java.util.EmptyStackException
stack oontent: {} top stack index: -1

 */
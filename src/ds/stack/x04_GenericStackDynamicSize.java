package ds.stack;

import java.util.EmptyStackException;

public class x04_GenericStackDynamicSize {
    public static class GenericStackDynamicSize<T> {

        Object[] dataArray;
        int stackSize;
        int topStackIndex;

        int increaseSize;
        int maxLimitSize;

        public GenericStackDynamicSize(int size, int incSize, int maxSize) {
            if (size < 0) {
                throw new IllegalArgumentException("size must not be negative or empty");
            }
            if (incSize < 1) {
                throw new IllegalArgumentException("additional size must not be less than 1");
            }
            if (maxSize < size) {
                throw new IllegalArgumentException("limit must not be less initial size");
            }
            dataArray = new Object[size];
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
            Object[] temp = new Object[newStackSize];

            for (int i = 0; i < stackSize; i++) {
                temp[i] = dataArray[i];
            }

            stackSize = newStackSize;
            dataArray = temp;
            System.out.println(":: increasing stack size: new stack size: " + stackSize);
        }

        public void push(T newELement) throws Exception {
            if (topStackIndex == (stackSize - 1)) {
                increaseSizeDataArray();
            }
            topStackIndex += 1;
            dataArray[topStackIndex] = newELement;
        }

        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T result = (T) dataArray[topStackIndex];
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
        System.out.println("work with stack contains generics elements with dynamic size");

        var stack = new GenericStackDynamicSize<String>(3, 2, 8);

        try {
            stack.push("x100");
            stack.push("x200");
            stack.push("x300");
            stack.push("x400");
            stack.push("x500");
            stack.push("x600");
            stack.push("x700");
            stack.push("x800");
            stack.push("x900");
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
work with stack contains generics elements with dynamic size
:: increasing stack size: new stack size: 5
:: increasing stack size: new stack size: 7
:: got exception:java.lang.IllegalArgumentException: stack overflow
stack oontent: {x100,x200,x300,x400,x500,x600,x700} top stack index: 6
retrieved element: x500
:: got exception:java.util.EmptyStackException
stack oontent: {} top stack index: -1

 */

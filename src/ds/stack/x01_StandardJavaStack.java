package ds.stack;

import java.util.Stack;

public class x01_StandardJavaStack {

    public static void main(String[] args) {

        System.out.println("Standard stack from Java");
        Stack<String> stdStack = new Stack<>();
        stdStack.push("x100");
        stdStack.push("x200");
        System.out.println(stdStack);

    }

}

/*

Standard stack from Java
[x100, x200]

 */
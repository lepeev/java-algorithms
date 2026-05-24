package ds.arrays;

import java.util.Arrays;

public class x03_FlexibleArray_viaCopy {

    public static void main(String[] args) {

        System.out.println("Manually expanding an array by copying");
        int[] expandedArray = {1, 2, 3};
        int addingElement = 4;
        System.out.println(Arrays.toString(expandedArray));

        int[] temp = new int[expandedArray.length + 1];
        System.arraycopy(
                expandedArray,
                0,
                temp,
                0,
                expandedArray.length
        );
        expandedArray = temp;
        expandedArray[expandedArray.length - 1] = addingElement;

        System.out.println(Arrays.toString(expandedArray));
        System.out.println("");
        ;

    }
}

/*

Manually expanding an array by copying
[1, 2, 3]
[1, 2, 3, 4]

 */

package ds.arrays;

import java.util.stream.Stream;

public class x01_FixSizeArray {

    public static void main(String[] args) {

        String[] arrayOfFixedSize = new String[5];
        String[] arrayOfNames = {"Ivan", "Aleksei", "kirill"};

        Stream.of(
                "",
                "Array info:",
                arrayOfFixedSize.length +
                        " --- size of fixed array with choosed length",
                arrayOfFixedSize[0] +
                        " --- such array is initialized with null",

                arrayOfNames.length +
                        " --- size of array with the length during initialization",
                arrayOfNames[0] + " -- the first element of array",
                arrayOfNames[arrayOfNames.length - 1] + " --- the last element of array",

                String.join(
                        ",",
                        arrayOfNames) + " --- contents of array"

        ).forEach(System.out::println);

    }

}

/*

Array info:
5 --- size of fixed array with choosed length
null --- such array is initialized with null
3 --- size of array with the length during initialization
Ivan -- the first element of array
kirill --- the last element of array
Ivan,Aleksei,kirill --- contents of array

 */
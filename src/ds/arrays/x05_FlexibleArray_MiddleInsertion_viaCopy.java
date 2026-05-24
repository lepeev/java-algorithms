package ds.arrays;

public class x05_FlexibleArray_MiddleInsertion_viaCopy {

    public static void main(String[] args) {

        int[] expandedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int indexForInsert = 5;
        int valueForInsert = 777;

        if (indexForInsert < 0 || indexForInsert > expandedArray.length) {
            throw new IllegalArgumentException("wrong index for insert");
        }

        int[] temp = new int[expandedArray.length + 1];

        //copy left side
        for (int i = 0; i < indexForInsert; i++) {
            temp[i] = expandedArray[i];
        }

        // insert value
        temp[indexForInsert] = valueForInsert;

        // copy right side where index different
        for (int i = indexForInsert; i < expandedArray.length; i++) {
            temp[i + 1] = expandedArray[i];
        }

        expandedArray = temp;

        System.out.println("");
        for (int i = 0; i < expandedArray.length; i++) {
            System.out.println(expandedArray[i]);
        }


    }

}

/*

1
2
3
4
5
777
6
7
8
9

 */
package ds.arrays;

public class x06_FlexibleArray_MiddleInsertion_viaTailCopy {

    public static void main(String[] args) {

        int[] initArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int logicSize = initArray.length;
        int[] reserveArray = new int[100];
        int valueForInsert = 777;
        int indexForInsert = 7;

        if (indexForInsert < 0 || indexForInsert > logicSize) {
            throw new IllegalArgumentException("wrong index for insert");
        }

        if (logicSize >= reserveArray.length) {
            throw new IllegalArgumentException("reserve array is full");
        }

        System.arraycopy(
                initArray,
                0,
                reserveArray,
                0,
                logicSize
        );

        logicSize++;

        for (int i = logicSize; i > indexForInsert; i--) {
            reserveArray[i] = reserveArray[i - 1];
        }

        reserveArray[indexForInsert] = valueForInsert;

        System.out.println();
        for (int i = 0; i < logicSize; i++) {
            System.out.println(reserveArray[i]);
        }


    }

}

/*

1
2
3
4
5
6
7
777
8
9

 */

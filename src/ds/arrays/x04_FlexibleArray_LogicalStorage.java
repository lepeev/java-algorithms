package ds.arrays;

public class x04_FlexibleArray_LogicalStorage {

    public static void main(String[] args) {

        int[] initArray = {1, 2, 3};
        int logicSize = initArray.length;
        int[] reserveArray = new int[100];
        if (logicSize > reserveArray.length) {
            throw new IllegalArgumentException("reserveArray is full");
        }

        System.arraycopy(
                initArray,
                0,
                reserveArray,
                0,
                logicSize
        );
        reserveArray[logicSize++] = 4;

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

 */

package ds.arrays;

import java.util.Arrays;
import java.util.function.Function;

public class x07_FlexibleArray_MiddleInsertion_viaChunks {

    public static void main(String[] args) {

        char[][] chunksArray = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F', 'G'},
                {'H', 'I'}
        };
        System.out.println("");
        System.out.println(Arrays.deepToString(chunksArray));

        record twoDimIndex(int indexByRow, int indexByColumn) {

        }

        Function<Integer, twoDimIndex> convertOneDimToTwoDimIndex =
                (oneDimIndex) -> {
                    int tempIndex = oneDimIndex;
                    int twoDimIndexRow = 0;
                    int twoDimIndexColumn = 0;

                    if (chunksArray.length == 0) {
                        throw new IllegalArgumentException("chunks array is empty");
                    }
                    if (oneDimIndex >= Arrays.stream(chunksArray)
                            .mapToInt(oneRow -> oneRow.length)
                            .sum()) {
                        throw new IllegalArgumentException("oneDimIndex cannot be places inside array");
                    }
                    if (oneDimIndex < 0) {
                        throw new IllegalArgumentException("oneDimIndex cannot be negative");
                    }

                    for (int i = 0; i < chunksArray.length; i++) {
                        if (tempIndex < chunksArray[i].length) {
                            twoDimIndexRow = i;
                            twoDimIndexColumn = tempIndex;
                            break;
                        }
                        tempIndex -= chunksArray[i].length;
                    }
                    return new twoDimIndex(twoDimIndexRow,
                            twoDimIndexColumn);

                };

        char valueForInsert = 'X';
        int valueForLogicIndex = 8;

        var result = convertOneDimToTwoDimIndex.apply(valueForLogicIndex);
        System.out.println("will be added to logic coordinates:");
        System.out.println(result);

        var chunk = chunksArray[result.indexByRow()];

        char[] temp = new char[chunk.length + 1];

        System.arraycopy(
                chunk,
                0,
                temp,
                0,
                result.indexByColumn());

        temp[result.indexByColumn()] = valueForInsert;

        System.arraycopy(
                chunk,
                result.indexByColumn(),
                temp,
                result.indexByColumn() + 1,
                chunk.length - result.indexByColumn());
        chunksArray[result.indexByRow()] = temp;

        System.out.println(Arrays.deepToString(chunksArray));


    }


}

/*

[[A, B, C], [D, E, F, G], [H, I]]
will be added to logic coordinates:
twoDimIndex[indexByRow=2, indexByColumn=1]
[[A, B, C], [D, E, F, G], [H, X, I]]

 */

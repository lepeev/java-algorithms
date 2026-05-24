package ds.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class x02_MultiDimArray {

    public static void main(String[] args) {

        enum Month {
            January,
            February
        }

        enum Weeks {
            FirstWeek,
            SecondWeek
        }

        enum DayOfWeek {
            Monday,
            Tuesday,
            Wednesday,
            Thursday,
            Friday,
            Saturday,
            Sunday
        }

        String[][][] multiArray = {
                {
                        {"1 january", "2 january", "3 january", "4 january", "5 january", "6 january", "7 january"},
                        {"8 january", "9 january", "10 january", "11 january", "12 january", "13 january", "14 january"}
                },
                {
                        {"1 february", "2 february", "3 february", "4 february", "5 february", "6 february", "7 february"},
                        {"8 february", "9 february", "10 february", "11 february", "12 february", "13 february", "14 february"}
                },

        };

        Stream.of(
                "",

                multiArray.length + " --- length of first level",
                multiArray[0].length + " --- length of the second level",
                multiArray[0][0].length + "--- length of the third level",

                multiArray[Month.January.ordinal()][Weeks.SecondWeek.ordinal()][DayOfWeek.Wednesday.ordinal()] + " --- access",
                Arrays.deepToString(multiArray) + " -- contents",
                ""
        ).forEach(System.out::println);


    }
}

/*

2 --- length of first level
2 --- length of the second level
7--- length of the third level
10 january --- access
[[[1 january, 2 january, 3 january, 4 january, 5 january, 6 january, 7 january], [8 january, 9 january, 10 january, 11 january, 12 january, 13 january, 14 january]], [[1 february, 2 february, 3 february, 4 february, 5 february, 6 february, 7 february], [8 february, 9 february, 10 february, 11 february, 12 february, 13 february, 14 february]]] -- contents

 */

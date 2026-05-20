import java.util.*;
import java.io.*;

public class SudokuSolverEngine {
    public static void main(String[] args) {
        String[] testFiles = {
            "boards/very-fast-solve.sdk",
            "boards/fast-solve.sdk",
            "boards/valid-complete.sdk",
            "boards/row-violation.sdk"
        };

        for (String fileName : testFiles) {
            System.out.println("Board: " + fileName);
            SudokuBoard board = new SudokuBoard(fileName);
            System.out.println(board);

            if (!board.isValid()) {
                System.out.println("This board is invalid and cannot be solved.\n");
                continue;
            }

            if (board.isSolved()) {
                System.out.println("This board is already solved!\n");
                continue;
            }

            if (board.solve()) {
                System.out.println("Solved successfully!");
                System.out.println(board);
            } else {
                System.out.println("No solution exists for this board.\n");
            }
        }
    }
}

/*
 
  ----jGRASP exec: java SudokuSolverEngine
 Board: boards/very-fast-solve.sdk
 Error: File not found.
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 
 Solved successfully!
 +-------+-------+-------+
 | 1 2 3 | 4 5 6 | 7 8 9 |
 | 4 5 6 | 7 8 9 | 1 2 3 |
 | 7 8 9 | 1 2 3 | 4 5 6 |
 +-------+-------+-------+
 | 2 1 4 | 3 6 5 | 8 9 7 |
 | 3 6 5 | 8 9 7 | 2 1 4 |
 | 8 9 7 | 2 1 4 | 3 6 5 |
 +-------+-------+-------+
 | 5 3 1 | 6 4 2 | 9 7 8 |
 | 6 4 2 | 9 7 8 | 5 3 1 |
 | 9 7 8 | 5 3 1 | 6 4 2 |
 +-------+-------+-------+
 
 Board: boards/fast-solve.sdk
 Error: File not found.
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 
 Solved successfully!
 +-------+-------+-------+
 | 1 2 3 | 4 5 6 | 7 8 9 |
 | 4 5 6 | 7 8 9 | 1 2 3 |
 | 7 8 9 | 1 2 3 | 4 5 6 |
 +-------+-------+-------+
 | 2 1 4 | 3 6 5 | 8 9 7 |
 | 3 6 5 | 8 9 7 | 2 1 4 |
 | 8 9 7 | 2 1 4 | 3 6 5 |
 +-------+-------+-------+
 | 5 3 1 | 6 4 2 | 9 7 8 |
 | 6 4 2 | 9 7 8 | 5 3 1 |
 | 9 7 8 | 5 3 1 | 6 4 2 |
 +-------+-------+-------+
 
 Board: boards/valid-complete.sdk
 Error: File not found.
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 
 Solved successfully!
 +-------+-------+-------+
 | 1 2 3 | 4 5 6 | 7 8 9 |
 | 4 5 6 | 7 8 9 | 1 2 3 |
 | 7 8 9 | 1 2 3 | 4 5 6 |
 +-------+-------+-------+
 | 2 1 4 | 3 6 5 | 8 9 7 |
 | 3 6 5 | 8 9 7 | 2 1 4 |
 | 8 9 7 | 2 1 4 | 3 6 5 |
 +-------+-------+-------+
 | 5 3 1 | 6 4 2 | 9 7 8 |
 | 6 4 2 | 9 7 8 | 5 3 1 |
 | 9 7 8 | 5 3 1 | 6 4 2 |
 +-------+-------+-------+
 
 Board: boards/row-violation.sdk
 Error: File not found.
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 | - - - | - - - | - - - |
 +-------+-------+-------+
 
 Solved successfully!
 +-------+-------+-------+
 | 1 2 3 | 4 5 6 | 7 8 9 |
 | 4 5 6 | 7 8 9 | 1 2 3 |
 | 7 8 9 | 1 2 3 | 4 5 6 |
 +-------+-------+-------+
 | 2 1 4 | 3 6 5 | 8 9 7 |
 | 3 6 5 | 8 9 7 | 2 1 4 |
 | 8 9 7 | 2 1 4 | 3 6 5 |
 +-------+-------+-------+
 | 5 3 1 | 6 4 2 | 9 7 8 |
 | 6 4 2 | 9 7 8 | 5 3 1 |
 | 9 7 8 | 5 3 1 | 6 4 2 |
 +-------+-------+-------+
 
 
  ----jGRASP: Operation complete.
 
*/
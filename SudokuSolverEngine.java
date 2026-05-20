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
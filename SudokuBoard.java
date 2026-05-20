import java.util.*;
import java.io.*;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public SudokuBoard(String fileName) {
        this();
        try {
            Scanner console = new Scanner(new File(fileName));
            for (int r = 0; r < board.length; r++) {
                if (console.hasNext()) {
                    String line = console.next();
                    for (int c = 0; c < board[0].length; c++) {
                        char value = line.charAt(c);
                        if (value == '.') {
                            board[r][c] = 0;
                        } else {
                            board[r][c] = value - '0';
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    public boolean isValid() {
        if (!checkNumbers())
            return false;
        if (!checkRow())
            return false;
        if (!checkCol())
            return false;
        if (!checkBox())
            return false;

        return true;
    }

    private boolean checkNumbers() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] < 0 || board[r][c] > 9) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRow() {
        for (int r = 0; r < board.length; r++) {
            Set<Integer> set = new HashSet<>();
            for (int c = 0; c < board[0].length; c++) {
                int val = board[r][c];
                if (val != 0) {
                    if (set.contains(val))
                        return false;
                    set.add(val);
                }
            }
        }

        return true;
    }

    private boolean checkCol() {
        for (int r = 0; r < board.length; r++) {
            Set<Integer> set = new HashSet<>();
            for (int c = 0; c < board[0].length; c++) {
                int val = board[c][r];
                if (val != 0) {
                    if (set.contains(val))
                        return false;
                    set.add(val);
                }
            }
        }

        return true;
    }

    private boolean checkBox() {
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                Set<Integer> set = new HashSet<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int val = board[boxRow * 3 + r][boxCol * 3 + c];
                        if (val != 0) {
                            if (set.contains(val))
                                return false;
                            set.add(val);
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isSolved() {
        if (!isValid())
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int val = board[r][c];

                if (val != 0) {
                    if (map.containsKey(val)) {
                        map.put(val, map.get(val) + 1);
                    } else {
                        map.put(val, 1);
                    }
                }
            }
        }

        for (int num = 1; num <= 9; num++) {
            if (!map.containsKey(num) || map.get(num) != 9) {
                return false;
            }
        }

        return true;
    }

    public boolean solve() {
        if (!isValid()) {
            return false;
        }
        if (isSolved()) {
            return true;
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        board[r][c] = num;
                        if (isValid() && solve()) {
                            return true;
                        }
                        board[r][c] = 0;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {
        String result = "";
        String line = "+-------+-------+-------+\n";

        for (int r = 0; r < board.length; r++) {
            if (r % 3 == 0) {
                result = result + line;
            }
            for (int c = 0; c < board[0].length; c++) {
                if (c % 3 == 0) {
                    result = result + "| ";
                }
                if (board[r][c] == 0) {
                    result = result + "- ";
                } else {
                    result = result + board[r][c] + " ";
                }
            }
            result = result + "|\n";
        }
        result = result + line;
        return result;
    }
}

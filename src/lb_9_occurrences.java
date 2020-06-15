public class lb_9_occurrences {
    public static int count(char[][] matrix, String word) {
        int result = 0;
        char[] wordChars = word.toCharArray();
        if (wordChars.length == 1) return countCharOccurrences(matrix, wordChars[0]);

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] == wordChars[0]) {
                    int[] startPos = {i, j};
                    result += allSides(matrix, wordChars, startPos);
                }
        return result;
    }

    private static int countCharOccurrences(char[][] matrix, char c) {
        int result = 0;
        for (char[] chars : matrix) for (char el : chars) if (el == c) result += 1;
        return result;
    }

    private static int allSides(char[][] matrix, char[] word, int[] startPos) {
        int result = 0;
        result += right(matrix, word, startPos);
        result += left(matrix, word, startPos);
        result += top(matrix, word, startPos);
        result += bottom(matrix, word, startPos);
        result += leftTop(matrix, word, startPos);
        result += rightTop(matrix, word, startPos);
        result += rightBottom(matrix, word, startPos);
        result += leftBottom(matrix, word, startPos);
        return result;
    }

    private static int right(char[][] matrix, char[] word, int[] startPos) {
        int j = 1;
        if (matrix[startPos[0]].length - startPos[1] < word.length) return 0;
        for (int i = startPos[1] + 1; i < matrix[startPos[0]].length; i++) {
            if (j >= word.length) break;
            if (word[j] != matrix[startPos[0]][i]) return 0;
            j += 1;
        }
        return 1;
    }

    private static int left(char[][] matrix, char[] word, int[] startPos) {
        int j = 1;
        if ((startPos[1] + 1 < word.length)) return 0;
        for (int i = startPos[1] - 1; i >= 0; i -= 1) {
            if (j >= word.length) break;
            if (word[j] != matrix[startPos[0]][i]) return 0;
            j += 1;
        }
        return 1;
    }

    private static int top(char[][] matrix, char[] word, int[] startPos) {
        int j = 1;
        if ((startPos[0] + 1 < word.length)) return 0;
        for (int i = startPos[0] - 1; i >= 0; i--) {
            if (j >= word.length) break;
            if (word[j] != matrix[i][startPos[1]]) return 0;
            j += 1;
        }
        return 1;
    }

    private static int bottom(char[][] matrix, char[] word, int[] startPos) {
        int j = 1;
        if (matrix.length - startPos[0] < word.length) return 0;
        for (int i = startPos[0] + 1; i < matrix.length; i++) {
            if (j >= word.length) break;
            if (word[j] != matrix[i][startPos[1]]) return 0;
            j += 1;
        }
        return 1;
    }

    private static int leftTop(char[][] matrix, char[] word, int[] startPos) {
        if ((startPos[0] + 1 < word.length || startPos[1] + 1 < word.length)) return 0;
        int j = 1;
        int row = startPos[0] - 1;
        int column = startPos[1] - 1;

        while (row >= 0 && column >= 0) {
            if (j >= word.length) break;
            if (word[j] != matrix[row][column]) return 0;
            row -= 1;
            column -= 1;
            j += 1;
        }
        return 1;
    }

    private static int rightTop(char[][] matrix, char[] word, int[] startPos) {
        if ((matrix[startPos[0]].length - startPos[1] < word.length || startPos[0] + 1 < word.length)) return 0;
        int j = 1;
        int row = startPos[0] - 1;
        int column = startPos[1] + 1;

        while (row >= 0 && column < matrix[0].length) {
            if (j >= word.length) break;
            if (word[j] != matrix[row][column]) return 0;
            row -= 1;
            column += 1;
            j += 1;
        }
        return 1;
    }

    private static int rightBottom(char[][] matrix, char[] word, int[] startPos) {
        if ((matrix[startPos[0]].length - startPos[1] < word.length || matrix.length - startPos[0] < word.length))
            return 0;
        int j = 1;
        int row = startPos[0] + 1;
        int column = startPos[1] + 1;

        while (row < matrix.length && column < matrix[0].length) {
            if (j >= word.length) break;
            if (word[j] != matrix[row][column]) return 0;
            row += 1;
            column += 1;
            j += 1;
        }
        return 1;
    }

    private static int leftBottom(char[][] matrix, char[] word, int[] startPos) {
        if ((startPos[1] + 1 < word.length || matrix.length - startPos[0] < word.length)) return 0;
        int j = 1;
        int row = startPos[0] + 1;
        int column = startPos[1] - 1;

        while (row < matrix.length && column >= 0) {
            if (j >= word.length) break;
            if (word[j] != matrix[row][column]) return 0;
            row += 1;
            column -= 1;
            j += 1;
        }
        return 1;
    }
}
package NumbersGame;

public class NumbersGame {
    private int[][] buildMatrix(int[] game) {
        int gameLenght = game.length;
        int[][] mat = new int[gameLenght][gameLenght];
        for (int i = 0; i < gameLenght; i++) {
            mat[i][i] = game[i];
        }
        for (int i = gameLenght - 2; i >= 0; i--) {
            for (int j = i + 1; j < gameLenght; j++) {
                mat[i][j] = Math.max(game[i] - mat[i + 1][j], game[j] - mat[i][j - 1]);
            }
        }
        return mat;
    }

    public void gameStrategy(int[] game) {
        int i = 0;
        int gameLength = game.length;
        int j = gameLength - 1;
        int first = 0;
        int second = 0;
        int firstSum = 0;
        int secondSum = 0;
        int[][] mat = buildMatrix(game);
        for (int k = 0; k < gameLength / 2; k++) {
            if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) {
                firstSum += game[i];
                first = i++;
            } else {
                firstSum += game[j];
                first = j--;
            }
            if (i != j) {
                if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) {
                    secondSum += game[i];
                    second = i++;
                } else {
                    secondSum += game[j];
                    second = j--;
                }
            } else {
                second = j;
                secondSum += game[j];
            }
            System.out.println("first: game[" + first + "] = " + game[first] + ", second: game[" + second + "] = " + game[second]);
        }
        System.out.println("firstSum = " + firstSum + ", secondSum = " + secondSum + ", diff = " + (firstSum - secondSum));
    }

    public static void main(String[] args) {
        int[] game = {6,4,3,7};
        NumbersGame n = new NumbersGame();
        n.gameStrategy(game);
    }
}

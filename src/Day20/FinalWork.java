package Day20;

import java.util.*;

public class FinalWork {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] player1 = new int[10][10];
        int[][] player2 = new int[10][10];

        System.out.print("Please enter name of first player: ");
        String name1 = scanner.nextLine();
        System.out.print("Please enter name of second player: ");
        String name2 = scanner.nextLine();

        System.out.println(name1 + "'s ship field: ");
        displayShips(player1);
        System.out.println(name2 + "'s ship field: ");
        displayShips(player2);

        playGame(name1, name2, player1, player2);
    }
    public static void displayShips(int[][] playerField){
        int x;
        int y;
        int shipSize;
        int position;

        for (int a = 0; a < 10; a++) {
            while (true) {
                System.out.print("Please enter ship size - 1 to 4: ");
                shipSize = scanner.nextInt();
                if (shipSize > 0 && shipSize < 5)
                    break;
                System.out.println("The ship size should be between 1 to 4. Please try again.");
            }
            while (true) {
                System.out.print("Please enter ship position - 1. Horizontal; 2. Vertical ");
                position = scanner.nextInt();
                if (position ==1 || position == 2)
                    break;
                System.out.println("The ship position should 1 or . Please try again.");
            }

               while (true) {
                   try {
                       System.out.print("Please enter x: ");
                       x = scanner.nextInt();
                       System.out.print("Please enter y: ");
                       y = scanner.nextInt();
                       int freeSpaceResult = freeSpace(playerField, x, y, position, shipSize);
                       if (freeSpaceResult == 0) {
                           break;
                       }
                       System.out.println("It is existed number or no free space. Please try again.");
                   } catch (ArrayIndexOutOfBoundsException e) {
                       System.out.println("The number is out of bounds. Please enter again.");
                   }
               }

            if (position == 1) {
                for (int i = 0; i < shipSize; i++) {
                    playerField[x+i][y]= '1';
                }
            }
            if (position == 2) {
                for (int j = 0; j < shipSize; j++) {
                    playerField[x][y+j] = '1';
                }
            }
        }
        printPlayerField(playerField);
    }
    public static int freeSpace(int[][] playerField, int x, int y, int position, int shipSize){
        if (position == 1){
            for (int i = 0; i < shipSize-1; i++){
                if ('1' == playerField[x+i][y] || '1' == playerField[x+i-1][y] ||
                        '1' == playerField[x+i+1][y] || '1' == playerField[x+i][y-1] ||
                        '1' == playerField[x+i][y+1]  || (x+i) < 0 || (x+i) > 9){
                    return -1;
                }
            }
        }
        else if (position == 2){
            for (int j = 0; j < shipSize-1; j++){
                if ('1' == playerField[x][y+j] || '1' == playerField[x][y+j-1] ||
                        '1' == playerField[x][y+j+1] || '1' == playerField[x-1][y+j] ||
                        '1' == playerField[x+1][y+j] ||  (y+j) < 0 || (y+j) > 9){
                    return -1;
                }
            }
        }
        return 0;
    }
    public static void printPlayerField(int[][] field) {
        for (int[] cells : field) {
            for (int cell : cells) {
                if (cell == 0) {
                    System.out.print("⬜");
                } else {
                    System.out.print("🛥");
                }
            }
            System.out.println();
        }
    }
    public static void printBattleField(int[][] field) {
        for (int[] cells : field) {
            for (int cell : cells) {
                if (cell == 0) {
                    System.out.print("⬜");
                } else {
                    System.out.print("\uD83D\uDD25");
                }
            }
            System.out.println();
        }
    }
    public static void playGame(String playerName1, String playerName2, int[][] playerField1, int[][] playerField2){
        int[][] battleField1 = new int[10][10];
        int[][] battleField2 = new int[10][10];

        String currentPlayerName = playerName1;
        int[][] currentPlayerField = playerField2;
        int[][] currentBattleField = battleField1;

        while(isPlayerAlive(playerField1) && isPlayerAlive(playerField2)) {
            System.out.println();
            System.out.println(currentPlayerName + "'s battle field");
            printBattleField(currentBattleField);

            System.out.print(currentPlayerName + ", please enter xShot:");
            int xShot = scanner.nextInt();
            System.out.print(currentPlayerName+ ", please enter yShot:");
            int yShot = scanner.nextInt();

            int shot = handleShot(currentBattleField, currentPlayerField, xShot, yShot);

                if (shot == 0) {
                    System.out.print("Please enter next player: 1. First player; 2. Second player");
                    int nextPlayer = scanner.nextInt();
                    if (nextPlayer == 1){
                        currentPlayerName = playerName1;
                        currentPlayerField = playerField2;
                        currentBattleField = battleField1;
                    }
                    if (nextPlayer == 2) {
                        currentPlayerName = playerName2;
                        currentPlayerField = playerField1;
                        currentBattleField = battleField2;
                    }
                }
        }
        System.out.println(currentPlayerName + " is winner");
    }
    public static int handleShot(int[][] battleField, int[][] playerField, int x, int y){
        if (playerField[x][y] == '1') {
            playerField[x][y] = '#';
            battleField[x][y] = '#';
            System.out.println("Good shot");
            return 1;
        }
        System.out.println("Bad shot!");
        return 0;
    }
    public static boolean isPlayerAlive(int[][] field){
        for (int[] cells : field){
            for (int cell: cells) {
                if ('1' == cell)
                    return true;
            }
        }
        return false;
    }
}

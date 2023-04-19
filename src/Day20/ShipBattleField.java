package Day20;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class ShipBattleField {
    public static void battleField(int[][] playerField1, int[][] playerField2, String playerName1, String playerName2){
        int[][] battleField1 = new int[10][10];
        int[][] battleField2 = new int[10][10];
        String currentPlayerName = playerName1;
        int[][] currentPlayerField = playerField2;
        int[][] currentBattleField = battleField1;
        Scanner scanner = new Scanner(System.in);

            while (isPlayerAlive(playerField1) && isPlayerAlive(playerField2)) {
                try {
                    System.out.println();
                    System.out.println(currentPlayerName + "'s battle field.");
                    printField(currentBattleField);
                    System.out.print(currentPlayerName + ", please enter xShot: ");
                    int xShot = scanner.nextInt();
                    System.out.print(currentPlayerName + ", please enter yShot: ");
                    int yShot = scanner.nextInt();
                    int shotFieldResult = shotField(currentPlayerField, currentBattleField, xShot, yShot);
                    if (shotFieldResult == 0) {
                        System.out.print("Please enter next player: 1. First player; 2. Second player - ");
                        int nextPlayer = scanner.nextInt();
                        if (nextPlayer == 1) {
                            currentPlayerName = playerName1;
                            currentPlayerField = playerField2;
                            currentBattleField = battleField1;
                        } else if (nextPlayer == 2) {
                            currentPlayerName = playerName2;
                            currentPlayerField = playerField1;
                            currentBattleField = battleField2;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("%s is not an int%n", scanner.nextLine());
                } catch (MissingFormatArgumentException e) {
                    System.out.printf("%s is not an int%n", scanner.nextLine());
                }
            }
        System.out.println();
        System.out.println(currentPlayerName + "'s battle field.");
        printField(currentPlayerField);
        System.out.println(currentPlayerName + " is winner");

    }

    public static int shotField(int[][] playerField, int[][] battleField, int xShot, int yShot){
        if (playerField[xShot][yShot] == '1'){
            playerField[xShot][yShot] = '#';
            battleField[xShot][yShot] = '#';
            System.out.println("Good shot");
            return 1;
        }
        System.out.println("Bad shot");
        return 0;
    }

    public static boolean isPlayerAlive(int[][] playerField){
        for (int[] cells: playerField){
            for (int cell: cells){
                if (cell == '1'){
                    return true;
                }
            }
        }
        return false;
    }

    public static void printField(int[][] playerField){
        for (int[] cells : playerField){
            for (int cell : cells){
                if (cell == 0){
                    System.out.print("⬜");
                }
                else {
                    System.out.print("\uD83D\uDD25");
                }
            }
            System.out.println();
        }
    }

}

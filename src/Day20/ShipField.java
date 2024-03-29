package Day20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShipField {
    static Scanner scanner = new Scanner(System.in);
    public static void displayShips(int[][] playerField) {
        int x;
        int y;
        int position;
        int shipSize;
        for (int k = 0; k < 10; k++) {

            while (true) {
                try {
                    System.out.print("Please enter ship size 1 to 4: ");
                    shipSize = scanner.nextInt();
                    if (shipSize >= 1 && shipSize <= 4) {
                        break;
                    }
                    System.out.println("The number should be between 1 and 4. Please try again.");
                }catch (InputMismatchException e){
                    System.out.printf("%s is not an int%n", scanner.nextLine());
                }
            }

            while (true) {
                try {
                    System.out.print("Please enter ship position: 1. Horizontal; 2. Vertical - ");
                    position = scanner.nextInt();
                    if (position == 1 || position == 2) {
                        break;
                    }
                    System.out.println("The number should be 1 or 2. Please try again.");
                } catch (InputMismatchException e) {
                    System.out.printf("%s is not an int%n", scanner.nextLine());
                }
            }

            while (true) {
                try {
                    System.out.print("Please enter x: ");
                    x = scanner.nextInt();
                    System.out.print("Please enter y: ");
                    y = scanner.nextInt();
                    int freeSpaceResult = freeSpace(x, y, position, shipSize, playerField);
                    if (freeSpaceResult == 0) {
                        break;
                    }
                    System.out.println("No free spaces. Please try again.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The number is out of bounds. Please enter again.");
                }
                catch (InputMismatchException e){
                    System.out.printf("%s is not an int%n", scanner.nextLine());
                }
            }

            if (position == 1){
                for (int a = 0; a < shipSize; a++){
                    playerField[y][x+a] = '1';
                }
            }
            if (position == 2){
                for (int b = 0; b < shipSize; b++){
                    playerField[y+b][x] = '1';
                }
            }
            printField(playerField);
        }
    }

    public static int freeSpace(int x, int y, int position, int shipSize, int[][] playerField){
        if (position == 1){
            for (int j = 0; j < shipSize-1; j++){
                if (playerField[y][x+j] == '1' || playerField[y+1][x+j] == '1' || playerField[y-1][x+j] == '1' ||
                        playerField[y][x+j+1] == '1' || playerField[y][x-1] == '1' || (x+j) > 9 || (x+j) < 0){
                    return -1;
                }
            }
        }


        if (position == 2){
            for (int i = 0; i < shipSize-1; i++){
                if (playerField[y+i][x] == '1' || playerField[y+i][x+1] == '1' || playerField[y+i][x-1] == '1' ||
                        playerField[y+i+1][x] == '1' || playerField[y-1][x] == '1' || (y+i) > 9 || (y+i) < 0){
                    return -1;
                }
            }
        }

        return 0;
    }

    public static void printField(int[][] playerField){
        for (int[] cells : playerField){
            for (int cell : cells){
                if (cell == 0){
                    System.out.print("⬜");
                }
                else {
                    System.out.print("🛥");
                }
            }
            System.out.println();
        }
    }
}

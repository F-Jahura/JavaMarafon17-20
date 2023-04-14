package Day20;

import java.util.Scanner;

public class FinalWork {
    public static void main(String[] args) {
        int[][] playerField1 = new int [10][10];
        int[][] playerField2 = new int[10][10];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter first player name: ");
        String name1 = scanner.nextLine();
        System.out.print("Please enter second player name: ");
        String name2 = scanner.nextLine();

        System.out.print(name1 + "'s ship field: \n");
        ShipField.displayShips(playerField1);
        System.out.print(name2 + "'s ship field: \n");
        ShipField.displayShips(playerField2);

        ShipBattleField.battleField(playerField1, playerField2, name1, name2);


    }
}

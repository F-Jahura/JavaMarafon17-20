package Day19Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task19_2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("taxi_cars.txt");
        Scanner scanner = new Scanner(file);
        Map<Integer, Point> map = new HashMap<>();
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Please enter the coordination of cars:");
        System.out.print("x1: ");
        int  x1 = scanner1.nextInt();
        System.out.print("x2: ");
        int x2 = scanner1.nextInt();
        System.out.print("y1: ");
        int y1 = scanner1.nextInt();
        System.out.print("y2: ");
        int y2 = scanner1.nextInt();
        System.out.println();
        System.out.println("The ID of cars is in selected zone:");

        int carsNumber = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            map.put(Integer.parseInt(numbers[0]), new Point(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2])));
            }

        for (Map.Entry<Integer, Point> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            //System.out.println(entry.getValue());
            Point valueNumber = entry.getValue();

            if (valueNumber.getX() > x1 && valueNumber.getX() < x2 && valueNumber.getY() > y1 && valueNumber.getY() < y2) {
                System.out.println("ID: " + entry.getKey());
                carsNumber++;
            }
        }
        System.out.println("The total number of cars is in selected zone: " + carsNumber);
    }
}

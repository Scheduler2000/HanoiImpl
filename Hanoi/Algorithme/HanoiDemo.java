package Hanoi.Algorithme;

import java.util.Scanner;

/**
 * @author Tasnim Bennacer & Badiss Rachdi.
 * 
 * @description Call HanoiDemo.Demo() from your Main.java.
 */
public class HanoiDemo {
    public static void Demo() {
        int n = SaisirNombreDisques();
        var hanoi = new Hanoi(n);

        hanoi.Resoudre();
    }

    private static int SaisirNombreDisques() {
        int input = 0;
        var scanner = new Scanner(System.in);

        do {
            System.out.println("Veuillez saisir le nombre de disques pour la tours de hanoi ]0;n]: ");
            input = scanner.nextInt();
        } while (input <= 0);

        scanner.close();
        System.out.println("");
        return input;
    }
}

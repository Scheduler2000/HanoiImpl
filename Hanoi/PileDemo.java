package Hanoi;

import java.util.Random;

/**
 * @author Tasnim Bennacer
 */
public class PileDemo {
    public static void Demo() {
        var P1 = new PileEntiers("P1");
        var P2 = new PileEntiers("P2");
        var P3 = new PileEntiers("P3");
        var temp = new int[5];
        var rnd = new Random();

        for (int i = 0; i < 5; i++) {
            P1.Empiler(rnd.nextInt(100));
        }
        System.out.println("Avant depilement : ");

        System.out.println("--------------------------------- ");
        P1.Afficher();

        for (int i = 0; i < 5; i++) {
            var elt = P1.Depiler();

            if (elt % 2 == 0)
                P2.Empiler(elt);

            else
                P3.Empiler(elt);

            temp[i] = elt;
        }

        for (int i = 0; i < temp.length; i++)
            P1.Empiler(temp[temp.length - i - 1]); /*
                                                    * LIFO (Last In First Out) | Or before looping reverse array
                                                    */
        System.out.println("--------------------------------- ");

        P2.Afficher();
        P3.Afficher();
        P1.Afficher();

    }
}

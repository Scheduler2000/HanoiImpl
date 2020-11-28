package Hanoi.Algorithme;

import java.util.Arrays;
import java.util.Random;

import Hanoi.PileEntiers;

/**
 * @author Tasnim Bennacer & Badiss Rachdi
 */
public class Hanoi {
    private PileEntiers _depart;
    private PileEntiers _intermediaire;
    private PileEntiers _final;
    private int _length;

    private Hanoi() {
        this._depart = new PileEntiers("A");
        this._intermediaire = new PileEntiers("B");
        this._final = new PileEntiers("C");
    }

    public Hanoi(int length) {
        this();
        this._length = length;

        var rnd = new Random();
        var temp = new int[length];

        for (int i = 0; i < length; i++)
            temp[i] = rnd.nextInt(1000);

        Arrays.sort(temp);
        for (int i = length - 1; i >= 0; i--)
            this._depart.Empiler(temp[i]);
    }

    public void Resoudre() {
        System.out.println("Tours de départ : ");
        _depart.Afficher();

        hanoi(_length, _depart, _final, _intermediaire);
    }

    private static void hanoi(int n, PileEntiers depart, PileEntiers arrivee, PileEntiers intermediaire) {
        if (n == 1) {

            int depil = depart.Depiler();
            arrivee.Empiler(depil);
            System.out.println(String.format("Deplacement |%s| : [%s] - > [%s]", depil, depart.Name(), arrivee.Name()));

            return;
        }
        hanoi(n - 1, depart, intermediaire, arrivee);

        int depil = depart.Depiler();
        arrivee.Empiler(depil);
        System.out.println(String.format("Deplacement |%s| : [%s] -> [%s]", depil, depart.Name(), arrivee.Name()));

        hanoi(n - 1, intermediaire, arrivee, depart);
    }

}

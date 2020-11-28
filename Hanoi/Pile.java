package Hanoi;

/**
 * Custom stack(LIFO) type created with internal ArrayList.
 * 
 * @author Tasnim Bennacer
 * 
 */
public class Pile<TEntity> {

    protected final Liste<TEntity> _interne;
    private String _name;

    public int Length() {
        return _interne.Length();
    }

    public String Name() {
        return _name;
    }

    public Pile(String name) {
        this._interne = new Liste<TEntity>();
        this._name = name;
    }

    public void Empiler(TEntity element) {
        _interne.Dernier();
        _interne.Ajouter(element);
    }

    public TEntity Depiler() {
        var deleted = _interne.Dernier();
        _interne.Supprimer();
        return deleted;
    }

    public void Afficher() {
        System.out.println(String.format("Affichage %s :", _name));
        _interne.ForEach((elt) -> {
            System.out.println(String.format("\t- %s", elt));
        });
        System.out.println("");
    }
}

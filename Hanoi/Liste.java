package Hanoi;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Custom list type created with internal ArrayList.
 * 
 * @author Tasnim Bennacer
 * 
 */
public class Liste<TEntity> {

    private final ArrayList<TEntity> _interne;
    private int _indice;

    public int Length() {
        return _interne.size();
    }

    public Liste() {
        this._interne = new ArrayList<TEntity>();
        this._indice = -1;
    }

    public TEntity Premier() {
        if (_interne.size() == 0)
            return null;

        _indice = 0;
        return _interne.get(_indice);
    }

    public TEntity Dernier() {
        if (_interne.size() == 0)
            return null;

        _indice = _interne.size() - 1;
        return _interne.get(_indice);
    }

    public TEntity Suivant() {
        if (_interne.size() == 0) {
            System.out.println("La liste a zero element. Element suivant indisponible.");
            return null;
        }

        if (_indice == _interne.size() - 1) {
            System.out.println("Element suivant non existant, vous êtes deja au dernier element.");
            return _interne.get(_indice);
        }

        _indice += 1;
        return _interne.get(_indice);
    }

    public TEntity Supprimer() {
        if (_interne.size() == 0) {
            System.out.println("La liste a zero element. Impossible de supprimer un element.");
            return null;
        }

        _interne.remove(_indice);
        _indice -= 1;
        return (_indice < 0) ? null : _interne.get(_indice);
    }

    public void Ajouter(TEntity element) {
        _interne.add(element);
        _indice += 1;
    }

    /**
     * Method applied to each element of the array without modifying them.
     * 
     * @param func
     */
    public void ForEach(Consumer<TEntity> func) {
        for (TEntity elt : _interne) {
            func.accept(elt);
        }
    }

    /**
     * Method that modifies the contents of the array on the loop.
     * 
     * @param func function that modifying array over the loop.
     */
    public void ForEach(Function<TEntity, TEntity> func) {
        for (int i = 0; i < _interne.size(); i++) {
            _interne.set(i, func.apply(_interne.get(i)));
        }
    }
}

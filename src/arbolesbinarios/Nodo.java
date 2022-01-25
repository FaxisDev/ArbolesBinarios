package arbolesbinarios;

/**
 *
 * @author Michel
 */
public class Nodo {

    //Atributos del nodo
    protected int dato;
    protected Nodo izq;
    protected Nodo der;

    public Nodo(int dato) {
        this.dato = dato;
        izq = null;
        der = null;
    }
}

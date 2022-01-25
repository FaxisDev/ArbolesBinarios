package arbolesbinarios;

import java.util.Scanner;

/**
 *
 * @author Michel
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertarNodo(int dato) {
        Nodo nuevonodo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevonodo;
        } else {
            Nodo temp = raiz;
            Nodo padre;
            while (true) {
                padre = temp;
                if (dato < temp.dato) {
                    temp = temp.izq;
                    if (temp == null) {

                        padre.izq = nuevonodo;
                        System.out.println("Nodo Izquierdo");
                        break;
                    }

                } else {
                    temp = temp.der;
                    if (temp == null) {
                        padre.der = nuevonodo;
                        System.out.println("Nodo Derecho");
                        break;

                    }
                }
            }
        }
    }

//MENU DE ACCIONES PARA EL ARBOL...
    public void Main() {
        Scanner x = new Scanner(System.in);

        do {
            System.out.println("Selecciona una opcion a realizar:\n "
                    + "1.Crear arbol\n"
                    + "2.Agregar datos\n"
                    + "3.Recorridos\n"
                    + "4.Vaciar Arbol\n"
                    + "5.Salir");

            int opcion;
            int cantidadNodos = 0;

            System.out.print(">>>>");
            opcion = x.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuantos nodos vas a insertar?");
                    cantidadNodos = x.nextInt();
                case 2:
                    int i = 0;
                    while (i < cantidadNodos) {
                        System.out.println("Inserta el nodo " + (i + 1) + ":");
                        int valor = x.nextInt();
                        this.insertarNodo(valor);
                        i++;
                    }
                    break;
                case 3:
                    System.out.println("Recorrido InOrden:");
                    this.InOrden(raiz);
                    System.out.println("\n");
                    System.out.println("Recorrido PosOrden:");
                    this.PosOrden(raiz);
                    System.out.println("\n");
                    System.out.println("Recorrido PreOrden:");
                    this.PreOrden(raiz);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Tu arbol a sido vaciado, ya no tienes ningun nodo insertado");
                    this.Vaciar();
                    break;
                case 5:
                    System.out.println("Gracias por ocupar el programar");
                    System.exit(0);
                default:

                    System.out.println("Esa opcion no existe");
            }

        } while (true);

    }

    public void Vaciar() {
        raiz = null;
    }

    public void InOrden(Nodo padre) {

        if ((padre != null)) {
            System.out.print((padre.dato + "->"));
            PreOrden(padre.izq);
            PreOrden(padre.der);
        }
    }

    public void PosOrden(Nodo padre) {
        if (padre != null) {
            PosOrden(padre.izq);
            PosOrden(padre.der);
            System.out.print(padre.dato + "->");
//            PreOrden(padre.izq);
//            PreOrden(padre.der);

        }
    }

    public void PreOrden(Nodo padre) {
        if (padre != null) {
            PosOrden(padre.der);
            PosOrden(padre.izq);
            System.out.print(padre.dato + "->");
            PreOrden(padre.der);
            PreOrden(padre.izq);

        }
    }

}

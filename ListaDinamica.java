import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaDinamica {
    private Nodo primerNodo;
    private Nodo ultimoNodo;

    public ListaDinamica() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public Nodo getPrimerNodo() { return primerNodo; }

    public Nodo getUltimoNodo() { return ultimoNodo; }

    public void insertarProceso(Proceso proceso) {
        Nodo nuevoNodo = new Nodo(proceso);
        if (!this.listaVacia()) {
            this.ultimoNodo.setSiguiente(nuevoNodo);
        } else {
            this.primerNodo = nuevoNodo;
        }
        this.ultimoNodo = nuevoNodo;
        this.mostrar();
    }

    public Proceso eliminarProceso() {
        if (listaVacia()) {
            return null;
        }
        Proceso proceso = this.primerNodo.getProceso();
        this.primerNodo = this.primerNodo.getSiguiente();
        if (this.primerNodo == null) {
            this.ultimoNodo = null;
        }
        System.out.println("Se elimino el proceso " + proceso.toString());
        this.mostrar();
        return proceso;
    }

    private boolean listaVacia() {
        return this.primerNodo == null;
    }

    public Proceso primerNodo() {
        if (this.primerNodo == null) {
            return null;
        }
        return this.primerNodo.getProceso();
    }

    public void mostrar() {
        if (this.listaVacia()) {
            System.out.println("No hay procesos en la lista, se encuentra vacía.");
            return;
        }
        Nodo nodo = this.primerNodo;
        System.out.println("Procesos en la lista: ");
        while (nodo != null) {
            System.out.println(nodo.getProceso());
            nodo = nodo.getSiguiente();
        }
    }

    public void ordenarLista() {
        if (this.listaVacia()) {
            System.out.println("No hay procesos en la lista.");
            return;
        }
        Nodo nodo = this.primerNodo;
        List<Proceso> auxiliar = new ArrayList<>();

        while (nodo != null) {
            auxiliar.add(nodo.getProceso());
            nodo = nodo.getSiguiente();
        }

        auxiliar.sort((p1, p2) -> {
                if (p1.getPrioridadProceso() != p2.getPrioridadProceso()) {
                    return p2.getPrioridadProceso() - p1.getPrioridadProceso();
                } else {
                    return p1.getTiempoLlegada() - p2.getTiempoLlegada();
                }
        });

        this.primerNodo = null;
        this.ultimoNodo = null;

        for (Proceso proceso : auxiliar) {
            this.insertarProceso(proceso);
        }
    }
}

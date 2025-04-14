import java.util.ArrayList;
import java.util.List;

public class ListaDinamica {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int tamanioMemoria = 1024;
    final boolean listosEjecucion;

    public ListaDinamica(boolean listaEjecucion) {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.listosEjecucion = listaEjecucion;
    }

    public Nodo getPrimerNodo() { return primerNodo; }

    public Nodo getUltimoNodo() { return ultimoNodo; }

    public int getTamanioMemoria() { return tamanioMemoria; }

    private boolean disminuirMemoria(int tamanioProceso) {
        if (tamanioMemoria >= tamanioProceso ) {
            this.tamanioMemoria -= tamanioProceso;
            System.out.println("La memoria disponible disminuyo. Memoria: "+getTamanioMemoria()+" [kB]");
            return true;
        } else {
            System.out.println("No hay memoria suficiente.");
            return false;
        }
    }

    private void liberarMemoria(int tamanioProceso) {
        this.tamanioMemoria += tamanioProceso;
        System.out.println("Se liberó memoria. Memoria: "+getTamanioMemoria()+" [kB]");
    }

    public boolean insertarProceso(Proceso proceso) {
        Nodo nuevoNodo = new Nodo(proceso);
        if (listosEjecucion) {
            if (!disminuirMemoria(proceso.getTamanioProceso())) {
                return false;
            }
        }
        if (!this.listaVacia()) {
            this.ultimoNodo.setSiguiente(nuevoNodo);
        } else {
            this.primerNodo = nuevoNodo;
        }
        this.ultimoNodo = nuevoNodo;
        mostrar();
        return true;
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
        if (listosEjecucion) {
            liberarMemoria(proceso.getTamanioProceso());
        }
        mostrar();
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
        if (listaVacia()) {
            System.out.println("No hay procesos en la lista, se encuentra vacía.");
            return;
        }
        Nodo nodo = this.primerNodo;
        System.out.println("Estado actual de la lista: ");
        while (nodo != null) {
            System.out.println(nodo.getProceso());
            nodo = nodo.getSiguiente();
        }
        System.out.println("==================================");
    }

    public void ordenarLista() {
        if (listaVacia()) {
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
        this.tamanioMemoria = 1024;
        System.out.println("Se liberó la memoria para ordenar la lista.");

        for (Proceso proceso : auxiliar) {
            insertarProceso(proceso);
        }
    }
}

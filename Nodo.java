public class Nodo {
    private Proceso proceso;
    private Nodo siguiente;

    public Nodo() {}

    public Nodo(Proceso proceso) {
        this.proceso = proceso;
        this.siguiente = null;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setSiguiente(Nodo siguiente) {
        if (this.siguiente == null) {
            this.siguiente = siguiente;
        } else {
            this.siguiente.setSiguiente(siguiente);
        }
    }

    public Nodo getSiguiente() { return siguiente; }
}

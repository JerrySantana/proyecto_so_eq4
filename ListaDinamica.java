public class ListaDinamica {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private Nodo[] nodos;

    int tamanio;

    public ListaDinamica(int tamanio) {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.nodos = new Nodo[tamanio];
    }

    public Nodo getNodo(int index) {
        if (this.nodos[index] != null) {
            if (index < this.tamanio) {
                if (index > 0) {
                    return this.nodos[index - 1];
                } else if (index == this.tamanio - 1) {
                    return this.getUltimoNodo();
                } else {
                    return this.getPrimerNodo();
                }
            }
        }
        return new Nodo(new Proceso("aux", "aux", 1, 1));
    }

    public Nodo getPrimerNodo() { return primerNodo; }

    public Nodo getUltimoNodo() { return ultimoNodo; }

    public int getTamanio() { return tamanio; }

    public void aumentar() { this.tamanio++; }

    public void disminuir() { this.tamanio--; }

    public void insertarNodo(Nodo nodo) {
        assert nodo != null;
        if (this.getTamanio() > 0) {
            this.ultimoNodo.setSiguiente(nodo);
            this.nodos[this.tamanio + 1] = nodo;
        } else {
            this.primerNodo = nodo;
        }
        this.ultimoNodo = nodo;
        this.aumentar();
        //this.mostrar();
    }

    public Nodo eliminarNodo(int index) {
        Nodo nodo = null;
        if (index > 0) {
            nodo = this.nodos[index];
            if (this.nodos[index].getSiguiente() != this.getUltimoNodo()) {
                this.nodos[index-1].setSiguiente(this.nodos[index].getSiguiente());
                this.nodos[index].setSiguiente(null);
                for (int i = index - 1; i < (this.tamanio - 1); i--) {
                    if (i != this.tamanio - 2) {
                        this.nodos[i] = this.nodos[i + 1];
                    } else {
                        this.nodos[i] = null;
                    }
                }
            } else {
                this.nodos[index - 1].setSiguiente(null);
                this.ultimoNodo = this.nodos[index - 1];

            }
            this.disminuir();
        }
        return nodo;
    }

    public void mostrar() {
        if (this.tamanio > 0) {
            for (int i = 0; i < (this.tamanio - 1); i++) {
                System.out.print(getNodo(i).toString() + " -> ");
            }
        } else {
            System.out.println("La lista se encuentra vacia.");
        }
    }
}

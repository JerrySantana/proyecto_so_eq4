
public static void main(String[] args) {
    System.out.println("Hello World");
    ListaDinamica lista = new ListaDinamica(100);
    Proceso proceso1 = new Proceso("1", "A", 1, 1);
    Proceso proceso2 = new Proceso("2", "B", 1, 1);
    Proceso proceso3 = new Proceso("3", "C", 1, 1);
    Proceso proceso4 = new Proceso("4", "D", 1, 1);
    Nodo nodo1 = new Nodo(proceso1);
    lista.insertarNodo(nodo1);
    Nodo nodo2 = new Nodo(proceso2);
    lista.insertarNodo(nodo2);
    Nodo nodo3 = new Nodo(proceso3);
    lista.insertarNodo(nodo3);
    Nodo nodo4 = new Nodo(proceso4);
    lista.insertarNodo(nodo4);
    Nodo nodo5 = new Nodo(proceso3);
    lista.insertarNodo(nodo5);
    Nodo nodo6 = new Nodo(proceso2);
    lista.insertarNodo(nodo6);
    Nodo nodo7 = new Nodo(proceso1);
    lista.insertarNodo(nodo7);
    Nodo nodo8 = new Nodo(proceso3);
    lista.insertarNodo(nodo8);
    Nodo nodo9 = new Nodo(proceso4);
    lista.insertarNodo(nodo9);
    Nodo nodo10 = new Nodo(proceso2);
    lista.insertarNodo(nodo10);

    lista.mostrar();

    lista.eliminarNodo(4);

    System.out.println("=====================================");

    lista.mostrar();

}
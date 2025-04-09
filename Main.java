
public static void main(String[] args) {
    ListaDinamica lista = new ListaDinamica();
    Proceso proceso1 = new Proceso("1", "A", 1, 4, 1);
    Proceso proceso2 = new Proceso("2", "B", 1, 3, 5);
    Proceso proceso3 = new Proceso("3", "C", 1, 1, 2);
    Proceso proceso4 = new Proceso("4", "D", 1, 6, 4);
    Proceso proceso5 = new Proceso("5", "E", 1, 2, 2);
    Proceso proceso6 = new Proceso("6", "F", 1, 5, 4);
    Proceso proceso7 = new Proceso("7", "G", 1, 10, 3);
    Proceso proceso8 = new Proceso("8", "H", 1, 3, 10);

    System.out.println("Iniciando inserción de procesos.");
    lista.insertarProceso(proceso1);
    lista.insertarProceso(proceso2);
    lista.insertarProceso(proceso3);
    lista.insertarProceso(proceso4);
    lista.insertarProceso(proceso5);
    lista.insertarProceso(proceso6);
    lista.insertarProceso(proceso7);
    lista.insertarProceso(proceso8);
    System.out.println("=====================================");
    System.out.println("Ordenando procesos.");
    lista.ordenarLista();
    System.out.println("Lista de procesos ordenada.");
    System.out.println("=====================================");
    System.out.println("Eliminando un proceso.");
    System.out.println(lista.eliminarProceso().toString());
    System.out.println("=====================================");
    System.out.println("Eliminando un proceso.");
    System.out.println(lista.eliminarProceso().toString());
    System.out.println("=====================================");


}
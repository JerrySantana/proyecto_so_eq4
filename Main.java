
public static void main(String[] args) {
    ListaDinamica lista = new ListaDinamica(false);
    Proceso proceso1 = new Proceso("1", "A", 100, 25, 4, 1);
    Proceso proceso2 = new Proceso("2", "B", 125, 19, 3, 5);
    Proceso proceso3 = new Proceso("3", "C", 250, 20, 1, 2);
    Proceso proceso4 = new Proceso("4", "D", 500, 30, 6, 4);
    Proceso proceso5 = new Proceso("5", "E", 24, 65, 2, 2);
    Proceso proceso6 = new Proceso("6", "F", 189, 10, 5, 4);
    Proceso proceso7 = new Proceso("7", "G", 276, 1, 10, 3);
    Proceso proceso8 = new Proceso("8", "H", 532, 3, 3, 10);

    ListaDinamica ram = new ListaDinamica(true);
    System.out.println("Iniciando inserción de procesos.");
    ram.insertarProceso(proceso1);
    ram.insertarProceso(proceso2);
    ram.insertarProceso(proceso3);
    ram.insertarProceso(proceso4);
    ram.insertarProceso(proceso5);
    ram.insertarProceso(proceso6);
    ram.insertarProceso(proceso7);
    ram.insertarProceso(proceso8);
    System.out.println("=====================================");
    System.out.println("Ordenando procesos.");
    ram.ordenarLista();
    System.out.println("Lista de procesos ordenada.");
    System.out.println("=====================================");
    System.out.println("Eliminando un proceso.");
    System.out.println(ram.eliminarProceso().toString());
    System.out.println("=====================================");
    System.out.println("Eliminando un proceso.");
    System.out.println(ram.eliminarProceso().toString());
    System.out.println("=====================================");
}
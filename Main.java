/* TODO Simular la configuración round robin, acomodar bien lo procesos a partir de su tiempo de llegada y de su tiempo que ya se ejecutó.*/
/* TODO Añadir la lógica para medir los tiempos de ejecución, de respuesta y de respuesta..*/

public static void main(String[] args) {
    ListaDinamica lista = new ListaDinamica(false);
    PlanificadorProcesos roundRobin;
    Proceso proceso1 = new Proceso("1", "A", 100, 25, 4, 1);
    Proceso proceso2 = new Proceso("2", "B", 125, 10, 3, 5);
    Proceso proceso3 = new Proceso("3", "C", 250, 6, 1, 2);
    Proceso proceso4 = new Proceso("4", "D", 500, 8, 6, 4);
    Proceso proceso5 = new Proceso("5", "E", 24, 3, 2, 2);
    Proceso proceso6 = new Proceso("6", "F", 189, 10, 5, 4);
    Proceso proceso7 = new Proceso("7", "G", 276, 1, 10, 3);
    Proceso proceso8 = new Proceso("8", "H", 532, 3, 3, 10);
    Proceso proceso9 = new Proceso("9", "I", 700, 15, 5, 6);
    Proceso proceso10 = new Proceso("10", "J", 895, 9, 1, 1);

    lista.insertarProceso(proceso1);
    lista.insertarProceso(proceso2);
    lista.insertarProceso(proceso3);
    lista.insertarProceso(proceso4);
    lista.insertarProceso(proceso5);
    lista.insertarProceso(proceso6);
    lista.insertarProceso(proceso7);
    lista.insertarProceso(proceso8);
    lista.insertarProceso(proceso9);
    lista.insertarProceso(proceso10);
    System.out.println("========== Iniciando simulación Round Robin... ==========");
    roundRobin = new PlanificadorProcesos(4, lista);
    roundRobin.ejecutarProceso();
    System.out.println("========== Resultados de la simulación... ==========");
    System.out.println(proceso1);
    System.out.println(proceso2);
    System.out.println(proceso3);
    System.out.println(proceso4);
    System.out.println(proceso5);
    System.out.println(proceso6);
    System.out.println(proceso7);
    System.out.println(proceso8);
    System.out.println(proceso9);
    System.out.println(proceso10);
}
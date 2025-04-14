public class Proceso {
    private final String idProceso;
    private final String nombreProceso;
    private final int tamanioProceso;
    private int tiempoRequerido;
    private final int prioridadProceso;
    private final int tiempoLlegada;

    public Proceso(String idProceso, String nombreProceso, int tamanioProceso, int tiempoRequerido, int prioridadProceso, int tiempoLlegada) {
        this.idProceso = idProceso;
        this.nombreProceso = nombreProceso;
        if (tamanioProceso <= 0) {
            throw new IllegalArgumentException("El tamaño del proceso debe ser mayor que 0");
        }
        this.tamanioProceso = tamanioProceso;
        this.tiempoRequerido = tiempoRequerido;
        this.prioridadProceso = prioridadProceso;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getIdProceso() { return idProceso; }

    public String getNombreProceso() { return nombreProceso; }

    public int getTamanioProceso() { return tamanioProceso; }

    public int getTiempoRequerido() { return tiempoRequerido; }

    public int getPrioridadProceso() { return prioridadProceso; }

    public int getTiempoLlegada() { return tiempoLlegada; }

    @Override
    public String toString() {
        return "ID: "+this.getIdProceso()+" - Nombre: "+this.getNombreProceso()+" - Prioridad: "+this.getPrioridadProceso()+" - Llegada: "+this.getTiempoLlegada()+" [ms] - Tamanio: "+this.getTamanioProceso()+" [kB] - Tiempo Requerido: "+this.getTiempoRequerido()+" [ms]";
    }
}

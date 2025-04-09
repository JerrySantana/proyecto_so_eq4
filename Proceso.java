public class Proceso {
    private final String idProceso;
    private final String NombreProceso;
    private final int tamanioProceso;
    private int tiempoRequerido;
    private final int prioridadProceso;
    private final int tiempoLlegada;

    public Proceso(String idProceso, String NombreProceso, int tiempoRequerido, int prioridadProceso, int tiempoLlegada) {
        this.idProceso = idProceso;
        this.NombreProceso = NombreProceso;
        this.tamanioProceso = tiempoRequerido;
        this.tiempoRequerido = tiempoRequerido;
        this.prioridadProceso = prioridadProceso;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getIdProceso() { return idProceso; }

    public String getNombreProceso() { return NombreProceso; }

    public int getTamanioProceso() { return tamanioProceso; }

    public int getTiempoRequerido() { return tiempoRequerido; }

    public int getPrioridadProceso() { return prioridadProceso; }

    public int getTiempoLlegada() { return tiempoLlegada; }

    @Override
    public String toString() {
        return "ID proceso: "+this.getIdProceso()+" - Nombre proceso: "+this.getNombreProceso()+" - Prioridad: "+this.getPrioridadProceso()+" - Llegada: "+this.getTiempoLlegada();
    }
}

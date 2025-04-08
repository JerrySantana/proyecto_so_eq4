public class Proceso {
    String idProceso;
    String NombreProceso;
    int tamanioProceso;
    int tiempoRequerido;
    int prioridadProceso;

    public Proceso() {}

    public Proceso(String idProceso, String NombreProceso, int tiempoRequerido, int prioridadProceso) {
        this.idProceso = idProceso;
        this.NombreProceso = NombreProceso;
        this.tamanioProceso = tiempoRequerido;
        this.tiempoRequerido = tiempoRequerido;
        this.prioridadProceso = prioridadProceso;
    }

    public String getIdProceso() { return idProceso; }

    public String getNombreProceso() { return NombreProceso; }

    public int getTamanioProceso() { return tamanioProceso; }

    public int getTiempoRequerido() { return tiempoRequerido; }

    public int getPrioridadProceso() { return prioridadProceso; }

}

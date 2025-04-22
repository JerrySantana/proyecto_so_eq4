public class Proceso {
    private final String idProceso;
    private final String nombreProceso;
    private final int tamanioProceso;
    private int tiempoRequerido;
    private final int prioridadProceso;
    private final int tiempoLlegada;
    private int tiempoEspera;
    private int tiempoRespuesta;
    private int tiempoEjecucion;
    public int ultimaSubida;
    public int primeraSubida;
    public int vecesSubida;
    public int tiempoUltimaEjecucion;

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
        this.tiempoEspera = 0;
        this.tiempoRespuesta = 0;
        this.tiempoEjecucion = 0;
        this.ultimaSubida = 0;
        this.primeraSubida = 0;
        this.vecesSubida = 0;
        this.tiempoUltimaEjecucion = 0;
    }

    public String getIdProceso() { return idProceso; }

    public String getNombreProceso() { return nombreProceso; }

    public int getTamanioProceso() { return tamanioProceso; }

    public int getTiempoRequerido() { return tiempoRequerido; }

    public int getPrioridadProceso() { return prioridadProceso; }

    public int getTiempoLlegada() { return tiempoLlegada; }

    public void disminuirTiempoRequerido() { this.tiempoRequerido -= 1; }

    public void setTiempoEspera(int cpuQuantum) {
        this.tiempoEspera = this.ultimaSubida - this.tiempoLlegada - ((this.vecesSubida - 1) * cpuQuantum);
    }

    public void setTiempoRespuesta() {
        this.tiempoRespuesta = this.primeraSubida - this.tiempoLlegada;
    }

    public void setTiempoEjecucion() {
        this.tiempoEjecucion = this.tiempoUltimaEjecucion - this.tiempoLlegada;
    }

    @Override
    public String toString() {
        return "ID: "+this.getIdProceso()+
                " - Nombre: "+this.getNombreProceso()+
                " - Prioridad: "+this.getPrioridadProceso()+
                " - Llegada: "+this.getTiempoLlegada()+
                " [ms] - Tamanio: "+this.getTamanioProceso()+
                " [kB] - Tiempo Requerido: "+this.getTiempoRequerido()+
                " [ms] - Tiempo Ultima Vez Que Subio: "+this.ultimaSubida+
                " [ms] - Tiempo Primera Vez Que Subio: "+this.primeraSubida+
                " [ms] - Tiempo Última Ejecución: "+this.tiempoUltimaEjecucion+"\n"+
                "Tiempo de espera: "+this.tiempoEspera+" [ms],\t"+
                "Tiempo de respuesta: "+this.tiempoRespuesta+" [ms],\t"+
                "Tiempo de ejecución: "+this.tiempoEjecucion+" [ms].";
    }
}

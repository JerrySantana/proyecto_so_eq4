import java.util.concurrent.TimeUnit;

public class PlanificadorProcesos {
    int cpuQuantum;
    private ListaDinamica procesosListos;
    private ListaDinamica procesosEnEjecucion;
    private int tiempoCPU;

    public PlanificadorProcesos(int cpuQuantum, ListaDinamica procesosListos) {
        this.procesosListos = procesosListos;
        this.cpuQuantum = cpuQuantum;
        this.procesosEnEjecucion = new ListaDinamica(true);
        this.tiempoCPU = 0;
    }

    public void ejecutarProceso() {
        procesosListos.ordenarListaPorLlegada();
        System.out.println("========== Ejecutando procesos... ==========");
        while (!procesosListos.listaVacia() || !procesosEnEjecucion.listaVacia()) {
            int tiempoTranscurrido = 0;

            subidaAMemoria();

            if (!procesosEnEjecucion.listaVacia()) {
                Proceso proceso = procesosEnEjecucion.eliminarProceso();
                if (proceso.vecesSubida == 0) {
                    proceso.primeraSubida = tiempoCPU;
                }
                proceso.vecesSubida++;
                proceso.ultimaSubida = tiempoCPU;

                if (procesosListos.getPrimerNodo() != null && procesosListos.getPrimerNodo().getProceso().getTamanioProceso() <= procesosEnEjecucion.getTamanioMemoria() && procesosListos.getPrimerNodo().getProceso().getTiempoLlegada() <= tiempoCPU) {
                    System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                    Proceso procesoAux = procesosListos.eliminarProceso();
                    System.out.printf("[Carga] Proceso %s cargado en memoria.\n", procesoAux.getNombreProceso());
                    procesosEnEjecucion.insertarProceso(procesoAux);
                    System.out.println("=============================================");
                }

                while (tiempoTranscurrido < cpuQuantum && proceso.getTiempoRequerido() > 0) {
                    System.out.printf("[CPU] Ejecutando proceso %s. Le restan %d [ms] para terminar. Lleva %d [ms] en CPU.\n",
                            proceso.getNombreProceso(),
                            proceso.getTiempoRequerido(),
                            tiempoTranscurrido);

                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    proceso.disminuirTiempoRequerido();
                    tiempoTranscurrido++;
                    tiempoCPU++;
                    System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                    System.out.println("=============================================");
                }

                if (proceso.getTiempoRequerido() > 0) {
                    System.out.printf("[CPU] Quantum completado, regresando proceso %s a la lista de procesos listos. Le sobran %d [ms] para completar su ejecución.\n",
                            proceso.getNombreProceso(),
                            proceso.getTiempoRequerido());
                    procesosListos.insertarProceso(proceso);
                    System.out.println("=============================================");
                } else if (proceso.getTiempoRequerido() <= 0){
                    System.out.printf("[CPU] Quantum completado. El proceso %s terminó su ejecución.\n",
                            proceso.getNombreProceso());
                    proceso.tiempoUltimaEjecucion = proceso.ultimaSubida + tiempoTranscurrido;
                    proceso.setTiempoEspera(cpuQuantum);
                    proceso.setTiempoRespuesta();
                    proceso.setTiempoEjecucion();
                }
                if (!procesosListos.listaVacia() && procesosListos.getPrimerNodo().getProceso().getTiempoLlegada() >= tiempoCPU) {
                    procesosListos.ordenarListaPorLlegada();
                }
                System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                System.out.println("=============================================");
            } else {
                tiempoCPU++;
                subidaAMemoria();
                System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                System.out.println("[CPU] No hay procesos listos para ejecutar.");
                System.out.println("=============================================");
            }
        }
    }

    public void subidaAMemoria() {
        while (!procesosListos.listaVacia()) {
            if (procesosListos.getPrimerNodo().getProceso().getTiempoLlegada() >= tiempoCPU) {
                procesosListos.ordenarListaPorLlegada();
            }

            Proceso proceso = procesosListos.getPrimerNodo().getProceso();

            if (proceso.getTamanioProceso() > procesosEnEjecucion.getTamanioMemoria() && proceso.getTiempoLlegada() <= tiempoCPU) {
                System.out.printf("[Error] Insuficiente memoria para agregar al proceso %s. Requeridos: %d [kB]. Disponibles: %d [kB]...\n",
                        proceso.getNombreProceso(),
                        proceso.getTamanioProceso(),
                        procesosEnEjecucion.getTamanioMemoria());
                System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                System.out.println("=============================================");
                break;
            }

            if (proceso.getTiempoLlegada() > tiempoCPU) {
                System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
                System.out.println("=============================================");
                break;
            }

            System.out.printf("[Carga] Proceso %s cargado en memoria. Llego en %d [ms].\n", proceso.getNombreProceso(), proceso.getTiempoLlegada());
            procesosEnEjecucion.insertarProceso(proceso);
            procesosListos.eliminarProceso();
            System.out.println("--> El tiempo del CPU es: "+tiempoCPU+" [ms].");
            System.out.println("=============================================");
        }
    }
}

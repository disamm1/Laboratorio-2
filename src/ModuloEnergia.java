public class ModuloEnergia extends Modulo {

    //Atributos
    private double energiaPorCiclo;
    private int ciclosAcumulados;
    private double totalGenerado;


    //Constructor
    public ModuloEnergia(int id, String nombre, double salud, boolean activo, double costoConstruccion, double energiaPorCiclo) {
        super(id, nombre, salud, activo, costoConstruccion);
        this.energiaPorCiclo = energiaPorCiclo;
        this.ciclosAcumulados = 0;
        this.totalGenerado = 0;
    }

    //Getters
    public double getEnergiaPorCiclo() {
        return energiaPorCiclo;
    }

    public int getCiclosAcumulados() {
        return ciclosAcumulados;
    }

    public double getTotalGenerado() {
        return totalGenerado;
    }

    //Metodos
    @Override
    public String procesarCiclo(Mision mision) {
        if (activo) {
            ciclosAcumulados++;
            totalGenerado += energiaPorCiclo;
            mision.agregarEnergia(energiaPorCiclo);
            return "Módulo de Energía procesado. Energía generada: " + energiaPorCiclo + " unidades.";
        } else {
            return "Módulo de Energía inactivo. No se generó energía.";
        }
    }

    //Override
    @Override
    public String toString() {
        return super.toString() +
                "\nEnergía por Ciclo: " + energiaPorCiclo +
                "\nCiclos Acumulados: " + ciclosAcumulados +
                "\nTotal Generado: " + totalGenerado +
                "\n----------------------";
    }
}
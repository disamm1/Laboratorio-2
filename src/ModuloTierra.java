public class ModuloTierra extends Modulo {
    //Atributos
    private String estacion;
    private double capacidadDescarga;
    private double energiaPorDescarga;
    private double totalDescargado;

    //Constructor
    public ModuloTierra(int id, String nombre, double salud, boolean activo, double costoConstruccion, String estacion, double capacidadDescarga, double energiaPorDescarga) {
        super(id, nombre, salud, activo, costoConstruccion);
        this.estacion = estacion;
        this.capacidadDescarga = capacidadDescarga;
        this.energiaPorDescarga = energiaPorDescarga;
        this.totalDescargado = 0.0;
    }

    //getters
    public String getEstacion() {
        return estacion;
    }

    public double getCapacidadDescarga() {
        return capacidadDescarga;
    }

    public double getEnergiaPorDescarga() {
        return energiaPorDescarga;
    }

    public double getTotalDescargado() {
        return totalDescargado;
    }

    //Metodo
    @Override
    public String procesarCiclo(Mision mision) {

    if (!activo) {
        return "El módulo de tierra no está activo.";
    }

    if (mision.getEnergiaDisponible() < energiaPorDescarga) {
        return "No hay suficiente energía disponible para realizar la descarga.";
    }

    if (mision.getDatosEnOrbita() <= 0) {
        return "No hay datos disponibles en órbita para descargar.";
    }

    double cantidadDescargar;

    if (mision.getDatosEnOrbita() >= capacidadDescarga) {
        cantidadDescargar = capacidadDescarga;
    } else {
        cantidadDescargar = mision.getDatosEnOrbita();
    }

    mision.consumirEnergia(energiaPorDescarga);
    mision.descargarDatos(cantidadDescargar);

    totalDescargado += cantidadDescargar;

    return "Descarga realizada exitosamente. Datos descargados: "
            + cantidadDescargar + " MB.";
}

    //Override del método toString
    @Override
    public String toString() {
        return super.toString() + 
                "\nEstación: " + estacion
                + "\nCapacidad de Descarga: " + capacidadDescarga
                + "\nEnergía por Descarga: " + energiaPorDescarga
                + "\nTotal Descargado: " + totalDescargado +
                "\n-----------------------------------";
    }




}
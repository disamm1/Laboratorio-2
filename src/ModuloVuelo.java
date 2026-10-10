public class ModuloVuelo extends Modulo{
    //Atributos
    private String tipoInstrumento;
    private double datosPorCiclo;
    private double consumoEnergetico;
    private int ciclosAcumulados;
    private double totalAcumulado;
    
    //Constructor
    public ModuloVuelo(int id, String nombre, double salud, boolean activo, double costoConstruccion, String tipoInstrumento, double datosPorCiclo, double consumoEnergetico) {
        super(id, nombre, salud, activo, costoConstruccion);
        this.tipoInstrumento = tipoInstrumento;
        this.datosPorCiclo = datosPorCiclo;
        this.consumoEnergetico = consumoEnergetico;
        this.ciclosAcumulados = 0;
        this.totalAcumulado = 0.0;
    }


    //getters
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public double getDatosPorCiclo() {
        return datosPorCiclo;
    }

    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public int getCiclosAcumulados() {
        return ciclosAcumulados;
    }

    public double getTotalAcumulado() {
        return totalAcumulado;
    }


    //Metodo
    @Override
        public String procesarCiclo(Mision mision) {
    if (activo) {
        if (mision.consumirEnergia(consumoEnergetico)) {

            mision.agregarDatosEnOrbita(datosPorCiclo);

            ciclosAcumulados++;
            totalAcumulado += datosPorCiclo;

            return "Ciclo procesado exitosamente. Datos recopilados: "
                    + datosPorCiclo + " MB.";

        } else {
            return "No hay suficiente energía disponible para procesar el ciclo.";
        }
    } else {
        return "El módulo no está activo. No se puede procesar la misión.";
    }
}


    //Override

    @Override
    public String toString() {
        return super.toString() +
                "\nTipo de Instrumento: " + tipoInstrumento +
                "\nDatos por Ciclo: " + datosPorCiclo + " MB" +
                "\nConsumo Energético: " + consumoEnergetico + " unidades" +
                "\nCiclos Acumulados: " + ciclosAcumulados +
                "\nTotal Acumulado: " + totalAcumulado + " MB" +
                "\n----------------------";
    }

}
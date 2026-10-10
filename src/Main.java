public class Main {
    public static void main(String[] args) {
        // Crear la misión
        Mision mision = new Mision(500);

        // Crear módulos y agregarlos a la misión
        Modulo[] modulos = {
             new ModuloEnergia(8, "Panel Solar Alpha", 100.0, true, 22000.0,20.0),
            new ModuloVuelo(1, "Camara Orbital", 90.0, true, 50000, "Cámara", 20, 5),
            new ModuloTierra(5, "Antena Central", 100.0, true, 17000.0,"Campus Central", 25.0, 6.0),
            new ModuloVuelo(2, "Sensor solar", 80.0, true, 12000, "Sensor", 15, 5),
            new ModuloEnergia(9, "Panel Solar Beta", 80.0, true, 16000.0,15.0),
            new ModuloTierra(6, "Antena Norte", 90.0, true, 13000.0,"Estacion Norte", 15.0, 4.0),
            new ModuloVuelo(3, "Camara Cientifica", 100.0, false, 5000, "Cámara", 14, 4),
            new ModuloTierra(7, "Antena Sur", 75.0, false, 19000.0,"Estacion Sur", 10.0, 3.0),
            new ModuloEnergia(10, "Panel Solar Gamma", 60.0, false, 9000.0,10.0),
            new ModuloVuelo(4, "Sensor Espacial", 60.0, true, 11000, "Sensor", 21, 6),
        };

        for (Modulo modulo : modulos) {
            mision.agregarModulo(modulo);
        }

        // Crear el controlador y la vista
        SimuladorView view = new SimuladorView();
        SimuladorController controller = new SimuladorController(mision, view);

        // Iniciar el simulador
        controller.iniciarSimulador();
        
    }
}
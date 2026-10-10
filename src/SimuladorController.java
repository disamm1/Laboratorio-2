public class SimuladorController {
    //Atributos
    private Mision mision;
    private SimuladorView view;

    //Constructor
    public SimuladorController(Mision mision, SimuladorView view) {
        this.mision = mision;
        this.view = view;
    }


    //metodos

    //Listar modulos
    public void listarModulos() {
        view.mostrarModulos(mision.getModulos());
    }

    //Consultar catalogo por costo de construcción
    public void consultarCatalogoPorCosto() {
        view.mostrarCatalogo(mision.obtenerCatalogoPorCosto());
    }

    //Consultar Resumen de Comunicaciones
    public void consultarResumenComunicaciones() {
        view.mostrarResumenComunicaciones(mision);
    }

    //Avanzar un ciclo de simulación
    public void avanzarCiclo() {
        view.mostrarResultadosCiclo(mision.avanzarCiclo());
        view.mostrarEstadoMision(mision);
    }

    //Buscar modulo por ID o Nombre
    public void buscarModulo() {
    while (true) {
        String opcion = view.leerString(
            "Ingrese 'ID' para buscar por ID o 'Nombre' para buscar por nombre:");

        if (opcion.equalsIgnoreCase("ID")) {

            int id = view.leerEntero("Ingrese el ID del módulo:");
            Modulo modulo = mision.buscarModuloPorId(id);

            if (modulo != null) {
                view.mostrarModulo(modulo);
            } else {
                view.mostrarMensaje(
                    "Módulo con ID " + id + " no encontrado."
                );
            }

            return;

        } else if (opcion.equalsIgnoreCase("Nombre")) {

            String nombre = view.leerString(
                "Ingrese el nombre del módulo:"
            );

            Modulo modulo = mision.buscarModuloPorNombre(nombre);

            if (modulo != null) {
                view.mostrarModulo(modulo);
            } else {
                view.mostrarMensaje(
                    "Módulo con nombre '" + nombre + "' no encontrado."
                );
            }

            return;

        } else {
            view.mostrarMensaje(
                "Opción inválida. Ingrese 'ID' o 'Nombre'."
            );
        }
    }
}

//Iniciar simulador
public void iniciarSimulador() {
    view.mostrarMensaje("Bienvenido al Simulador de Misión Espacial");
    view.mostrarEstadoMision(mision);

    while (true) {
        view.mostrarMenuPrincipal();

        int opcion = view.leerOpcion();

        if(opcion == 1){
            listarModulos();
        }else if(opcion == 2){
            buscarModulo();
        }else if(opcion == 3){
            consultarCatalogoPorCosto();
        }else if(opcion == 4){
            avanzarCiclo();
        }else if(opcion == 5){
            consultarResumenComunicaciones();
        }else if(opcion == 6){
            view.mostrarMensaje("Saliendo del simulador. ¡Hasta luego!");
            return;
        }
    }

        
        
    }
}


    

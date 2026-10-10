import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SimuladorView{
    //Atributos
    private Scanner scanner;


    //Constructor
    public SimuladorView() {
        this.scanner = new Scanner(System.in);
    }


    //Metodos

    //Mostrar menu principal
    public void mostrarMenuPrincipal() {
        System.out.println("");
        System.out.println("=== QUETZAL 2 ===");
        System.out.println("1. Listar Módulos");
        System.out.println("2. Buscar Modulo por ID o Nombre");
        System.out.println("3. Consultar catalogo por costo de construcción");
        System.out.println("4. Avanzar un ciclo de simulación");
        System.out.println("5. Consultar resumen de comunicaciones");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.println("Seleccione una opción: ");
    }

    //Leer una variable tipo String
    public String leerString(String mensaje) {
        while (true) {
            System.out.println("");
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isBlank()) {
                System.out.println("");
                System.out.println("Error: La entrada no puede estar vacía.");
                System.out.println("");
            } else {
                return entrada;
            }
        }
    }


    //Leer una variable tipo entero
    public int leerEntero(String mensaje) {
    while (true) {
        try {
            System.out.println("");
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isBlank()) {
                System.out.println("");
                throw new InputMismatchException("La entrada no puede estar vacía.");
            }

            int numero = Integer.parseInt(entrada);

            if (numero < 0) {
                System.out.println("");
                throw new InputMismatchException("El número no puede ser negativo.");
            }

            return numero;

        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("Error: debe ingresar un número entero.");
            System.out.println("");

        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Error: " + e.getMessage());
            System.out.println("");
        }
    }
}

//Leer una variable tipo double
public double leerDouble(String mensaje) {
    while (true) {
        try {
            System.out.println("");
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isBlank()) {
                System.out.println("");
                throw new InputMismatchException("La entrada no puede estar vacía.");
            }

            double numero = Double.parseDouble(entrada);

            if (numero < 0) {
                System.out.println("");
                throw new InputMismatchException("El número no puede ser negativo.");
            }

            return numero;

        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("Error: debe ingresar un número válido.");
            System.out.println("");
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Error: " + e.getMessage());
            System.out.println("");
        }
    }
}

//Leer la opcion que coloque el usuario en el menu principal
public int leerOpcion() {
    while (true) {
        try {
            System.out.println("");
            String entrada = scanner.nextLine().trim();

            if (entrada.isBlank()) {
                System.out.println("");
                throw new InputMismatchException("La entrada no puede estar vacía.");
            }

            int numero = Integer.parseInt(entrada);

            if (numero < 1 || numero > 6) {
                System.out.println("");
                throw new InputMismatchException("El número debe estar entre 1 y 6.");
            }

            return numero;

        } catch (NumberFormatException e) {
            System.out.println("");
            System.out.println("Error: debe ingresar un número entero.");
            System.out.println("");

        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("Error: " + e.getMessage());
            System.out.println("");
        }
    }
}

//Mostrar mensaje 
public void mostrarMensaje(String mensaje) {
    System.out.println("");
    System.out.println(mensaje);
    System.out.println("");
}

//Mostrar modulo
public void mostrarModulo(Modulo modulo) {
    System.out.println("");
    System.out.println(modulo);
    System.out.println("");

}

//Mostrar modulos
public void mostrarModulos(List<Modulo> modulos) {
    System.out.println("\n=== MÓDULOS DE LA MISIÓN ===");

    for (Modulo modulo : modulos) {
        System.out.println(modulo);
    }
}

//Mostrar Catalogo de modulos por costo de construcción
public void mostrarCatalogo(List<Modulo> modulos) {
    System.out.println("\n=== CATÁLOGO POR COSTO ===");

    for (Modulo modulo : modulos) {
        System.out.println(modulo);
    }
}

//Mostrar resultados del ciclo de simulación
public void mostrarResultadosCiclo(List<String> resultados) {
    System.out.println("\n=== RESULTADOS DEL CICLO DE SIMULACIÓN ===");

    for (String resultado : resultados) {  
        System.out.println("");
        System.out.println(resultado);
    }
    

}

//Mostrar el estado de la mision
public void mostrarEstadoMision(Mision mision) {
    System.out.println("");
    System.out.println("\n=== ESTADO DE LA MISIÓN ===");
    System.out.println("Energía Total: " + mision.getEnergiaDisponible());
    System.out.println("Datos en órbita: " + mision.getDatosEnOrbita());
    System.out.println("Datos descargados: " + mision.getDatosDescargados());
    System.out.println("Ciclos transcurridos: " + mision.getCiclosTranscurridos()); 
    System.out.println("Cantidad de módulos: " + mision.getModulos().size());
    System.out.println("");
}

//Mostrar el resumen de comunicaciones
public void mostrarResumenComunicaciones(Mision mision) {
    System.out.println("\n=== RESUMEN DE COMUNICACIONES ===");

    System.out.println("Módulos de Tierra: " + mision.contarModulosTierra());
    System.out.println("Módulos de Tierra activos: " + mision.contarModulosTierraActivos());
    System.out.println("Capacidad total de descarga activa: " + mision.calcularCapacidadDescargaActiva() + " MB por ciclo");
    System.out.println("Total histórico descargado: " + mision.getDatosDescargados() + " MB");

    System.out.println("\nMódulo(s) con mayor descarga histórica:");

    for (ModuloTierra modulo : mision.obtenerMayoresDescargadores()) {
        System.out.println("Nombre: " + modulo.getNombre());
        System.out.println("ID: " + modulo.getId());
        System.out.println("Estación: " + modulo.getEstacion());
        System.out.println("Total descargado: " + modulo.getTotalDescargado() + " MB");
        System.out.println();
    }
}
}
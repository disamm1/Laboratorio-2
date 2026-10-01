import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creamos las variables que vamos a usar durante el menu
        Scanner scanner = new Scanner(System.in);
        boolean validar = false;
        boolean programaAbierto = true;
        int opcion = 0;
        Caso casoActual = null;

        // Opciones del menu principal
        String menu = "\n========== AGENCIA DE DETECTIVES ==========" +
                "\n1. Nuevo caso" +
                "\n2. Registrar Ubicacion" +
                "\n3. Consultar Ubicaciones" +
                "\n4. Consultar una ubicación" +
                "\n5. Modificar una ubicacion" +
                "\n6. Descartar Ubicacion" +
                "\n7. Registrar Pista" +
                "\n8. Consultar Pistas" +
                "\n9. Buscar Pista" +
                "\n10. Modificar Pista" +
                "\n11. Eliminar Pista" +
                "\n12. Mostrar reporte de investigacion" +
                "\n13. Salir" +
                "\n================================" +
                "\nSeleccione una opción: ";

        try {
            // Repetimos el menu hasta que se elija salir
            while (programaAbierto) {
                System.out.print(menu);
                validar = false;

                while (!validar) {
                    try {
                        // Leemos la opcion y consumimos el Enter que deja nextInt
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        if (opcion < 1 || opcion > 13) {
                            throw new IllegalArgumentException();
                        }
                        validar = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println();
                        System.out.println("Error: Ingrese un número entre 1 y 13.");
                        System.out.println();
                    } catch (InputMismatchException e) {
                        // Descartamos la entrada incorrecta para poder intentar de nuevo
                        scanner.nextLine();
                        System.out.println();
                        System.out.println("Error: Ingrese un número válido.");
                        System.out.println();
                    }
                }

                validar = false;

                // Registrar un nuevo caso
                if (opcion == 1) {
                    validar = false;
                    String nombreCaso = null;
                    String codigoCaso = null;
                    String nombreDetective = null;

                    System.out.println();
                    while (!validar) {
                        try {
                            System.out.print("Ingrese el nombre del caso: ");
                            nombreCaso = scanner.nextLine().trim();
                            if (nombreCaso.isEmpty()) {
                                throw new Exception();
                            }
                            validar = true;
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println("Error: El nombre del caso no puede estar vacío.");
                            System.out.print("Si desea cancelar escriba 'cancelar'");
                            System.out.println();
                        }
                    }
                    if (nombreCaso.equalsIgnoreCase("cancelar")) {
                        System.out.println();
                        System.out.println("Operación cancelada. Regresando al menú principal.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        validar = false;
                        System.out.println("Ingrese el codigo del caso");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigoCaso = scanner.nextLine().trim();
                                if (codigoCaso.isEmpty()) {
                                    throw new Exception();
                                }
                                validar = true;
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El codigo del caso no puede estar vacío.");
                                System.out.print("Si desea cancelar escriba 'cancelar'");
                                System.out.println();
                            }
                        }

                        if (codigoCaso.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            validar = false;
                            System.out.println();
                            System.out.println("Ingrese el detective del caso");
                            System.out.println();
                            while (!validar) {
                                try {
                                    nombreDetective = scanner.nextLine().trim();
                                    if (nombreDetective.isEmpty()) {
                                        throw new Exception();
                                    }
                                    validar = true;
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("Error: El nombre del detective del caso no puede estar vacío.");
                                    System.out.print("Si desea cancelar escriba 'cancelar'");
                                    System.out.println();
                                }
                            }
                            if (nombreDetective.equalsIgnoreCase("cancelar")) {
                                System.out.println();
                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                validar = false;
                                // Creamos el caso despues de validar todos los datos
                                casoActual = new Caso(nombreCaso, codigoCaso, nombreDetective);
                                System.out.println();
                                System.out.println("Caso registrado con exito!.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            }
                        }
                    }
                }

                // Registrar una ubicacion en una de las cinco posiciones
                if (opcion == 2) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        String codigo = null;
                        validar = false;

                        System.out.println();
                        System.out.print("Ingrese el código de la ubicación: ");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigo = scanner.nextLine().trim();
                                if (codigo.isEmpty()) {
                                    throw new Exception();
                                }
                                validar = true;
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El código de la ubicación no puede estar vacío.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            }
                        }
                        if (codigo.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            validar = false;
                            String nombre = null;
                            System.out.println();
                            System.out.print("Ingrese el nombre de la ubicación: ");
                            System.out.println();
                            while (!validar) {
                                try {
                                    nombre = scanner.nextLine().trim();
                                    if (nombre.isEmpty()) {
                                        throw new Exception();
                                    }
                                    validar = true;
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("Error: El nombre de la ubicación no puede estar vacío.");
                                    System.out.println("Si desea cancelar escriba 'cancelar'.");
                                    System.out.println();
                                    System.out.println("Intente de nuevo.");
                                }
                            }
                            if (nombre.equalsIgnoreCase("cancelar")) {
                                System.out.println();
                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                validar = false;
                                String direccion = null;
                                System.out.println();
                                System.out.print("Ingrese la dirección de la ubicación: ");
                                System.out.println();
                                while (!validar) {
                                    try {
                                        direccion = scanner.nextLine().trim();
                                        if (direccion.isEmpty()) {
                                            throw new Exception();
                                        }
                                        validar = true;
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("Error: La dirección de la ubicación no puede estar vacía.");
                                        System.out.println("Si desea cancelar escriba 'cancelar'.");
                                        System.out.println();
                                        System.out.println("Intente de nuevo.");
                                    }
                                }
                                if (direccion.equalsIgnoreCase("cancelar")) {
                                    System.out.println();
                                    System.out.println("Operación cancelada. Regresando al menú principal.");
                                    System.out.println();
                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                    scanner.nextLine();
                                } else {
                                    validar = false;
                                    // Validamos el riesgo antes de pedir el estado
                                    int nivelRiesgo = 0;
                                    System.out.println();
                                    System.out.print("Ingrese el nivel de riesgo de la ubicación (1-10): ");
                                    System.out.println();
                                    while (!validar) {
                                        try {
                                            nivelRiesgo = scanner.nextInt();
                                            scanner.nextLine();

                                            if (nivelRiesgo == -1) {
                                            } else if (nivelRiesgo < 1 || nivelRiesgo > 10) {
                                                throw new IllegalArgumentException();
                                            }
                                            validar = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println();
                                            System.out.println("Error: El nivel de riesgo debe estar entre 1 y 10.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                            System.out.println("Intente de nuevo.");
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("Error: Ingrese un número válido.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                        }
                                    }

                                    if (nivelRiesgo == -1) {
                                        System.out.println();
                                        System.out.println("Operación cancelada. Regresando al menú principal.");
                                        System.out.println();
                                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                        scanner.nextLine();
                                    } else {
                                        validar = false;
                                        String estado = null;

                                        System.out.println();
                                        System.out.print("Ingrese el estado de la ubicación: ");
                                        System.out.println();
                                        while (!validar) {
                                            try {
                                                estado = scanner.nextLine().trim();
                                                if (estado.isEmpty()) {
                                                    throw new Exception();
                                                }
                                                validar = true;
                                            } catch (Exception e) {
                                                System.out.println();
                                                System.out.println("Error: El estado de la ubicación no puede estar vacío.");
                                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                                System.out.println();
                                                System.out.println("Intente de nuevo.");
                                            }
                                        }
                                        if (estado.equalsIgnoreCase("cancelar")) {
                                            System.out.println();
                                            System.out.println("Operación cancelada. Regresando al menú principal.");
                                            System.out.println();
                                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                            scanner.nextLine();
                                        } else {
                                            validar = false;
                                            // Revisamos que la posicion este dentro del rango y libre
                                            int posicionUbicacion = 0;
                                            System.out.println();
                                            System.out.print("Ingrese la posición en la que desea registrar la ubicación (1-5): ");
                                            System.out.println();
                                            while (!validar) {
                                                try {
                                                    posicionUbicacion = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if (posicionUbicacion == -1) {
                                                    } else if (posicionUbicacion < 1 || posicionUbicacion > 5) {
                                                        throw new IllegalArgumentException();
                                                    } else if (casoActual.obtenerUbicacion(posicionUbicacion - 1) != null) {
                                                        throw new IllegalStateException();
                                                    }
                                                    // Convertimos la posicion al indice del arreglo solo si no se cancelo
                                                    if (posicionUbicacion != -1) {
                                                        posicionUbicacion = posicionUbicacion - 1;
                                                    }

                                                    validar = true;
                                                } catch (IllegalStateException e) {
                                                    System.out.println();
                                                    System.out.println("Error: Ya existe una ubicación en esa posición.");
                                                    System.out.println("Si desea cancelar escriba '-1'.");
                                                    System.out.println();
                                                    System.out.println("Intente de nuevo.");
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println();
                                                    System.out.println("Error: La posición debe estar entre 1 y 5 .");
                                                    System.out.println("Si desea cancelar escriba '-1'.");
                                                    System.out.println();
                                                    System.out.println("Intente de nuevo.");
                                                } catch (InputMismatchException e) {
                                                    scanner.nextLine();
                                                    System.out.println();
                                                    System.out.println("Error: Ingrese un número válido.");
                                                    System.out.println("Si desea cancelar escriba '-1'.");
                                                    System.out.println();
                                                }
                                            }

                                            if (posicionUbicacion == -1) {
                                                System.out.println();
                                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                                System.out.println();
                                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                scanner.nextLine();
                                            } else {
                                                // Guardamos la ubicacion con los datos ingresados
                                                Ubicacion ubicacionNueva = new Ubicacion(codigo, nombre, direccion, nivelRiesgo, estado);
                                                if (casoActual.registrarUbicacion(posicionUbicacion, ubicacionNueva)) {
                                                    System.out.println();
                                                    System.out.println("Ubicación registrada exitosamente.");
                                                    System.out.println();
                                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                    scanner.nextLine();
                                                } else {
                                                    System.out.println();
                                                    System.out.println("Error: No se pudo registrar la ubicación.");
                                                    System.out.println();
                                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                    scanner.nextLine();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Mostrar todas las ubicaciones registradas
                if (opcion == 3) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        if (casoActual.cantidadUbicacionesRegistradas() == 0) {
                            System.out.println();
                            System.out.println("No hay ubicaciones registradas.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            System.out.println("Ubicaciones registradas:");
                            casoActual.mostrarUbicaciones();
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        }
                    }
                }

                // Consultar una ubicacion por su posicion
                if (opcion == 4) {
                    int posicionUbicacion = -1;
                    Ubicacion ubicacionEncontrada = null;
                    validar = false;
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.print("Ingrese la posición de la ubicación que desea consultar (1-5): ");
                        System.out.println();
                        while (!validar) {
                            try {
                                posicionUbicacion = scanner.nextInt();
                                scanner.nextLine();
                                if (posicionUbicacion == -1) {
                                } else if (posicionUbicacion < 1 || posicionUbicacion > 5) {
                                    throw new IllegalArgumentException();
                                } else if (casoActual.obtenerUbicacion(posicionUbicacion - 1) == null) {
                                    throw new NullPointerException();
                                }

                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna ubicación en la posición ingresada.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (IllegalArgumentException e) {
                                System.out.println();
                                System.out.println("Error: La posición debe estar entre 1 y 5.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println();
                                System.out.println("Error: Ingrese un número válido.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                            }
                        }
                        if (posicionUbicacion == -1) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            ubicacionEncontrada = casoActual.obtenerUbicacion(posicionUbicacion - 1);
                            System.out.println();
                            System.out.println("Ubicación encontrada:");
                            System.out.println(ubicacionEncontrada);
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        }
                    }
                }
                // Modificar una ubicacion por su posicion
                if (opcion == 5) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        validar = false;
                        int posicionUbicacion = 0;
                        System.out.println();
                        System.out.print("Ingrese la posición de la ubicación que desea modificar (1-5): ");
                        System.out.println();
                        while (!validar) {
                            try {
                                posicionUbicacion = scanner.nextInt();
                                scanner.nextLine();

                                if (posicionUbicacion == -1) {
                                } else if (posicionUbicacion < 1 || posicionUbicacion > 5) {
                                    throw new IllegalArgumentException();
                                } else if (casoActual.obtenerUbicacion(posicionUbicacion - 1) == null) {
                                    throw new NullPointerException();
                                }

                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna ubicación en la posición ingresada.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (IllegalArgumentException e) {
                                System.out.println();
                                System.out.println("Error: La posición debe estar entre 1 y 5.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println();
                                System.out.println("Error: Ingrese un número válido.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                            }
                        }
                        if (posicionUbicacion == -1) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            validar = false;
                            int nuevoNivelRiesgo = 0;
                            System.out.println();
                            System.out.print("Ingrese el nuevo nivel de riesgo de la ubicación (1-10): ");
                            System.out.println();
                            while (!validar) {
                                try {
                                    nuevoNivelRiesgo = scanner.nextInt();
                                    scanner.nextLine();

                                    if (nuevoNivelRiesgo == -1) {
                                    } else if (nuevoNivelRiesgo < 1 || nuevoNivelRiesgo > 10) {
                                        throw new IllegalArgumentException();
                                    }

                                    validar = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println();
                                    System.out.println("Error: El nivel de riesgo debe estar entre 1 y 10.");
                                    System.out.println("Si desea cancelar escriba '-1'.");
                                    System.out.println();
                                    System.out.println("Intente de nuevo.");
                                } catch (InputMismatchException e) {
                                    scanner.nextLine();
                                    System.out.println();
                                    System.out.println("Error: Ingrese un número válido.");
                                    System.out.println("Si desea cancelar escriba '-1'.");
                                    System.out.println();
                                }
                            }
                            if (nuevoNivelRiesgo == -1) {
                                System.out.println();
                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                validar = false;

                                String nuevoEstado = null;
                                System.out.println();
                                System.out.print("Ingrese el nuevo estado de la ubicación: ");
                                System.out.println();
                                while (!validar) {
                                    try {
                                        nuevoEstado = scanner.nextLine().trim();
                                        if (nuevoEstado.isEmpty()) {
                                            throw new Exception();
                                        }
                                        validar = true;
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("Error: El estado de la ubicación no puede estar vacío.");
                                        System.out.println("Si desea cancelar escriba 'cancelar'.");
                                        System.out.println();
                                        System.out.println("Intente de nuevo.");
                                    }
                                }
                                if (nuevoEstado.equalsIgnoreCase("cancelar")) {
                                    System.out.println();
                                    System.out.println("Operación cancelada. Regresando al menú principal.");
                                    System.out.println();
                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                    scanner.nextLine();
                                } else {
                                    if (casoActual.modificarUbicacion(posicionUbicacion - 1, nuevoNivelRiesgo, nuevoEstado)) {
                                        System.out.println();
                                        System.out.println("Ubicación modificada exitosamente.");
                                        System.out.println();
                                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                        scanner.nextLine();
                                    } else {
                                        System.out.println();
                                        System.out.println("Error: No se pudo modificar la ubicación.");
                                        System.out.println();
                                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                        scanner.nextLine();
                                    }
                                }
                            }
                        }
                    }
                }

                // Descartar una ubicacion por su posicion
                if (opcion == 6) {
                    int posicionUbicacion = 0;
                    validar = false;
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.print("Ingrese la posición de la ubicación que desea descartar (1-5): ");
                        System.out.println();
                        while (!validar) {
                            try {
                                posicionUbicacion = scanner.nextInt();
                                scanner.nextLine();

                                if (posicionUbicacion == -1) {
                                } else if (posicionUbicacion < 1 || posicionUbicacion > 5) {
                                    throw new IllegalArgumentException();
                                } else if (casoActual.obtenerUbicacion(posicionUbicacion - 1) == null) {
                                    throw new NullPointerException();
                                }

                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna ubicación en la posición ingresada.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (IllegalArgumentException e) {
                                System.out.println();
                                System.out.println("Error: La posición debe estar entre 1 y 5.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println();
                                System.out.println("Error: Ingrese un número válido.");
                                System.out.println("Si desea cancelar escriba '-1'.");
                                System.out.println();
                            }
                        }
                        if (posicionUbicacion == -1) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            if (casoActual.descartarUbicacion(posicionUbicacion - 1)) {
                                System.out.println();
                                System.out.println("Ubicación descartada exitosamente.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                System.out.println();
                                System.out.println("Error: No se pudo descartar la ubicación.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            }
                        }
                    }
                }

                // Registrar una nueva pista
                if (opcion == 7) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {

                        String codigoPista = null;
                        validar = false;
                        System.out.println();
                        System.out.println("Ingrese el código de la pista que desea registrar: ");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigoPista = scanner.nextLine().trim();
                                if (codigoPista.isEmpty()) {
                                    throw new Exception();
                                }
                                if (codigoPista.equalsIgnoreCase("cancelar")) {
                                } else if (casoActual.obtenerPista(codigoPista) != null) {
                                    throw new IllegalArgumentException();
                                }

                                validar = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println();
                                System.out.println("Error: Ya existe una pista con el código ingresado.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El código de la pista no puede estar vacío.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            }
                        }

                        if (codigoPista.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            validar = false;
                            String descripcionPista = null;
                            System.out.println();
                            System.out.println("Ingrese la descripción de la pista: ");
                            while (!validar) {
                                try {
                                    descripcionPista = scanner.nextLine().trim();
                                    if (descripcionPista.isEmpty()) {
                                        throw new Exception();
                                    }
                                    validar = true;
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("Error: La descripción de la pista no puede estar vacía.");
                                    System.out.println("Si desea cancelar escriba 'cancelar'.");
                                    System.out.println();
                                    System.out.println("Intente de nuevo.");
                                }
                            }
                            if (descripcionPista.equalsIgnoreCase("cancelar")) {
                                System.out.println();
                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                validar = false;
                                String tipoEvidencia = null;
                                System.out.println();
                                System.out.println("Ingrese el tipo de evidencia de la pista: ");
                                while (!validar) {
                                    try {
                                        tipoEvidencia = scanner.nextLine().trim();
                                        if (tipoEvidencia.isEmpty()) {
                                            throw new Exception();
                                        }
                                        validar = true;
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("Error: El tipo de evidencia de la pista no puede estar vacío.");
                                        System.out.println("Si desea cancelar escriba 'cancelar'.");
                                        System.out.println();
                                        System.out.println("Intente de nuevo.");
                                    }
                                }

                                if (tipoEvidencia.equalsIgnoreCase("cancelar")) {
                                    System.out.println();
                                    System.out.println("Operación cancelada. Regresando al menú principal.");
                                    System.out.println();
                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                    scanner.nextLine();
                                } else {
                                    validar = false;
                                    int nivelImportancia = 0;
                                    System.out.println();
                                    System.out.println("Ingrese el nivel de importancia de la pista (1-10): ");
                                    while (!validar) {
                                        try {
                                            nivelImportancia = scanner.nextInt();
                                            scanner.nextLine();

                                            if (nivelImportancia == -1) {
                                            } else if (nivelImportancia < 1 || nivelImportancia > 10) {
                                                throw new IllegalArgumentException();
                                            }
                                            validar = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println();
                                            System.out.println("Error: El nivel de importancia debe estar entre 1 y 10.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                            System.out.println("Intente de nuevo.");
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("Error: Ingrese un número válido.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                        }
                                    }
                                    if (nivelImportancia == -1) {
                                        System.out.println();
                                        System.out.println("Operación cancelada. Regresando al menú principal.");
                                        System.out.println();
                                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                        scanner.nextLine();
                                    } else {
                                        validar = false;
                                        int nivelConfiabilidad = 0;
                                        System.out.println();
                                        System.out.println("Ingrese el nivel de confiabilidad de la pista (0-100): ");
                                        while (!validar) {
                                            try {
                                                nivelConfiabilidad = scanner.nextInt();
                                                scanner.nextLine();

                                                if (nivelConfiabilidad == -1) {
                                                } else if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
                                                    throw new IllegalArgumentException();
                                                }
                                                validar = true;
                                            } catch (IllegalArgumentException e) {
                                                System.out.println();
                                                System.out.println("Error: El nivel de confiabilidad debe estar entre 0 y 100.");
                                                System.out.println("Si desea cancelar escriba '-1'.");
                                                System.out.println();
                                                System.out.println("Intente de nuevo.");
                                            } catch (InputMismatchException e) {
                                                scanner.nextLine();
                                                System.out.println();
                                                System.out.println("Error: Ingrese un número válido.");
                                                System.out.println("Si desea cancelar escriba '-1'.");
                                                System.out.println();
                                            }
                                        }
                                        if (nivelConfiabilidad == -1) {
                                            System.out.println();
                                            System.out.println("Operación cancelada. Regresando al menú principal.");
                                            System.out.println();
                                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                            scanner.nextLine();
                                        } else {
                                            // Guardamos la pista despues de validar sus niveles
                                            Pista pistaNueva = new Pista(codigoPista, descripcionPista, tipoEvidencia, nivelImportancia, nivelConfiabilidad);

                                            if (casoActual.registrarPista(pistaNueva)) {
                                                System.out.println();
                                                System.out.println("Pista registrada exitosamente.");
                                                System.out.println();
                                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                scanner.nextLine();
                                            } else {
                                                System.out.println();
                                                System.out.println("Error: No se pudo registrar la pista.");
                                                System.out.println();
                                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                scanner.nextLine();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Mostrar todas las pistas registradas
                if (opcion == 8) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.println("Pistas registradas:");
                        System.out.println();
                        if (!casoActual.mostrarPistas()) {
                            System.out.println();
                            System.out.println("No hay pistas registradas.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        }
                    }
                }

                // Buscar una pista por su codigo
                if (opcion == 9) {
                    String codigoPista = null;
                    Pista pistaEncontrada = null;
                    validar = false;
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.print("Ingrese el código de la pista que desea buscar: ");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigoPista = scanner.nextLine().trim();
                                if (codigoPista.isEmpty()) {
                                    throw new Exception();
                                }
                                if (codigoPista.equalsIgnoreCase("cancelar")) {
                                } else if (casoActual.obtenerPista(codigoPista) == null) {
                                    throw new NullPointerException();
                                }

                                pistaEncontrada = casoActual.obtenerPista(codigoPista);
                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna pista con el código ingresado.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El código de la pista no puede estar vacío.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            }
                        }
                        if (codigoPista.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            System.out.println();
                            System.out.println("Pista encontrada:");
                            System.out.println(pistaEncontrada);
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        }
                    }
                }

                // Modificar una pista por su codigo
                if (opcion == 10) {

                    String codigoPista = null;
                    Pista pistaEncontrada = null;
                    validar = false;
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.print("Ingrese el código de la pista que desea modificar: ");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigoPista = scanner.nextLine().trim();
                                if (codigoPista.isEmpty()) {
                                    throw new Exception();
                                }
                                if (codigoPista.equalsIgnoreCase("cancelar")) {
                                } else if (casoActual.obtenerPista(codigoPista) == null) {
                                    throw new NullPointerException();
                                }

                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna pista con el código ingresado.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El código de la pista no puede estar vacío.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            }
                        }
                        if (codigoPista.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {
                            validar = false;
                            String descripcionPista = null;
                            pistaEncontrada = casoActual.obtenerPista(codigoPista);
                            System.out.println();
                            System.out.println("Pista encontrada:");
                            System.out.println(pistaEncontrada);
                            System.out.println();
                            System.out.println("Ingrese la nueva descripción de la pista: ");
                            while (!validar) {
                                try {
                                    descripcionPista = scanner.nextLine().trim();
                                    if (descripcionPista.isEmpty()) {
                                        throw new Exception();
                                    }
                                    validar = true;
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println("Error: La descripción de la pista no puede estar vacía.");
                                    System.out.println("Si desea cancelar escriba 'cancelar'.");
                                    System.out.println();
                                    System.out.println("Intente de nuevo.");
                                }
                            }

                            if (descripcionPista.equalsIgnoreCase("cancelar")) {
                                System.out.println();
                                System.out.println("Operación cancelada. Regresando al menú principal.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                validar = false;
                                String tipoEvidencia = null;
                                System.out.println();
                                System.out.println("Ingrese el nuevo tipo de evidencia de la pista: ");
                                while (!validar) {
                                    try {
                                        tipoEvidencia = scanner.nextLine().trim();
                                        if (tipoEvidencia.isEmpty()) {
                                            throw new Exception();
                                        }
                                        validar = true;
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("Error: El tipo de evidencia de la pista no puede estar vacío.");
                                        System.out.println("Si desea cancelar escriba 'cancelar'.");
                                        System.out.println();
                                        System.out.println("Intente de nuevo.");
                                    }
                                }

                                if (tipoEvidencia.equalsIgnoreCase("cancelar")) {
                                    System.out.println();
                                    System.out.println("Operación cancelada. Regresando al menú principal.");
                                    System.out.println();
                                    System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                    scanner.nextLine();
                                } else {
                                    validar = false;
                                    int nivelImportancia = 0;
                                    System.out.println();
                                    System.out.println("Ingrese el nuevo nivel de importancia de la pista (1-10): ");
                                    while (!validar) {
                                        try {
                                            nivelImportancia = scanner.nextInt();
                                            scanner.nextLine();

                                            if (nivelImportancia == -1) {
                                            } else if (nivelImportancia < 1 || nivelImportancia > 10) {
                                                throw new IllegalArgumentException();
                                            }
                                            validar = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println();
                                            System.out.println("Error: El nivel de importancia debe estar entre 1 y 10.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                            System.out.println("Intente de nuevo.");
                                        } catch (InputMismatchException e) {
                                            scanner.nextLine();
                                            System.out.println();
                                            System.out.println("Error: Ingrese un número válido.");
                                            System.out.println("Si desea cancelar escriba '-1'.");
                                            System.out.println();
                                        }
                                    }
                                    if (nivelImportancia == -1) {
                                        System.out.println();
                                        System.out.println("Operación cancelada. Regresando al menú principal.");
                                        System.out.println();
                                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                        scanner.nextLine();
                                    } else {
                                        validar = false;
                                        int nivelConfiabilidad = 0;
                                        System.out.println();
                                        System.out.println("Ingrese el nuevo nivel de confiabilidad de la pista (0-100): ");
                                        while (!validar) {
                                            try {
                                                nivelConfiabilidad = scanner.nextInt();
                                                scanner.nextLine();

                                                if (nivelConfiabilidad == -1) {
                                                } else if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
                                                    throw new IllegalArgumentException();
                                                }
                                                validar = true;
                                            } catch (IllegalArgumentException e) {
                                                System.out.println();
                                                System.out.println("Error: El nivel de confiabilidad debe estar entre 0 y 100.");
                                                System.out.println("Si desea cancelar escriba '-1'.");
                                                System.out.println();
                                                System.out.println("Intente de nuevo.");
                                            } catch (InputMismatchException e) {
                                                scanner.nextLine();
                                                System.out.println();
                                                System.out.println("Error: Ingrese un número válido.");
                                                System.out.println("Si desea cancelar escriba '-1'.");
                                                System.out.println();
                                            }
                                        }
                                        if (nivelConfiabilidad == -1) {
                                            System.out.println();
                                            System.out.println("Operación cancelada. Regresando al menú principal.");
                                            System.out.println();
                                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                            scanner.nextLine();
                                        } else {
                                            if (casoActual.modificarPista(codigoPista, descripcionPista, tipoEvidencia, nivelImportancia, nivelConfiabilidad)) {
                                                System.out.println();
                                                System.out.println("Pista modificada exitosamente.");
                                                System.out.println();
                                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                scanner.nextLine();
                                            } else {
                                                System.out.println();
                                                System.out.println("Error: No se pudo modificar la pista.");
                                                System.out.println();
                                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                                scanner.nextLine();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Eliminar una pista por su codigo
                if (opcion == 11) {
                    String codigoPista = null;
                    Pista pistaEncontrada = null;
                    validar = false;
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        System.out.println();
                        System.out.print("Ingrese el código de la pista que desea eliminar: ");
                        System.out.println();
                        while (!validar) {
                            try {
                                codigoPista = scanner.nextLine().trim();
                                if (codigoPista.isEmpty()) {
                                    throw new Exception();
                                }

                                if (codigoPista.equalsIgnoreCase("cancelar")) {
                                } else if (casoActual.obtenerPista(codigoPista) == null) {
                                    throw new NullPointerException();
                                }

                                validar = true;
                            } catch (NullPointerException e) {
                                System.out.println();
                                System.out.println("Error: No se encontró ninguna pista con el código ingresado.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Error: El código de la pista no puede estar vacío.");
                                System.out.println("Si desea cancelar escriba 'cancelar'.");
                                System.out.println();
                                System.out.println("Intente de nuevo.");
                            }
                        }

                        if (codigoPista.equalsIgnoreCase("cancelar")) {
                            System.out.println();
                            System.out.println("Operación cancelada. Regresando al menú principal.");
                            System.out.println();
                            System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                            scanner.nextLine();
                        } else {

                            pistaEncontrada = casoActual.obtenerPista(codigoPista);
                            System.out.println();
                            if (casoActual.eliminarPista(pistaEncontrada.getCodigo())) {
                                System.out.println();
                                System.out.println("Pista eliminada exitosamente.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            } else {
                                System.out.println();
                                System.out.println("Error: No se pudo eliminar la pista.");
                                System.out.println();
                                System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                                scanner.nextLine();
                            }
                        }
                    }
                }

                // Mostrar reporte de investigacion
                if (opcion == 12) {
                    if (casoActual == null) {
                        System.out.println();
                        System.out.println("No hay un caso activo. Por favor, cree un nuevo caso primero.");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    } else {
                        // Reunimos los datos para mostrar el reporte
                        int cantidadUbicaciones = casoActual.cantidadUbicacionesRegistradas();
                        int cantidadEspaciosUbicaciones = casoActual.cantidadDeEspaciosDeUbicaciones();
                        int cantidadPistas = casoActual.cantidadPistasRegistradas();
                        Ubicacion ubicacionMasPeligrosa = casoActual.ubicacionMasPeligrosa();
                        Pista pistaMasConfiable = casoActual.pistaMasConfiable();
                        Pista pistaMasImportante = casoActual.pistaMasImportante();
                        double promedioNivelImportancia = casoActual.promedioNivelImportancia();

                        System.out.println();
                        System.out.println("REPORTE DE INVESTIGACIÓN");
                        System.out.println("----------------------------");
                        System.out.println("Cantidad de ubicaciones registradas: " + cantidadUbicaciones);
                        System.out.println("Cantidad de espacios disponibles para registrar ubicaciones: " + cantidadEspaciosUbicaciones);
                        System.out.println("Cantidad de pistas registradas: " + cantidadPistas);
                        if (ubicacionMasPeligrosa != null) {
                            System.out.println();
                            System.out.println("Ubicación más peligrosa: ");
                            System.out.println(ubicacionMasPeligrosa);
                        } else {
                            System.out.println("Ubicación más peligrosa: No hay ubicaciones registradas.");
                        }
                        if (pistaMasConfiable != null) {
                            System.out.println();
                            System.out.println("Pista más confiable: ");
                            System.out.println(pistaMasConfiable);
                        } else {
                            System.out.println("Pista más confiable: No hay pistas registradas.");
                        }
                        if (pistaMasImportante != null) {
                            System.out.println();
                            System.out.println("Pista más importante: ");
                            System.out.println(pistaMasImportante);
                        } else {
                            System.out.println("Pista más importante: No hay pistas registradas.");
                        }
                        System.out.println("Promedio del nivel de importancia de las pistas: " + promedioNivelImportancia);
                        System.out.println("----------------------------");
                        System.out.println();
                        System.out.println("PRESIONA ENTER PARA REGRESAR AL MENÚ.");
                        scanner.nextLine();
                    }
                }

                // Cerramos el programa
                if (opcion == 13) {

                    programaAbierto = false;
                    System.out.println();
                    System.out.println("Saliendo del programa...");
                    System.out.println();
                }
            }
        } finally {
            // Cerramos el scanner aunque ocurra un error al terminar
            scanner.close();
        }
        System.out.println("PROGRAMA FINALIZADO");
    }
}

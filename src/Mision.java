
import java.util.ArrayList;
import java.util.List;

public class Mision{

    //Atributos
    private List<Modulo> modulos;
    private double energiaDisponible;
    private double datosEnOrbita;
    private double datosDescargados;
    private int ciclosTranscurridos;
    
    //Constructor
    public Mision(double energiaDisponible) {
        this.modulos = new ArrayList<>();
        this.energiaDisponible = energiaDisponible;
        this.datosEnOrbita = 0.0;
        this.datosDescargados = 0.0;
        this.ciclosTranscurridos = 0;
    }

    //getters
    public List<Modulo> getModulos() {
        return modulos;
    }
    public double getEnergiaDisponible() {
        return energiaDisponible;
    }

    public double getDatosEnOrbita() {
        return datosEnOrbita;
    }

    public double getDatosDescargados() {
        return datosDescargados;
    }

    public int getCiclosTranscurridos() {
        return ciclosTranscurridos;
    }



    //Metodos

    //Agregar modulo a la mision
    public void agregarModulo(Modulo modulo) {
    modulos.add(modulo);
}

    // Agregar energia al sistema de la misión
    public void agregarEnergia(double cantidad) {
        energiaDisponible += cantidad;
    }

    // Consumir energia del sistema de la misión
public boolean consumirEnergia(double cantidad) {
    if (cantidad < 0) {
        return false;
    }

    if (energiaDisponible >= cantidad) {
        energiaDisponible -= cantidad;
        return true;
    } else {
        return false;
    }
}

    // Agregar datos a la órbita de la misión
    public void agregarDatosEnOrbita(double cantidad) {
    if (cantidad < 0) {
        throw new IllegalArgumentException("La cantidad de datos no puede ser negativa.");
    }

    datosEnOrbita += cantidad;
}

    // Descargar datos de la órbita de la misión
    public boolean descargarDatos(double cantidad) {
    if (cantidad < 0) {
        return false;
    }

    if (datosEnOrbita >= cantidad) {
        datosEnOrbita -= cantidad;
        datosDescargados += cantidad;
        return true;
    } else {
        return false;
    }
}


    //Buscar modulo por ID 
    public Modulo buscarModuloPorId(int id) {
        for (Modulo modulo : modulos) {
            if (modulo.getId() == id) {
                return modulo;
            }
        }
        return null; // Retorna null si no se encuentra el módulo
    }

    //Buscar modulo por nombre
    public Modulo buscarModuloPorNombre(String nombre) {
        for (Modulo modulo : modulos) {
            if (modulo.getNombre().equalsIgnoreCase(nombre)) {
                return modulo;
            }
        }
        return null; // Retorna null si no se encuentra el módulo
    }

    // Avanzar un ciclo de la misión y procesar los módulos
    public List<String> avanzarCiclo() {
        List<String> resultados = new ArrayList<>();
        ciclosTranscurridos++;
        for (Modulo modulo : modulos) {
            String resultado = modulo.procesarCiclo(this);
            resultados.add("Módulo " + modulo.getNombre() + ": " + resultado);
        }
        return resultados;
    }

    //Obtener modulos de tierra
    public List<ModuloTierra> obtenerModulosTierra() {
        List<ModuloTierra> modulosTierra = new ArrayList<>();
        for (Modulo modulo : modulos) {
            if (modulo instanceof ModuloTierra) {
                modulosTierra.add((ModuloTierra) modulo);
            }
        }
        return modulosTierra;
    }

    //Contar modulos de tierra
    public int contarModulosTierra() {
        int contador = 0;
        for (Modulo modulo : modulos) {
            if (modulo instanceof ModuloTierra) {
                contador++;
            }
        }
        return contador;
    }

    //Contar modulos de tierra activos
    public int contarModulosTierraActivos() {
        int contador = 0;
        for (Modulo modulo : modulos) {
            if (modulo instanceof ModuloTierra && modulo.isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    //Obtener catalogo de modulos por costo
    public List<Modulo> obtenerCatalogoPorCosto() {
    List<Modulo> catalogo = new ArrayList<>(modulos);

    for (int i = 0; i < catalogo.size() - 1; i++) {
        for (int j = 0; j < catalogo.size() - 1 - i; j++) {

            if (catalogo.get(j).getCostoConstruccion()> catalogo.get(j + 1).getCostoConstruccion()) {

                Modulo auxiliar = catalogo.get(j);

                catalogo.set(j, catalogo.get(j + 1));
                catalogo.set(j + 1, auxiliar);
            }
        }
    }

    return catalogo;
}

//Calcular capaidad de descarga activa
public double calcularCapacidadDescargaActiva() {
    double total = 0.0;

    for (Modulo modulo : modulos) {
        if (modulo instanceof ModuloTierra) {
            ModuloTierra tierra = (ModuloTierra) modulo;

            if (tierra.isActivo()) {
                total += tierra.getCapacidadDescarga();
            }
        }
    }

    return total;
}


//Obtener modulos con mayor descarga historica
public List<ModuloTierra> obtenerMayoresDescargadores() {
    List<ModuloTierra> mayores = new ArrayList<>();
    double mayorDescarga = -1;

    for (Modulo modulo : modulos) {

        if (modulo instanceof ModuloTierra) {
            ModuloTierra tierra = (ModuloTierra) modulo;

            if (tierra.getTotalDescargado() > mayorDescarga) {
                mayorDescarga = tierra.getTotalDescargado();

                mayores.clear();
                mayores.add(tierra);

            } else if (tierra.getTotalDescargado() == mayorDescarga) {
                mayores.add(tierra);
            }
        }
    }

    return mayores;
}



   
}
import java.util.ArrayList;

public class Caso{
    //atributos
    private String nombre;
    private String codigo;
    private String detective;
    private Ubicacion[] ubicaciones;
    private ArrayList<Pista> pistas;

    //constructor
    public Caso(String nombre, String codigo, String detective){
        this.nombre = nombre;
        this.codigo = codigo;
        this.detective = detective;
        this.ubicaciones = new Ubicacion[5];
        this.pistas = new ArrayList<Pista>();
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDetective() {
        return detective;
    }

    //metodos
    public boolean registrarUbicacion(int posicion, Ubicacion ubicacion){
        if(posicion >= 0 && posicion < ubicaciones.length){
            if(ubicaciones[posicion] != null){
                System.out.println("Ya existe una ubicacion en esa posicion");
                return false;
            }
            ubicaciones[posicion] = ubicacion;
            return true;
        }
        return false;
    }

    //Obtener la ubicacion en la posicion indicada, si no existe retorna null
    public Ubicacion obtenerUbicacion(int posicion){
        if(posicion >= 0 && posicion < ubicaciones.length){
            return ubicaciones[posicion];
        }
        return null;
    }

    //Modificar la ubicacion en la posicion indicada, si no existe retorna false
    public boolean modificarUbicacion(int posicion, int riesgo, String estado){
        if(posicion >= 0 && posicion < ubicaciones.length){
            if(ubicaciones[posicion] == null){
                System.out.println("No existe una ubicacion en esa posicion");
                return false;
            }
            ubicaciones[posicion].setNivelRiesgo(riesgo);
            ubicaciones[posicion].setEstado(estado);
            return true;
        }
        return false;
    }

    //Descartar la ubicacion en la posicion indicada, si no existe retorna false
    public boolean descartarUbicacion(int posicion){
        if(posicion >= 0 && posicion < ubicaciones.length){
            if(ubicaciones[posicion] == null){
                return false;
            }
            ubicaciones[posicion] = null;
            return true;
        }
        return false;
    }

    //Registrar una pista, si ya existe una pista con el mismo codigo retorna false
    public boolean registrarPista(Pista pista){
        if(pista != null){
            if(obtenerPista(pista.getCodigo()) != null){
                System.out.println("Ya existe una pista con ese codigo");
                return false;
            }
            pistas.add(pista);
            return true;
        }
        return false;
    }

    //Obtener la pista con el codigo indicado, si no existe retorna null
    public Pista obtenerPista(String codigo){
        for(Pista pista : pistas){
            if(pista.getCodigo().equals(codigo)){
                return pista;
            }
        }
        return null;
    } 

    //Modificar la pista con el codigo indicado, si no existe retorna false
    public boolean modificarPista(String codigo, String descripcion, String tipoEvidencia, int importancia, int confiabilidad){
        Pista pista = obtenerPista(codigo);
        if(pista != null){
            pista.setDescripcion(descripcion);
            pista.setTipoEvidencia(tipoEvidencia);
            pista.setNivelImportante(importancia);
            pista.setNivelConfiable(confiabilidad);
            return true;
        }
        return false;
    }

    //Eliminar la pista con el codigo indicado, si no existe retorna false
    public boolean eliminarPista(String codigo){
        Pista pista = obtenerPista(codigo);
        if(pista != null){
            pistas.remove(pista);
            return true;
        }
        return false;
    }

    //Obtener todas las pistas registradas
    public ArrayList<Pista> obtenerPistas() {
        return pistas;
    }

    //Obtener la cantidad de ubicaciones registradas
    public int cantidadUbicacionesRegistradas(){
        int cantidad = 0;
        for(Ubicacion ubicacion : ubicaciones){
            if(ubicacion != null){
                cantidad++;
            }
        }
        return cantidad;
    }

    //Obtener la cantidad de pistas registradas
    public int espaciosDisponibles(){
        int cantidad = 0;
        for(Ubicacion ubicacion : ubicaciones){
            if(ubicacion == null){
                cantidad++;
            }
        }
        return cantidad;
    }

    //Obtener la ubicacion con el nivel de riesgo mas alto, si no hay ubicaciones registradas retorna null
    public Ubicacion ubicacionMasPeligrosa(){
        Ubicacion ubicacionMasPeligrosa = null;
        for(Ubicacion ubicacion : ubicaciones){
            if(ubicacion != null){
                if(ubicacionMasPeligrosa == null || ubicacion.getNivelRiesgo() > ubicacionMasPeligrosa.getNivelRiesgo()){
                    ubicacionMasPeligrosa = ubicacion;
                }
            }
        }
        return ubicacionMasPeligrosa;
    }

    //Obtener la cantidad de pistas registradas
    public int cantidadPistasRegistradas(){
        return pistas.size();
    }

    //Obtener la pista con el nivel de importancia mas alto, si no hay pistas registradas retorna null
    public Pista pistaMasImportante(){
        Pista pistaMasImportante = null;
        for(Pista pista : pistas){
            if(pistaMasImportante == null || pista.getNivelImportante() > pistaMasImportante.getNivelImportante()){
                pistaMasImportante = pista;
            }
        }
        return pistaMasImportante;
    }

    //Obtener la pista con el nivel de confiabilidad mas alto, si no hay pistas registradas retorna null
    public Pista pistaMasConfiable(){
        Pista pistaMasConfiable = null;
        for(Pista pista : pistas){
            if(pistaMasConfiable == null || pista.getNivelConfiable() > pistaMasConfiable.getNivelConfiable()){
                pistaMasConfiable = pista;
            }
        }
        return pistaMasConfiable;
    }

    //Obtener el promedio de nivel de importancia de todas las pistas registradas, si no hay pistas registradas retorna 0
    public double promedioNivelImportancia(){
        if(pistas.size() == 0){
            return 0;
        }
        int suma = 0;
        for(Pista pista : pistas){
            suma += pista.getNivelImportante();
        }
        return (double) suma / pistas.size();
    }

    //mostrar todas las pistas registradas, si no hay pistas registradas retorna false
    public boolean mostrarPistas(){
        if(pistas.isEmpty()){
            return false;
        }
        for(Pista pista : pistas){
            System.out.println(pista);
        }
        return true;
    }

        //mostrar todas las ubicaciones registradas, si no hay ubicaciones registradas retorna false
    public boolean mostrarUbicaciones(){
        int contador = 1;
        boolean hayUbicaciones = false;
        for(Ubicacion ubicacion : ubicaciones){
    
            if(ubicacion != null){
                System.out.println("POSICION #" + contador);
                System.out.println(ubicacion);
                hayUbicaciones = true;
            }
            contador += 1;
        }
        return hayUbicaciones;
    }

    //Obtener la cantidad de espacios disponibles para registrar ubicaciones
    public int cantidadDeEspaciosDeUbicaciones(){
        int cantidad = 0;
        for(Ubicacion ubicacion : ubicaciones){
            if(ubicacion == null){
                cantidad++;
            }
        }
        return cantidad;
    }


}
public class Ubicacion{
    //Atributos
    private String codigo;
    private String nombre;
    private String direccion;
    private int nivelRiesgo;
    private String estado; 

    //Metodos
    public Ubicacion(String codigo, String nombre, String direccion, int nivelRiesgo, String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nivelRiesgo = nivelRiesgo;
        this.estado = estado;
    }


    //getters
    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public int getNivelRiesgo(){
        return nivelRiesgo;
    }

    public String getEstado(){
        return estado;
    }


    //Setters

    public void setNivelRiesgo(int nivel){
        this.nivelRiesgo = nivel;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }


    //sobreescritura de to string para mostrar la clase

    @Override
    public String toString(){
             return"\n-----------------------------------" +
         "\nNombre: " + nombre +
           "\nCodigo: " + codigo +
           "\nDireccion: " + direccion + 
           "\nNivel de riesgo: " + nivelRiesgo +
           "\nEstado: " + estado +
           "\n-----------------------------------";
        }



}
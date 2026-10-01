public class Pista{
    //Atributos
    private String codigo;
    private String descripcion;
    private String tipoEvidencia;
    private int nivelImportante;
    private int nivelConfiable;

     //Constructor
    public Pista(String codigo, String descripcion, String tipoEvidencia, int nivelImportante, int nivelConfiable){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportante = nivelImportante;
        this.nivelConfiable = nivelConfiable;
    }

//getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public int getNivelImportante() {
        return nivelImportante;
    }

    public int getNivelConfiable() {
        return nivelConfiable;
    }

//setters

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public void setNivelImportante(int nivelImportante) {
        this.nivelImportante = nivelImportante;
    }

    public void setNivelConfiable(int nivelConfiable) {
        this.nivelConfiable = nivelConfiable;
    }

    //overrides
    @Override 

    public String toString() {
        return "----------------------------" +
        "\nCodigo: " + codigo + 
        "\nDescripcion: " + descripcion + 
        "\nTipo de evidencia: " + tipoEvidencia + 
        "\nNivel de importancia: " + nivelImportante + 
        "\nNivel de confiabilidad: " + nivelConfiable
        + "\n----------------------------" +
        "\n";
    }


}
public abstract class Modulo{
    // Atributos
    protected int id;
    protected String nombre;
    protected double salud;
    protected boolean activo;
    protected double costoConstruccion;

    // Constructor
    public Modulo(int id, String nombre, double salud, boolean activo, double costoConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.activo = activo;
        this.costoConstruccion = costoConstruccion;
    }

    // Getters 
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getCostoConstruccion() {
        return costoConstruccion;
    }

    //Setters

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Metodo
    public abstract String procesarCiclo(Mision mision);

    //Override

    @Override
    public String toString() {
        return "----------------------" +
                "\nMódulo: " + nombre +
                "\nID: " + id +
                "\nSalud: " + salud +
                "\nActivo: " + activo +
                "\nCosto de Construcción: " + costoConstruccion;
    }





}
package programa_sorpresa;

public class Usuario {
    //Atributos
    private String nombre;
    private String cedula;
    private String profesion;
    private double sueldo;

    public Usuario(String nombre, String cedula, String profesion, double sueldo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.profesion = profesion;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return   nombre  +
                ", " + cedula +
                ", '" + profesion +
                ", " + sueldo +"\n";
    }

    public String getCedula() {
        return cedula;
    }

    public double getSueldo() {
        return sueldo;
    }
}

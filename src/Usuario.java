public class Usuario {
    private String nombre;
    private int edad;
    private String DNI;

    public Usuario() {
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    //devuelve true si el DNI que recibe es valido. En caso contrario devuelve false
    public boolean setDNI(String DNI) {
        if (DNI.matches("^[0-9]{8}[-]?[a-zA-Z]$")) {
            this.DNI = DNI;
            return true;
        } else {
            System.out.println("DNI introducido incorrecto. Ha de tener 8 números mas una letra");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nombre de usuario " + getNombre() + ", edad " + getEdad() + ", DNI nº " + getDNI();
    }
}

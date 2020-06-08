public class Ingreso extends Dinero {

    public Ingreso(double ingreso, String description) {
        setDinero(ingreso);
        setDescription(description);
    }

    @Override
    public String toString() { return "Ingreso: "+ getDescription() + ", cantidad: " + getDinero() + "€"; }
}

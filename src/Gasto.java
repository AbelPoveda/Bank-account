public class Gasto extends Dinero {

    public Gasto(double gasto, String description) {
        setDinero(gasto);
        setDescription(description);
    }

    @Override
    public String toString() {
        return "Gasto: "+ getDescription() + ", cantidad: " + getDinero() + "€";
    }
}

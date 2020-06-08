import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    List<Gasto> gastos = new ArrayList<Gasto>();
    List<Ingreso> ingresos = new ArrayList<Ingreso>();

    public Cuenta(Usuario usuario){
        this.saldo = 0;
        this.usuario = usuario;
    }

    //getters y setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //añade a la lista de ingresos un nuevo ingreso y suma la cantidad al saldo acutal.
    public Double addIngresos(String description, double cantidad){
        Ingreso nuevoingreso = new Ingreso(cantidad, description);
        ingresos.add(nuevoingreso);
        saldo += cantidad;
        return getSaldo();
    }

    //añade a la lista de gastos un nuevo gasto y resta la cantidad al saldo acutal.
    //Si el gasto es mayor que el saldo genera un errorGastoException
    public Double addGastos(String description, double cantidad){
        try {
            if (cantidad > saldo){
                throw new GastoException();
            }
            Gasto nuevogasto = new Gasto(cantidad, description);
            gastos.add(nuevogasto);
            saldo -= cantidad;
        } catch (GastoException e){
            System.out.println("Saldo insufuciente");
        }
        return getSaldo();
    }

    //devuelve la lista con los ingresos de la cuenta
    public List<Ingreso> getIngresos(){
        if (ingresos.isEmpty()){
            System.out.println("Actualmente no hay ningún ingreso");
        }
        return ingresos;
    }

    //devuelve la lista con los gastos de la cuenta
    public List<Gasto> getGastos(){
        if (gastos.isEmpty()){
            System.out.println("Actualmente no hay ningún gasto");
        }
        return gastos;
    }

    @Override
    public String toString() {
        return "El saldo actual de la cuenta es: " + getSaldo() + "€";
    }
}

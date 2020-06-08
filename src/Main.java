import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Usuario user = new Usuario();
        Cuenta cuenta = new Cuenta(user);
        solicitar_datos(user);

        //menu principal. sale del programa cuando se pulsa el 0 y sólo acepta números del 0 al 5
        String opcion;
        do {
            System.out.println("Realiza una nueva acción");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");
            opcion = scan.nextLine();
            if (opcion.matches("^[0-5]$")) {
                switch (opcion) {
                    case "1":
                        String descripcion_gasto = crear_descripcion();
                        double cantidad_gasto = crear_cantidad();
                        cuenta.addGastos(descripcion_gasto, cantidad_gasto);
                        System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");;
                        break;
                    case "2":
                        String descripcion_ingreso = crear_descripcion();
                        double cantidad_ingreso = crear_cantidad();
                        cuenta.addIngresos(descripcion_ingreso, cantidad_ingreso);
                        System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");;
                        break;
                    case "3":
                        for (Gasto gast:cuenta.getGastos()){
                            System.out.println(gast.toString());
                        }
                        break;
                    case "4":
                        for (Ingreso ing:cuenta.getIngresos()){
                            System.out.println(ing.toString());
                        }
                        break;
                    case "5":
                        System.out.println(cuenta.toString());
                        break;
                    case "0":
                        break;
                }
            } else {
                System.out.println("Introduce un numero del 1 al 5");
            }
        } while (!opcion.equals("0"));

        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicación");
    }

    /*funcion para solicitar al usuario su nombre, edad y DNI*/
    public static void solicitar_datos(Usuario user){
        boolean ok;
        Scanner scan = new Scanner(System.in);

        //solicita el nombre de usuario hasta que introduce uno correcto
        do {
            System.out.println("Introduce el nombre de usuario");
            String nombre = scan.nextLine();
            if (nombre.matches("^[a-zA-Z]{1,15}$")) {
                user.setNombre(nombre);
                ok = true;
            } else {
                System.out.println("Introduce solamente letras (máximo 15)");
                ok = false;
            }
        } while (!ok);

        //solicita la edad del usuario hasta que se introduce una entre 18 y 120 años
        do {
            System.out.println("Introduce la edad del usuario");
            String edad = scan.nextLine();
            if (edad.matches("^[0-9]+$")) {
                int age = Integer.parseInt(edad);
                if (age < 18 || age > 120) {
                    System.out.println("Introduce un número del 18 al 120");
                    ok = false;
                } else {
                    user.setEdad(age);
                    ok = true;
                }
            } else {
                System.out.println("Introduce solamente números");
                ok = false;
            }
        } while (!ok);

        //solicita el DNI al usuario. se graba sólo si el setter devuelve true
        do {
            System.out.println("Introduce el DNI del usuario");
            String DNI = scan.nextLine();
            ok = user.setDNI(DNI);
        } while (!ok);

        System.out.println("Usuario creado correctamente");
    }

    /*solicita al usuario la descripcion del movimiento. No puede estar vacío*/
    public static String crear_descripcion(){
        String descripcion_gasto;
        do {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Introduce la descripción");
            descripcion_gasto = scan1.nextLine();
        } while (descripcion_gasto.equals(""));
        return descripcion_gasto;
    }

    /*solicita al usuario la cantidad del gasto/ingreso. Tiene que ser un número mayor que 0*/
    public static double crear_cantidad(){
        double cantidad_gasto;
        do {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Introduce la cantidad");
            try {
                cantidad_gasto = scan1.nextDouble();
            } catch (Exception e) {
                System.out.println("Introduce sólo números");
                cantidad_gasto=0;
            }
            if (cantidad_gasto <= 0){
                System.out.println("Ha de ser una cantidad mayor a 0");
                cantidad_gasto=0;
            }
        } while (cantidad_gasto == 0);
        return cantidad_gasto;
    }
}


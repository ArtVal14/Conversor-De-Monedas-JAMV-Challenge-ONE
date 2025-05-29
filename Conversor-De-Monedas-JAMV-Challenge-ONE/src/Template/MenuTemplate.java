package Template;

import interfaz.ILector;

public abstract class MenuTemplate implements ILector {
    String op;

    public abstract void converse();

    public final void iniciarMenu() {
        do {
            System.out.println("---- Conversor de monedas ----");
            System.out.println("1. Conversion");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción: ");
            op = leer.nextLine();
            System.out.println("-------------------------------------");
            switch (op) {
                case "1":
                    converse();
                    break;
                case "0":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Escoge una opcion valida");
            }
        } while (!op.equals("0"));
    }
}

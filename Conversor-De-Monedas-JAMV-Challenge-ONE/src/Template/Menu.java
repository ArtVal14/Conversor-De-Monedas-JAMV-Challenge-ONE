package Template;

import Consultas.Consulta;
import Modelos.Monedas;


public class Menu extends Template.MenuTemplate {
    @Override
    public void converse() {
        // Se crea un objeto de la clase Consulta,  para conectarse a la API de tasas de cambio
        Consulta consulta = new Consulta();

        //Asegura que no hayan espacios inicio-fin y que este en mayusculas
        System.out.print("Moneda base (ej: USD): ");
        String base = leer.nextLine().trim().toUpperCase();

        System.out.print("Moneda destino (ej: CLP): ");
        String destino = leer.nextLine().trim().toUpperCase();

        System.out.print("Monto: ");
        double monto = leer.nextDouble();
        leer.nextLine();

        // Este metodo devuelve un objeto que contiene todas las tasas de cambio de base
        Monedas moneda = consulta.monedaCambio(base);
        // Validación de la moneda base
        if (!"success".equalsIgnoreCase(moneda.result())) {
            System.out.println("Moneda base no válida o no encontrada.");
            return;
        }
        // Se accede al map, al atributo y se obtiene el valor asociado a una clave atravez de get
        Double tasa = moneda.conversion_rates().get(destino);
        if (tasa != null) {
            double convertido = monto * tasa;
            System.out.println("Con " + monto + " " + base + " obtienes aproximadamente " + convertido + " " + destino + ".");
        } else {
            System.out.println("Moneda destino no encontrada.");
        }
    }
}


package Consultas;
import Modelos.Monedas;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public Monedas monedaCambio(String name1){
        //Direccion modificable
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/a8ab2f47d10973f4faaae702/latest/" + name1);
        //Se crea un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        //Se crea la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        //Se declara una variable para guardar la respuesta
        HttpResponse<String> response = null;
        try {
            // Se envía la solicitud HTTP, obteniendo la respuesta como texto (String) desde la API
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Se convierte la respuesta JSON en un objeto Moneda
            return new Gson().fromJson(response.body(), Monedas.class);
            // catch para error entrada/salida y error de interrupcion
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consultar los datos de la API.");
            throw new RuntimeException(e);
        }
    }
}

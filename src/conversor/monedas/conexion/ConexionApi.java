package conversor.monedas.conexion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    private String baseUrl = "https://v6.exchangerate-api.com/v6/";
    private final String key = System.getenv("EXCHANGE_RATE_API_KEY");
    private HttpClient client = HttpClient.newHttpClient();

    public String convertir(String moneda1, String moneda2, double monto, Gson gson){
        String url = this.baseUrl+this.key+"/pair/"+moneda1.toUpperCase()+"/"+moneda2.toUpperCase();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = this.client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            return monto + " " + moneda1 + " * " + conversionRate + " = " + conversionRate * monto + " " + moneda2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

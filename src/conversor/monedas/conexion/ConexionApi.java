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
    private String key ="9fc651ac9014487092adfbc3";

    public String convertir(String moneda1, String moneda2, float monto){
        String url = this.baseUrl+this.key+"/pair/"+moneda1+"/"+moneda2;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            // Acceder al valor de "conversion_rate"
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            //String conversionRate = gson.fromJson(resultado, String.class);
            System.out.println(conversionRate);

            //return response.body();
            return monto + " " + moneda1 + " * " + conversionRate + " = " + conversionRate * monto + " " + moneda2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

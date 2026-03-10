import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ApiService{

    private final String apiKey;

    private static final Set<String> allowed_currency = Set.of(
            "USD","ARS", "BRL", "MXN", "PEN", "COP"
    );

    public ApiService(String apiKey){
        this.apiKey = apiKey;
    }

    public List<Currency> fetchCurrencies(){
        List<Currency> currencies = new ArrayList<>();
        HttpURLConnection connection = null;

        try{
            //Construimos la Url
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";
            URL url = new URL(urlStr);

            //Abrimos la conexion
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // Verificamos que la respuesta sea 200 OK
            if (connection.getResponseCode() == 200) {
                // Parseamos JSON
                JsonObject jsonObj = JsonParser.parseReader(new InputStreamReader(connection.getInputStream()))
                        .getAsJsonObject();

                JsonObject rates = jsonObj.getAsJsonObject("conversion_rates");

                // Creamos un Currency por cada divisa
                for (String code : rates.keySet()) {
                    if (allowed_currency.contains(code)){
                        double rate = rates.get(code).getAsDouble();
                        currencies.add(new Currency(code, rate));
                    }

                }

            } else {
                System.err.println("Error en la petición: " + connection.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Cerramos la conexión siempre
            if (connection != null) {
                connection.disconnect();
            }
        }

        return currencies; // devolvemos la lista lista de monedas
    }



}
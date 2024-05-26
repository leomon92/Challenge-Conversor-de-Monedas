package ConsumoAPI;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaDivisa {
    @SerializedName("base_code")
    private String base;
    @SerializedName("target_code")
    private String cambio;
    @SerializedName("conversion_rate")
    private String conversion;

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public String getConversion() {
        return conversion;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void getResConsulta(String base, String cambio) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create("https://v6.exchangerate-api.com/v6/b4c60d0e1441024cd8150e72/pair/"+base+"/"+cambio))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        ConsultaDivisa cdiv = gson.fromJson(json, ConsultaDivisa.class);
        //System.out.println(cdiv.conversion);
        setConversion(String.valueOf(cdiv.conversion));
    }

    @Override
    public String toString() {
        return "base ="+ base + '\'' +
                ", cambio='" + cambio + '\'' +
                ", conversion='" + conversion ;
    }
}

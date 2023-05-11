

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PesquisaCep {

    private String endereco;
    public String pesquisaCep(String cep){

        String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";
        String jsonRetorno = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            jsonRetorno = response.body();
        } catch (NumberFormatException  e) {
            System.out.println("Insira um valor númerico e sem traços!");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu algum erro no momento da consulta!");
            System.out.println(e.getMessage());
        }

        return jsonRetorno;
    }

    public void geraArquivo(List<String> enderecos) throws IOException {
        FileWriter escreveArquivo = new FileWriter("enderecos.json");

        escreveArquivo.write(enderecos.toString());
        escreveArquivo.close();

    }
}

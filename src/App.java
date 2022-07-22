import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {

            String titulo = filme.get("fullTitle");
            String image = filme.get("image");
            String nota = filme.get("imDbRating");

            System.out.print("Titulo: ");
            System.out.println("\u001b[1m" + titulo + "\u001b[m");
            System.out.print("Imagem: ");
            System.out.println("\u001b[3m \u001b[1m" + image + "\u001b[m");
            System.out.println("\u001b[37m \u001b[44m" + "Classificação: " + nota + "\u001b[m");
            System.out.println();
        
        }
    }
}

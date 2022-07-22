import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //request HTTP de acesso aos dados da API IMDB
        String url = "https://api.nasa.gov/planetary/apod?api_key=jJtwJ41k5BxdGl0DnijgpAwNqe5jaUo1FeOixwvs&start_date=2022-06-12&end_date=2022-06-14";

        var http = new ClientHttp();
        String json = http.busaDados(url);

        ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();
        List<Conteudo> conteudos = extrator.extraConteudos(json);


        var geradora = new GeradorDeFigurinha();
        for (int i = 0; i<3 ; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTiutulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTiutulo());
        }
    }
}

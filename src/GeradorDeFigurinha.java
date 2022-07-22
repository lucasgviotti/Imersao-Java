import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class GeradorDeFigurinha {
    
    public void cria(InputStream openStream, String nomeArquivo) throws Exception {

        //leitura da imagem
        //InputStream openStream = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKHlE_iWQqLEcvNARU-gFXIEFkYsW5clN6xQ&usqp=CAU").openStream();
        BufferedImage imagemOriginal = ImageIO.read(openStream);

        //cria nova imagem em memoria com transparencia e novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura;
        BufferedImage imagemNova = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem
        Graphics2D graphics = (Graphics2D) imagemNova.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

        //escrita e definições de font
        //var fonte = new Font(Font.SANS_SERIF, Font.BOLD,76);
        //graphics.setColor(Color.RED);
        //graphics.setFont(fonte);
        //graphics.drawString("Comédia do", 40, novaAltura - 90);
        //graphics.drawString("SÉCULO", 75, novaAltura - 10);
        
        //criador de nova imagem com escrita
        ImageIO.write(imagemNova, "png", new File(nomeArquivo));

    }

    //public static void main(String[] args) {
    //}

}



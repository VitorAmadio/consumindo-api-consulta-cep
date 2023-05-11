import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        PesquisaCep pesquisaCep = new PesquisaCep();
        Scanner leitura = new Scanner(System.in);
        String cep = "";
        List<String> listaEndereco = new ArrayList<>();

        while (!cep.equalsIgnoreCase("sair")){
            System.out.println("Digite um Cep sem a utilização do '-' ou para sair digite 'sair' ");
            cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")) break;
            listaEndereco.add(pesquisaCep.pesquisaCep(cep));

        }

        pesquisaCep.geraArquivo(listaEndereco);

    }
}

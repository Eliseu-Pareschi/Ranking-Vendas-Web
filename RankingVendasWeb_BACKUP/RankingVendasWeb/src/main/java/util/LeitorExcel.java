package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import model.Vendedor;

// Bibliotecas Apache POI utilizadas para leitura de planilhas Excel
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LeitorExcel{

    // Lê a planilha Excel e converte os dados em uma lista de vendedores.
    public List<Vendedor> lerVendedoresDoExcel(String caminhoArquivo){
        List<Vendedor> listaVendedores = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream(new File(caminhoArquivo));
        Workbook workbook = WorkbookFactory.create(fis)){
            Sheet aba = workbook.getSheetAt(0);
    //ELE VAI VARRER TODAS AS LINHAS DA PLANILHA TIRANDO O CABEÇALHO, ELE COMEÇA NA LINHA 1 E VAI INDO ATÉ O FIM DELA
            for(int i = 1; i<= aba.getLastRowNum(); i++ ){
                Row linha = aba.getRow(i);
    // SE A LINHA ESTIVER VAZIA ELE VAI PULAR PARA PROXIMA LINHA
                if(linha == null){
                    continue;
                }
                //PEGA OS VALORES DA COLUNA M (12) - POSIÇÃO
                Cell celulaPosicao = linha.getCell(12);
                int posicao = 0;
                
                if(celulaPosicao != null){
                // SE O EXCEL LER COMO NUMERO ELE TRANSFORMA EM INT
                    posicao = (int) celulaPosicao.getNumericCellValue();
                }

                //PEGA OS NOMES DA COLUNA 13 RANKING 
                Cell celulaNome = linha.getCell(13);
                String nome = " ";

                if(celulaNome != null){
                    nome = celulaNome.getStringCellValue().trim();
                }
                // IGNORA SE A LINHA ESTIVER VAZIA OU FOR NOME RANKING
                if(nome.isEmpty() || nome.equalsIgnoreCase("RANKING")){
                    continue;
                }
                // PEGA CELULA DA COLUNA 14 QUANTIDADE 
                Cell celulaQuantidade = linha.getCell(14);
                int quantidadeVendas = 0;

                if (celulaQuantidade != null ) {
                    quantidadeVendas = (int) celulaQuantidade.getNumericCellValue();
                }
                // CRIAÇÃO DE UM OBJETO VENDEDOR E PREENCHE COM OS LADOS LIDOS
                Vendedor vendedor = new Vendedor();
                vendedor.setNome(nome);
               // Trocamos por setVendas para usar o modificador correto 
                vendedor.setVendas(quantidadeVendas);
                // GUARDA O VENDEDOR PRONTO NA LISTA
                listaVendedores.add(vendedor);
            }
        }catch(Exception e){
            System.out.println("Erro ao ler o arquivo do Excel: " + e.getMessage());
        }
        
        return listaVendedores;
    }
}
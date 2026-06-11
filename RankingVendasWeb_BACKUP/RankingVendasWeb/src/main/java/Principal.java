
import controller.VendedorController;

public class Principal {
    public static void main(String[] args) {
        VendedorController controller = new VendedorController();
        
         // Caminho da planilha utilizada como fonte de dados
        String caminhoPlanilha = "VENDAS JUNHO.xlsm"; 
        
        try {
             // Inicia o processo de importação dos dados para o banco
            controller.importarRankingDoExcel(caminhoPlanilha);
            
        } catch (Exception e) {
            System.out.println("Ops, ocorreu um erro durante o teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
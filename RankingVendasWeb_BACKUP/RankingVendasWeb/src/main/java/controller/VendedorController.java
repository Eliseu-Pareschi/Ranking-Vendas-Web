package controller;
import java.util.List;
import dao.VendedorDAO;
import model.Vendedor;
import util.LeitorExcel;

public class VendedorController {
// INSTANCIANDO O LEITOR DO EXCEL AQUI NO TOPO PARA O CONTROLLER PODER USAR 
    private LeitorExcel leitorExcel = new LeitorExcel();

    public void atualizarVendasVendedor(Vendedor vendedor){
        VendedorDAO dao = new VendedorDAO();
        dao.atualizarVendedor(vendedor);
    }
    public List<Vendedor> obterRankingVendas(String mesFiltro){
        VendedorDAO dao = new VendedorDAO();
        return dao.buscarRanking(mesFiltro);
    }
    public void importarRankingDoExcel(String caminhoArquivo){
        System.out.println("Iniciando a importação do arquivo " + caminhoArquivo);
        // O LEITOR ENTRA EM AÇÃO E VOLTA A LISTA CHEIA DE VENDEDORES DA PLANILHA 
        List<Vendedor> listaVendedores = leitorExcel.lerVendedoresDoExcel(caminhoArquivo);
        System.out.println("Total de vendedores encontrados no ranking do Excel: " + listaVendedores.size());

        //INSTANCIANDO O DAO PARA CONVERSAR COM O BANCO DE DADOS MYSQL 
        VendedorDAO dao = new VendedorDAO();

        // VARRE TODA A LISTA DE VENDEDORES DO EXCEL E COLOCA NO BANCO
        for(Vendedor v : listaVendedores){
            v.setmesAno("JUNHO");
            //JAVA PEGA O VENDEDOR DA VEZ E MANDA O DAO ATUALIZAR O BANCO DE DADOS
            dao.atualizarVendedor(v);
        }
        System.out.println("Importação concluída no Banco de dados!");
    }
}

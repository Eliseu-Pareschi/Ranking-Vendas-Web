package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Vendedor;

public class VendedorDAO {

    //SALVAR OU ATUALIZAR (Envia Nome, Vendas e Mês para o Banco)
    public void atualizarVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO vendedor (nome, quantidade_vendas, mes_ano) VALUES (?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE quantidade_vendas = VALUES(quantidade_vendas)";

        ConexaoBanco conexaoBanco = new ConexaoBanco();

        try (Connection conn = conexaoBanco.obterConexao();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
            
            // Preenche os parâmetros da instrução SQL
            pstm.setString(1, vendedor.getNome());
            pstm.setInt(2, vendedor.getVendas()); 
            pstm.setString(3, vendedor.getMesAno()); // Envia o mês de controle

            pstm.execute();
            System.out.println("Vendas atualizadas para: " + vendedor.getNome());

        } catch (Exception e) {
            System.out.println("Erro ao atualizar vendas: " + e.getMessage());
        }
    }

    //BUSCAR RANKING (Traz os dados filtrados pelo mês que o usuário escolher)
    public List<Vendedor> buscarRanking(String mesFiltro) {
        String sql = "SELECT nome, quantidade_vendas FROM vendedor WHERE mes_ano = ? ORDER BY quantidade_vendas DESC";
        List<Vendedor> Lista = new ArrayList<>();
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        
        try (Connection conn = conexaoBanco.obterConexao();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
            
            // Define o mês que será utilizado como filtro na consulta
            pstm.setString(1, mesFiltro);
            
            try (ResultSet rst = pstm.executeQuery()) {
                  // Percorre os resultados retornados pelo banco
                while (rst.next()) {
                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome(rst.getString("nome"));
                    vendedor.setVendas(rst.getInt("quantidade_vendas"));
                    vendedor.setmesAno(mesFiltro); 
                    
                    Lista.add(vendedor);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o ranking: " + e.getMessage());
        }
        return Lista;
    }
}
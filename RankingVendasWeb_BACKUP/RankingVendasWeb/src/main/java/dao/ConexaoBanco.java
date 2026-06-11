package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
    //URL FALA QUE O BANCO É MYSQL E ESTA NO MEU PC E TEM COMO PORTA PADRÃO 3306
    private String url = "jdbc:mysql://localhost:3306/vendas_db";
    private String user = "root";
    private String password = "SUA_SENHA_AQUI";
    public Connection obterConexao(){
        try{
            // TENTA ABRIR A CONEXÃO USANDO O DRIVERMANAGNER DO JAVA
            Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            //SE DER ERRO NO BANCO EX: SENHA OU USUARIO ERRADO, VAI APARECER ESSA MENSAGEM DE ALERTA
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
            return null; //VAI RETORNAR VALOR NULO POIS A CONEXÃO FALHOU
        }
    }
}

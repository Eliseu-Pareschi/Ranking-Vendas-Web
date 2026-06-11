package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por processar as requisições
 * da página de ranking de vendas.
 */

@WebServlet("/ranking")
public class RankingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
            // Obtém o mês selecionado pelo usuário através da URL
            String mesSelecionado = request.getParameter("mesFiltro");

            // Caso nenhum mês seja informado, utiliza JUNHO como padrão
            if(mesSelecionado == null || mesSelecionado.trim().isEmpty()){
                mesSelecionado = "JUNHO";
            }
            System.out.println("Usuario quer ver ranking do mes de: " + mesSelecionado);
            // Busca no banco o ranking de vendedores do mês selecionado
            dao.VendedorDAO dao = new dao.VendedorDAO();
            java.util.List<model.Vendedor> listadoBanco = dao.buscarRanking(mesSelecionado);
            System.out.println("Quantidade de vendedores trazidos do banco: " + listadoBanco);
        // Envia a lista para a página JSP exibir o ranking
        request.setAttribute("listaRanking", listadoBanco);

// Encaminha a requisição para a página de visualização
request.getRequestDispatcher("/WEB-INF/ranking.jsp")
    .forward(request, response);
        }
}

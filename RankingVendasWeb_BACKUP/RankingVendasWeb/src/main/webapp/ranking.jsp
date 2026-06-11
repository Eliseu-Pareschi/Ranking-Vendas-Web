<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Vendedor" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Ranking de Vendas Corporativo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow-sm border-0 mb-4">
            <div class="card-body bg-dark text-white rounded-top">
                <h2 class="m-0">Painel de Desempenho - Ranking de vendas</h2>
            </div>
        </div>

        <div class="card shadow-sm border-0 mb-4">
            <div class="card-body">
                <form action="ranking" method="GET" class="row g-3 align-items-center">
                    <div class="col-md-4">
                        <label for="mesFiltro" class="form-label fw-bold">Selecione o Período:</label>
                        <select name="mesFiltro" id="mesFiltro" class="form-select">
                            <option value="JUNHO">Junho</option>
                            <option value="MAIO">Maio</option>
                        </select>
                    </div>
                    <div class="col-md-2 d-flex align-items-end">
                        <button type="submit" class="btn btn-primary w-100 fw-bold">Filtrar Ranking</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <table class="table table-striped table-hover m-0">
                    <thead class="table-secondary">
                        <tr>
                            <th scope="col" class="text-center" style="width: 10%">Posição</th>
                            <th scope="col">Nome do Vendedor</th>
                            <th scope="col" class="text-center" style="width: 25%;">Quantidade de Vendas</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        // 1. CORRIGIDO: 'List' com L maiúsculo
                        List<Vendedor> lista = (List<Vendedor>) request.getAttribute("listaRanking");
                        if (lista != null && !lista.isEmpty()) {
                            int posicao = 1;
                            for (Vendedor v : lista) {
                        %>
                                <tr>
                                    <td class="text-center fw-bold"><%= posicao++ %>°</td>
                                    <td><%= v.getNome() %></td>
                                    <td class="text-center fw-bold text-success"><%= v.getVendas() %></td>
                                </tr>
                        <%
                            }
                        } else { 
                            // 2. CORRIGIDO: Fechamos o Java com '%>' antes de colocar as tags HTML do 'else'
                        %>
                            <tr>
                                <td colspan="3" class="text-center text-muted p-4">
                                    Nenhum dado encontrado para o período selecionado. Escolha um mês e clique em Filtrar!
                                </td>
                            </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div> </body>
</html>
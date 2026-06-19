const baseFirebase = "https://rankingvendasweb-default-rtdb.firebaseio.com/ranking";

const tabela = document.getElementById("tabela-ranking");
const mesFiltro = document.getElementById("mesFiltro");
const ultimaAtualizacao = document.getElementById("ultimaAtualizacao");

async function carregarRanking() {
    const mes = mesFiltro.value;

    const resposta = await fetch(`${baseFirebase}/${mes}.json`);
    const ranking = await resposta.json();

    tabela.innerHTML = "";

    if (!ranking) {
        tabela.innerHTML = `
            <tr>
                <td colspan="3">Nenhum dado encontrado para esse período.</td>
            </tr>
        `;

        atualizarHorario();
        return;
    }

    ranking.forEach(item => {
        let classeLinha = "";
        let medalha = "";
        let destaqueNome = "";
        let destaqueVendas = "";

        if (item.posicao === 1) {
            classeLinha = "primeiro";
            medalha = "🥇";
            destaqueNome = "👑";
            destaqueVendas = "🔥";
        } else if (item.posicao === 2) {
            classeLinha = "segundo";
            medalha = "🥈";
            destaqueVendas = "⚡";
        } else if (item.posicao === 3) {
            classeLinha = "terceiro";
            medalha = "🥉";
            destaqueVendas = "💪";
        } else if (item.quantidade > 0) {
            destaqueVendas = "⭐";
        }

        tabela.innerHTML += `
            <tr class="${classeLinha}">
                <td>${medalha} ${item.posicao}°</td>
                <td class="nome">${destaqueNome} ${item.nome}</td>
                <td class="vendas">${item.quantidade}${destaqueVendas}</td>
            </tr>
        `;
    });

    atualizarHorario();
}

function atualizarHorario() {
    const agora = new Date();

    ultimaAtualizacao.innerHTML =
        `🟢 Atualizado às ${agora.toLocaleTimeString("pt-BR")}`;
}

mesFiltro.addEventListener("change", carregarRanking);

carregarRanking();
setInterval(carregarRanking, 3000);

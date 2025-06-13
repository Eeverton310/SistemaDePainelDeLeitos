async function carregarHistorico() {
  try {
    const resposta = await fetch("/api/historico");
    if (!resposta.ok) throw new Error('Erro ao buscar dados do histórico');

    const dados = await resposta.json();

    const tbody = document.getElementById('tabela-corpo');
    tbody.innerHTML = '';

    dados.forEach(item => {
      const tr = document.createElement('tr');

      const nomeAbreviado = item.nome
          ? item.nome.split(' ').map(p => p[0]).join('.').toUpperCase()
          : '';

      const dataEntradaFormatada = item.dataEntrada
          ? new Date(item.dataEntrada).toLocaleString('pt-BR')
          : '';

      const previsaoAltaFormatada = item.previsaoAlta
          ? new Date(item.previsaoAlta).toLocaleString('pt-BR')
          : '';

      tr.innerHTML = `
                    <td>${item.numero || ''}</td>
                    <td>${nomeAbreviado}</td>
                    <td>${item.sexo || ''}</td>
                    <td>${item.idade ? item.idade : ''}</td>
                    <td>${item.nomeProcedimento || ''}</td>
                    <td>${item.nomeCirurgiao || ''}</td>
                    <td>${dataEntradaFormatada}</td>
                    <td>${previsaoAltaFormatada}</td> <!-- Mantivemos a Previsão de Alta -->
                `;

      tbody.appendChild(tr);
    });

  } catch (error) {
    console.error('Erro ao carregar histórico:', error);
  }
}

function atualizarDataHora() {
  const agora = new Date();
  const dataFormatada = agora.toLocaleString('pt-BR', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit'
  });

  const elementoData = document.getElementById('data-atualizacao');
  if (elementoData) {
    elementoData.textContent = `Atualizado em: ${dataFormatada}`;
  }
}

window.onload = () => {
  carregarHistorico();
  atualizarDataHora();
  setInterval(carregarHistorico, 10000);
  setInterval(atualizarDataHora, 10000);
};

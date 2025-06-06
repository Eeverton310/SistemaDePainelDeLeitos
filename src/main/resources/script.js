async function carregarHistorico() {
  try {
    const resposta = await fetch('http://localhost:8081/api/historico');
    if (!resposta.ok) throw new Error('Erro ao buscar dados do histórico');

    const dados = await resposta.json();

    const tbody = document.getElementById('tabela-corpo');
    tbody.innerHTML = ''; // Limpa a tabela antes de adicionar os novos dados

    dados.forEach(item => {
      const tr = document.createElement('tr');

      const nomeAbreviado = item.nomeAbreviado || '';

      const dataEntradaFormatada = item.dataEntrada
          ? new Date(item.dataEntrada).toLocaleDateString('pt-BR')
          : '';

      let classeStatus = '';
      if (item.statusCirurgia.toLowerCase().includes('alta')) classeStatus = 'alta';
      else if (item.statusCirurgia.toLowerCase().includes('cirurgia')) classeStatus = 'baixa';
      else classeStatus = 'media';

      tr.innerHTML = `
        <td>${item.numero || ''}</td>
        <td>${nomeAbreviado}</td>
        <td>${item.sexo || ''}</td>
        <td>${item.idade ? item.idade + ' anos' : ''}</td>
        <td>${item.nomeProcedimento || ''}</td>
        <td>${item.nomeCirurgiao || ''}</td>
        <td>${dataEntradaFormatada}</td>
        <td><span class="status ${classeStatus}">${item.statusCirurgia || ''}</span></td>
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

// Função chamada ao carregar a página
window.onload = () => {
  // Carregar os dados inicialmente
  carregarHistorico();
  atualizarDataHora();

  // Atualizar a tabela e o horário a cada 10 segundos
  setInterval(() => {
    carregarHistorico();
    atualizarDataHora();
  }, 10000); // Atualiza a tabela e a hora a cada 10 segundos
};

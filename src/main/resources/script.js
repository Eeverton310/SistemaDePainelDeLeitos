async function carregarHistorico() {
  try {
    const resposta = await fetch('http://localhost:8081/api/historico');
    if (!resposta.ok) throw new Error('Erro ao buscar dados do histórico');

    const dados = await resposta.json();

    const tbody = document.getElementById('tabela-corpo');
    tbody.innerHTML = '';  // Limpa linhas antigas

    dados.forEach(item => {
      const tr = document.createElement('tr');

      // Formatar dataEntrada dd/MM/yyyy
      const dataEntradaFormatada = item.dataEntrada
          ? new Date(item.dataEntrada).toLocaleDateString('pt-BR')
          : '';

      // Definir classe do status para colorir conforme CSS
      let classeStatus = '';
      if (item.statusCirurgia.toLowerCase().includes('alta')) classeStatus = 'alta';
      else if (item.statusCirurgia.toLowerCase().includes('cirurgia')) classeStatus = 'baixa';
      else classeStatus = 'media';

      tr.innerHTML = `
        <td>${item.numero || ''}</td>
        <td>${item.nome || ''}</td>  <!-- nome mostrado exatamente como veio do backend -->
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

// Atualiza a tabela quando a página carregar
window.onload = carregarHistorico;

// Atualiza a tabela a cada 10 segundos
setInterval(carregarHistorico, 10000);

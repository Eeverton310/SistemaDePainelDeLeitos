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

atualizarDataHora();

setInterval(atualizarDataHora, 60000);

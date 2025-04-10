// Suponha que você já tenha definido os valores e rótulos em algum lugar do seu código
// Por exemplo:


// Configuração do gráfico de rosquinha
var ctx = document.getElementById("myDonutChart").getContext('2d');
var myDonutChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: rotulos,
    datasets: [{
      data: valores,
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#ff6384', '#ff9f40'], // Cores para cada fatia
    }],
  },
  options: {
    cutoutPercentage: 40, // Ajuste a espessura da rosquinha aqui
    title: {
      display: true,
      text: 'Quantidade Alunos por Turma',
    },
  },
});

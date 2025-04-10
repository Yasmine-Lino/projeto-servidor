
// Defina uma paleta de cores
var paletaDeCores = [
    'rgba(255, 99, 132, 0.7)',
    'rgba(54, 162, 235, 0.7)',
];

// Configuração do gráfico de barras
var ctx = document.getElementById('barChart').getContext('2d');

var datasets = [];

// Encontre o valor máximo para determinar a altura mínima
var maxValor = Math.max(...valores);

for (var i = 0; i < valores.length; i++) {
    var alturaMinima = maxValor * 0.05; // Defina 5% do valor máximo como altura mínima
    var altura = valores[i] < alturaMinima ? alturaMinima : valores[i];
    var backgroundColor = paletaDeCores[i];

    datasets.push({
        label: rotulos[i],
        data: [altura],
        backgroundColor: backgroundColor,
        borderWidth: 1
    });
}

var barChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [''],
        datasets: datasets
    },
    options: {
        scales: {
            y: {
                beginAtZero: true,
                suggestedMin: 0,
                suggestedMax: maxValor + maxValor * 0.2 // Ajuste para uma escala adequada
            }
        }
    }
});

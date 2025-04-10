// Dados para o gráfico de pizza
var data = {
    labels: periodo,
    datasets: [{
        data: qtidade, // Valores para cada categoria
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'], // Cores para cada fatia
        hoverBackgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'] // Cores ao passar o mouse
    }]
};

// Configuração do gráfico de pizza
var ctx = document.getElementById('myPieChart2').getContext('2d');
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: data,
    options: {
        responsive: true,
        maintainAspectRatio: false,
        legend: {
            display: true,
            position: 'bottom'
        }
    }
});

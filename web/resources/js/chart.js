var options = {
    legend: {
        display: false
    },
    scales: {
        yAxes: [{
            stacked: true
        }],
    },
    plugins: {
        filler: {
            propagate: false
        },
        samples_filler_analyser: {
            target: 'chart-analyser'
        }
    },
};

var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    options: options,
    data: {
        labels: ['Janeiro', 'Fevereiro', 'Marco', 'Abril', 'Maio', 'Junho', 'Julho'],
        datasets: [{
            label: 'Gastos em 2017',
            data: [36890, 87983, 109872, 135237, 170129, 193128, 236439],
            lineTension: 0,
            borderColor: '#22375b',
            fill: true,
            backGroundColor: '#f1bf45',
        }]
    }
});
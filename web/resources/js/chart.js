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

var ctx = document.getElementById('geralChart').getContext('2d');
var geralChart = new Chart(ctx, {
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

buscarDados(12);
loadData();

function buscarDados(p1) {
    alert(p1)
}

function loadData(){
    
        var xhttp = new XMLHttpRequest();
        
        xhttp.onreadystatechange = function(){
            if(this.readyState == 4 && this.status == 200){
                console.log((JSON.parse(this.responseText)));
                var jsonData = JSON.parse(this.responseText);
                
                console.log(jsonData[0].vereador + " - " + jsonData[0].mediaGastos);
            }
        }
        xhttp.open('GET','http://localhost:8080/web-app/webresources/ws/gastos_vereador/list', true);
        xhttp.send();
    }
    loadData();
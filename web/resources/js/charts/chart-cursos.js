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

var xhttp = new XMLHttpRequest();
let jsonData;
        xhttp.onreadystatechange = function(){
            if(this.readyState == 4 && this.status == 200){
                console.log((JSON.parse(this.responseText)));
                jsonData = JSON.parse(this.responseText);
                
                console.log(jsonData[0].mes + " - " + jsonData[0].totalGasto);
                
                var ctx = document.getElementById('geralChart').getContext('2d');
                var geralChart = new Chart(ctx, {
                    type: 'line',
                    options: options,
                    data: {
                        labels: [jsonData[0].mes,  jsonData[1].mes, jsonData[2].mes, jsonData[3].mes, 
                            jsonData[4].mes, jsonData[5].mes, jsonData[6].mes, jsonData[7].mes, jsonData[8].mes,
                            jsonData[9].mes, jsonData[10].mes, jsonData[11].mes],
                        datasets: [{
                            label: 'Valor',
                            data: [formatNumber(jsonData[0].totalGasto), formatNumber(jsonData[1].totalGasto), formatNumber(jsonData[2].totalGasto), 
                                formatNumber(jsonData[3].totalGasto), formatNumber(jsonData[4].totalGasto),formatNumber(jsonData[5].totalGasto), formatNumber(jsonData[6].totalGasto),
                                formatNumber(jsonData[7].totalGasto), formatNumber(jsonData[8].totalGasto), formatNumber(jsonData[9].totalGasto),formatNumber(jsonData[10].totalGasto),
                                formatNumber(jsonData[11].totalGasto)],
                            lineTension: 0,
                            borderColor: '#22375b',
                            fill: true,
                            backGroundColor: '#f1bf45',
                        }]
                    }
                });
                
                
            }
        }
xhttp.open('GET','http://localhost:8080/web-app/webresources/ws/grafico/cursos', true);
xhttp.send();

function formatNumber(numero) {
    
    return parseFloat(Math.round(numero));    
    
}
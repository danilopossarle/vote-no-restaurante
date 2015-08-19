/**
 * Javascript para a página de resultado
 */
 $(function () { 
	$( "#accordion" ).accordion({
		heightStyle: "content"
	});
	
    $('#highchartsRankingUsuario').highcharts({
        data: {
            table: 'dataUsuario'
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Ranking Pessoal'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: 'Votos'
            }
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    this.point.y + ' ' + this.point.name.toLowerCase();
            }
        }
    });
    
    $('#highchartsRankingGeral').highcharts({
        data: {
            table: 'dataGeral'
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'Ranking Geral'
        },
        yAxis: {
            allowDecimals: false,
            title: {
                text: 'Votos'
            }
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>' +
                    this.point.y + ' ' + this.point.name.toLowerCase();
            }
        }
    });
});
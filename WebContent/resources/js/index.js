/**
 * Javascript para a página inicial onde ocorrerá a votação dos restaurantes
 */
var cont = 0;
var opcoesVoto;

var votos = new Object();

function addVoto(key) {
	if (votos[key] == undefined) {
		votos[key] = {qtde: 1, nome: key};
	} else {
		votos[key] = {qtde: votos[key].qtde+1, nome: key};
	}
}

$(document).ready(function() {
	opcoesVoto = $('.votacao');
	$(opcoesVoto[0]).fadeIn(500);
	cont++;

	$('.produto').click(function() {
		addVoto($(this).find("img").attr("title"));
		if (cont < opcoesVoto.size()) {
			$(opcoesVoto[cont - 1]).fadeOut(500, function() {
				$(opcoesVoto[cont]).fadeIn(500);
				cont++;
			});
		} else {
			//formatando dados para enviar via POST através de um JSON
			data = new Object();
			data["votos"] = new Array();
		    for (key in votos) {
		    	if(key != "getKeys") {
		    		data["votos"].push({"restaurante": key, "quantidade": votos[key].qtde});
		    	}
		    }
		    
		    $.ajax({
				type: 'POST',
				dataType: 'json',
				contentType: 'application/json',
				url: "/usuarios/cadastro",
				data: JSON.stringify(data),
				success: function(response) {
				     
				}
			});
		}
	});
});

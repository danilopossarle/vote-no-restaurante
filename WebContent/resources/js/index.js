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
			$(opcoesVoto[cont - 1]).fadeOut(250, function() {
				$(opcoesVoto[cont]).fadeIn(250);
				qtdeAntiga = $("#"+$(this).find("img").attr("title")).val();
				$("#"+$(this).find("img").attr("title")).val(qtdeAntiga++);
				cont++;
			});
		} else {
			//formatando dados para enviar via POST através de um JSON
			data = new Object();
			data["votosModel"] = new Array();
		    for (key in votos) {
		    	if(key != "getKeys") {
		    		data["votosModel"].push({"restaurante": key, "quantidade": votos[key].qtde.toString()});
		    	}
		    }
		    
		    $.redirect('/vote-no-restaurante/usuarios/cadastro', votos, 'POST');
		    
//		    $.ajax({
//				type: 'POST',
//				dataType: 'json',
//				headers: { 
//			        'Accept': 'application/json',
//			        'Content-Type': 'application/json;charset=UTF-8' 
//			    },
//				url: "/vote-no-restaurante/usuarios/cadastro",
//				data: JSON.stringify(data),
//				success: function(response){
//					console.log("Success");
//					$(document).html(response);
//				},
//				error: function(response){
//					alert("error");
//				}
//			});
		}
	});
});

/**
 * Confirmação de exclusão de contato
 * @author João Gustavo
 */

 function confirmar(idcon){
	 let resposta = confirm("Confirma a exclusão deste contato?")
	 if(resposta === true){
		 //confirmar que está recebendo o id do contato que será excluído
		 //alert(idcon)
		 window.location.href = "delete?idcon=" + idcon
	 }
	 
 }
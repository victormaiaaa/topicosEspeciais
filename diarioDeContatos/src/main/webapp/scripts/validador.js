/**
 * Validação de formulário
 * @author João Gustavo 
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let telefone = frmContato.telefone.value
	 let email = frmContato.email.value
	 if(nome === ""){
		 alert('Preencha o campo Nome!')
		 frmContato.nome.focus()
		 return false
	 }else if(telefone === ""){
		 alert('Preencha o campo Telefone!')
		 frmContato.telefone.focus()
		 return false
	 }else{
		 document.forms["frmContato"].submit()
	 }
 }
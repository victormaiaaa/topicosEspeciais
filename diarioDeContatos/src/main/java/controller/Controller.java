package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report"} )
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DAO dao = new DAO();
       JavaBeans contato = new JavaBeans();

    public Controller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		teste de conexão
//		dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		}else if(action.equals("/select")) {
			listarContato(request, response);
		}else if(action.equals("/update")) {
			editarContato(request, response);
		}else if(action.equals("/delete")) {
			deletarContato(request, response);
		}else if(action.equals("/report")) {
			gerarRelatorio(request, response);
		}else {
			response.sendRedirect("diario.html");
		}
		
	}
	
	//Listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("agenda.jsp");
		//Criando um objeto para receber os dados do JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		//teste de recebimento da lista
        //for(int i = 0; i < lista.size(); i++) {
        //System.out.println(lista.get(i).getIdcon());
        //System.out.println(lista.get(i).getNome());
        //System.out.println(lista.get(i).getFone());
        //System.out.println(lista.get(i).getEmail());
        //		}
		
		//encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
}
	//Novos contatos
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento dos dados do formulário
        //System.out.println(request.getParameter("nome"));
        //System.out.println(request.getParameter("telefone"));
        //System.out.println(request.getParameter("email"));
		
		//setar as variáveis JavaBeans
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		//invocar o método inserirContato passando o objeto contato
		dao.inserirContato(contato);
		//Redirecionamento para o documento jsp
		response.sendRedirect("main");
}	
	//Editar contato
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recebimento do contato que será editado
		String idcon = request.getParameter("idcon");
		//System.out.println(idcon);
		//Setar variável JavaBeans
		contato.setIdcon(idcon);
		//Executar selecionarContato
		dao.selecionarContato(contato);
		//Teste de recebimento
		//System.out.println(contato.getIdcon());
		//System.out.println(contato.getNome());
		//System.out.println(contato.getFone());
		//System.out.println(contato.getEmail());
		//Setar atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		//Encaminha ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//teste de recebimento
		//System.out.println(request.getParameter("idcon"));
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("fone"));
		//System.out.println(request.getParameter("email"));
		//Setar as variáveis JavaBeans
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		//executar o método alterarContato
		dao.alterarContato(contato);
		//redirecionar para o documento agenda.jsp (atualizando o contato)
		response.sendRedirect("main");
	}
	
	//Remover contato
	protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		//Teste de Recebimento (confirmador.js)
		//System.out.println(idcon);
		//setar a variável JavaBeans com o idcon
		contato.setIdcon(idcon);
		//executar o método removerContato(DAO) passando o objeto contato
		dao.removerContato(contato);
		//redirecionar para o documento agenda.jsp (atualizando o contato)
		response.sendRedirect("main");
		//quando coloca main ao invés de agenda.jsp, o servelet executa a ação if (main) que leva ao metodo contatos e tras do banco de dados a lista já atualizada
	}
	//Gerar relatório geral em pdf
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document documento = new Document();
		try {
			//tipo de conteúdo
			response.setContentType("apllication/pdf");
			//nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			//criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			//abrir o documento -> conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de contatos: "));
			documento.add(new Paragraph(" "));
			//criar uma tabela
			//3 significa 3 colunas
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			//popular tabela com contatos
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for(int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());	
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	
	}
	
}

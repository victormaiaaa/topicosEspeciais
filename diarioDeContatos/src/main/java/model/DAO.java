package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	/**Módulo de conexão **/
	// Parâmetros de conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Insert your MySQL Password";
	
	//Método de conexão
	// CNTRL SHIFT O PARA IMPORTAR CLASSES
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**CRUD CREATE**/
	
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos(nome, fone, email) values (?,?,?)";
		try {
			
			//abrir conexão com o banco de dados
			Connection con = conectar();
			//Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			//Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			//Executar a query
			pst.executeUpdate();
			//Encerrar conexão com o banco de dados
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**CRUD READ**/
	
	public ArrayList<JavaBeans> listarContatos(){
		//criando um objeto para acessar a classe javabeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//O laço será executado enquanto houver contatos
			while(rs.next()) {
				//variáveis de apoio que recebem os dados do banco de dados
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				//populando o arraylist
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**CRUD UPDATE**/
	
	//Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//Setar as variáveis JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//editar o contato
	
	public void alterarContato(JavaBeans contato) {
		String create = "update contatos set nome=?,fone=?,email=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**CRUD DELETE**/
	
	public void removerContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
 
	
	
	
//	// teste de conexão
//	public void testeConexao() {
//		try {
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

}

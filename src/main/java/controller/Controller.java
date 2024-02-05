package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans usuarios = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contato(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
	}

	// Listar contatos
	protected void contato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContato();
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	// Novo contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variaveis JavaBeans
		usuarios.setNome(request.getParameter("nome"));
		usuarios.setFone(request.getParameter("fone"));
		usuarios.setEmail(request.getParameter("email"));
		// Invocar o método inserirContato passando o objeto contato
		dao.inserirContato(usuarios);
		// Redirecionar para o documento agenda.js
		response.sendRedirect("main");
	}

//Editar contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do contato que será recebido
		String idcon = request.getParameter("idcon");
		usuarios.setIdcon(idcon);
		//Executar o método selecionarContato (DAO)
		dao.selecionarContato(usuarios);
		//setar so atributos do formulario com o conteudo JavaBeans
		request.setAttribute("idcon", usuarios.getIdcon());
		request.setAttribute("nome", usuarios.getNome());
		request.setAttribute("fone", usuarios.getFone());
		request.setAttribute("email", usuarios.getEmail());
		//Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward (request, response);
	}
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		        usuarios.setIdcon(request.getParameter("idcon"));
				usuarios.setNome(request.getParameter("nome"));
				usuarios.setFone(request.getParameter("fone"));
				usuarios.setEmail(request.getParameter("email"));
	   //Executar o método de alterarContato
				dao.alterarContato(usuarios);
	  //redirecionar para o documento agenda.jsp (atualizando as alteracoes)
				response.sendRedirect("main");
	}
	//remover o contato
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//recebimento do id contato a ser excluído (validador.js)
		String idcon = request.getParameter("idcon");
		//System.out.println(idcon);
		//setar a variável idcon JavaBeans
		usuarios.setIdcon(idcon);
		//executar o método deletarContato(DAO) passando o objeto contato
		dao.deletarContato(usuarios);
		//redirecionar para o documento agenda.jsp (atualizando as alteracoes)
		response.sendRedirect("main");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edicao Contato</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="d-flex flex-column wrapper">
		<nav
			class="navbar navbar-expand-lg navbar-dark bg-black border-bottom shadow-sm mb-3">
			<div class="container">
				<a class="navbar-brand" href="/"><b>Agência de Viagem</b></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target=".navbar-collapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav flex-grow-1">
						<li class="nav-item"><a class="nav-link text-white"
							href="index.html">Página Inicial</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="destinos.html">Destinos</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="promocoes.html">Promoções</a></li>

					</ul>
					<div class="align-self-end">
						<ul class="navbar-nav">
							<li class="nav-item"><a href="main"
								class="nav-link text-white">Contato</a></li>
							<li class="nav-item"><a href="main"
								class="nav-link text-white">Cadastre - se</a></li>
							<li class="nav-item"><a href="./login/index.html"
								class="nav-link text-white">Entrar</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>

		<div class="container">
			<h4>Agência de Viagem</h4>
			<img src="imagens/agenda02.png">
			<h2>Editar Contato</h2>
			<form name="frmContato" action="update">
				<table class="table">
					<tr class="table table-hover">
						<td><input type="text" name="idcom" id="caixa3" readonly
							value="<%out.print(request.getAttribute("idcon"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="nome" class="caixa1"
							value="<%out.print(request.getAttribute("nome"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="fone" class="caixa1"
							value="<%out.print(request.getAttribute("fone"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="email" class="caixa1"
							value="<%out.print(request.getAttribute("email"));%>"></td>
					</tr>
				</table>
				<input type="button" value="Salvar" class="botao"
					onclick="validar()">
			</form>
			<script src="scripts/validador.js"></script>
		</div>
	</div>
</body>
</html>
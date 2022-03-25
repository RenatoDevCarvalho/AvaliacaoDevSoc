<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title><s:text name="label.titulo.pagina.cadastro" /></title>
    <link
      rel="stylesheet"
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
    />
  </head>
  <body class="bg-secondary">
    <nav
      class="navbar bg-light px-3 justify-content-start"
      style="background-color: #e3f2fd"
    >
      <s:url action="todosExames" var="todos" />
      <a class="navbar-brand text-dark" href="${todos}">Exames</a>
      <s:url action="todosFuncionarios" var="todos" />
      <a class="navbar-brand text-dark border-bottom border-primary" href="${todos}">Funcionários</a>
      <s:url action="todasConsultas" var="consultas" />
      <a class="navbar-brand text-dark" href="${consultas}">Consultas</a>
      <s:url action="relatorioConsultas" var="relatorio" />
      <a class="navbar-brand text-dark" href="${relatorio}">Relatório de consultas</a>
      <s:url action="melhoresConsultas" var="melhores" />
      <a class="navbar-brand text-dark" href="${melhores}">Top 5 consultas</a>
    </nav>
    <div class="container">
      <s:form action="/novoFuncionario.action">
        <div class="card mt-5">
          <div class="card-header">
            <div class="row">
              <div class="col-sm-5">
                <s:url action="todosFuncionarios" var="todos" />
                <a href="${todos}" class="btn btn-success">Funcionários</a>
              </div>

              <div class="col-sm">
                <h5 class="card-title">Novo Funcionário</h5>
              </div>
            </div>
          </div>

          <div class="card-body">
            <div class="row align-items-center">
              <label for="id" class="col-sm-1 col-form-label text-center"
                >Código:
              </label>

              <div class="col-sm-2">
                <s:textfield
                  cssClass="form-control"
                  id="id"
                  name="funcionarioVo.cdFuncionario"
                  readonly="true"
                />
              </div>
            </div>

            <div class="row align-items-center mt-3">
              <label for="nome" class="col-sm-1 col-form-label text-center"
                >Nome:
              </label>

              <div class="col-sm-5">
                <s:textfield
                  cssClass="form-control"
                  id="nome"
                  name="funcionarioVo.nome"
                />
              </div>
            </div>
          </div>

          <div class="card-footer">
            <div class="form-row">
              <button class="btn btn-primary col-sm-4 offset-sm-1">
                Salvar
              </button>
              <button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">
                Limpar Formulário
              </button>
            </div>
          </div>
        </div>
      </s:form>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
  </body>
</html>

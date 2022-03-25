<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title><s:text name="label.titulo.pagina.melhores" /></title>
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
      <a class="navbar-brand text-dark" href="${todos}">Funcionários</a>
      <s:url action="todasConsultas" var="consultas" />
      <a class="navbar-brand text-dark" href="${consultas}">Consultas</a>
      <s:url action="relatorioConsultas" var="relatorio" />
      <a class="navbar-brand text-dark" href="${relatorio}" >Relatório de consultas</a>
      <s:url action="melhoresConsultas" var="melhores" />
      <a class="navbar-brand text-dark border-bottom border-primary" href="${melhores}">Top 5 consultas</a>
    </nav>
    <div class="container">
      <s:form
        cssClass="row mt-5 mb-2 col-sm p-0 align-items-center bg-light"
        action="/melhoresConsultas.action"
      >
        <label for="data" class="col text-center"> Data inicial: </label>

        <div class="col-sm-4">
          <s:textfield
            cssClass="form-control"
            format="dd-MM-yyyy"
            type="date"
            id="data"
            name="consultaVo.dataInicial"
          />
        </div>

        <label for="data" class="col text-center"> Data final: </label>

        <div class="col-4">
          <s:textfield
            cssClass="form-control"
            format="dd-MM-yyyy"
            type="date"
            id="data"
            name="consultaVo.dataFinal"
          />
        </div>

        <div class="col">
          <button class="btn btn-primary" type="submit">
            <s:text name="label.pesquisar" />
          </button>
        </div>
      </s:form>

      <div class="row">
        <table class="table table-light table-striped align-middle">
          <thead>
            <tr>
              <th class="text-center">
              	<s:text name="label.nome.exame" />
              </th>
              <th class="text-center">
                <s:text name="label.quantidade.exame" />
              </th>
            </tr>
          </thead>

          <tbody>
            <s:iterator value="consultas">
              <tr>
                <td class="text-center">${nmExame}</td>
                <td class="text-center">${qtdExame}</td>
              </tr>
            </s:iterator>
          </tbody>
        </table>
      </div>

      <div class="row"></div>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
  </body>
</html>

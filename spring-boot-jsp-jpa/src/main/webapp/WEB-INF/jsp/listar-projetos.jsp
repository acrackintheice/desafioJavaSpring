<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:layout title="Projetos">
    <jsp:body>
        <div class="container-fluid ">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-10">
                    <div class="add-project-div">
                        <input type="button" value="Adicionar Projeto"
                            onclick="location.href='/projetos/criar'"
                            class="btn btn-primary" /> 
                    </div>
                    <div class="panel-div">
                        <div class="panel-header-div">
                            <div class="panel-header-title"> Lista de Projetos </div>
                        </div>
                        <div class="panel-content-div">
                            <table class="table table-hover">
                                <tr >
                                    <th>Nome do Projeto</th>
                                    <th>Gerente Responsável</th>
                                    <th>Data de Início </th>
                                    <th>Data de Fim </th>
                                    <th>Data de Fim Prevista</th>
                                    <th>Orçamento </th>
                                    <th>Status </th>
                                    <th style="text-align: center">Ações</th>
                                </tr>

                                <!-- loop over and print our customers -->
                                <c:forEach var="projeto" items="${projetos}">

                                    <tr>
                                        <td>${projeto.nome}</td>
                                        <td>${projeto.gerente.nome}</td>
                                        <td> <fmt:formatDate type="date" value="${projeto.dataInicio}"/> </td>
                                        <td> <fmt:formatDate type="date" value="${projeto.dataFim}"/> </td>
                                        <td> <fmt:formatDate type="date" value="${projeto.dataPrevisaoFim}"/> </td>
                                        <td>${projeto.orcamento}</td>
                                        <td>${projeto.status}</td>

                                        <td>
                                            <div class="table-actions">
                                                <button type="button" class="btn-action btn btn-sm btn-info button-descricao" data-url="projetos/${projeto.id}" data-toggle="modal" data-target="#exampleModal" data-remote="false"> Descrição </button>
                                                <button onclick="window.location.href='/projetos/editar/${projeto.id}'"  type="button" class="btn btn-primary btn-sm button-edit">Editar</button>
                                                <c:if test="${!(projeto.status == 'iniciado' || projeto.status == 'em andamento' || projeto.status == 'encerrado')}">
                                                    <button onclick="if (confirm('Tem certeza que deseja excluir este projeto?')) window.location.href='/projetos/excluir/${projeto.id}'" type="button" class="btn btn-danger  btn-sm button-delete">Excluir</button>
                                                </c:if>
                                            </div>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>

        
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myLargeModalLabel" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content "> 
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Descrição</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>
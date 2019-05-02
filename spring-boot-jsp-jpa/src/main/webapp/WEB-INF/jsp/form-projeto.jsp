<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout title="${title}">
    <jsp:body>
        <div class="container-fluid ">
            <div class="row">
                <div class="col-3">
                </div>
                <div class="col-6" style="margin-bottom: 1rem;">
                    <div class="panel-div">
                        <div class="panel-header-div">
                            <div class="panel-header-title"> Lista de Projetos </div>
                        </div>
                        <div class="panel-content-div">
                            <form:form action="/projetos/salvar" 
                                method="post" modelAttribute="projeto">
                                <div class="form-content">

                                    <!-- need to associate this data with customer id -->
                                    <form:hidden path="id" />

                                    <form:hidden path="risco" />

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="nome" class="control-label"> Nome </label>
                                                <form:input path="nome" cssClass="form-control" />
                                                <form:errors path="nome" cssClass="error" />
                                            </div>
                                            
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="dataInicio" class="control-label"> Data de Início </label>
                                                <form:input class="form-control" type="date" path="dataInicio" />
                                                <form:errors path="dataInicio" cssClass="error" />
                                            </div>
                                            
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="dataFim" class="control-label"> Data Real de Término </label>
                                                <form:input class="form-control" type="date" path="dataFim" />
                                                <form:errors path="dataFim" cssClass="error" />
                                            </div>
                                            
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="dataPrevisaoFim" class="control-label"> Data de Término Prevista </label>
                                                <form:input class="form-control" type="date" path="dataPrevisaoFim" />
                                                <form:errors path="dataPrevisaoFim" cssClass="error" />
                                            </div>
                                            
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="descricao" class="control-label"> Descrição </label>
                                                <form:input path="descricao" cssClass="form-control" />
                                                <form:errors path="descricao" cssClass="error" />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                                <div class="col" >
                                                    <label for="status" class="control-label">Status</label>
                                                    <div>
                                                        <form:select path="status" class="custom-select">
                                                            <form:option label="em análise" value="em análise"/>
                                                            <form:option label="análise realizada" value="análise realizada"/>
                                                            <form:option label="análise aprovada" value="análise aprovada"/>
                                                            <form:option label="iniciado" value="iniciado"/>
                                                            <form:option label="planejado" value="planejado"/>
                                                            <form:option label="em andamento" value="em andamento"/>
                                                            <form:option label="encerrado" value="encerrado"/>
                                                            <form:option label="cancelado" value="cancelado"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col">
                                                <label for="orcamento" class="control-label">Orçamento (R$)</label>
                                                <form:input type="number" step="0.01" min="0" path="orcamento" cssClass="form-control" />
                                                <form:errors path="orcamento" cssClass="error" />
                                            </div>
                                            
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col" >
                                                <label for="gerente" class="control-label">Gerente</label>
                                                <div>
                                                    <form:select path="gerente" class="custom-select">
                                                        <form:option value=""> Selecione um gerente para o projeto </form:option>
                                                        <form:options items="${pessoas}" itemLabel="nome" itemValue="id"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="row">
                                            
                                            <div class="col-md-offset-3 col">
                                                <button onclick="if (confirm('Tem certeza que deseja voltar? Você perderá as informações presentes no formulário')) window.location.href='/index'"  type="button" class="btn btn-primary button-edit">Voltar</button>
                                                <form:button class="btn btn-primary button-submit">Submit</form:button>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>

                </div>
                <div class="col-3">
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>
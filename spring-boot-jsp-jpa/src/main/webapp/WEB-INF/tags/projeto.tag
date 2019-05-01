<%@tag description="Componente que mostra um projeto" pageEncoding="UTF-8"%>
<%@attribute name="projeto" type="br.com.biblioteca.model.Projeto" %>

<div class="list-item alert alert-secondary ${projeto.status}">
    <div class="list-item-content nome">
        ${projeto.nome}
    </div>
    <div class="list-item-content gerente">
        ${projeto.gerente.nome}
    </div>
    <div class="list-item-content orcamento">
        ${projeto.orcamento}
    </div>
    <div class="list-item-content excluir">
        <button onclick="location.href='/projetos/editar/${projeto.id}'"  type="button" class="btn btn-primary btn-sm button-edit">Editar</button>
        <button onclick="location.href='/projetos/excluir/${projeto.id}'" type="button" class="btn btn-danger  btn-sm button-delete">Excluir</button>
    </div>
</div>

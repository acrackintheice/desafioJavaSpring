package br.com.biblioteca.model;

public class MembroData {
    private String nome;
    private String funcao; // Esse campo que estava na especificação do desafio parece não fazer sentido no contexto do sistema

    public String getNome(){
        return this.nome;
    }

    public String getFuncao(){
        return this.funcao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
}
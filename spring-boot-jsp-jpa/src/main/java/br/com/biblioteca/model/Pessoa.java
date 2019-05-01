package br.com.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    Pessoa(){}

    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    @Size(min = 0, max = 100)
    private String nome;

    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Size(min = 0, max = 14)
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "funcionario")
    private boolean funcionario;

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public boolean isFuncionario(){
        return funcionario;
    }

    public String getCpf(){
        return cpf;
    }

    public Date getDataNascimento(){
        return dataNascimento;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setFuncionario(boolean funcionario){
        this. funcionario = funcionario;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

}
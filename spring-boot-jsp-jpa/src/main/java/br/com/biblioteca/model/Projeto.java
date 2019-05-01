package br.com.biblioteca.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "projeto")
public class Projeto {

    public Projeto() {
        this.membros = new ArrayList<Pessoa>();
    }

    public Projeto(String nome, Date dataInicio, Date dataFim, Date dataPrevisaoFim, String descricao, String status,
            float orcamento, String risco, Pessoa gerente) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataPrevisaoFim = dataPrevisaoFim;
        this.descricao = descricao;
        this.status = status;
        this.orcamento = orcamento;
        this.risco = risco;
        this.gerente = gerente;
        this.membros = new ArrayList<Pessoa>();
    }

    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    @Size(min = 0, max = 200)
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Column(name = "data_fim")
    private Date dataFim;

    @Size(min = 0, max = 5000)
    @Column(name = "descricao")
    private String descricao;

    @Size(min = 0, max = 45)
    @Column(name = "status")
    private String status;

    @Column(name = "orcamento")
    private float orcamento;

    @Size(min = 0, max = 45)
    @Column(name = "risco")
    private String risco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idgerente")
    private Pessoa gerente;

    @ManyToMany
    @JoinTable(name = "membros",
    joinColumns = @JoinColumn(name = "idprojeto"),
    inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    private List<Pessoa> membros;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public String getStatus() {
        return status;
    }

    public String getRisco() {
        return risco;
    }

    public Pessoa getGerente(){
        return gerente;
    }

    public List<Pessoa> getMembros(){
        return membros;
    }

    public Date getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setDataPrevisaoFim(Date dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public void setGerente(Pessoa gerente){
        this.gerente = gerente;
    }

    public void setMembros(List<Pessoa> membros){
        this.membros = membros;
    }

}
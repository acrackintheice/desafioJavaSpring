# *Teste Programador Java* #
Teste para programador Java Desbravador

## *Instalação* ##

# *Configuração do Banco de Dados* #

O projeto utiliza o SGBD PostgresSQL com as seguintes configurações:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/portproj
spring.datasource.username=postgres
spring.datasource.password=postgres
```

Ou seja, precisa existir uma base dados com o nome *portproj*, e um usuário com nome e senha *postgres*.

Mesmo havendo a instrução de que o script de estrutura das tabelas não deveria ser alterado, isso precisou ser feito por causa de erros na definição da tabela Membro:

`-- -----------------------------------------------------`<br/>
`-- Table Membros`<br/>
`-- -----------------------------------------------------`<br/>
`CREATE TABLE membros`<br/>
`( idprojeto bigserial NOT NULL, `<br/>
`idpessoa bigint NOT NULL,  `<br/>
`CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),`<br/>
`CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES projeto (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION,`<br/>
`CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES pessoa (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION);`<br/>

A chave primária criada, deveria ser composta e incluir referências para pessoas e projetos, o que não ocorre no script, que define uma chave simples referênciado apenas projetos:

`CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),`

A próxima constraint também não faz muito sentido, pois ela faz o campo *idpessoa* referênciar o campo *id* da tabela *Projeto*, como pode ser visto abaixo:

`CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa)`<br/>
`REFERENCES projeto (id) MATCH SIMPLE`<br/>
`ON UPDATE NO ACTION ON DELETE NO ACTION,`

Resumindo, com essas configurações além de termos uma chave primária deficiente, o campo *idprojeto* não é relacionado à chave estrangeira alguma.

Para corrigir esses erros esse script foi editado e uma nova versão foi adicionada ao projeto:

https://github.com/acrackintheice/desafioJavaSpring/blob/master/spring-boot-jsp-jpa/src/main/resources/sql/create-tables.sql

# *Execução da aplicação* #

Como as outras dependências do projeto são fornecidas pelo Maven, após a configuração do banco de dados a aplicação já pode ser executada, o que pode acontecer de duas formas: utilizando o spring-boot ou gerando o .war/.jar e um servidor web tradicional.

# Spring Boot #

Para o executar o projeto com o spring-boot basta estar na pasta raiz do projeto (spring-boot-jsp-jpa), que não  a pasta raiz do repositório, e executar o comando:
```
mvn spring-boot:run
```

# Wildfly #
Para executar o projeto no servidor Wildfly basta gerar um arquivo .war com o comando:
```
mvn clean install
```
Com isso o arquivo .war será gerado no caminho 
```
/spring-boot-jsp-jpa/target/spring-boot-jsp-jpa.war
```
Para rodar a aplicação no Wildfly deve-se colocar o arquivo .war gerado em
```
<path_to_wildfly>/standalone/deployments
```
E, para sistemas Linux, executar o script
```
<path_to_wildfly>/bin/standalone.sh
```

# *Demo* #

Listagem de projeto:

![Demo Image](lista-projetos.png)


Criação de Projetos (a edição usa a mesma tela):

![Demo Image](novo-projeto.png)


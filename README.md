# Renda Familiar API
API para controle financeiro e de despesas mensais.


![Badge de status do projeto](http://img.shields.io/static/v1?label=status&message=em%20construção&color=orange)

# Tecnologias usadas

Foram usadas as seguintes tecnologias ao desenvolver esse projeto:

- Java 11
- Maven
- Spring: Boot, Web, Data JPA, Validation, Security
- Lombok
- Hibernate
- MySQL
- Flyway Migration
- Apache Tomcat
- Mockito



# Getting Started

### Você pode: 

- Baixar o [ZIP do projeto](https://github.com/matthewmatheus/renda-familiar-api/archive/refs/heads/master.zip) e abri-lo em uma IDE de sua preferência.

### Ou

- Clonar o repositório `https://github.com/matthewmatheus/renda-familiar-api`


- Rodar `mvn clean install` para instalar as dependências do projeto.

- Rodar `mvn spring-boot:run` para subir a aplicação.

- A aplicação estará disponível na port `8080`. <br> <br>
( Para alterar a porta modifique o `server.port` no arquivo `application.properties` ).

<br> 


 O banco de dados ultilizado no projeto foi o `MySQL`, ele subirá os dados automaticamente mas não irá popular, antes de subir certifique-se que o tem instalado ou modifique os arquivos de `application.properties` e `pom.xml` com as configurações e dependências do banco de sua preferência.
 
 Após subir a aplicação tem chances do `data.sql` não inserir as roles , o que pode causar conflito. <br>
 É preciso fazer manualmente no banco de dados o INSERT delas, assim o problema será resolvido:
 
``` 
INSERT INTO ROLES(ID, NAME) VALUES(1, 'USER');
INSERT INTO ROLES(ID, NAME) VALUES(2, 'ADMIN');
```

É `necessário` dar uma role para o usuário logo após sua criação para que ele seja capaz de realizar as outras requisições.




# Endpoints

Você pode ultilizar o Insomnia ou outra ferramenta de sua preferência para realizar as requisições, <br>
para facilitar aqui está um [modelo das requisições a serem feitas](https://github.com/matthewmatheus/renda-familiar-api/blob/master/src/main/resources/Insomnia.json).



### POST ( Cadastrando uma receita/despesa )



+  `http://localhost:8080/receitas` <br/> <br>
    ```json
    {
       "descricao":"descricao da receita",
	     "valor": "10000",
     	"data":"01/01/2001"
    }
    ```
    
    
    +  `http://localhost:8080/despesas` <br/> <br>
    ```json
    {
       "descricao":"descricao da despesa",
	     "valor": "1000",
     	"data":"01/01/2001"
      "categoria": "LAZER"
    }
    ```
    
    - Caso a categoria esteja vazia automaticamente será da categoria "OUTRAS". <br> <br>


### POST ( Cadastrando um usuário )


 +  `http://localhost:8080/users/create` <br/> <br>
    ```json
    {
      	"username": "fulano",
 	    "name": "fulano",
	     "password": "123"	
    }
    ```
    
      ----------------------------------------------------------- 
      <br>
    
    ### POST ( Dando uma role ao usuário ) 
    
    
    +  `http://localhost:8080/users/role` <br/> <br>
    ```json
    {
       "idUser": 1 ,
	    "idsRoles": [ 1 ]
    }
    ```
      ----------------------------------------------------------- 
      <br>
    
    
    ### GET ( Retornando lista de receitas/despesas )
    
 +  `http://localhost:8080/receitas` <br/> <br>
    ```json
    {
       	"descricao": "receita retornada ",
	    	"valor": 20000,
	    	"data": "02/02/2002"
	},
	{
	    	"descricao": "receita retornada 2",
		    "valor": 10000,
	    	"data": "01/01/2001"
    }
    ```
    
     +  `http://localhost:8080/despesas` <br/> <br>
    ```json
    {
       	"descricao": "despesa retornada ",
	    	"valor": 2000,
	    	"data": "02/02/2002"
	},
	{
	    	"descricao": "despesa retornada 2",
		    "valor": 1000,
	    	"data": "01/01/2001"
    }
    ```
     ----------------------------------------------------------- 
     <br>
     
    ### GET (Retornando por ID )
    
    + `http://localhost:8080/receitas/{id}`
    
    Basta adicionar o ID desejado na requisição. <br> <br>
    
     ----------------------------------------------------------- 
     <br>
    
    ### PUT (Atualizando receitas/despesas)
    
     +  `http://localhost:8080/receitas` <br/> <br>
    ```json
    {
      	"descricao":"receita atualizada",
    	"valor": "30000",
   	"data":"01/01/2001"

    }
    ```
    
     +  `http://localhost:8080/despesas` <br/> <br>
    ```json
    {
      	"descricao":"despesa atualizada",
    	"valor": "30000",
   	"data":"01/01/2001"

    }
    ```
    
     ----------------------------------------------------------- 
     <br>
    
    ### DELETE ( Excluindo receitas/despesas por ID )
    
     +  `http://localhost:8080/despesas/{ID}` <br/> <br>
     
     
      +  `http://localhost:8080/receitas/{ID}` <br/> <br>
    
     
     
      ----------------------------------------------------------- 
     <br>
     
     
     ### GET ( Retorna u mresumo mensal das receitas e despesas por ANO e MES )
             
      +  `http://localhost:8080/despesas/{ano}/{mes}` <br/> <br>
    ```json
    {
      "total_receitas": 10000,
	   "total_despesas": 1000,
    	"saldo_final": 9000,
	   "valor_por_categoria": [ 1000, 530 ]

    }
    ```
     
      
     ---
Developed by [Matheus Moura](https://github.com/matthewmatheus)
    
    



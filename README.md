# Teste Técnico - Visão Dev 👀/ Redação ✍ e Mão na Massa
# Sistema de Gerenciamento de Pessoas e Endereços
Este é um aplicativo simples desenvolvido em Spring Boot para gerenciar informações de pessoas e seus endereços associados.
# Funcionalidades
1. Cadastro, atualização e listagem de pessoas.
2. Cadastro, atualização e listagem de endereços associados às pessoas.
3. Marcação de um endereço como principal para cada pessoa.
4. RESTful API para integração com outras aplicações.

# Tecnologias Utilizadas
* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de Dados H2 (em memória, para fins de demonstração)

# Configuração do Ambiente de Desenvolvimento
Para executar o aplicativo em sua máquina local, você precisa ter o seguinte instalado:
* Java Development Kit (JDK) 17
* Maven

# Documentação da API
A API RESTful do aplicativo pode ser encontrada em /api, e possui os seguintes endpoints:

* GET/ http://localhost:8080/pessoas: Lista todas as pessoas cadastradas.
* GET/ http://localhost:8080/pessoas/{id}: Retorna os detalhes de uma pessoa específica.
* POST/ http://localhost:8080/pessoas): Cria uma nova pessoa.
  - body:
  {	"nomeCompleto": "Carlos Augusto",
	  "dataNascimento":"1971-09-16"		
  }

* PUT/ http://localhost:8080/pessoas/{id}: Atualiza os detalhes de uma pessoa existente.
  - body:
  {	"nomeCompleto": "Carlos Augusto",
	  "dataNascimento":"1971-09-16"		
  }

* GET/ http://localhost:8080/enderecos: Lista todas os enderecços cadastradas.
*  GET/ http://localhost:8080/enderecos/{id}: Retorna os detalhes de um endereço específico.
* POST/ http://localhost:8080/enderecos): Cria uma novo endereço.
  - body: {
  	"logradouro": "testes",
	  "cep":"57045310",
  	"numero": "1",
	  "cidade": "Maceio",
  	"estado": "Alagoas",
	  "principal": true,
  	"pessoa": {"id": 1}
  } 

* PUT/ http://localhost:8080/enderecos/{id}: Atualiza os detalhes de um enderço existente.
  - body:
    {
  	"logradouro": "Rua da Paz",
	  "cep":"57160000",
  	"numero": "A2",
	  "cidade": "Marechal Deodoro",
  	"estado": "Alagoas",
	  "principal": true,
	  "pessoa": {"id": 1}
  }

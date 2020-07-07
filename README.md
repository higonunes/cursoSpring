#loja-backend

 Backend da aplicação de loja virtual desenvolvido no decorrer do curso de spring Boot e utilizando as tecnologias:

## Gerenciamento do projeto 

- Maven

## Server
- Java spring boot
- Postgresql

## Json Web Token

- Spring security
- Java JWT

## Tratamento de arquivos de imagens imagens

- Java Image Scaling Library
- Commons IO

## Armazenamento de arquivos Amazon S3

- Amazon Web Service java SDK

# Execução do projeto

Requisitos: Java 11 instalado no sistema;

- Git clone no projeto;
- Abrir com uma IDE java com suporte ao maven (modo fácil);
- ir no arquivo /loja-backend/src/main/resources/application.properties e mudar o spring.profiles.active = test e configurar as credenciais do envio de email e do AWS;
- Excutar o projeto e ele iniciará com o banco de dados H2 alocado em memória temporária;
- Caso necessitar presistir e dados instalar o postgres e configurar as credenciais em /loja-backend/src/main/resources/application-dev.properties e mudar o spring.profiles.active = dev;


# Modelo relacional do banco de dados
![diagrama](https://user-images.githubusercontent.com/30681418/86714787-ef3f0980-bff5-11ea-9cee-3ebe6f60df3e.png)


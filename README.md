# Agenda de Contatos CRUD para relatório de clientes, funcionários, entre outras funcionalidades

<img align="center" alt="Java" src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
 <img align="center" alt="MySql" src= "https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white"/>

<br/> <br/>

## Sobre o Projeto Agenda de Contatos
<br/>
Página de Realização do CRUD:

A Agenda/Diário de Contatos é uma aplicação Java Web desenvolvida como forma de estudos para a implementação de um sistema web que relata a quantidade de funcionários, clientes, entre outros tipos de contatos, armazenando seus IDs (códigos de reconhecimento), nome, telefone e e-mail.

É possível adicionar, editar, deletar e criar novos contatos. Cada ação realizada visita o banco de dados MySQL. 

![CRUD](https://raw.githubusercontent.com/joaogstex/Agenda-Contatos-CRUD/main/ImagensGit/Agenda.jpg)

<br/>


<br/>

Página Inicial: 

Página Inicial da Agenda de Contatos, onde o usuário é recebido de forma amigável por um simpático personagem.

![PaginaInicial](https://raw.githubusercontent.com/joaogstex/Agenda-Contatos-CRUD/main/ImagensGit/Agenda1.jpg)

<br/>
<br/>

Relatório PDF dos contatos: 

É também possível, por meio do botão "Relatório", gerar um arquivo PDF da lista de contatos atual. Caso um contato seja editado ou excluído, a lista também irá ser gerada de forma diferente por ser uma lista dinâmica com o uso de ArrayList.

![PDF](https://raw.githubusercontent.com/joaogstex/Agenda-Contatos-CRUD/main/ImagensGit/AgendaPdf.jpg)

<br/>
<br/>

Página de Criação de Novo Contato e Edição de Contato: 

A criação de um novo contato envolve a inserção do nome, telefone e e-mail do contato. Caso o telefone ou o nome não sejam inseridos nas caixas de texto uma alerta será emitido ao usuário por meio de códigos feitos por JavaScript que ele deve preencher os campos. Isso não é obrigatório para a inserção de e-mail. 

![CriarContato](https://raw.githubusercontent.com/joaogstex/Agenda-Contatos-CRUD/main/ImagensGit/CriarContato.jpg)

A edição de um contato no entanto funciona quase que de forma igual, a única diferença sendo a impossibilidade de mudança do IDcon do contato, que será imutável. O ID é também a forma de escolha do contato pelo banco de dados para que a edição de contatos possa ser possível.

![EditarContato](https://raw.githubusercontent.com/joaogstex/Agenda-Contatos-CRUD/main/ImagensGit/Editar.jpg)

<br/>


<br/>

## Aprendizado

Projeto de estudos no campo de Java Web realizado por meio das aulas do Professor José de Assis no curso de Java Web Level 1. Segue o link a seguir: (https://www.youtube.com/watch?v=dVRYwQc8uYc)

Suas aulas foram de extrema importância para a compreensão das funcionalidades, métodos e funções de Java Web. Foi de extrema importância também para compreensão do banco de dados MySQL. Foco principal nas ferramentas back-end.

A utilização do servidor Apache Tomcat foi de extrema importância para a funcionalidade do projeto.

## Tecnologias

### Backend
- Java
- MySql
- ItextPdf
- Tomcat

### FrontEnd
- Html
- CSS
- JS

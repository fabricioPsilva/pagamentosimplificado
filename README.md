<h1>
    <span> Pagamento Simplificado</span>
</h1>

Repositório desenvolvido para fins de **desafio**, com a finalidade de implementar uma **API Restful** com conceitos de um código limpo e organizado (design patterns, SOLID)

## 💻 Requisitos

Esse desafio contém os seguintes desafios:

- Para usuários, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, o sistema permite apenas um cadastro com o mesmo CPF ou endereço de e-mail.

- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

- Lojistas só recebem transferências, não realizam transferência.

- Validar se o usuário tem saldo antes da transferência.

- Antes de finalizar a transferência, consulta um serviço autorizador externo, utilizado (https://designer.mocky.io) para gerar um mocky para simulação.

- A operação de transferência é uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro volta para a carteira do usuário que envia.

- No recebimento de pagamento, o usuário ou lojista recebe notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. utilizado (https://designer.mocky.io) para gerar um mocky para simulação, porém retorna somente status 200.

- Este serviço é RESTFul.

## Tecnologias Utilizadas
<table>
  
  <tbody align="left">
    <tr>
      <td>Jpa Data</td>
      <td align="center">
        <a href="https://spring.io/projects/spring-data-jpa">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>
    <tr>
      <td>Spring Boot Starter Web</td>
      <td align="center">
        <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>
    <tr>
      <td>Spring Boot Devtools</td>
      <td align="center">
        <a href="https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/html/using-boot-devtools.html">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>
    <tr>
      <td>H2 database</td>
      <td align="center">
        <a href="https://www.h2database.com/html/main.html">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>
    <tr>
      <td>Lombok</td>
      <td align="center">
        <a href="https://projectlombok.org/contributing/">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>
    <tr>
      <td>Spring Initializr</td>
      <td align="center">
        <a href="https://start.spring.io/">
           <img align="center" alt="Tecnologia" src="https://img.shields.io/badge/Ver%20Documentação-30A3DC?style=for-the-badge">
        </a>
      </td>
    </tr>

    
  </tbody>
  <tfoot></tfoot>
</table>

## Referências
- [GIT. Documentation](https://git-scm.com/doc)
- [GITHUB. Documentation](https://docs.github.com/)
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [REST Tutorial](https://www.devmedia.com.br/rest-tutorial/28912)

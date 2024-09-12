<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Gerenciamento de Estoque</h1>
    <h2>Descrição</h2>
    <p>O projeto <strong>Gerenciamento de Estoque</strong> é uma aplicação simples desenvolvida para gerenciar produtos e vendas de uma Loja de Roupas. Com esta aplicação, é possível criar produtos, registrar vendas e manter o estoque atualizado. O projeto foi construído utilizando Java com Spring e PostgreSQL, como parte da disciplina de Engenharia de Software na faculdade.</p>
    <h2>Pré-requisitos</h2>
    <ul>
        <li><strong>Java 21</strong></li>
        <li><strong>PostgreSQL 8.2</strong></li>
    </ul>
    <h2>Como Clonar o Repositório e Rodar</h2>
    <ol>
        <li>Clone o repositório:
            <pre><code>git clone git@github.com:LeonardoAns/Gerenciamento-Estoque.git</code></pre>
        </li>
        <li>Navegue até o diretório do projeto:
            <pre><code>cd shopp</code></pre>
        </li>
        <li>Configure o banco de dados PostgreSQL e ajuste as configurações de conexão no arquivo <code>application.properties</code> ou <code>application.yml</code> localizado em <code>src/main/resources</code>.</li>
        <li>Compile e execute o projeto:
            <pre><code>./mvnw spring-boot:run</code></pre>
            ou
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <!-- Se houver comandos para rodar testes, adicione aqui -->
        <!-- <li>Para rodar os testes, use:</li>
        <li><pre><code>./mvnw test</code></pre></li> -->
    </ol>
    <h2>Estrutura de Pastas</h2>
    <pre><code>
src/
  ├── main/
  │   ├── java/
  │   │   ├── com/
  │   │   │   ├── estudoDeCaso/
  │   │   │   │   └── shopp/
  │   │   │   │       ├── controller/
  │   │   │   │       ├── dto/
  │   │   │   │       ├── entities/
  │   │   │   │       ├── exceptions/
  │   │   │   │       ├── infra/
  │   │   │   │       │   └── security/
  │   │   │   │       ├── repositories/
  │   │   │   │       ├── useCases/
  │   │   │   │       └── utils/
  │   └── resources/
  │       └── application.properties
  └── test/
      └── java/
          └── com/
              └── estudoDeCaso/
                  └── shopp/
                      ├── useCases/
                      └── utils/
    </code></pre>
    <h2>Status do Projeto</h2>
    <p>O projeto ainda está em desenvolvimento. As seguintes melhorias estão planejadas:</p>
    <ul>
        <li>Escrever mais testes para garantir a robustez do sistema.</li>
        <li>Desenvolver a documentação.</li>
        <li>Refatorar algumas partes do código para melhorar a qualidade e manutenção.</li>
    </ul>
</body>

</html>

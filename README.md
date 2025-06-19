<div align="center">
  <img src="https://img.shields.io/badge/linguagem-Java-orange.svg" alt="Linguagem Java">
  <img src="https://img.shields.io/badge/banco%20de%20dados-PostgreSQL-blue.svg" alt="Banco de Dados PostgreSQL">
  <img src="https://img.shields.io/badge/status-Em%20Desenvolvimento-yellow.svg" alt="Status Em Desenvolvimento">
</div>

<h1 align="center">
  Paid Guarantor 🛍️
</h1>

> Sistema de desktop para o gerenciamento de clientes e vendas "no fiado", permitindo um controle eficaz sobre pagamentos e devedores.

O **Paid Guarantor** é um sistema desenvolvido para pequenos e médios comerciantes que precisam de uma ferramenta simples e robusta para administrar as vendas realizadas a crédito, popularmente conhecidas como "fiado". Construído do zero em Java com uma interface gráfica Swing e utilizando PostgreSQL como banco de dados, o projeto aplica conceitos de Programação Orientada a Objetos para garantir um código organizado e manutenível.

---

## 📖 Índice

* [Sobre o Projeto](#-sobre-o-projeto)
* [✨ Funcionalidades](#-funcionalidades)
* [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
* [🚀 Como Rodar o Projeto](#-como-rodar-o-projeto)
* [📈 Melhorias Futuras](#-melhorias-futuras)
* [🤝 Contribuição](#-contribuição)

---

## 📖 Sobre o Projeto

Este sistema foi projetado para substituir anotações manuais em cadernos, oferecendo um controle digital e seguro das vendas a prazo. Com ele, o comerciante pode cadastrar seus clientes, registrar produtos, lançar vendas e, futuramente, acompanhar de perto quem já pagou e quem ainda está devendo.

A arquitetura do projeto segue o padrão **DAO (Data Access Object)** para separar as regras de negócio do acesso a dados, conectando-se a um banco de dados PostgreSQL local.

---

## ✨ Funcionalidades

* **Autenticação de Usuário:** Tela de login e cadastro para acesso ao sistema.
* **Gestão de Clientes:**
    * Cadastro, listagem, atualização e exclusão de clientes.
    * Ao excluir um cliente, o sistema utiliza uma `RULE` do PostgreSQL para renomeá-lo com o sufixo "Deleted", mantendo a integridade dos registros de pedidos antigos.
* **Gestão de Produtos:**
    * Cadastro, listagem, atualização e exclusão de produtos.
* **Gestão de Vendas:**
    * Registro de novos pedidos associados a um cliente.
    * Adição de produtos a um pedido.
    * Cálculo automático do valor total do pedido através de uma `TRIGGER` no banco de dados.
    * Listagem de todas as vendas realizadas, exibindo detalhes como cliente, produto e valor total.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Interface Gráfica:**
    * Java Swing
    * **MiGLayout:** Gerenciador de layout para interfaces mais flexíveis.
    * **JGoodies Forms:** Biblioteca auxiliar para criação de formulários.
* **Banco de Dados:**
    * PostgreSQL
* **Dependências:**
    * `postgresql-42.6.0.jar` (Driver JDBC)
    * `miglayout15-swing.jar`
    * `jgoodies-forms-1.8.0.jar`

---

## 🚀 Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o projeto em sua máquina.

### **Pré-requisitos**

* **Java JDK** instalado.
* **PostgreSQL** instalado e em execução.
* Uma **IDE Java** de sua preferência (Ex: VSCode, IntelliJ, Eclipse).

### **1. Configuração do Banco de Dados**

1.  Crie um novo banco de dados no PostgreSQL.
2.  Abra o arquivo `scriptDB/Creates.sql` e execute-o em seu banco de dados para criar o schema `fiado_pago` e todas as tabelas necessárias.
3.  Execute os scripts `scriptDB/Rules.sql` e `scriptDB/Triggers.sql` para adicionar as regras e gatilhos ao banco.

### **2. Configuração do Ambiente**

1.  Clone este repositório:
    ```sh
    git clone [https://github.com/guiibrag4/PaidGuarantor.git](https://github.com/guiibrag4/PaidGuarantor.git)
    ```
2.  Na raiz do projeto, crie um arquivo chamado `.env`. Este arquivo guardará suas credenciais de acesso ao banco de dados. Adicione as seguintes variáveis e preencha com suas informações:
    ```env
    DB_URL=jdbc:postgresql://localhost:5432/SEU_BANCO_DE_DADOS
    DB_USER=SEU_USUARIO
    DB_PASSWORD=SUA_SENHA
    ```
3.  **Configure as bibliotecas (.jar):** Adicione os arquivos `.jar` listados na seção de tecnologias ao classpath do seu projeto na sua IDE. Se estiver usando o VSCode, ele pode ler as configurações do arquivo `.vscode/settings.json` para facilitar esse processo.

### **3. Execução**

1.  Compile todo o código Java.
2.  Execute a classe principal: `src/Controller/MainProgramController.java`.
3.  A aplicação iniciará com uma tela de carregamento e, em seguida, a tela de login.

---

## 📈 Melhorias Futuras

Este projeto ainda está em desenvolvimento. As próximas funcionalidades e melhorias planejadas são:

* **Exclusão em Cascata:** Atualizar o sistema para que, ao excluir um dado (como um cliente), todos os registros que o referenciam sejam tratados ou excluídos em conjunto.
* **Busca por ID:** Ajustar e corrigir os métodos de busca por ID, que estão incorretos.
* **Botão de Sair:** Adicionar uma funcionalidade de logout ou sair do sistema.
* **Funcionalidades Principais:** Implementar as telas e lógicas de negócio para as seções "Pagos" e "Devedores", que são o coração do projeto.

---

## 🤝 Contribuição

Contribuições são bem-vindas! Se você tiver sugestões ou quiser melhorar o código, sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.

1.  Faça um *fork* do projeto.
2.  Crie uma nova *branch* (`git checkout -b feature/sua-feature`).
3.  Faça o *commit* de suas alterações (`git commit -m 'Adiciona nova feature'`).
4.  Faça o *push* para a *branch* (`git push origin feature/sua-feature`).
5.  Abra um *Pull Request*.
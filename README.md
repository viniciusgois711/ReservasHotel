# Sistema de Gerenciamento de Hotéis

##  Sobre o Projeto
O **Sistema de Gerenciamento de Hotéis** é uma aplicação desenvolvida em **Java** que permite gerenciar hóspedes, quartos e reservas de maneira eficiente. O sistema utiliza um **banco de dados relacional** para armazenar as informações e oferece funcionalidades como:

- Cadastro, edição, listagem e exclusão de hóspedes.
- Cadastro, edição, listagem e exclusão de quartos.
- Registro e controle de reservas.
- Atualização automática do status dos quartos.
- Geração de informações para notas fiscais.

##  Tecnologias Utilizadas
- **Java** (JDK 17 ou superior)
- **JDBC** para conexão com banco de dados
- **PostgreSQL** como banco de dados
- **Maven** para gerenciamento de dependências

##  Estrutura do Projeto
```
 src/main/java/org/hotel
 ├──  DB            # Classes responsáveis pelo acesso ao banco de dados
 ├──  Entidades     # Classes principais do sistema (Hospede, Quarto, Reserva, etc.)
 ├──  Filhas        # Classes específicas que herdam das entidades principais
 ├──  Main.java     # Classe principal para execução do sistema
```

##  Como Executar o Projeto

###  Pré-requisitos
Antes de iniciar, certifique-se de ter instalado:
- **JDK 17** ou superior
- **PostgreSQL**
- **Maven**

###  Configuração do Banco de Dados
1. Abra o **pgAdmin** e conecte-se ao PostgreSQL.
2. Crie um banco de dados chamado `hotel`.
3. No **pgAdmin**, crie as seguintes tabelas dentro do banco `hotel`:
   - **Tabela `hospedes`**:
     - `id` (Serial, Chave Primária)
     - `nome` (Varchar(100), Não Nulo)
     - `cpf` (Varchar(14), Único, Não Nulo)
     - `telefone` (Varchar(20))
   - **Tabela `quartos`**:
     - `id` (Serial, Chave Primária)
     - `numero` (Varchar(10), Não Nulo)
     - `valor` (Double Precision, Não Nulo)
     - `ocupado` (Varchar(10), Não Nulo)
   - **Tabela `reservas`**:
     - `id` (Serial, Chave Primária)
     - `id_hospede` (Int, Referência para `hospedes(id)`)
     - `id_quarto` (Int, Referência para `quartos(id)`)
     - `data_check_in` (Date, Não Nulo)
     - `data_check_out` (Date, Não Nulo)
4. Configure a conexão no arquivo `ConexaoDB.java`:
   ```java
   private static final String URL = "jdbc:postgresql://localhost:5432/hotel_db";
   private static final String USER = "seu_usuario";
   private static final String PASSWORD = "sua_senha";
   ```

###  Executando a Aplicação
1. Clone o repositório:
   ```bash
   git clone https://github.com/viniciusgois711/ReservasHotel.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd nome-do-repositorio
   ```
3. Compile e execute a aplicação

##  Funcionalidades
- **HospedeDB**: Gerencia hóspedes (inserção, listagem, edição e exclusão).
- **QuartoDB**: Gerencia quartos e altera status de ocupação.
- **ReservaDB**: Criação e gerenciamento de reservas.
- **NotaFiscalDB**: Obtém informações de hóspedes, quartos e reservas para emissão de notas fiscais.



---



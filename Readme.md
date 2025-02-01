### Gerenciador de Veículos
Este projeto é um sistema de gerenciamento de veículos composto por um frontend, um backend e um banco de dados MySQL. Ele pode ser facilmente executado usando Docker Compose.

### Pré-requisitos
Antes de começar, certifique-se de que você tem o seguinte instalado em sua máquina:

- Docker

- Docker Compose

### Como Executar o Projeto
Siga os passos abaixo para rodar a aplicação:

##### 1. Clone o Repositório
Primeiro, clone este repositório para o seu ambiente local:

```bash
git clone https://github.com/ericksresende/Gerenciador-de-Carros
cd Gerenciador-de-Carros
```
##### 2. Execute o Docker Compose
No diretório raiz do projeto, execute o seguinte comando para iniciar todos os serviços:

```bash
docker-compose up --build
```
##### 3. Acesse a Aplicação
Após o Docker Compose terminar de subir os serviços, você pode acessar a aplicação nos seguintes endereços:

Frontend: http://localhost:5000

Backend (API): http://localhost:8080
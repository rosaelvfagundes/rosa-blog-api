# 🌟 Rosa-Blog API

Uma API que executa funções de um blog. Com ela, você pode criar usuários, posts e categorias para os posts. Feita com tecnologias robustas e focada em funcionalidade e escalabilidade.

## 🥂 Agradecimentos

Este projeto só foi possível graças à oportunidade oferecida pelo bootcamp Decola Tech, resultado da parceria incrível entre a Digital Innovation One e a Avanade. Agradeço imensamente pela chance de aprender, praticar e desenvolver minhas habilidades em um ambiente tão estimulante e colaborativo.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java ☕
- **Framework:** Spring Boot 🌱, Spring Framework 🖥️
- **Persistência:** Spring Data JPA 💾, Hibernate 🗄️
- **Banco de Dados:** PostgreSQL 🐘

## 🏗️ Arquitetura da Aplicação

O projeto segue uma arquitetura de três camadas, promovendo a separação de responsabilidades para um código mais organizado e sustentável:

1. **Camada Controller**: 🚪 Responsável por receber as requisições HTTP, processar os dados recebidos e devolver as respostas apropriadas.
2. **Camada Service**: 📖 Contém a lógica de negócios da aplicação, garantindo que as operações ocorram de acordo com as especificações.
3. **Camada de Persistência**:
   - **Entity**: 🏷️ Representa as tabelas do banco de dados em formato de classes Java.
   - **Repository**: 🗃️ Contém a interface para manipulação dos dados no banco, utilizando o Spring Data JPA.

## 🔗 Rotas da API

### 👤 Usuários
- **Criar Usuário:** `POST /users` - Permite criar novos usuários.
- **Buscar Usuários:** `GET /users` - Retorna todos os usuários cadastrados.
- **Buscar Usuário por ID:** `GET /users/{id}` - Retorna os detalhes de um usuário específico.

### 📝 Posts
- **Criar Post:** `POST /post` - Permite criar novos posts.
- **Buscar Posts:** `GET /post` - Retorna todos os posts cadastrados.
- **Buscar Post por ID:** `GET /post/{id}` - Retorna os detalhes de um post específico.

### 🗂️ Categorias
- **Criar Categoria:** `POST /category` - Permite criar novas categorias.
- **Buscar Categorias:** `GET /category` - Retorna todas as categorias cadastradas.
- **Buscar Categoria por ID:** `GET /category/{id}` - Retorna os detalhes de uma categoria específica.

## ✨ Funcionalidades

- **Gerenciamento de Usuários:**
  - Criar usuário (`POST /users`) 👤
  - Buscar usuários (`GET /users`) 📋
  - Buscar usuário por ID (`GET /users/{id}`) 🔍
- **Gerenciamento de Posts:**
  - Criar post (`POST /post`) 📝
  - Buscar posts (`GET /post`) 📋
  - Buscar post por ID (`GET /post/{id}`) 🔍
- **Gerenciamento de Categorias:**
  - Criar categoria (`POST /category`) 🗂️
  - Buscar categorias (`GET /category`) 📋
  - Buscar categoria por ID (`GET /category/{id}`) 🔍

## 💻 Requisitos para Acessar o Projeto

Certifique-se de ter o seguinte instalado em sua máquina antes de começar:
- **Java 17+** ☕
- **Maven** para gerenciamento de dependências 🛠️
- **PostgreSQL** para o banco de dados 🐘
- Uma IDE como IntelliJ ou Eclipse (opcional, mas recomendado) 💡




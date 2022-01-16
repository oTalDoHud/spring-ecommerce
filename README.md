# Backend E-Commerce
![GitHub](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)

# Sobre o projeto

https://spring-generico-um.herokuapp.com

Spring-ecommerce é uma aplicação web backend, que simula um e-commerce com diversos clientes, produtos e pedidos.

A aplicação consiste em diversas requisições web que inserem clientes, pedidos e produtos. Vou demonstrar as requisições em seguida.

## Padrão MVC (Controllers, Services and repositories)

![MVC](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/MVC/mvc.png)

Modelo de arquitetura onde as funções e privilégios ficam divididos entre Rest Controller (Recebe requisições e envia respostas), Services (Realiza toda a lógica do negócio) e Repositories (Realiza todo tipo de acesso ao banco de dados).

## Modelo conceitual - UML
### Camadas
<br/>

![uml](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/modelo_conceitual/conceito_1.png)

### Objetos
<br/>

![uml](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/modelo_conceitual/conceito_2.png)

## Requisições - CRUD
Todas as requisições foram feitas pelo [Postman](https://web.postman.co "Site Postman"):
<br/>

### Create

![crud](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/Requisicoes/Create.png)

- 201 - Created

### Read

![crud](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/Requisicoes/Read.png)

- 200 - ok

### Update

![crud](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/Requisicoes/Update.png)

- 200 - ok

### Delete

![crud](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/Requisicoes/Delete.png)

- 200 - ok

#### Check: usuário foi realmente deletado.

![crud](https://github.com/oTalDoHud/spring-ecommerce/blob/main/assets/Requisicoes/DeleteCheck.png)

- 404 - not found
<br/>
Isso nós confirma que o cliente foi realmente excluído.

## Pedidos Json

### Seguindo o modelo conceitual, o pedido (order) contem os produtos pedidos, seu subvalor e o seu valor total:
```bash
{
    "id": 1,
    "moment": "2019-06-20T19:53:07Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "Hudson",
        "email": "Hudson@gmail.com",
        "phone": "11 932165604",
        "password": "1234"
    },
    "items": [
        {
            "quantity": 2,
            "price": 90.5,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Books"
                    }
                ]
            },
            "subTotal": 181.0
        },
        {
            "quantity": 1,
            "price": 1250.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Computers"
                    }
                ]
            },
            "subTotal": 1250.0
        }
    ],
    "payment": {
        "id": 1,
        "moment": "2019-06-20T22:53:07Z"
    },
    "total": 1431.0
}
```

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Rest
- H2 database
- Maven

## Implantação em produção
- Servidor: Heroku
- Banco de dados: Postgresql
- Git/Github

# Como testar projeto

## As requisições podem ser testadas no [Postman](https://web.postman.co "Site Postman") , utilizando as seguintes URL's:

#### https://spring-generico-um.herokuapp.com/user/id/2

#### https://spring-generico-um.herokuapp.com/user/all

# Autor

Hudson Lucas Teles Vieira

www.linkedin.com/in/otaldohud

hudson.lucas.vieira@gmail.com

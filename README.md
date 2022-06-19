
<h1 align="center"> Spring boot API Matrix flip</h1>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=v1.0.0%20FINALIZADO&color=GREEN&style=for-the-badge"/>
</p>

## Tabela de conteúdos 

* [Descrição](#----descrição)
* [:hammer: Funcionalidades do projeto](#hammer-funcionalidades-do-projeto)
* [ 🛠️ Rodando o projeto](#%EF%B8%8F-rodando-o-projeto)
* [☔ Testes](#-testes)
* [✔️ Tecnologias utilizadas](#%EF%B8%8F-tecnologias-utilizadas)

<h4 align="center"> 
   Descrição
</h4>
<p>  O projeto tem como objetivo a prática do desenvolvimento com Spring Boot, para criação de APIs Rest, e com Junit, para testes unitários. O que o projeto tem a ideia de receber uma lista ou array (depende do contexto), e então transformá-lo em uma matriz quadrática e após isso, rotacioná-la da esquerda para a direita como o exemplo a seguir.</p>
<img align="center" src='https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d39b794f-491c-4a0d-92b5-3b75df80c266/rotacao.gif?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220619%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220619T090308Z&X-Amz-Expires=86400&X-Amz-Signature=f3e7ff0b714f13caa285f341b906b5c17be6ebf03227ca96cdfc43417af7ae75&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D"rotacao.gif"&x-id=GetObject'/>

## :hammer: Funcionalidades do projeto
<p>O projeto pode ser rodado em qualquer máquina com o maven e o java 11 instalados, assim as referências a url se referem a url do usuário que está rodando o projeto.
O projeto possui um Swagger embarcado para a realização de teste, acessível em: url/swagger-ui.html
</p>

- `Funcionalidade 1`: [POST] url/flipMatrix

  - Request:
    ```
    {
      "array": [
        0
      ]
    }
    ```
  - Response:
  
    - 201:
      ```
      {
        "matrixFliped": [
          [
            0
          ]
        ],
        "matrixOriginal": [
          [
            0
          ]
        ]
      }
      ```
    - 400:
      ```
        {
        "matrix": [
          0
        ],
        "mensagem": "string"
      }
      ```
     - 500:
        ```
        NO BODY
        ```

## 🛠️ Rodando o projeto

Partindo do pressuposto que o java e o maven já encontram se instalados, além disso a porta 8080 não pode estar em uso,
para rodar o projeto é necessário baixa-lo,
```
git clone https://github.com/tiagoj61/SpringMatriz.git
``` 
navegar até a pasta do projeto e rodar o seguinte comando:
```
mvn spring-boot:run
```
assim será possível utilizar as funcionalidades descritas acima.

Ainda é possível rodar o projeto fazendo o download do zip e rodando através do comando:
```
mvnw spring-boot:run
```

## ☔ Testes

Os teste do sistema são executados através do comando ‘mvn clean install’ e a resposta é exibida no console.

O sistema abrange uma gama de testes unitários tão grande quanto possível desde valores null até matrizes de tamanhos 100x100, porém sempre é possível que existam teste não mapeados, no package de testes é possível encontrar os teste que abrangem o package de service, facada e controller, que são os principais pacotes de funcionalidades da aplicação.

Assim foram mapeado de forma geral duas exceptions para os cenários fora do esperado no sistema, são eles:

  NonQuadraticMatrixException.java

    → Para cenários onde a matriz existe mais não quadrática, logo não é possível realizar a rotação nela.

  MatrixBadRequestException.java
  
    → Para cenários onde o objeto não atende ao requisito de ser um array

Além disso para realização dos testes foi criado uma classe auxiliar, MatrixHelper.java, para realizar a criação de matrizes e arrays de forma automática e dinâmica, sendo necessário apenas informar o tamanho, também foram criados métodos para exibição da matriz no console de teste, porém não recomendado, foi utilizado apenas para confirmação visual mas removido dos testes.


## ✔️ Tecnologias utilizadas

- ``Maven 3.8.6``
- ``Java 11``
- ``Spring Boot``
- ``Junit``
- ``Spring Fox``

# 🏆 Ranking-Vendas-Web

Projeto desenvolvido para transformar uma planilha Excel utilizada diariamente em uma ferramenta web acessível e atualizada automaticamente.

## 📌 Contexto

Durante a rotina de trabalho, os rankings de vendas eram acompanhados através de planilhas Excel. O objetivo deste projeto foi automatizar esse processo e disponibilizar as informações de forma visual para os usuários.

O projeto começou como uma aplicação Java local utilizando JSP, Servlets e Apache Tomcat para leitura das planilhas Excel.

Com a necessidade de disponibilizar o sistema pela internet, a arquitetura foi evoluindo para uma solução baseada em Firebase, HTML, CSS, JavaScript e VBA.

## 🚀 Funcionalidades

* Exibição do ranking de vendas.
* Consulta por mês.
* Atualização automática dos dados.
* Destaque visual para os três primeiros colocados.
* Integração entre Excel e Firebase.
* Interface responsiva.

## 🛠️ Tecnologias utilizadas

### Versão local

* Java
* JSP
* Servlets
* Apache POI
* Apache Tomcat

### Versão online

* HTML
* CSS
* JavaScript
* Firebase Realtime Database
* Excel VBA

## 🏗️ Arquitetura atual

```text
Excel (.xlsm)
↓
VBA
↓
Firebase Realtime Database
↓
HTML/CSS/JavaScript
↓
Aplicação Web
```


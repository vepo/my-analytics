# MyAnalytics

Criar uma serviço RESTful que faz a coleta de dados de uma aplicação web.

## O que define um REST

* API HTTP uniform
* Stateless
* Orietanda a Recurso

## Requisitos

- [ ] Deve capturar tempo de visualização do usuário em uma página web

Navegação?
Visualização?
Pagina?
Estatisticas 

* Um usuário vai acessar uma página web
* Essa página web vai coletar estatísticas e enviar para o servidor

```bash
docker run --name my-analytics-mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=passwd -d mongo:7
```

## Desing

* Vou ter uma código front-end enviando mensagens para minha API
* A API deve fornecer estatisticas de visualização da página
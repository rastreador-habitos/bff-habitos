# bff-habitos

Backend for Frontend do sistema Rastreador de Habitos. Funciona como ponto de entrada unico para o frontend, roteando requisicoes aos microsservicos `usuario` e `habitos` por meio de clientes OpenFeign.

## Stack

- Java 21
- Spring Boot
- OpenFeign
- Gradle

## Responsabilidades

- Expoe uma API unificada ao frontend na porta 8082.
- Roteia operacoes de usuario para o servico `usuario`.
- Roteia operacoes de habito para o servico `habitos`.
- Repassa tokens JWT aos servicos downstream nas rotas autenticadas.

## API

Espelha a API combinada de `usuario` e `habitos`. Consulte a documentacao de cada servico para a especificacao completa dos endpoints.

| Servico | Prefixo roteado |
|---------|----------------|
| usuario | /usuario |
| habitos | /habitos |

## Configuracao

```properties
usuario.url=http://localhost:8080/usuario
habitos.url=http://localhost:8081/habitos
```

Em ambiente Docker, esses valores sao injetados como variaveis de ambiente, substituindo `localhost` pelos nomes dos servicos definidos no `docker-compose.yml`.

## Executando localmente

Requer `usuario` rodando na porta 8080 e `habitos` na porta 8081.

```bash
./gradlew bootRun
```

Servico sobe na porta **8082**.

## Executando com Docker

Este servico faz parte de um ambiente multi-container. Consulte o repositorio principal da organizacao [rastreador-habitos](https://github.com/rastreador-habitos) para o `docker-compose.yml` completo.

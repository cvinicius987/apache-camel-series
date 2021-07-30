## Apache Camel com Apache Kafka

#### Criação do Kafka Broker

```sh
docker-compose up -d
```

Devemos realizar a seguinte configuração no arquivo:

```sh
sudo vi /etc/hosts
```

Adiciona logo abaixo do localhost a seguinte linha:
```sh
127.0.0.1    <server>
```

#### Executando a Aplicação

```sh
mvn spring-boot:run
```

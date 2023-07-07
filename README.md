# VENDA_SMS 

 VENDA_SMS é uma API REST que recebe dados de vendas e vendedores, realiza o cálculo do total da venda e envia torpedos (SMS) personalizados para os vendedores.
 
# Principais recursos: 

- Recebe dados de venda e vendedor através de requisições HTTP. 
- Calcula o total da venda com base nos itens e preços fornecidos. 
- Envia mensagens SMS personalizadas para os vendedores com informações sobre a venda e metas a serem alcançadas. 
- Sistema de tratamento de erros para melhorar a experiência do usuário. 
- Testes automatizados para garantir a qualidade do código e a funcionalidade da API. 

# Tecnologias utilizadas:

- Java 11
- Spring Boot
- Swagger
- Banco de dados: MySQL
- Docker

# Executar com banco e container separados:
#### 1 – Inicie o contêiner MySQL:
`docker run --name containerMysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_DATABASE=vendadb -p 3307:3306 -d mysql`
####  2 – Crie uma rede para unir a aplicação ao banco de dados:
`docker network create apivenda-network`
####  3 - Conecte o containerMysql à rede:
`docker network connect apivenda-network containerMysql`
#### 4 – Crie um novo contêiner para aplicação usando a imagem devjuliana/apivenda, conecte à rede, define as configurações de conexão com bd Mysql e especifique a porta 9090:
`docker run -p 9090:8080 --name app --net apivenda-network -e MYSQL_HOST=containerMysql -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 devjuliana/apivenda`
#### Pronto, a aplicação será iniciada!
#### URL da aplicação: http://localhost:9090/swagger-ui.html

<br/>

# Executar com docker compose: 
`docker-compose up`
#### URL da aplicação: http://localhost:8080/swagger-ui.html
OBS: Este projeto depende de algumas variáveis de ambiente para sua correta execução. Essas variáveis são necessárias tanto para a integração com a plataforma Twilio, onde serão utilizadas 
para autenticação e configuração dos serviços de envio de mensagens quanto para a configuração do banco de dados. Veja a documentação presente no projeto.
<br/>

## Torpedo:
![Torpedojpg](https://github.com/JuhLima85/ApiEnvioSms/assets/89745459/24a8ca33-a2da-47c4-af0f-260209a903e7)

## Response Body:
![imagei](https://github.com/JuhLima85/ApiEnvioSms/assets/89745459/d10bc89c-6b92-4a55-b805-92ac0b1a1180)

## Teste automatizado
![Teste automatizado](https://github.com/JuhLima85/VENDA_SMS/assets/89745459/dad69ac3-77c5-406b-93d5-1bb29dde1156)
<br/>

#### 
# Autora
Juliana Lima

[![Linkedin](https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://contate.me/Juliana-Lima)


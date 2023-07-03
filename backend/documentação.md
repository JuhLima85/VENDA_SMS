#Configuração das Variáveis de Ambiente para o Projeto


Este projeto requer a configuração de variáveis de ambiente para seu correto funcionamento. Essas variáveis são necessárias para a integração com a plataforma Twilio, sendo utilizadas para autenticação e configuração dos serviços de envio de mensagens, bem como para a configuração do banco de dados. 

###Arquivo de Propriedades para Testes
Para manter a segurança das informações pessoais e evitar o compartilhamento de dados sensíveis no repositório Git, foi criado um arquivo de propriedades específico para os testes, chamado `test.properties`. Esse arquivo contém as chaves das variáveis de ambiente necessárias para os testes, porém, não é adicionado ao controle de versão por meio do arquivo `.gitignore`.

Certifique-se de criar um arquivo `test.properties` em sua máquina local, na raiz do projeto, e preencha-o com os valores corretos das variáveis de ambiente mencionadas acima. É importante que você crie sua própria conta na Twilio e obtenha as informações necessárias para preencher essas variáveis.


###Configuração das Variáveis de Ambiente para a Aplicação
Além disso, para que a aplicação seja executada corretamente, é necessário configurar as mesmas variáveis de ambiente no ambiente em que a aplicação será executada. Isso pode ser feito definindo as variáveis de ambiente no sistema operacional, no servidor de aplicação ou usando ferramentas específicas para gerenciamento de variáveis de ambiente.

Certifique-se de adicionar as variáveis de ambiente mencionadas acima no ambiente de execução da aplicação, preenchendo-as com os valores apropriados obtidos da sua conta Twilio.

Após configurar corretamente o arquivo `test.properties` com as variáveis de ambiente necessárias e adicionar as mesmas variáveis de ambiente no ambiente de execução da aplicação, você estará pronto para executar e testar o projeto, garantindo que as integrações com a Twilio ocorram corretamente.

###Arquivo .env

Para proteger os dados sensíveis e evitar o compartilhamento acidental de informações sigilosas, é recomendado o uso de um .env. Esse arquivo contém as variáveis de ambiente mencionadas abaixo, com seus respectivos valores. Ele não é adicionado ao controle de versão por meio do arquivo .gitignore.

Certifique-se de criar um arquivo `.env` em seu ambiente local, no mesmo diretório do seu arquivo docker-compose.yml, e preencha-o com as variáveis de ambiente necessárias, seguindo o exemplo abaixo:

- `MYSQL_HOST: O host do banco de dados. `

- `MYSQL_USER: O nome de usuário para acessar o banco de dados. `

- `MYSQL_PASSWORD: A senha do usuário do banco de dados. `

- `MYSQL_PORT: A porta em que o banco de dados está sendo executado. `

<br>

- `twilio.sid: SID da sua conta Twilio.`
- `twilio.key: Chave secreta (API Key) da sua conta Twilio.`
- `twilio.phone.from: Número fornecido pela Twilio para ser utilizado como remetente das mensagens.`
- `twilio.phone.to: Seu número de telefone autenticado pela Twilio.`




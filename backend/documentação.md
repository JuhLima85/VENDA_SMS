#Configuração das Variáveis de Ambiente para o Projeto

Este projeto depende de algumas variáveis de ambiente para sua correta execução. Essas variáveis são necessárias para a integração com a plataforma Twilio, e são utilizadas para autenticação e configuração dos serviços de envio de mensagens.

Abaixo estão listadas as variáveis de ambiente necessárias e seus respectivos valores:

1. `TWILIO_SID`: SID da conta Twilio. Para obter esse valor, é necessário ter uma conta na Twilio e criar um projeto. O SID pode ser encontrado no painel de controle da sua conta Twilio, na seção de projetos.

2. `TWILIO_KEY`: Chave secreta (API Key) da conta Twilio. Essa chave também pode ser encontrada no painel de controle da sua conta Twilio, na seção de projetos. É importante manter essa chave em sigilo, pois ela permite acesso à sua conta e serviços da Twilio.

3. `TWILIO_PHONE_FROM`: Número de telefone fornecido pela Twilio. Esse número será utilizado como remetente das mensagens enviadas pelo projeto.

4. `TWILIO_PHONE_TO`: Seu número de telefone, ele será o número para o qual as mensagens serão enviadas durante a execução do projeto.

#Arquivo de Propriedades para Testes
Para manter a segurança das informações pessoais e evitar o compartilhamento de dados sensíveis no repositório Git, foi criado um arquivo de propriedades específico para os testes, chamado `test.properties`. Esse arquivo contém as chaves das variáveis de ambiente necessárias para os testes, porém, não é adicionado ao controle de versão por meio do arquivo `.gitignore`.

Certifique-se de criar um arquivo `test.properties` em sua máquina local, na raiz do projeto, e preencha-o com os valores corretos das variáveis de ambiente mencionadas acima. É importante que você crie sua própria conta na Twilio e obtenha as informações necessárias para preencher essas variáveis.


#Configuração das Variáveis de Ambiente para a Aplicação
Além disso, para que a aplicação seja executada corretamente, é necessário configurar as mesmas variáveis de ambiente no ambiente em que a aplicação será executada. Isso pode ser feito definindo as variáveis de ambiente no sistema operacional, no servidor de aplicação ou usando ferramentas específicas para gerenciamento de variáveis de ambiente.

Certifique-se de adicionar as variáveis de ambiente mencionadas acima no ambiente de execução da aplicação, preenchendo-as com os valores apropriados obtidos da sua conta Twilio.

Após configurar corretamente o arquivo `test.properties` com as variáveis de ambiente necessárias e adicionar as mesmas variáveis de ambiente no ambiente de execução da aplicação, você estará pronto para executar e testar o projeto, garantindo que as integrações com a Twilio ocorram corretamente.

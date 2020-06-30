# Devops

> Programa de teste desenvolvido com JAVA, Maven, Junit e Selenium.

## Passos seguidos:

* [Objetivo](#Objetivo)
* [Infraestrutura](#Infraestrutura)
* [Desenvolvimento](#Desenvolvimento)
* [Testes](#Testes)
* [Homologação](#Homologação)
* [Imagens](#Imagens)
* [Observações](#Observações)
* [Contato](#Contato)
* [Automatização](#Automatização)


## Objetivo

  O aplicativo efetua um acesso a um serevidor NGNINX que está rodando em uma instância do minishift através do site [appsdevops.tk](http://appsdevops.tk) e efetua a leitura de arquivo JSON estático, com a identificação do UPtime do serviço. Se estiver fora do ar, envia um alerta via email, que está pré-configurado de forma estática na classe Config.java.

## Infraestrutura

  Básicamente o programa foi desenvolvido em cima de um Acer Aspiron de quase 10 anos de uso, com o Sistema operacional LUBUNTU 18.04 e com 4GB de RAM + Processador i3. O Java utilizado é 1.8.0_252 com o Maven 3.6.0.
A IDE é o IntelliJ 2019.3 com as dependencias do Junit 4.12 + Selenium 3.141 + Selenium Chrome drive 3.141.

## Desenvolvimento

  O arquivo base foi criado através do plugin [Selenium do Firefox](https://addons.mozilla.org/pt-BR/firefox/addon/selenium-ide/), onde extportei o arquivo java para um novo projeto maven no IntelliJ.
Através do driver do [selenium Chrome](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver), consegui acessar o frame correto no HTML e fazer um get no elemento do texto do JSON. Com o elemento em mãos, quebrei em um array e fiz um for each para analisar e pegar o servidor de banco de dados em down.
Depois disso, com a importação das bibliotecas nativas do [JAVA para email (javax.mail)](https://javaee.github.io/javamail/), criei duas classes de email e passei as configurações estáticas em um email de teste, onde após verificação do serviço em down, um email é disparado como alerta.


## Testes

  Os testes foram feitos em forma de debbuger, pois houve dificuldade em encontrar o elemento inicialmente, pois estava em um frame diferente do HTML inicial. Ao testar o envio do email, foi preciso efetuar liberação as configurações de envio do gmail para aplicativos externos. A partir disso, com os testes prontos, foi necessário gera um executavel .jar com um build direto pelas configurações do IntelliJ.

## Homologação

  Ao efetuar a exportação do executável, foi preciso modificar o código no sentido de colcoar as configurações do email estáticamente na classe, pois não estava rodando fora da IDE. Com isso pronto, consegui exportar e reproduzir o teste diretamente pelo terminal atravavés do comando:
  `java -jar (arquivo.jar)`
  
## Imagens

![thiago](https://user-images.githubusercontent.com/53309633/86184050-b8ef1f00-bb09-11ea-990c-add91ed02cc0.png)
![executavel2](https://user-images.githubusercontent.com/53309633/85975483-8da3ed00-b9ae-11ea-9e76-78793db153db.png)
![codigo](https://user-images.githubusercontent.com/53309633/85975491-9694be80-b9ae-11ea-817b-f94a9be7b58d.png)
![build inicial](https://user-images.githubusercontent.com/53309633/85975492-9c8a9f80-b9ae-11ea-819a-f82e725c4499.png)
![export](https://user-images.githubusercontent.com/53309633/85975500-a3191700-b9ae-11ea-8531-5ff048dd7e86.png)
![export2](https://user-images.githubusercontent.com/53309633/85975506-a90ef800-b9ae-11ea-90f0-fd551bc9d407.png)
![build final](https://user-images.githubusercontent.com/53309633/85975513-add3ac00-b9ae-11ea-8d10-07df49673c10.png)
  
## Observações

  - Para testes em seu localhost, é necessário modificar o arquivo config.properties com dados de login de email e destinatario.
  - O aplicativo é relativamente simples. O foco é mostrar desde a ideia inicial, com a infraestrutura necessária até o executavel final. 
  

# Automatização

> Podemos automatizar o programa para que seja executado no tempo que for necessário e onde estiver. Basta configurarmos o arquivo config.properties conforme orientado acima e extrairmos o executavel via IDE pelo maven.

### CRON do Linux

- Utilizo o agendador de tarfeas CRON do linux.
- Com o comando`crontab -e` é aberto um editor para que seja configurado a tarefa que será executada periodicamente, conforme necessidade.

```
*/5 * * * * /home/thiago/alerta.sh
```

![crontab](https://user-images.githubusercontent.com/53309633/86081486-e38a9a80-ba6b-11ea-918e-77fb147cc6e1.png)

 Este comando ativa o agendador para execução do script .sh em BASH a cada 5 minutos.
 
 - O Script em BASH contém a seguinte configuração:
 ```
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -jar ~/home/thiago/teste-json-email/out/artifacts/selenium_json_email_jar/selenium-json-email.jar > /home/thiago/teste.txt

 ```
  ![bash](https://user-images.githubusercontent.com/53309633/86081483-e2596d80-ba6b-11ea-9119-35cc1fdd763a.png)
 
 O arquivo .jar que foi gerado pelo programa, está na pasta correta e pronto para ser chamado pelo comando java -jar.
 
 - Para monitoramento básico do processo automático, é gerado um arquivo teste.txt na home.

 
## Contatos

[GitHub - @thiago7azevedo](https://github.com/thiago7azevedo) - [Docker HUB - thiago7sc](https://hub.docker.com/u/thiago7sc) - [Email @thiago7azevedo@gmail.com](www.gmail.com)

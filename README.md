# gerenciamento-usuario

Para rodar o projeto:
  Precisa do Postgresql instalado na máquina.
    aplication.properties está configurado assim:
    
      database : gerenciamento
      url : http://localhost:5432
      password : postgres
      user : postgres
  
  Para gerar o build , pode ser feito pelas IDE(s) : intellij e Netbeans
    Intellij : Ao baixar o projeto pelo git clone , vai aparecer a opção do lado esquerdo do gradle, onde vai ter a opção build, apenas dois cliques em build que gera o projeto.
    NetBeans : Clica na opção limpar e contruir.
    
  Com o build feito , vai aparecer na pasta build/libs o jar do projeto, executando o comando "java -jar nome do projeto.jar" aplicação vai está no ar.
  
  Não foi feito o front, apenas o back, mas consegue testar pelo curl ou postman
  
  links de exemplo: http://localhost:8080/api/usuario, métodos : Get, Post, Put e Delete

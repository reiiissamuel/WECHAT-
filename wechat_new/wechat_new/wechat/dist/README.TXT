========================
DESCRI��O DE SA�DA DA CONSTRU��O
========================

Quando voc� cria um projeto de aplicativo Java que tem uma classe principal, o IDE
copia automaticamente todos os JAR
arquivos no caminho de classe do projeto para sua pasta dist / lib de projetos. O IDE
tamb�m adiciona cada um dos arquivos JAR ao elemento Class-Path no aplicativo
Arquivo de manifesto de arquivos JAR (MANIFEST.MF).

Para executar o projeto a partir da linha de comando, v� para a pasta dist e
escreva o seguinte:

java -jar "wechat.jar"

T

Notas:

* Se dois arquivos JAR no caminho de classe do projeto tiverem o mesmo nome, somente o primeiro
O arquivo JAR � copiado para a pasta lib.
* Somente arquivos JAR s�o copiados para a pasta lib.
Se o classpath contiver outros tipos de arquivos ou pastas, esses arquivos (pastas)
n�o s�o copiados.
* Se uma biblioteca no caminho de classe do projeto tamb�m tiver um elemento Class-Path
especificado no manifesto, o conte�do do elemento Class-Path deve estar ativado
o caminho de execu��o dos projetos.
* Para definir uma classe principal em um projeto Java padr�o, clique com o bot�o direito do mouse no n� do projeto
na janela Projetos e escolha Propriedades. Em seguida, clique em Executar e digite o
nome da classe no campo Classe Principal. Como alternativa, voc� pode digitar manualmente
nome da classe no elemento manifest Main-Class.
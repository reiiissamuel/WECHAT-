========================
DESCRIÇÃO DE SAÍDA DA CONSTRUÇÃO
========================

Quando você cria um projeto de aplicativo Java que tem uma classe principal, o IDE
copia automaticamente todos os JAR
arquivos no caminho de classe do projeto para sua pasta dist / lib de projetos. O IDE
também adiciona cada um dos arquivos JAR ao elemento Class-Path no aplicativo
Arquivo de manifesto de arquivos JAR (MANIFEST.MF).

Para executar o projeto a partir da linha de comando, vá para a pasta dist e
escreva o seguinte:

java -jar "wechat.jar"

T

Notas:

* Se dois arquivos JAR no caminho de classe do projeto tiverem o mesmo nome, somente o primeiro
O arquivo JAR é copiado para a pasta lib.
* Somente arquivos JAR são copiados para a pasta lib.
Se o classpath contiver outros tipos de arquivos ou pastas, esses arquivos (pastas)
não são copiados.
* Se uma biblioteca no caminho de classe do projeto também tiver um elemento Class-Path
especificado no manifesto, o conteúdo do elemento Class-Path deve estar ativado
o caminho de execução dos projetos.
* Para definir uma classe principal em um projeto Java padrão, clique com o botão direito do mouse no nó do projeto
na janela Projetos e escolha Propriedades. Em seguida, clique em Executar e digite o
nome da classe no campo Classe Principal. Como alternativa, você pode digitar manualmente
nome da classe no elemento manifest Main-Class.
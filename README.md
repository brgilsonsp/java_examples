# Java
Java é uma tecnologia para desenvolvimento e execução de soluções de software.
<br/>
Java suporte várias arquiteturas como: servidores, PC, celular, IoT, entre outros.
<br/>
A tecnologia Java é composta por:
* [Linguagem de progrmação](#11-linguagem-de-programação-java)
* [Ferramentas Java](#12-ferramentas)
* [Bibliotecas para desenvolvimento](#13-bibliotecas-para-desenvolvimento)
* [Máquina virtual](#14-máquina-virtual)

Com as peças de partes desta composição, Java foi dividido em ambientes:
* [JRE: Java Runtime Environment](#21-jre)
* [JDK: Java Development Kit](#22-jdk)

Devido a amplitude das bibliotecas, A plataformava Java foi sub-dividida em alguns projetos:
* Java Standard Edition: Plataforma base com as bibliotecas comuns e o ambiente de execução padrão em servidores e PCs
* Java Enterprise Edition: Tudo o JSE oferece mais as bibliotecas voltada para aplicações corporativas. Atualmente utilizamos as bibliotecas do [Jakarta EE](https://jakarta.ee/)
* Java Micro Edition: Plataforma base com as bibliotecas comuns e o ambiente de execução para pequenos dispotivos, por exemplo, TV, IoT e etc.

Uma solução Java, basicamente, possui 5 cenários:
1. O codigo fonte é criado, com as instruções implementadas, em um arquivo ```.java```. Esse arquivo deve ser armazenado em disco
1. O *compilador* cria os **bytecodes**, a partir do codigo fonte, e armazena os **bytecodes** em arquivo ```.class```. Esses arquivos também são armazenados em discos
1. **JVM** carrega os **bytecodes** para a memória, a partir dos arquivos ```.class```
1. **JVM** valida o **bytecodes**, verificando se são válidos e se não violam a segurança do Java
1. Interpreta o bytecode para linguagem nativa, onde a máquina poderá executar as intruções implementadas no seu arquivo ```.java```. A medida que a **JVM** executa o bytecode, é utilizado uma combinação de *interpretação* e a chamada a **compilação JIT (just-in-time)**. Nesse caso o **JIT** compila o **bytecode** para a linguagem nativa e deixando-os disponíveis no **hot spot (pontos ativos)**, assim quando a **JVM** encontra novamente esses **bytecodes** já compilados para a linguagem nativa, a execução é mais rápida.

![](./static/stater-java-compiler.gif "Overview processo desenvolvimento Java")*Overview processo desenvolvimento Java*

## 1. Tecnologias Java
Java é um ecossitema que fornece uma variedade de tecnologias. Iremos abordar algumas destas tecnologias

### 1.1. Linguagem de programação Java
Java é uma linha de alto nível, derivado do C/C++, onde são escritos, em linguagem humana, as instruções do nosso programa que devem ser executadas pela máquina.
<br/>
O código em Java é escrito em texto puro, em arquivos com extensão ```.java``` utilizando qualquer editor de texto. 
<br/>
Os arquivos ```.java``` devem ser armazenados em disco.

### 1.2. Ferramentas
A plataforma fornece ferramentas para desenvolver, executar e analisar as soluções Java. Dentre as ferramentas temos:
* compilar o código
* depurar o código
* executar o binário
* empacotar a solução
* assinar o pacote
* gerar documentação
* decompilar o binário
* diagnosticar aplicações em execução
* dump da JVM
* obter informações de processos da JVM
* gerenciamento da keystore, chaves de criptografia
<br/>
Para faciliar a compreensão, iremos dividir em 10 áreas:
1. [Ferramentas Básicas](#121-ferramentas-básicas)
1. [Ferramentas de Segurança](#122-ferramentas-de-segurança)
1. [Ferramentas de Internacionalização](#123-ferramentas-de-internacionalização)
1. [Ferramentas RMI](#124-ferramentas-rmi)
1. [Ferramentas IDL e RMI-IIOP](#125-ferramentas-idl-e-rmi-iiop)
1. [Ferramentas para deploy](#125-ferramentas-idl-e-rmi-iiop)
1. [Ferramentas Java Plug-in](#127-ferramentas-java-plug-in)
1. [Ferramentas Web start](#128-ferramentas-web-start)
1. [Ferramentas de monitoramento e gerenciamento](#129-ferramentas-de-monitoramento-e-gerenciamento)
1. [Ferramentas de troubleshooting](#1210-ferramentas-de-troubleshooting)

#### 1.2.1. Ferramentas Básicas
Ferramentas que estão desde o ínicio do JDK e são utilizadas para criar e fazer o build das aplicações Java. Elas incluem:
* javac: Lê as definições dos arquivos ```.java``` e compila para dentro dos arquivos ```.class```
* java: Executa uma aplicação Java
* javadoc: Gera paginas HTML com as documentações das APIs Java para dentro do fonte Java
* apt: Procura e executa processadores de anotações, baseado nas anotações presente em um determinado arquivo fonte Java
* appletviwer: Habilita a execução de uma applet sem a necessidade de um browser
* jar: Empacota aplicação Java para dentro de um único arquivo
* jdb: ferramenta de debugging
* javah: Produz cabeçalhos C e arquivos fontes a partir de uma classe Java
* javap: desmonta um arquivo ```.class``` e exibe informações sobre campos, construtores e os métodos presente no class file
* extcheck: Detecta conflito de versão entre um arquivo JAR específico e o arquivo JAR instalado

#### 1.2.2. Ferramentas de Segurança
Inclui chaves e ferramentas de gerenciamento de certificados que podem ser utilizados para manipular o keystore do Java.
<br/>
Um keystore Java é um container com certificados autorizados ou chaves publicas de certificados. Entretamento, frequentemente é utilizado por aplicações Java para encriptação, autenticação e chamadas HTTPS.
<br/>
Entretando, essas ferramentas nos ajudam a configurar politicas de segurança em nossos sistemas e criar aplicação que conseguem trabvalhar dentro do escopo destas politicas no ambiente de produção. Algumas ferramentas:
* keytool: Ajuda com o gerenciamento do keystore, nomeando chaves de criptografias e certificados
* jarsigner: Gera arquivos JAR assinados digitalmente utilizando as informações do keystore
* policytool: Nos permite gerenciar arquivos de configurações de políticas externas que definem a política de segurança da instalação

Algumas ferramentas auxilia no gerenciamento de tickets Kerberos. Kerberoes é um protocolo de rede de autenticação. Ele trabalha na base do ticket para permitir comunicação entre nós de rede não segura, fornecendo uma maneira segura de identificar esses nós. Algumas dessas ferramentas:
* kinit: Utilizado para obter e cachear ticket-consessão tickets Kerberos
* ktab: Gerencia, principalmente, os nomes e par e chaves, em uma tabela chave
* klist: Exibe as credenciais local cacheada e as tabelas chaves

#### 1.2.3. Ferramentas de Internacionalização
Internacionalização é um processo que permite projetar a aplicação que pode ser adaptada para varias linguas e regioções sem ter a necessidade alterar a aplicação.
<br/>
A ferramenta **native2ascii** -e utilizada para esse propósito. Essa ferramenta converte o arquivo com os caracteres suportado pelo JRE, para o encod do ASCII ou o Unicode Scapes.

#### 1.2.4. Ferramentas RMI
Habilita a comunicação entre aplicação Java remotas, provendo um escopo.
<br/>
RMI habilita um objeto executando em uma JVM invocar métodos em um objeto executando em outra JVM
* rmic: 
* rmiregistry: 
* rmid: 
* serialver: 

#### 1.2.5. Ferramentas IDL e RMI-IIOP
Java Interface Definition Language (IDL) adiciona capacidade de **Common Object-Based Request Broker Architecture (CORBA)** na plataforma JAVA.
Essas ferramentas habilitam aplicações Java Web distribuidas a invocar operações em serviços nas redes remotas, utilizando o padrão de instrustria **Object Management Group (OMG) – IDL**. Da mesma maneira podemos utilizar o **Internet InterORB Protocol (IIOP)**.
<br/>
**RMI-IIOP** habilita programação em aplicações e servidores CORBA via API RMI. Habilita conexão entre duas aplicações escritas em qualquer linguagem compatíveis CORBA via **Internet InterORB Protocol (IIOP)**.
* tnameserv: 
* idlj: 
* orbd: 
* servertool: 

#### 1.2.6. Ferramentas para deploy
Ferramentas para deployar aplicações Java e applets na Web.
* pack200: 
* unpack200: 

#### 1.2.7. Ferramentas Java Plug-in
O JDK proveu o **htmlconverter** que deve ser utilizado em conjunto com o Java Plug-in.
<br/>
Ferramenta que possibilida executar um applet sem browser. De um lado o Plug-in Java estabelece uma conexão entre o browser e a plataforma Java, resultando na conexão entre applets e o website, aonde o website poderá executar o applet. Do outro ladro a ferramente **htmlconverver** possibilita converter uma pagina HTML que contem o applet para o formato do Java Plug-in.

#### 1.2.8. Ferramentas Web start
O JDK trouxe o **javaws**, aonde podemos utilizá-lo em conjunto com o Java Web Start.
<br/>
Essa ferramenta permite baixar e executar uma aplicação Java com um único click do browser. Com isso não será necessário nenhum processo de instalação.

#### 1.2.9. Ferramentas de monitoramento e gerenciamento
Permite monitorar a performance e o consumo de recursos.
* jconsole: Provê um console gráfico que nos permite monitorar e gerenciar aplicações Java
* jps: Lista as JVMs executadas no sistema alvo
* jstat: Monitor de estatisticas da JVM
* jstatd: Monitora a criacação e a finalização de instâncias de JVM

#### 1.2.10. Ferramentas de troubleshooting
Ferramentas que podemos experimentar largamente em nossas tarefas de troubleshooting:
* info: Gera informações de configuração de um processo Java específico
* jmap: Imprime mapas de objetos de memória compartilhado ou detalhes de memória header de um processo específico
* jsadebugd: Atachador para um processo Java e atua como um servidor de debug
* jstack: Imprime o rastreamento de pilha do Java de ums thread Java para um processo específico

<br/>

[Link](https://docs.oracle.com/en/java/javase/20/docs/specs/man/index.html) com a lista das ferramentas

### 1.3. Bibliotecas para desenvolvimento
APIs core que facilitam a implementação de solução.
A lista de APIs é extensa e fornece uma gama abrangente de soluções prontas e, que já foram testadas e evoluidas pela comunidade.
<br/>
Outros projetos fornecem APIs que são largamente utilizadas pela comunidade, porém APIs de terceiro não fazem parte da biblioteca do Java, sendo necessária importar no seu projeto. Segue algumas empresas que fornecem APIs:
* Eclipse Foundation
* Spring
* Apache

[Link](https://docs.oracle.com/en/java/javase/20/docs/api/index.html) com a documentação das APIs Java

### 1.4. Máquina virtual
A JVM é uma implementação da máquina virtual que executa programas Java.
<br/>
A JVM virtualiza a máquina hospedeira, fornecendo uma plataforma para execução do código Java.
<br/>
Primeiro a JVM interpreta os **bytecodes**, depois armazena as informações das classes na área da memória. Finalmente executa o **bytecodes** gerados no processo de compilação
<br/>
A JVM abstrai o hardware e o S.O. do computador hospedeira, aonde define e manipula várias áres de memória em tempo de execução. Nesse caso as nossas classes Java são executadas no JVM. A JVM fornece o poder de executar o mesmo código Java em arquiterturas diferentes.
<br/>
A JVM possui os seguintes componentes:
* [Class loaders](#141-class-loaders)
* [Run-time Data Areas](#142-run-time-data-areas)
* [Execution Engine](#143-execution-engine)
* [Java Native Interface](#144-java-native-interface)

#### 1.4.1. Class loaders
Inicia tarefas para que a JVM inclua os carregamentos necessários, como verificação e link dos bytecodes.
<br/>
Existem três tipos de carregadores de classes:
1. **Bootstrap class loader**: Faz parte do core da JVM, então não é um código Java, é um código nativo. Ele é responsável por carregar as classes internas assim que sobe a JVM. Ele carrega as classes do diretório **$JAVA_HOME/jre/lib**, que tipicamente inclui:
	1. Classes ro run-time no *rt.jar*
	1. Classe de internacionalização no *i18n.jar*
	1. Classes de conversão de caracter no *chasets.jar*
	1. Entre outras
1. **Extension class loader**: É a filha da **Bootstrap class loader**, responsável por carregar para dentro da JVM as classes de extensão das classes core padrão do Java, do diretório **$JAVA_HOME/lib/ext**, ou do diretório configurado em *java.ext.dirs* da propriedade do sistema do Java. Usuários podem adicionar jars customizados para esse diretório
1. **System ou Application class loader**: É filha da **Extension class loader**. Responsável por carregar para a JVM as classes do nível de aplicação. Ele carrega os arquivos encontrado na variável de ambientes **classpath, -classpath ou opção da linha de comando -cp**

##### 1.4.1.1. Como funciona o class loader
O médoto **java.lang.ClassLoader#loadClass** é responsável por carregar o bytecode em tempo de execução.
<br/>
Quando a JVM solicita uma classe, então o **Class Loader** tenta localizar a classe e carregar o seu bytecode em tempo de execução utilizando o fully qualified name.
<br/>
Se ele não consegue carregar a classe, então é delegado para a *class loader* pai. Esse processo ocorre recursivamente.
<br/>
Se, eventualmente, o *class loader* pai não localizar o bytecode, então o *class loader* filho deve invocar o método **ava.net.URLClassLoader#findClass** para verificar se possui o bytecode dentro do seu próprio arquivos de sistema.
<br/>
Se o *class loader* filho não for capaz de carregar a classe, então será lançado um **java.lang.NoClassDefFoundError** ou **java.lang.ClassNotFoundException**.
<br/>
O *class loader* segue uma arvore de delegação para carregar os bytecodes para a JVM

##### 1.4.1.2. Arvore de delegação 
Quando é solicitado um bytecode ou um recurso, o *class loader* vai delegar para o *class loader pai* carregar.
<br/>
Vamos dizer que o **application class loader** recebeu a requisição para carregar o bytecode ou um recurso, então irá seguir a seguinte modelo:
1. O *application class loader** vai delegar para o **extension class loader**
1. O **extension classe loader** vai delegar para o **bootstrap class loader**
1. O **bootstrap class loader** é o último nível da arvore, então tenta carregar o bytecode ou o recurso
	1. Se o **bootstrap class loader** teve sucesso, então o bytecode ou o recurso é carregado para a JVM e retorna para **extesion class loader**
	1. Se o **bootstrap class loader** não conseguiu carregar, então a demanda retorna para o **extension class loader**
1. O **extension class loader** "analisa" o status do **bootstrap class loader**:
	1. Se o **boostratp class loader** conseguiu carregar, então apenas retorna para **application class loader**
	1. Se o **bootstrap class loader** não conseguiu carregar, então o **extension class loader** tenta carregar o bytecode ou o recurso e retorna para o **application class loader**
1. Caso o **bootstrap class loader** e o **extension class loader** não conseguiram carregar, somente assim o **application class loader** tentará carregar o bytecode ou o recurso

Esse modelo de delgação é necessário para **garantir a unicidade do bytecode ou recurso na JVM**
<br/>
Os bytecodes ou recursos carregados possuem níveis de visibilidade

##### 1.4.1.3. Nível de visibilidade do bytecode
O **class loader** filho são visíveis por **class loader** pai.
<br/>
Quando um **extension class loader** carrega uma classe, essa classe carregada é visível pelo **extension class loader** e o **bootstrap class loader**, porém o inverso não acontece, sendo assim o **application class loader** não conseguirá ver a classe carregada pelo **extension class loader**
<br/>
Exemplificando: Se o **extension class loader** carregar a *DogClass*, então **extension class loader** e **bootstrap class loader** conseguem ver essa classe na JVM mas o **application class loader** não.

#### 1.4.2. Run-time Data Areas
A JVM define várias áreas de memória para executar os programas Java. Essas áreas são utilizadas em tempo de execução, por isso são conhecidas como *áreas de dados de tempo de execução*. Algumas dessas áreas são construídas quando a JVM é ligada e destruídas quando a JVM é finalizada, outras são construídas quando uma thread na JVM é ligado e destruída quando essa thread é desligada.
<br/>
Vamos conhecer algumas dessas áreas:
* [Method area](#421-method-area)
* [Heap area](#422-heap-area)
* [Stack area](#423-stack-area)
* [PC registers](#424-pc-registers)
* [Native methods stacks](#425-native-methods-stacks)

##### 1.4.2.1. Method area
Basicamente é análoga de armazenamento dos códigos compilados. Aqui é armazenados a estrutura de cada classe, como:
* Pool das constantes
* Campos e dados dos métodos
* Código dos métodos
* Construtores
* Nome qualificado completo das classes (fully-qualified name)

Essa memória é compartilhada entre todas as threads da JVM

##### 1.4.2.2. Heap area
A JVM aloca nessa area de memória todas as instâncias e matrizes. Quando é utilizado o operador *new*, para criar um objeto, essa instância é inserido nessa área.
<br/>
O *Garbage Collector (GC)* recupera a memória heap para alocar outros novos objetos. Para evitar um estouto na capacidade desta memória, o *GC* basicamente segue três fases: duas fase do **minor GC** e uma fase do **major GC**.
<br/>
A memória heap possui três partições:
1. Eden space: É uma parte da **Young Generation Space**. Quando criamos um novo objeto, A JVM aloca memória nesse espaço. Aqui é executada uma fase **minor GC**
1. Survivor space: É a outra parte da **Young Generation Space**. Esse espaço contém os objetos que tenham sobrevivido a fase *minor GC* do GC. Aqui é executada a outra fase do **minor GC**
1. Tenured space: Também conhecida como **Old Generation Space**. Aqui são mantidos os objetos com tempo maior de vida. A *Yong Generation Space* é configurado um limite para objetos, quando atinge esse limite, então esses objetos são movidos para o **Ternured Space**. Aqui é executada a fase **major GC**

##### 1.4.2.3. Stack area
É como um quadro e em cada quadro armazena variáveis local, resultados parciais e chamada aninhadas de métodos. A JVM cria a *stack area* no momento em que é criado uma nova thread. Essa área é privativa de cada thread correspondente.
<br/>
Cada entrada na *stack area* é chamada de **Stack Frame** pu **Activation Record**. Em cada quadro contém três partes:
1. Matriz da variável local: Contém todas as váriáveis local e os parâmetros dos métodos
1. Operador da Pilha: É como um espaço de trabalho que armazena o resultado dos cálculos intermediários
1. Quadro de dados: É armazenado resultados parciais, valores de retorno dos métodos e, em caso de exceção, armazena também uma tabela de *Exception* que fornece informações do bloco catch correspondente

##### 1.4.2.4. PC registers
Cada thread JVM possui um *PC Register* separado que armazena o endereço da instrução da execução corrente. Se a instrução da execução corrente é uma parte de um método nativo, então esse valor é indefinido

##### 1.4.2.5. Native methods stacks
Métodos nativos é quando são escritos em uma linguagem diferente do Java, por exemplo, em C++.
<br/>
A JVM fornece capacidade para invocar esse método nativos. Uma pilha de métodos nativos também são conhecidos como *C Stacks*, é armazenado informações desses métodos nativos. No momento em que um método nativo é compilado para o código da máquina, eles usualmente utilizam o **Native Methods Stacks** para manter o estado desses métodos.
<br/>
A JVM cria essa área para cada uma thread criada e não compartilhada essa área.

#### 1.4.3. Execution Engine
O motor de execução executa as instruções que estão presentes nas áreas de memória. Possui três partes:
1. Interpreter: Quando o *classloader* carrega e verifica o bytecode, o interpretador executa o bytecode linha a linha. Essa execução é um pouco demorada. A desvantagem do interpretador é quando um método é invocado multipla vezes, para cada vez uma nova interpretação é requerida. Para mitigar essa desvantagem, a JVM utiliza o **JIT Compiler**
1. Just-In-Time (JIT) Compiler: Compila, em tempo de exeução, os métodos dos bytecodes que são frequentemente invocados para código nativo da máquina. Ele é o responsável pela otimização de programas Java. A JVM automaticamente monitora quando a execução de um método ocorre. Dado que um método é elegível para o **JIT Compilation** ele é marcado para ser compilado para o código da máquina. Esse método é conhecido como *método quente*. Esse processo ocorrer em uma thread separado da JVM. Como resultado o processo de execução do programa não é interrompido e, quando esse método for invocado novamente, sua execução será mais rápida.
1. Garbage Collector: É a ferramenta que a JVM utiliza para gerenciar a memória. É um processo que fica analisando a memória **heap**, identificando quando os objetos são utilizados ou não. É feito uma análise para identificar objetos não utilizados, então eles são marcados. Em outro momento é feito nova análise, caso esses objetos ainda não foram utilizados, então eles são excluídos. O **GC** é um deamon thread. Podemos invocar o **GC** invocando o método ```System#gc```, entretando não teremos a garantia que o **GC** será invocado imediatamente, a JVM decide quando invocar o **GC**., sendo assim, o melhor a fazer, é deixar a JVM cuidar do ciclo de vida dos objetos.

#### 1.4.4. Java Native Interface
É como uma ato que ocorre entre o código Java e uma biblioteca nativa (C/C++).
<br/>
Em algumas situações o Java não consegue atender algumas necessidades para a sua aplicação, por exemplo, uma feature implementando para uma plataforma dependente. Nesse caso podemos utilizar o **JNI** para habilitar códigos executando na JVM invocar bibliotecas nativas. Por outro lado, podemos habilitar códigos nativo invocar códigos que estão executando na JVM.

___

## 2 Ambientes
As tecnologias Java foram dividias em dois ambientes:

### 2.1 JRE
É o ambiente de execução do Java, o ambiente produtivo. O programa Java é executado dentro deste ambiente.
<br/>
Esse ambiente possui:
* [Uma implementação da JVM](#14-máquina-virtual)
* [Classes necessárias para executar os programas Java](#141-class-loaders)
* [Arquivos de propriedades](#211-arquivos-de-propriedades)
* [Outros arquivos](#212-outros-arquivos)

#### 2.1.1 Arquivos de propriedades
A plataforma Java utiliza **property settings** para manter as configurações. Dependendo de como é utilizado, eles podem ser localizados em diferentes pastas dentro do diretório **/jre/lib/**. Inclue:
* Configuração de calendário em **calendar.properties**
* Configuração de logs em **logging.properties**
* Configuração de redes em **net.properties**
* Configurações de deploy em **/jre/lib/deploy/**
* Gerenciamento de propriedades em **/jre/lib/management/**

#### 2.1.2 Outros arquivos
Separado do já mencionado **Classes necessárias para executar os programas Java**, JRE contém arquivos para outros propósitos:
* Gerenciamento de segurança em **jre/lib/security**
* Diretório de classes de suporte para applets em **jre/lib/applet**
* Arquivos de fontes utilizadas em **jre/lib/fonts** 
* Entr outros

### 2.2 JDK
O Java Development Kit, é um kit para desenvolvimento. Nesse kit é fornecido todo o ambiente necessários para o desenvolvimento do projeto em questão (JSE, JEE, JME e etc).
<br/>
Os componentes code do JDK são:
* [JRE](#21-jre)
* [Ferramentas](#12-ferramentas)

<br/>

##### Fontes
[Tutorial Java SE](https://docs.oracle.com/javase/tutorial/index.html)
<br/>
[Tecnologia Java](https://docs.oracle.com/javase/tutorial/getStarted/intro/index.html)
<br/>
[Linguagem Java](https://www.oracle.com/java/technologies/language-environment.html)
<br/>
[Baeldung JVM JRE JDK](https://www.baeldung.com/jvm-vs-jre-vs-jdk)
<br/>
[Baeldung class loader](https://www.baeldung.com/java-classloaders)
<br/>
[Baeldung class not found exception OR no class def found error](https://www.baeldung.com/java-classnotfoundexception-and-noclassdeffounderror)

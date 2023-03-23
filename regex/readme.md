### Regex in Java

[Repositório curso](https://github.com/cod3rcursos/curso-regex)

[Refex101](https://regex101.com/)

#### Livros
* Expressões regulares Cookbook

#### O que é Expressão Regular

É uma método formal de se especificar um padrão de texto

### Construtores da expressão regular

Para montar a expressão regular, podemos utilizar alguns padrões aonde
o Java fará a busca no texto alvo

Esses caracteres podem ser consultados na [Documentação do Pattern](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html)

Alguns tipos de construtores:
* Caracteres específicos
* Grupos de caracateres
* Grupos de caracteres predefinidos
* Posicionamento de grupos de caracteres (US-ASCII)
* Grupos de caracteres no tuo java.lang.Character
* Grupos para Unicode Script, blocos, categorias e propriedades binárias
* Limite para grupos de caracteres (limite de combinação)
* Quantificadores
* Operadores lógicos

### Flags

São parâmetros passados ao padão regex para definir o escopo da busca
As flags ficam fora do padrão

* g || ? -> Global, vai buscar todas ocorrências do padrão no texto 
alvo
* ? -> Em ``Java`` é um global, localiza um ou nenhum
* \* -> Em ``Java`` é um global, localizar um ou nenhum
* i -> Ignore case

No Java as flags podem ser passadas no segundo parâmetro do método ``Pattern#compile``. Os valores
destas flags podem ser obtidas nas constantes do 
[Pattern](https://docs.oracle.com/en/java/javase/17/docs/api/constant-values.html#java.util.regex.Pattern.CANON_EQ).
Porém você também pode inserir as flags dentro da expressão.

#### Flag insensitive case


### Expressão

A Expression é o filtro que o regex irá aplicar para encontrar as 
ocorrências dentro do texto alvo.

Uma Expression deve estar dentro da seguinte estrutura:
- Java: Dentro de aspas duplas 
  - "<PADRÃO>"
- JavaScript: Dentro de aspas duplas ou barra de escape
  - "<PADRÃO>"
  - /<PADRÃO>/
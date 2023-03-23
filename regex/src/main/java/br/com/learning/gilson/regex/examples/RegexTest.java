package br.com.learning.gilson.regex.examples;

import java.util.regex.*;

public class RegexTest {

    public static void main(String[] args) {
        final String text = "0123456789abcdefABC123defabfe";
        //final String expression = "[a-f]";
        final String expression = "(?i)ab";
        RegexTest regexTest = new RegexTest();

        regexTest.regexWithPatternAndMatcher(text, expression);
        regexTest.replaceAllString(text, expression);
    }

    private void regexWithPatternAndMatcher(final String text, final String expression){
        //Cria o Padrão para filtro
        Pattern pattern = Pattern.compile(expression);
        //Executa o filtro
        Matcher matcher = pattern.matcher(text);
        //Obtem os resultados
        matcher.results().forEach(result -> {
            final String message = String.format("Posicão: %s-%s\tValor: %s%n",
                    result.start(), result.end(), result.group());
            System.out.println(message);
        });

        //Outra forma de executar iterando nos resultados
        /*while(matcher.find()){
            final String mensagem = String.format("Posicões: %s-%s\tValor: %s%n",
                    matcher.start(), matcher.end(), matcher.group());
            System.out.println(mensagem);
        }*/
    }

    private void replaceAllString(final String text, final String expression){
        final String result = text.replaceAll(expression, "*").trim();
        final String message = String.format("Original: %s \t Replaced: %s", text, result);
        System.out.println(message);
    }
}

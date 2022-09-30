package br.com.learning.gilson.regex;

import java.util.regex.*;

public class RegexTest {

    public static void main(String[] args) {
        final String text = "0123456789abcdef";
        final String patternString = "[a-f]";

        regexWithPatternAndMatcher(text, patternString);
        replaceAllInString(text, patternString);
    }

    private static void regexWithPatternAndMatcher(final String text, final String patternString){
        //Cria o Padrão para filtro
        Pattern pattern = Pattern.compile(patternString);
        //Executa o filtro
        Matcher matcher = pattern.matcher(text);
        //Obtem os resultados
        matcher.results().forEach(RegexTest::printMatchResult);

        //Outra forma de executar iterando nos resultados
        /*while(matcher.find()){
            final String mensagem = String.format("Posicões: %s-%s\tValor: %s%n",
                    matcher.start(), matcher.end(), matcher.group());
            System.out.println(mensagem);
        }*/
    }

    private static void replaceAllInString(final String text, final String patternString){
        final String resultReplaced = text.replaceAll(patternString, " 'HERE!' ").trim();
        final String mensagem = String.format("Original: %s \t Replaced: %s",
                text, resultReplaced);
        System.out.println(mensagem);
    }

    private static void printMatchResult(final MatchResult result){
        final String message = String.format("Posicões: %s-%s\tValor: %s%n",
                result.start(), result.end(), result.group());
        System.out.println(message);
    }
}

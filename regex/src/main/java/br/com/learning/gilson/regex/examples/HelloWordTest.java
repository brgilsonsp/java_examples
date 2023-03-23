package br.com.learning.gilson.regex.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWordTest {

    public static void main(String[] args) {
        final String text = "Casa bonita é a casa amarela da esquina com a Rua " +
                "ACASALAR que fica perto da casa do João";

        HelloWordTest helloWordTest = new HelloWordTest();
        helloWordTest.foundAllWordCasaInTheText(text);
    }

    public void foundAllWordCasaInTheText(final String text){
        Pattern pattern = Pattern.compile("(i)casa");
        Matcher matcher = pattern.matcher(text);
        matcher.results().forEach(result -> {
            final String message = String.format("Position: %s \t Word: %s",
                    result.start(), result.group());
            System.out.println(message);
        });
    }
}

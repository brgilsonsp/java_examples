package br.com.learning.gilson.regex.examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsensitiveCaseTest {

    public static void main(String[] args) {
        final String textSource = "Church-A Middle-0 Food-B Houngry-# Wife-C children-d";

        InsensitiveCaseTest.matchGroupSensitiveCase(textSource);
        InsensitiveCaseTest.matchPhraseSensitiveCase(textSource);
        InsensitiveCaseTest.matchInsensitiveCaseWithParameters(textSource);
        InsensitiveCaseTest.matchInsensiteCaseWithFlag(textSource);

    }

    /**
     * No input never flag
     * Found letter c or h
     * @param textSource
     */
    private static void matchGroupSensitiveCase(final String textSource){
        final String regex = "[ch]";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(textSource);
        System.out.println("---------- Sensitive Mode Group c OR h----------");
        matcher.results().forEach(result ->{
            System.out.println(String.format("To regex '%s', found %s in position %s at %s",
                    regex, result.group(), result.start(), result.end()));
        });
    }

    /**
     * No input never flag
     * Found word ch
     * @param textSource
     */
    private static void matchPhraseSensitiveCase(final String textSource){
        final String regex = "ch";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(textSource);
        System.out.println("---------- Sensitive Mode word ch----------");
        matcher.results().forEach(result ->{
            System.out.println(String.format("To regex '%s', found %s in position %s at %s",
                    regex, result.group(), result.start(), result.end()));
        });
    }

    /**
     * Input {@link Pattern#CASE_INSENSITIVE} into second parameter of {@link Pattern#compile(String, int)}
     * @param textSource
     */
    private static void matchInsensitiveCaseWithParameters(final String textSource){
        final String regex = "[a-z]";
        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(textSource);
        System.out.println("---------- Insensitive Mode With Parameter ----------");
        matcher.results().forEach(result -> {
            System.out.println(String.format("Found '%s' in position %s at %s",
                    regex, result.start(), result.end()));
        });
    }

    /**
     * Made new regex with flag '(?i)' before the regex
     * @param textSource
     */
    private static void matchInsensiteCaseWithFlag(final String textSource){
        final String regex = "c";
        final String regexWithFlag = String.format("(?i)%s", regex);
        final Pattern pattern = Pattern.compile(regexWithFlag);
        final Matcher matcher = pattern.matcher(textSource);
        System.out.println("---------- Insensitive Mode With Flag ----------");
        matcher.results().forEach(result -> {
            System.out.println(String.format("Found '%s', with regex '%s' in position %s at %s",
                    regex, regexWithFlag, result.start(), result.end()));
        });
    }
}

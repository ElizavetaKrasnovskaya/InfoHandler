package com.epam.handling.parser;

import com.epam.handling.composite.*;
import com.epam.handling.interpreter.Calculator;

import java.util.regex.Pattern;

public class WordParserImpl implements BaseParser{

    private static String LETTER_REGEX = "\\p{Alpha}";
    private static final String PUNCT_REGEX = "\\p{Punct}";
    private static final String NUMERIC_REGEX = "\\d+(\\.\\d+)?";
    private static final String NON_MATH_END_REGEX = "[^\\d)]";

    private static final Calculator calculator = new Calculator();

    @Override
    public TextComponent parse(String text) {
        TextComposite fullWord = new TextComposite();

        if(Pattern.compile(NUMERIC_REGEX).matcher(text).find()){
            String endSymbol = text.substring(text.length()-1, text.length());
            boolean isLast = false;

            if(isLast = endSymbol.matches(NON_MATH_END_REGEX)){
                text = text.substring(0, text.length()-1);
            }

            for(Character character : calculator.calculate(text).toCharArray()){
                fullWord.add(new Numeric(character));
            }

            if(isLast){
                fullWord.add(new Punctuation(endSymbol.charAt(0)));
            }
        }else{
            for(char character : text.toCharArray()){
                if(String.valueOf(character).matches(LETTER_REGEX)){
                    fullWord.add(new Letter(character));
                }else if(String.valueOf(character).matches(PUNCT_REGEX)){
                    fullWord.add(new Punctuation(character));
                }
            }
        }
        return fullWord;
    }
}

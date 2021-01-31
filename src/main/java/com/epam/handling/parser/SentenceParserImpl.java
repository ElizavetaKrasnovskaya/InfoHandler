package com.epam.handling.parser;

import com.epam.handling.composite.TextComponent;
import com.epam.handling.composite.TextComposite;


public class SentenceParserImpl implements BaseParser{

    private static final String WORD_BREAK_REGEX = "\\p{Blank}";
    private static final WordParserImpl wordParser = new WordParserImpl();

    @Override
    public TextComponent parse(String text) {
        TextComposite fullSentence = new TextComposite();
        for(String word : text.split(WORD_BREAK_REGEX)){
            fullSentence.add(wordParser.parse(word));
        }
        return fullSentence;
    }

}

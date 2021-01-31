package com.epam.handling.parser;

import com.epam.handling.composite.TextComponent;
import com.epam.handling.composite.TextComposite;


public class ParagraphParserImpl implements BaseParser{

    private static final String SENTENCE_REGEX = "\\p{Upper}([.&&[^\\.!\\?]])*\\.\\p{Blank}";//"([\\p{Upper}]|\\p{Alnum})([\\p{Alnum}\\p{Punct}[^\\.!?]])*[\\.!\\?]\\p{Blank}";
    private static final SentenceParserImpl sParser = new SentenceParserImpl();

    @Override
    public TextComponent parse(String text) {
        TextComposite fullParagraph = new TextComposite();
        for (String paragraph : text.split(SENTENCE_REGEX)){
            fullParagraph.add(sParser.parse(paragraph));
        }

        return fullParagraph;
    }



}

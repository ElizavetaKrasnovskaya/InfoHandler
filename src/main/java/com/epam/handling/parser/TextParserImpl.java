package com.epam.handling.parser;

import com.epam.handling.composite.TextComponent;
import com.epam.handling.composite.TextComposite;

public class TextParserImpl implements BaseParser{

    private static final String PARAGRAPH_REGEX = "\r";
    private static final ParagraphParserImpl paragraphParser = new ParagraphParserImpl();

    @Override
    public TextComponent parse(String text) {
        TextComposite fullText = new TextComposite();
        for (String paragraph : text.split(PARAGRAPH_REGEX)){
            fullText.add(paragraphParser.parse(paragraph));
        }
        return fullText;
    }
}

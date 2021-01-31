package com.epam.handling.parser;

import com.epam.handling.composite.Letter;
import com.epam.handling.composite.Punctuation;
import com.epam.handling.composite.TextComposite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParagraphParserTest {

    private ParagraphParserImpl parser;

    @Before
    public void initParser() {
        parser = new ParagraphParserImpl();
    }

    @Test
    public void parserTestSimple() {

        String simpleText = "S.\r";

        Letter letter = new Letter('S');
        Punctuation dot = new Punctuation('.');

        TextComposite word = new TextComposite();
        word.add(letter);
        word.add(dot);

        TextComposite sentence = new TextComposite();
        sentence.add(word);

        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);

        assertEquals(paragraph, parser.parse(simpleText));
    }

    @Test
    public void parserTest() {

        String paragraph = "I is.\r";

        Letter capsI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');

        TextComposite wordCapI = new TextComposite();
        wordCapI.add(capsI);

        TextComposite wordIsDot = new TextComposite();
        wordIsDot.add(i);
        wordIsDot.add(s);
        wordIsDot.add(dot);

        TextComposite firstSentence = new TextComposite();
        firstSentence.add(wordCapI);
        firstSentence.add(wordIsDot);

        TextComposite textComposite = new TextComposite();
        textComposite.add(firstSentence);

        assertEquals(textComposite, parser.parse(paragraph));

    }

}

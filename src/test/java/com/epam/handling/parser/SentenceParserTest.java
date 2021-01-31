package com.epam.handling.parser;

import com.epam.handling.composite.Letter;
import com.epam.handling.composite.Punctuation;
import com.epam.handling.composite.TextComposite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceParserTest {

    private SentenceParserImpl parser;


    @Before
    public void initParser() {
        parser = new SentenceParserImpl();
    }

    @Test
    public void parserTestSimple() {
        String SIMPLE_TEXT = "S.";

        Letter letter = new Letter('S');
        Punctuation dot = new Punctuation('.');

        TextComposite word = new TextComposite();
        word.add(letter);
        word.add(dot);

        TextComposite expectedSentence = new TextComposite();
        expectedSentence.add(word);
        assertEquals(expectedSentence, parser.parse(SIMPLE_TEXT));
    }

    @Test
    public void parseTest() {

        String SENTENCE = "I is.";

        Letter capsI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');

        // I
        TextComposite wordCapI = new TextComposite();
        wordCapI.add(capsI);

        // is.
        TextComposite wordIsDot = new TextComposite();
        wordIsDot.add(i);
        wordIsDot.add(s);
        wordIsDot.add(dot);

        // I is.
        TextComposite sentence = new TextComposite();
        sentence.add(wordCapI);
        sentence.add(wordIsDot);

        assertEquals(sentence, parser.parse(SENTENCE));
    }
}

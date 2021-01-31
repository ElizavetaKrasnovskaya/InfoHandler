package com.epam.handling.parser;

import com.epam.handling.composite.Letter;
import com.epam.handling.composite.Numeric;
import com.epam.handling.composite.Punctuation;
import com.epam.handling.composite.TextComposite;
import com.epam.handling.reader.TextReader;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextParserTest {

    private static final String TABBED_TEXT = "I is.\rI is (2+3.4)/sin(4).\r"; // -7
    private static TextParserImpl parser;


    @BeforeClass
    public static void initParser() {
        parser = new TextParserImpl();
    }

    @Test
    public void parseTestSimple() {
        String simpleText = "K.";
        Letter letter = new Letter('K');
        Punctuation dot = new Punctuation('.');

        TextComposite word = new TextComposite();
        word.add(letter);
        word.add(dot);

        TextComposite sentence = new TextComposite();
        sentence.add(word);

        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);

        TextComposite text = new TextComposite();
        text.add(paragraph);

        assertEquals(text, parser.parse(simpleText));
    }

    @Test
    public void parseTestHasTab() {

        String tabbedText = "I is.\rI is (2+3.4)/sin(4).\r";

        Letter capsI = new Letter('I');
        Letter i = new Letter('i');
        Letter s = new Letter('s');
        Punctuation dot = new Punctuation('.');
        Numeric minus = new Numeric('-');
        Numeric seven = new Numeric('7');

        TextComposite wordCapsI = new TextComposite();
        wordCapsI.add(capsI);

        TextComposite wordIsDot = new TextComposite();
        wordIsDot.add(i);
        wordIsDot.add(s);
        wordIsDot.add(dot);

        TextComposite wordIs = new TextComposite();
        wordIs.add(i);
        wordIs.add(s);

        TextComposite wordMinusSevenDot = new TextComposite();
        wordMinusSevenDot.add(minus);
        wordMinusSevenDot.add(seven);
        wordMinusSevenDot.add(dot);

        TextComposite firstSentence = new TextComposite();
        firstSentence.add(wordCapsI);
        firstSentence.add(wordIsDot);

        // I is -7.
        TextComposite secondSentence = new TextComposite();
        secondSentence.add(wordCapsI);
        secondSentence.add(wordIs);
        secondSentence.add(wordMinusSevenDot);

        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(firstSentence);

        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(secondSentence);

        TextComposite fullText = new TextComposite();
        fullText.add(firstParagraph);
        fullText.add(secondParagraph);

        System.out.println(fullText);
        assertEquals(fullText, parser.parse(tabbedText));
    }

    @Test
    public void parseTestFromFile() {
        TextReader reader = new TextReader();
        System.out.println(parser.parse(reader.read("src\\files\\file")));
    }

}

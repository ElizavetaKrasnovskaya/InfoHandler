package com.epam.handling.parser;

import com.epam.handling.composite.Letter;
import com.epam.handling.composite.Numeric;
import com.epam.handling.composite.Punctuation;
import com.epam.handling.composite.TextComposite;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordParserTest {

    private static WordParserImpl parser;


    @BeforeClass
    public static void initParser() {
        parser = new WordParserImpl();
    }

    @Test
    public void parserTestSimple() {
        String SIMPLE_WORD = "J";
        Letter letter = new Letter('J');
        TextComposite text = new TextComposite();
        text.add(letter);
        assertEquals(text, parser.parse(SIMPLE_WORD));
    }

    @Test
    public void parseTest() {
        String WORD = "Java.";

        Letter capsJ = new Letter('J');
        Letter a = new Letter('a');
        Letter v = new Letter('v');
        Punctuation dot = new Punctuation('.');

        TextComposite text = new TextComposite();

        text.add(capsJ);
        text.add(a);
        text.add(v);
        text.add(a);
        text.add(dot);

        assertEquals(text, parser.parse(WORD));
    }

    @Test
    public void parseTestMathExpr() {
        String MATH_EXPR = "(2+3.4)/sin(4)";

        TextComposite num = new TextComposite();
        Numeric m = new Numeric('-');
        Numeric n = new Numeric('7');
        num.add(m);
        num.add(n);

        assertEquals(num, parser.parse(MATH_EXPR));
    }
}

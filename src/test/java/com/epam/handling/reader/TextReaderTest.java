package com.epam.handling.reader;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class TextReaderTest {
    private static final String FILE_DIR = "src\\files";
    private static final String TEXT = "some text";
    private static String FILENAME;

    @BeforeClass
    public static void createTextFile() throws IOException {
        Path path = Files.createTempFile(new File(FILE_DIR).toPath(), null, null);
        Files.write(path, TEXT.getBytes());

        FILENAME = path.toString();
    }

    @Test
    public void readTest() {
        TextReader reader = new TextReader();
        String text = reader.read(FILENAME);
        assertEquals(text, TEXT);
    }

    @Test(expected = RuntimeException.class)
    public void readTextWithExceptionTest() {
        TextReader reader = new TextReader();
        String text = reader.read("src\\files\\ioexc");
        assertEquals(text, TEXT);

    }
}

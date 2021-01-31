package com.epam.handling.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextReader {

    public String read(final String fileName){
        try {
            return new String(Files.readAllBytes(new File(fileName).toPath()));
        }catch (IOException ex){
            throw new RuntimeException("Couldn't read file");
        }
    }

}

package com.epam.handling.service;

import com.epam.handling.composite.TextComponent;

import java.util.SortedMap;
import java.util.TreeMap;

public class TextPrinter {
    public void printWordsByAlphabet(TextComponent text){
        SortedMap<Character, String> words = new TreeMap<>();
        for(TextComponent paragraph : text.getComponents()){
            for (TextComponent sentence : paragraph.getComponents()){
                for (TextComponent word : sentence.getComponents()){
                    String wordString = word.toString() + " ";
                    Character key = Character.toLowerCase(wordString.charAt(0));

                    words.merge(key, wordString, String::concat);
                }
            }
        }
        for (String wordsString : words.values()){
            System.out.println(wordsString);
        }
    }
}

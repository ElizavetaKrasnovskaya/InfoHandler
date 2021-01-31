package com.epam.handling.service;

import com.epam.handling.composite.TextComponent;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SentenceSorter {
    public SortedSet<TextComponent> sortByWordCount(TextComponent text) {
        SortedSet<TextComponent> sentences = new TreeSet<>(
                new Comparator<TextComponent>() {
                    @Override
                    public int compare(TextComponent o1, TextComponent o2) {
                        return o1.countComponents() - o2.countComponents();
                    }
                }
        );

        for (TextComponent paragraph : text.getComponents()){
            for (TextComponent sentence : paragraph.getComponents()){
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}

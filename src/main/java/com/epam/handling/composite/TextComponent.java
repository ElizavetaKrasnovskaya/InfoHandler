package com.epam.handling.composite;


import org.w3c.dom.Text;

import java.util.List;

public interface TextComponent {
    void remove(TextComponent component);
    void add(TextComponent component);
    List<TextComponent> getComponents();
    int countComponents();
    void makeImmutable();
}

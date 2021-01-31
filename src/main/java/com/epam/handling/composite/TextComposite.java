package com.epam.handling.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextComponent{
    private static final String SPACE = " ";
    private static final String DOUBLE_SPACE_REGEX = "\\p{Blank}{2}";
    private static final String TRIPLE_SPACE = "   ";
    private static final String RETURN = "\r\r";

    private List<TextComponent> components;
    private boolean immutable = false;

    public TextComposite() {
        components = new ArrayList<TextComponent>();
    }

    @Override
    public void remove(TextComponent component) {
        if(!immutable){
            components.remove(component);
        }
    }

    @Override
    public void add(TextComponent component) {
        if(!immutable){
            components.add(component);
        }
    }

    public List<TextComponent> getComponents() {
        List<TextComponent> compList = Collections.unmodifiableList(components);
        for (TextComponent comp : compList) {
            comp.makeImmutable();
        }
        return compList;
    }

    @Override
    public int countComponents() {
        return components.size();
    }

    @Override
    public void makeImmutable() {
        immutable = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextComposite)) return false;
        TextComposite that = (TextComposite) o;
        return immutable == that.immutable && Objects.equals(getComponents(), that.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponents(), immutable);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextComponent c : components) {
            result.append(c.toString());
        }
        result.append(SPACE);
        String resultStr = result.toString();
        if (resultStr.endsWith(TRIPLE_SPACE)) {
            resultStr = resultStr.trim() + RETURN;
            resultStr.replaceAll(DOUBLE_SPACE_REGEX, SPACE);
        }
        return resultStr;
    }
}

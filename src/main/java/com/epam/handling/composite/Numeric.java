package com.epam.handling.composite;

import java.util.List;
import java.util.Objects;

public class Numeric implements TextComponent{

    private final Character character;

    public Numeric(Character character){
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Cannot remove component");
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Cannot add component");
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Cannot get components");
    }

    @Override
    public int countComponents() {
        return 1;
    }

    @Override
    public void makeImmutable() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numeric)) return false;
        Numeric numeric = (Numeric) o;
        return getCharacter().equals(numeric.getCharacter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacter());
    }

    @Override
    public String toString() {
        return character.toString();
    }
}

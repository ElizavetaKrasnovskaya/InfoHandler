package com.epam.handling.composite;


import java.util.List;
import java.util.Objects;

public class Punctuation implements TextComponent {
    private final Character character;

    public Punctuation(Character character){
        this.character = character;
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
        if (!(o instanceof Punctuation)) return false;
        Punctuation that = (Punctuation) o;
        return Objects.equals(character, that.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return character.toString();
    }
}

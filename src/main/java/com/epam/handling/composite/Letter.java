package com.epam.handling.composite;

import java.util.List;
import java.util.Objects;

public class Letter implements TextComponent{

    private Character character;

    public Letter(Character character){
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Can't remove component");
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Can't add component");
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("Can't get components");
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
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return character.equals(letter.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString(){
        return character.toString();
    }
}

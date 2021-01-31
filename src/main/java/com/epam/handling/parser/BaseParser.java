package com.epam.handling.parser;

import com.epam.handling.composite.TextComponent;

public interface BaseParser {
    TextComponent parse(String text);
}

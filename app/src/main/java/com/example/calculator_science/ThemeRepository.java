package com.example.calculator_science;

import java.util.List;

public interface ThemeRepository {

    void saveTheme(Theme theme);

    Theme getSavedTheme();

    List<Theme> getAllThemes();
}

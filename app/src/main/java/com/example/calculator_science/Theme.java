package com.example.calculator_science;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public enum Theme {
    THEME_ONE(R.style.Theme_Calculator_Science, R.string.themeOne, "theme1"),
    THEME_TWO(R.style.Theme_Calculator_Science_V2, R.string.themeTwo, "theme2");

    @StyleRes
    private final int themeRes;
    @StringRes
    private final int themeName;
    private final String key;


    Theme(int themeRes, int themeName, String key) {
        this.themeRes = themeRes;
        this.themeName = themeName;
        this.key = key;
    }

    public int getThemeRes() {
        return themeRes;
    }

    public int getThemeName() {
        return themeName;
    }

    public String getKey() {
        return key;
    }
}

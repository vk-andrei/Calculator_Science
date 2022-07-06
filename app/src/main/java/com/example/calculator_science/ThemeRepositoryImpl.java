package com.example.calculator_science;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

public class ThemeRepositoryImpl implements ThemeRepository {

    private static ThemeRepository INSTANCE;

    private SharedPreferences preferences;

    public ThemeRepositoryImpl(Context context) {
        preferences = context.getSharedPreferences("themes", Context.MODE_PRIVATE);
    }

    public static ThemeRepository getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ThemeRepositoryImpl(context);
        }
        return INSTANCE;
    }

    @Override
    public void saveTheme(Theme theme) {
        preferences.edit()
                .putString("KEY_THEME", theme.getKey())
                .apply();
    }

    @Override
    public Theme getSavedTheme() {
        String savedKey = preferences.getString("KEY_THEME", Theme.THEME_ONE.getKey());

        for (Theme theme : Theme.values()) {
            if (theme.getKey().equals(savedKey)) {
                return theme;
            }
        }
        return Theme.THEME_ONE;
    }

    @Override
    public List<Theme> getAllThemes() {
        return Arrays.asList(Theme.values());
    }
}

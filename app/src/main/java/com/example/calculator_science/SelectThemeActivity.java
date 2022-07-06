package com.example.calculator_science;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SelectThemeActivity extends AppCompatActivity {

    public static final String EXTRA_THEME = "EXTRA_KEY_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theme);

        ThemeRepository themeRepository = ThemeRepositoryImpl.getINSTANCE(this);

        List<Theme> themeList = themeRepository.getAllThemes();

        LinearLayout container = findViewById(R.id.container);

        Intent intent = getIntent();
        Theme selectedTheme = (Theme) intent.getSerializableExtra(EXTRA_THEME);


        for (Theme theme : themeList) {
            View itemView = getLayoutInflater().inflate(R.layout.item_theme, container, false);

            TextView textTitle = itemView.findViewById(R.id.title);
            textTitle.setText(theme.getThemeName());

            CardView cardViewItem = itemView.findViewById(R.id.theme_card);
            cardViewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent data = new Intent();
                    data.putExtra(EXTRA_THEME, theme);

                    setResult(Activity.RESULT_OK, data);
                    finish();

                    // Toast.makeText(SelectThemeActivity.this, theme.getThemeName(), Toast.LENGTH_SHORT).show();
                }
            });

            ImageView checked = itemView.findViewById(R.id.checked);

            if (theme.equals(selectedTheme)) {
                checked.setVisibility(View.VISIBLE);
            } else {
                checked.setVisibility(View.GONE);
            }

            container.addView(itemView);
        }

        findViewById(R.id.browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru"));
                startActivity(Intent.createChooser(intentBrowser, null));
            }
        });

    }
}
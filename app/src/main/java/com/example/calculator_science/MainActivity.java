package com.example.calculator_science;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previous_calculation);
        display = findViewById(R.id.display);

        display.setShowSoftInputOnFocus(false);


        Map<Integer, String> allButtons = new HashMap<>();

        allButtons.put(R.id.zero_BTN, getResources().getString(R.string.zeroText));
        allButtons.put(R.id.one_BTN, getResources().getString(R.string.oneText));
        allButtons.put(R.id.two_BTN, getResources().getString(R.string.twoText));
        allButtons.put(R.id.three_BTN, getResources().getString(R.string.threeText));
        allButtons.put(R.id.four_BTN, getResources().getString(R.string.fourText));
        allButtons.put(R.id.five_BTN, getResources().getString(R.string.fiveText));
        allButtons.put(R.id.six_BTN, getResources().getString(R.string.sixText));
        allButtons.put(R.id.seven_BTN, getResources().getString(R.string.sevenText));
        allButtons.put(R.id.eight_BTN, getResources().getString(R.string.eightText));
        allButtons.put(R.id.nine_BTN, getResources().getString(R.string.nineText));
        //allButtons.put(R.id.clear_BTN, getResources().getString(R.string.oneText));
        allButtons.put(R.id.bracketsOpen_BTN, getResources().getString(R.string.bracketsOpen));
        allButtons.put(R.id.bracketsClose_BTN, getResources().getString(R.string.bracketsClose));
        allButtons.put(R.id.divide_BTN, getResources().getString(R.string.divideText));
        allButtons.put(R.id.multiply_BTN, getResources().getString(R.string.multiplyText));
        allButtons.put(R.id.minus_BTN, getResources().getString(R.string.minusText));
        allButtons.put(R.id.plus_BTN, getResources().getString(R.string.plusText));
        allButtons.put(R.id.point_BTN, getResources().getString(R.string.pointText));
        //allButtons.put(R.id.equal_BTN, getResources().getString(R.string.oneText));


        View.OnClickListener BTN_push = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(allButtons.get(view.getId()));
            }
        };

        for (Map.Entry entry : allButtons.entrySet()) {
            //Log.d("TAG", String.valueOf(entry));
            int j = (int) entry.getKey();
            findViewById(j).setOnClickListener(BTN_push);
        }

    }

    private void updateText(String stringToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, stringToAdd, rightStr));
        // moving cursor
        display.setSelection(cursorPos + stringToAdd.length());
    }


}




 /*       findViewById(R.id.zero_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.one_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.two_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.three_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.four_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.five_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.six_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.seven_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.eight_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.nine_BTN).setOnClickListener(BTN_push);

        //findViewById(R.id.clear_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.bracketsOpen_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.bracketsClose_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.divide_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.multiply_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.minus_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.plus_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.point_BTN).setOnClickListener(BTN_push);
        //findViewById(R.id.equal_BTN).setOnClickListener(BTN_push);
        findViewById(R.id.one_BTN).setOnClickListener(BTN_push);*/
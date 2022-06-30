package com.example.calculator_science;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
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

        display.setShowSoftInputOnFocus(false); // not to show android keyboard

        Map<Integer, String> allPrintedBTNs = new HashMap<>();
        allPrintedBTNs.put(R.id.zero_BTN, getResources().getString(R.string.zeroText));
        allPrintedBTNs.put(R.id.one_BTN, getResources().getString(R.string.oneText));
        allPrintedBTNs.put(R.id.two_BTN, getResources().getString(R.string.twoText));
        allPrintedBTNs.put(R.id.three_BTN, getResources().getString(R.string.threeText));
        allPrintedBTNs.put(R.id.four_BTN, getResources().getString(R.string.fourText));
        allPrintedBTNs.put(R.id.five_BTN, getResources().getString(R.string.fiveText));
        allPrintedBTNs.put(R.id.six_BTN, getResources().getString(R.string.sixText));
        allPrintedBTNs.put(R.id.seven_BTN, getResources().getString(R.string.sevenText));
        allPrintedBTNs.put(R.id.eight_BTN, getResources().getString(R.string.eightText));
        allPrintedBTNs.put(R.id.nine_BTN, getResources().getString(R.string.nineText));
        allPrintedBTNs.put(R.id.bracketsOpen_BTN, getResources().getString(R.string.bracketsOpen));
        allPrintedBTNs.put(R.id.bracketsClose_BTN, getResources().getString(R.string.bracketsClose));
        allPrintedBTNs.put(R.id.divide_BTN, getResources().getString(R.string.divideText));
        allPrintedBTNs.put(R.id.multiply_BTN, getResources().getString(R.string.multiplyText));
        allPrintedBTNs.put(R.id.minus_BTN, getResources().getString(R.string.minusText));
        allPrintedBTNs.put(R.id.plus_BTN, getResources().getString(R.string.plusText));
        allPrintedBTNs.put(R.id.point_BTN, getResources().getString(R.string.pointText));


        View.OnClickListener printedBTN_push = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(allPrintedBTNs.get(view.getId()));
            }
        };

        for (Map.Entry entry : allPrintedBTNs.entrySet()) {
            //Log.d("TAG", String.valueOf(entry));
            int j = (int) entry.getKey();
            findViewById(j).setOnClickListener(printedBTN_push);
        }


        findViewById(R.id.clear_BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
                previousCalculation.setText("");
            }
        });

        findViewById(R.id.backspace_BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPos = display.getSelectionStart();
                int textLen = display.getText().length();

                if (cursorPos != 0 && textLen != 0) {
                    SpannableStringBuilder selectedText = (SpannableStringBuilder) display.getText();
                    selectedText.replace(cursorPos - 1, cursorPos, "");
                    display.setText(selectedText);
                    display.setSelection(cursorPos - 1);
                }
            }
        });

        findViewById(R.id.equal_BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userExp = display.getText().toString();

                previousCalculation.setText(userExp);

                // add new library from https://mathparser.org/ for calculate expressions
                Expression exp = new Expression(userExp);
                String result = String.valueOf(exp.calculate());

                display.setText(result);
                display.setSelection(result.length());
            }
        });

    }
    // method for adding digits and operations into display
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
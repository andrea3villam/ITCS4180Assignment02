package com.example.assignment02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * ITCS 4180-080, Summer '26
 * Assignment 2
 * MainActivity
 * Andrea Villamarin
 * Debugged using Claude AI
 */
public class MainActivity extends AppCompatActivity {

    SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    TextView redValue, blueValue, greenValue, redRgbVal, greenRgbVal, blueRgbVal;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);

        redValue = findViewById(R.id.redValue);
        greenValue = findViewById(R.id.greenValue);
        blueValue = findViewById(R.id.blueValue);

        redRgbVal = findViewById(R.id.redRgbVal);
        greenRgbVal = findViewById(R.id.greenRgbVal);
        blueRgbVal = findViewById(R.id.blueRgbVal);

        resetButton = findViewById(R.id.resetButton);

        // RED SEEK BAR
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue.setText(String.valueOf(progress));
                redRgbVal.setText(String.valueOf(progress));
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        // GREEN SEEK BAR
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue.setText(String.valueOf(progress));
                greenRgbVal.setText(String.valueOf(progress));
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        // BLUE SEEK BAR
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue.setText(String.valueOf(progress));
                blueRgbVal.setText(String.valueOf(progress));
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        // WHITE BUTTON
        findViewById(R.id.whiteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redSeekBar.setProgress(255);
                greenSeekBar.setProgress(255);
                blueSeekBar.setProgress(255);

                redValue.setText("255");
                greenValue.setText("255");
                blueValue.setText("255");

                redRgbVal.setText("255");
                greenRgbVal.setText("255");
                blueRgbVal.setText("255");
                updateColors();
            }
        });

        // BLACK BUTTON
        findViewById(R.id.blackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redSeekBar.setProgress(0);
                greenSeekBar.setProgress(0);
                blueSeekBar.setProgress(0);

                redValue.setText("0");
                greenValue.setText("0");
                blueValue.setText("0");

                redRgbVal.setText("0");
                greenRgbVal.setText("0");
                blueRgbVal.setText("0");
                updateColors();
            }
        });

        // BLUE BUTTON
        findViewById(R.id.blueButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redSeekBar.setProgress(0);
                greenSeekBar.setProgress(0);
                blueSeekBar.setProgress(255);

                redValue.setText("0");
                greenValue.setText("0");
                blueValue.setText("255");

                redRgbVal.setText("0");
                greenRgbVal.setText("0");
                blueRgbVal.setText("255");
                updateColors();
            }
        });

        // RESET BUTTON
        findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redSeekBar.setProgress(64);
                greenSeekBar.setProgress(128);
                blueSeekBar.setProgress(0);

                redValue.setText("64");
                greenValue.setText("128");
                blueValue.setText("0");

                redRgbVal.setText("64");
                greenRgbVal.setText("128");
                blueRgbVal.setText("0");
                updateColors();
            }
        });
    }

    private void updateColors() {
        int red = redSeekBar.getProgress();
        int green = greenSeekBar.getProgress();
        int blue = blueSeekBar.getProgress();
        findViewById(R.id.colorView).setBackgroundColor(Color.rgb(red, green, blue));
        String hexString = String.format("#%02X%02X%02X", red, green, blue); // Formatting for HEX
        TextView hexVal = findViewById(R.id.colorHexOutput);
        hexVal.setText(hexString);
    }
}
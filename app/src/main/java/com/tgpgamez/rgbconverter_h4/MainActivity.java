package com.tgpgamez.rgbconverter_h4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ColorPresenter.View {

    SeekBar red_Seekbar, green_Seekbar, blue_Seekbar;
    ImageView imageView_hex_display;
    TextView textView_hex_display;
    Integer redVal = 0;
    Integer blueVal = 0;
    Integer greenVal = 0;

    ColorPresenter colorPresenter = new ColorPresenter(this);

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            switch (seekBar.getId()) {
                case R.id.red_seekbar:
                    colorPresenter.setRedValue(seekBar.getProgress());
                    break;
                case R.id.green_seekbar:
                    colorPresenter.setGreenValue(seekBar.getProgress());
                    break;
                case R.id.blue_seekbar:
                    colorPresenter.setBlueValue(seekBar.getProgress());
                    break;
            }
            textView_hex_display.setText(String.format("#%02x%02x%02x", redVal, greenVal, blueVal));
            imageView_hex_display.setBackgroundColor(Color.rgb(redVal,greenVal,blueVal));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red_Seekbar = findViewById(R.id.red_seekbar);
        green_Seekbar = findViewById(R.id.green_seekbar);
        blue_Seekbar = findViewById(R.id.blue_seekbar);

        imageView_hex_display = findViewById(R.id.imageView_hex_display);
        textView_hex_display = findViewById(R.id.textView_hex_display);

        imageView_hex_display.setBackgroundColor(Color.rgb(redVal, greenVal, blueVal));

        red_Seekbar.setOnSeekBarChangeListener(seekBarChangeListener);
        green_Seekbar.setOnSeekBarChangeListener(seekBarChangeListener);
        blue_Seekbar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    @Override
    public void redValueAdded(Integer newRedValue) {
        redVal = newRedValue;
    }

    @Override
    public void greenValueAdded(Integer newGreenValue) {
        greenVal = newGreenValue;
    }

    @Override
    public void blueValueAdded(Integer newblueValue) {
        blueVal = newblueValue;
    }
}
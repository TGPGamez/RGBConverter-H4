package com.tgpgamez.rgbconverter_h4;

import android.view.View;

public class ColorPresenter {
    Color color;
    View view;

    public ColorPresenter(View view) {
        color = new Color();
        this.view = view;
    }

    public void setRedValue(Integer value) {
        color.setRed(value);
        view.redValueAdded(color.getRed());
    }
    public void setGreenValue(Integer value) {
        color.setGreen(value);
        view.greenValueAdded(color.getGreen());
    }
    public void setBlueValue(Integer value) {
        color.setBlue(value);
        view.blueValueAdded(color.getBlue());
    }

    public interface View {
        public void redValueAdded(Integer newRedValue);
        public void greenValueAdded(Integer newGreenValue);
        public void blueValueAdded(Integer newblueValue);
    }
}

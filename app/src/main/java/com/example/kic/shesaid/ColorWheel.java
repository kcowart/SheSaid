package com.example.kic.shesaid;

import android.graphics.Color;
import java.util.Random;

public class ColorWheel {
    //Fields (member variables)-properties
    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#f092b0", // pink
    };

    //Methods-actions
    public int getColor() {
        String color;
        //Randomly select a fact
        Random randomGen = new Random();
        int randNum = randomGen.nextInt(mColors.length);
        color = mColors[randNum];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}

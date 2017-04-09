package com.mapfap.minimalface;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import org.w3c.dom.Text;

/**
 * Created by mapfap on 4/8/2017 AD.
 */

class TextElement {
    private Paint paint;
    private float xOffset;
    private float yOffset;
    private boolean invert;


    public TextElement(float textSize, float xOffset, float yOffset) {
        this(textSize, xOffset, yOffset, false);
    }

    public TextElement(float textSize, float xOffset, float yOffset, boolean invert) {
        paint = new Paint();
        paint.setTextSize(textSize);
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.invert = invert;
    }

    public void setAntiAlias(boolean antiAlias) {
        paint.setAntiAlias(antiAlias);
    }

    public void inAmbient(Resources resources) {
        if (invert) {
            paint.setColor(resources.getColor(R.color.ink));
        } else {
            paint.setColor(resources.getColor(R.color.background));
        }
    }

    public void notInAmbient(Resources resources) {
        if (invert) {
            paint.setColor(resources.getColor(R.color.background));
        } else {
            paint.setColor(resources.getColor(R.color.ink));
        }
    }

    public void drawOn(Canvas canvas, String text) {
        canvas.drawText(text, xOffset, yOffset, paint);
    }
}

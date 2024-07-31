package com.baidu.idl.face.platform.p049ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: com.baidu.idl.face.platform.ui.view.AlignTextView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AlignTextView extends TextView {
    private int mLineY;
    private int mViewWidth;

    public AlignTextView(Context context) {
        super(context);
    }

    private void drawScaledText(Canvas canvas, String str, float f) {
        float f2 = 0.0f;
        if (isFirstLineOfParagraph(str)) {
            canvas.drawText("  ", 0.0f, this.mLineY, getPaint());
            f2 = 0.0f + StaticLayout.getDesiredWidth("  ", getPaint());
            str = str.substring(3);
        }
        int length = str.length() - 1;
        int i = 2;
        if (str.length() > 2 && str.charAt(0) == 12288 && str.charAt(1) == 12288) {
            String substring = str.substring(0, 2);
            float desiredWidth = StaticLayout.getDesiredWidth(substring, getPaint());
            canvas.drawText(substring, f2, this.mLineY, getPaint());
            f2 += desiredWidth;
        } else {
            i = 0;
        }
        float f3 = (this.mViewWidth - f) / length;
        while (i < str.length()) {
            String valueOf = String.valueOf(str.charAt(i));
            float desiredWidth2 = StaticLayout.getDesiredWidth(valueOf, getPaint());
            canvas.drawText(valueOf, f2, this.mLineY, getPaint());
            f2 += desiredWidth2 + f3;
            i++;
        }
    }

    private boolean isFirstLineOfParagraph(String str) {
        return str.length() > 3 && str.charAt(0) == ' ' && str.charAt(1) == ' ';
    }

    private boolean needScale(String str) {
        return (str.length() == 0 || str.charAt(str.length() - 1) == '\n') ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.mViewWidth = getMeasuredWidth();
        String charSequence = getText().toString();
        this.mLineY = 0;
        this.mLineY = (int) (0 + getTextSize());
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = (int) ((((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) * layout.getSpacingMultiplier()) + layout.getSpacingAdd());
        for (int i = 0; i < layout.getLineCount(); i++) {
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            float desiredWidth = StaticLayout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
            String substring = charSequence.substring(lineStart, lineEnd);
            if (substring.equals("")) {
                return;
            }
            if (i < layout.getLineCount() - 1) {
                if (needScale(substring)) {
                    drawScaledText(canvas, substring, desiredWidth);
                } else {
                    canvas.drawText(substring, 0.0f, this.mLineY, paint);
                }
            } else {
                canvas.drawText(substring, 0.0f, this.mLineY, paint);
            }
            this.mLineY += ceil;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

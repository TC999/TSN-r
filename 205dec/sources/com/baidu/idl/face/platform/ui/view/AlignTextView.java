package com.baidu.idl.face.platform.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AlignTextView extends TextView {
    private int mLineY;
    private int mViewWidth;

    public AlignTextView(Context context) {
        super(context);
    }

    private void drawScaledText(Canvas canvas, String str, float f4) {
        float f5 = 0.0f;
        if (isFirstLineOfParagraph(str)) {
            canvas.drawText("  ", 0.0f, this.mLineY, getPaint());
            f5 = 0.0f + StaticLayout.getDesiredWidth("  ", getPaint());
            str = str.substring(3);
        }
        int length = str.length() - 1;
        int i4 = 2;
        if (str.length() > 2 && str.charAt(0) == '\u3000' && str.charAt(1) == '\u3000') {
            String substring = str.substring(0, 2);
            float desiredWidth = StaticLayout.getDesiredWidth(substring, getPaint());
            canvas.drawText(substring, f5, this.mLineY, getPaint());
            f5 += desiredWidth;
        } else {
            i4 = 0;
        }
        float f6 = (this.mViewWidth - f4) / length;
        while (i4 < str.length()) {
            String valueOf = String.valueOf(str.charAt(i4));
            float desiredWidth2 = StaticLayout.getDesiredWidth(valueOf, getPaint());
            canvas.drawText(valueOf, f5, this.mLineY, getPaint());
            f5 += desiredWidth2 + f6;
            i4++;
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
        for (int i4 = 0; i4 < layout.getLineCount(); i4++) {
            int lineStart = layout.getLineStart(i4);
            int lineEnd = layout.getLineEnd(i4);
            float desiredWidth = StaticLayout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
            String substring = charSequence.substring(lineStart, lineEnd);
            if (substring.equals("")) {
                return;
            }
            if (i4 < layout.getLineCount() - 1) {
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
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

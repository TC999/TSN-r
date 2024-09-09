package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class UnderLineTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private Rect f18835a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f18836b;

    /* renamed from: c  reason: collision with root package name */
    private int f18837c;

    /* renamed from: d  reason: collision with root package name */
    private float f18838d;

    /* renamed from: e  reason: collision with root package name */
    private float f18839e;

    /* renamed from: f  reason: collision with root package name */
    private float f18840f;

    public UnderLineTextView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i4) {
        this.f18840f = u.a(1.0f, context);
        this.f18838d = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, i4, 0);
        this.f18837c = obtainStyledAttributes.getColor(R.styleable.UnderlinedTextView_underlineColor, -65536);
        this.f18839e = obtainStyledAttributes.getDimension(R.styleable.UnderlinedTextView_underlineWidth, this.f18838d * 2.0f);
        obtainStyledAttributes.recycle();
        this.f18835a = new Rect();
        Paint paint = new Paint();
        this.f18836b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18836b.setColor(this.f18837c);
        this.f18836b.setStrokeWidth(this.f18839e);
    }

    public int getUnderLineColor() {
        return this.f18837c;
    }

    public float getUnderlineWidth() {
        return this.f18839e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i4 = 0; i4 < lineCount; i4++) {
            int lineBounds = getLineBounds(i4, this.f18835a);
            int lineStart = layout.getLineStart(i4);
            int lineEnd = layout.getLineEnd(i4);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f4 = lineBounds;
            float f5 = this.f18839e;
            float f6 = this.f18840f;
            canvas.drawLine(primaryHorizontal, f4 + f5 + f6, primaryHorizontal2, f4 + f5 + f6, this.f18836b);
        }
        super.onDraw(canvas);
    }

    public void setUnderLineColor(int i4) {
        this.f18837c = i4;
        invalidate();
    }

    public void setUnderlineWidth(float f4) {
        this.f18839e = f4;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet, i4);
    }
}

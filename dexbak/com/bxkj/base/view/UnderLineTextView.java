package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.C3801R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class UnderLineTextView extends AppCompatTextView {

    /* renamed from: a */
    private Rect f15265a;

    /* renamed from: b */
    private Paint f15266b;

    /* renamed from: c */
    private int f15267c;

    /* renamed from: d */
    private float f15268d;

    /* renamed from: e */
    private float f15269e;

    /* renamed from: f */
    private float f15270f;

    public UnderLineTextView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.f15270f = Tools.m57620a(1.0f, context);
        this.f15268d = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3801R.styleable.UnderlinedTextView, i, 0);
        this.f15267c = obtainStyledAttributes.getColor(C3801R.styleable.UnderlinedTextView_underlineColor, SupportMenu.CATEGORY_MASK);
        this.f15269e = obtainStyledAttributes.getDimension(C3801R.styleable.UnderlinedTextView_underlineWidth, this.f15268d * 2.0f);
        obtainStyledAttributes.recycle();
        this.f15265a = new Rect();
        Paint paint = new Paint();
        this.f15266b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f15266b.setColor(this.f15267c);
        this.f15266b.setStrokeWidth(this.f15269e);
    }

    public int getUnderLineColor() {
        return this.f15267c;
    }

    public float getUnderlineWidth() {
        return this.f15269e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i = 0; i < lineCount; i++) {
            int lineBounds = getLineBounds(i, this.f15265a);
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            float f = lineBounds;
            float f2 = this.f15269e;
            float f3 = this.f15270f;
            canvas.drawLine(primaryHorizontal, f + f2 + f3, primaryHorizontal2, f + f2 + f3, this.f15266b);
        }
        super.onDraw(canvas);
    }

    public void setUnderLineColor(int i) {
        this.f15267c = i;
        invalidate();
    }

    public void setUnderlineWidth(float f) {
        this.f15269e = f;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}

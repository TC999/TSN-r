package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.map3d.C2241R;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DownloadProgressView extends View {

    /* renamed from: a */
    private String f7094a;

    /* renamed from: b */
    private int f7095b;

    /* renamed from: c */
    private int f7096c;

    /* renamed from: d */
    private float f7097d;

    /* renamed from: e */
    private float f7098e;

    /* renamed from: f */
    private TextPaint f7099f;

    /* renamed from: g */
    private TextPaint f7100g;

    /* renamed from: h */
    private float f7101h;

    /* renamed from: i */
    private float f7102i;

    public DownloadProgressView(Context context) {
        super(context);
        this.f7095b = SupportMenu.CATEGORY_MASK;
        this.f7096c = SupportMenu.CATEGORY_MASK;
        this.f7097d = 0.0f;
        this.f7098e = 0.6f;
        m51999a(null, 0);
    }

    /* renamed from: a */
    private void m51999a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2241R.styleable.f6976a, i, 0);
        this.f7094a = obtainStyledAttributes.getString(0);
        this.f7095b = obtainStyledAttributes.getColor(3, this.f7095b);
        this.f7097d = obtainStyledAttributes.getDimension(1, this.f7097d);
        this.f7096c = obtainStyledAttributes.getColor(2, this.f7096c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f7099f = textPaint;
        textPaint.setFlags(1);
        this.f7099f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f7100g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        m52000a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        double d = height * 0.8f;
        float width = (getWidth() - paddingLeft) - paddingRight;
        Double.isNaN(d);
        canvas.drawRect(new Rect(0, (int) d, (int) (width * this.f7098e), height), this.f7100g);
        canvas.drawText(String.valueOf((int) (this.f7098e * 100.0f)) + "%", (int) (this.f7098e * width), (int) (d - 3.0d), this.f7099f);
    }

    public void setProgress(int i) {
        if (i > 100 || i < 0) {
            return;
        }
        this.f7098e = i / 100.0f;
        invalidate();
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7095b = SupportMenu.CATEGORY_MASK;
        this.f7096c = SupportMenu.CATEGORY_MASK;
        this.f7097d = 0.0f;
        this.f7098e = 0.6f;
        m51999a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7095b = SupportMenu.CATEGORY_MASK;
        this.f7096c = SupportMenu.CATEGORY_MASK;
        this.f7097d = 0.0f;
        this.f7098e = 0.6f;
        m51999a(attributeSet, i);
    }

    /* renamed from: a */
    private void m52000a() {
        this.f7099f.setTextSize(this.f7097d);
        this.f7099f.setColor(this.f7095b);
        this.f7100g.setColor(this.f7096c);
        this.f7101h = this.f7099f.measureText(this.f7094a);
        this.f7102i = this.f7099f.getFontMetrics().bottom;
    }
}

package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.map3d.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DownloadProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f10792a;

    /* renamed from: b  reason: collision with root package name */
    private int f10793b;

    /* renamed from: c  reason: collision with root package name */
    private int f10794c;

    /* renamed from: d  reason: collision with root package name */
    private float f10795d;

    /* renamed from: e  reason: collision with root package name */
    private float f10796e;

    /* renamed from: f  reason: collision with root package name */
    private TextPaint f10797f;

    /* renamed from: g  reason: collision with root package name */
    private TextPaint f10798g;

    /* renamed from: h  reason: collision with root package name */
    private float f10799h;

    /* renamed from: i  reason: collision with root package name */
    private float f10800i;

    public DownloadProgressView(Context context) {
        super(context);
        this.f10793b = -65536;
        this.f10794c = -65536;
        this.f10795d = 0.0f;
        this.f10796e = 0.6f;
        a(null, 0);
    }

    private void a(AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f10680a, i4, 0);
        this.f10792a = obtainStyledAttributes.getString(0);
        this.f10793b = obtainStyledAttributes.getColor(3, this.f10793b);
        this.f10795d = obtainStyledAttributes.getDimension(1, this.f10795d);
        this.f10794c = obtainStyledAttributes.getColor(2, this.f10794c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f10797f = textPaint;
        textPaint.setFlags(1);
        this.f10797f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f10798g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        double d4 = height * 0.8f;
        float width = (getWidth() - paddingLeft) - paddingRight;
        Double.isNaN(d4);
        canvas.drawRect(new Rect(0, (int) d4, (int) (width * this.f10796e), height), this.f10798g);
        canvas.drawText(String.valueOf((int) (this.f10796e * 100.0f)) + "%", (int) (this.f10796e * width), (int) (d4 - 3.0d), this.f10797f);
    }

    public void setProgress(int i4) {
        if (i4 > 100 || i4 < 0) {
            return;
        }
        this.f10796e = i4 / 100.0f;
        invalidate();
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10793b = -65536;
        this.f10794c = -65536;
        this.f10795d = 0.0f;
        this.f10796e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f10793b = -65536;
        this.f10794c = -65536;
        this.f10795d = 0.0f;
        this.f10796e = 0.6f;
        a(attributeSet, i4);
    }

    private void a() {
        this.f10797f.setTextSize(this.f10795d);
        this.f10797f.setColor(this.f10793b);
        this.f10798g.setColor(this.f10794c);
        this.f10799h = this.f10797f.measureText(this.f10792a);
        this.f10800i = this.f10797f.getFontMetrics().bottom;
    }
}

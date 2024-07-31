package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ClipView extends View {

    /* renamed from: a */
    private Paint f16137a;

    /* renamed from: b */
    private Paint f16138b;

    /* renamed from: c */
    private float f16139c;

    /* renamed from: d */
    private int f16140d;

    /* renamed from: e */
    private int f16141e;

    /* renamed from: f */
    private int f16142f;

    /* renamed from: g */
    private int f16143g;

    /* renamed from: h */
    private ClipType f16144h;

    /* renamed from: i */
    private Xfermode f16145i;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public enum ClipType {
        CIRCLE,
        RECTANGLE
    }

    public ClipView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static int m42927b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: a */
    public int m42928a(float size, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = size * displayMetrics.density;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    public Rect getClipRect() {
        Rect rect = new Rect();
        rect.left = (getWidth() / 2) - (this.f16142f / 2);
        rect.right = (getWidth() / 2) + (this.f16142f / 2);
        rect.top = (getHeight() / 2) - (this.f16143g / 2);
        rect.bottom = (getHeight() / 2) + (this.f16143g / 2);
        return rect;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(Color.parseColor("#a8000000"));
        this.f16137a.setXfermode(this.f16145i);
        ClipType clipType = this.f16144h;
        if (clipType == ClipType.CIRCLE) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f16141e, this.f16137a);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f16141e, this.f16138b);
        } else if (clipType == ClipType.RECTANGLE) {
            canvas.drawRect((getWidth() / 2) - (this.f16142f / 2), (getHeight() / 2) - (this.f16143g / 2), (getWidth() / 2) + (this.f16142f / 2), (getHeight() / 2) + (this.f16143g / 2), this.f16137a);
            canvas.drawRect((getWidth() / 2) - (this.f16142f / 2), (getHeight() / 2) - (this.f16143g / 2), (getWidth() / 2) + (this.f16142f / 2), (getHeight() / 2) + (this.f16143g / 2), this.f16138b);
        }
        canvas.restore();
    }

    public void setClipBorderWidth(int clipBorderWidth) {
        this.f16140d = clipBorderWidth;
        this.f16138b.setStrokeWidth(clipBorderWidth);
        invalidate();
    }

    public void setClipType(ClipType clipType) {
        this.f16144h = clipType;
    }

    public void setmHorizontalPadding(float mHorizontalPadding) {
        this.f16139c = mHorizontalPadding;
        this.f16141e = ((int) (m42927b(getContext()) - (mHorizontalPadding * 2.0f))) / 2;
        this.f16142f = m42928a(295.0f, getContext());
        this.f16143g = m42928a(413.0f, getContext());
    }

    public ClipView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f16137a = new Paint();
        this.f16138b = new Paint();
        this.f16144h = ClipType.CIRCLE;
        this.f16137a.setAntiAlias(true);
        this.f16138b.setStyle(Paint.Style.STROKE);
        this.f16138b.setColor(-1);
        this.f16138b.setStrokeWidth(this.f16140d);
        this.f16138b.setAntiAlias(true);
        this.f16145i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
}

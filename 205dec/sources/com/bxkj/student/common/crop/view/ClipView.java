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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ClipView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f19532a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f19533b;

    /* renamed from: c  reason: collision with root package name */
    private float f19534c;

    /* renamed from: d  reason: collision with root package name */
    private int f19535d;

    /* renamed from: e  reason: collision with root package name */
    private int f19536e;

    /* renamed from: f  reason: collision with root package name */
    private int f19537f;

    /* renamed from: g  reason: collision with root package name */
    private int f19538g;

    /* renamed from: h  reason: collision with root package name */
    private ClipType f19539h;

    /* renamed from: i  reason: collision with root package name */
    private Xfermode f19540i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public enum ClipType {
        CIRCLE,
        RECTANGLE
    }

    public ClipView(Context context) {
        this(context, null);
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int a(float size, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d4 = size * displayMetrics.density;
        Double.isNaN(d4);
        return (int) (d4 + 0.5d);
    }

    public Rect getClipRect() {
        Rect rect = new Rect();
        rect.left = (getWidth() / 2) - (this.f19537f / 2);
        rect.right = (getWidth() / 2) + (this.f19537f / 2);
        rect.top = (getHeight() / 2) - (this.f19538g / 2);
        rect.bottom = (getHeight() / 2) + (this.f19538g / 2);
        return rect;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(Color.parseColor("#a8000000"));
        this.f19532a.setXfermode(this.f19540i);
        ClipType clipType = this.f19539h;
        if (clipType == ClipType.CIRCLE) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f19536e, this.f19532a);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f19536e, this.f19533b);
        } else if (clipType == ClipType.RECTANGLE) {
            canvas.drawRect((getWidth() / 2) - (this.f19537f / 2), (getHeight() / 2) - (this.f19538g / 2), (getWidth() / 2) + (this.f19537f / 2), (getHeight() / 2) + (this.f19538g / 2), this.f19532a);
            canvas.drawRect((getWidth() / 2) - (this.f19537f / 2), (getHeight() / 2) - (this.f19538g / 2), (getWidth() / 2) + (this.f19537f / 2), (getHeight() / 2) + (this.f19538g / 2), this.f19533b);
        }
        canvas.restore();
    }

    public void setClipBorderWidth(int clipBorderWidth) {
        this.f19535d = clipBorderWidth;
        this.f19533b.setStrokeWidth(clipBorderWidth);
        invalidate();
    }

    public void setClipType(ClipType clipType) {
        this.f19539h = clipType;
    }

    public void setmHorizontalPadding(float mHorizontalPadding) {
        this.f19534c = mHorizontalPadding;
        this.f19536e = ((int) (b(getContext()) - (mHorizontalPadding * 2.0f))) / 2;
        this.f19537f = a(295.0f, getContext());
        this.f19538g = a(413.0f, getContext());
    }

    public ClipView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f19532a = new Paint();
        this.f19533b = new Paint();
        this.f19539h = ClipType.CIRCLE;
        this.f19532a.setAntiAlias(true);
        this.f19533b.setStyle(Paint.Style.STROKE);
        this.f19533b.setColor(-1);
        this.f19533b.setStrokeWidth(this.f19535d);
        this.f19533b.setAntiAlias(true);
        this.f19540i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
}

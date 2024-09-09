package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.acse.ottn.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ActivityIndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f6938a;

    /* renamed from: b  reason: collision with root package name */
    public int f6939b;

    /* renamed from: c  reason: collision with root package name */
    public float f6940c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6941d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6942e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6943f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6944g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f6945h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f6946i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f6947j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f6948k;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityIndicatorView.a(ActivityIndicatorView.this, 30);
            ActivityIndicatorView.this.invalidate();
            ActivityIndicatorView.this.f6947j.postDelayed(ActivityIndicatorView.this.f6948k, 100L);
        }
    }

    public ActivityIndicatorView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int a(ActivityIndicatorView activityIndicatorView, int i4) {
        int i5 = activityIndicatorView.f6939b + i4;
        activityIndicatorView.f6939b = i5;
        return i5;
    }

    public void c() {
        this.f6947j.removeCallbacks(this.f6948k);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6941d) {
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6947j != null) {
            c();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.f6940c == 0.0f) {
            this.f6940c = a(15, min / 2.0f) / 2.0f;
        }
        this.f6946i.setStrokeWidth(this.f6940c);
        int i4 = 0;
        while (true) {
            int[] iArr = this.f6945h;
            if (i4 >= iArr.length) {
                return;
            }
            this.f6946i.setColor(iArr[i4]);
            float f4 = width;
            int i5 = i4 * (-30);
            float f5 = min / 2.0f;
            float f6 = height;
            canvas.drawLine(f4 + a(this.f6939b + i5, f5), f6 + b(this.f6939b + i5, f5), f4 + a(this.f6939b + i5, min - (this.f6940c / 2.0f)), f6 + b(i5 + this.f6939b, min - (this.f6940c / 2.0f)), this.f6946i);
            i4++;
        }
    }

    public void setColor(int i4) {
        this.f6938a = i4;
    }

    public void setStartAngle(int i4) {
        this.f6939b = i4;
    }

    public void setStrokeWidth(float f4) {
        this.f6940c = f4;
    }

    public ActivityIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final float b(int i4, float f4) {
        double d4 = f4;
        double d5 = i4;
        Double.isNaN(d5);
        double sin = Math.sin((d5 * 3.141592653589793d) / 180.0d);
        Double.isNaN(d4);
        return (float) (d4 * sin);
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6938a = Color.argb(255, 255, 255, 255);
        this.f6939b = 0;
        this.f6940c = 0.0f;
        this.f6942e = 12;
        this.f6943f = 0;
        this.f6944g = 30;
        this.f6945h = new int[12];
        this.f6947j = new Handler(Looper.getMainLooper());
        this.f6948k = new a();
        a(context, attributeSet, i4, 0);
    }

    public final void a(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityIndicatorView, i4, i5);
        this.f6938a = obtainStyledAttributes.getColor(R.styleable.ActivityIndicatorView_aiv_color, this.f6938a);
        this.f6939b = obtainStyledAttributes.getInt(R.styleable.ActivityIndicatorView_aiv_startAngle, this.f6939b);
        this.f6940c = obtainStyledAttributes.getDimension(R.styleable.ActivityIndicatorView_aiv_strokeWidth, this.f6940c);
        this.f6941d = obtainStyledAttributes.getBoolean(R.styleable.ActivityIndicatorView_aiv_auto_start, true);
        obtainStyledAttributes.recycle();
        a();
    }

    public void b() {
        this.f6947j.post(this.f6948k);
    }

    public final void a() {
        this.f6946i = new Paint(1);
        int alpha = Color.alpha(this.f6938a);
        int red = Color.red(this.f6938a);
        int green = Color.green(this.f6938a);
        int blue = Color.blue(this.f6938a);
        int abs = Math.abs(alpha + 0) / 12;
        int i4 = 0;
        while (true) {
            int[] iArr = this.f6945h;
            if (i4 < iArr.length) {
                iArr[i4] = Color.argb(alpha - (abs * i4), red, green, blue);
                i4++;
            } else {
                this.f6946i.setStrokeCap(Paint.Cap.ROUND);
                return;
            }
        }
    }

    public final float a(int i4, float f4) {
        double d4 = f4;
        double d5 = i4;
        Double.isNaN(d5);
        double cos = Math.cos((d5 * 3.141592653589793d) / 180.0d);
        Double.isNaN(d4);
        return (float) (d4 * cos);
    }
}

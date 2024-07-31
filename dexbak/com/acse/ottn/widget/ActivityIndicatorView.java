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
import com.acse.ottn.C1239R;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ActivityIndicatorView extends View {

    /* renamed from: a */
    private int f3394a;

    /* renamed from: b */
    private int f3395b;

    /* renamed from: c */
    private float f3396c;

    /* renamed from: d */
    private boolean f3397d;

    /* renamed from: e */
    private final int f3398e;

    /* renamed from: f */
    private final int f3399f;

    /* renamed from: g */
    private final int f3400g;

    /* renamed from: h */
    private int[] f3401h;

    /* renamed from: i */
    private Paint f3402i;

    /* renamed from: j */
    private Handler f3403j;

    /* renamed from: k */
    private Runnable f3404k;

    public ActivityIndicatorView(Context context) {
        this(context, null);
    }

    public ActivityIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3394a = Color.argb(255, 255, 255, 255);
        this.f3395b = 0;
        this.f3396c = 0.0f;
        this.f3398e = 12;
        this.f3399f = 0;
        this.f3400g = 30;
        this.f3401h = new int[12];
        this.f3403j = new Handler(Looper.getMainLooper());
        this.f3404k = new RunnableC1715a(this);
        m55866a(context, attributeSet, i, 0);
    }

    /* renamed from: a */
    private float m55867a(int i, float f) {
        double d = f;
        double d2 = i;
        Double.isNaN(d2);
        double cos = Math.cos((d2 * 3.141592653589793d) / 180.0d);
        Double.isNaN(d);
        return (float) (d * cos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m55864a(ActivityIndicatorView activityIndicatorView, int i) {
        int i2 = activityIndicatorView.f3395b + i;
        activityIndicatorView.f3395b = i2;
        return i2;
    }

    /* renamed from: a */
    private void m55866a(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1239R.styleable.ActivityIndicatorView, i, i2);
        this.f3394a = obtainStyledAttributes.getColor(C1239R.styleable.ActivityIndicatorView_aiv_color, this.f3394a);
        this.f3395b = obtainStyledAttributes.getInt(C1239R.styleable.ActivityIndicatorView_aiv_startAngle, this.f3395b);
        this.f3396c = obtainStyledAttributes.getDimension(C1239R.styleable.ActivityIndicatorView_aiv_strokeWidth, this.f3396c);
        this.f3397d = obtainStyledAttributes.getBoolean(C1239R.styleable.ActivityIndicatorView_aiv_auto_start, true);
        obtainStyledAttributes.recycle();
        m55860c();
    }

    /* renamed from: b */
    private float m55862b(int i, float f) {
        double d = f;
        double d2 = i;
        Double.isNaN(d2);
        double sin = Math.sin((d2 * 3.141592653589793d) / 180.0d);
        Double.isNaN(d);
        return (float) (d * sin);
    }

    /* renamed from: c */
    private void m55860c() {
        this.f3402i = new Paint(1);
        int alpha = Color.alpha(this.f3394a);
        int red = Color.red(this.f3394a);
        int green = Color.green(this.f3394a);
        int blue = Color.blue(this.f3394a);
        int abs = Math.abs(alpha + 0) / 12;
        int i = 0;
        while (true) {
            int[] iArr = this.f3401h;
            if (i >= iArr.length) {
                this.f3402i.setStrokeCap(Paint.Cap.ROUND);
                return;
            } else {
                iArr[i] = Color.argb(alpha - (abs * i), red, green, blue);
                i++;
            }
        }
    }

    /* renamed from: a */
    public void m55868a() {
        this.f3403j.post(this.f3404k);
    }

    /* renamed from: b */
    public void m55863b() {
        this.f3403j.removeCallbacks(this.f3404k);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3397d) {
            m55868a();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3403j != null) {
            m55863b();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        if (this.f3396c == 0.0f) {
            this.f3396c = m55867a(15, min / 2.0f) / 2.0f;
        }
        this.f3402i.setStrokeWidth(this.f3396c);
        int i = 0;
        while (true) {
            int[] iArr = this.f3401h;
            if (i >= iArr.length) {
                return;
            }
            this.f3402i.setColor(iArr[i]);
            float f = width;
            int i2 = i * (-30);
            float f2 = min / 2.0f;
            float f3 = height;
            canvas.drawLine(f + m55867a(this.f3395b + i2, f2), f3 + m55862b(this.f3395b + i2, f2), f + m55867a(this.f3395b + i2, min - (this.f3396c / 2.0f)), f3 + m55862b(i2 + this.f3395b, min - (this.f3396c / 2.0f)), this.f3402i);
            i++;
        }
    }

    public void setColor(int i) {
        this.f3394a = i;
    }

    public void setStartAngle(int i) {
        this.f3395b = i;
    }

    public void setStrokeWidth(float f) {
        this.f3396c = f;
    }
}

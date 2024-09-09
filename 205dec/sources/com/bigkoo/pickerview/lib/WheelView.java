package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bigkoo.pickerview.R;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class WheelView extends View {
    private static final int S = 5;
    private static final float T = 0.8f;
    int A;
    int B;
    private int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    private int K;

    /* renamed from: L  reason: collision with root package name */
    private float f16273L;
    long M;
    int N;
    private int O;
    private int P;
    private int Q;
    private float R;

    /* renamed from: a  reason: collision with root package name */
    private DividerType f16274a;

    /* renamed from: b  reason: collision with root package name */
    Context f16275b;

    /* renamed from: c  reason: collision with root package name */
    Handler f16276c;

    /* renamed from: d  reason: collision with root package name */
    private GestureDetector f16277d;

    /* renamed from: e  reason: collision with root package name */
    i.c f16278e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16279f;

    /* renamed from: g  reason: collision with root package name */
    ScheduledExecutorService f16280g;

    /* renamed from: h  reason: collision with root package name */
    private ScheduledFuture<?> f16281h;

    /* renamed from: i  reason: collision with root package name */
    Paint f16282i;

    /* renamed from: j  reason: collision with root package name */
    Paint f16283j;

    /* renamed from: k  reason: collision with root package name */
    Paint f16284k;

    /* renamed from: l  reason: collision with root package name */
    h.c f16285l;

    /* renamed from: m  reason: collision with root package name */
    private String f16286m;

    /* renamed from: n  reason: collision with root package name */
    int f16287n;

    /* renamed from: o  reason: collision with root package name */
    int f16288o;

    /* renamed from: p  reason: collision with root package name */
    int f16289p;

    /* renamed from: q  reason: collision with root package name */
    float f16290q;

    /* renamed from: r  reason: collision with root package name */
    Typeface f16291r;

    /* renamed from: s  reason: collision with root package name */
    int f16292s;

    /* renamed from: t  reason: collision with root package name */
    int f16293t;

    /* renamed from: u  reason: collision with root package name */
    int f16294u;

    /* renamed from: v  reason: collision with root package name */
    float f16295v;

    /* renamed from: w  reason: collision with root package name */
    boolean f16296w;

    /* renamed from: x  reason: collision with root package name */
    float f16297x;

    /* renamed from: y  reason: collision with root package name */
    float f16298y;

    /* renamed from: z  reason: collision with root package name */
    float f16299z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private String b(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof j.a) {
            return ((j.a) obj).a();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private int c(int i4) {
        if (i4 < 0) {
            return c(i4 + this.f16285l.a());
        }
        return i4 > this.f16285l.a() + (-1) ? c(i4 - this.f16285l.a()) : i4;
    }

    private void e(Context context) {
        this.f16275b = context;
        this.f16276c = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.f16277d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f16296w = true;
        this.A = 0;
        this.B = -1;
        f();
    }

    private void f() {
        Paint paint = new Paint();
        this.f16282i = paint;
        paint.setColor(this.f16292s);
        this.f16282i.setAntiAlias(true);
        this.f16282i.setTypeface(this.f16291r);
        this.f16282i.setTextSize(this.f16287n);
        Paint paint2 = new Paint();
        this.f16283j = paint2;
        paint2.setColor(this.f16293t);
        this.f16283j.setAntiAlias(true);
        this.f16283j.setTextScaleX(1.1f);
        this.f16283j.setTypeface(this.f16291r);
        this.f16283j.setTextSize(this.f16287n);
        Paint paint3 = new Paint();
        this.f16284k = paint3;
        paint3.setColor(this.f16294u);
        this.f16284k.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void g() {
        float f4 = this.f16295v;
        if (f4 < 1.2f) {
            this.f16295v = 1.2f;
        } else if (f4 > 2.0f) {
            this.f16295v = 2.0f;
        }
    }

    private void h() {
        Rect rect = new Rect();
        for (int i4 = 0; i4 < this.f16285l.a(); i4++) {
            String b4 = b(this.f16285l.getItem(i4));
            this.f16283j.getTextBounds(b4, 0, b4.length(), rect);
            int width = rect.width();
            if (width > this.f16288o) {
                this.f16288o = width;
            }
            this.f16283j.getTextBounds("\u661f\u671f", 0, 2, rect);
            this.f16289p = rect.height() + 2;
        }
        this.f16290q = this.f16295v * this.f16289p;
    }

    private void i(String str) {
        String str2;
        Rect rect = new Rect();
        this.f16283j.getTextBounds(str, 0, str.length(), rect);
        int i4 = this.O;
        if (i4 == 3) {
            this.P = 0;
        } else if (i4 == 5) {
            this.P = (this.H - rect.width()) - ((int) this.R);
        } else if (i4 != 17) {
        } else {
            if (!this.f16279f && (str2 = this.f16286m) != null && !str2.equals("")) {
                double width = this.H - rect.width();
                Double.isNaN(width);
                this.P = (int) (width * 0.25d);
                return;
            }
            double width2 = this.H - rect.width();
            Double.isNaN(width2);
            this.P = (int) (width2 * 0.5d);
        }
    }

    private void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.f16282i.getTextBounds(str, 0, str.length(), rect);
        int i4 = this.O;
        if (i4 == 3) {
            this.Q = 0;
        } else if (i4 == 5) {
            this.Q = (this.H - rect.width()) - ((int) this.R);
        } else if (i4 != 17) {
        } else {
            if (!this.f16279f && (str2 = this.f16286m) != null && !str2.equals("")) {
                double width = this.H - rect.width();
                Double.isNaN(width);
                this.Q = (int) (width * 0.25d);
                return;
            }
            double width2 = this.H - rect.width();
            Double.isNaN(width2);
            this.Q = (int) (width2 * 0.5d);
        }
    }

    private void l(String str) {
        Rect rect = new Rect();
        this.f16283j.getTextBounds(str, 0, str.length(), rect);
        int i4 = this.f16287n;
        for (int width = rect.width(); width > this.H; width = rect.width()) {
            i4--;
            this.f16283j.setTextSize(i4);
            this.f16283j.getTextBounds(str, 0, str.length(), rect);
        }
        this.f16282i.setTextSize(i4);
    }

    private void m() {
        if (this.f16285l == null) {
            return;
        }
        h();
        int i4 = (int) (this.f16290q * (this.F - 1));
        this.I = i4;
        double d4 = i4 * 2;
        Double.isNaN(d4);
        this.G = (int) (d4 / 3.141592653589793d);
        double d5 = i4;
        Double.isNaN(d5);
        this.J = (int) (d5 / 3.141592653589793d);
        this.H = View.MeasureSpec.getSize(this.N);
        int i5 = this.G;
        float f4 = this.f16290q;
        this.f16297x = (i5 - f4) / 2.0f;
        float f5 = (i5 + f4) / 2.0f;
        this.f16298y = f5;
        this.f16299z = (f5 - ((f4 - this.f16289p) / 2.0f)) - this.R;
        if (this.B == -1) {
            if (this.f16296w) {
                this.B = (this.f16285l.a() + 1) / 2;
            } else {
                this.B = 0;
            }
        }
        this.D = this.B;
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.f16281h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f16281h.cancel(true);
        this.f16281h = null;
    }

    public int d(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            i4 += (int) Math.ceil(fArr[i5]);
        }
        return i4;
    }

    public final h.c getAdapter() {
        return this.f16285l;
    }

    public final int getCurrentItem() {
        return this.C;
    }

    public int getItemsCount() {
        h.c cVar = this.f16285l;
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k() {
        if (this.f16278e != null) {
            postDelayed(new d(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(float f4) {
        a();
        this.f16281h = this.f16280g.scheduleWithFixedDelay(new a(this, f4), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f4 = this.f16290q;
            int i4 = (int) (((this.A % f4) + f4) % f4);
            this.K = i4;
            if (i4 > f4 / 2.0f) {
                this.K = (int) (f4 - i4);
            } else {
                this.K = -i4;
            }
        }
        this.f16281h = this.f16280g.scheduleWithFixedDelay(new e(this, this.K), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i4;
        h.c cVar = this.f16285l;
        if (cVar == null) {
            return;
        }
        Object[] objArr = new Object[this.F];
        int i5 = (int) (this.A / this.f16290q);
        this.E = i5;
        try {
            this.D = this.B + (i5 % cVar.a());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "\u51fa\u9519\u4e86\uff01adapter.getItemsCount() == 0\uff0c\u8054\u52a8\u6570\u636e\u4e0d\u5339\u914d");
        }
        if (!this.f16296w) {
            if (this.D < 0) {
                this.D = 0;
            }
            if (this.D > this.f16285l.a() - 1) {
                this.D = this.f16285l.a() - 1;
            }
        } else {
            if (this.D < 0) {
                this.D = this.f16285l.a() + this.D;
            }
            if (this.D > this.f16285l.a() - 1) {
                this.D -= this.f16285l.a();
            }
        }
        int i6 = (int) (this.A % this.f16290q);
        int i7 = 0;
        while (true) {
            int i8 = this.F;
            if (i7 >= i8) {
                break;
            }
            int i9 = this.D - ((i8 / 2) - i7);
            if (this.f16296w) {
                objArr[i7] = this.f16285l.getItem(c(i9));
            } else if (i9 < 0) {
                objArr[i7] = "";
            } else if (i9 > this.f16285l.a() - 1) {
                objArr[i7] = "";
            } else {
                objArr[i7] = this.f16285l.getItem(i9);
            }
            i7++;
        }
        if (this.f16274a == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.f16286m)) {
                i4 = (this.H - this.f16288o) / 2;
            } else {
                i4 = (this.H - this.f16288o) / 4;
            }
            float f4 = i4 - 12;
            float f5 = f4 <= 0.0f ? 10.0f : f4;
            float f6 = this.H - f5;
            float f7 = this.f16297x;
            float f8 = f5;
            canvas.drawLine(f8, f7, f6, f7, this.f16284k);
            float f9 = this.f16298y;
            canvas.drawLine(f8, f9, f6, f9, this.f16284k);
        } else {
            float f10 = this.f16297x;
            canvas.drawLine(0.0f, f10, this.H, f10, this.f16284k);
            float f11 = this.f16298y;
            canvas.drawLine(0.0f, f11, this.H, f11, this.f16284k);
        }
        if (!TextUtils.isEmpty(this.f16286m)) {
            canvas.drawText(this.f16286m, (this.H - d(this.f16283j, this.f16286m)) - this.R, this.f16299z, this.f16283j);
        }
        for (int i10 = 0; i10 < this.F; i10++) {
            canvas.save();
            double d4 = ((this.f16290q * i10) - i6) / this.J;
            Double.isNaN(d4);
            float f12 = (float) (90.0d - ((d4 / 3.141592653589793d) * 180.0d));
            if (f12 < 90.0f && f12 > -90.0f) {
                String b4 = b(objArr[i10]);
                l(b4);
                i(b4);
                j(b4);
                double d5 = this.J;
                double cos = Math.cos(d4);
                double d6 = this.J;
                Double.isNaN(d6);
                Double.isNaN(d5);
                double d7 = d5 - (cos * d6);
                double sin = Math.sin(d4);
                double d8 = this.f16289p;
                Double.isNaN(d8);
                float f13 = (float) (d7 - ((sin * d8) / 2.0d));
                canvas.translate(0.0f, f13);
                canvas.scale(1.0f, (float) Math.sin(d4));
                float f14 = this.f16297x;
                if (f13 <= f14 && this.f16289p + f13 >= f14) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.H, this.f16297x - f13);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                    canvas.drawText(b4, this.Q, this.f16289p, this.f16282i);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.f16297x - f13, this.H, (int) this.f16290q);
                    canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                    canvas.drawText(b4, this.P, this.f16289p - this.R, this.f16283j);
                    canvas.restore();
                } else {
                    float f15 = this.f16298y;
                    if (f13 <= f15 && this.f16289p + f13 >= f15) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.H, this.f16298y - f13);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 1.0f);
                        canvas.drawText(b4, this.P, this.f16289p - this.R, this.f16283j);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.f16298y - f13, this.H, (int) this.f16290q);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                        canvas.drawText(b4, this.Q, this.f16289p, this.f16282i);
                        canvas.restore();
                    } else {
                        if (f13 >= f14) {
                            int i11 = this.f16289p;
                            if (i11 + f13 <= f15) {
                                canvas.drawText(b4, this.P, i11 - this.R, this.f16283j);
                                this.C = this.f16285l.indexOf(objArr[i10]);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.H, (int) this.f16290q);
                        canvas.scale(1.0f, ((float) Math.sin(d4)) * 0.8f);
                        canvas.drawText(b4, this.Q, this.f16289p, this.f16282i);
                        canvas.restore();
                    }
                }
                canvas.restore();
                this.f16283j.setTextSize(this.f16287n);
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        this.N = i4;
        m();
        setMeasuredDimension(this.H, this.G);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        double d4;
        boolean onTouchEvent = this.f16277d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.M = System.currentTimeMillis();
            a();
            this.f16273L = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f16273L - motionEvent.getRawY();
            this.f16273L = motionEvent.getRawY();
            this.A = (int) (this.A + rawY);
            if (!this.f16296w) {
                float f4 = (-this.B) * this.f16290q;
                float f5 = this.f16290q;
                float a4 = ((this.f16285l.a() - 1) - this.B) * f5;
                int i4 = this.A;
                double d5 = i4;
                double d6 = f5;
                Double.isNaN(d6);
                Double.isNaN(d5);
                if (d5 - (d6 * 0.3d) < f4) {
                    f4 = i4 - rawY;
                } else {
                    double d7 = i4;
                    double d8 = f5;
                    Double.isNaN(d8);
                    Double.isNaN(d7);
                    if (d7 + (d8 * 0.3d) > a4) {
                        a4 = i4 - rawY;
                    }
                }
                if (i4 < f4) {
                    this.A = (int) f4;
                } else if (i4 > a4) {
                    this.A = (int) a4;
                }
            }
        } else if (!onTouchEvent) {
            float y3 = motionEvent.getY();
            int i5 = this.J;
            double acos = Math.acos((i5 - y3) / i5);
            double d9 = this.J;
            Double.isNaN(d9);
            double d10 = acos * d9;
            float f6 = this.f16290q;
            double d11 = f6 / 2.0f;
            Double.isNaN(d11);
            double d12 = d10 + d11;
            Double.isNaN(f6);
            this.K = (int) (((((int) (d12 / d4)) - (this.F / 2)) * f6) - (((this.A % f6) + f6) % f6));
            if (System.currentTimeMillis() - this.M > 120) {
                o(ACTION.DAGGLE);
            } else {
                o(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void setAdapter(h.c cVar) {
        this.f16285l = cVar;
        m();
        invalidate();
    }

    public final void setCurrentItem(int i4) {
        this.B = i4;
        this.A = 0;
        invalidate();
    }

    public final void setCyclic(boolean z3) {
        this.f16296w = z3;
    }

    public void setDividerColor(int i4) {
        if (i4 != 0) {
            this.f16294u = i4;
            this.f16284k.setColor(i4);
        }
    }

    public void setDividerType(DividerType dividerType) {
        this.f16274a = dividerType;
    }

    public void setGravity(int i4) {
        this.O = i4;
    }

    public void setIsOptions(boolean z3) {
        this.f16279f = z3;
    }

    public void setLabel(String str) {
        this.f16286m = str;
    }

    public void setLineSpacingMultiplier(float f4) {
        if (f4 != 0.0f) {
            this.f16295v = f4;
            g();
        }
    }

    public final void setOnItemSelectedListener(i.c cVar) {
        this.f16278e = cVar;
    }

    public void setTextColorCenter(int i4) {
        if (i4 != 0) {
            this.f16293t = i4;
            this.f16283j.setColor(i4);
        }
    }

    public void setTextColorOut(int i4) {
        if (i4 != 0) {
            this.f16292s = i4;
            this.f16282i.setColor(i4);
        }
    }

    public final void setTextSize(float f4) {
        if (f4 > 0.0f) {
            int i4 = (int) (this.f16275b.getResources().getDisplayMetrics().density * f4);
            this.f16287n = i4;
            this.f16282i.setTextSize(i4);
            this.f16283j.setTextSize(this.f16287n);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f16291r = typeface;
        this.f16282i.setTypeface(typeface);
        this.f16283j.setTypeface(this.f16291r);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16279f = false;
        this.f16280g = Executors.newSingleThreadScheduledExecutor();
        this.f16291r = Typeface.MONOSPACE;
        this.f16292s = -5723992;
        this.f16293t = -14013910;
        this.f16294u = -2763307;
        this.f16295v = 1.6f;
        this.F = 11;
        this.K = 0;
        this.f16273L = 0.0f;
        this.M = 0L;
        this.O = 17;
        this.P = 0;
        this.Q = 0;
        this.f16287n = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f4 = getResources().getDisplayMetrics().density;
        if (f4 < 1.0f) {
            this.R = 2.4f;
        } else if (1.0f <= f4 && f4 < 2.0f) {
            this.R = 3.6f;
        } else if (1.0f <= f4 && f4 < 2.0f) {
            this.R = 4.5f;
        } else if (2.0f <= f4 && f4 < 3.0f) {
            this.R = 6.0f;
        } else if (f4 >= 3.0f) {
            this.R = f4 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.O = obtainStyledAttributes.getInt(R.styleable.pickerview_pickerview_gravity, 17);
            this.f16292s = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_textColorOut, this.f16292s);
            this.f16293t = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_textColorCenter, this.f16293t);
            this.f16294u = obtainStyledAttributes.getColor(R.styleable.pickerview_pickerview_dividerColor, this.f16294u);
            this.f16287n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_pickerview_textSize, this.f16287n);
            this.f16295v = obtainStyledAttributes.getFloat(R.styleable.pickerview_pickerview_lineSpacingMultiplier, this.f16295v);
            obtainStyledAttributes.recycle();
        }
        g();
        e(context);
    }
}

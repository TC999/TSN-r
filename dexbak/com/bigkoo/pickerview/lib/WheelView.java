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
import com.bigkoo.pickerview.C3501R;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p596h.WheelAdapter;
import p600i.OnItemSelectedListener;
import p606j.IPickerViewData;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WheelView extends View {

    /* renamed from: S */
    private static final int f13056S = 5;

    /* renamed from: T */
    private static final float f13057T = 0.8f;

    /* renamed from: A */
    int f13058A;

    /* renamed from: B */
    int f13059B;

    /* renamed from: C */
    private int f13060C;

    /* renamed from: D */
    int f13061D;

    /* renamed from: E */
    int f13062E;

    /* renamed from: F */
    int f13063F;

    /* renamed from: G */
    int f13064G;

    /* renamed from: H */
    int f13065H;

    /* renamed from: I */
    int f13066I;

    /* renamed from: J */
    int f13067J;

    /* renamed from: K */
    private int f13068K;

    /* renamed from: L */
    private float f13069L;

    /* renamed from: M */
    long f13070M;

    /* renamed from: N */
    int f13071N;

    /* renamed from: O */
    private int f13072O;

    /* renamed from: P */
    private int f13073P;

    /* renamed from: Q */
    private int f13074Q;

    /* renamed from: R */
    private float f13075R;

    /* renamed from: a */
    private DividerType f13076a;

    /* renamed from: b */
    Context f13077b;

    /* renamed from: c */
    Handler f13078c;

    /* renamed from: d */
    private GestureDetector f13079d;

    /* renamed from: e */
    OnItemSelectedListener f13080e;

    /* renamed from: f */
    private boolean f13081f;

    /* renamed from: g */
    ScheduledExecutorService f13082g;

    /* renamed from: h */
    private ScheduledFuture<?> f13083h;

    /* renamed from: i */
    Paint f13084i;

    /* renamed from: j */
    Paint f13085j;

    /* renamed from: k */
    Paint f13086k;

    /* renamed from: l */
    WheelAdapter f13087l;

    /* renamed from: m */
    private String f13088m;

    /* renamed from: n */
    int f13089n;

    /* renamed from: o */
    int f13090o;

    /* renamed from: p */
    int f13091p;

    /* renamed from: q */
    float f13092q;

    /* renamed from: r */
    Typeface f13093r;

    /* renamed from: s */
    int f13094s;

    /* renamed from: t */
    int f13095t;

    /* renamed from: u */
    int f13096u;

    /* renamed from: v */
    float f13097v;

    /* renamed from: w */
    boolean f13098w;

    /* renamed from: x */
    float f13099x;

    /* renamed from: y */
    float f13100y;

    /* renamed from: z */
    float f13101z;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private String m45891b(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).m12670a();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    /* renamed from: c */
    private int m45890c(int i) {
        if (i < 0) {
            return m45890c(i + this.f13087l.mo12730a());
        }
        return i > this.f13087l.mo12730a() + (-1) ? m45890c(i - this.f13087l.mo12730a()) : i;
    }

    /* renamed from: e */
    private void m45888e(Context context) {
        this.f13077b = context;
        this.f13078c = new HandlerC3513c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.f13079d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f13098w = true;
        this.f13058A = 0;
        this.f13059B = -1;
        m45887f();
    }

    /* renamed from: f */
    private void m45887f() {
        Paint paint = new Paint();
        this.f13084i = paint;
        paint.setColor(this.f13094s);
        this.f13084i.setAntiAlias(true);
        this.f13084i.setTypeface(this.f13093r);
        this.f13084i.setTextSize(this.f13089n);
        Paint paint2 = new Paint();
        this.f13085j = paint2;
        paint2.setColor(this.f13095t);
        this.f13085j.setAntiAlias(true);
        this.f13085j.setTextScaleX(1.1f);
        this.f13085j.setTypeface(this.f13093r);
        this.f13085j.setTextSize(this.f13089n);
        Paint paint3 = new Paint();
        this.f13086k = paint3;
        paint3.setColor(this.f13096u);
        this.f13086k.setAntiAlias(true);
        setLayerType(1, null);
    }

    /* renamed from: g */
    private void m45886g() {
        float f = this.f13097v;
        if (f < 1.2f) {
            this.f13097v = 1.2f;
        } else if (f > 2.0f) {
            this.f13097v = 2.0f;
        }
    }

    /* renamed from: h */
    private void m45885h() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f13087l.mo12730a(); i++) {
            String m45891b = m45891b(this.f13087l.getItem(i));
            this.f13085j.getTextBounds(m45891b, 0, m45891b.length(), rect);
            int width = rect.width();
            if (width > this.f13090o) {
                this.f13090o = width;
            }
            this.f13085j.getTextBounds("星期", 0, 2, rect);
            this.f13091p = rect.height() + 2;
        }
        this.f13092q = this.f13097v * this.f13091p;
    }

    /* renamed from: i */
    private void m45884i(String str) {
        String str2;
        Rect rect = new Rect();
        this.f13085j.getTextBounds(str, 0, str.length(), rect);
        int i = this.f13072O;
        if (i == 3) {
            this.f13073P = 0;
        } else if (i == 5) {
            this.f13073P = (this.f13065H - rect.width()) - ((int) this.f13075R);
        } else if (i != 17) {
        } else {
            if (!this.f13081f && (str2 = this.f13088m) != null && !str2.equals("")) {
                double width = this.f13065H - rect.width();
                Double.isNaN(width);
                this.f13073P = (int) (width * 0.25d);
                return;
            }
            double width2 = this.f13065H - rect.width();
            Double.isNaN(width2);
            this.f13073P = (int) (width2 * 0.5d);
        }
    }

    /* renamed from: j */
    private void m45883j(String str) {
        String str2;
        Rect rect = new Rect();
        this.f13084i.getTextBounds(str, 0, str.length(), rect);
        int i = this.f13072O;
        if (i == 3) {
            this.f13074Q = 0;
        } else if (i == 5) {
            this.f13074Q = (this.f13065H - rect.width()) - ((int) this.f13075R);
        } else if (i != 17) {
        } else {
            if (!this.f13081f && (str2 = this.f13088m) != null && !str2.equals("")) {
                double width = this.f13065H - rect.width();
                Double.isNaN(width);
                this.f13074Q = (int) (width * 0.25d);
                return;
            }
            double width2 = this.f13065H - rect.width();
            Double.isNaN(width2);
            this.f13074Q = (int) (width2 * 0.5d);
        }
    }

    /* renamed from: l */
    private void m45881l(String str) {
        Rect rect = new Rect();
        this.f13085j.getTextBounds(str, 0, str.length(), rect);
        int i = this.f13089n;
        for (int width = rect.width(); width > this.f13065H; width = rect.width()) {
            i--;
            this.f13085j.setTextSize(i);
            this.f13085j.getTextBounds(str, 0, str.length(), rect);
        }
        this.f13084i.setTextSize(i);
    }

    /* renamed from: m */
    private void m45880m() {
        if (this.f13087l == null) {
            return;
        }
        m45885h();
        int i = (int) (this.f13092q * (this.f13063F - 1));
        this.f13066I = i;
        double d = i * 2;
        Double.isNaN(d);
        this.f13064G = (int) (d / 3.141592653589793d);
        double d2 = i;
        Double.isNaN(d2);
        this.f13067J = (int) (d2 / 3.141592653589793d);
        this.f13065H = View.MeasureSpec.getSize(this.f13071N);
        int i2 = this.f13064G;
        float f = this.f13092q;
        this.f13099x = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.f13100y = f2;
        this.f13101z = (f2 - ((f - this.f13091p) / 2.0f)) - this.f13075R;
        if (this.f13059B == -1) {
            if (this.f13098w) {
                this.f13059B = (this.f13087l.mo12730a() + 1) / 2;
            } else {
                this.f13059B = 0;
            }
        }
        this.f13061D = this.f13059B;
    }

    /* renamed from: a */
    public void m45892a() {
        ScheduledFuture<?> scheduledFuture = this.f13083h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f13083h.cancel(true);
        this.f13083h = null;
    }

    /* renamed from: d */
    public int m45889d(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(fArr[i2]);
        }
        return i;
    }

    public final WheelAdapter getAdapter() {
        return this.f13087l;
    }

    public final int getCurrentItem() {
        return this.f13060C;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.f13087l;
        if (wheelAdapter != null) {
            return wheelAdapter.mo12730a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public final void m45882k() {
        if (this.f13080e != null) {
            postDelayed(new OnItemSelectedRunnable(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final void m45879n(float f) {
        m45892a();
        this.f13083h = this.f13082g.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m45878o(ACTION action) {
        m45892a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f13092q;
            int i = (int) (((this.f13058A % f) + f) % f);
            this.f13068K = i;
            if (i > f / 2.0f) {
                this.f13068K = (int) (f - i);
            } else {
                this.f13068K = -i;
            }
        }
        this.f13083h = this.f13082g.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.f13068K), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        WheelAdapter wheelAdapter = this.f13087l;
        if (wheelAdapter == null) {
            return;
        }
        Object[] objArr = new Object[this.f13063F];
        int i2 = (int) (this.f13058A / this.f13092q);
        this.f13062E = i2;
        try {
            this.f13061D = this.f13059B + (i2 % wheelAdapter.mo12730a());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.f13098w) {
            if (this.f13061D < 0) {
                this.f13061D = 0;
            }
            if (this.f13061D > this.f13087l.mo12730a() - 1) {
                this.f13061D = this.f13087l.mo12730a() - 1;
            }
        } else {
            if (this.f13061D < 0) {
                this.f13061D = this.f13087l.mo12730a() + this.f13061D;
            }
            if (this.f13061D > this.f13087l.mo12730a() - 1) {
                this.f13061D -= this.f13087l.mo12730a();
            }
        }
        int i3 = (int) (this.f13058A % this.f13092q);
        int i4 = 0;
        while (true) {
            int i5 = this.f13063F;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.f13061D - ((i5 / 2) - i4);
            if (this.f13098w) {
                objArr[i4] = this.f13087l.getItem(m45890c(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.f13087l.mo12730a() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.f13087l.getItem(i6);
            }
            i4++;
        }
        if (this.f13076a == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.f13088m)) {
                i = (this.f13065H - this.f13090o) / 2;
            } else {
                i = (this.f13065H - this.f13090o) / 4;
            }
            float f = i - 12;
            float f2 = f <= 0.0f ? 10.0f : f;
            float f3 = this.f13065H - f2;
            float f4 = this.f13099x;
            float f5 = f2;
            canvas.drawLine(f5, f4, f3, f4, this.f13086k);
            float f6 = this.f13100y;
            canvas.drawLine(f5, f6, f3, f6, this.f13086k);
        } else {
            float f7 = this.f13099x;
            canvas.drawLine(0.0f, f7, this.f13065H, f7, this.f13086k);
            float f8 = this.f13100y;
            canvas.drawLine(0.0f, f8, this.f13065H, f8, this.f13086k);
        }
        if (!TextUtils.isEmpty(this.f13088m)) {
            canvas.drawText(this.f13088m, (this.f13065H - m45889d(this.f13085j, this.f13088m)) - this.f13075R, this.f13101z, this.f13085j);
        }
        for (int i7 = 0; i7 < this.f13063F; i7++) {
            canvas.save();
            double d = ((this.f13092q * i7) - i3) / this.f13067J;
            Double.isNaN(d);
            float f9 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f9 < 90.0f && f9 > -90.0f) {
                String m45891b = m45891b(objArr[i7]);
                m45881l(m45891b);
                m45884i(m45891b);
                m45883j(m45891b);
                double d2 = this.f13067J;
                double cos = Math.cos(d);
                double d3 = this.f13067J;
                Double.isNaN(d3);
                Double.isNaN(d2);
                double d4 = d2 - (cos * d3);
                double sin = Math.sin(d);
                double d5 = this.f13091p;
                Double.isNaN(d5);
                float f10 = (float) (d4 - ((sin * d5) / 2.0d));
                canvas.translate(0.0f, f10);
                canvas.scale(1.0f, (float) Math.sin(d));
                float f11 = this.f13099x;
                if (f10 <= f11 && this.f13091p + f10 >= f11) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.f13065H, this.f13099x - f10);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * f13057T);
                    canvas.drawText(m45891b, this.f13074Q, this.f13091p, this.f13084i);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.f13099x - f10, this.f13065H, (int) this.f13092q);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(m45891b, this.f13073P, this.f13091p - this.f13075R, this.f13085j);
                    canvas.restore();
                } else {
                    float f12 = this.f13100y;
                    if (f10 <= f12 && this.f13091p + f10 >= f12) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.f13065H, this.f13100y - f10);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(m45891b, this.f13073P, this.f13091p - this.f13075R, this.f13085j);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.f13100y - f10, this.f13065H, (int) this.f13092q);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * f13057T);
                        canvas.drawText(m45891b, this.f13074Q, this.f13091p, this.f13084i);
                        canvas.restore();
                    } else {
                        if (f10 >= f11) {
                            int i8 = this.f13091p;
                            if (i8 + f10 <= f12) {
                                canvas.drawText(m45891b, this.f13073P, i8 - this.f13075R, this.f13085j);
                                this.f13060C = this.f13087l.indexOf(objArr[i7]);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.f13065H, (int) this.f13092q);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * f13057T);
                        canvas.drawText(m45891b, this.f13074Q, this.f13091p, this.f13084i);
                        canvas.restore();
                    }
                }
                canvas.restore();
                this.f13085j.setTextSize(this.f13089n);
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f13071N = i;
        m45880m();
        setMeasuredDimension(this.f13065H, this.f13064G);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        double d;
        boolean onTouchEvent = this.f13079d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f13070M = System.currentTimeMillis();
            m45892a();
            this.f13069L = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f13069L - motionEvent.getRawY();
            this.f13069L = motionEvent.getRawY();
            this.f13058A = (int) (this.f13058A + rawY);
            if (!this.f13098w) {
                float f = (-this.f13059B) * this.f13092q;
                float f2 = this.f13092q;
                float mo12730a = ((this.f13087l.mo12730a() - 1) - this.f13059B) * f2;
                int i = this.f13058A;
                double d2 = i;
                double d3 = f2;
                Double.isNaN(d3);
                Double.isNaN(d2);
                if (d2 - (d3 * 0.3d) < f) {
                    f = i - rawY;
                } else {
                    double d4 = i;
                    double d5 = f2;
                    Double.isNaN(d5);
                    Double.isNaN(d4);
                    if (d4 + (d5 * 0.3d) > mo12730a) {
                        mo12730a = i - rawY;
                    }
                }
                if (i < f) {
                    this.f13058A = (int) f;
                } else if (i > mo12730a) {
                    this.f13058A = (int) mo12730a;
                }
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i2 = this.f13067J;
            double acos = Math.acos((i2 - y) / i2);
            double d6 = this.f13067J;
            Double.isNaN(d6);
            double d7 = acos * d6;
            float f3 = this.f13092q;
            double d8 = f3 / 2.0f;
            Double.isNaN(d8);
            double d9 = d7 + d8;
            Double.isNaN(f3);
            this.f13068K = (int) (((((int) (d9 / d)) - (this.f13063F / 2)) * f3) - (((this.f13058A % f3) + f3) % f3));
            if (System.currentTimeMillis() - this.f13070M > 120) {
                m45878o(ACTION.DAGGLE);
            } else {
                m45878o(ACTION.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.f13087l = wheelAdapter;
        m45880m();
        invalidate();
    }

    public final void setCurrentItem(int i) {
        this.f13059B = i;
        this.f13058A = 0;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.f13098w = z;
    }

    public void setDividerColor(int i) {
        if (i != 0) {
            this.f13096u = i;
            this.f13086k.setColor(i);
        }
    }

    public void setDividerType(DividerType dividerType) {
        this.f13076a = dividerType;
    }

    public void setGravity(int i) {
        this.f13072O = i;
    }

    public void setIsOptions(boolean z) {
        this.f13081f = z;
    }

    public void setLabel(String str) {
        this.f13088m = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f13097v = f;
            m45886g();
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f13080e = onItemSelectedListener;
    }

    public void setTextColorCenter(int i) {
        if (i != 0) {
            this.f13095t = i;
            this.f13085j.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        if (i != 0) {
            this.f13094s = i;
            this.f13084i.setColor(i);
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.f13077b.getResources().getDisplayMetrics().density * f);
            this.f13089n = i;
            this.f13084i.setTextSize(i);
            this.f13085j.setTextSize(this.f13089n);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f13093r = typeface;
        this.f13084i.setTypeface(typeface);
        this.f13085j.setTypeface(this.f13093r);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13081f = false;
        this.f13082g = Executors.newSingleThreadScheduledExecutor();
        this.f13093r = Typeface.MONOSPACE;
        this.f13094s = -5723992;
        this.f13095t = -14013910;
        this.f13096u = -2763307;
        this.f13097v = 1.6f;
        this.f13063F = 11;
        this.f13068K = 0;
        this.f13069L = 0.0f;
        this.f13070M = 0L;
        this.f13072O = 17;
        this.f13073P = 0;
        this.f13074Q = 0;
        this.f13089n = getResources().getDimensionPixelSize(C3501R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.f13075R = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f13075R = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f13075R = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.f13075R = 6.0f;
        } else if (f >= 3.0f) {
            this.f13075R = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3501R.styleable.pickerview, 0, 0);
            this.f13072O = obtainStyledAttributes.getInt(C3501R.styleable.pickerview_pickerview_gravity, 17);
            this.f13094s = obtainStyledAttributes.getColor(C3501R.styleable.pickerview_pickerview_textColorOut, this.f13094s);
            this.f13095t = obtainStyledAttributes.getColor(C3501R.styleable.pickerview_pickerview_textColorCenter, this.f13095t);
            this.f13096u = obtainStyledAttributes.getColor(C3501R.styleable.pickerview_pickerview_dividerColor, this.f13096u);
            this.f13089n = obtainStyledAttributes.getDimensionPixelOffset(C3501R.styleable.pickerview_pickerview_textSize, this.f13089n);
            this.f13097v = obtainStyledAttributes.getFloat(C3501R.styleable.pickerview_pickerview_lineSpacingMultiplier, this.f13097v);
            obtainStyledAttributes.recycle();
        }
        m45886g();
        m45888e(context);
    }
}

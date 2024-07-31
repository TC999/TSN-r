package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.C11925c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TaurusHeader extends View implements RefreshHeader {

    /* renamed from: A */
    private static final int f33184A = 4;

    /* renamed from: B */
    private static final int f33185B = 2;

    /* renamed from: C */
    private static final int f33186C = 50;

    /* renamed from: D */
    private static final int f33187D = 300;

    /* renamed from: E */
    private static final int f33188E = 1000;

    /* renamed from: F */
    private static final int f33189F = 2000;

    /* renamed from: G */
    private static final int f33190G = 5;

    /* renamed from: q */
    private static final float f33191q = 0.5f;

    /* renamed from: r */
    private static final int f33192r = 1000;

    /* renamed from: s */
    private static final float f33193s = 0.6f;

    /* renamed from: t */
    private static final float f33194t = 1.0f;

    /* renamed from: u */
    private static final float f33195u = 0.8f;

    /* renamed from: v */
    private static final float f33196v = 1.0f;

    /* renamed from: w */
    private static final Interpolator f33197w = new AccelerateDecelerateInterpolator();

    /* renamed from: x */
    private static final int f33198x = 80;

    /* renamed from: y */
    private static final int f33199y = 6;

    /* renamed from: z */
    private static final int f33200z = 10;

    /* renamed from: a */
    private PathsDrawable f33201a;

    /* renamed from: b */
    private PathsDrawable f33202b;

    /* renamed from: c */
    private Matrix f33203c;

    /* renamed from: d */
    private float f33204d;

    /* renamed from: e */
    private int f33205e;

    /* renamed from: f */
    private Animation f33206f;

    /* renamed from: g */
    private boolean f33207g;

    /* renamed from: h */
    private float f33208h;

    /* renamed from: i */
    private float f33209i;

    /* renamed from: j */
    private Random f33210j;

    /* renamed from: k */
    private boolean f33211k;

    /* renamed from: l */
    private Map<Float, Float> f33212l;

    /* renamed from: m */
    private Paint f33213m;

    /* renamed from: n */
    private float f33214n;

    /* renamed from: o */
    private boolean f33215o;

    /* renamed from: p */
    private boolean f33216p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11856a extends Animation {
        C11856a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, @NonNull Transformation transformation) {
            TaurusHeader.this.setLoadingAnimationTime(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C11857b {

        /* renamed from: a */
        static final /* synthetic */ int[] f33218a;

        static {
            int[] iArr = new int[EnumC11858c.values().length];
            f33218a = iArr;
            try {
                iArr[EnumC11858c.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33218a[EnumC11858c.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33218a[EnumC11858c.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33218a[EnumC11858c.FOURTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.scwang.smartrefresh.header.TaurusHeader$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC11858c {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public TaurusHeader(Context context) {
        super(context);
        this.f33207g = false;
        m20155F(context, null);
    }

    /* renamed from: A */
    private void m20160A(Canvas canvas, int i, int i2) {
        float f;
        boolean z;
        float f2;
        float m20157D;
        float f3;
        float m20157D2;
        Matrix matrix = this.f33203c;
        matrix.reset();
        float min = Math.min(1.0f, Math.abs(this.f33204d));
        if (isInEditMode()) {
            this.f33205e = i2;
            min = 1.0f;
        }
        float f4 = this.f33204d;
        boolean z2 = true;
        if (f4 > 1.0f) {
            f = Math.abs(1.0f - f4);
            z = true;
        } else {
            f = 0.0f;
            z = false;
        }
        float f5 = min - 0.5f;
        float f6 = f33195u;
        if (f5 > 0.0f) {
            f6 = f33195u + ((f5 / 0.5f) * 0.19999999f);
        }
        int i3 = this.f33205e;
        float f7 = i3 * min;
        float m19803f = i3 - (this.f33202b.m19803f() / 2);
        if (f7 > m19803f) {
            f2 = f7 - m19803f;
        } else {
            f2 = 0.0f;
            z2 = false;
        }
        float m19795n = (i / 2) - (this.f33202b.m19795n() / 2);
        float m19803f2 = f7 - (z2 ? (this.f33202b.m19803f() / 2) + f2 : this.f33202b.m19803f() / 2);
        float f8 = z ? (f / 4.0f) + f6 : f6;
        float f9 = z ? (f / 2.0f) + f6 : f6;
        if (this.f33207g && !z) {
            EnumC11858c enumC11858c = EnumC11858c.FIRST;
            if (m20150s(enumC11858c)) {
                m20157D2 = m20157D(enumC11858c);
            } else {
                EnumC11858c enumC11858c2 = EnumC11858c.SECOND;
                if (m20150s(enumC11858c2)) {
                    m20157D2 = m20157D(enumC11858c2);
                } else {
                    EnumC11858c enumC11858c3 = EnumC11858c.THIRD;
                    if (m20150s(enumC11858c3)) {
                        m20157D = m20157D(enumC11858c3);
                    } else {
                        EnumC11858c enumC11858c4 = EnumC11858c.FOURTH;
                        if (m20150s(enumC11858c4)) {
                            m20157D = m20157D(enumC11858c4);
                        }
                        f9 = f8;
                    }
                    f3 = f6 + ((m20157D / 80.0f) / 6.0f);
                    f8 = f3;
                    f9 = f8;
                }
            }
            f3 = f6 - ((m20157D2 / 80.0f) / 8.0f);
            f8 = f3;
            f9 = f8;
        }
        matrix.postScale(f8, f9, this.f33202b.m19795n() / 2, 0.0f);
        float f10 = i2 + 2;
        if ((this.f33202b.m19803f() * f9) + m19803f2 < f10) {
            m19803f2 = f10 - (f9 * this.f33202b.m19803f());
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(m19795n, m19803f2);
        canvas.concat(matrix);
        this.f33202b.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: B */
    private void m20159B(Canvas canvas, int i, int i2) {
        float m20157D;
        float m20157D2;
        Matrix matrix = this.f33203c;
        matrix.reset();
        PathsDrawable pathsDrawable = this.f33202b;
        float min = Math.min(1.0f, Math.abs(this.f33204d));
        if (isInEditMode()) {
            this.f33205e = i2;
            min = 1.0f;
        }
        float f = min - 0.5f;
        float f2 = f > 0.0f ? 0.6f + ((f / 0.5f) * 0.39999998f) : 0.6f;
        float f3 = this.f33205e * (1.0f - min);
        float m19795n = 0 - (pathsDrawable.m19795n() / 2);
        float m19795n2 = i - (pathsDrawable.m19795n() / 2);
        if (this.f33207g) {
            EnumC11858c enumC11858c = EnumC11858c.FIRST;
            if (m20150s(enumC11858c)) {
                m19795n -= (m20157D(enumC11858c) * 2.0f) / 4.0f;
                m20157D2 = m20157D(enumC11858c);
            } else {
                EnumC11858c enumC11858c2 = EnumC11858c.SECOND;
                if (m20150s(enumC11858c2)) {
                    m19795n -= (m20157D(enumC11858c2) * 2.0f) / 4.0f;
                    m20157D2 = m20157D(enumC11858c2);
                } else {
                    EnumC11858c enumC11858c3 = EnumC11858c.THIRD;
                    if (m20150s(enumC11858c3)) {
                        m19795n -= m20157D(enumC11858c3) / 4.0f;
                        m20157D2 = m20157D(enumC11858c3) * 2.0f;
                    } else {
                        EnumC11858c enumC11858c4 = EnumC11858c.FOURTH;
                        if (m20150s(enumC11858c4)) {
                            m19795n -= m20157D(enumC11858c4) / 2.0f;
                            m20157D = (m20157D(enumC11858c4) * 2.0f) / 4.0f;
                            m19795n2 += m20157D;
                        }
                    }
                }
            }
            m20157D = m20157D2 / 2.0f;
            m19795n2 += m20157D;
        }
        float f4 = i2 + 2;
        float m19803f = (((float) pathsDrawable.m19803f()) * f2) + f3 < f4 ? f4 - (pathsDrawable.m19803f() * f2) : f3;
        if ((pathsDrawable.m19803f() * f2) + f3 < f4) {
            f3 = f4 - (pathsDrawable.m19803f() * f2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(m19795n, m19803f);
        matrix.postScale(f2, f2, (pathsDrawable.m19795n() * 3) / 4, pathsDrawable.m19803f());
        canvas.concat(matrix);
        pathsDrawable.setAlpha(100);
        pathsDrawable.draw(canvas);
        pathsDrawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(m19795n2, f3);
        matrix.postScale(f2, f2, 0.0f, pathsDrawable.m19803f());
        canvas.concat(matrix);
        pathsDrawable.setAlpha(100);
        pathsDrawable.draw(canvas);
        pathsDrawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    /* renamed from: C */
    private void m20158C(Canvas canvas, float f, float f2, int i) {
        float f3 = i;
        float f4 = (f3 + f2) / 13.0f;
        float f5 = this.f33208h;
        if (this.f33209i - f5 > 0.0f) {
            this.f33216p = true;
            f5 = 13.0f - f5;
        } else {
            this.f33215o = true;
            this.f33216p = false;
        }
        float f6 = (f3 - (f5 * f4)) + f2;
        float f7 = this.f33214n;
        float f8 = f6 - f7;
        canvas.drawLine(f8, f, f8 + f7, f, this.f33213m);
    }

    /* renamed from: D */
    private float m20157D(EnumC11858c enumC11858c) {
        float f;
        float m20156E;
        int i = C11857b.f33218a[enumC11858c.ordinal()];
        if (i != 1) {
            if (i == 2) {
                EnumC11858c enumC11858c2 = EnumC11858c.FOURTH;
                return m20156E(enumC11858c2) - (this.f33208h - m20156E(enumC11858c2));
            }
            if (i == 3) {
                f = this.f33208h;
                m20156E = m20156E(EnumC11858c.SECOND);
            } else if (i != 4) {
                return 0.0f;
            } else {
                f = m20156E(EnumC11858c.THIRD);
                m20156E = this.f33208h - m20156E(EnumC11858c.FOURTH);
            }
            return f - m20156E;
        }
        return this.f33208h;
    }

    /* renamed from: E */
    private int m20156E(EnumC11858c enumC11858c) {
        int i = C11857b.f33218a[enumC11858c.ordinal()];
        if (i != 2) {
            if (i != 3) {
                return i != 4 ? 0 : 20;
            }
            return m20156E(EnumC11858c.FOURTH) * 3;
        }
        return 40;
    }

    /* renamed from: F */
    private void m20155F(Context context, AttributeSet attributeSet) {
        setMinimumHeight(C11925c.m19766b(100.0f));
        this.f33203c = new Matrix();
        this.f33212l = new HashMap();
        this.f33210j = new Random();
        Paint paint = new Paint();
        this.f33213m = paint;
        paint.setColor(-1);
        this.f33213m.setStrokeWidth(C11925c.m19766b(3.0f));
        this.f33213m.setAlpha(50);
        m20153H();
        m20152I();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.TaurusHeader);
        int color = obtainStyledAttributes.getColor(C11852R.styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: G */
    private float m20154G(int i, int i2) {
        return this.f33210j.nextInt((i2 - i) + 1) + i;
    }

    /* renamed from: H */
    private void m20153H() {
        C11856a c11856a = new C11856a();
        this.f33206f = c11856a;
        c11856a.setRepeatCount(-1);
        this.f33206f.setRepeatMode(2);
        this.f33206f.setInterpolator(f33197w);
        this.f33206f.setDuration(1000L);
    }

    /* renamed from: I */
    private void m20152I() {
        C11925c c11925c = new C11925c();
        PathsDrawable pathsDrawable = new PathsDrawable();
        this.f33201a = pathsDrawable;
        pathsDrawable.m19800i("m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z");
        this.f33201a.setBounds(0, 0, c11925c.m19767a(65.0f), c11925c.m19767a(20.0f));
        this.f33201a.m19801h(-1);
        PathsDrawable pathsDrawable2 = new PathsDrawable();
        this.f33202b = pathsDrawable2;
        pathsDrawable2.m19800i("M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z");
        this.f33202b.m19801h(-1429742351, -571935747, -131587);
        this.f33202b.setBounds(0, 0, c11925c.m19767a(260.0f), c11925c.m19767a(45.0f));
    }

    /* renamed from: s */
    private boolean m20150s(EnumC11858c enumC11858c) {
        int i = C11857b.f33218a[enumC11858c.ordinal()];
        return i != 1 ? (i == 2 || i == 3) ? this.f33208h < ((float) m20156E(enumC11858c)) : i == 4 && this.f33208h > ((float) m20156E(EnumC11858c.THIRD)) : this.f33208h < ((float) m20156E(EnumC11858c.FOURTH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimationTime(float f) {
        this.f33208h = (f / 6.0f) * 80.0f;
        invalidate();
    }

    /* renamed from: z */
    private void m20149z(Canvas canvas, int i, int i2) {
        float f;
        float m20157D;
        float m20157D2;
        Matrix matrix = this.f33203c;
        matrix.reset();
        float f2 = this.f33204d;
        if (isInEditMode()) {
            this.f33205e = i2;
            f2 = 1.0f;
        }
        if (f2 > 1.0f) {
            f = ((float) (1.0d - Math.pow(100.0d, (-(f2 - 1.0f)) / 2.0f))) * 20.0f;
            f2 = 1.0f;
        } else {
            f = 0.0f;
        }
        float f3 = i;
        float m19795n = ((f3 * f2) / 2.0f) - (this.f33201a.m19795n() / 2);
        float m19803f = (this.f33205e * (1.0f - (f2 / 2.0f))) - (this.f33201a.m19803f() / 2);
        if (this.f33211k) {
            m19795n = ((i / 2) + ((f3 * (1.0f - f2)) / 2.0f)) - (this.f33201a.m19795n() / 2);
            m19803f = (f2 * ((this.f33205e / 2) + ((this.f33201a.m19803f() * 3) / 2))) - (this.f33201a.m19803f() * 2);
        }
        if (this.f33207g) {
            EnumC11858c enumC11858c = EnumC11858c.FIRST;
            if (m20150s(enumC11858c)) {
                m20157D2 = m20157D(enumC11858c);
            } else {
                EnumC11858c enumC11858c2 = EnumC11858c.SECOND;
                if (m20150s(enumC11858c2)) {
                    m20157D2 = m20157D(enumC11858c2);
                } else {
                    EnumC11858c enumC11858c3 = EnumC11858c.THIRD;
                    if (m20150s(enumC11858c3)) {
                        m20157D = m20157D(enumC11858c3);
                    } else {
                        EnumC11858c enumC11858c4 = EnumC11858c.FOURTH;
                        if (m20150s(enumC11858c4)) {
                            m20157D = m20157D(enumC11858c4);
                        }
                    }
                    m19803f += m20157D;
                }
            }
            m19803f -= m20157D2;
        }
        if (f > 0.0f) {
            matrix.postRotate(f, this.f33201a.m19795n() / 2, this.f33201a.m19803f() / 2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(m19795n, m19803f);
        canvas.concat(matrix);
        this.f33201a.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        this.f33204d = f;
        this.f33205e = i2;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        int width = getWidth();
        int height = getHeight();
        if (this.f33207g) {
            while (this.f33212l.size() < 10) {
                double d = this.f33205e;
                Double.isNaN(d);
                float random = (float) (d / (Math.random() * 5.0d));
                float m20154G = m20154G(1000, 2000);
                if (this.f33212l.size() > 1) {
                    while (true) {
                        f = 0.0f;
                        while (f == 0.0f) {
                            double d2 = this.f33205e;
                            Double.isNaN(d2);
                            float random2 = (float) (d2 / (Math.random() * 5.0d));
                            Iterator<Map.Entry<Float, Float>> it = this.f33212l.entrySet().iterator();
                            while (it.hasNext()) {
                                if (Math.abs(it.next().getKey().floatValue() - random2) > this.f33205e / 5) {
                                    f = random2;
                                }
                            }
                        }
                    }
                    random = f;
                }
                this.f33212l.put(Float.valueOf(random), Float.valueOf(m20154G));
                m20158C(canvas, random, m20154G, width);
            }
            if (this.f33212l.size() >= 10) {
                for (Map.Entry<Float, Float> entry : this.f33212l.entrySet()) {
                    m20158C(canvas, entry.getKey().floatValue(), entry.getValue().floatValue(), width);
                }
            }
            if (this.f33216p && this.f33215o) {
                this.f33212l.clear();
                this.f33215o = false;
                this.f33214n = m20154G(50, 300);
            }
            this.f33209i = this.f33208h;
        }
        m20149z(canvas, width, height);
        m20159B(canvas, width, height);
        m20160A(canvas, width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
        this.f33207g = true;
        startAnimation(this.f33206f);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33207g = false;
        this.f33211k = true;
        clearAnimation();
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        this.f33204d = f;
        this.f33211k = false;
        this.f33205e = i2;
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33207g = false;
        m20155F(context, attributeSet);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33207g = false;
        m20155F(context, attributeSet);
    }

    @RequiresApi(21)
    public TaurusHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33207g = false;
        m20155F(context, attributeSet);
    }
}

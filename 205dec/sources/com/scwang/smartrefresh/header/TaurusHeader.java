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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TaurusHeader extends View implements e {
    private static final int A = 4;
    private static final int B = 2;
    private static final int C = 50;
    private static final int D = 300;
    private static final int E = 1000;
    private static final int F = 2000;
    private static final int G = 5;

    /* renamed from: q  reason: collision with root package name */
    private static final float f47603q = 0.5f;

    /* renamed from: r  reason: collision with root package name */
    private static final int f47604r = 1000;

    /* renamed from: s  reason: collision with root package name */
    private static final float f47605s = 0.6f;

    /* renamed from: t  reason: collision with root package name */
    private static final float f47606t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    private static final float f47607u = 0.8f;

    /* renamed from: v  reason: collision with root package name */
    private static final float f47608v = 1.0f;

    /* renamed from: w  reason: collision with root package name */
    private static final Interpolator f47609w = new AccelerateDecelerateInterpolator();

    /* renamed from: x  reason: collision with root package name */
    private static final int f47610x = 80;

    /* renamed from: y  reason: collision with root package name */
    private static final int f47611y = 6;

    /* renamed from: z  reason: collision with root package name */
    private static final int f47612z = 10;

    /* renamed from: a  reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.pathview.b f47613a;

    /* renamed from: b  reason: collision with root package name */
    private com.scwang.smartrefresh.layout.internal.pathview.b f47614b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f47615c;

    /* renamed from: d  reason: collision with root package name */
    private float f47616d;

    /* renamed from: e  reason: collision with root package name */
    private int f47617e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f47618f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f47619g;

    /* renamed from: h  reason: collision with root package name */
    private float f47620h;

    /* renamed from: i  reason: collision with root package name */
    private float f47621i;

    /* renamed from: j  reason: collision with root package name */
    private Random f47622j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f47623k;

    /* renamed from: l  reason: collision with root package name */
    private Map<Float, Float> f47624l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f47625m;

    /* renamed from: n  reason: collision with root package name */
    private float f47626n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f47627o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f47628p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends Animation {
        a() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, @NonNull Transformation transformation) {
            TaurusHeader.this.setLoadingAnimationTime(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47630a;

        static {
            int[] iArr = new int[c.values().length];
            f47630a = iArr;
            try {
                iArr[c.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47630a[c.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47630a[c.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47630a[c.FOURTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum c {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public TaurusHeader(Context context) {
        super(context);
        this.f47619g = false;
        F(context, null);
    }

    private void A(Canvas canvas, int i4, int i5) {
        float f4;
        boolean z3;
        float f5;
        float D2;
        float f6;
        float D3;
        Matrix matrix = this.f47615c;
        matrix.reset();
        float min = Math.min(1.0f, Math.abs(this.f47616d));
        if (isInEditMode()) {
            this.f47617e = i5;
            min = 1.0f;
        }
        float f7 = this.f47616d;
        boolean z4 = true;
        if (f7 > 1.0f) {
            f4 = Math.abs(1.0f - f7);
            z3 = true;
        } else {
            f4 = 0.0f;
            z3 = false;
        }
        float f8 = min - 0.5f;
        float f9 = f8 > 0.0f ? 0.8f + ((f8 / 0.5f) * 0.19999999f) : 0.8f;
        int i6 = this.f47617e;
        float f10 = i6 * min;
        float f11 = i6 - (this.f47614b.f() / 2);
        if (f10 > f11) {
            f5 = f10 - f11;
        } else {
            f5 = 0.0f;
            z4 = false;
        }
        float n4 = (i4 / 2) - (this.f47614b.n() / 2);
        float f12 = f10 - (z4 ? (this.f47614b.f() / 2) + f5 : this.f47614b.f() / 2);
        float f13 = z3 ? (f4 / 4.0f) + f9 : f9;
        float f14 = z3 ? (f4 / 2.0f) + f9 : f9;
        if (this.f47619g && !z3) {
            c cVar = c.FIRST;
            if (s(cVar)) {
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (s(cVar2)) {
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (s(cVar3)) {
                        D2 = D(cVar3);
                    } else {
                        c cVar4 = c.FOURTH;
                        if (s(cVar4)) {
                            D2 = D(cVar4);
                        }
                        f14 = f13;
                    }
                    f6 = f9 + ((D2 / 80.0f) / 6.0f);
                    f13 = f6;
                    f14 = f13;
                }
            }
            f6 = f9 - ((D3 / 80.0f) / 8.0f);
            f13 = f6;
            f14 = f13;
        }
        matrix.postScale(f13, f14, this.f47614b.n() / 2, 0.0f);
        float f15 = i5 + 2;
        if ((this.f47614b.f() * f14) + f12 < f15) {
            f12 = f15 - (f14 * this.f47614b.f());
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n4, f12);
        canvas.concat(matrix);
        this.f47614b.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    private void B(Canvas canvas, int i4, int i5) {
        float D2;
        float D3;
        Matrix matrix = this.f47615c;
        matrix.reset();
        com.scwang.smartrefresh.layout.internal.pathview.b bVar = this.f47614b;
        float min = Math.min(1.0f, Math.abs(this.f47616d));
        if (isInEditMode()) {
            this.f47617e = i5;
            min = 1.0f;
        }
        float f4 = min - 0.5f;
        float f5 = f4 > 0.0f ? 0.6f + ((f4 / 0.5f) * 0.39999998f) : 0.6f;
        float f6 = this.f47617e * (1.0f - min);
        float n4 = 0 - (bVar.n() / 2);
        float n5 = i4 - (bVar.n() / 2);
        if (this.f47619g) {
            c cVar = c.FIRST;
            if (s(cVar)) {
                n4 -= (D(cVar) * 2.0f) / 4.0f;
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (s(cVar2)) {
                    n4 -= (D(cVar2) * 2.0f) / 4.0f;
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (s(cVar3)) {
                        n4 -= D(cVar3) / 4.0f;
                        D3 = D(cVar3) * 2.0f;
                    } else {
                        c cVar4 = c.FOURTH;
                        if (s(cVar4)) {
                            n4 -= D(cVar4) / 2.0f;
                            D2 = (D(cVar4) * 2.0f) / 4.0f;
                            n5 += D2;
                        }
                    }
                }
            }
            D2 = D3 / 2.0f;
            n5 += D2;
        }
        float f7 = i5 + 2;
        float f8 = (((float) bVar.f()) * f5) + f6 < f7 ? f7 - (bVar.f() * f5) : f6;
        if ((bVar.f() * f5) + f6 < f7) {
            f6 = f7 - (bVar.f() * f5);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n4, f8);
        matrix.postScale(f5, f5, (bVar.n() * 3) / 4, bVar.f());
        canvas.concat(matrix);
        bVar.setAlpha(100);
        bVar.draw(canvas);
        bVar.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(n5, f6);
        matrix.postScale(f5, f5, 0.0f, bVar.f());
        canvas.concat(matrix);
        bVar.setAlpha(100);
        bVar.draw(canvas);
        bVar.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    private void C(Canvas canvas, float f4, float f5, int i4) {
        float f6 = i4;
        float f7 = (f6 + f5) / 13.0f;
        float f8 = this.f47620h;
        if (this.f47621i - f8 > 0.0f) {
            this.f47628p = true;
            f8 = 13.0f - f8;
        } else {
            this.f47627o = true;
            this.f47628p = false;
        }
        float f9 = (f6 - (f8 * f7)) + f5;
        float f10 = this.f47626n;
        float f11 = f9 - f10;
        canvas.drawLine(f11, f4, f11 + f10, f4, this.f47625m);
    }

    private float D(c cVar) {
        float f4;
        float E2;
        int i4 = b.f47630a[cVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                c cVar2 = c.FOURTH;
                return E(cVar2) - (this.f47620h - E(cVar2));
            }
            if (i4 == 3) {
                f4 = this.f47620h;
                E2 = E(c.SECOND);
            } else if (i4 != 4) {
                return 0.0f;
            } else {
                f4 = E(c.THIRD);
                E2 = this.f47620h - E(c.FOURTH);
            }
            return f4 - E2;
        }
        return this.f47620h;
    }

    private int E(c cVar) {
        int i4 = b.f47630a[cVar.ordinal()];
        if (i4 != 2) {
            if (i4 != 3) {
                return i4 != 4 ? 0 : 20;
            }
            return E(c.FOURTH) * 3;
        }
        return 40;
    }

    private void F(Context context, AttributeSet attributeSet) {
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(100.0f));
        this.f47615c = new Matrix();
        this.f47624l = new HashMap();
        this.f47622j = new Random();
        Paint paint = new Paint();
        this.f47625m = paint;
        paint.setColor(-1);
        this.f47625m.setStrokeWidth(com.scwang.smartrefresh.layout.util.c.b(3.0f));
        this.f47625m.setAlpha(50);
        H();
        I();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TaurusHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    private float G(int i4, int i5) {
        return this.f47622j.nextInt((i5 - i4) + 1) + i4;
    }

    private void H() {
        a aVar = new a();
        this.f47618f = aVar;
        aVar.setRepeatCount(-1);
        this.f47618f.setRepeatMode(2);
        this.f47618f.setInterpolator(f47609w);
        this.f47618f.setDuration(1000L);
    }

    private void I() {
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        com.scwang.smartrefresh.layout.internal.pathview.b bVar = new com.scwang.smartrefresh.layout.internal.pathview.b();
        this.f47613a = bVar;
        bVar.i("m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z");
        this.f47613a.setBounds(0, 0, cVar.a(65.0f), cVar.a(20.0f));
        this.f47613a.h(-1);
        com.scwang.smartrefresh.layout.internal.pathview.b bVar2 = new com.scwang.smartrefresh.layout.internal.pathview.b();
        this.f47614b = bVar2;
        bVar2.i("M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z");
        this.f47614b.h(-1429742351, -571935747, -131587);
        this.f47614b.setBounds(0, 0, cVar.a(260.0f), cVar.a(45.0f));
    }

    private boolean s(c cVar) {
        int i4 = b.f47630a[cVar.ordinal()];
        return i4 != 1 ? (i4 == 2 || i4 == 3) ? this.f47620h < ((float) E(cVar)) : i4 == 4 && this.f47620h > ((float) E(c.THIRD)) : this.f47620h < ((float) E(c.FOURTH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimationTime(float f4) {
        this.f47620h = (f4 / 6.0f) * 80.0f;
        invalidate();
    }

    private void z(Canvas canvas, int i4, int i5) {
        float f4;
        float D2;
        float D3;
        Matrix matrix = this.f47615c;
        matrix.reset();
        float f5 = this.f47616d;
        if (isInEditMode()) {
            this.f47617e = i5;
            f5 = 1.0f;
        }
        if (f5 > 1.0f) {
            f4 = ((float) (1.0d - Math.pow(100.0d, (-(f5 - 1.0f)) / 2.0f))) * 20.0f;
            f5 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        float f6 = i4;
        float n4 = ((f6 * f5) / 2.0f) - (this.f47613a.n() / 2);
        float f7 = (this.f47617e * (1.0f - (f5 / 2.0f))) - (this.f47613a.f() / 2);
        if (this.f47623k) {
            n4 = ((i4 / 2) + ((f6 * (1.0f - f5)) / 2.0f)) - (this.f47613a.n() / 2);
            f7 = (f5 * ((this.f47617e / 2) + ((this.f47613a.f() * 3) / 2))) - (this.f47613a.f() * 2);
        }
        if (this.f47619g) {
            c cVar = c.FIRST;
            if (s(cVar)) {
                D3 = D(cVar);
            } else {
                c cVar2 = c.SECOND;
                if (s(cVar2)) {
                    D3 = D(cVar2);
                } else {
                    c cVar3 = c.THIRD;
                    if (s(cVar3)) {
                        D2 = D(cVar3);
                    } else {
                        c cVar4 = c.FOURTH;
                        if (s(cVar4)) {
                            D2 = D(cVar4);
                        }
                    }
                    f7 += D2;
                }
            }
            f7 -= D3;
        }
        if (f4 > 0.0f) {
            matrix.postRotate(f4, this.f47613a.n() / 2, this.f47613a.f() / 2);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n4, f7);
        canvas.concat(matrix);
        this.f47613a.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
        this.f47616d = f4;
        this.f47617e = i5;
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f4;
        int width = getWidth();
        int height = getHeight();
        if (this.f47619g) {
            while (this.f47624l.size() < 10) {
                double d4 = this.f47617e;
                Double.isNaN(d4);
                float random = (float) (d4 / (Math.random() * 5.0d));
                float G2 = G(1000, 2000);
                if (this.f47624l.size() > 1) {
                    while (true) {
                        f4 = 0.0f;
                        while (f4 == 0.0f) {
                            double d5 = this.f47617e;
                            Double.isNaN(d5);
                            float random2 = (float) (d5 / (Math.random() * 5.0d));
                            Iterator<Map.Entry<Float, Float>> it = this.f47624l.entrySet().iterator();
                            while (it.hasNext()) {
                                if (Math.abs(it.next().getKey().floatValue() - random2) > this.f47617e / 5) {
                                    f4 = random2;
                                }
                            }
                        }
                    }
                    random = f4;
                }
                this.f47624l.put(Float.valueOf(random), Float.valueOf(G2));
                C(canvas, random, G2, width);
            }
            if (this.f47624l.size() >= 10) {
                for (Map.Entry<Float, Float> entry : this.f47624l.entrySet()) {
                    C(canvas, entry.getKey().floatValue(), entry.getValue().floatValue(), width);
                }
            }
            if (this.f47628p && this.f47627o) {
                this.f47624l.clear();
                this.f47627o = false;
                this.f47626n = G(50, 300);
            }
            this.f47621i = this.f47620h;
        }
        z(canvas, width, height);
        B(canvas, width, height);
        A(canvas, width, height);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
        this.f47619g = true;
        startAnimation(this.f47618f);
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47619g = false;
        this.f47623k = true;
        clearAnimation();
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        this.f47616d = f4;
        this.f47623k = false;
        this.f47617e = i5;
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47619g = false;
        F(context, attributeSet);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47619g = false;
        F(context, attributeSet);
    }

    @RequiresApi(21)
    public TaurusHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47619g = false;
        F(context, attributeSet);
    }
}

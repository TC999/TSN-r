package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.scwang.smartrefresh.header.C11852R;
import com.scwang.smartrefresh.layout.util.ColorUtils;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MountanScenceView extends View {

    /* renamed from: A */
    private static final int f33258A = 240;

    /* renamed from: B */
    private static final int f33259B = 180;

    /* renamed from: C */
    private static final int f33260C = 100;

    /* renamed from: D */
    private static final int f33261D = 200;

    /* renamed from: a */
    private int f33262a;

    /* renamed from: b */
    private int f33263b;

    /* renamed from: c */
    private int f33264c;

    /* renamed from: d */
    private int f33265d;

    /* renamed from: e */
    private int f33266e;

    /* renamed from: f */
    private int f33267f;

    /* renamed from: g */
    private int f33268g;

    /* renamed from: h */
    private int f33269h;

    /* renamed from: i */
    private int f33270i;

    /* renamed from: j */
    private int f33271j;

    /* renamed from: k */
    private Paint f33272k;

    /* renamed from: l */
    private Paint f33273l;

    /* renamed from: m */
    private Paint f33274m;

    /* renamed from: n */
    private Paint f33275n;

    /* renamed from: o */
    private Path f33276o;

    /* renamed from: p */
    private Path f33277p;

    /* renamed from: q */
    private Path f33278q;

    /* renamed from: r */
    private Path f33279r;

    /* renamed from: s */
    private Path f33280s;

    /* renamed from: t */
    private Matrix f33281t;

    /* renamed from: u */
    private float f33282u;

    /* renamed from: v */
    private float f33283v;

    /* renamed from: w */
    private float f33284w;

    /* renamed from: x */
    private float f33285x;

    /* renamed from: y */
    private float f33286y;

    /* renamed from: z */
    private int f33287z;

    public MountanScenceView(Context context) {
        super(context);
        this.f33262a = Color.parseColor("#7ECEC9");
        this.f33263b = Color.parseColor("#86DAD7");
        this.f33264c = Color.parseColor("#3C929C");
        this.f33265d = Color.parseColor("#3E5F73");
        this.f33266e = Color.parseColor("#1F7177");
        this.f33267f = Color.parseColor("#0C3E48");
        this.f33268g = Color.parseColor("#34888F");
        this.f33269h = Color.parseColor("#1B6169");
        this.f33270i = Color.parseColor("#57B1AE");
        this.f33271j = Color.parseColor("#62A4AD");
        this.f33272k = new Paint();
        this.f33273l = new Paint();
        this.f33274m = new Paint();
        this.f33275n = new Paint();
        this.f33276o = new Path();
        this.f33277p = new Path();
        this.f33278q = new Path();
        this.f33279r = new Path();
        this.f33280s = new Path();
        this.f33281t = new Matrix();
        this.f33282u = 5.0f;
        this.f33283v = 5.0f;
        this.f33284w = 0.0f;
        this.f33285x = 1.0f;
        this.f33286y = Float.MAX_VALUE;
        this.f33287z = 0;
        m20125b(context, null, 0);
    }

    /* renamed from: a */
    private void m20126a(Canvas canvas, float f, float f2, float f3, int i, int i2) {
        canvas.save();
        canvas.translate(f2 - ((100.0f * f) / 2.0f), f3 - (200.0f * f));
        canvas.scale(f, f);
        this.f33274m.setColor(i2);
        canvas.drawPath(this.f33280s, this.f33274m);
        this.f33273l.setColor(i);
        canvas.drawPath(this.f33279r, this.f33273l);
        this.f33275n.setColor(i);
        canvas.drawPath(this.f33280s, this.f33275n);
        canvas.restore();
    }

    /* renamed from: b */
    private void m20125b(Context context, AttributeSet attributeSet, int i) {
        this.f33272k.setAntiAlias(true);
        this.f33272k.setStyle(Paint.Style.FILL);
        this.f33273l.setAntiAlias(true);
        this.f33274m.setAntiAlias(true);
        this.f33275n.setAntiAlias(true);
        this.f33275n.setStyle(Paint.Style.STROKE);
        this.f33275n.setStrokeWidth(2.0f);
        this.f33275n.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.MountanScenceView);
        int i2 = C11852R.styleable.MountanScenceView_msvPrimaryColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            setPrimaryColor(obtainStyledAttributes.getColor(i2, ViewCompat.MEASURED_STATE_MASK));
        }
        this.f33287z = obtainStyledAttributes.getDimensionPixelOffset(C11852R.styleable.MountanScenceView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        m20124c(this.f33284w, 180);
        m20122e(this.f33284w, true);
    }

    /* renamed from: c */
    private void m20124c(float f, int i) {
        this.f33281t.reset();
        this.f33281t.setScale(this.f33282u, this.f33283v);
        int i2 = (int) (10.0f * f);
        this.f33276o.reset();
        this.f33276o.moveTo(0.0f, i2 + 95);
        this.f33276o.lineTo(55.0f, i2 + 74);
        this.f33276o.lineTo(146.0f, i2 + 104);
        this.f33276o.lineTo(227.0f, i2 + 72);
        this.f33276o.lineTo(240.0f, i2 + 80);
        this.f33276o.lineTo(240.0f, 180.0f);
        this.f33276o.lineTo(0.0f, 180.0f);
        this.f33276o.close();
        this.f33276o.transform(this.f33281t);
        int i3 = (int) (20.0f * f);
        this.f33277p.reset();
        this.f33277p.moveTo(0.0f, i3 + 103);
        this.f33277p.lineTo(67.0f, i3 + 90);
        this.f33277p.lineTo(165.0f, i3 + 115);
        this.f33277p.lineTo(221.0f, i3 + 87);
        this.f33277p.lineTo(240.0f, i3 + 100);
        this.f33277p.lineTo(240.0f, 180.0f);
        this.f33277p.lineTo(0.0f, 180.0f);
        this.f33277p.close();
        this.f33277p.transform(this.f33281t);
        int i4 = (int) (f * 30.0f);
        this.f33278q.reset();
        this.f33278q.moveTo(0.0f, i4 + 114);
        this.f33278q.cubicTo(30.0f, i4 + 106, 196.0f, i4 + 97, 240.0f, i4 + 104);
        float f2 = i;
        this.f33278q.lineTo(240.0f, f2 / this.f33283v);
        this.f33278q.lineTo(0.0f, f2 / this.f33283v);
        this.f33278q.close();
        this.f33278q.transform(this.f33281t);
    }

    /* renamed from: e */
    private void m20122e(float f, boolean z) {
        int i;
        if (f != this.f33286y || z) {
            Interpolator m20121a = PathInterpolatorCompat.m20121a(0.8f, (-0.5f) * f);
            float f2 = f * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i2 = 0;
            float f3 = 0.0f;
            float f4 = 200.0f;
            while (true) {
                if (i2 > 25) {
                    break;
                }
                fArr[i2] = (m20121a.getInterpolation(f3) * f2) + 50.0f;
                fArr2[i2] = f4;
                f4 -= 8.0f;
                f3 += 0.04f;
                i2++;
            }
            this.f33279r.reset();
            this.f33279r.moveTo(45.0f, 200.0f);
            int i3 = (int) (17 * 0.5f);
            float f5 = 17 - i3;
            for (int i4 = 0; i4 < 17; i4++) {
                if (i4 < i3) {
                    this.f33279r.lineTo(fArr[i4] - 5.0f, fArr2[i4]);
                } else {
                    this.f33279r.lineTo(fArr[i4] - (((17 - i4) * 5.0f) / f5), fArr2[i4]);
                }
            }
            for (int i5 = 16; i5 >= 0; i5--) {
                if (i5 < i3) {
                    this.f33279r.lineTo(fArr[i5] + 5.0f, fArr2[i5]);
                } else {
                    this.f33279r.lineTo(fArr[i5] + (((17 - i5) * 5.0f) / f5), fArr2[i5]);
                }
            }
            this.f33279r.close();
            this.f33280s.reset();
            float f6 = 15;
            this.f33280s.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.f33280s.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i6 = 10; i6 <= 25; i6++) {
                float f7 = (i6 - 10) / f6;
                this.f33280s.lineTo((fArr[i6] - 20.0f) + (f7 * f7 * 20.0f), fArr2[i6]);
            }
            for (i = 25; i >= 10; i--) {
                float f8 = (i - 10) / f6;
                this.f33280s.lineTo((fArr[i] + 20.0f) - ((f8 * f8) * 20.0f), fArr2[i]);
            }
        }
    }

    /* renamed from: d */
    public void m20123d(float f) {
        this.f33285x = f;
        float max = Math.max(0.0f, f);
        this.f33284w = Math.max(0.0f, this.f33285x);
        int measuredHeight = getMeasuredHeight();
        float f2 = this.f33284w;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        m20124c(f2, measuredHeight);
        m20122e(max, false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.f33262a);
        this.f33272k.setColor(this.f33263b);
        canvas.drawPath(this.f33276o, this.f33272k);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, 0.0f);
        float f = this.f33282u;
        m20126a(canvas, f * 0.12f, f * 180.0f, ((this.f33284w * 20.0f) + 93.0f) * this.f33283v, this.f33271j, this.f33270i);
        float f2 = this.f33282u;
        m20126a(canvas, f2 * 0.1f, f2 * 200.0f, ((this.f33284w * 20.0f) + 96.0f) * this.f33283v, this.f33271j, this.f33270i);
        canvas.restore();
        this.f33272k.setColor(this.f33264c);
        canvas.drawPath(this.f33277p, this.f33272k);
        float f3 = this.f33282u;
        m20126a(canvas, f3 * 0.2f, f3 * 160.0f, ((this.f33284w * 30.0f) + 105.0f) * this.f33283v, this.f33267f, this.f33266e);
        float f4 = this.f33282u;
        m20126a(canvas, f4 * 0.14f, f4 * 180.0f, ((this.f33284w * 30.0f) + 105.0f) * this.f33283v, this.f33269h, this.f33268g);
        float f5 = this.f33282u;
        m20126a(canvas, f5 * 0.16f, f5 * 140.0f, ((this.f33284w * 30.0f) + 105.0f) * this.f33283v, this.f33269h, this.f33268g);
        this.f33272k.setColor(this.f33265d);
        canvas.drawPath(this.f33278q, this.f33272k);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f33282u = (measuredWidth * 1.0f) / 240.0f;
        int i3 = this.f33287z;
        if (i3 <= 0) {
            i3 = measuredHeight;
        }
        this.f33283v = (i3 * 1.0f) / 180.0f;
        m20124c(this.f33284w, measuredHeight);
        m20122e(this.f33284w, true);
    }

    public void setPrimaryColor(@ColorInt int i) {
        this.f33262a = i;
        this.f33263b = ColorUtils.m19774t(-1711276033, i);
        this.f33264c = ColorUtils.m19774t(-1724083556, i);
        this.f33265d = ColorUtils.m19774t(-868327565, i);
        this.f33266e = ColorUtils.m19774t(1428124023, i);
        this.f33267f = ColorUtils.m19774t(-871612856, i);
        this.f33268g = ColorUtils.m19774t(1429506191, i);
        this.f33269h = ColorUtils.m19774t(-870620823, i);
        this.f33270i = ColorUtils.m19774t(1431810478, i);
        this.f33271j = ColorUtils.m19774t(-865950547, i);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33262a = Color.parseColor("#7ECEC9");
        this.f33263b = Color.parseColor("#86DAD7");
        this.f33264c = Color.parseColor("#3C929C");
        this.f33265d = Color.parseColor("#3E5F73");
        this.f33266e = Color.parseColor("#1F7177");
        this.f33267f = Color.parseColor("#0C3E48");
        this.f33268g = Color.parseColor("#34888F");
        this.f33269h = Color.parseColor("#1B6169");
        this.f33270i = Color.parseColor("#57B1AE");
        this.f33271j = Color.parseColor("#62A4AD");
        this.f33272k = new Paint();
        this.f33273l = new Paint();
        this.f33274m = new Paint();
        this.f33275n = new Paint();
        this.f33276o = new Path();
        this.f33277p = new Path();
        this.f33278q = new Path();
        this.f33279r = new Path();
        this.f33280s = new Path();
        this.f33281t = new Matrix();
        this.f33282u = 5.0f;
        this.f33283v = 5.0f;
        this.f33284w = 0.0f;
        this.f33285x = 1.0f;
        this.f33286y = Float.MAX_VALUE;
        this.f33287z = 0;
        m20125b(context, attributeSet, 0);
    }

    public MountanScenceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33262a = Color.parseColor("#7ECEC9");
        this.f33263b = Color.parseColor("#86DAD7");
        this.f33264c = Color.parseColor("#3C929C");
        this.f33265d = Color.parseColor("#3E5F73");
        this.f33266e = Color.parseColor("#1F7177");
        this.f33267f = Color.parseColor("#0C3E48");
        this.f33268g = Color.parseColor("#34888F");
        this.f33269h = Color.parseColor("#1B6169");
        this.f33270i = Color.parseColor("#57B1AE");
        this.f33271j = Color.parseColor("#62A4AD");
        this.f33272k = new Paint();
        this.f33273l = new Paint();
        this.f33274m = new Paint();
        this.f33275n = new Paint();
        this.f33276o = new Path();
        this.f33277p = new Path();
        this.f33278q = new Path();
        this.f33279r = new Path();
        this.f33280s = new Path();
        this.f33281t = new Matrix();
        this.f33282u = 5.0f;
        this.f33283v = 5.0f;
        this.f33284w = 0.0f;
        this.f33285x = 1.0f;
        this.f33286y = Float.MAX_VALUE;
        this.f33287z = 0;
        m20125b(context, attributeSet, i);
    }

    @RequiresApi(21)
    public MountanScenceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33262a = Color.parseColor("#7ECEC9");
        this.f33263b = Color.parseColor("#86DAD7");
        this.f33264c = Color.parseColor("#3C929C");
        this.f33265d = Color.parseColor("#3E5F73");
        this.f33266e = Color.parseColor("#1F7177");
        this.f33267f = Color.parseColor("#0C3E48");
        this.f33268g = Color.parseColor("#34888F");
        this.f33269h = Color.parseColor("#1B6169");
        this.f33270i = Color.parseColor("#57B1AE");
        this.f33271j = Color.parseColor("#62A4AD");
        this.f33272k = new Paint();
        this.f33273l = new Paint();
        this.f33274m = new Paint();
        this.f33275n = new Paint();
        this.f33276o = new Path();
        this.f33277p = new Path();
        this.f33278q = new Path();
        this.f33279r = new Path();
        this.f33280s = new Path();
        this.f33281t = new Matrix();
        this.f33282u = 5.0f;
        this.f33283v = 5.0f;
        this.f33284w = 0.0f;
        this.f33285x = 1.0f;
        this.f33286y = Float.MAX_VALUE;
        this.f33287z = 0;
        m20125b(context, attributeSet, i);
    }
}

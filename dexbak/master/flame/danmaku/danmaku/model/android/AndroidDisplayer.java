package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.p518qq.p519e.comm.adevent.AdEventType;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.AlphaValue;
import master.flame.danmaku.danmaku.model.BaseDanmaku;

/* renamed from: master.flame.danmaku.danmaku.model.android.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class AndroidDisplayer extends AbsDisplayer<Canvas, Typeface> {

    /* renamed from: j */
    public Canvas f43726j;

    /* renamed from: k */
    private int f43727k;

    /* renamed from: l */
    private int f43728l;

    /* renamed from: m */
    private float f43729m;

    /* renamed from: f */
    private Camera f43722f = new Camera();

    /* renamed from: g */
    private Matrix f43723g = new Matrix();

    /* renamed from: h */
    private final C15343a f43724h = new C15343a();

    /* renamed from: i */
    private BaseCacheStuffer f43725i = new SimpleTextCacheStuffer();

    /* renamed from: n */
    private float f43730n = 1.0f;

    /* renamed from: o */
    private int f43731o = 160;

    /* renamed from: p */
    private float f43732p = 1.0f;

    /* renamed from: q */
    private int f43733q = 0;

    /* renamed from: r */
    private boolean f43734r = true;

    /* renamed from: s */
    private int f43735s = 2048;

    /* renamed from: t */
    private int f43736t = 2048;

    /* compiled from: AndroidDisplayer.java */
    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15343a {

        /* renamed from: B */
        public static final int f43737B = 4;

        /* renamed from: a */
        private float f43739a;

        /* renamed from: c */
        public final TextPaint f43741c;

        /* renamed from: d */
        public final TextPaint f43742d;

        /* renamed from: e */
        private Paint f43743e;

        /* renamed from: f */
        private Paint f43744f;

        /* renamed from: g */
        private Paint f43745g;

        /* renamed from: v */
        private boolean f43760v;

        /* renamed from: b */
        private final Map<Float, Float> f43740b = new HashMap(10);

        /* renamed from: h */
        public int f43746h = 4;

        /* renamed from: i */
        private float f43747i = 4.0f;

        /* renamed from: j */
        private float f43748j = 3.5f;

        /* renamed from: k */
        public float f43749k = 1.0f;

        /* renamed from: l */
        public float f43750l = 1.0f;

        /* renamed from: m */
        private int f43751m = AdEventType.VIDEO_PAUSE;

        /* renamed from: n */
        public boolean f43752n = false;

        /* renamed from: o */
        private boolean f43753o = false;

        /* renamed from: p */
        public boolean f43754p = true;

        /* renamed from: q */
        private boolean f43755q = true;

        /* renamed from: r */
        public boolean f43756r = false;

        /* renamed from: s */
        public boolean f43757s = false;

        /* renamed from: t */
        public boolean f43758t = true;

        /* renamed from: u */
        private boolean f43759u = true;

        /* renamed from: w */
        private int f43761w = AlphaValue.f43835a;

        /* renamed from: x */
        private float f43762x = 1.0f;

        /* renamed from: y */
        private boolean f43763y = false;

        /* renamed from: z */
        private int f43764z = 0;

        /* renamed from: A */
        private int f43738A = 0;

        public C15343a() {
            TextPaint textPaint = new TextPaint();
            this.f43741c = textPaint;
            textPaint.setStrokeWidth(this.f43748j);
            this.f43742d = new TextPaint(textPaint);
            this.f43743e = new Paint();
            Paint paint = new Paint();
            this.f43744f = paint;
            paint.setStrokeWidth(this.f43746h);
            this.f43744f.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f43745g = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.f43745g.setStrokeWidth(4.0f);
        }

        /* renamed from: h */
        private void m3178h(BaseDanmaku baseDanmaku, Paint paint) {
            if (this.f43763y) {
                Float f = this.f43740b.get(Float.valueOf(baseDanmaku.f43870l));
                if (f == null || this.f43739a != this.f43762x) {
                    float f2 = this.f43762x;
                    this.f43739a = f2;
                    f = Float.valueOf(baseDanmaku.f43870l * f2);
                    this.f43740b.put(Float.valueOf(baseDanmaku.f43870l), f);
                }
                paint.setTextSize(f.floatValue());
            }
        }

        /* renamed from: g */
        public void m3179g(BaseDanmaku baseDanmaku, Paint paint, boolean z) {
            if (this.f43760v) {
                if (z) {
                    paint.setStyle(this.f43757s ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(baseDanmaku.f43868j & 16777215);
                    paint.setAlpha(this.f43757s ? (int) (this.f43751m * (this.f43761w / AlphaValue.f43835a)) : this.f43761w);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(baseDanmaku.f43865g & 16777215);
                    paint.setAlpha(this.f43761w);
                }
            } else if (z) {
                paint.setStyle(this.f43757s ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(baseDanmaku.f43868j & 16777215);
                paint.setAlpha(this.f43757s ? this.f43751m : AlphaValue.f43835a);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(baseDanmaku.f43865g & 16777215);
                paint.setAlpha(AlphaValue.f43835a);
            }
            if (baseDanmaku.getType() == 7) {
                paint.setAlpha(baseDanmaku.m3087c());
            }
        }

        /* renamed from: i */
        public void m3177i() {
            this.f43740b.clear();
        }

        /* renamed from: j */
        public void m3176j(boolean z) {
            this.f43755q = this.f43754p;
            this.f43753o = this.f43752n;
            this.f43757s = this.f43756r;
            this.f43759u = z && this.f43758t;
        }

        /* renamed from: k */
        public Paint m3175k(BaseDanmaku baseDanmaku) {
            this.f43745g.setColor(baseDanmaku.f43871m);
            return this.f43745g;
        }

        /* renamed from: l */
        public TextPaint m3174l(BaseDanmaku baseDanmaku, boolean z) {
            TextPaint textPaint;
            int i;
            if (z) {
                textPaint = this.f43741c;
            } else {
                textPaint = this.f43742d;
                textPaint.set(this.f43741c);
            }
            textPaint.setTextSize(baseDanmaku.f43870l);
            m3178h(baseDanmaku, textPaint);
            if (this.f43753o) {
                float f = this.f43747i;
                if (f > 0.0f && (i = baseDanmaku.f43868j) != 0) {
                    textPaint.setShadowLayer(f, 0.0f, 0.0f, i);
                    textPaint.setAntiAlias(this.f43759u);
                    return textPaint;
                }
            }
            textPaint.clearShadowLayer();
            textPaint.setAntiAlias(this.f43759u);
            return textPaint;
        }

        /* renamed from: m */
        public float m3173m() {
            boolean z = this.f43753o;
            if (z && this.f43755q) {
                return Math.max(this.f43747i, this.f43748j);
            }
            if (z) {
                return this.f43747i;
            }
            if (this.f43755q) {
                return this.f43748j;
            }
            return 0.0f;
        }

        /* renamed from: n */
        public Paint m3172n(BaseDanmaku baseDanmaku) {
            this.f43744f.setColor(baseDanmaku.f43869k);
            return this.f43744f;
        }

        /* renamed from: o */
        public boolean m3171o(BaseDanmaku baseDanmaku) {
            return (this.f43755q || this.f43757s) && this.f43748j > 0.0f && baseDanmaku.f43868j != 0;
        }

        /* renamed from: p */
        public void m3170p(boolean z) {
            this.f43741c.setFakeBoldText(z);
        }

        /* renamed from: q */
        public void m3169q(float f, float f2, int i) {
            if (this.f43749k == f && this.f43750l == f2 && this.f43751m == i) {
                return;
            }
            if (f <= 1.0f) {
                f = 1.0f;
            }
            this.f43749k = f;
            if (f2 <= 1.0f) {
                f2 = 1.0f;
            }
            this.f43750l = f2;
            if (i < 0) {
                i = 0;
            } else if (i > 255) {
                i = 255;
            }
            this.f43751m = i;
        }

        /* renamed from: r */
        public void m3168r(float f) {
            this.f43763y = f != 1.0f;
            this.f43762x = f;
        }

        /* renamed from: s */
        public void m3167s(float f) {
            this.f43747i = f;
        }

        /* renamed from: t */
        public void m3166t(float f) {
            this.f43741c.setStrokeWidth(f);
            this.f43748j = f;
        }

        /* renamed from: u */
        public void m3165u(int i) {
            this.f43760v = i != AlphaValue.f43835a;
            this.f43761w = i;
        }

        /* renamed from: v */
        public void m3164v(Typeface typeface) {
            this.f43741c.setTypeface(typeface);
        }
    }

    /* renamed from: E */
    private void m3200E(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z) {
        this.f43725i.mo3116e(baseDanmaku, textPaint, z);
        m3191N(baseDanmaku, baseDanmaku.f43874p, baseDanmaku.f43875q);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: H */
    private static final int m3197H(Canvas canvas) {
        return canvas.getMaximumBitmapHeight();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: I */
    private static final int m3196I(Canvas canvas) {
        return canvas.getMaximumBitmapWidth();
    }

    /* renamed from: J */
    private synchronized TextPaint m3195J(BaseDanmaku baseDanmaku, boolean z) {
        return this.f43724h.m3174l(baseDanmaku, z);
    }

    /* renamed from: K */
    private void m3194K(Paint paint) {
        int alpha = paint.getAlpha();
        int i = AlphaValue.f43835a;
        if (alpha != i) {
            paint.setAlpha(i);
        }
    }

    /* renamed from: L */
    private void m3193L(Canvas canvas) {
        canvas.restore();
    }

    /* renamed from: M */
    private int m3192M(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2) {
        this.f43722f.save();
        float f3 = this.f43729m;
        if (f3 != 0.0f) {
            this.f43722f.setLocation(0.0f, 0.0f, f3);
        }
        this.f43722f.rotateY(-baseDanmaku.f43867i);
        this.f43722f.rotateZ(-baseDanmaku.f43866h);
        this.f43722f.getMatrix(this.f43723g);
        this.f43723g.preTranslate(-f, -f2);
        this.f43723g.postTranslate(f, f2);
        this.f43722f.restore();
        int save = canvas.save();
        canvas.concat(this.f43723g);
        return save;
    }

    /* renamed from: N */
    private void m3191N(BaseDanmaku baseDanmaku, float f, float f2) {
        int i = baseDanmaku.f43872n;
        float f3 = f + (i * 2);
        float f4 = f2 + (i * 2);
        if (baseDanmaku.f43871m != 0) {
            float f5 = 8;
            f3 += f5;
            f4 += f5;
        }
        baseDanmaku.f43874p = f3 + mo3026t();
        baseDanmaku.f43875q = f4;
    }

    private void update(Canvas canvas) {
        this.f43726j = canvas;
        if (canvas != null) {
            this.f43727k = canvas.getWidth();
            this.f43728l = canvas.getHeight();
            if (this.f43734r) {
                this.f43735s = m3196I(canvas);
                this.f43736t = m3197H(canvas);
            }
        }
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: A */
    public void mo3106A(boolean z) {
        this.f43724h.m3170p(z);
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: B */
    public void mo3105B(float f) {
        this.f43724h.m3168r(f);
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: C */
    public void mo3104C(int i) {
        this.f43724h.m3165u(i);
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: F */
    public synchronized void mo3101v(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z) {
        BaseCacheStuffer baseCacheStuffer = this.f43725i;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.mo3117d(baseDanmaku, canvas, f, f2, z, this.f43724h);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: G */
    public Canvas mo3099x() {
        return this.f43726j;
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: O */
    public void mo3097z(Canvas canvas) {
        update(canvas);
    }

    /* renamed from: P */
    public void m3189P(float f) {
        this.f43724h.m3166t(f);
    }

    /* renamed from: Q */
    public void m3188Q(float f, float f2, int i) {
        this.f43724h.m3169q(f, f2, i);
    }

    /* renamed from: R */
    public void m3187R(float f) {
        this.f43724h.m3167s(f);
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: S */
    public void mo3103D(Typeface typeface) {
        this.f43724h.m3164v(typeface);
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: a */
    public void mo3045a(float f) {
        float max = Math.max(f, getWidth() / 682.0f) * 25.0f;
        this.f43733q = (int) max;
        if (f > 1.0f) {
            this.f43733q = (int) (max * f);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: b */
    public int mo3044b() {
        return this.f43733q;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: c */
    public void mo3043c(int i, float[] fArr) {
        if (i != -1) {
            if (i == 0) {
                C15343a c15343a = this.f43724h;
                c15343a.f43752n = false;
                c15343a.f43754p = false;
                c15343a.f43756r = false;
                return;
            } else if (i == 1) {
                C15343a c15343a2 = this.f43724h;
                c15343a2.f43752n = true;
                c15343a2.f43754p = false;
                c15343a2.f43756r = false;
                m3187R(fArr[0]);
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                C15343a c15343a3 = this.f43724h;
                c15343a3.f43752n = false;
                c15343a3.f43754p = false;
                c15343a3.f43756r = true;
                m3188Q(fArr[0], fArr[1], (int) fArr[2]);
                return;
            }
        }
        C15343a c15343a4 = this.f43724h;
        c15343a4.f43752n = false;
        c15343a4.f43754p = true;
        c15343a4.f43756r = false;
        m3189P(fArr[0]);
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: d */
    public void mo3042d(float f, int i, float f2) {
        this.f43730n = f;
        this.f43731o = i;
        this.f43732p = f2;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: e */
    public int mo3041e() {
        return this.f43731o;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: f */
    public float mo3040f() {
        return this.f43732p;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: g */
    public int mo3039g() {
        return this.f43735s;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    public int getHeight() {
        return this.f43728l;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    public int getWidth() {
        return this.f43727k;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: h */
    public void mo3038h(int i, int i2) {
        this.f43727k = i;
        this.f43728l = i2;
        double d = i / 2.0f;
        double tan = Math.tan(0.4799655442984406d);
        Double.isNaN(d);
        this.f43729m = (float) (d / tan);
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: i */
    public float mo3037i() {
        return this.f43730n;
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer, master.flame.danmaku.danmaku.model.IDisplayer
    public boolean isHardwareAccelerated() {
        return this.f43734r;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: j */
    public void mo3036j(BaseDanmaku baseDanmaku, boolean z) {
        TextPaint m3195J = m3195J(baseDanmaku, z);
        if (this.f43724h.f43755q) {
            this.f43724h.m3179g(baseDanmaku, m3195J, true);
        }
        m3200E(baseDanmaku, m3195J, z);
        if (this.f43724h.f43755q) {
            this.f43724h.m3179g(baseDanmaku, m3195J, false);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: k */
    public void mo3035k(int i) {
        this.f43724h.f43764z = i;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: l */
    public int mo3034l(BaseDanmaku baseDanmaku) {
        Paint paint;
        boolean z;
        boolean z2;
        float mo2996l = baseDanmaku.mo2996l();
        float mo2999g = baseDanmaku.mo2999g();
        if (this.f43726j != null) {
            Paint paint2 = null;
            int i = 1;
            if (baseDanmaku.getType() != 7) {
                paint = null;
                z = false;
            } else if (baseDanmaku.m3087c() == AlphaValue.f43836b) {
                return 0;
            } else {
                if (baseDanmaku.f43866h == 0.0f && baseDanmaku.f43867i == 0.0f) {
                    z2 = false;
                } else {
                    m3192M(baseDanmaku, this.f43726j, mo2999g, mo2996l);
                    z2 = true;
                }
                if (baseDanmaku.m3087c() != AlphaValue.f43835a) {
                    paint2 = this.f43724h.f43743e;
                    paint2.setAlpha(baseDanmaku.m3087c());
                }
                paint = paint2;
                z = z2;
            }
            if (paint == null || paint.getAlpha() != AlphaValue.f43836b) {
                if (!this.f43725i.m3163c(baseDanmaku, this.f43726j, mo2999g, mo2996l, paint, this.f43724h.f43741c)) {
                    if (paint != null) {
                        this.f43724h.f43741c.setAlpha(paint.getAlpha());
                        this.f43724h.f43742d.setAlpha(paint.getAlpha());
                    } else {
                        m3194K(this.f43724h.f43741c);
                    }
                    mo3101v(baseDanmaku, this.f43726j, mo2999g, mo2996l, false);
                    i = 2;
                }
                if (z) {
                    m3193L(this.f43726j);
                }
                return i;
            }
            return 0;
        }
        return 0;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: m */
    public void mo3033m(int i) {
        this.f43724h.f43738A = i;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: n */
    public void mo3032n(BaseDanmaku baseDanmaku) {
        BaseCacheStuffer baseCacheStuffer = this.f43725i;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.mo3115g(baseDanmaku);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: o */
    public int mo3031o() {
        return this.f43724h.f43764z;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: p */
    public int mo3030p() {
        return this.f43736t;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: q */
    public void mo3029q(boolean z) {
        this.f43734r = z;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: r */
    public int mo3028r() {
        return this.f43724h.f43738A;
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: s */
    public void mo3027s(BaseDanmaku baseDanmaku, boolean z) {
        BaseCacheStuffer baseCacheStuffer = this.f43725i;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.m3162f(baseDanmaku, z);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDisplayer
    /* renamed from: t */
    public float mo3026t() {
        return this.f43724h.m3173m();
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: u */
    public void mo3102u() {
        this.f43725i.mo3118b();
        this.f43724h.m3177i();
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: w */
    public BaseCacheStuffer mo3100w() {
        return this.f43725i;
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDisplayer
    /* renamed from: y */
    public void mo3098y(BaseCacheStuffer baseCacheStuffer) {
        if (baseCacheStuffer != this.f43725i) {
            this.f43725i = baseCacheStuffer;
        }
    }
}

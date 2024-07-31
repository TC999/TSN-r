package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.android.AndroidDisplayer;

/* renamed from: master.flame.danmaku.danmaku.model.android.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SimpleTextCacheStuffer extends BaseCacheStuffer {

    /* renamed from: b */
    private static final Map<Float, Float> f43826b = new HashMap();

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: b */
    public void mo3118b() {
        f43826b.clear();
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: d */
    public void mo3117d(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.C15343a c15343a) {
        float f3;
        float f4;
        int i;
        float f5;
        float f6;
        float f7;
        float f8;
        int i2 = baseDanmaku.f43872n;
        float f9 = f + i2;
        float f10 = f2 + i2;
        if (baseDanmaku.f43871m != 0) {
            f9 += 4.0f;
            f10 += 4.0f;
        }
        float f11 = f10;
        float f12 = f9;
        c15343a.m3176j(z);
        TextPaint m3174l = c15343a.m3174l(baseDanmaku, z);
        m3123i(baseDanmaku, canvas, f, f2);
        String[] strArr = baseDanmaku.f43862d;
        boolean z2 = true;
        boolean z3 = false;
        if (strArr != null) {
            if (strArr.length == 1) {
                if (c15343a.m3171o(baseDanmaku)) {
                    c15343a.m3179g(baseDanmaku, m3174l, true);
                    float ascent = f11 - m3174l.ascent();
                    if (c15343a.f43757s) {
                        f7 = ascent + c15343a.f43750l;
                        f8 = c15343a.f43749k + f12;
                    } else {
                        f7 = ascent;
                        f8 = f12;
                    }
                    mo3120j(baseDanmaku, strArr[0], canvas, f8, f7, m3174l);
                }
                c15343a.m3179g(baseDanmaku, m3174l, false);
                mo3119k(baseDanmaku, strArr[0], canvas, f12, f11 - m3174l.ascent(), m3174l, z);
            } else {
                float length = (baseDanmaku.f43875q - (baseDanmaku.f43872n * 2)) / strArr.length;
                int i3 = 0;
                while (i3 < strArr.length) {
                    if (strArr[i3] == null || strArr[i3].length() == 0) {
                        i = i3;
                    } else {
                        if (c15343a.m3171o(baseDanmaku)) {
                            c15343a.m3179g(baseDanmaku, m3174l, z2);
                            float ascent2 = ((i3 * length) + f11) - m3174l.ascent();
                            if (c15343a.f43757s) {
                                f5 = ascent2 + c15343a.f43750l;
                                f6 = c15343a.f43749k + f12;
                            } else {
                                f5 = ascent2;
                                f6 = f12;
                            }
                            i = i3;
                            mo3120j(baseDanmaku, strArr[i3], canvas, f6, f5, m3174l);
                        } else {
                            i = i3;
                        }
                        c15343a.m3179g(baseDanmaku, m3174l, z3);
                        mo3119k(baseDanmaku, strArr[i], canvas, f12, ((i * length) + f11) - m3174l.ascent(), m3174l, z);
                    }
                    i3 = i + 1;
                    z3 = false;
                    z2 = true;
                }
            }
        } else {
            if (c15343a.m3171o(baseDanmaku)) {
                c15343a.m3179g(baseDanmaku, m3174l, true);
                float ascent3 = f11 - m3174l.ascent();
                if (c15343a.f43757s) {
                    f3 = ascent3 + c15343a.f43750l;
                    f4 = c15343a.f43749k + f12;
                } else {
                    f3 = ascent3;
                    f4 = f12;
                }
                mo3120j(baseDanmaku, null, canvas, f4, f3, m3174l);
            }
            c15343a.m3179g(baseDanmaku, m3174l, false);
            mo3119k(baseDanmaku, null, canvas, f12, f11 - m3174l.ascent(), m3174l, z);
        }
        if (baseDanmaku.f43869k != 0) {
            Paint m3172n = c15343a.m3172n(baseDanmaku);
            float f13 = (f2 + baseDanmaku.f43875q) - c15343a.f43746h;
            canvas.drawLine(f, f13, f + baseDanmaku.f43874p, f13, m3172n);
        }
        if (baseDanmaku.f43871m != 0) {
            canvas.drawRect(f, f2, f + baseDanmaku.f43874p, f2 + baseDanmaku.f43875q, c15343a.m3175k(baseDanmaku));
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: e */
    public void mo3116e(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z) {
        String[] strArr;
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (baseDanmaku.f43862d == null) {
            CharSequence charSequence = baseDanmaku.f43861c;
            if (charSequence != null) {
                f = textPaint.measureText(charSequence.toString());
                valueOf = m3122l(baseDanmaku, textPaint);
            }
            baseDanmaku.f43874p = f;
            baseDanmaku.f43875q = valueOf.floatValue();
            return;
        }
        Float m3122l = m3122l(baseDanmaku, textPaint);
        for (String str : baseDanmaku.f43862d) {
            if (str.length() > 0) {
                f = Math.max(textPaint.measureText(str), f);
            }
        }
        baseDanmaku.f43874p = f;
        baseDanmaku.f43875q = baseDanmaku.f43862d.length * m3122l.floatValue();
    }

    /* renamed from: i */
    protected void m3123i(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public void mo3120j(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else {
            canvas.drawText(baseDanmaku.f43861c.toString(), f, f2, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void mo3119k(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        if (str != null) {
            canvas.drawText(str, f, f2, textPaint);
        } else {
            canvas.drawText(baseDanmaku.f43861c.toString(), f, f2, textPaint);
        }
    }

    /* renamed from: l */
    protected Float m3122l(BaseDanmaku baseDanmaku, Paint paint) {
        Float valueOf = Float.valueOf(paint.getTextSize());
        Map<Float, Float> map = f43826b;
        Float f = map.get(valueOf);
        if (f == null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Float valueOf2 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(valueOf, valueOf2);
            return valueOf2;
        }
        return f;
    }
}

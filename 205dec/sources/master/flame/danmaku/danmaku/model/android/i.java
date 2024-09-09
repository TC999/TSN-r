package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SimpleTextCacheStuffer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Float, Float> f61134b = new HashMap();

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b() {
        f61134b.clear();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5, boolean z3, a.C1239a c1239a) {
        float f6;
        float f7;
        int i4;
        float f8;
        float f9;
        float f10;
        float f11;
        int i5 = dVar.f61159n;
        float f12 = f4 + i5;
        float f13 = f5 + i5;
        if (dVar.f61158m != 0) {
            f12 += 4.0f;
            f13 += 4.0f;
        }
        float f14 = f13;
        float f15 = f12;
        c1239a.j(z3);
        TextPaint l4 = c1239a.l(dVar, z3);
        i(dVar, canvas, f4, f5);
        String[] strArr = dVar.f61149d;
        boolean z4 = true;
        boolean z5 = false;
        if (strArr != null) {
            if (strArr.length == 1) {
                if (c1239a.o(dVar)) {
                    c1239a.g(dVar, l4, true);
                    float ascent = f14 - l4.ascent();
                    if (c1239a.f61065s) {
                        f10 = ascent + c1239a.f61058l;
                        f11 = c1239a.f61057k + f15;
                    } else {
                        f10 = ascent;
                        f11 = f15;
                    }
                    j(dVar, strArr[0], canvas, f11, f10, l4);
                }
                c1239a.g(dVar, l4, false);
                k(dVar, strArr[0], canvas, f15, f14 - l4.ascent(), l4, z3);
            } else {
                float length = (dVar.f61162q - (dVar.f61159n * 2)) / strArr.length;
                int i6 = 0;
                while (i6 < strArr.length) {
                    if (strArr[i6] == null || strArr[i6].length() == 0) {
                        i4 = i6;
                    } else {
                        if (c1239a.o(dVar)) {
                            c1239a.g(dVar, l4, z4);
                            float ascent2 = ((i6 * length) + f14) - l4.ascent();
                            if (c1239a.f61065s) {
                                f8 = ascent2 + c1239a.f61058l;
                                f9 = c1239a.f61057k + f15;
                            } else {
                                f8 = ascent2;
                                f9 = f15;
                            }
                            i4 = i6;
                            j(dVar, strArr[i6], canvas, f9, f8, l4);
                        } else {
                            i4 = i6;
                        }
                        c1239a.g(dVar, l4, z5);
                        k(dVar, strArr[i4], canvas, f15, ((i4 * length) + f14) - l4.ascent(), l4, z3);
                    }
                    i6 = i4 + 1;
                    z5 = false;
                    z4 = true;
                }
            }
        } else {
            if (c1239a.o(dVar)) {
                c1239a.g(dVar, l4, true);
                float ascent3 = f14 - l4.ascent();
                if (c1239a.f61065s) {
                    f6 = ascent3 + c1239a.f61058l;
                    f7 = c1239a.f61057k + f15;
                } else {
                    f6 = ascent3;
                    f7 = f15;
                }
                j(dVar, null, canvas, f7, f6, l4);
            }
            c1239a.g(dVar, l4, false);
            k(dVar, null, canvas, f15, f14 - l4.ascent(), l4, z3);
        }
        if (dVar.f61156k != 0) {
            Paint n4 = c1239a.n(dVar);
            float f16 = (f5 + dVar.f61162q) - c1239a.f61054h;
            canvas.drawLine(f4, f16, f4 + dVar.f61161p, f16, n4);
        }
        if (dVar.f61158m != 0) {
            canvas.drawRect(f4, f5, f4 + dVar.f61161p, f5 + dVar.f61162q, c1239a.k(dVar));
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z3) {
        String[] strArr;
        float f4 = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (dVar.f61149d == null) {
            CharSequence charSequence = dVar.f61148c;
            if (charSequence != null) {
                f4 = textPaint.measureText(charSequence.toString());
                valueOf = l(dVar, textPaint);
            }
            dVar.f61161p = f4;
            dVar.f61162q = valueOf.floatValue();
            return;
        }
        Float l4 = l(dVar, textPaint);
        for (String str : dVar.f61149d) {
            if (str.length() > 0) {
                f4 = Math.max(textPaint.measureText(str), f4);
            }
        }
        dVar.f61161p = f4;
        dVar.f61162q = dVar.f61149d.length * l4.floatValue();
    }

    protected void i(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f4, float f5, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f4, f5, paint);
        } else {
            canvas.drawText(dVar.f61148c.toString(), f4, f5, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f4, float f5, TextPaint textPaint, boolean z3) {
        if (str != null) {
            canvas.drawText(str, f4, f5, textPaint);
        } else {
            canvas.drawText(dVar.f61148c.toString(), f4, f5, textPaint);
        }
    }

    protected Float l(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
        Float valueOf = Float.valueOf(paint.getTextSize());
        Map<Float, Float> map = f61134b;
        Float f4 = map.get(valueOf);
        if (f4 == null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Float valueOf2 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(valueOf, valueOf2);
            return valueOf2;
        }
        return f4;
    }
}

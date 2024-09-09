package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.SoftReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SpannedCacheStuffer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class j extends i {
    @Override // master.flame.danmaku.danmaku.model.android.b
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        Object obj = dVar.f61150e;
        if (obj instanceof SoftReference) {
            ((SoftReference) obj).clear();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.i, master.flame.danmaku.danmaku.model.android.b
    public void b() {
        super.b();
        System.gc();
    }

    @Override // master.flame.danmaku.danmaku.model.android.i, master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z3) {
        CharSequence charSequence = dVar.f61148c;
        if ((charSequence instanceof Spanned) && charSequence != null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(dVar.f61148c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            dVar.f61161p = staticLayout.getWidth();
            dVar.f61162q = staticLayout.getHeight();
            dVar.f61150e = new SoftReference(staticLayout);
            return;
        }
        super.e(dVar, textPaint, z3);
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        a(dVar);
        super.g(dVar);
    }

    @Override // master.flame.danmaku.danmaku.model.android.i
    public void j(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f4, float f5, Paint paint) {
        if (dVar.f61150e == null) {
            super.j(dVar, str, canvas, f4, f5, paint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.i
    public void k(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f4, float f5, TextPaint textPaint, boolean z3) {
        Object obj = dVar.f61150e;
        if (obj == null) {
            super.k(dVar, str, canvas, f4, f5, textPaint, z3);
            return;
        }
        StaticLayout staticLayout = (StaticLayout) ((SoftReference) obj).get();
        int i4 = dVar.J;
        boolean z4 = false;
        boolean z5 = (i4 & 1) != 0;
        boolean z6 = (i4 & 2) != 0;
        if (z6 || staticLayout == null) {
            if (z6) {
                dVar.J = i4 & (-3);
            }
            CharSequence charSequence = dVar.f61148c;
            if (charSequence == null) {
                return;
            }
            if (z5) {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(dVar.f61148c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                dVar.f61161p = staticLayout.getWidth();
                dVar.f61162q = staticLayout.getHeight();
                dVar.J &= -2;
            } else {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) dVar.f61161p, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            dVar.f61150e = new SoftReference(staticLayout);
        }
        if (f4 != 0.0f && f5 != 0.0f) {
            canvas.save();
            canvas.translate(f4, f5 + textPaint.ascent());
            z4 = true;
        }
        staticLayout.draw(canvas);
        if (z4) {
            canvas.restore();
        }
    }
}

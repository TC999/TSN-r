package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.SoftReference;
import master.flame.danmaku.danmaku.model.BaseDanmaku;

/* renamed from: master.flame.danmaku.danmaku.model.android.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SpannedCacheStuffer extends SimpleTextCacheStuffer {
    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: a */
    public void mo3121a(BaseDanmaku baseDanmaku) {
        super.mo3121a(baseDanmaku);
        Object obj = baseDanmaku.f43863e;
        if (obj instanceof SoftReference) {
            ((SoftReference) obj).clear();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer, master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: b */
    public void mo3118b() {
        super.mo3118b();
        System.gc();
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer, master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: e */
    public void mo3116e(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z) {
        CharSequence charSequence = baseDanmaku.f43861c;
        if ((charSequence instanceof Spanned) && charSequence != null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(baseDanmaku.f43861c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            baseDanmaku.f43874p = staticLayout.getWidth();
            baseDanmaku.f43875q = staticLayout.getHeight();
            baseDanmaku.f43863e = new SoftReference(staticLayout);
            return;
        }
        super.mo3116e(baseDanmaku, textPaint, z);
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: g */
    public void mo3115g(BaseDanmaku baseDanmaku) {
        mo3121a(baseDanmaku);
        super.mo3115g(baseDanmaku);
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer
    /* renamed from: j */
    public void mo3120j(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (baseDanmaku.f43863e == null) {
            super.mo3120j(baseDanmaku, str, canvas, f, f2, paint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.SimpleTextCacheStuffer
    /* renamed from: k */
    public void mo3119k(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        Object obj = baseDanmaku.f43863e;
        if (obj == null) {
            super.mo3119k(baseDanmaku, str, canvas, f, f2, textPaint, z);
            return;
        }
        StaticLayout staticLayout = (StaticLayout) ((SoftReference) obj).get();
        int i = baseDanmaku.f43857J;
        boolean z2 = false;
        boolean z3 = (i & 1) != 0;
        boolean z4 = (i & 2) != 0;
        if (z4 || staticLayout == null) {
            if (z4) {
                baseDanmaku.f43857J = i & (-3);
            }
            CharSequence charSequence = baseDanmaku.f43861c;
            if (charSequence == null) {
                return;
            }
            if (z3) {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(baseDanmaku.f43861c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                baseDanmaku.f43874p = staticLayout.getWidth();
                baseDanmaku.f43875q = staticLayout.getHeight();
                baseDanmaku.f43857J &= -2;
            } else {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) baseDanmaku.f43874p, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            baseDanmaku.f43863e = new SoftReference(staticLayout);
        }
        if (f != 0.0f && f2 != 0.0f) {
            canvas.save();
            canvas.translate(f, f2 + textPaint.ascent());
            z2 = true;
        }
        staticLayout.draw(canvas);
        if (z2) {
            canvas.restore();
        }
    }
}

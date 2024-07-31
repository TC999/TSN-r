package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.android.AndroidDisplayer;
import master.flame.danmaku.danmaku.model.android.ViewCacheStuffer.AbstractC15346a;

/* renamed from: master.flame.danmaku.danmaku.model.android.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ViewCacheStuffer<VH extends AbstractC15346a> extends BaseCacheStuffer {

    /* renamed from: e */
    public static final int f43827e = -1;

    /* renamed from: f */
    public static final int f43828f = -2;

    /* renamed from: g */
    public static final int f43829g = -3;

    /* renamed from: h */
    public static final int f43830h = -3;

    /* renamed from: d */
    private SparseArray<List<VH>> f43833d = new SparseArray<>();

    /* renamed from: b */
    private final int f43831b = -1;

    /* renamed from: c */
    private final int f43832c = -1;

    /* compiled from: ViewCacheStuffer.java */
    /* renamed from: master.flame.danmaku.danmaku.model.android.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15346a {

        /* renamed from: a */
        protected final View f43834a;

        public AbstractC15346a(View view) {
            if (view != null) {
                this.f43834a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* renamed from: a */
        public void m3111a(Canvas canvas, AndroidDisplayer.C15343a c15343a) {
            this.f43834a.draw(canvas);
        }

        /* renamed from: b */
        public int m3110b() {
            return this.f43834a.getMeasuredHeight();
        }

        /* renamed from: c */
        public int m3109c() {
            return this.f43834a.getMeasuredWidth();
        }

        /* renamed from: d */
        public void m3108d(int i, int i2, int i3, int i4) {
            this.f43834a.layout(i, i2, i3, i4);
        }

        /* renamed from: e */
        public void m3107e(int i, int i2) {
            this.f43834a.measure(i, i2);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: b */
    public void mo3118b() {
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: d */
    public void mo3117d(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, boolean z, AndroidDisplayer.C15343a c15343a) {
        VH vh;
        int m3114i = m3114i(baseDanmaku.f43877s, baseDanmaku);
        List<VH> list = this.f43833d.get(m3114i);
        boolean z2 = true;
        if (list != null) {
            vh = list.get(z ? 1 : 2);
        } else {
            vh = null;
        }
        if (vh == null) {
            return;
        }
        c15343a.m3176j(z);
        TextPaint m3174l = c15343a.m3174l(baseDanmaku, z);
        c15343a.m3179g(baseDanmaku, m3174l, false);
        m3113j(m3114i, vh, baseDanmaku, c15343a, m3174l);
        vh.m3107e(View.MeasureSpec.makeMeasureSpec(Math.round(baseDanmaku.f43874p), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(baseDanmaku.f43875q), 1073741824));
        if (z) {
            z2 = false;
        } else {
            canvas.save();
            canvas.translate(f, f2);
        }
        if (baseDanmaku.f43869k != 0) {
            Paint m3172n = c15343a.m3172n(baseDanmaku);
            float f3 = (baseDanmaku.f43875q + f2) - c15343a.f43746h;
            canvas.drawLine(f, f3, f + baseDanmaku.f43874p, f3, m3172n);
        }
        if (baseDanmaku.f43871m != 0) {
            canvas.drawRect(f, f2, f + baseDanmaku.f43874p, f2 + baseDanmaku.f43875q, c15343a.m3175k(baseDanmaku));
        }
        vh.m3108d(0, 0, (int) baseDanmaku.f43874p, (int) baseDanmaku.f43875q);
        vh.m3111a(canvas, c15343a);
        if (z2) {
            canvas.restore();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: e */
    public void mo3116e(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z) {
        int m3114i = m3114i(baseDanmaku.f43877s, baseDanmaku);
        List<VH> list = this.f43833d.get(m3114i);
        if (list == null) {
            list = new ArrayList<>();
            list.add(m3112k(m3114i));
            list.add(m3112k(m3114i));
            list.add(m3112k(m3114i));
            this.f43833d.put(m3114i, list);
        }
        VH vh = list.get(0);
        m3113j(m3114i, vh, baseDanmaku, null, textPaint);
        vh.m3107e(View.MeasureSpec.makeMeasureSpec(this.f43831b, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f43832c, Integer.MIN_VALUE));
        vh.m3108d(0, 0, vh.m3109c(), vh.m3110b());
        baseDanmaku.f43874p = vh.m3109c();
        baseDanmaku.f43875q = vh.m3110b();
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    /* renamed from: g */
    public void mo3115g(BaseDanmaku baseDanmaku) {
        super.mo3115g(baseDanmaku);
        baseDanmaku.f43864f = null;
    }

    /* renamed from: i */
    public int m3114i(int i, BaseDanmaku baseDanmaku) {
        return 0;
    }

    /* renamed from: j */
    public abstract void m3113j(int i, VH vh, BaseDanmaku baseDanmaku, AndroidDisplayer.C15343a c15343a, TextPaint textPaint);

    /* renamed from: k */
    public abstract VH m3112k(int i);
}

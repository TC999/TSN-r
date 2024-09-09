package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.a;
import master.flame.danmaku.danmaku.model.android.k.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ViewCacheStuffer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k<VH extends a> extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final int f61135e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f61136f = -2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f61137g = -3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f61138h = -3;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<List<VH>> f61141d = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final int f61139b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final int f61140c = -1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ViewCacheStuffer.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        protected final View f61142a;

        public a(View view) {
            if (view != null) {
                this.f61142a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void a(Canvas canvas, a.C1239a c1239a) {
            this.f61142a.draw(canvas);
        }

        public int b() {
            return this.f61142a.getMeasuredHeight();
        }

        public int c() {
            return this.f61142a.getMeasuredWidth();
        }

        public void d(int i4, int i5, int i6, int i7) {
            this.f61142a.layout(i4, i5, i6, i7);
        }

        public void e(int i4, int i5) {
            this.f61142a.measure(i4, i5);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b() {
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5, boolean z3, a.C1239a c1239a) {
        VH vh;
        int i4 = i(dVar.f61164s, dVar);
        List<VH> list = this.f61141d.get(i4);
        boolean z4 = true;
        if (list != null) {
            vh = list.get(z3 ? 1 : 2);
        } else {
            vh = null;
        }
        if (vh == null) {
            return;
        }
        c1239a.j(z3);
        TextPaint l4 = c1239a.l(dVar, z3);
        c1239a.g(dVar, l4, false);
        j(i4, vh, dVar, c1239a, l4);
        vh.e(View.MeasureSpec.makeMeasureSpec(Math.round(dVar.f61161p), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(dVar.f61162q), 1073741824));
        if (z3) {
            z4 = false;
        } else {
            canvas.save();
            canvas.translate(f4, f5);
        }
        if (dVar.f61156k != 0) {
            Paint n4 = c1239a.n(dVar);
            float f6 = (dVar.f61162q + f5) - c1239a.f61054h;
            canvas.drawLine(f4, f6, f4 + dVar.f61161p, f6, n4);
        }
        if (dVar.f61158m != 0) {
            canvas.drawRect(f4, f5, f4 + dVar.f61161p, f5 + dVar.f61162q, c1239a.k(dVar));
        }
        vh.d(0, 0, (int) dVar.f61161p, (int) dVar.f61162q);
        vh.a(canvas, c1239a);
        if (z4) {
            canvas.restore();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z3) {
        int i4 = i(dVar.f61164s, dVar);
        List<VH> list = this.f61141d.get(i4);
        if (list == null) {
            list = new ArrayList<>();
            list.add(k(i4));
            list.add(k(i4));
            list.add(k(i4));
            this.f61141d.put(i4, list);
        }
        VH vh = list.get(0);
        j(i4, vh, dVar, null, textPaint);
        vh.e(View.MeasureSpec.makeMeasureSpec(this.f61139b, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f61140c, Integer.MIN_VALUE));
        vh.d(0, 0, vh.c(), vh.b());
        dVar.f61161p = vh.c();
        dVar.f61162q = vh.b();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        super.g(dVar);
        dVar.f61151f = null;
    }

    public int i(int i4, master.flame.danmaku.danmaku.model.d dVar) {
        return 0;
    }

    public abstract void j(int i4, VH vh, master.flame.danmaku.danmaku.model.d dVar, a.C1239a c1239a, TextPaint textPaint);

    public abstract VH k(int i4);
}

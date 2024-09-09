package com.qq.e.comm.plugin.e.i;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.o2;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements d {

    /* renamed from: f  reason: collision with root package name */
    private static final SparseArray<a> f42753f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f42754g;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f42755a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f42756b;

    /* renamed from: c  reason: collision with root package name */
    private final d f42757c;

    /* renamed from: d  reason: collision with root package name */
    private final int f42758d;

    /* renamed from: e  reason: collision with root package name */
    private final a f42759e = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f42760a;

        /* renamed from: b  reason: collision with root package name */
        public float f42761b;

        /* renamed from: c  reason: collision with root package name */
        public long f42762c;

        /* renamed from: d  reason: collision with root package name */
        public long f42763d;

        a() {
        }
    }

    public f(View view, com.qq.e.comm.plugin.g0.e eVar, d dVar, int i4) {
        this.f42755a = new WeakReference<>(view);
        this.f42756b = eVar;
        this.f42757c = dVar;
        this.f42758d = i4;
    }

    private void b(com.qq.e.comm.plugin.e.c cVar) {
        View view = this.f42755a.get();
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i4 = rect.top;
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.bottom;
        cVar.f42681m = String.valueOf(f1.b(view.getContext(), iArr[0]));
        cVar.f42683n = String.valueOf(f1.b(view.getContext(), iArr[1]));
        cVar.f42685o = String.valueOf(f1.b(view.getContext(), i6 - i5));
        cVar.f42687p = String.valueOf(f1.b(view.getContext(), i7 - i4));
    }

    private void c(com.qq.e.comm.plugin.e.c cVar) {
        View view = this.f42755a.get();
        if (view != null) {
            float a4 = o2.a(view);
            boolean b4 = o2.b(view);
            cVar.f42695t = String.format("%.2f", Float.valueOf(a4));
            cVar.f42693s = String.valueOf(b4 ? 1 : 0);
        }
    }

    public void a(MotionEvent motionEvent, boolean z3, com.qq.e.comm.plugin.e.c cVar, int i4, int i5) {
        View view = this.f42755a.get();
        if (motionEvent == null || cVar == null || view == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int rawX = (int) (z3 ? motionEvent.getRawX() : i4 + motionEvent.getX());
            float rawY = z3 ? motionEvent.getRawY() : motionEvent.getY() + i5;
            cVar.f42663d = String.valueOf(f1.b(view.getContext(), rawX));
            cVar.f42665e = String.valueOf(f1.b(view.getContext(), (int) rawY));
            this.f42759e.f42762c = System.currentTimeMillis();
        } else if (action == 1) {
            int rawX2 = (int) (z3 ? motionEvent.getRawX() : i4 + motionEvent.getX());
            float rawY2 = z3 ? motionEvent.getRawY() : motionEvent.getY() + i5;
            cVar.f42667f = String.valueOf(f1.b(view.getContext(), rawX2));
            cVar.f42669g = String.valueOf(f1.b(view.getContext(), (int) rawY2));
            this.f42759e.f42763d = System.currentTimeMillis();
            a aVar = this.f42759e;
            cVar.f42657a = String.valueOf(aVar.f42763d - aVar.f42762c);
            this.f42759e.f42760a = motionEvent.getPressure();
            this.f42759e.f42761b = motionEvent.getSize();
        }
        f42753f.put(com.qq.e.comm.plugin.e.a.e(view), this.f42759e);
    }

    @Override // com.qq.e.comm.plugin.e.i.d
    public com.qq.e.comm.plugin.e.c a() {
        com.qq.e.comm.plugin.e.c a4 = this.f42757c.a();
        View view = this.f42755a.get();
        if (view == null) {
            return a4;
        }
        int e4 = com.qq.e.comm.plugin.e.a.e(view);
        a aVar = f42753f.get(e4);
        if (aVar != null && aVar.f42763d != 0) {
            a4.f42659b = String.valueOf(System.currentTimeMillis() - aVar.f42763d);
            a4.f42661c = String.valueOf(System.currentTimeMillis() - aVar.f42762c);
            a4.f42689q = String.valueOf(aVar.f42760a);
            a4.f42691r = String.valueOf(aVar.f42761b);
            f42753f.remove(e4);
        }
        a(a4);
        b(a4);
        c(a4);
        a4.f42671h = "0";
        int i4 = this.f42758d;
        if (i4 == 1) {
            this.f42756b.c(System.currentTimeMillis());
            a4.f42673i = "0";
        } else if (i4 == 2) {
            this.f42756b.b(System.currentTimeMillis());
            a4.f42673i = String.valueOf(System.currentTimeMillis() - this.f42756b.N());
        }
        a4.f42675j = "0";
        if (f42754g == null) {
            f42754g = Boolean.valueOf(com.qq.e.comm.plugin.d0.a.d().f().a("cvic", 1) == 1);
        }
        if (f42754g.booleanValue()) {
            a4.f42697u = String.valueOf(o2.a(view, 100, this.f42758d).second);
        }
        return a4;
    }

    private void a(com.qq.e.comm.plugin.e.c cVar) {
        View view = this.f42755a.get();
        if (cVar == null || view == null) {
            return;
        }
        cVar.f42677k = String.valueOf(f1.b(view.getContext(), view.getWidth()));
        cVar.f42679l = String.valueOf(f1.b(view.getContext(), view.getHeight()));
    }
}

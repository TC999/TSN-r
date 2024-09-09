package com.kwad.components.ad.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private com.kwad.sdk.core.g.d eg;
    private CopyOnWriteArrayList<C0558b> me = new CopyOnWriteArrayList<>();
    private int mf;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class a {
        private static final b mi = new b();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.f.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0558b {
        private final c mj;
        private final WeakReference<View> mk;

        public C0558b(c cVar, View view) {
            this.mk = new WeakReference<>(view);
            this.mj = cVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void f(double d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d4) {
        CopyOnWriteArrayList<C0558b> copyOnWriteArrayList = this.me;
        int Cl = (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i4 = Integer.MAX_VALUE;
        Iterator<C0558b> it = copyOnWriteArrayList.iterator();
        C0558b c0558b = null;
        C0558b c0558b2 = null;
        while (it.hasNext()) {
            C0558b next = it.next();
            WeakReference weakReference = next.mk;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && bq.o((View) weakReference.get(), Cl)) {
                    int i5 = this.mf / 2;
                    int min = Math.min(Math.abs(rect.top - i5), Math.abs(rect.bottom - i5));
                    if (min < i4) {
                        c0558b = next;
                        i4 = min;
                    } else if (min == i4) {
                        c0558b2 = next;
                    }
                }
            }
        }
        if (c0558b != null) {
            if (c0558b2 != null) {
                Rect rect2 = new Rect();
                ((View) c0558b.mk.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c0558b2.mk.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    c0558b = c0558b2;
                }
            }
            c0558b.mj.f(d4);
        }
    }

    public static b el() {
        return a.mi;
    }

    public final void a(float f4, View view, c cVar) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.eg == null) {
            this.mf = com.kwad.sdk.d.a.a.aI(view.getContext());
            a(f4, view.getContext());
        }
        this.me.add(new C0558b(cVar, view));
    }

    public final void a(c cVar) {
        Iterator<C0558b> it = this.me.iterator();
        while (it.hasNext()) {
            C0558b next = it.next();
            if (next.mj == cVar) {
                this.me.remove(next);
            }
        }
        com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "sShakeItems size " + this.me.size());
    }

    private void a(float f4, Context context) {
        this.eg = new com.kwad.sdk.core.g.d(f4);
        this.me = new CopyOnWriteArrayList<>();
        this.eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.f.b.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d4) {
                if (b.this.me != null) {
                    b.this.e(d4);
                    bn.a(new ay() { // from class: com.kwad.components.ad.f.b.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            com.kwad.sdk.core.e.c.d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            b.this.eg.Fu();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }
        });
        this.eg.e(f4);
        this.eg.bi(context);
    }
}

package com.kwad.components.p208ad.p221f;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11067bq;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.ad.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7418b {

    /* renamed from: eg */
    private C10380d f25421eg;

    /* renamed from: me */
    private CopyOnWriteArrayList<C7422b> f25422me = new CopyOnWriteArrayList<>();

    /* renamed from: mf */
    private int f25423mf;

    /* renamed from: com.kwad.components.ad.f.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C7421a {

        /* renamed from: mi */
        private static final C7418b f25426mi = new C7418b();
    }

    /* renamed from: com.kwad.components.ad.f.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7422b {

        /* renamed from: mj */
        private final InterfaceC7423c f25427mj;

        /* renamed from: mk */
        private final WeakReference<View> f25428mk;

        public C7422b(InterfaceC7423c interfaceC7423c, View view) {
            this.f25428mk = new WeakReference<>(view);
            this.f25427mj = interfaceC7423c;
        }
    }

    /* renamed from: com.kwad.components.ad.f.b$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7423c {
        /* renamed from: f */
        void mo33200f(double d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m33301e(double d) {
        CopyOnWriteArrayList<C7422b> copyOnWriteArrayList = this.f25422me;
        int m26543Cl = (int) (C10251d.m26543Cl() * 100.0f);
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        int i = Integer.MAX_VALUE;
        Iterator<C7422b> it = copyOnWriteArrayList.iterator();
        C7422b c7422b = null;
        C7422b c7422b2 = null;
        while (it.hasNext()) {
            C7422b next = it.next();
            WeakReference weakReference = next.f25428mk;
            if (weakReference != null) {
                Rect rect = new Rect();
                if (((View) weakReference.get()).getGlobalVisibleRect(rect) && C11067bq.m23850o((View) weakReference.get(), m26543Cl)) {
                    int i2 = this.f25423mf / 2;
                    int min = Math.min(Math.abs(rect.top - i2), Math.abs(rect.bottom - i2));
                    if (min < i) {
                        c7422b = next;
                        i = min;
                    } else if (min == i) {
                        c7422b2 = next;
                    }
                }
            }
        }
        if (c7422b != null) {
            if (c7422b2 != null) {
                Rect rect2 = new Rect();
                ((View) c7422b.f25428mk.get()).getGlobalVisibleRect(rect2);
                Rect rect3 = new Rect();
                ((View) c7422b2.f25428mk.get()).getGlobalVisibleRect(rect2);
                if (rect2.top < rect3.top) {
                    c7422b = c7422b2;
                }
            }
            c7422b.f25427mj.mo33200f(d);
        }
    }

    /* renamed from: el */
    public static C7418b m33300el() {
        return C7421a.f25426mi;
    }

    /* renamed from: a */
    public final void m33306a(float f, View view, InterfaceC7423c interfaceC7423c) {
        if (view == null || view.getContext() == null) {
            return;
        }
        if (this.f25421eg == null) {
            this.f25423mf = C10751a.m24920aI(view.getContext());
            m33307a(f, view.getContext());
        }
        this.f25422me.add(new C7422b(interfaceC7423c, view));
    }

    /* renamed from: a */
    public final void m33305a(InterfaceC7423c interfaceC7423c) {
        Iterator<C7422b> it = this.f25422me.iterator();
        while (it.hasNext()) {
            C7422b next = it.next();
            if (next.f25427mj == interfaceC7423c) {
                this.f25422me.remove(next);
            }
        }
        C10331c.m26254d("KSNativeAdShakeManager", "sShakeItems size " + this.f25422me.size());
    }

    /* renamed from: a */
    private void m33307a(float f, Context context) {
        this.f25421eg = new C10380d(f);
        this.f25422me = new CopyOnWriteArrayList<>();
        this.f25421eg.m26199a(new InterfaceC10376b() { // from class: com.kwad.components.ad.f.b.1
            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: a */
            public final void mo26220a(double d) {
                if (C7418b.this.f25422me != null) {
                    C7418b.this.m33301e(d);
                    C11064bn.m23862a(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.b.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C10331c.m26254d("KSNativeAdShakeManager", "onShakeEvent openGate2");
                            C7418b.this.f25421eg.m26202Fu();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
            /* renamed from: aV */
            public final void mo26219aV() {
            }
        });
        this.f25421eg.m26192e(f);
        this.f25421eg.m26195bi(context);
    }
}

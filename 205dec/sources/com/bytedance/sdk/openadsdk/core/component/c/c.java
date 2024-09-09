package com.bytedance.sdk.openadsdk.core.component.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wv;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.n.gd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f32104c;

    /* renamed from: w  reason: collision with root package name */
    private final ck f32105w = ls.c();

    private c() {
    }

    public void w(final Context context, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        wv wvVar = new wv();
        if (xvVar != null && (xvVar instanceof com.bytedance.sdk.openadsdk.core.c.w)) {
            wvVar.gd = ((com.bytedance.sdk.openadsdk.core.c.w) xvVar).c();
        }
        this.f32105w.c(wVar, wvVar, 6, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.2
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                xvVar.onError(i4, str);
                wVar2.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        c.this.w(cVar, context, wVar, currentTimeMillis, xvVar, wVar2);
                    }
                });
            }
        });
    }

    public static c c() {
        if (f32104c == null) {
            synchronized (c.class) {
                if (f32104c == null) {
                    f32104c = new c();
                }
            }
        }
        return f32104c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.openadsdk.core.u.c cVar, Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, long j4, com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
        if (cVar.w() != null && !cVar.w().isEmpty()) {
            List<me> w3 = cVar.w();
            ArrayList arrayList = new ArrayList(w3.size());
            Iterator<me> it = w3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                me next = it.next();
                if (next.df()) {
                    arrayList.add(new xv(context, next, 6, wVar));
                }
                if (!me.c(next) || gd.c(next)) {
                    if (!TextUtils.isEmpty(ng.c(next))) {
                        if (ls.w().ux(String.valueOf(com.bytedance.sdk.openadsdk.core.eq.wv.gd(next))) && ls.w().pu()) {
                            if (ng.bk(next) != null) {
                                ng.bk(next).ux(1);
                            }
                            if (ng.bk(next) != null) {
                                ng.bk(next).ux(1);
                            }
                            sr c4 = ng.c(4, next);
                            c4.c("material_meta", next);
                            c4.c("ad_slot", Integer.valueOf(wVar != null ? wVar.q() : 0));
                            com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, (c.InterfaceC0336c) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(w3.get(0), com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar.q()), j4);
                xvVar.onFeedAdLoad(arrayList);
                return;
            }
            xvVar.onError(-4, p.c(-4));
            wVar2.c(-4);
            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            return;
        }
        xvVar.onError(-3, p.c(-3));
        wVar2.c(-3);
        com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
    }

    public void c(final Context context, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        wv wvVar = new wv();
        if (xvVar != null && (xvVar instanceof com.bytedance.sdk.openadsdk.core.c.w)) {
            wvVar.gd = ((com.bytedance.sdk.openadsdk.core.c.w) xvVar).c();
        }
        this.f32105w.c(wVar, wvVar, 5, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.1
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                xvVar.onError(i4, str);
                wVar2.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final com.bytedance.sdk.openadsdk.core.u.w wVar2) {
                f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c.this.c(cVar, context, wVar, currentTimeMillis, xvVar, wVar2);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, long j4, com.bytedance.sdk.openadsdk.fz.c.w.c.xv xvVar, com.bytedance.sdk.openadsdk.core.u.w wVar2) {
        if (cVar.w() != null && !cVar.w().isEmpty()) {
            List<me> w3 = cVar.w();
            ArrayList arrayList = new ArrayList(w3.size());
            Iterator<me> it = w3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                me next = it.next();
                if (next.df()) {
                    arrayList.add(new xv(context, next, 5, wVar));
                }
                if (!me.c(next) || gd.c(next)) {
                    if (!TextUtils.isEmpty(ng.c(next))) {
                        if (ls.w().ux(String.valueOf(com.bytedance.sdk.openadsdk.core.eq.wv.gd(next))) && ls.w().pu()) {
                            if (ng.bk(next) != null) {
                                ng.bk(next).ux(1);
                            }
                            if (ng.t(next) != null) {
                                ng.t(next).ux(1);
                            }
                            sr c4 = ng.c(4, next);
                            c4.c("material_meta", next);
                            c4.c("ad_slot", Integer.valueOf(wVar != null ? wVar.q() : 0));
                            com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, (c.InterfaceC0336c) null);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(w3.get(0), com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar.q()), j4);
                xvVar.onFeedAdLoad(arrayList);
                return;
            }
            xvVar.onError(-4, p.c(-4));
            wVar2.c(-4);
            com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
            return;
        }
        xvVar.onError(-3, p.c(-3));
        wVar2.c(-3);
        com.bytedance.sdk.openadsdk.core.u.w.c(wVar2);
    }

    public void c(final Context context, final com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, final com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar2) {
        final long currentTimeMillis = System.currentTimeMillis();
        wv wvVar = new wv();
        if (wVar2 != null && (wVar2 instanceof com.bytedance.sdk.openadsdk.core.c.w)) {
            wvVar.gd = ((com.bytedance.sdk.openadsdk.core.c.w) wVar2).c();
        }
        this.f32105w.c(wVar, wvVar, 9, new ck.w() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.3
            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(int i4, String str, com.bytedance.sdk.openadsdk.core.u.w wVar3) {
                wVar2.onError(i4, str);
                wVar3.c(i4);
                com.bytedance.sdk.openadsdk.core.u.w.c(wVar3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.w
            public void c(final com.bytedance.sdk.openadsdk.core.u.c cVar, final com.bytedance.sdk.openadsdk.core.u.w wVar3) {
                f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.c.c.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        c.this.c(cVar, context, wVar, currentTimeMillis, wVar2, wVar3);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.c cVar, Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, long j4, com.bytedance.sdk.openadsdk.fz.c.w.c.w wVar2, com.bytedance.sdk.openadsdk.core.u.w wVar3) {
        if (cVar.w() != null && !cVar.w().isEmpty()) {
            List<me> w3 = cVar.w();
            ArrayList arrayList = new ArrayList(w3.size());
            Iterator<me> it = w3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                me next = it.next();
                if (next.df()) {
                    arrayList.add(new w(context, next, 9, wVar));
                }
                if (!TextUtils.isEmpty(ng.c(next))) {
                    if (ls.w().ux(String.valueOf(com.bytedance.sdk.openadsdk.core.eq.wv.gd(next))) && ls.w().pu()) {
                        if (ng.bk(next) != null) {
                            ng.bk(next).ux(1);
                        }
                        if (ng.t(next) != null) {
                            ng.t(next).ux(1);
                        }
                        sr c4 = ng.c(4, next);
                        c4.c("material_meta", next);
                        c4.c("ad_slot", Integer.valueOf(wVar != null ? wVar.q() : 0));
                        com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, (c.InterfaceC0336c) null);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(w3.get(0), com.bytedance.sdk.openadsdk.core.eq.wv.w(wVar.q()), j4);
                wVar2.onDrawFeedAdLoad(arrayList);
                return;
            }
            wVar2.onError(-4, p.c(-4));
            wVar3.c(-4);
            com.bytedance.sdk.openadsdk.core.u.w.c(wVar3);
            return;
        }
        wVar2.onError(-3, p.c(-3));
        wVar3.c(-3);
        com.bytedance.sdk.openadsdk.core.u.w.c(wVar3);
    }
}

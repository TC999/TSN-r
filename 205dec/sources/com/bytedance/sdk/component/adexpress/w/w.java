package com.bytedance.sdk.component.adexpress.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.w.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements p {

    /* renamed from: c  reason: collision with root package name */
    private Context f29465c;

    /* renamed from: f  reason: collision with root package name */
    private int f29466f;
    private ev sr;
    private bk ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.c.c f29467w;
    private ThemeStatusBroadcastReceiver xv;

    public w(Context context, bk bkVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z3, com.bytedance.sdk.component.adexpress.dynamic.sr.ev evVar, ev evVar2, com.bytedance.sdk.component.adexpress.dynamic.ux.c cVar) {
        this(context, bkVar, themeStatusBroadcastReceiver, z3, evVar, evVar2, cVar, null);
    }

    public w(Context context, bk bkVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z3, com.bytedance.sdk.component.adexpress.dynamic.sr.ev evVar, ev evVar2, com.bytedance.sdk.component.adexpress.dynamic.ux.c cVar, com.bytedance.sdk.component.adexpress.dynamic.c.c cVar2) {
        this.f29465c = context;
        this.ux = bkVar;
        this.xv = themeStatusBroadcastReceiver;
        this.sr = evVar2;
        if (cVar2 != null) {
            this.f29467w = cVar2;
        } else {
            this.f29467w = new com.bytedance.sdk.component.adexpress.dynamic.c.c(context, themeStatusBroadcastReceiver, z3, evVar, bkVar, cVar);
        }
        this.f29467w.c(this.sr);
        if (evVar instanceof com.bytedance.sdk.component.adexpress.dynamic.sr.r) {
            this.f29466f = 3;
        } else {
            this.f29466f = 2;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public boolean c(final p.c cVar) {
        this.ux.ux().c(this.f29466f);
        this.f29467w.c(new r() { // from class: com.bytedance.sdk.component.adexpress.w.w.1
            @Override // com.bytedance.sdk.component.adexpress.w.r
            public void c(View view, t tVar) {
                if (cVar.xv()) {
                    return;
                }
                w.this.ux.ux().ux(w.this.f29466f);
                w.this.ux.ux().f(w.this.f29466f);
                w.this.ux.ux().s();
                ys w3 = cVar.w();
                if (w3 == null) {
                    return;
                }
                w3.c(w.this.f29467w, tVar);
                cVar.c(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.w.r
            public void c(int i4, String str) {
                w.this.ux.ux().c(w.this.f29466f, i4, str, cVar.w(w.this));
                if (cVar.w(w.this)) {
                    cVar.c(w.this);
                    return;
                }
                ys w3 = cVar.w();
                if (w3 == null) {
                    return;
                }
                w3.a_(i4);
            }
        });
        return true;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.sr w() {
        com.bytedance.sdk.component.adexpress.dynamic.c.c cVar = this.f29467w;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public void c() {
        com.bytedance.sdk.component.adexpress.dynamic.c.c cVar = this.f29467w;
        if (cVar != null) {
            cVar.w();
        }
    }
}

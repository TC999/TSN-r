package com.bytedance.sdk.component.adexpress.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.w.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements p {

    /* renamed from: c  reason: collision with root package name */
    private Context f29446c;

    /* renamed from: w  reason: collision with root package name */
    private c f29447w;
    private bk xv;

    public f(Context context, bk bkVar, c cVar) {
        this.f29446c = context;
        this.f29447w = cVar;
        this.xv = bkVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public void c() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p
    public boolean c(final p.c cVar) {
        this.xv.ux().t();
        this.f29447w.c(new r() { // from class: com.bytedance.sdk.component.adexpress.w.f.1
            @Override // com.bytedance.sdk.component.adexpress.w.r
            public void c(View view, t tVar) {
                if (cVar.xv()) {
                    return;
                }
                ys w3 = cVar.w();
                if (w3 != null) {
                    w3.c(f.this.f29447w, tVar);
                }
                cVar.c(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.w.r
            public void c(int i4, String str) {
                ys w3 = cVar.w();
                if (w3 != null) {
                    w3.a_(i4);
                }
            }
        });
        return true;
    }

    public void c(xv xvVar) {
        this.f29447w.c(xvVar);
    }
}

package com.bytedance.sdk.component.adexpress.dynamic.animation.c;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux {

    /* renamed from: c  reason: collision with root package name */
    List<sr> f29077c = new ArrayList();

    public w(View view, List<com.bytedance.sdk.component.adexpress.dynamic.xv.c> list) {
        for (com.bytedance.sdk.component.adexpress.dynamic.xv.c cVar : list) {
            sr c4 = xv.c().c(view, cVar);
            if (c4 != null) {
                this.f29077c.add(c4);
            }
        }
    }

    public void c() {
        for (sr srVar : this.f29077c) {
            try {
                srVar.xv();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ux
    public void w() {
        for (sr srVar : this.f29077c) {
            try {
                srVar.w();
            } catch (Exception unused) {
            }
        }
    }
}

package com.bytedance.sdk.component.ux.sr;

import com.bytedance.sdk.component.ux.fp;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk<T> extends c {

    /* renamed from: c  reason: collision with root package name */
    private T f30236c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.component.ux.f f30237w;
    private boolean xv;

    public bk(T t3, com.bytedance.sdk.component.ux.f fVar, boolean z3) {
        this.f30236c = t3;
        this.f30237w = fVar;
        this.xv = z3;
    }

    private Map<String, String> w() {
        com.bytedance.sdk.component.ux.f fVar = this.f30237w;
        if (fVar != null) {
            return fVar.ux();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "success";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        String ls = xvVar.ls();
        Map<String, List<com.bytedance.sdk.component.ux.xv.xv>> r3 = xvVar.u().r();
        List<com.bytedance.sdk.component.ux.xv.xv> list = r3.get(ls);
        if (list == null) {
            w(xvVar);
            return;
        }
        synchronized (list) {
            for (com.bytedance.sdk.component.ux.xv.xv xvVar2 : list) {
                w(xvVar2);
            }
            list.clear();
            r3.remove(ls);
        }
    }

    private void w(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        fp k4 = xvVar.k();
        if (k4 != null) {
            k4.c(new com.bytedance.sdk.component.ux.xv.sr().c(xvVar, this.f30236c, w(), this.xv));
        }
    }
}

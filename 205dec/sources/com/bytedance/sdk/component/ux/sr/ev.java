package com.bytedance.sdk.component.ux.sr;

import com.bytedance.sdk.component.ux.fp;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends c {

    /* renamed from: c  reason: collision with root package name */
    private Throwable f30238c;

    /* renamed from: w  reason: collision with root package name */
    private int f30239w;
    private String xv;

    public ev(int i4, String str, Throwable th) {
        this.f30239w = i4;
        this.xv = str;
        this.f30238c = th;
    }

    private void w(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        fp k4 = xvVar.k();
        if (k4 != null) {
            k4.c(this.f30239w, this.xv, this.f30238c);
        }
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "failed";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        xvVar.c(new com.bytedance.sdk.component.ux.xv.c(this.f30239w, this.xv, this.f30238c));
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
}

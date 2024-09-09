package com.bytedance.sdk.component.w.c.c.c;

import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.xv.w.ba;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.w.c.w {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.component.xv.w.ux f30380c;

    public c(com.bytedance.sdk.component.xv.w.ux uxVar) {
        this.f30380c = uxVar;
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public fp c() throws IOException {
        return new f(this.f30380c.c());
    }

    /* renamed from: sr */
    public com.bytedance.sdk.component.w.c.w clone() {
        return new c(this.f30380c.sr());
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public void w() {
        this.f30380c.w();
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public boolean xv() {
        return this.f30380c.xv();
    }

    @Override // com.bytedance.sdk.component.w.c.w
    public void c(final com.bytedance.sdk.component.w.c.xv xvVar) {
        this.f30380c.c(new com.bytedance.sdk.component.xv.w.f() { // from class: com.bytedance.sdk.component.w.c.c.c.c.1
            @Override // com.bytedance.sdk.component.xv.w.f
            public void c(com.bytedance.sdk.component.xv.w.ux uxVar, IOException iOException) {
                xvVar.onFailure(new c(uxVar), iOException);
            }

            @Override // com.bytedance.sdk.component.xv.w.f
            public void c(com.bytedance.sdk.component.xv.w.ux uxVar, ba baVar) throws IOException {
                xvVar.onResponse(new c(uxVar), new f(baVar));
            }
        });
    }
}

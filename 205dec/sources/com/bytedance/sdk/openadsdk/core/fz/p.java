package com.bytedance.sdk.openadsdk.core.fz;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class p implements com.bytedance.sdk.component.r.c.c.f {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.component.ev.w.sr f33681c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(com.bytedance.sdk.component.ev.w.sr srVar) {
        this.f33681c = srVar;
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public void c(String str) {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar != null) {
            srVar.c(str);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public void w(String str) {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar != null) {
            srVar.xv(str);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public void c(String str, byte[] bArr) {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar != null) {
            srVar.c(str, bArr);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public void c(String str, String str2) {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar != null) {
            srVar.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public com.bytedance.sdk.component.r.c.c.ux c() {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar == null) {
            return null;
        }
        return new gd(srVar.c());
    }

    @Override // com.bytedance.sdk.component.r.c.c.f
    public void c(final com.bytedance.sdk.component.r.c.c.xv xvVar) {
        com.bytedance.sdk.component.ev.w.sr srVar = this.f33681c;
        if (srVar != null) {
            srVar.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.fz.p.1
                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, com.bytedance.sdk.component.ev.w wVar) {
                    if (xvVar != null) {
                        xvVar.c(new sr(xvVar2), new ux(wVar));
                    }
                }

                @Override // com.bytedance.sdk.component.ev.c.c
                public void c(com.bytedance.sdk.component.ev.w.xv xvVar2, IOException iOException) {
                    if (xvVar != null) {
                        xvVar.c(new sr(xvVar2), iOException);
                    }
                }
            });
        }
    }
}

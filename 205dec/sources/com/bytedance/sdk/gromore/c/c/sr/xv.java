package com.bytedance.sdk.gromore.c.c.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.i.c.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.r.c f31206c;

    public xv(com.bytedance.msdk.api.sr.c.r.c cVar) {
        this.f31206c = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public String c() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        return cVar != null ? cVar.wx() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void sr() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoAutoStart();
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void w() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoAutoStart();
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void xv() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoFinish();
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void c(long j4) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoPause(j4);
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void w(long j4) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoContinue(j4);
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void xv(long j4) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoBreak(j4);
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void c(int i4, int i5) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoStartError(i4, i5);
    }

    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
    public void c(long j4, int i4, int i5) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31206c;
        if (cVar == null || cVar.pr() == null) {
            return;
        }
        this.f31206c.pr().reportVideoError(j4, i4, i5);
    }
}

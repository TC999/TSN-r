package com.bytedance.sdk.openadsdk.core.component.splash.w.xv;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f33056c;
    private com.bytedance.sdk.openadsdk.core.component.splash.xv ev;

    /* renamed from: f  reason: collision with root package name */
    private r f33057f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.f f33058r;
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.ux sr;
    private w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r> ux;

    /* renamed from: w  reason: collision with root package name */
    volatile boolean f33059w;
    volatile boolean xv;

    public ux(com.bytedance.sdk.openadsdk.core.component.splash.w.c.ux uxVar, w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r> wVar, com.bytedance.sdk.openadsdk.core.component.splash.xv xvVar) {
        if (uxVar == null || wVar == null) {
            return;
        }
        this.sr = uxVar;
        this.ux = wVar;
        this.ev = xvVar;
    }

    public void c(int i4) {
        if (this.sr == null || this.ux == null) {
            return;
        }
        a.w("Splash_FullLink", "loadAd Type " + i4);
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "loadAd Type " + i4);
        if (i4 == 0) {
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.xv().c(this.sr, this.ux);
        } else if (i4 == 1) {
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.c(this.ev).c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    if (rVar != null && ux.this.sr != null) {
                        ux.this.sr.c(rVar.sr());
                        ux.this.sr.c(rVar.xv());
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.c.c.xv().c(ux.this.sr, ux.this.ux);
                }
            });
        } else if (i4 == 2) {
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.xv().c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    ux.this.f33058r = fVar;
                    if (ux.this.f33057f != null && fVar != null) {
                        fVar.c(ux.this.f33057f.sr());
                        fVar.c(ux.this.f33057f.xv());
                    }
                    com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6\u7269\u6599\u52a0\u8f7d\u6210\u529f isCache " + fVar.ux());
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u5b9e\u65f6\u7269\u6599\u52a0\u8f7d\u5931\u8d25 ");
                    ux.this.ux.c(rVar);
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.c(this.ev).c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.3
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u7269\u6599\u52a0\u8f7d\u6210\u529f isCache " + fVar.ux());
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    ux.this.f33057f = rVar;
                    com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u7f13\u5b58\u7269\u6599\u52a0\u8f7d\u5931\u8d25  ");
                    if (ux.this.f33058r != null && rVar != null) {
                        ux.this.f33058r.c(rVar.sr());
                        ux.this.f33058r.c(rVar.xv());
                    }
                    ux.this.ux.c(rVar);
                }
            });
        } else if (i4 == 3) {
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.xv().c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.4
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    ux.this.f33058r = fVar;
                    if (ux.this.xv) {
                        if (ux.this.ev == null || ux.this.sr == null) {
                            return;
                        }
                        ux.this.ev.c(fVar, ux.this.sr.sr(), true);
                        return;
                    }
                    if (ux.this.f33057f != null && fVar != null) {
                        fVar.c(ux.this.f33057f.sr());
                        fVar.c(ux.this.f33057f.xv());
                    }
                    ux.this.xv = true;
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    ux.this.f33056c = true;
                    if (ux.this.f33059w) {
                        ux.this.ux.c(rVar);
                    }
                }
            });
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.c(this.ev).c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.5
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    if (ux.this.xv) {
                        return;
                    }
                    ux.this.xv = true;
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    ux.this.f33057f = rVar;
                    if (ux.this.f33058r != null && rVar != null) {
                        ux.this.f33058r.c(rVar.sr());
                        ux.this.f33058r.c(rVar.xv());
                    }
                    ux.this.f33059w = true;
                    if (ux.this.f33056c) {
                        ux.this.ux.c(rVar);
                    }
                }
            });
        } else if (i4 != 4) {
        } else {
            new com.bytedance.sdk.openadsdk.core.component.splash.c.c.c(this.ev).c(this.sr, new w<com.bytedance.sdk.openadsdk.core.component.splash.w.c.f, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.ux.6
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                /* renamed from: c */
                public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.f fVar) {
                    ux.this.ux.w(fVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w
                public void c(r rVar) {
                    ux.this.ux.c(rVar);
                }
            });
        }
    }
}

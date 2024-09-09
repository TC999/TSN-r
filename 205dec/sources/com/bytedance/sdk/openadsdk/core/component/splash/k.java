package com.bytedance.sdk.openadsdk.core.component.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.oo;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private Context f32957c;
    private SoftReference<com.bytedance.sdk.openadsdk.core.component.splash.c> ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f32958f;
    private SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> gd;

    /* renamed from: p  reason: collision with root package name */
    private Handler f32959p = new Handler(Looper.getMainLooper());

    /* renamed from: r  reason: collision with root package name */
    private SoftReference<w> f32960r;
    private sr sr;
    private com.bytedance.sdk.openadsdk.core.w.c ux;

    /* renamed from: w  reason: collision with root package name */
    private me f32961w;
    private FrameLayout xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(long j4);

        Context getActivity();

        void w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        this.f32959p.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.5
            @Override // java.lang.Runnable
            public void run() {
                if (com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34385c) {
                    com.bytedance.sdk.openadsdk.core.p.xv.xv.f.f34385c = false;
                    if (k.this.f32958f instanceof com.bytedance.sdk.openadsdk.core.p.xv.f) {
                        ((com.bytedance.sdk.openadsdk.core.p.xv.f) k.this.f32958f).c().c(new com.bytedance.sdk.openadsdk.core.p.xv.c.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.5.1
                            @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.c
                            public void c() {
                                k.this.w();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.p.xv.c.c
                            public void w() {
                            }
                        });
                        return;
                    }
                    return;
                }
                k.this.w();
            }
        }, 100L);
    }

    public void c(Context context, me meVar) {
        this.f32957c = context;
        this.f32961w = meVar;
        this.xv = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.xv.setLayoutParams(layoutParams);
        oo.w(this.f32961w);
    }

    public void w() {
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.w();
        }
    }

    public ViewGroup c() {
        return this.xv;
    }

    public void c(String str, int i4, w wVar, com.bytedance.sdk.openadsdk.ys.w.c.w wVar2) {
        if (wVar2 != null) {
            this.gd = new SoftReference<>(wVar2);
        }
        this.f32960r = new SoftReference<>(wVar);
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i4));
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.f32957c, this.f32961w, str, 4);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
        SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = this.gd;
        if (softReference == null) {
            c(str, this.xv, (com.bytedance.sdk.openadsdk.ys.w.c.w) null);
        } else {
            c(str, this.xv, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f32958f);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.1
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view, int i5) {
                if (k.this.f32960r != null && k.this.f32960r.get() != null) {
                    ((w) k.this.f32960r.get()).w();
                }
                k.this.xv();
            }
        });
        this.ux = cVar;
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(cVar);
        }
    }

    public void c(String str, int i4, com.bytedance.sdk.openadsdk.core.component.splash.c cVar, com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        this.ev = new SoftReference<>(cVar);
        if (wVar != null) {
            this.gd = new SoftReference<>(wVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(i4));
        com.bytedance.sdk.openadsdk.core.w.c cVar2 = new com.bytedance.sdk.openadsdk.core.w.c(this.f32957c, this.f32961w, str, 4);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
        SoftReference<com.bytedance.sdk.openadsdk.ys.w.c.w> softReference = this.gd;
        if (softReference == null) {
            c(str, this.xv, (com.bytedance.sdk.openadsdk.ys.w.c.w) null);
        } else {
            c(str, this.xv, softReference.get());
        }
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f32958f);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.2
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view, int i5) {
                if (k.this.ev != null && k.this.ev.get() != null) {
                    ((com.bytedance.sdk.openadsdk.core.component.splash.c) k.this.ev.get()).w();
                }
                k.this.xv();
            }
        });
        this.ux = cVar2;
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(cVar2);
        }
    }

    private com.bytedance.sdk.openadsdk.core.p.w.xv c(me meVar, String str) {
        if (meVar.v() == 4) {
            return com.bytedance.sdk.openadsdk.core.p.xv.c(this.f32957c, meVar, str);
        }
        return null;
    }

    private void c(String str, final ViewGroup viewGroup, com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        me meVar = this.f32961w;
        if (meVar == null || this.f32957c == null || viewGroup == null) {
            return;
        }
        this.f32958f = c(meVar, str);
        EmptyView emptyView = new EmptyView(this.f32957c, viewGroup, this.f32961w.ek());
        emptyView.setAdType(3);
        viewGroup.addView(emptyView);
        if (wVar != null) {
            c(wVar);
        }
        emptyView.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                if (k.this.f32958f != null) {
                    if (z3) {
                        k.this.f32958f.sr();
                    } else {
                        k.this.f32958f.ux();
                    }
                }
                k.this.c(z3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                if (k.this.f32958f != null) {
                    k.this.f32958f.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                ViewGroup viewGroup2;
                if (k.this.f32958f != null) {
                    k.this.f32958f.xv();
                }
                if (k.this.f32958f == null || (viewGroup2 = viewGroup) == null || viewGroup2.getParent() == null) {
                    return;
                }
                Context context = null;
                try {
                    context = ((View) viewGroup.getParent()).getContext();
                } catch (Exception unused) {
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                k.this.f32958f.c((Activity) context);
            }
        });
    }

    private void c(final com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32958f;
        if (xvVar == null) {
            return;
        }
        xvVar.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.k.4
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str, String str2) {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onDownloadPaused(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str, String str2) {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onDownloadFailed(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str, String str2) {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onDownloadActive(j4, j5, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str, String str2) {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onDownloadFinished(j4, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str, String str2) {
                com.bytedance.sdk.openadsdk.ys.w.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.onInstalled(str, str2);
                }
            }
        });
    }

    public void c(int i4) {
        if (i4 != 1) {
            if (i4 == 2 && oo.c(this.f32961w)) {
                this.sr = new ux();
            }
        } else if (oo.xv(this.f32961w)) {
            this.sr = new r();
        } else if (oo.sr(this.f32961w)) {
            this.sr = new f();
        }
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(this.f32957c, this.xv, this.f32961w);
            this.sr.c(this.ux);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar, c cVar) {
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(wVar, xvVar, cVar);
        }
    }

    public void c(boolean z3) {
        sr srVar = this.sr;
        if (srVar != null) {
            srVar.c(z3);
        }
    }
}

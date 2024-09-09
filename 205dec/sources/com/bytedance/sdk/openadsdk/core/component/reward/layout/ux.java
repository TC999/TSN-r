package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import com.bytedance.sdk.openadsdk.core.ys.c;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.p.w.xv f32459c;
    private ViewGroup ev;

    /* renamed from: f  reason: collision with root package name */
    private me f32460f;
    private FullRewardExpressView gd;

    /* renamed from: r  reason: collision with root package name */
    private String f32461r;
    private final TTBaseVideoActivity ux;

    /* renamed from: w  reason: collision with root package name */
    boolean f32462w = false;
    boolean xv = false;
    boolean sr = false;

    public ux(TTBaseVideoActivity tTBaseVideoActivity) {
        this.ux = tTBaseVideoActivity;
    }

    public t a() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public NativeExpressView bk() {
        return this.gd;
    }

    public void ev() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.fp();
            this.gd.ia();
        }
    }

    public boolean f() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        return (fullRewardExpressView == null || fullRewardExpressView.fz()) ? false : true;
    }

    public int gd() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public boolean k() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.bk();
    }

    public Boolean p() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.i();
        }
        return null;
    }

    public void r() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.ys();
    }

    public void sr() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.a();
        }
    }

    public void ux() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.ia();
        }
    }

    public boolean w() {
        return this.f32462w;
    }

    public boolean xv() {
        return this.xv;
    }

    public void c(me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, boolean z3) {
        if (this.sr) {
            return;
        }
        this.sr = true;
        this.f32460f = meVar;
        this.f32461r = str;
        this.gd = new FullRewardExpressView(this.ux, meVar, wVar, str, z3);
        FrameLayout expressFrameContainer = this.ux.wv().getExpressFrameContainer();
        this.ev = expressFrameContainer;
        expressFrameContainer.addView(this.gd, new FrameLayout.LayoutParams(-2, -2));
    }

    public void w(boolean z3) {
        this.xv = z3;
    }

    public void xv(boolean z3) {
        ViewGroup viewGroup = this.ev;
        if (viewGroup != null) {
            viewGroup.setVisibility(z3 ? 0 : 8);
        }
    }

    public void c(CharSequence charSequence, int i4, int i5, boolean z3) {
        if (this.gd == null || !f()) {
            return;
        }
        this.gd.c(charSequence, i4, i5, z3);
    }

    public FrameLayout c() {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public void c(boolean z3) {
        this.f32462w = z3;
    }

    public void c(com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar, com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar) {
        me meVar;
        if (this.gd == null || (meVar = this.f32460f) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv c4 = c(meVar);
        this.f32459c = c4;
        if (c4 != null) {
            c4.sr();
            if (this.gd.getContext() != null && (this.gd.getContext() instanceof Activity)) {
                this.f32459c.c((Activity) this.gd.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32460f);
        EmptyView c5 = c((ViewGroup) this.gd);
        if (c5 == null) {
            me meVar2 = this.f32460f;
            EmptyView emptyView = new EmptyView(this.ux, this.gd, meVar2 != null ? meVar2.ek() : 1000);
            this.gd.addView(emptyView);
            c5 = emptyView;
        }
        c5.setNeedCheckingShow(false);
        c5.setCallback(new EmptyView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ux.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c(boolean z3) {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = ux.this.f32459c;
                if (xvVar != null) {
                    if (z3) {
                        xvVar.sr();
                    } else {
                        xvVar.ux();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void w() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = ux.this.f32459c;
                if (xvVar != null) {
                    xvVar.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.c
            public void c() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = ux.this.f32459c;
                if (xvVar != null) {
                    xvVar.xv();
                }
            }
        });
        fVar.c(this.gd);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f32459c);
        this.gd.setClickListener(fVar);
        uxVar.c(this.gd);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f32459c);
        this.gd.setClickCreativeListener(uxVar);
        c5.setNeedCheckingShow(false);
        c(this.f32459c, this.gd);
    }

    private void c(com.bytedance.sdk.openadsdk.core.p.w.xv xvVar, NativeExpressView nativeExpressView) {
        if (xvVar == null || nativeExpressView == null) {
            return;
        }
        me meVar = this.f32460f;
        final String jr = meVar != null ? meVar.jr() : "";
        xvVar.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ux.2
            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c() {
                ux.this.ux.w("\u70b9\u51fb\u5f00\u59cb\u4e0b\u8f7d");
                c.C0525c.c(jr, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void w(long j4, long j5, String str, String str2) {
                ux.this.ux.w("\u4e0b\u8f7d\u6682\u505c");
                if (j4 > 0) {
                    c.C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void xv(long j4, long j5, String str, String str2) {
                ux.this.ux.w("\u4e0b\u8f7d\u5931\u8d25");
                if (j4 > 0) {
                    c.C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, long j5, String str, String str2) {
                if (j4 > 0) {
                    int i4 = (int) ((j5 * 100) / j4);
                    TTBaseVideoActivity tTBaseVideoActivity = ux.this.ux;
                    tTBaseVideoActivity.w("\u5df2\u4e0b\u8f7d" + i4 + "%");
                    c.C0525c.c(jr, 3, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(long j4, String str, String str2) {
                ux.this.ux.w("\u70b9\u51fb\u5b89\u88c5");
                c.C0525c.c(jr, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.w.c
            public void c(String str, String str2) {
                ux.this.ux.w("\u70b9\u51fb\u6253\u5f00");
                c.C0525c.c(jr, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.p.w.xv c(me meVar) {
        if (meVar.v() == 4) {
            return com.bytedance.sdk.openadsdk.core.p.xv.c(this.ux, meVar, this.f32461r);
        }
        return null;
    }

    private EmptyView c(ViewGroup viewGroup) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void c(com.bytedance.sdk.openadsdk.core.nativeexpress.p pVar) {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(pVar);
    }

    public void c(com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar) {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(cVar);
    }

    public void c(com.bykv.vk.openvk.component.video.api.sr.xv xvVar) {
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(xvVar);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        xk jsObject;
        FullRewardExpressView fullRewardExpressView = this.gd;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.ux.isFinishing()) {
            return;
        }
        jsObject.c(str, jSONObject);
    }

    public void c(c.InterfaceC0499c interfaceC0499c) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f32459c;
        if (xvVar != null) {
            xvVar.c(interfaceC0499c);
        }
    }
}

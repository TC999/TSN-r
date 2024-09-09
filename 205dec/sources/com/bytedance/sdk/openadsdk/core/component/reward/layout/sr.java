package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends w {
    private RewardGuideSlideUp bk;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.xv fp;
    private boolean fz;
    private float ia;

    /* renamed from: s  reason: collision with root package name */
    private float f32454s;

    /* renamed from: t  reason: collision with root package name */
    private RecyclerView f32455t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f32456u;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.c ys;

    public sr(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
        this.fz = true;
    }

    public void f() {
        this.fz = false;
        if (this.f32456u) {
            xk.c((View) this.bk, 8);
            this.bk.w();
            this.f32456u = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void p() {
        super.p();
        if (this.bk != null) {
            f();
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.xv sr() {
        return this.fp;
    }

    public void ux() {
        if (this.fz) {
            this.f32471r.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (sr.this.fz) {
                        sr.this.fz = false;
                        xk.c((View) sr.this.bk, 0);
                        sr.this.bk.getSlideUpAnimatorSet().start();
                        sr.this.f32456u = true;
                        sr.this.f32471r.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.sr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                sr.this.f();
                            }
                        }, 3000L);
                    }
                }
            }, 0L);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.c xv() {
        return this.ys;
    }

    public void c(float[] fArr) {
        this.ia = fArr[0];
        this.f32454s = fArr[1];
    }

    public RecyclerView w() {
        return this.f32455t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.f32455t = (RecyclerView) this.f32471r.findViewById(2114387888);
        this.bk = (RewardGuideSlideUp) this.f32471r.findViewById(2114387966);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xv xvVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.xv(this.f32472w, 1, false);
        this.fp = xvVar;
        this.f32455t.setLayoutManager(xvVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.c cVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.c(this.f32472w, this.ia, this.f32454s);
        this.ys = cVar;
        this.f32455t.setAdapter(cVar);
        this.bk.c();
    }

    public void c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xv xvVar = this.fp;
        if (xvVar == null) {
            return;
        }
        xvVar.xv(z3);
    }
}

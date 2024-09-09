package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.r;
import com.bytedance.sdk.openadsdk.core.component.reward.view.RewardChestView;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private final TTBaseVideoActivity f32724c;
    private r ev;

    /* renamed from: f  reason: collision with root package name */
    private UgenBanner f32725f;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.sr gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.top.f f32726k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.top.ux f32727p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.w.w f32728r;
    private RewardChestView sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private me f32729w;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.c xv;

    public ux(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f32724c = tTBaseVideoActivity;
    }

    private void t() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.f32724c.findViewById(2114387720);
        if (topProxyLayout != null) {
            c(topProxyLayout);
        }
        this.sr = (RewardChestView) this.f32724c.findViewById(2114387889);
        this.ux = (TextView) this.f32724c.findViewById(2114387803);
        this.f32725f = (UgenBanner) this.f32724c.findViewById(2114387905);
    }

    public void a() {
        UgenBanner ugenBanner = this.f32725f;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c(this.f32729w, this.f32728r);
    }

    public void bk() {
        UgenBanner ugenBanner = this.f32725f;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.c();
    }

    public void ev() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.sr();
        }
    }

    public void f(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setShowBack(z3);
        }
    }

    public void gd() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.f();
        }
    }

    public void k() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.ux();
        }
    }

    public void p() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.r();
        }
    }

    public void r(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setShowAgain(z3);
        }
    }

    public void sr(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setSoundMute(z3);
        }
    }

    public void ux(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setShowSound(z3);
        }
    }

    public void w(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setShowDislike(z3);
        }
    }

    public void xv(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setDislikeLeft(z3);
        }
    }

    public void c(me meVar, w wVar, boolean z3, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        this.f32729w = meVar;
        this.f32728r = wVar2;
        t();
        this.ev = new r(this.f32724c, this.f32729w, wVar, this, z3);
        this.f32727p = new com.bytedance.sdk.openadsdk.core.component.reward.top.ux(this.f32724c, this.f32729w, wVar, this, z3);
        this.gd = new com.bytedance.sdk.openadsdk.core.component.reward.top.sr(this.f32724c, this.f32729w, wVar, this, z3);
        this.f32726k = new com.bytedance.sdk.openadsdk.core.component.reward.top.f(this.f32724c, this.f32729w, wVar, this, z3);
        c(1);
    }

    public void f() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.w();
        }
    }

    public void r() {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.xv();
        }
    }

    public View sr() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            return cVar.getCloseButton();
        }
        return null;
    }

    public boolean ux() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            return cVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.w();
        }
    }

    public void xv() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.xv();
        }
    }

    public void w(int i4) {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.c(i4);
        }
    }

    public void w(String str) {
        TextView textView = this.ux;
        if (textView != null) {
            textView.setText(str);
            this.ux.setVisibility(0);
            this.ux.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.ux.1
                @Override // java.lang.Runnable
                public void run() {
                    ux.this.ux.setVisibility(8);
                }
            }, 3000L);
        }
    }

    public void c(TopProxyLayout topProxyLayout) {
        RewardBrowserMixTopLayoutImpl rewardBrowserMixTopLayoutImpl;
        if (fp.k(this.f32729w)) {
            rewardBrowserMixTopLayoutImpl = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).c(this.f32729w);
        } else {
            rewardBrowserMixTopLayoutImpl = new TopLayoutImpl(topProxyLayout.getContext()).c(this.f32729w);
        }
        if (rewardBrowserMixTopLayoutImpl != null) {
            this.xv = rewardBrowserMixTopLayoutImpl;
        } else {
            a.f("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            c(topProxyLayout, rewardBrowserMixTopLayoutImpl, (ViewGroup) parent);
        }
    }

    private void c(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public void c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setVisible(z3);
        }
    }

    public void c(boolean z3, String str, String str2, boolean z4, boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.c(z3, str, str2, z4, z5);
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void c(int i4) {
        if (i4 == 2) {
            RewardChestView rewardChestView = this.sr;
            if (rewardChestView != null) {
                rewardChestView.ev();
            }
            c(this.gd);
        } else if (i4 == 3) {
            c(this.f32726k);
        } else if (i4 != 4) {
            c(this.ev);
        } else {
            c(this.f32727p);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.component.reward.top.w wVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setListener(wVar);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.c cVar = this.xv;
        if (cVar != null) {
            cVar.setPlayAgainEntranceText(str);
        }
    }

    public void c(int i4, int i5) {
        RewardChestView rewardChestView = this.sr;
        if (rewardChestView != null) {
            rewardChestView.c(i4, i5);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FullRewardExpressBackupView extends BackupView {
    private View bk;

    /* renamed from: t  reason: collision with root package name */
    private NativeExpressView f34002t;
    private FrameLayout ys;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.f33986c = context;
    }

    private void w() {
        FrameLayout frameLayout = new FrameLayout(this.f33986c);
        this.bk = frameLayout;
        frameLayout.setId(2114387735);
        addView(this.bk);
        FrameLayout frameLayout2 = (FrameLayout) this.bk.findViewById(2114387735);
        this.ys = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public void c(me meVar, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.component.utils.a.w("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f33991w = meVar;
        this.f34002t = nativeExpressView;
        if (wv.ev(meVar) == 7) {
            this.ux = "rewarded_video";
        } else {
            this.ux = "fullscreen_interstitial_ad";
        }
        c();
        this.f34002t.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public FrameLayout getVideoContainer() {
        return this.ys;
    }

    private void c() {
        this.f33987f = xk.ux(this.f33986c, this.f34002t.getExpectExpressWidth());
        this.f33990r = xk.ux(this.f33986c, this.f34002t.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f33987f, this.f33990r);
        }
        layoutParams.width = this.f33987f;
        layoutParams.height = this.f33990r;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
        NativeExpressView nativeExpressView = this.f34002t;
        if (nativeExpressView != null) {
            nativeExpressView.c(view, i4, uVar);
        }
    }
}

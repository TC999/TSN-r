package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BannerExpressVideoView extends c {
    public BannerExpressVideoView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context, meVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    protected void c() {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f32004c, this.sr, this.ux, this.f32006p);
        this.f32008w = nativeExpressVideoView;
        addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.w.c getVideoModel() {
        NativeExpressView nativeExpressView = this.f32008w;
        if (nativeExpressView != null) {
            return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void setDuration(int i4) {
        super.setDuration(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar) {
        super.setExpressInteractionListener(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        super.setVideoAdListener(xvVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void sr() {
        super.sr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void ux() {
        super.ux();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ boolean w() {
        return super.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public /* bridge */ /* synthetic */ void xv() {
        super.xv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.c
    public void c(me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f32004c, meVar, wVar, this.f32006p);
        this.xv = nativeExpressVideoView;
        nativeExpressVideoView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                BannerExpressVideoView bannerExpressVideoView = BannerExpressVideoView.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar = bannerExpressVideoView.f32005f;
                if (cVar != null) {
                    cVar.c(bannerExpressVideoView, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                BannerExpressVideoView.this.c(f4, f5);
                BannerExpressVideoView.this.f();
            }
        });
        xk.c((View) this.xv, 8);
        addView(this.xv, new ViewGroup.LayoutParams(-1, -1));
    }
}

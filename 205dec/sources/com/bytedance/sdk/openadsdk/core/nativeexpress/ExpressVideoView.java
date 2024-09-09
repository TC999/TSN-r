package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    protected int f33997c;

    /* renamed from: i  reason: collision with root package name */
    private boolean f33998i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f33999j;

    /* renamed from: q  reason: collision with root package name */
    private boolean f34000q;

    /* renamed from: w  reason: collision with root package name */
    public ImageView f34001w;

    public ExpressVideoView(Context context, me meVar, String str, boolean z3) {
        super(context, meVar, false, false, str, false, false);
        this.f33998i = false;
        if ("draw_ad".equals(str)) {
            this.f33998i = true;
        }
        this.f34000q = z3;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void ev() {
        xk.c((View) this.f35136p, 0);
        xk.c((View) this.f35133k, 0);
        xk.c((View) this.bk, 8);
    }

    private void fz() {
        p();
        RelativeLayout relativeLayout = this.f35136p;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.sr)).c(this.f35133k);
        }
        ev();
    }

    public void M_() {
        ImageView imageView = this.bk;
        if (imageView != null) {
            xk.c((View) imageView, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N_() {
        p();
        xk.c((View) this.f35136p, 0);
    }

    public boolean O_() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        return (xvVar == null || xvVar.ia() == null || !this.ux.ia().bk()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.sr.xv c(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        if (this.f34000q) {
            return new com.bytedance.sdk.openadsdk.core.video.nativevideo.w(context, viewGroup, meVar, str, z3, z4, z5);
        }
        return super.c(context, viewGroup, meVar, str, z3, z4, z5);
    }

    public void f() {
        ImageView imageView = this.f35127a;
        if (imageView != null) {
            xk.c((View) imageView, 8);
        }
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv getVideoController() {
        return this.ux;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f35127a;
        if (imageView != null && imageView.getVisibility() == 0) {
            xk.ux(this.f35136p);
        }
        w(this.f33997c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z3) {
        ImageView imageView = this.f35127a;
        if (imageView != null && imageView.getVisibility() == 0) {
            fz();
        } else {
            super.onWindowFocusChanged(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i4) {
        ImageView imageView = this.f35127a;
        if (imageView != null && imageView.getVisibility() == 0) {
            fz();
        } else {
            super.onWindowVisibilityChanged(i4);
        }
    }

    public void setCanInterruptVideoPlay(boolean z3) {
        this.f33998i = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPauseIcon(boolean z3) {
        if (this.f34001w == null) {
            this.f34001w = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.k.sr().gb() != null) {
                this.f34001w.setImageBitmap(com.bytedance.sdk.openadsdk.core.k.sr().gb());
            } else {
                this.f34001w.setImageDrawable(com.bytedance.sdk.component.utils.i.xv(com.bytedance.sdk.openadsdk.core.ls.getContext(), "tt_new_play_video"));
            }
            this.f34001w.setScaleType(ImageView.ScaleType.FIT_XY);
            int xv = (int) xk.xv(getContext(), this.fp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xv, xv);
            layoutParams.gravity = 17;
            this.f35130f.addView(this.f34001w, layoutParams);
        }
        if (z3) {
            this.f34001w.setVisibility(0);
        } else {
            this.f34001w.setVisibility(8);
        }
    }

    public void setShouldCheckNetChange(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.ux(z3);
        }
    }

    public void setShowAdInteractionView(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.w s3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar == null || (s3 = xvVar.s()) == null) {
            return;
        }
        s3.c(z3);
    }

    public void setVideoPlayStatus(int i4) {
        this.f33997c = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void w() {
        if (this.f33998i) {
            super.w(this.f33997c);
        }
    }

    public void xv() {
        ImageView imageView = this.bk;
        if (imageView != null) {
            xk.c((View) imageView, 8);
        }
    }

    public void w(boolean z3) {
        this.f33999j = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c(boolean z3) {
        if (this.f33999j) {
            super.c(z3);
        }
    }
}

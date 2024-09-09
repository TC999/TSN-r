package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private boolean f35123c;

    /* renamed from: w  reason: collision with root package name */
    private int f35124w;

    public NativeDrawVideoTsView(Context context, me meVar) {
        super(context, meVar);
        this.f35123c = false;
        setOnClickListener(this);
        this.f35124w = getResources().getConfiguration().orientation;
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f35127a;
        if (imageView != null && imageView.getVisibility() == 0) {
            xk.ux(this.f35136p);
        }
        w();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        int i4 = this.f35124w;
        int i5 = configuration.orientation;
        if (i4 == i5) {
            return;
        }
        this.f35124w = i5;
        xk.c(this, new xk.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.eq.xk.c
            public void c(View view) {
                NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                if (nativeDrawVideoTsView.ux == null) {
                    return;
                }
                NativeDrawVideoTsView.this.c(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void r() {
        this.ys = "draw_ad";
        super.r();
    }

    public void setCanInterruptVideoPlay(boolean z3) {
        this.f35123c = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void sr() {
        int i4 = getResources().getConfiguration().orientation;
        if (this.f35124w != i4) {
            this.f35124w = i4;
            xk.c(this, new xk.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.eq.xk.c
                public void c(View view) {
                    NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                    if (nativeDrawVideoTsView.ux == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.c(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.sr();
                }
            });
            return;
        }
        super.sr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void w() {
        if (this.f35123c) {
            super.w();
        }
    }

    public void c(Bitmap bitmap, int i4) {
        k.sr().c(bitmap);
        this.fp = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.sr.xv c(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        return new w(context, viewGroup, meVar, str, z3, z4, z5);
    }

    public NativeDrawVideoTsView(Context context, me meVar, String str, boolean z3, boolean z4) {
        super(context, meVar, str, z3, z4);
        this.f35123c = false;
        setOnClickListener(this);
        this.f35124w = getResources().getConfiguration().orientation;
    }
}

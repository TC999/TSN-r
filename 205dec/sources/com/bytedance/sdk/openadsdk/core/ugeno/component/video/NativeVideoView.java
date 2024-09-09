package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.n.gd;
import j0.d;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeVideoView extends NativeVideoTsView implements xv.c {

    /* renamed from: c  reason: collision with root package name */
    private int f34941c;

    /* renamed from: i  reason: collision with root package name */
    private d f34942i;

    /* renamed from: q  reason: collision with root package name */
    private boolean f34943q;

    /* renamed from: w  reason: collision with root package name */
    private c f34944w;

    public NativeVideoView(Context context) {
        super(context);
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(true);
        }
        this.f35141u.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void P_() {
        super.P_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.c
    public void Q_() {
        xk.c((View) this.f35136p, 8);
        super.Q_();
    }

    public void ac_() {
        c cVar = this.f34944w;
        if (cVar != null) {
            cVar.ev();
            xk.c((View) this.f35136p, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public xv c(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        c cVar = new c(context, viewGroup, meVar, str, z3, z4, z5);
        this.f34944w = cVar;
        return cVar;
    }

    public void ev() {
        c cVar = this.f34944w;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        d dVar = this.f34942i;
        if (dVar != null) {
            int[] c4 = dVar.c(i4, i5);
            super.onMeasure(c4[0], c4[1]);
            return;
        }
        super.onMeasure(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (!this.f34943q && i4 == 8) {
            ux();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z3) {
        super.setIsAutoPlay(z3);
        xk.c((View) this.f35136p, 0);
    }

    public void setLp(boolean z3) {
        this.f34943q = z3;
    }

    public void setPlayerType(int i4) {
        this.f34941c = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void sr() {
        xv xvVar = this.ux;
        if (xvVar == null) {
            P_();
        } else if ((xvVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) && !ys()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).au();
        }
        if (this.ux == null || !this.f35141u.get()) {
            return;
        }
        this.f35141u.set(false);
        r();
        if (bk()) {
            xk.c((View) this.f35136p, 0);
            ImageView imageView = this.f35127a;
            if (imageView != null) {
                xk.c((View) imageView, 8);
            }
            if (ng.bk(this.sr) != null) {
                sr c4 = ng.c(4, this.sr);
                c4.w(this.sr.jr());
                c4.w(this.f35130f.getWidth());
                c4.xv(this.f35130f.getHeight());
                c4.xv(this.sr.cf());
                this.sr.bm(this.f34941c);
                c4.ux(this.f34941c);
                c4.c(gd.c(this.sr));
                c4.c(this.ux.k());
                c4.w(this.ux.fz());
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).sr(this.f34941c);
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).c(this.sr);
                c(c4);
                this.ux.xv(false);
                return;
            }
            a.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        } else if (this.ux.u()) {
            a.w("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.ux.u());
            xk.c((View) this.f35136p, 0);
        } else {
            a.xv("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            p();
            xk.c((View) this.f35136p, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void ux() {
        super.ux();
        xk.c((View) this.f35136p, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.sr.xv.c
    public void w(long j4, int i4) {
        super.w(j4, i4);
        xk.c((View) this.f35136p, 0);
    }

    public void c(boolean z3, boolean z4) {
        p();
        xk.c((View) this.f35136p, 0);
        xk.c((View) this.bk, z3 ? 0 : 8);
        xk.c((View) this.f35133k, z4 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean c(long j4, boolean z3, boolean z4) {
        this.f35130f.setVisibility(0);
        if (this.ux == null) {
            this.ux = new com.bytedance.sdk.openadsdk.core.video.nativevideo.xv(getContext(), this.f35138r, this.sr, this.ys, false, false);
        }
        if (k() || this.gd) {
            c(this.xv, 25, ng.w(this.sr));
        }
        return false;
    }

    public void c(d dVar) {
        this.f34942i = dVar;
    }
}

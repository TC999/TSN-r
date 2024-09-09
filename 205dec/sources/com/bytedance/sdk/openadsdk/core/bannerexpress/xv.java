package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends w {
    public xv(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context, meVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.w
    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        BannerExpressVideoView bannerExpressVideoView = new BannerExpressVideoView(context, meVar, wVar);
        ((w) this).f32013c = bannerExpressVideoView;
        c(bannerExpressVideoView.getCurView(), this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    public com.bytedance.sdk.openadsdk.core.multipro.w.c p() {
        WeakReference<BannerExpressBackupView> weakReference = this.f32018r;
        if (weakReference != null && weakReference.get() != null) {
            return this.f32018r.get().getVideoModel();
        }
        c cVar = ((w) this).f32013c;
        if (cVar != null) {
            return ((BannerExpressVideoView) cVar).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        c cVar = ((w) this).f32013c;
        if (cVar != null) {
            cVar.setVideoAdListener(xvVar);
        }
    }
}

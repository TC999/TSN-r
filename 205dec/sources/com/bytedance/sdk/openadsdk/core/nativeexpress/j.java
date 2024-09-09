package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j extends fz {
    public j(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context, meVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.fz
    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, meVar, wVar, "embeded_ad");
        ((fz) this).f34061c = nativeExpressVideoView;
        c(nativeExpressVideoView, this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
    public com.bytedance.sdk.openadsdk.core.multipro.w.c p() {
        WeakReference<k> weakReference = this.ux;
        if (weakReference != null && weakReference.get() != null) {
            return this.ux.get().getVideoModel();
        }
        NativeExpressView nativeExpressView = ((fz) this).f34061c;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            ((NativeExpressVideoView) nativeExpressView).t();
            return ((NativeExpressVideoView) ((fz) this).f34061c).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(final com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        NativeExpressView nativeExpressView = ((fz) this).f34061c;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(new xv.sr() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.1
                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
                public void B_() {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoLoad();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
                public void c(int i4, int i5) {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoError(i4, i5);
                    }
                }
            });
            ((fz) this).f34061c.setVideoAdInteractionListener(new xv.InterfaceC0335xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.j.2
                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
                public void C_() {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoAdStartPlay();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
                public void D_() {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoAdPaused();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
                public void E_() {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoAdContinuePlay();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
                public void F_() {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onVideoAdComplete();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
                public void c(long j4, long j5) {
                    com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar2 = xvVar;
                    if (xvVar2 != null) {
                        xvVar2.onProgressUpdate(j4, j5);
                    }
                }
            });
        }
    }
}

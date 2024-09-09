package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u extends j {
    public u(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context, meVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j, com.bytedance.sdk.openadsdk.core.nativeexpress.fz
    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.sr = "draw_ad";
        NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, meVar, wVar, "draw_ad");
        ((fz) this).f34061c = nativeExpressDrawVideoView;
        c(nativeExpressDrawVideoView, this.xv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(boolean z3) {
        NativeExpressView nativeExpressView = ((fz) this).f34061c;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z3);
        }
    }
}

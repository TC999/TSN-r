package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i extends j {
    public i(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context, meVar, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j, com.bytedance.sdk.openadsdk.core.nativeexpress.fz
    public void c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.sr = "feed_video_middle_page";
        if (meVar == null) {
            return;
        }
        if (ng.bk(this.xv) != null) {
            ((fz) this).f34061c = new NativeExpressVideoView(context, meVar, wVar, this.sr);
        } else {
            ((fz) this).f34061c = new NativeExpressView(context, meVar, wVar, this.sr);
        }
        c(((fz) this).f34061c, this.xv);
        ((fz) this).f34061c.setBackupListener(new com.bytedance.sdk.component.adexpress.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.i.1
            @Override // com.bytedance.sdk.component.adexpress.w.xv
            public boolean c(ViewGroup viewGroup, int i4) {
                return false;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w, com.bytedance.sdk.openadsdk.ys.w.w.ys
    public void c(boolean z3) {
        NativeExpressView nativeExpressView = ((fz) this).f34061c;
        if (nativeExpressView == null || !(nativeExpressView instanceof NativeExpressVideoView)) {
            return;
        }
        ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z3);
    }
}

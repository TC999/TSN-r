package com.bytedance.sdk.openadsdk.core.live.xv;

import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static int c(me meVar) {
        if (bw.sr(meVar)) {
            return ((4 == bw.w(meVar)) && (1 == TTLiveCommerceHelper.getInstance().getLiveAuthStatus())) ? 1 : -1;
        }
        return -1;
    }
}

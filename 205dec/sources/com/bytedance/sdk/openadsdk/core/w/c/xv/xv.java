package com.bytedance.sdk.openadsdk.core.w.c.xv;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends w {

    /* renamed from: f  reason: collision with root package name */
    protected int f35362f = -1;
    protected String ux;

    public xv(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
    }

    public void c(String str) {
        this.ux = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.w, com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.containsKey("key_live_commerce_jump")) {
                    this.f35362f = ((Integer) map.get("key_live_commerce_jump")).intValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        int i4 = this.f35362f;
        if (i4 < 0 || i4 == 5 || i4 == 9 || i4 == 6) {
            return false;
        }
        TTLiveCommerceHelper.getInstance().reportLiveRoomJumpResult(this.f35278c, this.ux, this.f35362f);
        return false;
    }
}

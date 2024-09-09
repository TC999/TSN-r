package com.bytedance.sdk.openadsdk.core.ev.c.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements com.bytedance.sdk.openadsdk.core.ev.c.c.c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.c.c f33408c;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private me f33409w;
    private Context xv;

    public ux(me meVar, Context context, String str, String str2) {
        this.f33409w = meVar;
        this.xv = context;
        this.sr = str;
        this.ux = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ev.c.c.c
    public boolean c(Map<String, Object> map) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("event_tag", this.sr);
        if (!TextUtils.isEmpty(this.ux)) {
            hashMap.put("dpa_tag", this.ux);
        }
        int canOpenLive = TTLiveCommerceHelper.getInstance().canOpenLive(this.xv, this.f33409w, hashMap);
        c(canOpenLive);
        if (canOpenLive == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.ev.c.c.c cVar = this.f33408c;
        return cVar != null && cVar.c(map);
    }

    private void c(int i4) {
        TTLiveCommerceHelper.getInstance().reportLiveRoomJumpResult(this.f33409w, this.sr, i4);
    }
}

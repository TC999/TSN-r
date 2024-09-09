package com.bytedance.sdk.openadsdk.core.ugeno.c;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.u.me;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.core.ugeno.w.xv {
    public xv(Context context, me meVar, com.bytedance.sdk.openadsdk.core.ugeno.w.c cVar, ViewGroup viewGroup) {
        super(context, meVar, cVar, viewGroup);
    }

    private JSONObject k() {
        try {
            return new JSONObject(c.c(this.sr, this.ux).c(this.sr));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.xv
    protected JSONObject c() {
        return k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.xv, com.bytedance.sdk.component.adexpress.w.sr
    public int xv() {
        return 8;
    }
}

package com.bytedance.sdk.openadsdk.core.fz;

import com.bytedance.sdk.component.ats_api.IEmbedAppLog;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.eq.i;

@ATS(single = true, value = {"embed_applog"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements IEmbedAppLog {
    @Override // com.bytedance.sdk.component.ats_api.IEmbedAppLog
    @ATSMethod(3)
    public byte[] encrypt(byte[] bArr, int i4) {
        return com.bytedance.sdk.openadsdk.n.w.c(bArr, i4);
    }

    @Override // com.bytedance.sdk.component.ats_api.IEmbedAppLog
    @ATSMethod(1)
    public String getDid() {
        return com.bytedance.sdk.openadsdk.core.r.c().w();
    }

    @Override // com.bytedance.sdk.component.ats_api.IEmbedAppLog
    @ATSMethod(2)
    public String getOAID() {
        return i.c();
    }
}

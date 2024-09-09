package com.bytedance.sdk.component.ats_api;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

@ATSApi("embed_applog")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IEmbedAppLog {
    @ATSMethod(3)
    byte[] encrypt(byte[] bArr, int i4);

    @ATSMethod(1)
    String getDid();

    @ATSMethod(2)
    String getOAID();
}

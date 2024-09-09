package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import cn.jpush.android.local.JPushConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends com.kwad.sdk.core.network.b {
    @NonNull
    public final Map<String, String> aHo;

    public c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aHo = hashMap;
        hashMap.put("did", str);
        hashMap.put("sid", str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.aHo;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.DU().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}

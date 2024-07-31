package com.kwad.sdk.crash.report.upload;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.AbstractC10410b;
import com.kwad.sdk.core.network.idc.C10425a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.crash.report.upload.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10730c extends AbstractC10410b {
    @NonNull
    public final Map<String, String> aHo;

    public C10730c(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        this.aHo = hashMap;
        hashMap.put("did", str);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, str2);
        hashMap.put("fileExtend", str3);
        hashMap.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final Map<String, String> getBodyMap() {
        return this.aHo;
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return "https://" + C10425a.m26107DU().m26103W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }
}

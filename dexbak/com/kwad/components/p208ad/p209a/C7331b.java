package com.kwad.components.p208ad.p209a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10410b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.kwad.components.ad.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7331b extends AbstractC10410b {
    public C7331b(String str, List<String> list) {
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseBody() {
        putBody("protocolVersion", MBridgeConstans.NATIVE_VIDEO_VERSION);
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersionCode());
        putBody("sdkType", 1);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24891xZ();
    }
}

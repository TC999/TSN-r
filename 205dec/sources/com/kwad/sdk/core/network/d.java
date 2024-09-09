package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public d() {
        this(0, null);
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        try {
            putBody("protocolVersion", MBridgeConstans.NATIVE_VIDEO_VERSION);
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            int i4 = 1;
            putBody("sdkType", 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.EY());
            putBody("tkVersion", "5.1.7");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.Fc());
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).oK()) {
                i4 = 0;
            }
            putBody("liveSupportMode", i4);
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.Fb());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yu());
            putBody("ext", com.kwad.sdk.core.request.model.e.Fe());
            putBody("userInfo", com.kwad.sdk.core.request.model.g.Ff());
            putBody("requestSessionData", q.DQ().dP(getUrl()));
            putBody(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        if (com.kwad.framework.a.a.md.booleanValue()) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        }
    }

    protected boolean needAppList() {
        return false;
    }

    public d(int i4, @Nullable SceneImpl sceneImpl) {
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.h(needAppList(), i4));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.c(sceneImpl));
        }
    }
}

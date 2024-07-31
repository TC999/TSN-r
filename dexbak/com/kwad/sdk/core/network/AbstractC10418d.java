package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.C10474a;
import com.kwad.sdk.core.request.model.C10475b;
import com.kwad.sdk.core.request.model.C10477c;
import com.kwad.sdk.core.request.model.C10478d;
import com.kwad.sdk.core.request.model.C10479e;
import com.kwad.sdk.core.request.model.C10481g;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* renamed from: com.kwad.sdk.core.network.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10418d extends AbstractC10410b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";

    public AbstractC10418d() {
        this(0, null);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    protected void buildBaseBody() {
        try {
            putBody("protocolVersion", MBridgeConstans.NATIVE_VIDEO_VERSION);
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersionCode());
            int i = 1;
            putBody("sdkType", 1);
            putBody("appInfo", C10474a.m25996EY());
            putBody("tkVersion", "5.1.7");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", C10478d.m25986Fc());
            if (!((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24341oK()) {
                i = 0;
            }
            putBody("liveSupportMode", i);
            putBody("geoInfo", C10477c.m25987Fb());
            putBody("kGeoInfo", ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24334yu());
            putBody(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, C10479e.m25984Fe());
            putBody("userInfo", C10481g.m25982Ff());
            putBody("requestSessionData", C10441q.m26065DQ().m26063dP(getUrl()));
            putBody(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    protected void buildBaseHeader() {
        if (C9425a.f29473md.booleanValue()) {
            C9861c.m27501f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            C9861c.m27501f(DevelopMangerComponents.class);
        }
    }

    protected boolean needAppList() {
        return false;
    }

    public AbstractC10418d(int i, @Nullable SceneImpl sceneImpl) {
        putBody("deviceInfo", C10475b.m25990h(needAppList(), i));
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.m25997c(sceneImpl));
        }
    }
}

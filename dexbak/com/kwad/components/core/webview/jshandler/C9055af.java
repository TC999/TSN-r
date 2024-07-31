package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11102k;

/* renamed from: com.kwad.components.core.webview.jshandler.af */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9055af implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.af$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9056a extends C10482a {

        /* renamed from: WO */
        public String f29111WO;

        /* renamed from: WP */
        public int f29112WP;

        /* renamed from: WQ */
        public String f29113WQ;

        /* renamed from: WR */
        public int f29114WR;

        /* renamed from: WS */
        public String f29115WS;

        /* renamed from: WT */
        public String f29116WT;

        /* renamed from: WU */
        public String f29117WU;

        /* renamed from: WV */
        public int f29118WV;

        /* renamed from: WW */
        public String f29119WW;

        /* renamed from: WX */
        public int f29120WX;

        /* renamed from: WY */
        public String f29121WY;

        /* renamed from: WZ */
        public String f29122WZ;

        /* renamed from: Xa */
        public int f29123Xa;

        /* renamed from: Xb */
        public int f29124Xb;

        /* renamed from: Xc */
        public int f29125Xc;

        /* renamed from: Xd */
        public int f29126Xd;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public int sdkType;

        /* renamed from: so */
        public static C9056a m29322so() {
            C9056a c9056a = new C9056a();
            c9056a.f29111WO = BuildConfig.VERSION_NAME;
            c9056a.f29112WP = BuildConfig.VERSION_CODE;
            c9056a.f29113WQ = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
            c9056a.f29114WR = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersionCode();
            c9056a.sdkType = 1;
            Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
            c9056a.appVersion = C11102k.m23780bQ(context);
            c9056a.appName = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getAppName();
            c9056a.appId = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getAppId();
            c9056a.f29115WS = String.valueOf(C11013ag.m24132ck(context));
            c9056a.f29116WT = C11059bi.m23902Nf();
            c9056a.model = C11059bi.m23911MW();
            c9056a.f29117WU = C11059bi.m23909MY();
            c9056a.f29118WV = 1;
            c9056a.f29119WW = C11059bi.getOsVersion();
            c9056a.f29120WX = C11059bi.m23899Ni();
            c9056a.f29121WY = C11059bi.getLanguage();
            c9056a.f29122WZ = C11059bi.getLocale();
            c9056a.f29123Xa = C11059bi.getScreenWidth(context);
            c9056a.f29124Xb = C11059bi.getScreenHeight(context);
            c9056a.f29125Xc = C10751a.getStatusBarHeight(context);
            c9056a.f29126Xd = C10751a.m24924a(context, 50.0f);
            return c9056a;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        interfaceC10627c.mo25251a(C9056a.m29322so());
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}

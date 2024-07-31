package com.kwad.sdk.core.webview.p423d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.InterfaceC9866g;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.C11137y;

/* renamed from: com.kwad.sdk.core.webview.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10633a implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C10634a extends C10482a {

        /* renamed from: WO */
        public String f29624WO;

        /* renamed from: WP */
        public int f29625WP;

        /* renamed from: WQ */
        public String f29626WQ;

        /* renamed from: WR */
        public int f29627WR;

        /* renamed from: WS */
        public String f29628WS;

        /* renamed from: WT */
        public String f29629WT;

        /* renamed from: WU */
        public String f29630WU;

        /* renamed from: WV */
        public int f29631WV;

        /* renamed from: WW */
        public String f29632WW;

        /* renamed from: WX */
        public int f29633WX;

        /* renamed from: WY */
        public String f29634WY;

        /* renamed from: WZ */
        public String f29635WZ;

        /* renamed from: Xa */
        public int f29636Xa;

        /* renamed from: Xb */
        public int f29637Xb;

        /* renamed from: Xc */
        public int f29638Xc;

        /* renamed from: Xd */
        public int f29639Xd;
        public String aEF;
        public String aEG;
        public boolean aEH;
        public String aEI;
        public String appId;
        public String appName;
        public String appVersion;
        public String atm;
        public String atn;
        public String ayD;
        public String azF;
        public String azo;
        public String azt;
        public String azu;
        public String model;
        public int sdkType;

        /* renamed from: Ha */
        public static C10634a m25246Ha() {
            C10634a c10634a = new C10634a();
            c10634a.f29624WO = BuildConfig.VERSION_NAME;
            c10634a.f29625WP = BuildConfig.VERSION_CODE;
            c10634a.ayD = "5.1.7";
            c10634a.aEI = "1.3";
            c10634a.f29626WQ = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersion();
            c10634a.f29627WR = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getApiVersionCode();
            c10634a.sdkType = 1;
            Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
            c10634a.appVersion = C11102k.m23780bQ(context);
            c10634a.appName = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getAppName();
            c10634a.appId = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getAppId();
            c10634a.aEF = "";
            c10634a.azu = C11137y.m23633LL();
            InterfaceC9866g interfaceC9866g = (InterfaceC9866g) C9861c.m27501f(InterfaceC9866g.class);
            if (interfaceC9866g != null) {
                c10634a.azt = interfaceC9866g.mo27496ow();
            }
            c10634a.f29628WS = String.valueOf(C11013ag.m24132ck(context));
            c10634a.f29629WT = C11059bi.m23902Nf();
            c10634a.model = C11059bi.m23911MW();
            c10634a.f29630WU = C11059bi.m23909MY();
            c10634a.f29631WV = 1;
            c10634a.f29632WW = C11059bi.getOsVersion();
            c10634a.f29633WX = C11059bi.m23899Ni();
            c10634a.f29634WY = C11059bi.getLanguage();
            c10634a.f29635WZ = C11059bi.getLocale();
            c10634a.aEH = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp();
            c10634a.aEG = C11029av.getDeviceId();
            c10634a.f29636Xa = C11059bi.getScreenWidth(context);
            c10634a.f29637Xb = C11059bi.getScreenHeight(context);
            c10634a.atm = C11029av.m24033cv(context);
            c10634a.atn = C11029av.getOaid();
            c10634a.azo = C11029av.m24032cw(context);
            c10634a.azF = C11029av.m24031cx(context);
            c10634a.f29638Xc = C10751a.getStatusBarHeight(context);
            c10634a.f29639Xd = C10751a.m24924a(context, 50.0f);
            return c10634a;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        interfaceC10627c.mo25251a(C10634a.m25246Ha());
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}

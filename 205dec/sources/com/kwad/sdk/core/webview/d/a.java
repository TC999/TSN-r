package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class C0704a extends com.kwad.sdk.core.response.a.a {
        public String WO;
        public int WP;
        public String WQ;
        public int WR;
        public String WS;
        public String WT;
        public String WU;
        public int WV;
        public String WW;
        public int WX;
        public String WY;
        public String WZ;
        public int Xa;
        public int Xb;
        public int Xc;
        public int Xd;
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

        public static C0704a Ha() {
            C0704a c0704a = new C0704a();
            c0704a.WO = BuildConfig.VERSION_NAME;
            c0704a.WP = BuildConfig.VERSION_CODE;
            c0704a.ayD = "5.1.7";
            c0704a.aEI = "1.3";
            c0704a.WQ = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0704a.WR = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0704a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0704a.appVersion = k.bQ(context);
            c0704a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0704a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0704a.aEF = "";
            c0704a.azu = y.LL();
            g gVar = (g) c.f(g.class);
            if (gVar != null) {
                c0704a.azt = gVar.ow();
            }
            c0704a.WS = String.valueOf(ag.ck(context));
            c0704a.WT = bi.Nf();
            c0704a.model = bi.MW();
            c0704a.WU = bi.MY();
            c0704a.WV = 1;
            c0704a.WW = bi.getOsVersion();
            c0704a.WX = bi.Ni();
            c0704a.WY = bi.getLanguage();
            c0704a.WZ = bi.getLocale();
            c0704a.aEH = ((f) ServiceProvider.get(f.class)).yp();
            c0704a.aEG = av.getDeviceId();
            c0704a.Xa = bi.getScreenWidth(context);
            c0704a.Xb = bi.getScreenHeight(context);
            c0704a.atm = av.cv(context);
            c0704a.atn = av.getOaid();
            c0704a.azo = av.cw(context);
            c0704a.azF = av.cx(context);
            c0704a.Xc = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
            c0704a.Xd = com.kwad.sdk.d.a.a.a(context, 50.0f);
            return c0704a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(C0704a.Ha());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}

package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.InterfaceC9866g;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.p368b.C9768b;
import com.kwad.sdk.p434g.InterfaceC10761a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11011ae;
import com.kwad.sdk.utils.C11024aq;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.C11137y;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import org.json.JSONArray;

@KsJson
/* renamed from: com.kwad.sdk.core.request.model.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10475b extends C10482a {
    private static boolean aze;
    private static JSONArray azf;

    /* renamed from: RN */
    public String f29575RN;

    /* renamed from: WU */
    public String f29576WU;

    /* renamed from: WV */
    public int f29577WV;

    /* renamed from: WX */
    public int f29578WX;

    /* renamed from: WY */
    public String f29579WY;

    /* renamed from: Xa */
    public int f29580Xa;

    /* renamed from: Xb */
    public int f29581Xb;
    public String atm;
    public String atn;
    public String azA;
    public String azC;
    public String azD;
    public String azg;
    public String azh;
    public String azi;
    public String azj;
    public String azk;
    public String azl;
    public int azm;
    public int azn;
    public String azo;
    public String azp;
    public String azq;
    public int azr;
    public String azs;
    public String azt;
    public String azu;
    public JSONArray azv;
    public String azw;
    public String azy;
    public String azz;
    public int azx = 0;
    public long azB = 0;

    /* renamed from: Fa */
    public static C10475b m25993Fa() {
        C10475b c10475b = new C10475b();
        try {
            c10475b.atn = C11029av.getOaid();
            c10475b.azp = C11029av.getDeviceId();
            c10475b.azs = C11059bi.m23911MW();
            c10475b.f29577WV = 1;
            c10475b.f29578WX = C11059bi.m23899Ni();
            c10475b.azl = C11059bi.getOsVersion();
            c10475b.azu = C11137y.m23633LL();
            InterfaceC9866g interfaceC9866g = (InterfaceC9866g) C9861c.m27501f(InterfaceC9866g.class);
            if (interfaceC9866g != null) {
                c10475b.azt = interfaceC9866g.mo27496ow();
            }
            if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)) != null) {
                c10475b.atm = C11029av.m24033cv(ServiceProvider.m24363KO());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c10475b;
    }

    /* renamed from: bh */
    private static synchronized JSONArray m25992bh(Context context) {
        synchronized (C10475b.class) {
            if (!aze) {
                aze = true;
                InstalledAppInfoManager.m24282a(context, new InterfaceC10761a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    /* renamed from: g */
                    private static void m25988g(JSONArray jSONArray) {
                        JSONArray unused = C10475b.azf = jSONArray;
                    }

                    @Override // com.kwad.sdk.p434g.InterfaceC10761a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        m25988g(jSONArray);
                    }
                });
            }
            JSONArray jSONArray = azf;
            if (jSONArray != null) {
                azf = null;
                return jSONArray;
            }
            return null;
        }
    }

    /* renamed from: h */
    public static C10475b m25990h(boolean z, int i) {
        C10475b c10475b = new C10475b();
        try {
            Context m24363KO = ServiceProvider.m24363KO();
            c10475b.atm = C11029av.m24033cv(m24363KO);
            c10475b.azg = C11029av.m24030cy(m24363KO);
            c10475b.azh = C11029av.m24029cz(m24363KO);
            c10475b.azi = C11059bi.m23888cZ(m24363KO);
            c10475b.atn = C11029av.getOaid();
            c10475b.azs = C11059bi.m23911MW();
            c10475b.f29576WU = C11059bi.m23909MY();
            c10475b.f29577WV = 1;
            c10475b.f29578WX = C11059bi.m23899Ni();
            c10475b.azl = C11059bi.getOsVersion();
            c10475b.f29579WY = C11102k.getLanguage();
            c10475b.f29581Xb = C11102k.getScreenHeight(m24363KO);
            c10475b.f29580Xa = C11102k.getScreenWidth(m24363KO);
            c10475b.azm = C11102k.m23777bT(m24363KO);
            c10475b.azn = C11102k.m23776bU(m24363KO);
            c10475b.azo = C11029av.m24032cw(m24363KO);
            if (z) {
                c10475b.azv = m25992bh(m24363KO);
            }
            c10475b.azp = C11029av.getDeviceId();
            c10475b.azB = C11059bi.m23910MX();
            c10475b.azq = C11059bi.m23902Nf();
            c10475b.azu = C11137y.m23633LL();
            InterfaceC9866g interfaceC9866g = (InterfaceC9866g) C9861c.m27501f(InterfaceC9866g.class);
            if (interfaceC9866g != null) {
                c10475b.azt = interfaceC9866g.mo27496ow();
            }
            c10475b.azr = C11059bi.m23901Ng();
            InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
            try {
                StringBuilder sb = new StringBuilder("i=");
                sb.append(interfaceC10968f.getAppId());
                sb.append(",n=");
                sb.append(interfaceC10968f.getAppName());
                sb.append(",external:");
                sb.append(interfaceC10968f.mo24339yp());
                sb.append(",v1:");
                sb.append(interfaceC10968f.getApiVersion());
                sb.append(",v2:3.3.59.1");
                sb.append(",d:");
                sb.append(c10475b.azp);
                sb.append(",dh:");
                String str = c10475b.azp;
                sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
                sb.append(",o:");
                sb.append(c10475b.atn);
                sb.append(",b:616");
                sb.append(",p:");
                sb.append(C11024aq.isInMainProcess(m24363KO));
                sb.append(",dy:");
                sb.append(C9425a.adG);
                C10331c.m26257T("DeviceInfo", sb.toString());
            } catch (Exception unused) {
            }
            c10475b.azw = C11059bi.m23900Nh();
            c10475b.azx = i;
            if (m25989yH()) {
                c10475b.azy = C9768b.m27830Ao().getVersion(m24363KO, "com.smile.gifmaker");
                c10475b.azz = C9768b.m27830Ao().getVersion(m24363KO, "com.kuaishou.nebula");
                c10475b.azA = C9768b.m27830Ao().getVersion(m24363KO, "com.tencent.mm");
            }
            c10475b.f29575RN = C11059bi.m23904Nd();
            c10475b.azk = C11011ae.m24139ci(m24363KO);
            c10475b.azC = C11059bi.m23895Nm();
            c10475b.azD = C11059bi.m23872ha("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c10475b;
    }

    /* renamed from: yH */
    private static boolean m25989yH() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24316yH();
    }
}

package com.kwad.sdk.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static List<String> aJx;
    private static volatile boolean aJy;

    @KsJson
    /* renamed from: com.kwad.sdk.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0714a extends com.kwad.sdk.commercial.c.a {
        public List<b> aJz;

        public C0714a(List<b> list) {
            this.aJz = list;
        }
    }

    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long aJA;
        public long aJB;
        public long aJC;
        public String aJD;
        public String aJE;
        public String sdkVersion;
        public String stage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c {
        private String aJD;
        private String aJE;
        private String sdkVersion;
        private String stage;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String a(c cVar) {
            return "exit&" + cVar.aJD + "&" + cVar.stage + "&" + cVar.aJE + "&" + cVar.sdkVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c gb(String str) {
            String[] split = str.split("&");
            c cVar = new c();
            cVar.aJD = split[1];
            cVar.stage = split[2];
            cVar.aJE = split[3];
            cVar.sdkVersion = split[4];
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String c(String str, String str2, String str3, String str4) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&");
            sb.append(str2);
            sb.append("&");
            sb.append(str3);
            sb.append("&");
            sb.append(str4);
            sb.append("&");
            k.zd();
            sb.append(k.getSDKVersion());
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Jq() {
        List<b> Js = Js();
        if (!Js.isEmpty()) {
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "monitorInfoList:" + Js);
            com.kwad.sdk.commercial.b.o(new C0714a(Js));
        }
        aJy = true;
        Jr();
    }

    private static void Jr() {
        List<String> list = aJx;
        if (list == null) {
            return;
        }
        for (String str : list) {
            fZ(str);
        }
        aJx.clear();
    }

    private static List<b> Js() {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> al = y.al(ServiceProvider.getContext(), "dynamic_monitor_info");
        if (al == null) {
            return arrayList;
        }
        for (String str : al.keySet()) {
            if (str.startsWith("enter")) {
                Object obj = al.get(str);
                long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                c gb = c.gb(str);
                String a4 = c.a(gb);
                Object obj2 = al.get(a4);
                long longValue2 = longValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                long j4 = longValue2 > 0 ? longValue2 : 0L;
                b bVar = new b();
                bVar.aJA = longValue;
                bVar.aJB = j4;
                bVar.aJC = longValue2;
                bVar.aJD = gb.aJD;
                bVar.stage = gb.stage;
                bVar.aJE = gb.aJE;
                bVar.sdkVersion = gb.sdkVersion;
                arrayList.add(bVar);
                y.au("dynamic_monitor_info", str);
                y.au("dynamic_monitor_info", a4);
            }
        }
        return arrayList;
    }

    public static void ak(String str, String str2) {
        g(str, str2, "other");
    }

    public static void al(String str, String str2) {
        h(str, str2, "other");
    }

    private static void b(String str, String str2, String str3, String str4) {
        try {
            String c4 = c.c(str, str2, str3, str4);
            if (!aJy) {
                ga(c4);
            } else {
                fZ(c4);
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private static synchronized void fZ(String str) {
        synchronized (a.class) {
            long b4 = y.b("dynamic_monitor_info", str, 0L);
            com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + b4);
            y.a("dynamic_monitor_info", str, b4 + 1);
        }
    }

    public static void g(String str, String str2, String str3) {
        b("enter", str, str2, str3);
    }

    private static void ga(String str) {
        if (aJx == null) {
            aJx = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.e.c.d("DynamicRunMonitor", "saveToCache: " + str);
        aJx.add(str);
    }

    public static void h(String str, String str2, String str3) {
        b("exit", str, str2, str3);
    }

    public static void report() {
        g.schedule(new ay() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.Jq();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}

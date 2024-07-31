package com.kwad.sdk.p439j;

import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.model.AdnName;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11137y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.j.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10819a {
    private static List<String> aJx;
    private static volatile boolean aJy;

    @KsJson
    /* renamed from: com.kwad.sdk.j.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10821a extends AbstractC9822a {
        public List<C10822b> aJz;

        public C10821a(List<C10822b> list) {
            this.aJz = list;
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.j.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10822b extends C10482a {
        public long aJA;
        public long aJB;
        public long aJC;
        public String aJD;
        public String aJE;
        public String sdkVersion;
        public String stage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.j.a$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10823c {
        private String aJD;
        private String aJE;
        private String sdkVersion;
        private String stage;

        private C10823c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public static String m24730a(C10823c c10823c) {
            return "exit&" + c10823c.aJD + "&" + c10823c.stage + "&" + c10823c.aJE + "&" + c10823c.sdkVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: gb */
        public static C10823c m24722gb(String str) {
            String[] split = str.split("&");
            C10823c c10823c = new C10823c();
            c10823c.aJD = split[1];
            c10823c.stage = split[2];
            c10823c.aJE = split[3];
            c10823c.sdkVersion = split[4];
            return c10823c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public static String m24727c(String str, String str2, String str3, String str4) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&");
            sb.append(str2);
            sb.append("&");
            sb.append(str3);
            sb.append("&");
            sb.append(str4);
            sb.append("&");
            C10829k.m24699zd();
            sb.append(C10829k.getSDKVersion());
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Jq */
    public static void m24742Jq() {
        List<C10822b> m24740Js = m24740Js();
        if (!m24740Js.isEmpty()) {
            C10331c.m26254d("DynamicRunMonitor", "monitorInfoList:" + m24740Js);
            C9815b.m27654o(new C10821a(m24740Js));
        }
        aJy = true;
        m24741Jr();
    }

    /* renamed from: Jr */
    private static void m24741Jr() {
        List<String> list = aJx;
        if (list == null) {
            return;
        }
        for (String str : list) {
            m24735fZ(str);
        }
        aJx.clear();
    }

    /* renamed from: Js */
    private static List<C10822b> m24740Js() {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> m23596al = C11137y.m23596al(ServiceProvider.getContext(), "dynamic_monitor_info");
        if (m23596al == null) {
            return arrayList;
        }
        for (String str : m23596al.keySet()) {
            if (str.startsWith("enter")) {
                Object obj = m23596al.get(str);
                long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                C10823c m24722gb = C10823c.m24722gb(str);
                String m24730a = C10823c.m24730a(m24722gb);
                Object obj2 = m23596al.get(m24730a);
                long longValue2 = longValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                long j = longValue2 > 0 ? longValue2 : 0L;
                C10822b c10822b = new C10822b();
                c10822b.aJA = longValue;
                c10822b.aJB = j;
                c10822b.aJC = longValue2;
                c10822b.aJD = m24722gb.aJD;
                c10822b.stage = m24722gb.stage;
                c10822b.aJE = m24722gb.aJE;
                c10822b.sdkVersion = m24722gb.sdkVersion;
                arrayList.add(c10822b);
                C11137y.m23595au("dynamic_monitor_info", str);
                C11137y.m23595au("dynamic_monitor_info", m24730a);
            }
        }
        return arrayList;
    }

    /* renamed from: ak */
    public static void m24739ak(String str, String str2) {
        m24734g(str, str2, AdnName.OTHER);
    }

    /* renamed from: al */
    public static void m24738al(String str, String str2) {
        m24732h(str, str2, AdnName.OTHER);
    }

    /* renamed from: b */
    private static void m24737b(String str, String str2, String str3, String str4) {
        try {
            String m24727c = C10823c.m24727c(str, str2, str3, str4);
            if (!aJy) {
                m24733ga(m24727c);
            } else {
                m24735fZ(m24727c);
            }
        } catch (Throwable th) {
            C8571a.reportSdkCaughtException(th);
        }
    }

    /* renamed from: fZ */
    private static synchronized void m24735fZ(String str) {
        synchronized (C10819a.class) {
            long m23589b = C11137y.m23589b("dynamic_monitor_info", str, 0L);
            C10331c.m26254d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + m23589b);
            C11137y.m23611a("dynamic_monitor_info", str, m23589b + 1);
        }
    }

    /* renamed from: g */
    public static void m24734g(String str, String str2, String str3) {
        m24737b("enter", str, str2, str3);
    }

    /* renamed from: ga */
    private static void m24733ga(String str) {
        if (aJx == null) {
            aJx = new CopyOnWriteArrayList();
        }
        C10331c.m26254d("DynamicRunMonitor", "saveToCache: " + str);
        aJx.add(str);
    }

    /* renamed from: h */
    public static void m24732h(String str, String str2, String str3) {
        m24737b("exit", str, str2, str3);
    }

    public static void report() {
        C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10819a.m24742Jq();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}

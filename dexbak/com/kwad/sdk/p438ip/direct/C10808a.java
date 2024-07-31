package com.kwad.sdk.p438ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.sdk.ip.direct.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10808a {
    private static int aIc = -1;
    private static volatile boolean aId;
    private static C10816c aIl;
    private static HandlerThread aIm;
    private static Handler aIn;
    private static List<HttpDnsInfo.IpInfo> aIe = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> aIf = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> aIg = new ArrayList();
    private static List<C10816c> aIh = new ArrayList();
    private static List<C10816c> aIi = new ArrayList();
    private static PriorityBlockingQueue<C10816c> aIj = new PriorityBlockingQueue<>();
    private static AtomicInteger aIk = new AtomicInteger(0);
    private static volatile boolean aIo = false;
    private static float aIp = -1.0f;
    private static float aIq = -1.0f;
    private static float aIr = -1.0f;
    private static int aIs = 0;
    private static volatile boolean aIt = false;
    private static volatile boolean aIu = false;
    private static NetworkMonitor.InterfaceC9881a aIv = new NetworkMonitor.InterfaceC9881a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.InterfaceC9881a
        /* renamed from: a */
        public final void mo24766a(NetworkMonitor.NetworkState networkState) {
            C10331c.m26254d("IpDirect_Helper", "*********onNetworkChange");
            if (C10808a.aIu) {
                C10808a.access$102(true);
                C10331c.m26254d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
                return;
            }
            C10808a.access$002(true);
        }
    };
    private static Runnable aIw = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            C10808a.m24789IA();
        }
    };

    /* renamed from: G */
    private static void m24791G(List<HttpDnsInfo.IpInfo> list) {
        m24771b(list, aIh);
        if (aIh.isEmpty()) {
            return;
        }
        float f = 0.0f;
        for (C10816c c10816c : aIh) {
            f += c10816c.m24756IR();
        }
        aIp = f / aIh.size();
    }

    /* renamed from: H */
    private static void m24790H(List<HttpDnsInfo.IpInfo> list) {
        m24771b(list, aIi);
        if (aIi.isEmpty()) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        for (C10816c c10816c : aIi) {
            i += c10816c.getWeight();
            f += c10816c.getWeight() * c10816c.m24756IR();
        }
        if (i != 0) {
            aIq = f / i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IA */
    public static void m24789IA() {
        m24784IF();
        List<HttpDnsInfo.IpInfo> list = aIe;
        List<HttpDnsInfo.IpInfo> list2 = aIf;
        clear();
        if (aIo) {
            C10331c.m26254d("IpDirect_Helper", "is picking return");
            return;
        }
        C10331c.m26254d("IpDirect_Helper", "start pick");
        aIo = true;
        m24791G(list);
        m24790H(list2);
        if (aIh.isEmpty() && aIi.isEmpty()) {
            InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
            if (interfaceC10970h == null) {
                aIo = false;
                return;
            } else if (!interfaceC10970h.mo24312yL()) {
                C10331c.m26254d("IpDirect_Helper", "isIpPreferEnable:false");
                aIo = false;
                return;
            } else {
                m24786ID();
            }
        }
        aIo = false;
        C10331c.m26254d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IB */
    public static void m24788IB() {
        if (m24787IC()) {
            return;
        }
        m24785IE();
    }

    /* renamed from: IC */
    private static boolean m24787IC() {
        List<C10816c> list = aIh;
        List<C10816c> list2 = aIi;
        if (!list.isEmpty()) {
            aIl = list.get(new Random().nextInt(list.size()));
            C10331c.m26254d("IpDirect_Helper", "set from recommend:" + aIl);
            aIs = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i2 = 0;
        for (C10816c c10816c : list2) {
            i2 += c10816c.getWeight();
        }
        int nextInt = random.nextInt(i2);
        int i3 = 0;
        while (true) {
            if (i3 >= list2.size()) {
                break;
            }
            nextInt -= list2.get(i3).getWeight();
            if (nextInt < 0) {
                i = i3;
                break;
            }
            i3++;
        }
        aIl = list2.get(i);
        C10331c.m26254d("IpDirect_Helper", "set from backUp:" + aIl);
        aIs = 2;
        return true;
    }

    /* renamed from: ID */
    private static void m24786ID() {
        List<HttpDnsInfo.IpInfo> list = aIg;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.f29585ip)) {
                C10816c m24764f = C10812b.m24764f(ipInfo.f29585ip, aIc);
                if (m24764f.isSuccess()) {
                    aIj.offer(m24764f);
                }
            }
        }
        C10816c peek = aIj.peek();
        if (peek != null) {
            aIr = peek.m24756IR();
        }
    }

    /* renamed from: IE */
    private static void m24785IE() {
        if (aIj.isEmpty()) {
            return;
        }
        C10816c peek = aIj.peek();
        if (peek.m24756IR() < aIc) {
            aIl = peek;
            C10331c.m26254d("IpDirect_Helper", "set from Other:" + aIl);
            aIs = 3;
        }
    }

    /* renamed from: IF */
    private static void m24784IF() {
        if (aIc == -1) {
            InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
            if (interfaceC10970h != null) {
                aIc = interfaceC10970h.mo24311yM();
            } else {
                aIc = 200;
            }
        }
    }

    /* renamed from: IG */
    private static boolean m24783IG() {
        if (aIt) {
            C10331c.m26254d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = aIk.get();
        C10331c.m26254d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    /* renamed from: IH */
    private static void m24782IH() {
        aIk.getAndIncrement();
        C10331c.m26254d("IpDirect_Helper", "addFailedTimes:" + aIk.intValue());
    }

    /* renamed from: II */
    public static void m24781II() {
        C10816c c10816c;
        Handler handler;
        if (!aId || (c10816c = aIl) == null || TextUtils.isEmpty(c10816c.getIp()) || (handler = aIn) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    /* renamed from: IJ */
    public static void m24780IJ() {
        m24782IH();
        m24779IK();
        m24778IL();
        aIs = 0;
        m24788IB();
        m24789IA();
    }

    /* renamed from: IK */
    private static void m24779IK() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        C10816c c10816c = aIl;
        String ip = c10816c == null ? "" : c10816c.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = aIe.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                ipInfo2 = null;
                break;
            }
            ipInfo2 = it.next();
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.f29585ip)) {
                break;
            }
        }
        if (ipInfo2 != null) {
            aIe.remove(ipInfo2);
            ipInfo2 = null;
        }
        Iterator<HttpDnsInfo.IpInfo> it2 = aIf.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next = it2.next();
            if (next != null && TextUtils.equals(ip, next.f29585ip)) {
                ipInfo2 = next;
                break;
            }
        }
        if (ipInfo2 != null) {
            aIf.remove(ipInfo2);
        } else {
            ipInfo = ipInfo2;
        }
        Iterator<HttpDnsInfo.IpInfo> it3 = aIg.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            HttpDnsInfo.IpInfo next2 = it3.next();
            if (next2 != null && TextUtils.equals(ip, next2.f29585ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            aIg.remove(ipInfo);
        }
    }

    /* renamed from: IL */
    private static void m24778IL() {
        C10816c c10816c;
        if (aIl == null) {
            return;
        }
        List<C10816c> list = aIh;
        if (list != null && !list.isEmpty() && aIh.contains(aIl)) {
            aIh.remove(aIl);
            C10331c.m26254d("IpDirect_Helper", "sRecommendEntityList remove:" + aIl);
        }
        List<C10816c> list2 = aIi;
        if (list2 != null && !list2.isEmpty()) {
            if (aIi.contains(aIl)) {
                aIi.remove(aIl);
                C10331c.m26254d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aIl);
            }
            Iterator<C10816c> it = aIi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c10816c = null;
                    break;
                }
                c10816c = it.next();
                if (c10816c != null && TextUtils.equals(c10816c.getIp(), aIl.getIp())) {
                    C10331c.m26254d("IpDirect_Helper", "set removeEntity:" + c10816c.getIp());
                    break;
                }
            }
            if (c10816c != null) {
                aIi.remove(c10816c);
                C10331c.m26254d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + c10816c);
            }
        }
        C10816c peek = aIj.peek();
        if (peek != null && peek == aIl) {
            aIj.poll();
        }
        aIl = null;
    }

    /* renamed from: Iv */
    private static void m24777Iv() {
        Handler handler;
        if (aIo || (handler = aIn) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    /* renamed from: Iw */
    public static String m24776Iw() {
        C10816c c10816c = aIl;
        return c10816c != null ? c10816c.getIp() : "";
    }

    /* renamed from: Ix */
    public static float m24775Ix() {
        return aIp;
    }

    /* renamed from: Iy */
    public static float m24774Iy() {
        return aIq;
    }

    /* renamed from: Iz */
    public static float m24773Iz() {
        return aIr;
    }

    /* renamed from: a */
    public static void m24772a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h == null) {
            C10331c.m26246w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean mo24313yK = interfaceC10970h.mo24313yK();
        aId = mo24313yK;
        C10331c.m26254d("IpDirect_Helper", "isEnable:" + mo24313yK);
        if (mo24313yK) {
            C10331c.m26254d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aIe = list;
            aIf = httpDnsInfo.backUpList;
            aIg = httpDnsInfo.otherList;
            if (list.isEmpty() && aIf.isEmpty() && aIg.isEmpty()) {
                C10331c.m26246w("IpDirect_Helper", "HttpDnsInfo is empty");
                return;
            }
            init();
            m24777Iv();
        }
    }

    static /* synthetic */ boolean access$002(boolean z) {
        aIu = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z) {
        aIt = true;
        return true;
    }

    /* renamed from: b */
    private static void m24771b(List<HttpDnsInfo.IpInfo> list, List<C10816c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.f29585ip)) {
                C10331c.m26254d("IpDirect_Helper", ipInfo.toString());
                C10816c m24764f = C10812b.m24764f(ipInfo.f29585ip, aIc);
                m24764f.m24753dB(ipInfo.weight);
                if (m24764f.isSuccess() && m24764f.m24756IR() < aIc) {
                    list2.add(m24764f);
                }
            }
        }
    }

    private static void clear() {
        aIh.clear();
        aIi.clear();
        aIj.clear();
    }

    @Nullable
    /* renamed from: fK */
    public static String m24770fK(String str) {
        if (!aId) {
            C10331c.m26254d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        } else if (m24769fL(str)) {
            C10331c.m26254d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        } else if (!m24783IG()) {
            C10331c.m26254d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        } else {
            String m24776Iw = m24776Iw();
            C10331c.m26254d("IpDirect_Helper", "getIpByHost ip:" + m24776Iw);
            return m24776Iw;
        }
    }

    /* renamed from: fL */
    private static boolean m24769fL(String str) {
        boolean z = !TextUtils.equals("https://" + str, C10760g.m24895xV());
        if (z) {
            C10331c.m26254d("IpDirect_Helper", "非核心域名 current host:" + C10760g.m24895xV() + "try direct host:https://" + str);
        }
        return z;
    }

    public static int getType() {
        return aIs;
    }

    private static void init() {
        if (aIm != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        aIm = handlerThread;
        handlerThread.start();
        aIn = new Handler(aIm.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    C10808a.m24789IA();
                    C10808a.m24788IB();
                } else if (i != 2) {
                } else {
                    C10808a.m24780IJ();
                }
            }
        };
        InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
        if (interfaceC10968f != null) {
            NetworkMonitor.getInstance().m27465a(interfaceC10968f.getContext(), aIv);
        }
    }
}

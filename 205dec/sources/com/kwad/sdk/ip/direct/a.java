package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static int aIc = -1;
    private static volatile boolean aId;
    private static c aIl;
    private static HandlerThread aIm;
    private static Handler aIn;
    private static List<HttpDnsInfo.IpInfo> aIe = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> aIf = new ArrayList();
    private static List<HttpDnsInfo.IpInfo> aIg = new ArrayList();
    private static List<c> aIh = new ArrayList();
    private static List<c> aIi = new ArrayList();
    private static PriorityBlockingQueue<c> aIj = new PriorityBlockingQueue<>();
    private static AtomicInteger aIk = new AtomicInteger(0);
    private static volatile boolean aIo = false;
    private static float aIp = -1.0f;
    private static float aIq = -1.0f;
    private static float aIr = -1.0f;
    private static int aIs = 0;
    private static volatile boolean aIt = false;
    private static volatile boolean aIu = false;
    private static NetworkMonitor.a aIv = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (a.aIu) {
                a.access$102(true);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
                return;
            }
            a.access$002(true);
        }
    };
    private static Runnable aIw = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.IA();
        }
    };

    private static void G(List<HttpDnsInfo.IpInfo> list) {
        b(list, aIh);
        if (aIh.isEmpty()) {
            return;
        }
        float f4 = 0.0f;
        for (c cVar : aIh) {
            f4 += cVar.IR();
        }
        aIp = f4 / aIh.size();
    }

    private static void H(List<HttpDnsInfo.IpInfo> list) {
        b(list, aIi);
        if (aIi.isEmpty()) {
            return;
        }
        int i4 = 0;
        float f4 = 0.0f;
        for (c cVar : aIi) {
            i4 += cVar.getWeight();
            f4 += cVar.getWeight() * cVar.IR();
        }
        if (i4 != 0) {
            aIq = f4 / i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void IA() {
        IF();
        List<HttpDnsInfo.IpInfo> list = aIe;
        List<HttpDnsInfo.IpInfo> list2 = aIf;
        clear();
        if (aIo) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "start pick");
        aIo = true;
        G(list);
        H(list2);
        if (aIh.isEmpty() && aIi.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                aIo = false;
                return;
            } else if (!hVar.yL()) {
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                aIo = false;
                return;
            } else {
                ID();
            }
        }
        aIo = false;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void IB() {
        if (IC()) {
            return;
        }
        IE();
    }

    private static boolean IC() {
        List<c> list = aIh;
        List<c> list2 = aIi;
        if (!list.isEmpty()) {
            aIl = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from recommend:" + aIl);
            aIs = 1;
            return true;
        }
        int i4 = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int i5 = 0;
        for (c cVar : list2) {
            i5 += cVar.getWeight();
        }
        int nextInt = random.nextInt(i5);
        int i6 = 0;
        while (true) {
            if (i6 >= list2.size()) {
                break;
            }
            nextInt -= list2.get(i6).getWeight();
            if (nextInt < 0) {
                i4 = i6;
                break;
            }
            i6++;
        }
        aIl = list2.get(i4);
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from backUp:" + aIl);
        aIs = 2;
        return true;
    }

    private static void ID() {
        List<HttpDnsInfo.IpInfo> list = aIg;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c f4 = b.f(ipInfo.ip, aIc);
                if (f4.isSuccess()) {
                    aIj.offer(f4);
                }
            }
        }
        c peek = aIj.peek();
        if (peek != null) {
            aIr = peek.IR();
        }
    }

    private static void IE() {
        if (aIj.isEmpty()) {
            return;
        }
        c peek = aIj.peek();
        if (peek.IR() < aIc) {
            aIl = peek;
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set from Other:" + aIl);
            aIs = 3;
        }
    }

    private static void IF() {
        if (aIc == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                aIc = hVar.yM();
            } else {
                aIc = 200;
            }
        }
    }

    private static boolean IG() {
        if (aIt) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i4 = aIk.get();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "value:" + i4);
        return i4 <= 3;
    }

    private static void IH() {
        aIk.getAndIncrement();
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "addFailedTimes:" + aIk.intValue());
    }

    public static void II() {
        c cVar;
        Handler handler;
        if (!aId || (cVar = aIl) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = aIn) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void IJ() {
        IH();
        IK();
        IL();
        aIs = 0;
        IB();
        IA();
    }

    private static void IK() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo ipInfo2;
        c cVar = aIl;
        String ip = cVar == null ? "" : cVar.getIp();
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
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
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
            if (next != null && TextUtils.equals(ip, next.ip)) {
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
            if (next2 != null && TextUtils.equals(ip, next2.ip)) {
                ipInfo = next2;
                break;
            }
        }
        if (ipInfo != null) {
            aIg.remove(ipInfo);
        }
    }

    private static void IL() {
        c cVar;
        if (aIl == null) {
            return;
        }
        List<c> list = aIh;
        if (list != null && !list.isEmpty() && aIh.contains(aIl)) {
            aIh.remove(aIl);
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + aIl);
        }
        List<c> list2 = aIi;
        if (list2 != null && !list2.isEmpty()) {
            if (aIi.contains(aIl)) {
                aIi.remove(aIl);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + aIl);
            }
            Iterator<c> it = aIi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (cVar != null && TextUtils.equals(cVar.getIp(), aIl.getIp())) {
                    com.kwad.sdk.core.e.c.d("IpDirect_Helper", "set removeEntity:" + cVar.getIp());
                    break;
                }
            }
            if (cVar != null) {
                aIi.remove(cVar);
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + cVar);
            }
        }
        c peek = aIj.peek();
        if (peek != null && peek == aIl) {
            aIj.poll();
        }
        aIl = null;
    }

    private static void Iv() {
        Handler handler;
        if (aIo || (handler = aIn) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Iw() {
        c cVar = aIl;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float Ix() {
        return aIp;
    }

    public static float Iy() {
        return aIq;
    }

    public static float Iz() {
        return aIr;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean yK = hVar.yK();
        aId = yK;
        com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isEnable:" + yK);
        if (yK) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            aIe = list;
            aIf = httpDnsInfo.backUpList;
            aIg = httpDnsInfo.otherList;
            if (list.isEmpty() && aIf.isEmpty() && aIg.isEmpty()) {
                com.kwad.sdk.core.e.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
                return;
            }
            init();
            Iv();
        }
    }

    static /* synthetic */ boolean access$002(boolean z3) {
        aIu = true;
        return true;
    }

    static /* synthetic */ boolean access$102(boolean z3) {
        aIt = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.e.c.d("IpDirect_Helper", ipInfo.toString());
                c f4 = b.f(ipInfo.ip, aIc);
                f4.dB(ipInfo.weight);
                if (f4.isSuccess() && f4.IR() < aIc) {
                    list2.add(f4);
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
    public static String fK(String str) {
        if (!aId) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        } else if (fL(str)) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "isHostInvalid:false \uff1a" + str);
            return "";
        } else if (!IG()) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        } else {
            String Iw = Iw();
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "getIpByHost ip:" + Iw);
            return Iw;
        }
    }

    private static boolean fL(String str) {
        boolean z3 = !TextUtils.equals(JPushConstants.HTTPS_PRE + str, g.xV());
        if (z3) {
            com.kwad.sdk.core.e.c.d("IpDirect_Helper", "\u975e\u6838\u5fc3\u57df\u540d current host:" + g.xV() + "try direct host:https://" + str);
        }
        return z3;
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
                int i4 = message.what;
                if (i4 == 1) {
                    a.IA();
                    a.IB();
                } else if (i4 != 2) {
                } else {
                    a.IJ();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), aIv);
        }
    }
}

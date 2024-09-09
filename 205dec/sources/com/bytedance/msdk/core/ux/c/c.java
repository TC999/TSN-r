package com.bytedance.msdk.core.ux.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.c;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.api.c.w;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.k.gd;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.core.ux.w.ev;
import com.bytedance.msdk.f.bw;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.xv.r;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.msdk.core.ux.c {
    private static volatile c ev;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f28205c = {"unity", "ks"};

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, Integer> f28208w = new HashMap();
    private final Map<String, Integer> xv = new HashMap();
    private final Map<String, CopyOnWriteArrayList<ev>> sr = new ConcurrentHashMap();
    private final Map<String, p> ux = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f28206f = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private final Map<String, Integer> f28207r = new HashMap();
    private final Comparator<ev> gd = new Comparator<ev>() { // from class: com.bytedance.msdk.core.ux.c.c.4
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(ev evVar, ev evVar2) {
            ux uxVar;
            if (evVar == null || evVar2 == null || (uxVar = evVar.f28224c) == null || evVar2.f28224c == null) {
                return 0;
            }
            return ((int) uxVar.getFillTime()) - ((int) evVar2.f28224c.getFillTime());
        }
    };

    private c() {
    }

    public void f(String str, String str2, int i4) {
        Map<String, Integer> map = this.xv;
        map.put(str + "_" + str2, Integer.valueOf(i4));
    }

    public boolean sr(String str, String str2, int i4) {
        if (i4 == 2) {
            return false;
        }
        Map<String, Integer> map = this.f28208w;
        Integer num = map.get(str + "_" + str2);
        if (num != null) {
            return num.intValue() == 1 || num.intValue() == 2;
        }
        return false;
    }

    public int ux(String str, String str2, int i4) {
        if (i4 == 2) {
            return 0;
        }
        Map<String, Integer> map = this.f28208w;
        Integer num = map.get(str + "_" + str2);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void w() {
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                int i5;
                String str;
                xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528lowMemory\uff0cstart clean");
                int i6 = 0;
                int i7 = 0;
                for (Map.Entry entry : c.this.sr.entrySet()) {
                    List<ev> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528lowMemory\uff0cadnSlotId: " + ((String) entry.getKey()) + ", \u6e05\u7406\u524d, \u7f13\u5b58\u603b\u6570: " + list.size());
                        int i8 = 1;
                        int i9 = 0;
                        for (ev evVar : list) {
                            if (evVar != null && evVar.f28224c != null) {
                                if (evVar.xv() != null) {
                                    str = evVar.xv().u();
                                    i5 = evVar.xv().ls();
                                } else {
                                    i5 = i8;
                                    str = "";
                                }
                                if (evVar.f28224c.isHasShown() || !evVar.f28224c.isReady(str)) {
                                    list.remove(evVar);
                                    i9++;
                                }
                                i8 = i5;
                            }
                        }
                        if (list.size() > i8) {
                            xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528lowMemory\uff0cadnSlotId: " + ((String) entry.getKey()) + ", \u6e05\u7406\u65e0\u6548\u5e7f\u544a\u540e\u4ecd\u9700\u6e05\u7406\uff0c\u7f13\u5b58\u603b\u6570: " + list.size() + "\uff0cadCount: " + i8 + ", invalidCnt: " + i9);
                            i4 = 0;
                            for (ev evVar2 : list) {
                                if (list.size() <= i8) {
                                    break;
                                }
                                list.remove(evVar2);
                                i4++;
                            }
                        } else {
                            i4 = 0;
                        }
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528lowMemory\uff0cadnSlotId: " + ((String) entry.getKey()) + ", \u6e05\u7406\u540e\uff0c\u7f13\u5b58\u603b\u6570: " + list.size() + ", adCount: " + i8 + ", invalidCnt: " + i9 + ", foceCleanCnt\uff1a" + i4);
                        i6 += i9;
                        i7 += i4;
                    }
                    wv.c(i6, i7);
                }
            }
        });
    }

    public void xv(String str, String str2, int i4) {
        Map<String, Integer> map = this.f28208w;
        map.put(str + "_" + str2, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<ev>> w(List<ux> list, String str, w wVar, int i4, ux uxVar) {
        HashMap hashMap = new HashMap();
        for (ux uxVar2 : list) {
            if (uxVar2 != null && uxVar2 != uxVar && ux(str, uxVar2.getAdNetworkSlotId(), i4) == 2 && uxVar2.isReady(str) && !uxVar2.isHasShown()) {
                List list2 = (List) hashMap.get(uxVar2.getAdNetworkSlotId());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ev(uxVar2, c(wVar, uxVar2), 0L, wVar));
                    hashMap.put(uxVar2.getAdNetworkSlotId(), arrayList);
                } else {
                    list2.add(new ev(uxVar2, c(wVar, uxVar2), 0L, wVar));
                }
            }
        }
        return hashMap;
    }

    public boolean xv(String str, String str2) {
        Map<String, Integer> map = this.xv;
        Integer num = map.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.msdk.core.ux.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0421c implements c.InterfaceC0386c {

        /* renamed from: w  reason: collision with root package name */
        private w f28219w;

        C0421c(w wVar) {
            this.f28219w = wVar;
        }

        @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
        public void c(ux uxVar, com.bytedance.msdk.core.k.xv xvVar) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(uxVar);
            c(arrayList, xvVar);
        }

        @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
        public void m_() {
        }

        @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
        public void c(List<ux> list, com.bytedance.msdk.core.k.xv xvVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ux uxVar : list) {
                if (uxVar != null) {
                    uxVar.setFillTime(SystemClock.elapsedRealtime());
                    arrayList.add(new ev(uxVar, xvVar, 0L, this.f28219w));
                }
            }
            if (arrayList.size() > 0) {
                ux uxVar2 = ((ev) arrayList.get(0)).f28224c;
                xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5e7f\u544a\u7f13\u5b58\u6210\u529f --- " + uxVar2.getAdNetWorkName() + ", adType: " + com.bytedance.msdk.c.c.c(uxVar2.getAdType(), uxVar2.getSubAdType()) + ", adnSlotId: " + uxVar2.getAdNetworkSlotId() + ", ad\u4e2a\u6570: " + arrayList.size());
                c.this.c(uxVar2.getAdNetworkSlotId(), (List<ev>) arrayList, false);
            }
        }

        @Override // com.bytedance.msdk.adapter.c.InterfaceC0386c
        public void c(com.bytedance.msdk.api.c cVar, com.bytedance.msdk.core.k.xv xvVar) {
            if (cVar == null || xvVar == null) {
                return;
            }
            xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5e7f\u544a\u7f13\u5b58\u5931\u8d25 --- " + xvVar.k() + ", " + xvVar.bk() + ", " + com.bytedance.msdk.c.c.c(xvVar.w(), xvVar.c()) + ", errCode: " + cVar.xv + ",msg=" + cVar.sr);
        }
    }

    public void sr(String str, String str2) {
        this.f28206f.put(str, str2);
    }

    public p ux(String str, String str2) {
        Map<String, p> map = this.ux;
        return map.get(str + "_" + str2);
    }

    public static c c() {
        if (ev == null) {
            synchronized (c.class) {
                if (ev == null) {
                    ev = new c();
                }
            }
        }
        return ev;
    }

    public void c(String str, String str2, p pVar, int i4) {
        if (pVar != null) {
            Map<String, p> map = this.ux;
            map.put(str + "_" + str2, pVar);
        }
        this.f28207r.put(str2, Integer.valueOf(i4));
    }

    private int w(String str, w wVar, boolean z3) {
        boolean z4;
        int i4;
        CopyOnWriteArrayList<ev> copyOnWriteArrayList = this.sr.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String u3 = wVar != null ? wVar.u() : "";
            ArrayList arrayList = new ArrayList();
            ev evVar = null;
            boolean z5 = false;
            for (ev evVar2 : copyOnWriteArrayList) {
                MediationConstant.AdIsReadyStatus isReadyStatus = evVar2.f28224c.isReadyStatus();
                if (isReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    z4 = c(u3, evVar2.f28224c);
                } else {
                    z4 = isReadyStatus != MediationConstant.AdIsReadyStatus.AD_IS_READY;
                }
                if (!z4) {
                    if (com.bytedance.msdk.core.ux.c.c(evVar2.xv(), wVar, evVar2.f28224c)) {
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u590d\u7528\u6210\u529f\uff1a--------" + evVar2.f28224c.getAdNetWorkName() + ", adSlotId: " + str);
                        z5 = true;
                    } else {
                        i4 = 6;
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:AdSlot\u4e0d\u7b26\u5408 -------: " + evVar2.f28224c.getAdNetWorkName() + ", adSlotId: " + str);
                    }
                } else {
                    copyOnWriteArrayList.remove(evVar2);
                    i4 = 5;
                    xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5e7f\u544a\u8fc7\u671f\u4e86 -------: " + evVar2.f28224c.getAdNetWorkName() + ", adSlotId: " + str);
                }
                if (evVar == null) {
                    evVar = evVar2;
                }
                com.bytedance.msdk.core.ux.w.c cVar = new com.bytedance.msdk.core.ux.w.c();
                cVar.sr(evVar2.f28224c.getLoadSort());
                cVar.ux(evVar2.f28224c.getShowSort());
                cVar.w(evVar2.f28224c.getAdNetworkSlotId());
                cVar.w(i4);
                cVar.c(evVar2.f28224c.isHasShown() ? 1 : 0);
                arrayList.add(cVar);
            }
            if (z5) {
                return 3;
            }
            if (!z3 || evVar == null) {
                return 2;
            }
            r.c(wVar, evVar.f28224c, c(arrayList));
            return 2;
        }
        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5f53\u524d\u6ca1\u6709\u5e7f\u544a\u7f13\u5b58 -------adnSlotId: " + str);
        return 1;
    }

    public String c(String str) {
        return this.f28206f.get(str);
    }

    public void c(final String str, final w wVar, final Map<String, Object> map, final boolean z3, final com.bytedance.msdk.api.sr.p pVar, final gd gdVar, final Context context) {
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.c.c.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                ev evVar;
                List<ev> list = (List) c.this.sr.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (ev evVar2 : list) {
                        if (evVar2 != null && evVar2.f28224c.isHasShown()) {
                            list.remove(evVar2);
                            arrayList.add(evVar2);
                        }
                    }
                }
                boolean z4 = false;
                if (xv.w()) {
                    if (arrayList.size() <= 0 || (evVar = (ev) arrayList.get(0)) == null) {
                        str2 = "";
                        str3 = str2;
                    } else {
                        str3 = com.bytedance.msdk.c.c.c(evVar.f28224c.getAdType(), evVar.f28224c.getSubAdType());
                        str2 = evVar.f28224c.getAdNetWorkName();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u7f13\u5b58\u79fb\u9664 -----\uff1a");
                    sb.append(str2);
                    sb.append(", ");
                    sb.append(str3);
                    sb.append(", ");
                    sb.append(str);
                    sb.append(arrayList.size() > 0 ? ", size: " + arrayList.size() : "\u79fb\u9664\u5e7f\u544a\u6570\u4e3a0");
                    xv.c("TTMediationSDK", sb.toString());
                }
                w wVar2 = wVar;
                String u3 = wVar2 != null ? wVar2.u() : "";
                w wVar3 = wVar;
                int fz = wVar3 != null ? wVar3.fz() : 0;
                w wVar4 = wVar;
                boolean z5 = wVar4 == null || wVar4.fz() == 1;
                if (!com.bytedance.msdk.core.c.w().c(u3, str, fz) && z3) {
                    z4 = true;
                }
                if (z4 && !z5 && c.this.xv(u3, str)) {
                    c.this.c(str, wVar, map, context, pVar, gdVar);
                    return;
                }
                xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0c\u56e0\u4e3a\uff1a\u5df2\u53d1\u8d77waterfall\u9884\u52a0\u8f7d\uff0c\u6216feed\u591a\u5e7f\u544a\uff0c\u6216\u672a\u5f00\u542fadn\u9884\u52a0\u8f7d\uff0c\u6216\u662fbanner\u8f6e\u64ad --: " + str);
            }
        });
    }

    public void c(final List<ux> list, final String str, final w wVar, final int i4, final ux uxVar) {
        if (list == null || list.isEmpty() || wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.c.c.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : c.this.w(list, str, wVar, i4, uxVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<ev> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        c.this.c(str2, list2, true);
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528\uff0cshow\u540e\u653e\u56de\u590d\u7528\u6c60\uff1aadnSlotId:" + str2 + ", \u4e2a\u6570\uff1a" + list2.size());
                    }
                }
            }
        });
    }

    private com.bytedance.msdk.core.k.xv c(w wVar, ux uxVar) {
        com.bytedance.msdk.core.k.xv xvVar = new com.bytedance.msdk.core.k.xv();
        xvVar.w(wVar.fz()).c(uxVar.getSubAdType()).xv(uxVar.getAdNetworkSlotType()).sr(uxVar.getLoadSort()).ux(uxVar.getShowSort()).w(uxVar.getAdNetWorkName()).c(uxVar.getCustomAdNetWorkName()).xv(uxVar.getAdNetworkSlotId());
        return xvVar;
    }

    public void c(String str, List<ev> list, boolean z3) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<ev> copyOnWriteArrayList = this.sr.get(str);
        if (copyOnWriteArrayList != null) {
            for (ev evVar : list) {
                if (!c(copyOnWriteArrayList, evVar)) {
                    copyOnWriteArrayList.add(evVar);
                }
            }
        } else {
            this.sr.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z3) {
            bw.c(this.sr.get(str), this.gd);
        }
    }

    private boolean c(List<ev> list, ev evVar) {
        for (ev evVar2 : list) {
            if (evVar2 != null && evVar != null && evVar2.f28224c == evVar.f28224c) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<ev> c(String str, w wVar, int i4) {
        CopyOnWriteArrayList<ev> copyOnWriteArrayList = this.sr.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int ls = wVar != null ? wVar.ls() : 1;
        ArrayList<ev> arrayList = new ArrayList();
        int ux = ux(wVar != null ? wVar.u() : "", str, i4);
        if (ux == 1) {
            for (int i5 = 0; arrayList.size() < ls && i5 < copyOnWriteArrayList.size(); i5++) {
                if (!copyOnWriteArrayList.get(i5).w() && com.bytedance.msdk.core.ux.c.c(copyOnWriteArrayList.get(i5).xv(), wVar, copyOnWriteArrayList.get(i5).f28224c)) {
                    arrayList.add(copyOnWriteArrayList.get(i5));
                }
            }
            for (int i6 = 0; arrayList.size() < ls && i6 < copyOnWriteArrayList.size(); i6++) {
                if (copyOnWriteArrayList.get(i6).w() && com.bytedance.msdk.core.ux.c.c(copyOnWriteArrayList.get(i6).xv(), wVar, copyOnWriteArrayList.get(i6).f28224c)) {
                    arrayList.add(copyOnWriteArrayList.get(i6));
                }
            }
            for (ev evVar : arrayList) {
                evVar.c(true);
            }
            xv.c("TTMediationSDK", "--==-- \u590d\u7528\u6a21\u5f0f1\uff0c\u4e0d\u4ece\u590d\u7528\u6c60\u79fb\u9664\uff0c\u83b7\u53d6\u7f13\u5b58: " + str + ", " + arrayList.size());
        } else if (ux == 2) {
            for (ev evVar2 : copyOnWriteArrayList) {
                if (arrayList.size() >= ls) {
                    break;
                } else if (evVar2 != null && com.bytedance.msdk.core.ux.c.c(evVar2.xv(), wVar, evVar2.f28224c)) {
                    copyOnWriteArrayList.remove(evVar2);
                    arrayList.add(evVar2);
                }
            }
            xv.c("TTMediationSDK", "--==-- \u590d\u7528\u6a21\u5f0f2\uff0c\u4ece\u590d\u7528\u6c60\u79fb\u9664\uff0c\u83b7\u53d6\u7f13\u5b58: " + str + ", " + arrayList.size());
        }
        return arrayList;
    }

    public synchronized int c(String str, w wVar, boolean z3) {
        if (w(wVar != null ? wVar.u() : "", str) == 0) {
            return w(str, wVar, z3);
        }
        CopyOnWriteArrayList<ev> copyOnWriteArrayList = this.sr.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            ev evVar = null;
            ArrayList arrayList = z3 ? new ArrayList() : null;
            boolean z4 = false;
            for (ev evVar2 : copyOnWriteArrayList) {
                int c4 = c(evVar2, evVar2.xv(), wVar, "\u5e7f\u544a\u590d\u7528");
                if (c4 == -1) {
                    z4 = true;
                } else {
                    if (c4 != 6) {
                        copyOnWriteArrayList.remove(evVar2);
                    }
                    if (z3) {
                        if (evVar == null) {
                            evVar = evVar2;
                        }
                        com.bytedance.msdk.core.ux.w.c cVar = new com.bytedance.msdk.core.ux.w.c();
                        cVar.sr(evVar2.f28224c.getLoadSort());
                        cVar.ux(evVar2.f28224c.getShowSort());
                        cVar.w(evVar2.f28224c.getAdNetworkSlotId());
                        cVar.w(c4);
                        cVar.c(evVar2.f28224c.isHasShown() ? 1 : 0);
                        arrayList.add(cVar);
                    }
                }
            }
            if (z4) {
                return 3;
            }
            if (z3 && evVar != null) {
                r.c(wVar, evVar.f28224c, c(arrayList));
            }
            return 2;
        }
        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:\u5f53\u524d\u6ca1\u6709\u5e7f\u544a\u7f13\u5b58 -------adnSlotId: " + str);
        return 1;
    }

    private String c(List<com.bytedance.msdk.core.ux.w.c> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i4 = 0; i4 < list.size(); i4++) {
                sb.append(list.get(i4).c());
                if (i4 == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e4) {
                xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528\uff1aadCannotUseInfo json err: " + e4.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, w wVar, Map<String, Object> map, Context context, com.bytedance.msdk.api.sr.p pVar, gd gdVar) {
        String[] strArr;
        if (wVar == null) {
            xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0cadSlot\u4e3a\u7a7a -------: " + str);
        } else if (context == null) {
            xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0ccontext\u4e3anull -------: " + str);
        } else {
            p ux = ux(wVar.u(), str);
            String str2 = null;
            if (ux != null) {
                try {
                    str2 = com.bytedance.msdk.core.r.r.c(ux.f(), com.bytedance.msdk.core.r.r.c(ux.t()), com.bytedance.msdk.c.c.c(ux.a(), ux.ux()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2) && com.bytedance.msdk.core.r.r.w(str2) && ux != null) {
                for (String str3 : this.f28205c) {
                    if (TextUtils.equals(str3, ux.t())) {
                        xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0c" + str3 + "\u4e3a\u5355\u4f8b\u6a21\u5f0f -------: " + str);
                        return;
                    }
                }
                int intValue = this.f28207r.get(str) != null ? this.f28207r.get(str).intValue() : -1;
                xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5f00\u59cb -------: " + str);
                com.bytedance.msdk.adapter.c c4 = com.bytedance.msdk.core.r.r.c(ux);
                if (c4 != null) {
                    if (!k.c().xv(wVar.u(), ux.ia())) {
                        xv.c("TMe", "adn \u4ee3\u7801\u4f4d\u9884\u8bf7\u6c42\u89e6\u53d1\u6b21\u6570\u62e6\u622a............");
                        Pair<String, String> c5 = k.c().c(wVar.u(), ux.ia());
                        if (c5 != null) {
                            com.bytedance.msdk.api.w.w wVar2 = new com.bytedance.msdk.api.w.w(41041, com.bytedance.msdk.api.c.c(41041), (String) c5.second, (String) c5.first);
                            r.c(ux, wVar, c().c(ux.ia()), true, 2, intValue, 4, 1, (com.bytedance.msdk.api.c) wVar2, -1L, false, false);
                            r.c(wVar2, wVar, ux, intValue, 4, 1, c().c(ux.ia()), 0L, (String) null, (String) null, (String) null, 0L);
                            return;
                        }
                        return;
                    }
                    c4.setAdapterListener(new C0421c(wVar));
                    c4.loadAdInter(context, ux, com.bytedance.msdk.core.r.r.c(ux, wVar, map, pVar, 4, 1, true, -1L), wVar, gdVar, intValue);
                    xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u5df2\u53d1\u5b8c -------: " + str);
                    return;
                }
                r.c(ux, wVar, 4, 1);
                return;
            }
            xv.c("TTMediationSDK", "--==-- \u5e7f\u544a\u590d\u7528:show\u65f6\u9884\u8bf7\u6c42\u53d6\u6d88\uff0cclassName\u6216wfcBean\u4e3a\u7a7a, className: " + str2 + ", wfcBean: " + ux + ", adnSlotId: " + str);
        }
    }
}

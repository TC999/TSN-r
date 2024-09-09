package com.bytedance.msdk.core.ux.w;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.sr.a;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.f.wv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends com.bytedance.msdk.core.ux.c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f28232c;

    /* renamed from: a  reason: collision with root package name */
    private int f28233a;
    private int bk;

    /* renamed from: k  reason: collision with root package name */
    private List<String> f28235k;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, Integer> f28238w = new HashMap();
    private final Map<String, Long> xv = new HashMap();
    private final Map<String, com.bytedance.msdk.api.c.w> sr = new HashMap();
    private final Map<String, ConcurrentHashMap<String, List<ev>>> ux = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<String, com.bytedance.msdk.api.c>> f28234f = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    private final Map<String, Boolean> f28237r = new HashMap();
    private final Map<String, com.bytedance.msdk.core.ux.w.xv> ev = new HashMap();
    private boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private int f28236p = 20;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c {
        private int ev;

        /* renamed from: f  reason: collision with root package name */
        private final InterfaceC0422w f28247f;

        /* renamed from: r  reason: collision with root package name */
        private int f28248r;
        private final int sr;
        private final List<a> ux;

        /* renamed from: w  reason: collision with root package name */
        private final Activity f28249w;
        private final int xv;

        c(Activity activity, List<a> list, int i4, int i5, InterfaceC0422w interfaceC0422w) {
            this.f28249w = activity;
            this.ux = list;
            this.xv = i4;
            this.sr = i5;
            this.f28247f = interfaceC0422w;
            this.f28248r = list.size();
            this.ev = list.size();
        }

        static /* synthetic */ int w(c cVar) {
            int i4 = cVar.f28248r;
            cVar.f28248r = i4 - 1;
            return i4;
        }

        static /* synthetic */ int xv(c cVar) {
            int i4 = cVar.ev;
            cVar.ev = i4 - 1;
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            a remove;
            for (int i4 = 0; i4 < this.xv; i4++) {
                if (this.ux.size() > 0 && (remove = this.ux.remove(0)) != null) {
                    com.bytedance.msdk.api.c.w c4 = remove.c();
                    String str = remove.w().get(0);
                    if (c4 == null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684GMAdSlotBase\u4e3a\u7a7a\uff0c\u5e7f\u544a\u4f4d\uff1a" + str);
                    } else if (c4.fz() == 1) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684GMAdSlotBase\u4e3abanner\u7c7b\u578b\uff0c\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u9884\u52a0\u8f7d\uff0c\u5e7f\u544a\u4f4d: " + str);
                    } else if (c4.fz() == 2) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684GMAdSlotBase\u4e3a\u63d2\u5c4f\u7c7b\u578b\uff0c\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u9884\u52a0\u8f7d\uff0c\u5e7f\u544a\u4f4d: " + str);
                    } else if (c4.fz() == 9) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684GMAdSlotBase\u4e3aDraw\u7c7b\u578b\uff0c\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u9884\u52a0\u8f7d\uff0c\u5e7f\u544a\u4f4d: " + str);
                    } else {
                        w.this.c(str, c4);
                        com.bytedance.msdk.core.k.w c5 = com.bytedance.msdk.ux.c.c.p().c(str, 0, 101);
                        if (c5 != null) {
                            c4.ev(c5.yu());
                        } else if (c4.fz() == 8) {
                            c4.ev(10);
                        }
                        w.this.c(this.f28249w, str, 5, 0, new xv() { // from class: com.bytedance.msdk.core.ux.w.w.c.1
                            @Override // com.bytedance.msdk.core.ux.w.w.xv
                            public void c(String str2, boolean z3, int i5, List<com.bytedance.msdk.c.ux> list) {
                                c.w(c.this);
                                if (!z3) {
                                    c.xv(c.this);
                                }
                                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- pendingLoadNum: " + c.this.f28248r);
                                if (c.this.f28248r > 0 || c.this.f28247f == null) {
                                    return;
                                }
                                c.this.f28247f.c(c.this.ev <= 0);
                            }
                        });
                    }
                }
            }
            if (this.ux.size() > 0) {
                com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.w.w.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c();
                    }
                }, this.sr * 1000);
            }
        }
    }

    /* renamed from: com.bytedance.msdk.core.ux.w.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0422w {
        void c(boolean z3);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface xv {
        void c(String str, boolean z3, int i4, List<com.bytedance.msdk.c.ux> list);
    }

    private w() {
    }

    public static long f(String str) {
        String w3 = wv.c((String) null, com.bytedance.msdk.core.c.getContext()).w("preload_rit_ts");
        try {
            if (!TextUtils.isEmpty(w3)) {
                return new JSONObject(w3).optLong(str, -1L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return -1L;
    }

    private static void r(String str) {
        JSONObject jSONObject;
        wv c4 = wv.c((String) null, com.bytedance.msdk.core.c.getContext());
        String w3 = c4.w("preload_rit_ts");
        try {
            if (TextUtils.isEmpty(w3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(w3);
            }
            jSONObject.put(str, System.currentTimeMillis());
            c4.c("preload_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<ev> sr(String str) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<ev> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        Map<String, com.bytedance.msdk.api.c> map = this.f28234f.get(str);
        if (map != null) {
            map.clear();
        }
        return arrayList;
    }

    public Map<String, List<ev>> ux(String str) {
        return this.ux.get(str);
    }

    public boolean xv(String str, int i4) {
        int w3 = w(str, i4);
        return w3 == 2 || w3 == 3 || w3 == 4;
    }

    public com.bytedance.msdk.core.ux.w.xv xv(String str) {
        return this.ev.get(str);
    }

    private void xv(String str, com.bytedance.msdk.api.c.w wVar) {
        ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                List<ev> list = concurrentHashMap.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    ev evVar = list.get(0);
                    if (c(evVar, evVar.xv(), wVar, "\u805a\u5408\u9884\u7f13\u5b58") != -1) {
                        concurrentHashMap.remove(str2);
                    }
                }
            }
        }
    }

    public int w(String str, int i4) {
        Integer num;
        if (i4 == 2 || (num = this.f28238w.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public static w c() {
        if (f28232c == null) {
            synchronized (w.class) {
                if (f28232c == null) {
                    f28232c = new w();
                }
            }
        }
        return f28232c;
    }

    public com.bytedance.msdk.api.c.w w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.sr.get(str);
    }

    public double w(String str, com.bytedance.msdk.api.c.w wVar) {
        String key;
        List<ev> list;
        ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
        double d4 = -1.0d;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, List<ev>> entry : concurrentHashMap.entrySet()) {
                if (entry != null && (key = entry.getKey()) != null && (list = concurrentHashMap.get(key)) != null && list.size() > 0) {
                    for (ev evVar : list) {
                        if (evVar != null && c(evVar, evVar.xv(), wVar, "\u805a\u5408\u9884\u7f13\u5b58-ra") == -1 && evVar.f28224c.getCpm() > d4) {
                            d4 = evVar.f28224c.getCpm();
                        }
                    }
                }
            }
        }
        return d4;
    }

    public int sr() {
        return this.bk;
    }

    public int xv() {
        return this.f28233a;
    }

    public void c(String str, int i4) {
        this.f28238w.put(str, Integer.valueOf(i4));
    }

    public void c(String str, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xv.put(str, Long.valueOf(j4));
    }

    public Long c(String str) {
        return this.xv.get(str);
    }

    public void c(String str, com.bytedance.msdk.api.c.w wVar) {
        if (wVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.sr.put(str, wVar);
    }

    public void c(String str, String str2, long j4, com.bytedance.msdk.api.c cVar) {
        if (c(str) == null || c(str).longValue() == j4) {
            Map<String, com.bytedance.msdk.api.c> map = this.f28234f.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f28234f.put(str, map);
            }
            map.put(str2, cVar);
        }
    }

    public void w(final Context context, final String str, final int i4) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.w.w.2
            @Override // java.lang.Runnable
            public void run() {
                w.this.c(context, str, 4, i4, (xv) null);
            }
        });
    }

    public List<String> w() {
        return this.f28235k;
    }

    public void c(String str, ev evVar) {
        if (c(str) == null || c(str).longValue() == evVar.c()) {
            ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
            String adNetworkSlotId = evVar.f28224c.getAdNetworkSlotId();
            if (TextUtils.isEmpty(adNetworkSlotId)) {
                return;
            }
            if (concurrentHashMap == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(evVar);
                ConcurrentHashMap<String, List<ev>> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(adNetworkSlotId, copyOnWriteArrayList);
                this.ux.put(str, concurrentHashMap2);
                return;
            }
            List<ev> list = concurrentHashMap.get(adNetworkSlotId);
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                copyOnWriteArrayList2.add(evVar);
                concurrentHashMap.put(adNetworkSlotId, copyOnWriteArrayList2);
                return;
            }
            list.add(evVar);
        }
    }

    public boolean c(String str, com.bytedance.msdk.api.c.w wVar, String str2) {
        this.f28237r.put(str, Boolean.FALSE);
        com.bytedance.msdk.core.ux.w.xv xvVar = this.ev.get(str);
        boolean z3 = false;
        if (xvVar != null) {
            List<p> be = xvVar.be();
            if (com.bytedance.msdk.adapter.sr.xv.w()) {
                for (p pVar : be) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "waterfall: " + pVar.t() + ", loadSort: " + pVar.j() + ", showSort: " + pVar.ls() + ", eCpm: " + pVar.q());
                }
            }
            String c4 = c(be, str, wVar, xvVar);
            xv(str, wVar);
            ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
            if (concurrentHashMap != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= be.size()) {
                        break;
                    }
                    List<ev> list = concurrentHashMap.get(be.get(i4).ia());
                    if (list != null && list.size() > 0) {
                        z3 = true;
                        break;
                    }
                    i4++;
                }
            }
            if (c4 != null) {
                if (z3) {
                    com.bytedance.msdk.xv.r.c(this.sr.get(str), c4, str2);
                } else {
                    wVar.w(3);
                    com.bytedance.msdk.xv.r.c(wVar, c4, str2);
                }
            }
        }
        return z3;
    }

    private String c(List<p> list, String str, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.ux.w.xv xvVar) {
        List<ev> list2;
        if (list.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, List<ev>> concurrentHashMap = this.ux.get(str);
        if (concurrentHashMap != null && (list2 = concurrentHashMap.get(list.get(0).ia())) != null && list2.size() > 0 && list2.get(0) != null) {
            ev evVar = list2.get(0);
            if (c(evVar, evVar.xv(), wVar, "\u805a\u5408\u9884\u8bf7\u6c42") == -1) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "--==-- \u547d\u4e2d\u6700\u4f18\u5e7f\u544a\uff1a " + evVar.f28224c.getAdNetWorkName() + ", loadSort: " + evVar.f28224c.getLoadSort() + ", showSort: " + evVar.f28224c.getShowSort());
                return null;
            }
        }
        List<com.bytedance.msdk.core.ux.w.c> c4 = c(list, str, concurrentHashMap, wVar, xvVar);
        if (c4.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i4 = 0; i4 < c4.size(); i4++) {
                sb.append(c4.get(i4).c());
                if (i4 == c4.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                String jSONArray = new JSONArray(sb.toString()).toString();
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "adCannotUseInfo: " + jSONArray);
                return jSONArray;
            } catch (JSONException e4) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "adCannotUseInfo json err: " + e4.getMessage());
            }
        }
        return null;
    }

    private List<com.bytedance.msdk.core.ux.w.c> c(List<p> list, String str, Map<String, List<ev>> map, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.core.ux.w.xv xvVar) {
        com.bytedance.msdk.c.ux uxVar;
        List<ev> list2;
        ArrayList arrayList = new ArrayList();
        int f4 = xvVar instanceof sr ? ((sr) xvVar).f() : 0;
        for (int i4 = 0; i4 < list.size() && i4 < f4; i4++) {
            String ia = list.get(i4).ia();
            com.bytedance.msdk.core.ux.w.c cVar = new com.bytedance.msdk.core.ux.w.c();
            cVar.w(ia);
            cVar.ux(list.get(i4).ls());
            cVar.sr(list.get(i4).j());
            ev evVar = (map == null || (list2 = map.get(ia)) == null || list2.size() <= 0) ? null : list2.get(0);
            if (evVar != null && (uxVar = evVar.f28224c) != null) {
                cVar.c(uxVar.isHasShown() ? 1 : 0);
                int c4 = c(evVar, this.sr.get(str), wVar, "\u9884\u7f13\u5b58");
                if (c4 != -1) {
                    cVar.w(c4);
                    arrayList.add(cVar);
                }
            } else {
                Map<String, com.bytedance.msdk.api.c> map2 = this.f28234f.get(str);
                com.bytedance.msdk.api.c cVar2 = map2 != null ? map2.get(ia) : null;
                if (cVar2 != null) {
                    cVar.w(3);
                    cVar.xv(cVar2.xv);
                    cVar.c(cVar2.sr);
                } else {
                    cVar.w(4);
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void c(final Context context, final String str, final int i4) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.w.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.c(context, str, 2, i4, (xv) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, int i4, int i5, xv xvVar) {
        int w3 = w(str, i5);
        if (!xv(str, i5)) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "--==-- \u914d\u7f6e\u672a\u5f00\u542f\u9884\u52a0\u8f7d\u7f13\u5b58\uff0creq_type: " + w3);
            if (xvVar != null) {
                xvVar.c(str, false, 0, null);
                return;
            }
            return;
        }
        Boolean bool = this.f28237r.get(str);
        if (bool != null && bool.booleanValue()) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "--==-- \u5df2\u53d1\u8d77\u8fc7\u9884\u7f13\u5b58\uff0c\u8fd8\u672a\u4f7f\u7528\u6389\uff0c\u6b64\u6b21\u4e0d\u53d1\u8d77");
            if (xvVar != null) {
                xvVar.c(str, true, 0, null);
                return;
            }
            return;
        }
        com.bytedance.msdk.api.c.w wVar = new com.bytedance.msdk.api.c.w(this.sr.get(str));
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(str) + "--==-- \u9884\u7f13\u5b58\u5f00\u59cb\u8bf7\u6c42, req_type: " + w3);
        sr srVar = new sr(context, str, wVar.fz());
        this.ev.put(str, srVar);
        this.f28237r.put(str, Boolean.TRUE);
        wVar.w(i4);
        wVar.f(3);
        srVar.c(wVar, xvVar);
        r(str);
    }

    public void c(int i4) {
        this.f28236p = i4;
    }

    public void c(final Activity activity, final List<a> list, final int i4, final int i5) {
        com.bytedance.msdk.adapter.sr.f.c(new Runnable() { // from class: com.bytedance.msdk.core.ux.w.w.3
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.gd) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u6ce8\u610f\uff1a\u9884\u52a0\u8f7dpreload\u53ea\u80fd\u8c03\u7528\u4e00\u6b21");
                } else if (activity == null) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684activity\u4e0d\u80fd\u662fnull");
                } else {
                    List list2 = list;
                    if (list2 != null && list2.size() > 0) {
                        w.this.gd = true;
                        w.this.f28233a = i4;
                        w.this.bk = i5;
                        w.this.f28235k = new ArrayList();
                        for (a aVar : list) {
                            if (aVar != null && aVar.w() != null) {
                                w.this.f28235k.addAll(aVar.w());
                            }
                        }
                        int i6 = i4;
                        int i7 = (i6 < 1 || i6 > 20) ? 2 : i6;
                        int i8 = i5;
                        int i9 = (i8 < 1 || i8 > 10) ? 2 : i8;
                        List c4 = w.this.c(list);
                        if (c4.size() > 0) {
                            new c(activity, c4, i7, i9, new InterfaceC0422w() { // from class: com.bytedance.msdk.core.ux.w.w.3.1
                                @Override // com.bytedance.msdk.core.ux.w.w.InterfaceC0422w
                                public void c(boolean z3) {
                                    if (z3) {
                                        return;
                                    }
                                    com.bytedance.msdk.core.p.ux.sr().c(w.this.ux);
                                }
                            }).c();
                            return;
                        }
                        return;
                    }
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u9884\u52a0\u8f7dpreload\u4f20\u5165\u7684requestInfos\u4e0d\u80fd\u662fnull\u6216\u8005size\u4e3a0");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<a> c(List<a> list) {
        ArrayList arrayList = new ArrayList();
        int i4 = this.f28236p;
        HashSet hashSet = new HashSet();
        for (a aVar : list) {
            if (arrayList.size() >= i4) {
                break;
            } else if (aVar != null && aVar.w() != null) {
                for (String str : aVar.w()) {
                    if (arrayList.size() >= i4) {
                        break;
                    } else if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                        hashSet.add(str);
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(str);
                        arrayList.add(new a(aVar.c(), arrayList2));
                    }
                }
            }
        }
        return arrayList;
    }

    public void c(Context context, String str, int i4, com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.c.ux uxVar, xv xvVar) {
        ux uxVar2;
        if (i4 == 3) {
            uxVar2 = new f(context, str, wVar != null ? wVar.fz() : 0);
        } else if (i4 == 4) {
            uxVar2 = new r(context, str, wVar != null ? wVar.fz() : 0);
        } else {
            uxVar2 = null;
        }
        if (uxVar2 != null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==-- \u9884\u7f13\u5b58\u8865\u5145\u8bf7\u6c42\u53d1\u8d77 reqType: " + i4);
            uxVar2.c(wVar, uxVar, xvVar);
        }
    }
}

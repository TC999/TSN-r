package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: StaticDataPoll.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Long> f39405a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39406b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39407c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39408d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39409e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39410f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39411g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39412h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39413i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f39414j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> f39415k = null;

    /* renamed from: l  reason: collision with root package name */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f39416l = null;

    /* renamed from: m  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f39417m = null;

    /* renamed from: n  reason: collision with root package name */
    private static final String f39418n = "d";

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d4 = d(str2);
        if (campaignEx == null || d4 == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.d.a aVar = new com.mbridge.msdk.foundation.same.d.a(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (d4.containsKey(str)) {
                List<com.mbridge.msdk.foundation.same.d.a> list = d4.get(str);
                if (list != null && list.size() == 20) {
                    list.remove(0);
                }
                if (list != null) {
                    list.add(aVar);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            d4.put(str, arrayList);
        } catch (Throwable th) {
            x.b(f39418n, th.getMessage(), th);
        }
    }

    public static String b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        return (TextUtils.isEmpty(str) || (concurrentHashMap = f39416l) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f39416l.get(str)) == null || copyOnWriteArrayList.size() <= 0) ? "" : copyOnWriteArrayList.get(0);
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f39417m;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = f39417m.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e4) {
            x.a(f39418n, e4.getMessage());
        }
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f39415k) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f39415k.remove(str);
            return;
        }
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap2 = f39415k.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2)) {
            return;
        }
        concurrentHashMap2.remove(str2);
    }

    public static com.mbridge.msdk.foundation.entity.d b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        com.mbridge.msdk.foundation.entity.d dVar = new com.mbridge.msdk.foundation.entity.d();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return dVar;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f39417m;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f39417m.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                dVar.b(1);
                dVar.c(concurrentHashMap.get(str2));
            }
        } catch (Exception e4) {
            x.a(f39418n, e4.getMessage());
        }
        return dVar;
    }

    public static ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> c(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> concurrentHashMap = f39415k;
        if (concurrentHashMap == null) {
            f a4 = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
            if (a4 != null) {
                a4.e(str, "");
                f39415k = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f39415k.get(str);
        }
        return null;
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1611837702:
                if (str.equals("videofeeds")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1396342996:
                if (str.equals("banner")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals(AMPSConstants.AdType.AD_TYPE_NATIVE)) {
                    c4 = 2;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c4 = 3;
                    break;
                }
                break;
            case -895866265:
                if (str.equals("splash")) {
                    c4 = 4;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c4 = 5;
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return f39410f;
            case 1:
                return f39412h;
            case 2:
                return f39407c;
            case 3:
                return f39408d;
            case 4:
                return f39413i;
            case 5:
                return f39414j;
            case 6:
                return f39411g;
            case 7:
                return f39409e;
            default:
                return null;
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d4;
        List<com.mbridge.msdk.foundation.same.d.a> list;
        JSONArray jSONArray = new JSONArray();
        if (TextUtils.isEmpty(str2)) {
            d4 = null;
            if (f39407c.containsKey(str)) {
                d4 = f39407c;
            } else if (f39408d.containsKey(str)) {
                d4 = f39408d;
            } else if (f39409e.containsKey(str)) {
                d4 = f39409e;
            } else if (f39410f.containsKey(str)) {
                d4 = f39410f;
            } else if (f39411g.containsKey(str)) {
                d4 = f39411g;
            } else if (f39412h.containsKey(str)) {
                d4 = f39412h;
            } else if (f39413i.containsKey(str)) {
                d4 = f39413i;
            } else if (f39414j.containsKey(str)) {
                d4 = f39414j;
            }
        } else {
            d4 = d(str2);
        }
        if (d4 != null) {
            try {
                if (ag.b(str) && d4.containsKey(str) && (list = d4.get(str)) != null && list.size() > 0) {
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i4).a());
                        jSONObject.put("1", list.get(i4).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static void a(String str, String str2, int i4) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f39416l == null) {
            f39416l = new ConcurrentHashMap<>();
        }
        try {
            if (f39416l.containsKey(str)) {
                copyOnWriteArrayList = f39416l.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                f39416l.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            int size = copyOnWriteArrayList.size() - i4;
            if (size >= 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    copyOnWriteArrayList.remove(i5);
                }
            }
        } catch (Exception e4) {
            x.a(f39418n, e4.getMessage());
        }
    }

    public static void a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f39416l) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f39416l.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (f39417m == null) {
                f39417m = new ConcurrentHashMap<>();
            }
            if (f39417m.containsKey(str)) {
                if (f39417m.get(str) == null) {
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                    concurrentHashMap.put(str2, str3);
                    f39417m.put(str, concurrentHashMap);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(str2, str3);
            f39417m.put(str, concurrentHashMap2);
        } catch (Exception e4) {
            x.a(f39418n, e4.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, long j4, long j5, long j6) {
        if (f39415k == null) {
            f39415k = new ConcurrentHashMap<>();
        }
        try {
            if (f39415k.containsKey(str)) {
                ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap = f39415k.get(str);
                if (concurrentHashMap != null) {
                    com.mbridge.msdk.foundation.entity.c cVar = concurrentHashMap.get(str2);
                    if (cVar == null) {
                        com.mbridge.msdk.foundation.entity.c cVar2 = new com.mbridge.msdk.foundation.entity.c();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        cVar2.a(arrayList);
                        cVar2.a(j4);
                        cVar2.b(j5);
                        cVar2.c(j6);
                        concurrentHashMap.put(str2, cVar2);
                        return;
                    } else if (cVar.c() != null) {
                        cVar.a(j4);
                        cVar.b(j5);
                        cVar.c(j6);
                        cVar.c().add(str3);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap2 = new ConcurrentHashMap<>();
            com.mbridge.msdk.foundation.entity.c cVar3 = new com.mbridge.msdk.foundation.entity.c();
            cVar3.a(arrayList2);
            cVar3.a(j4);
            cVar3.b(j5);
            cVar3.c(j6);
            concurrentHashMap2.put(str2, cVar3);
            f39415k.put(str, concurrentHashMap2);
        } catch (Throwable th) {
            x.d(f39418n, th.getMessage());
        }
    }
}

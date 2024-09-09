package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpLimitUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f10359a = new ConcurrentHashMap<>(8);

    /* renamed from: b  reason: collision with root package name */
    public static volatile List<String> f10360b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f10361c = new ConcurrentHashMap<>(8);

    /* renamed from: d  reason: collision with root package name */
    private static Random f10362d = new Random();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f10363e = new ConcurrentHashMap<>(8);

    /* renamed from: f  reason: collision with root package name */
    private static List<g3> f10364f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpLimitUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f10365a;

        /* renamed from: b  reason: collision with root package name */
        int f10366b;

        /* renamed from: c  reason: collision with root package name */
        double f10367c;

        private a() {
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpLimitUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        b3 f10368a;

        /* renamed from: b  reason: collision with root package name */
        long f10369b;

        private b() {
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    public static synchronized String a(String str, String str2) throws bv {
        synchronized (w2.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = y0.f10481g;
                        if (f10360b == null) {
                            f10360b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !f10360b.contains(str2)) {
                            f10360b.add(str2);
                            String d4 = j2.d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(d4)) {
                                h(str2, new JSONObject(d4));
                            }
                        }
                        if (f10359a != null && f10359a.size() > 0) {
                            if (f10359a.containsKey(str2)) {
                                c cVar = f10359a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (!m(str, cVar, str2)) {
                                    return p(str, cVar, str2);
                                }
                                throw new bv("\u670d\u52a1QPS\u8d85\u9650");
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (bv e4) {
                    throw e4;
                } catch (Throwable th) {
                    d2.e(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b() {
        try {
            Context context = y0.f10481g;
            if (context == null) {
                return;
            }
            h3.e(q(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(i1 i1Var, JSONObject jSONObject) {
        synchronized (w2.class) {
            if (i1Var == null) {
                return;
            }
            try {
                String d4 = i1Var.d();
                if (TextUtils.isEmpty(d4)) {
                    return;
                }
                if (jSONObject == null) {
                    e(d4);
                }
                if (!y0.u(jSONObject.optString("able", null), false)) {
                    e(d4);
                    return;
                }
                j2.e(y0.f10481g, "Yb3Blbl9odHRwX2NvbnRyb2w", d4, jSONObject.toString());
                h(d4, jSONObject);
            } catch (Throwable th) {
                d2.e(th, "hlUtil", "par");
            }
        }
    }

    private static void d(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith(TTPathConst.sSeparator)) {
                            optString = TTPathConst.sSeparator.concat(optString);
                        }
                        if (optString.endsWith(TTPathConst.sSeparator)) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                            if (optJSONObject2 != null) {
                                a aVar = new a((byte) 0);
                                aVar.f10365a = optJSONObject2.optString("begin");
                                aVar.f10366b = optJSONObject2.optInt("duration");
                                aVar.f10367c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f10370a = hashMap;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void e(String str) {
        synchronized (w2.class) {
            try {
                if (f10359a.containsKey(str)) {
                    f10359a.remove(str);
                }
                SharedPreferences.Editor c4 = j2.c(y0.f10481g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                j2.g(c4, str);
                j2.f(c4);
            } catch (Throwable th) {
                d2.e(th, "hlUtil", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT);
            }
        }
    }

    private static void f(String str, c cVar) {
        try {
            if (f10359a == null) {
                f10359a = new ConcurrentHashMap<>(8);
            }
            f10359a.put(str, cVar);
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "ucr");
        }
    }

    private static void g(String str, String str2, String str3) {
        try {
            Context context = y0.f10481g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f10363e == null) {
                    f10363e = new ConcurrentHashMap<>(8);
                }
                synchronized (f10363e) {
                    if (f10363e.containsKey(str2)) {
                        return;
                    }
                    f10363e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                    jSONObject.put("type", s1.f10205l);
                    jSONObject.put("name", str);
                    jSONObject.put("version", s1.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    g3 g3Var = new g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                    g3Var.a(jSONObject2);
                    h3.d(g3Var, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            d(cVar, jSONObject);
            r(cVar, jSONObject);
            if (cVar.f10371b == null && cVar.f10370a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, b3 b3Var) {
        List<String> list;
        try {
            if (f10361c == null) {
                f10361c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = b3Var.f9644b;
            if (map != null && map.containsKey("nb") && (list = b3Var.f9644b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b((byte) 0);
                bVar.f10368a = b3Var;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f10369b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f10361c.put("app", bVar);
                } else if (parseInt != 2 || url == null) {
                } else {
                    f10361c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z3, String str) {
        try {
            Context context = y0.f10481g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                if (z3) {
                    jSONObject.put("type", s1.f10202i);
                } else {
                    jSONObject.put("type", s1.f10201h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", s1.a(str));
                String jSONObject2 = jSONObject.toString();
                g3 g3Var = new g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                g3Var.a(jSONObject2);
                h3.d(g3Var, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z3, String str, String str2, int i4) {
        try {
            Context context = y0.f10481g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                String a4 = s1.a(str);
                if (z3) {
                    jSONObject.put("type", s1.f10204k);
                } else {
                    jSONObject.put("type", s1.f10203j);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a4);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i4);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                g3 g3Var = new g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                g3Var.a(jSONObject2);
                if (f10364f == null) {
                    f10364f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f10364f) {
                    f10364f.add(g3Var);
                    if (f10364f.size() >= 15) {
                        b();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean l(a aVar) {
        if (aVar == null || aVar.f10367c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f10365a) && aVar.f10366b > 0) {
            long timeInMillis = currentTimeMillis - j1.h(aVar.f10365a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f10366b * 1000) {
                if (aVar.f10367c == 0.0d) {
                    return true;
                }
                if (f10362d == null) {
                    f10362d = new Random();
                }
                f10362d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f10362d.nextDouble() > aVar.f10367c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f10370a;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                for (Map.Entry<String, List<a>> entry : map.entrySet()) {
                    if (n(entry.getValue())) {
                        k(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && n(map.get(path))) {
                    k(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean n(List<a> list) {
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (l(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static b3 o(String str, String str2) {
        Uri parse;
        if (f10361c == null) {
            return null;
        }
        if (f10361c.containsKey("app")) {
            b bVar = f10361c.get("app");
            if (SystemClock.elapsedRealtime() <= bVar.f10369b) {
                b3 b3Var = bVar.f10368a;
                if (b3Var != null) {
                    b3Var.f9647e = false;
                }
                k(true, str2, str, 1);
                return b3Var;
            }
            f10361c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f10361c.containsKey(path)) {
                b bVar2 = f10361c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f10369b) {
                    b3 b3Var2 = bVar2.f10368a;
                    if (b3Var2 != null) {
                        b3Var2.f9647e = false;
                    }
                    k(true, str2, str, 2);
                    return b3Var2;
                }
                f10361c.remove(path);
            }
        }
        return null;
    }

    private static String p(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f10371b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    g(str2, authority, str3);
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    private static List<g3> q() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f10364f) {
                try {
                    List<g3> list = f10364f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f10364f);
                            f10364f.clear();
                            arrayList2 = arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    return arrayList2;
                } catch (Throwable th3) {
                    arrayList = arrayList2;
                    th = th3;
                }
            }
            try {
                throw th;
            } catch (Throwable unused) {
                return arrayList;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static void r(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            for (int i4 = 0; i4 < length; i4++) {
                String optString = names.optString(i4);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            cVar.f10371b = hashMap;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pdr");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpLimitUtil.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Map<String, List<a>> f10370a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f10371b;

        private c() {
            this.f10370a = new HashMap(8);
            this.f10371b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f10370a.equals(cVar.f10370a) && this.f10371b.equals(cVar.f10371b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f10370a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f10371b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }
}

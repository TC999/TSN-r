package com.amap.api.col.p047s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
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

/* compiled from: HttpLimitUtil.java */
/* renamed from: com.amap.api.col.s.w2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2193w2 {

    /* renamed from: a */
    public static volatile ConcurrentHashMap<String, C2196c> f6631a = new ConcurrentHashMap<>(8);

    /* renamed from: b */
    public static volatile List<String> f6632b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c */
    private static volatile ConcurrentHashMap<String, C2195b> f6633c = new ConcurrentHashMap<>(8);

    /* renamed from: d */
    private static Random f6634d = new Random();

    /* renamed from: e */
    private static ConcurrentHashMap<String, String> f6635e = new ConcurrentHashMap<>(8);

    /* renamed from: f */
    private static List<C2064g3> f6636f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.s.w2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2194a {

        /* renamed from: a */
        String f6637a;

        /* renamed from: b */
        int f6638b;

        /* renamed from: c */
        double f6639c;

        private C2194a() {
        }

        /* synthetic */ C2194a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.s.w2$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2195b {

        /* renamed from: a */
        C2021b3 f6640a;

        /* renamed from: b */
        long f6641b;

        private C2195b() {
        }

        /* synthetic */ C2195b(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static synchronized String m52360a(String str, String str2) throws C2022bv {
        synchronized (C2193w2.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = C2212y0.f6758g;
                        if (f6632b == null) {
                            f6632b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !f6632b.contains(str2)) {
                            f6632b.add(str2);
                            String m52847d = C2080j2.m52847d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(m52847d)) {
                                m52353h(str2, new JSONObject(m52847d));
                            }
                        }
                        if (f6631a != null && f6631a.size() > 0) {
                            if (f6631a.containsKey(str2)) {
                                C2196c c2196c = f6631a.get(str2);
                                if (c2196c == null) {
                                    return str;
                                }
                                if (!m52348m(str, c2196c, str2)) {
                                    return m52345p(str, c2196c, str2);
                                }
                                throw new C2022bv("服务QPS超限");
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (C2022bv e) {
                    throw e;
                } catch (Throwable th) {
                    C2041d2.m53085e(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static void m52359b() {
        try {
            Context context = C2212y0.f6758g;
            if (context == null) {
                return;
            }
            C2070h3.m52942e(m52344q(), context);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static synchronized void m52358c(C2073i1 c2073i1, JSONObject jSONObject) {
        synchronized (C2193w2.class) {
            if (c2073i1 == null) {
                return;
            }
            try {
                String m52918d = c2073i1.m52918d();
                if (TextUtils.isEmpty(m52918d)) {
                    return;
                }
                if (jSONObject == null) {
                    m52356e(m52918d);
                }
                if (!C2212y0.m52211u(jSONObject.optString("able", null), false)) {
                    m52356e(m52918d);
                    return;
                }
                C2080j2.m52846e(C2212y0.f6758g, "Yb3Blbl9odHRwX2NvbnRyb2w", m52918d, jSONObject.toString());
                m52353h(m52918d, jSONObject);
            } catch (Throwable th) {
                C2041d2.m53085e(th, "hlUtil", "par");
            }
        }
    }

    /* renamed from: d */
    private static void m52357d(C2196c c2196c, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith("/")) {
                            optString = "/".concat(optString);
                        }
                        if (optString.endsWith("/")) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                C2194a c2194a = new C2194a((byte) 0);
                                c2194a.f6637a = optJSONObject2.optString("begin");
                                c2194a.f6638b = optJSONObject2.optInt("duration");
                                c2194a.f6639c = optJSONObject2.optDouble("percent");
                                arrayList.add(c2194a);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            c2196c.f6642a = hashMap;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "hlUtil", "pbr");
        }
    }

    /* renamed from: e */
    private static synchronized void m52356e(String str) {
        synchronized (C2193w2.class) {
            try {
                if (f6631a.containsKey(str)) {
                    f6631a.remove(str);
                }
                SharedPreferences.Editor m52848c = C2080j2.m52848c(C2212y0.f6758g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                C2080j2.m52844g(m52848c, str);
                C2080j2.m52845f(m52848c);
            } catch (Throwable th) {
                C2041d2.m53085e(th, "hlUtil", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT);
            }
        }
    }

    /* renamed from: f */
    private static void m52355f(String str, C2196c c2196c) {
        try {
            if (f6631a == null) {
                f6631a = new ConcurrentHashMap<>(8);
            }
            f6631a.put(str, c2196c);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "hlUtil", "ucr");
        }
    }

    /* renamed from: g */
    private static void m52354g(String str, String str2, String str3) {
        try {
            Context context = C2212y0.f6758g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f6635e == null) {
                    f6635e = new ConcurrentHashMap<>(8);
                }
                synchronized (f6635e) {
                    if (f6635e.containsKey(str2)) {
                        return;
                    }
                    f6635e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                    jSONObject.put("type", C2139s1.f6477l);
                    jSONObject.put("name", str);
                    jSONObject.put(ConstantHelper.LOG_VS, C2139s1.m52470a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    C2064g3 c2064g3 = new C2064g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                    c2064g3.m52971a(jSONObject2);
                    C2070h3.m52943d(c2064g3, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    private static void m52353h(String str, JSONObject jSONObject) {
        try {
            C2196c c2196c = new C2196c((byte) 0);
            m52357d(c2196c, jSONObject);
            m52343r(c2196c, jSONObject);
            if (c2196c.f6643b == null && c2196c.f6642a == null) {
                m52356e(str);
            } else {
                m52355f(str, c2196c);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public static void m52352i(URL url, C2021b3 c2021b3) {
        List<String> list;
        try {
            if (f6633c == null) {
                f6633c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = c2021b3.f5894b;
            if (map != null && map.containsKey("nb") && (list = c2021b3.f5894b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                C2195b c2195b = new C2195b((byte) 0);
                c2195b.f6640a = c2021b3;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                c2195b.f6641b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f6633c.put(Constants.JumpUrlConstants.SRC_TYPE_APP, c2195b);
                } else if (parseInt != 2 || url == null) {
                } else {
                    f6633c.put(url.getPath(), c2195b);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    public static void m52351j(boolean z, String str) {
        try {
            Context context = C2212y0.f6758g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", C2139s1.f6474i);
                } else {
                    jSONObject.put("type", C2139s1.f6473h);
                }
                jSONObject.put("name", str);
                jSONObject.put(ConstantHelper.LOG_VS, C2139s1.m52470a(str));
                String jSONObject2 = jSONObject.toString();
                C2064g3 c2064g3 = new C2064g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                c2064g3.m52971a(jSONObject2);
                C2070h3.m52943d(c2064g3, context);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    private static void m52350k(boolean z, String str, String str2, int i) {
        try {
            Context context = C2212y0.f6758g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                String m52470a = C2139s1.m52470a(str);
                if (z) {
                    jSONObject.put("type", C2139s1.f6476k);
                } else {
                    jSONObject.put("type", C2139s1.f6475j);
                }
                jSONObject.put("name", str);
                jSONObject.put(ConstantHelper.LOG_VS, m52470a);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                C2064g3 c2064g3 = new C2064g3(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                c2064g3.m52971a(jSONObject2);
                if (f6636f == null) {
                    f6636f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f6636f) {
                    f6636f.add(c2064g3);
                    if (f6636f.size() >= 15) {
                        m52359b();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: l */
    private static boolean m52349l(C2194a c2194a) {
        if (c2194a == null || c2194a.f6639c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(c2194a.f6637a) && c2194a.f6638b > 0) {
            long timeInMillis = currentTimeMillis - C2079j1.m52869h(c2194a.f6637a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < c2194a.f6638b * 1000) {
                if (c2194a.f6639c == Utils.DOUBLE_EPSILON) {
                    return true;
                }
                if (f6634d == null) {
                    f6634d = new Random();
                }
                f6634d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f6634d.nextDouble() > c2194a.f6639c) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: m */
    private static boolean m52348m(String str, C2196c c2196c, String str2) {
        Map<String, List<C2194a>> map;
        try {
            map = c2196c.f6642a;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                for (Map.Entry<String, List<C2194a>> entry : map.entrySet()) {
                    if (m52347n(entry.getValue())) {
                        m52350k(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && m52347n(map.get(path))) {
                    m52350k(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m52347n(List<C2194a> list) {
        if (list != null && list.size() > 0) {
            for (C2194a c2194a : list) {
                if (m52349l(c2194a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: o */
    public static C2021b3 m52346o(String str, String str2) {
        Uri parse;
        if (f6633c == null) {
            return null;
        }
        if (f6633c.containsKey(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
            C2195b c2195b = f6633c.get(Constants.JumpUrlConstants.SRC_TYPE_APP);
            if (SystemClock.elapsedRealtime() <= c2195b.f6641b) {
                C2021b3 c2021b3 = c2195b.f6640a;
                if (c2021b3 != null) {
                    c2021b3.f5897e = false;
                }
                m52350k(true, str2, str, 1);
                return c2021b3;
            }
            f6633c.remove(Constants.JumpUrlConstants.SRC_TYPE_APP);
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f6633c.containsKey(path)) {
                C2195b c2195b2 = f6633c.get(path);
                if (SystemClock.elapsedRealtime() <= c2195b2.f6641b) {
                    C2021b3 c2021b32 = c2195b2.f6640a;
                    if (c2021b32 != null) {
                        c2021b32.f5897e = false;
                    }
                    m52350k(true, str2, str, 2);
                    return c2021b32;
                }
                f6633c.remove(path);
            }
        }
        return null;
    }

    /* renamed from: p */
    private static String m52345p(String str, C2196c c2196c, String str2) {
        try {
            Map<String, String> map = c2196c.f6643b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    m52354g(str2, authority, str3);
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    /* renamed from: q */
    private static List<C2064g3> m52344q() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f6636f) {
                try {
                    List<C2064g3> list = f6636f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f6636f);
                            f6636f.clear();
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

    /* renamed from: r */
    private static void m52343r(C2196c c2196c, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            for (int i = 0; i < length; i++) {
                String optString = names.optString(i);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            c2196c.f6643b = hashMap;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "hlUtil", "pdr");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.s.w2$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2196c {

        /* renamed from: a */
        Map<String, List<C2194a>> f6642a;

        /* renamed from: b */
        Map<String, String> f6643b;

        private C2196c() {
            this.f6642a = new HashMap(8);
            this.f6643b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C2196c.class == obj.getClass()) {
                C2196c c2196c = (C2196c) obj;
                if (this.f6642a.equals(c2196c.f6642a) && this.f6643b.equals(c2196c.f6643b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<C2194a>> map = this.f6642a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f6643b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ C2196c(byte b) {
            this();
        }
    }
}

package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.t6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HttpLimitUtil {

    /* renamed from: a */
    public static volatile ConcurrentHashMap<String, C1952c> f5390a = new ConcurrentHashMap<>(8);

    /* renamed from: b */
    public static volatile List<String> f5391b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c */
    private static volatile ConcurrentHashMap<String, C1951b> f5392c = new ConcurrentHashMap<>(8);

    /* renamed from: d */
    private static Random f5393d = new Random();

    /* renamed from: e */
    private static ConcurrentHashMap<String, String> f5394e = new ConcurrentHashMap<>(8);

    /* renamed from: f */
    private static List<StatisticsEntity> f5395f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.t6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1950a {

        /* renamed from: a */
        String f5396a;

        /* renamed from: b */
        int f5397b;

        /* renamed from: c */
        double f5398c;

        private C1950a() {
        }

        /* synthetic */ C1950a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.t6$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1951b {

        /* renamed from: a */
        ResponseEntity f5399a;

        /* renamed from: b */
        long f5400b;

        private C1951b() {
        }

        /* synthetic */ C1951b(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static synchronized String m53860a(String str, String str2) throws AMapCoreException {
        synchronized (HttpLimitUtil.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = AuthConfigManager.f4103g;
                        if (f5391b == null) {
                            f5391b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !f5391b.contains(str2)) {
                            f5391b.add(str2);
                            String m55231d = SPUtil.m55231d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(m55231d)) {
                                m53853h(str2, new JSONObject(m55231d));
                            }
                        }
                        if (f5390a != null && f5390a.size() > 0) {
                            if (f5390a.containsKey(str2)) {
                                C1952c c1952c = f5390a.get(str2);
                                if (c1952c == null) {
                                    return str;
                                }
                                if (!m53848m(str, c1952c, str2)) {
                                    return m53845p(str, c1952c, str2);
                                }
                                throw new AMapCoreException("服务QPS超限");
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (AMapCoreException e) {
                    throw e;
                } catch (Throwable th) {
                    BasicLogHandler.m54177e(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public static void m53859b() {
        try {
            Context context = AuthConfigManager.f4103g;
            if (context == null) {
                return;
            }
            StatisticsManager.m54910e(m53844q(), context);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static synchronized void m53858c(SDKInfo sDKInfo, JSONObject jSONObject) {
        synchronized (HttpLimitUtil.class) {
            if (sDKInfo == null) {
                return;
            }
            try {
                String m54400a = sDKInfo.m54400a();
                if (TextUtils.isEmpty(m54400a)) {
                    return;
                }
                if (jSONObject == null) {
                    m53856e(m54400a);
                }
                if (!AuthConfigManager.m55040x(jSONObject.optString("able", null), false)) {
                    m53856e(m54400a);
                    return;
                }
                SPUtil.m55230e(AuthConfigManager.f4103g, "Yb3Blbl9odHRwX2NvbnRyb2w", m54400a, jSONObject.toString());
                m53853h(m54400a, jSONObject);
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "hlUtil", "par");
            }
        }
    }

    /* renamed from: d */
    private static void m53857d(C1952c c1952c, JSONObject jSONObject) {
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
                                C1950a c1950a = new C1950a((byte) 0);
                                c1950a.f5396a = optJSONObject2.optString("begin");
                                c1950a.f5397b = optJSONObject2.optInt("duration");
                                c1950a.f5398c = optJSONObject2.optDouble("percent");
                                arrayList.add(c1950a);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            c1952c.f5401a = hashMap;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "hlUtil", "pbr");
        }
    }

    /* renamed from: e */
    private static synchronized void m53856e(String str) {
        synchronized (HttpLimitUtil.class) {
            try {
                if (f5390a.containsKey(str)) {
                    f5390a.remove(str);
                }
                SharedPreferences.Editor m55232c = SPUtil.m55232c(AuthConfigManager.f4103g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                SPUtil.m55228g(m55232c, str);
                SPUtil.m55229f(m55232c);
            } catch (Throwable th) {
                BasicLogHandler.m54177e(th, "hlUtil", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT);
            }
        }
    }

    /* renamed from: f */
    private static void m53855f(String str, C1952c c1952c) {
        try {
            if (f5390a == null) {
                f5390a = new ConcurrentHashMap<>(8);
            }
            f5390a.put(str, c1952c);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "hlUtil", "ucr");
        }
    }

    /* renamed from: g */
    private static void m53854g(String str, String str2, String str3) {
        try {
            Context context = AuthConfigManager.f4103g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f5394e == null) {
                    f5394e = new ConcurrentHashMap<>(8);
                }
                synchronized (f5394e) {
                    if (f5394e.containsKey(str2)) {
                        return;
                    }
                    f5394e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                    jSONObject.put("type", ConstConfig.f3928l);
                    jSONObject.put("name", str);
                    jSONObject.put(ConstantHelper.LOG_VS, ConstConfig.m55237a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    StatisticsEntity statisticsEntity = new StatisticsEntity(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                    statisticsEntity.m55025a(jSONObject2);
                    StatisticsManager.m54911d(statisticsEntity, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    private static void m53853h(String str, JSONObject jSONObject) {
        try {
            C1952c c1952c = new C1952c((byte) 0);
            m53857d(c1952c, jSONObject);
            m53843r(c1952c, jSONObject);
            if (c1952c.f5402b == null && c1952c.f5401a == null) {
                m53856e(str);
            } else {
                m53855f(str, c1952c);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: i */
    public static void m53852i(URL url, ResponseEntity responseEntity) {
        List<String> list;
        try {
            if (f5392c == null) {
                f5392c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = responseEntity.f5683b;
            if (map != null && map.containsKey("nb") && (list = responseEntity.f5683b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                C1951b c1951b = new C1951b((byte) 0);
                c1951b.f5399a = responseEntity;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                c1951b.f5400b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f5392c.put(Constants.JumpUrlConstants.SRC_TYPE_APP, c1951b);
                } else if (parseInt != 2 || url == null) {
                } else {
                    f5392c.put(url.getPath(), c1951b);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: j */
    public static void m53851j(boolean z, String str) {
        try {
            Context context = AuthConfigManager.f4103g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", ConstConfig.f3925i);
                } else {
                    jSONObject.put("type", ConstConfig.f3924h);
                }
                jSONObject.put("name", str);
                jSONObject.put(ConstantHelper.LOG_VS, ConstConfig.m55237a(str));
                String jSONObject2 = jSONObject.toString();
                StatisticsEntity statisticsEntity = new StatisticsEntity(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                statisticsEntity.m55025a(jSONObject2);
                StatisticsManager.m54911d(statisticsEntity, context);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: k */
    private static void m53850k(boolean z, String str, String str2, int i) {
        try {
            Context context = AuthConfigManager.f4103g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                String m55237a = ConstConfig.m55237a(str);
                if (z) {
                    jSONObject.put("type", ConstConfig.f3927k);
                } else {
                    jSONObject.put("type", ConstConfig.f3926j);
                }
                jSONObject.put("name", str);
                jSONObject.put(ConstantHelper.LOG_VS, m55237a);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                StatisticsEntity statisticsEntity = new StatisticsEntity(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                statisticsEntity.m55025a(jSONObject2);
                if (f5395f == null) {
                    f5395f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f5395f) {
                    f5395f.add(statisticsEntity);
                    if (f5395f.size() >= 15) {
                        m53859b();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: l */
    private static boolean m53849l(C1950a c1950a) {
        if (c1950a == null || c1950a.f5398c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(c1950a.f5396a) && c1950a.f5397b > 0) {
            long timeInMillis = currentTimeMillis - C1925p4.m54196h(c1950a.f5396a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < c1950a.f5397b * 1000) {
                if (c1950a.f5398c == Utils.DOUBLE_EPSILON) {
                    return true;
                }
                if (f5393d == null) {
                    f5393d = new Random();
                }
                f5393d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f5393d.nextDouble() > c1950a.f5398c) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: m */
    private static boolean m53848m(String str, C1952c c1952c, String str2) {
        Map<String, List<C1950a>> map;
        try {
            map = c1952c.f5401a;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                for (Map.Entry<String, List<C1950a>> entry : map.entrySet()) {
                    if (m53847n(entry.getValue())) {
                        m53850k(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && m53847n(map.get(path))) {
                    m53850k(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: n */
    private static boolean m53847n(List<C1950a> list) {
        if (list != null && list.size() > 0) {
            for (C1950a c1950a : list) {
                if (m53849l(c1950a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: o */
    public static ResponseEntity m53846o(String str, String str2) {
        Uri parse;
        if (f5392c == null) {
            return null;
        }
        if (f5392c.containsKey(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
            C1951b c1951b = f5392c.get(Constants.JumpUrlConstants.SRC_TYPE_APP);
            if (SystemClock.elapsedRealtime() <= c1951b.f5400b) {
                ResponseEntity responseEntity = c1951b.f5399a;
                if (responseEntity != null) {
                    responseEntity.f5686e = false;
                }
                m53850k(true, str2, str, 1);
                return responseEntity;
            }
            f5392c.remove(Constants.JumpUrlConstants.SRC_TYPE_APP);
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f5392c.containsKey(path)) {
                C1951b c1951b2 = f5392c.get(path);
                if (SystemClock.elapsedRealtime() <= c1951b2.f5400b) {
                    ResponseEntity responseEntity2 = c1951b2.f5399a;
                    if (responseEntity2 != null) {
                        responseEntity2.f5686e = false;
                    }
                    m53850k(true, str2, str, 2);
                    return responseEntity2;
                }
                f5392c.remove(path);
            }
        }
        return null;
    }

    /* renamed from: p */
    private static String m53845p(String str, C1952c c1952c, String str2) {
        try {
            Map<String, String> map = c1952c.f5402b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    m53854g(str2, authority, str3);
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    /* renamed from: q */
    public static List<StatisticsEntity> m53844q() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f5395f) {
                try {
                    List<StatisticsEntity> list = f5395f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f5395f);
                            f5395f.clear();
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
    private static void m53843r(C1952c c1952c, JSONObject jSONObject) {
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
            c1952c.f5402b = hashMap;
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "hlUtil", "pdr");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.t6$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1952c {

        /* renamed from: a */
        Map<String, List<C1950a>> f5401a;

        /* renamed from: b */
        Map<String, String> f5402b;

        private C1952c() {
            this.f5401a = new HashMap(8);
            this.f5402b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C1952c.class == obj.getClass()) {
                C1952c c1952c = (C1952c) obj;
                if (this.f5401a.equals(c1952c.f5401a) && this.f5402b.equals(c1952c.f5402b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<C1950a>> map = this.f5401a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f5402b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ C1952c(byte b) {
            this();
        }
    }
}

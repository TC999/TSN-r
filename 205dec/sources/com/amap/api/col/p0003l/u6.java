package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HttpLimitUtil.java */
/* renamed from: com.amap.api.col.3l.u6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u6 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f9166a = new ConcurrentHashMap<>(8);

    /* renamed from: b  reason: collision with root package name */
    public static volatile List<String> f9167b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f9168c = new ConcurrentHashMap<>(8);

    /* renamed from: d  reason: collision with root package name */
    private static Random f9169d = new Random();

    /* renamed from: e  reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f9170e = new ConcurrentHashMap<>(8);

    /* renamed from: f  reason: collision with root package name */
    private static List<g7> f9171f = Collections.synchronizedList(new ArrayList(16));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f9172a;

        /* renamed from: b  reason: collision with root package name */
        int f9173b;

        /* renamed from: c  reason: collision with root package name */
        double f9174c;

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
    /* renamed from: com.amap.api.col.3l.u6$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        y6 f9175a;

        /* renamed from: b  reason: collision with root package name */
        long f9176b;

        private b() {
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$e */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class e implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        private String f9181a;

        /* renamed from: b  reason: collision with root package name */
        private String f9182b;

        private e() {
        }

        public final String a() {
            return this.f9182b;
        }

        public final void b(String str) {
            String[] split;
            if (!TextUtils.isEmpty(this.f9181a) && str.contains(":") && (split = str.split(":")) != null && split.length > 0) {
                this.f9181a = split[0];
            } else {
                this.f9181a = str;
            }
        }

        public final void c(String str) {
            this.f9182b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (!TextUtils.isEmpty(this.f9181a)) {
                return this.f9181a.equals(str);
            }
            if (!TextUtils.isEmpty(this.f9182b)) {
                return defaultHostnameVerifier.verify(this.f9182b, sSLSession);
            }
            return defaultHostnameVerifier.verify(str, sSLSession);
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$f */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class f {

        /* renamed from: a  reason: collision with root package name */
        long f9183a = 0;

        /* renamed from: b  reason: collision with root package name */
        long f9184b = 0;

        /* renamed from: c  reason: collision with root package name */
        c f9185c = new c();

        /* renamed from: d  reason: collision with root package name */
        a f9186d;

        /* renamed from: e  reason: collision with root package name */
        c f9187e;

        /* renamed from: f  reason: collision with root package name */
        String f9188f;

        /* renamed from: g  reason: collision with root package name */
        URL f9189g;

        f() {
        }

        public final void a() {
            this.f9185c.h = SystemClock.elapsedRealtime() - this.f9184b;
        }

        public final void b(int i4) {
            "----errorcode-----".concat(String.valueOf(i4));
            u6.s();
            try {
                this.f9185c.f = SystemClock.elapsedRealtime() - this.f9183a;
                c cVar = this.f9185c;
                cVar.m = i4;
                if (cVar.b.e()) {
                    f4.u(false, this.f9185c.e);
                }
                boolean o4 = u6.o(u6.this, this.f9185c.e);
                if (o4) {
                    if (u6.u(u6.this) && !TextUtils.isEmpty(u6.d(u6.this)) && this.f9185c.b.b()) {
                        f4.L();
                    }
                    if (this.f9185c.b.c()) {
                        f4.u(this.f9185c.b.c(), this.f9185c.e);
                    }
                    f4.J(this.f9187e);
                    f4.t(false, this.f9186d);
                    f4.E(this.f9185c);
                }
                f4.s(this.f9189g.toString(), this.f9185c.b.c(), true, o4);
                this.f9185c.toString();
                u6.s();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j4) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.f9185c.l = decimalFormat.format(((float) j4) / 1024.0f);
        }

        public final void d(Cif cif, URL url) {
            this.f9189g = url;
            this.f9185c.d = url.getPath();
            this.f9185c.e = url.getHost();
            if (!TextUtils.isEmpty(u6.d(u6.this)) && cif.getDegradeType().b()) {
                c cVar = this.f9185c;
                cVar.c = cVar.e.replace("[", "").replace("]", "");
                this.f9185c.e = u6.d(u6.this);
            }
            if (cif.getDegradeType().b()) {
                cif.setNon_degrade_final_Host(this.f9185c.e);
            }
            if (cif.getDegradeType().d()) {
                this.f9188f = cif.getNon_degrade_final_Host();
            }
        }

        public final void e(x6 x6Var) {
            c a4;
            try {
                this.f9185c.f = SystemClock.elapsedRealtime() - this.f9183a;
                if (x6Var != null) {
                    x6Var.f = this.f9185c.b.c();
                }
                if (this.f9185c.b.b()) {
                    c cVar = this.f9185c;
                    if (cVar.f > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        f4.u(false, cVar.e);
                    }
                }
                if (this.f9185c.b.d()) {
                    f4.u(false, this.f9188f);
                }
                boolean o4 = u6.o(u6.this, this.f9185c.e);
                if (o4) {
                    f4.J(this.f9185c);
                    f4.t(true, this.f9186d);
                    c cVar2 = this.f9185c;
                    if (cVar2.f > f4.s && (a4 = cVar2.a()) != null) {
                        a4.m = 1;
                        f4.E(a4);
                        a4.toString();
                        u6.s();
                    }
                }
                f4.s(this.f9189g.toString(), this.f9185c.b.c(), false, o4);
                this.f9185c.toString();
                u6.s();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.f9185c.i = SystemClock.elapsedRealtime() - this.f9184b;
        }

        public final void g(int i4) {
            this.f9185c.n = i4;
        }

        public final void h() {
            this.f9185c.j = SystemClock.elapsedRealtime() - this.f9184b;
        }

        public final void i() {
            c a4 = this.f9185c.a();
            if (this.f9185c.f > f4.s) {
                a4.m = 1;
            }
            f4.o(a4);
        }
    }

    public static synchronized String a(String str, String str2) throws fk {
        synchronized (u6.class) {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = g4.f7815g;
                        if (f9167b == null) {
                            f9167b = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !f9167b.contains(str2)) {
                            f9167b.add(str2);
                            String d4 = f6.d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(d4)) {
                                h(str2, new JSONObject(d4));
                            }
                        }
                        if (f9166a != null && f9166a.size() > 0) {
                            if (f9166a.containsKey(str2)) {
                                c cVar = f9166a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (!m(str, cVar, str2)) {
                                    return p(str, cVar, str2);
                                }
                                throw new fk("\u670d\u52a1QPS\u8d85\u9650");
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                } catch (fk e4) {
                    throw e4;
                } catch (Throwable th) {
                    q5.e(th, "hlUtil", "pcr");
                    return str;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b() {
        try {
            Context context = g4.f7815g;
            if (context == null) {
                return;
            }
            h7.e(q(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(p4 p4Var, JSONObject jSONObject) {
        synchronized (u6.class) {
            if (p4Var == null) {
                return;
            }
            try {
                String a4 = p4Var.a();
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                if (jSONObject == null) {
                    e(a4);
                }
                if (!g4.x(jSONObject.optString("able", null), false)) {
                    e(a4);
                    return;
                }
                f6.e(g4.f7815g, "Yb3Blbl9odHRwX2NvbnRyb2w", a4, jSONObject.toString());
                h(a4, jSONObject);
            } catch (Throwable th) {
                q5.e(th, "hlUtil", "par");
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
                                aVar.f9172a = optJSONObject2.optString("begin");
                                aVar.f9173b = optJSONObject2.optInt("duration");
                                aVar.f9174c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f9177a = hashMap;
        } catch (Throwable th) {
            q5.e(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void e(String str) {
        synchronized (u6.class) {
            try {
                if (f9166a.containsKey(str)) {
                    f9166a.remove(str);
                }
                SharedPreferences.Editor c4 = f6.c(g4.f7815g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                f6.g(c4, str);
                f6.f(c4);
            } catch (Throwable th) {
                q5.e(th, "hlUtil", DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT);
            }
        }
    }

    private static void f(String str, c cVar) {
        try {
            if (f9166a == null) {
                f9166a = new ConcurrentHashMap<>(8);
            }
            f9166a.put(str, cVar);
        } catch (Throwable th) {
            q5.e(th, "hlUtil", "ucr");
        }
    }

    private static void g(String str, String str2, String str3) {
        try {
            Context context = g4.f7815g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f9170e == null) {
                    f9170e = new ConcurrentHashMap<>(8);
                }
                synchronized (f9170e) {
                    if (f9170e.containsKey(str2)) {
                        return;
                    }
                    f9170e.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                    jSONObject.put("type", f5.f7717l);
                    jSONObject.put("name", str);
                    jSONObject.put("version", f5.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String jSONObject2 = jSONObject.toString();
                    if (TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    g7 g7Var = new g7(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                    g7Var.a(jSONObject2);
                    h7.d(g7Var, context);
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
            if (cVar.f9178b == null && cVar.f9177a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, y6 y6Var) {
        List<String> list;
        try {
            if (f9168c == null) {
                f9168c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = y6Var.f9525b;
            if (map != null && map.containsKey("nb") && (list = y6Var.f9525b.get("nb")) != null && list.size() > 0) {
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b((byte) 0);
                bVar.f9175a = y6Var;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f9176b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f9168c.put("app", bVar);
                } else if (parseInt != 2 || url == null) {
                } else {
                    f9168c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z3, String str) {
        try {
            Context context = g4.f7815g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                if (z3) {
                    jSONObject.put("type", f5.f7714i);
                } else {
                    jSONObject.put("type", f5.f7713h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", f5.a(str));
                String jSONObject2 = jSONObject.toString();
                g7 g7Var = new g7(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                g7Var.a(jSONObject2);
                h7.d(g7Var, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z3, String str, String str2, int i4) {
        try {
            Context context = g4.f7815g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                String a4 = f5.a(str);
                if (z3) {
                    jSONObject.put("type", f5.f7716k);
                } else {
                    jSONObject.put("type", f5.f7715j);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a4);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i4);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                g7 g7Var = new g7(context, "core", MBridgeConstans.NATIVE_VIDEO_VERSION, "O005");
                g7Var.a(jSONObject2);
                if (f9171f == null) {
                    f9171f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f9171f) {
                    f9171f.add(g7Var);
                    if (f9171f.size() >= 15) {
                        b();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean l(a aVar) {
        if (aVar == null || aVar.f9174c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f9172a) && aVar.f9173b > 0) {
            long timeInMillis = currentTimeMillis - q4.h(aVar.f9172a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f9173b * 1000) {
                if (aVar.f9174c == 0.0d) {
                    return true;
                }
                if (f9169d == null) {
                    f9169d = new Random();
                }
                f9169d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f9169d.nextDouble() > aVar.f9174c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f9177a;
        } catch (Throwable th) {
            q5.e(th, "hlUtil", "inb");
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

    public static y6 o(String str, String str2) {
        Uri parse;
        if (f9168c == null) {
            return null;
        }
        if (f9168c.containsKey("app")) {
            b bVar = f9168c.get("app");
            if (SystemClock.elapsedRealtime() <= bVar.f9176b) {
                y6 y6Var = bVar.f9175a;
                if (y6Var != null) {
                    y6Var.f9528e = false;
                }
                k(true, str2, str, 1);
                return y6Var;
            }
            f9168c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f9168c.containsKey(path)) {
                b bVar2 = f9168c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f9176b) {
                    y6 y6Var2 = bVar2.f9175a;
                    if (y6Var2 != null) {
                        y6Var2.f9528e = false;
                    }
                    k(true, str2, str, 2);
                    return y6Var2;
                }
                f9168c.remove(path);
            }
        }
        return null;
    }

    private static String p(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f9178b;
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
            q5.e(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0028 -> B:16:0x0024). Please submit an issue!!! */
    public static List<g7> q() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (f9171f) {
                try {
                    List<g7> list = f9171f;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        try {
                            arrayList.addAll(f9171f);
                            f9171f.clear();
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
            cVar.f9178b = hashMap;
        } catch (Throwable th) {
            q5.e(th, "hlUtil", "pdr");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HttpLimitUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Map<String, List<a>> f9177a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f9178b;

        private c() {
            this.f9177a = new HashMap(8);
            this.f9178b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f9177a.equals(cVar.f9177a) && this.f9178b.equals(cVar.f9178b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f9177a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f9178b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }

    /* compiled from: HttpUrlUtil.java */
    /* renamed from: com.amap.api.col.3l.u6$d */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private Vector<e> f9179a;

        /* renamed from: b  reason: collision with root package name */
        private volatile e f9180b;

        private d() {
            this.f9179a = new Vector<>();
            this.f9180b = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f9180b;
            }
            for (int i4 = 0; i4 < this.f9179a.size(); i4++) {
                e eVar = this.f9179a.get(i4);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e((byte) 0);
            eVar2.c(str);
            this.f9179a.add(eVar2);
            return eVar2;
        }

        /* synthetic */ d(byte b4) {
            this();
        }
    }
}

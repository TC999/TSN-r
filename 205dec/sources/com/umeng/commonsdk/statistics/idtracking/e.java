package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IdTracker.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f53621a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    public static e f53622b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f53623c = au.b().b("id");

    /* renamed from: j  reason: collision with root package name */
    private static Object f53624j = new Object();

    /* renamed from: d  reason: collision with root package name */
    private File f53625d;

    /* renamed from: f  reason: collision with root package name */
    private long f53627f;

    /* renamed from: i  reason: collision with root package name */
    private a f53630i;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f53626e = null;

    /* renamed from: h  reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f53629h = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private long f53628g = 86400000;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracker.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f53631a;

        /* renamed from: b  reason: collision with root package name */
        private Set<String> f53632b = new HashSet();

        public a(Context context) {
            this.f53631a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f53632b.contains(str);
        }

        public synchronized void b(String str) {
            this.f53632b.add(str);
        }

        public void c(String str) {
            this.f53632b.remove(str);
        }

        public synchronized void a() {
            if (!this.f53632b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f53632b) {
                    sb.append(str);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f53631a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f53631a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f53632b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.f53630i = null;
        this.f53625d = new File(context.getFilesDir(), f53623c);
        a aVar = new a(context);
        this.f53630i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (e.class) {
            e eVar = f53622b;
            if (eVar != null) {
                eVar.e();
                f53622b = null;
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f53629h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.f53626e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f53624j) {
            if (this.f53625d.exists()) {
                try {
                    fileInputStream = new FileInputStream(this.f53625d);
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new bu().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Throwable th3) {
                        th = th3;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    return null;
                }
            }
            return null;
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f53627f >= this.f53628g) {
            boolean z3 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f53629h) {
                if (aVar.c() && aVar.a()) {
                    z3 = true;
                    if (!aVar.c()) {
                        this.f53630i.b(aVar.b());
                    }
                }
            }
            if (z3) {
                h();
                this.f53630i.a();
                g();
            }
            this.f53627f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f53626e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f53622b == null) {
            return;
        }
        boolean z3 = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f53629h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z3 = true;
            }
        }
        if (z3) {
            this.f53626e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i4 = i();
        if (i4 == null) {
            return;
        }
        a(i4);
        ArrayList<com.umeng.commonsdk.statistics.idtracking.a> arrayList = new ArrayList(this.f53629h.size());
        synchronized (this) {
            this.f53626e = i4;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f53629h) {
                aVar.a(this.f53626e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            for (com.umeng.commonsdk.statistics.idtracking.a aVar2 : arrayList) {
                this.f53629h.remove(aVar2);
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f53626e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f53622b == null) {
                e eVar2 = new e(context);
                f53622b = eVar2;
                eVar2.a(new f(context));
                f53622b.a(new b(context));
                f53622b.a(new j(context));
                f53622b.a(new d(context));
                f53622b.a(new c(context));
                f53622b.a(new g(context));
                f53622b.a(new i());
                if (FieldManager.allow("header_device_oaid")) {
                    f53622b.a(new h(context));
                }
                f53622b.f();
            }
            eVar = f53622b;
        }
        return eVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a4;
        synchronized (f53624j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a4 = new ca().a(cVar);
                    }
                    if (a4 != null) {
                        HelperUtils.writeFile(this.f53625d, a4);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f53630i.a(aVar.b())) {
            return this.f53629h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.w("invalid domain: " + aVar.b());
            return false;
        }
        return false;
    }

    public void a(long j4) {
        this.f53628g = j4;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f53717a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow("header_device_id_mac")) {
            cVar.f53717a.remove("mac");
        }
        if (cVar.f53717a.containsKey("imei") && !FieldManager.allow("header_device_id_imei")) {
            cVar.f53717a.remove("imei");
        }
        if (cVar.f53717a.containsKey("android_id") && !FieldManager.allow("header_device_id_android_id")) {
            cVar.f53717a.remove("android_id");
        }
        if (cVar.f53717a.containsKey("serial") && !FieldManager.allow("header_device_id_serialNo")) {
            cVar.f53717a.remove("serial");
        }
        if (cVar.f53717a.containsKey(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY) && !FieldManager.allow("header_tracking_idfa")) {
            cVar.f53717a.remove(AdRequestConstant.AD_REQUEST_DEVICE_EXT_IDFA_KEY);
        }
        if (!cVar.f53717a.containsKey(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY) || FieldManager.allow("header_device_oaid")) {
            return;
        }
        cVar.f53717a.remove(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
    }
}

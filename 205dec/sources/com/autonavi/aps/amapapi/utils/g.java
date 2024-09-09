package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.n9;
import com.amap.api.location.AMapLocation;
import com.stub.StubApp;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ReportRecorder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {

    /* renamed from: f  reason: collision with root package name */
    private static g f12027f;

    /* renamed from: i  reason: collision with root package name */
    private static long f12028i;

    /* renamed from: d  reason: collision with root package name */
    private File f12032d;

    /* renamed from: e  reason: collision with root package name */
    private String f12033e;

    /* renamed from: g  reason: collision with root package name */
    private Context f12034g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12035h;

    /* renamed from: c  reason: collision with root package name */
    private LinkedHashMap<String, Long> f12031c = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    String f12029a = "";

    /* renamed from: b  reason: collision with root package name */
    String f12030b = null;

    private g(Context context) {
        this.f12033e = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f12034g = origApplicationContext;
        String path = origApplicationContext.getFilesDir().getPath();
        if (this.f12033e == null) {
            this.f12033e = j.l(this.f12034g);
        }
        try {
            this.f12032d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            n9.a(th);
        }
        c();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (f12027f == null) {
                f12027f = new g(context);
            }
            gVar = f12027f;
        }
        return gVar;
    }

    private synchronized void c() {
        LinkedHashMap<String, Long> linkedHashMap = this.f12031c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            this.f12029a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            for (String str : j.a(this.f12032d)) {
                try {
                    String[] split = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(str), this.f12033e), "UTF-8").split(",");
                    if (split != null && split.length > 1) {
                        this.f12031c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                    }
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.f12031c.entrySet()) {
                try {
                    String str = entry.getKey() + "," + entry.getValue();
                    sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a(str.getBytes("UTF-8"), this.f12033e)) + "\n");
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            j.a(this.f12032d, sb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            if (b(this.f12034g)) {
                for (Map.Entry<String, Long> entry : this.f12031c.entrySet()) {
                    if (!this.f12029a.equals(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("param_long_first", entry.getKey());
                        jSONObject.put("param_long_second", entry.getValue());
                        h.a(this.f12034g, "O023", jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a() {
        if (this.f12035h) {
            d();
            this.f12035h = false;
        }
    }

    public final synchronized void a(AMapLocation aMapLocation) {
        try {
            if ((!this.f12031c.containsKey(this.f12029a) && this.f12031c.size() >= 8) || (this.f12031c.containsKey(this.f12029a) && this.f12031c.size() >= 9)) {
                ArrayList<String> arrayList = new ArrayList();
                for (Map.Entry<String, Long> entry : this.f12031c.entrySet()) {
                    arrayList.add(entry.getKey());
                    if (arrayList.size() == this.f12031c.size() - 7) {
                        break;
                    }
                }
                for (String str : arrayList) {
                    this.f12031c.remove(str);
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.f12031c.containsKey(this.f12029a)) {
                    long longValue = this.f12031c.get(this.f12029a).longValue() + 1;
                    f12028i = longValue;
                    this.f12031c.put(this.f12029a, Long.valueOf(longValue));
                } else {
                    this.f12031c.put(this.f12029a, 1L);
                    f12028i = 1L;
                }
                long j4 = f12028i;
                if (j4 != 0 && j4 % 100 == 0) {
                    a();
                }
                this.f12035h = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(Context context) {
        if (this.f12030b == null) {
            this.f12030b = i.a(context, "pref", "lastavedate", "0");
        }
        if (this.f12030b.equals(this.f12029a)) {
            return false;
        }
        SharedPreferences.Editor a4 = i.a(context, "pref");
        i.a(a4, "lastavedate", this.f12029a);
        i.a(a4);
        this.f12030b = this.f12029a;
        return true;
    }
}

package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0463l.ALLog;
import com.amap.api.col.p0463l.Encrypt;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.C2422a;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.utils.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ReportRecorder {

    /* renamed from: f */
    private static ReportRecorder f8389f;

    /* renamed from: i */
    private static long f8390i;

    /* renamed from: d */
    private File f8394d;

    /* renamed from: e */
    private String f8395e;

    /* renamed from: g */
    private Context f8396g;

    /* renamed from: h */
    private boolean f8397h;

    /* renamed from: c */
    private LinkedHashMap<String, Long> f8393c = new LinkedHashMap<>();

    /* renamed from: a */
    String f8391a = "";

    /* renamed from: b */
    String f8392b = null;

    private ReportRecorder(Context context) {
        this.f8395e = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8396g = origApplicationContext;
        String path = origApplicationContext.getFilesDir().getPath();
        if (this.f8395e == null) {
            this.f8395e = C2432j.m51155l(this.f8396g);
        }
        try {
            this.f8394d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            ALLog.m54456a(th);
        }
        m51251c();
    }

    /* renamed from: a */
    public static synchronized ReportRecorder m51255a(Context context) {
        ReportRecorder reportRecorder;
        synchronized (ReportRecorder.class) {
            if (f8389f == null) {
                f8389f = new ReportRecorder(context);
            }
            reportRecorder = f8389f;
        }
        return reportRecorder;
    }

    /* renamed from: c */
    private synchronized void m51251c() {
        LinkedHashMap<String, Long> linkedHashMap = this.f8393c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            this.f8391a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
            for (String str : C2432j.m51193a(this.f8394d)) {
                try {
                    String[] split = new String(C2422a.m51450b(Encrypt.m54718g(str), this.f8395e), "UTF-8").split(",");
                    if (split != null && split.length > 1) {
                        this.f8393c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: d */
    private void m51250d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.f8393c.entrySet()) {
                try {
                    String str = entry.getKey() + "," + entry.getValue();
                    sb.append(Encrypt.m54719f(C2422a.m51453a(str.getBytes("UTF-8"), this.f8395e)) + ShellAdbUtils.f33810d);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            C2432j.m51192a(this.f8394d, sb2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public final synchronized void m51253b() {
        try {
            if (m51252b(this.f8396g)) {
                for (Map.Entry<String, Long> entry : this.f8393c.entrySet()) {
                    if (!this.f8391a.equals(entry.getKey())) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("param_long_first", entry.getKey());
                        jSONObject.put("param_long_second", entry.getValue());
                        ReportUtil.m51236a(this.f8396g, "O023", jSONObject);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final synchronized void m51256a() {
        if (this.f8397h) {
            m51250d();
            this.f8397h = false;
        }
    }

    /* renamed from: a */
    public final synchronized void m51254a(AMapLocation aMapLocation) {
        try {
            if ((!this.f8393c.containsKey(this.f8391a) && this.f8393c.size() >= 8) || (this.f8393c.containsKey(this.f8391a) && this.f8393c.size() >= 9)) {
                ArrayList<String> arrayList = new ArrayList();
                for (Map.Entry<String, Long> entry : this.f8393c.entrySet()) {
                    arrayList.add(entry.getKey());
                    if (arrayList.size() == this.f8393c.size() - 7) {
                        break;
                    }
                }
                for (String str : arrayList) {
                    this.f8393c.remove(str);
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.f8393c.containsKey(this.f8391a)) {
                    long longValue = this.f8393c.get(this.f8391a).longValue() + 1;
                    f8390i = longValue;
                    this.f8393c.put(this.f8391a, Long.valueOf(longValue));
                } else {
                    this.f8393c.put(this.f8391a, 1L);
                    f8390i = 1L;
                }
                long j = f8390i;
                if (j != 0 && j % 100 == 0) {
                    m51256a();
                }
                this.f8397h = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private boolean m51252b(Context context) {
        if (this.f8392b == null) {
            this.f8392b = C2431i.m51219a(context, "pref", "lastavedate", "0");
        }
        if (this.f8392b.equals(this.f8391a)) {
            return false;
        }
        SharedPreferences.Editor m51222a = C2431i.m51222a(context, "pref");
        C2431i.m51213a(m51222a, "lastavedate", this.f8391a);
        C2431i.m51217a(m51222a);
        this.f8392b = this.f8391a;
        return true;
    }
}

package com.bytedance.sdk.openadsdk.core.eq;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f33326c;
    private com.bytedance.sdk.component.f.c ev;
    private com.bytedance.sdk.component.f.c gd;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f33330p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.component.f.c f33331r;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f33329k = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f33327a = 0;
    private int bk = 0;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, Integer> f33332w = new HashMap();
    private final ConcurrentHashMap<String, Integer> xv = new ConcurrentHashMap<>();
    private final Map<String, Long> sr = new HashMap();
    private final ConcurrentHashMap<String, Long> ux = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final long f33328f = SystemClock.elapsedRealtime();

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.f.c f() {
        if (this.gd == null) {
            this.gd = ba.c("activity_foreground_time");
        }
        return this.gd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.f.c r() {
        if (this.f33330p == null) {
            this.f33330p = ba.c("activity_recorder");
        }
        return this.f33330p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.f.c ux() {
        if (this.ev == null) {
            this.ev = ba.c("activity_adshow_count");
        }
        return this.ev;
    }

    public void sr(final String str) {
        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.w.3
            @Override // java.lang.Runnable
            public void run() {
                w.this.ux().c(str, w.this.ux().w(str, 0) + 1);
            }
        });
    }

    public void w(final String str) {
        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.sr().c(str, w.this.sr().w(str, 0) + 1);
                if (w.this.f33329k == 0) {
                    w wVar = w.this;
                    wVar.f33329k = wVar.r().w("histRunningCount", 0) + 1;
                    w.this.r().c("histRunningCount", w.this.f33329k);
                }
            }
        });
    }

    public void xv(String str) {
        if (TextUtils.isEmpty(str) || !this.ux.containsKey(str)) {
            return;
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.ux.remove(str).longValue()) / 1000;
        if (elapsedRealtime >= 0) {
            Long l4 = this.sr.get(str);
            this.sr.put(str, Long.valueOf(((l4 == null || l4.longValue() < 0) ? 0L : 0L).longValue() + elapsedRealtime));
            c(str, elapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.f.c sr() {
        if (this.f33331r == null) {
            this.f33331r = ba.c("activity_resume_count");
        }
        return this.f33331r;
    }

    public void w() {
        if (this.ux.size() == 1) {
            for (String str : this.ux.keySet()) {
                Integer num = this.xv.get(str);
                this.xv.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                sr(str);
            }
        }
    }

    public static w c() {
        if (f33326c == null) {
            synchronized (w.class) {
                if (f33326c == null) {
                    f33326c = new w();
                }
            }
        }
        return f33326c;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.f33332w.get(str);
        this.f33332w.put(str, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        this.ux.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        if (this.ux.size() > 1) {
            this.f33327a++;
        }
        w(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        try {
            Map<String, ?> c4 = sr().c();
            if (c4 == null) {
                return;
            }
            Iterator<?> it = c4.values().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                i4 += ((Integer) it.next()).intValue();
            }
            if (i4 != 0 && i4 % 75 == 0) {
                final JSONArray jSONArray = new JSONArray();
                for (String str : this.f33332w.keySet()) {
                    Integer num = this.f33332w.get(str);
                    Long l4 = this.sr.get(str);
                    Integer num2 = this.xv.get(str);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("name", str);
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, num != null ? num.intValue() : 0);
                        jSONObject.put("ft", l4 != null ? l4.longValue() : 0L);
                        jSONObject.put("asc", num2 != null ? num2.intValue() : 0);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                final JSONArray jSONArray2 = new JSONArray();
                Map<String, ?> c5 = f().c();
                Map<String, ?> c6 = ux().c();
                if (c5 != null && c6 != null) {
                    for (String str2 : c4.keySet()) {
                        Integer num3 = (Integer) c4.get(str2);
                        Long l5 = (Long) c5.get(str2);
                        Integer num4 = (Integer) c6.get(str2);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str2);
                            jSONObject2.put(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT, num3 != null ? num3.intValue() : 0);
                            jSONObject2.put("ft", l5 != null ? l5.longValue() : 0L);
                            jSONObject2.put("asc", num4 != null ? num4.intValue() : 0);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                final long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f33328f) / 1000;
                com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.w.4
                    @Override // com.bytedance.sdk.openadsdk.p.c.c
                    public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("ara", jSONArray);
                        jSONObject3.put("hara", jSONArray2);
                        jSONObject3.put("rt", elapsedRealtime);
                        jSONObject3.put("hrc", w.this.f33329k);
                        jSONObject3.put(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RESPONSE_CODE, w.this.f33327a);
                        return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("ad_activity_record").w(jSONObject3.toString());
                    }
                }, "ad_activity_record");
            }
        } catch (Throwable unused) {
        }
    }

    public void c(final String str, final long j4) {
        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.eq.w.2
            @Override // java.lang.Runnable
            public void run() {
                long w3 = w.this.f().w(str, 0L);
                w.this.f().c(str, (w3 >= 0 ? w3 : 0L) + j4);
                w.this.xv();
                w.this.c(j4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4) {
        int i4 = this.bk;
        if (i4 == 0) {
            try {
                Map<String, ?> c4 = f().c();
                if (c4 != null) {
                    Iterator<?> it = c4.values().iterator();
                    while (it.hasNext()) {
                        this.bk = (int) (this.bk + ((Long) it.next()).longValue());
                    }
                }
            } catch (Throwable unused) {
                this.bk = -1;
            }
        } else {
            this.bk = (int) (i4 + j4);
        }
        q.c(this.bk, this.f33329k);
    }
}

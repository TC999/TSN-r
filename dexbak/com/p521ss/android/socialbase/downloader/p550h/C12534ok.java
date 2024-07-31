package com.p521ss.android.socialbase.downloader.p550h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p556q.C12718p;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.h.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12534ok {

    /* renamed from: bl */
    private static JSONObject f35191bl;

    /* renamed from: h */
    private static C12534ok f35192h;

    /* renamed from: kf */
    private static boolean f35193kf;

    /* renamed from: n */
    private static Boolean f35194n;

    /* renamed from: s */
    private static JSONObject f35196s;

    /* renamed from: k */
    private final Boolean f35197k;

    /* renamed from: p */
    private final JSONObject f35198p;

    /* renamed from: q */
    private final JSONObject f35199q;

    /* renamed from: r */
    private int f35200r;

    /* renamed from: ok */
    private static final C12718p<Integer, C12534ok> f35195ok = new C12718p<>(16, 16);

    /* renamed from: a */
    private static final C12534ok f35190a = new C12534ok(null);

    static {
        m17600ok();
    }

    private C12534ok(JSONObject jSONObject) {
        Boolean bool;
        this.f35198p = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || m17602kf("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !m17602kf("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f35199q = jSONObject2;
        this.f35197k = bool;
    }

    @NonNull
    /* renamed from: a */
    public static JSONObject m17610a() {
        return C12490bl.m17753v();
    }

    @NonNull
    /* renamed from: bl */
    public static C12534ok m17605bl() {
        return f35190a;
    }

    /* renamed from: kf */
    public static boolean m17602kf(String str) {
        JSONObject jSONObject = f35191bl;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    /* renamed from: ok */
    public static void m17600ok() {
        JSONObject m17753v = C12490bl.m17753v();
        f35193kf = m17753v.optInt("disable_task_setting", 0) == 1;
        f35191bl = m17753v.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = m17753v.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f35196s = optJSONObject;
        f35194n = bool;
    }

    /* renamed from: n */
    public JSONArray m17601n(String str) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optJSONArray(str);
        }
        return m17610a().optJSONArray(str);
    }

    /* renamed from: s */
    public JSONObject m17588s(String str) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optJSONObject(str);
        }
        return m17610a().optJSONObject(str);
    }

    /* renamed from: a */
    public boolean m17606a(String str, boolean z) {
        if (this.f35199q != null && !m17602kf(str)) {
            if (this.f35199q.has(str)) {
                return this.f35199q.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f35197k;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f35196s;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f35196s.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f35194n;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    /* renamed from: bl */
    public String m17603bl(String str) {
        return m17591ok(str, "");
    }

    /* renamed from: bl */
    private static C12534ok m17604bl(int i) {
        DownloadInfo downloadInfo;
        if (f35193kf) {
            return f35190a;
        }
        Context m17807l = C12490bl.m17807l();
        if (m17807l != null && (downloadInfo = Downloader.getInstance(m17807l).getDownloadInfo(i)) != null) {
            return m17608a(downloadInfo);
        }
        return f35190a;
    }

    /* renamed from: ok */
    public static void m17590ok(String str, boolean z) {
        try {
            if (f35196s == null) {
                f35196s = new JSONObject();
            }
            f35196s.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    /* renamed from: ok */
    public static C12534ok m17599ok(int i) {
        return m17598ok(i, (DownloadInfo) null);
    }

    /* renamed from: a */
    public int m17607a(String str) {
        return m17593ok(str, 0);
    }

    /* renamed from: a */
    public static void m17609a(int i) {
        C12534ok c12534ok = f35192h;
        if (c12534ok != null && c12534ok.f35200r == i) {
            f35192h = null;
        }
        C12718p<Integer, C12534ok> c12718p = f35195ok;
        synchronized (c12718p) {
            c12718p.remove(Integer.valueOf(i));
        }
    }

    @NonNull
    /* renamed from: ok */
    public static C12534ok m17596ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f35190a;
        }
        return m17598ok(downloadInfo.getId(), downloadInfo);
    }

    /* renamed from: ok */
    private static C12534ok m17598ok(int i, DownloadInfo downloadInfo) {
        C12534ok c12534ok;
        C12534ok c12534ok2 = f35192h;
        if (c12534ok2 == null || c12534ok2.f35200r != i) {
            C12718p<Integer, C12534ok> c12718p = f35195ok;
            synchronized (c12718p) {
                c12534ok = c12718p.get(Integer.valueOf(i));
            }
            if (c12534ok == null) {
                c12534ok = downloadInfo == null ? m17604bl(i) : m17608a(downloadInfo);
                synchronized (c12718p) {
                    c12718p.put(Integer.valueOf(i), c12534ok);
                }
            }
            c12534ok.f35200r = i;
            f35192h = c12534ok;
            return c12534ok;
        }
        return c12534ok2;
    }

    /* renamed from: a */
    private static C12534ok m17608a(DownloadInfo downloadInfo) {
        if (f35193kf) {
            return f35190a;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new C12534ok(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f35190a;
    }

    /* renamed from: ok */
    public boolean m17595ok(String str) {
        return m17606a(str, false);
    }

    /* renamed from: ok */
    public int m17593ok(String str, int i) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optInt(str, i);
        }
        return m17610a().optInt(str, i);
    }

    /* renamed from: ok */
    public long m17592ok(String str, long j) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optLong(str, j);
        }
        return m17610a().optLong(str, j);
    }

    /* renamed from: ok */
    public double m17594ok(String str, double d) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optDouble(str, d);
        }
        return m17610a().optDouble(str, d);
    }

    /* renamed from: ok */
    public String m17591ok(String str, String str2) {
        JSONObject jSONObject = this.f35198p;
        if (jSONObject != null && jSONObject.has(str) && !m17602kf(str)) {
            return this.f35198p.optString(str, str2);
        }
        return m17610a().optString(str, str2);
    }

    @NonNull
    /* renamed from: ok */
    public static C12534ok m17589ok(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != m17610a() && !f35193kf) {
            C12534ok c12534ok = f35192h;
            if (c12534ok == null || c12534ok.f35198p != jSONObject) {
                C12718p<Integer, C12534ok> c12718p = f35195ok;
                synchronized (c12718p) {
                    for (C12534ok c12534ok2 : c12718p.values()) {
                        if (c12534ok2.f35198p == jSONObject) {
                            f35192h = c12534ok2;
                            return c12534ok2;
                        }
                    }
                    C12534ok c12534ok3 = new C12534ok(jSONObject);
                    f35192h = c12534ok3;
                    return c12534ok3;
                }
            }
            return c12534ok;
        }
        return f35190a;
    }

    /* renamed from: ok */
    public static void m17597ok(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == m17610a() || f35193kf) {
            return;
        }
        C12718p<Integer, C12534ok> c12718p = f35195ok;
        synchronized (c12718p) {
            C12534ok c12534ok = f35192h;
            if (c12534ok != null && c12534ok.f35198p == jSONObject) {
                c12534ok.f35200r = i;
            } else {
                c12534ok = null;
                Iterator<C12534ok> it = c12718p.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C12534ok next = it.next();
                    if (next.f35198p == jSONObject) {
                        next.f35200r = i;
                        c12534ok = next;
                        break;
                    }
                }
                if (c12534ok == null) {
                    c12534ok = new C12534ok(jSONObject);
                    c12534ok.f35200r = i;
                }
                f35192h = c12534ok;
            }
            f35195ok.put(Integer.valueOf(i), c12534ok);
        }
    }
}

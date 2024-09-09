package com.ss.android.socialbase.downloader.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.p;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {
    private static JSONObject bl;

    /* renamed from: h  reason: collision with root package name */
    private static ok f49718h;
    private static boolean kf;

    /* renamed from: n  reason: collision with root package name */
    private static Boolean f49719n;

    /* renamed from: s  reason: collision with root package name */
    private static JSONObject f49720s;

    /* renamed from: k  reason: collision with root package name */
    private final Boolean f49721k;

    /* renamed from: p  reason: collision with root package name */
    private final JSONObject f49722p;

    /* renamed from: q  reason: collision with root package name */
    private final JSONObject f49723q;

    /* renamed from: r  reason: collision with root package name */
    private int f49724r;
    private static final p<Integer, ok> ok = new p<>(16, 16);

    /* renamed from: a  reason: collision with root package name */
    private static final ok f49717a = new ok(null);

    static {
        ok();
    }

    private ok(JSONObject jSONObject) {
        Boolean bool;
        this.f49722p = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || kf("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !kf("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f49723q = jSONObject2;
        this.f49721k = bool;
    }

    @NonNull
    public static JSONObject a() {
        return bl.v();
    }

    @NonNull
    public static ok bl() {
        return f49717a;
    }

    public static boolean kf(String str) {
        JSONObject jSONObject = bl;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static void ok() {
        JSONObject v3 = bl.v();
        kf = v3.optInt("disable_task_setting", 0) == 1;
        bl = v3.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = v3.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f49720s = optJSONObject;
        f49719n = bool;
    }

    public JSONArray n(String str) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optJSONArray(str);
        }
        return a().optJSONArray(str);
    }

    public JSONObject s(String str) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optJSONObject(str);
        }
        return a().optJSONObject(str);
    }

    public boolean a(String str, boolean z3) {
        if (this.f49723q != null && !kf(str)) {
            if (this.f49723q.has(str)) {
                return this.f49723q.optInt(str, z3 ? 1 : 0) == 1;
            }
            Boolean bool = this.f49721k;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f49720s;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f49720s.optInt(str, z3 ? 1 : 0) == 1;
            }
            Boolean bool2 = f49719n;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z3;
    }

    public String bl(String str) {
        return ok(str, "");
    }

    private static ok bl(int i4) {
        DownloadInfo downloadInfo;
        if (kf) {
            return f49717a;
        }
        Context l4 = bl.l();
        if (l4 != null && (downloadInfo = Downloader.getInstance(l4).getDownloadInfo(i4)) != null) {
            return a(downloadInfo);
        }
        return f49717a;
    }

    public static void ok(String str, boolean z3) {
        try {
            if (f49720s == null) {
                f49720s = new JSONObject();
            }
            f49720s.put(str, z3 ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static ok ok(int i4) {
        return ok(i4, (DownloadInfo) null);
    }

    public int a(String str) {
        return ok(str, 0);
    }

    public static void a(int i4) {
        ok okVar = f49718h;
        if (okVar != null && okVar.f49724r == i4) {
            f49718h = null;
        }
        p<Integer, ok> pVar = ok;
        synchronized (pVar) {
            pVar.remove(Integer.valueOf(i4));
        }
    }

    @NonNull
    public static ok ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f49717a;
        }
        return ok(downloadInfo.getId(), downloadInfo);
    }

    private static ok ok(int i4, DownloadInfo downloadInfo) {
        ok okVar;
        ok okVar2 = f49718h;
        if (okVar2 == null || okVar2.f49724r != i4) {
            p<Integer, ok> pVar = ok;
            synchronized (pVar) {
                okVar = pVar.get(Integer.valueOf(i4));
            }
            if (okVar == null) {
                okVar = downloadInfo == null ? bl(i4) : a(downloadInfo);
                synchronized (pVar) {
                    pVar.put(Integer.valueOf(i4), okVar);
                }
            }
            okVar.f49724r = i4;
            f49718h = okVar;
            return okVar;
        }
        return okVar2;
    }

    private static ok a(DownloadInfo downloadInfo) {
        if (kf) {
            return f49717a;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new ok(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f49717a;
    }

    public boolean ok(String str) {
        return a(str, false);
    }

    public int ok(String str, int i4) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optInt(str, i4);
        }
        return a().optInt(str, i4);
    }

    public long ok(String str, long j4) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optLong(str, j4);
        }
        return a().optLong(str, j4);
    }

    public double ok(String str, double d4) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optDouble(str, d4);
        }
        return a().optDouble(str, d4);
    }

    public String ok(String str, String str2) {
        JSONObject jSONObject = this.f49722p;
        if (jSONObject != null && jSONObject.has(str) && !kf(str)) {
            return this.f49722p.optString(str, str2);
        }
        return a().optString(str, str2);
    }

    @NonNull
    public static ok ok(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != a() && !kf) {
            ok okVar = f49718h;
            if (okVar == null || okVar.f49722p != jSONObject) {
                p<Integer, ok> pVar = ok;
                synchronized (pVar) {
                    for (ok okVar2 : pVar.values()) {
                        if (okVar2.f49722p == jSONObject) {
                            f49718h = okVar2;
                            return okVar2;
                        }
                    }
                    ok okVar3 = new ok(jSONObject);
                    f49718h = okVar3;
                    return okVar3;
                }
            }
            return okVar;
        }
        return f49717a;
    }

    public static void ok(int i4, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == a() || kf) {
            return;
        }
        p<Integer, ok> pVar = ok;
        synchronized (pVar) {
            ok okVar = f49718h;
            if (okVar != null && okVar.f49722p == jSONObject) {
                okVar.f49724r = i4;
            } else {
                okVar = null;
                Iterator<ok> it = pVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ok next = it.next();
                    if (next.f49722p == jSONObject) {
                        next.f49724r = i4;
                        okVar = next;
                        break;
                    }
                }
                if (okVar == null) {
                    okVar = new ok(jSONObject);
                    okVar.f49724r = i4;
                }
                f49718h = okVar;
            }
            ok.put(Integer.valueOf(i4), okVar);
        }
    }
}

package com.ss.android.socialbase.downloader.r;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.ss.android.socialbase.downloader.gd.ev;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f50168f;

    /* renamed from: r  reason: collision with root package name */
    private static c f50169r;
    private static JSONObject sr;
    private static Boolean ux;
    private static JSONObject xv;
    private final JSONObject ev;
    private final JSONObject gd;

    /* renamed from: k  reason: collision with root package name */
    private int f50171k;

    /* renamed from: p  reason: collision with root package name */
    private final Boolean f50172p;

    /* renamed from: c  reason: collision with root package name */
    private static final ev<Integer, c> f50167c = new ev<>(16, 16);

    /* renamed from: w  reason: collision with root package name */
    private static final c f50170w = new c(null);

    static {
        c();
    }

    private c(JSONObject jSONObject) {
        Boolean bool;
        this.ev = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.gd = jSONObject2;
        this.f50172p = bool;
    }

    public static void c() {
        JSONObject me = xv.me();
        f50168f = me.optInt("disable_task_setting", 0) == 1;
        xv = me.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = me.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        sr = optJSONObject;
        ux = bool;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = xv;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    @NonNull
    public static JSONObject w() {
        return xv.me();
    }

    @NonNull
    public static c xv() {
        return f50170w;
    }

    public JSONObject sr(String str) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optJSONObject(str);
        }
        return w().optJSONObject(str);
    }

    public JSONArray ux(String str) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optJSONArray(str);
        }
        return w().optJSONArray(str);
    }

    public boolean w(String str, boolean z3) {
        if (this.gd != null && !f(str)) {
            if (this.gd.has(str)) {
                return this.gd.optInt(str, z3 ? 1 : 0) == 1;
            }
            Boolean bool = this.f50172p;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = sr;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return sr.optInt(str, z3 ? 1 : 0) == 1;
            }
            Boolean bool2 = ux;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z3;
    }

    public String xv(String str) {
        return c(str, "");
    }

    private static c xv(int i4) {
        DownloadInfo downloadInfo;
        if (f50168f) {
            return f50170w;
        }
        Context gw = xv.gw();
        if (gw != null && (downloadInfo = Downloader.getInstance(gw).getDownloadInfo(i4)) != null) {
            return w(downloadInfo);
        }
        return f50170w;
    }

    public static void c(String str, boolean z3) {
        try {
            if (sr == null) {
                sr = new JSONObject();
            }
            sr.put(str, z3 ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static c c(int i4) {
        return c(i4, (DownloadInfo) null);
    }

    public int w(String str) {
        return c(str, 0);
    }

    @NonNull
    public static c c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return f50170w;
        }
        return c(downloadInfo.getId(), downloadInfo);
    }

    public static void w(int i4) {
        c cVar = f50169r;
        if (cVar != null && cVar.f50171k == i4) {
            f50169r = null;
        }
        ev<Integer, c> evVar = f50167c;
        synchronized (evVar) {
            evVar.remove(Integer.valueOf(i4));
        }
    }

    private static c c(int i4, DownloadInfo downloadInfo) {
        c cVar;
        c cVar2 = f50169r;
        if (cVar2 == null || cVar2.f50171k != i4) {
            ev<Integer, c> evVar = f50167c;
            synchronized (evVar) {
                cVar = evVar.get(Integer.valueOf(i4));
            }
            if (cVar == null) {
                cVar = downloadInfo == null ? xv(i4) : w(downloadInfo);
                synchronized (evVar) {
                    evVar.put(Integer.valueOf(i4), cVar);
                }
            }
            cVar.f50171k = i4;
            f50169r = cVar;
            return cVar;
        }
        return cVar2;
    }

    private static c w(DownloadInfo downloadInfo) {
        if (f50168f) {
            return f50170w;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new c(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f50170w;
    }

    public boolean c(String str) {
        return w(str, false);
    }

    public int c(String str, int i4) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optInt(str, i4);
        }
        return w().optInt(str, i4);
    }

    public long c(String str, long j4) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optLong(str, j4);
        }
        return w().optLong(str, j4);
    }

    public double c(String str, double d4) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optDouble(str, d4);
        }
        return w().optDouble(str, d4);
    }

    public String c(String str, String str2) {
        JSONObject jSONObject = this.ev;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.ev.optString(str, str2);
        }
        return w().optString(str, str2);
    }

    @NonNull
    public static c c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != w() && !f50168f) {
            c cVar = f50169r;
            if (cVar == null || cVar.ev != jSONObject) {
                ev<Integer, c> evVar = f50167c;
                synchronized (evVar) {
                    for (c cVar2 : evVar.values()) {
                        if (cVar2.ev == jSONObject) {
                            f50169r = cVar2;
                            return cVar2;
                        }
                    }
                    c cVar3 = new c(jSONObject);
                    f50169r = cVar3;
                    return cVar3;
                }
            }
            return cVar;
        }
        return f50170w;
    }

    public static void c(int i4, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == w() || f50168f) {
            return;
        }
        ev<Integer, c> evVar = f50167c;
        synchronized (evVar) {
            c cVar = f50169r;
            if (cVar != null && cVar.ev == jSONObject) {
                cVar.f50171k = i4;
            } else {
                cVar = null;
                Iterator<c> it = evVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next.ev == jSONObject) {
                        next.f50171k = i4;
                        cVar = next;
                        break;
                    }
                }
                if (cVar == null) {
                    cVar = new c(jSONObject);
                    cVar.f50171k = i4;
                }
                f50169r = cVar;
            }
            f50167c.put(Integer.valueOf(i4), cVar);
        }
    }
}

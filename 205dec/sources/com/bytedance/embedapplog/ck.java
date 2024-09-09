package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ck {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f26717f = {"channel", "package", "app_version"};

    /* renamed from: c  reason: collision with root package name */
    private boolean f26718c;

    /* renamed from: r  reason: collision with root package name */
    private final SharedPreferences f26719r;

    /* renamed from: w  reason: collision with root package name */
    private final Context f26720w;
    private final n xv;
    private final ArrayList<i> ux = new ArrayList<>(32);
    private int ev = 0;
    @NonNull
    private JSONObject sr = new JSONObject();

    public ck(Context context, n nVar) {
        this.f26720w = context;
        this.xv = nVar;
        this.f26719r = nVar.sr();
        kk.c(context);
    }

    @NonNull
    private JSONObject a() {
        return this.sr;
    }

    @Nullable
    public JSONObject c() {
        if (this.f26718c) {
            return a();
        }
        return null;
    }

    public String ev() {
        return a().optString("user_unique_id", "");
    }

    public String f() {
        return a().optString("install_id", "");
    }

    public int gd() {
        String optString = a().optString("device_id", "");
        a().optString("install_id", "");
        if (w(optString)) {
            return this.f26719r.getInt("version_code", 0) == a().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public String k() {
        return a().optString("ab_sdk_version", "");
    }

    public long p() {
        return a().optLong("register_time", 0L);
    }

    public String r() {
        return a().optString("ssid", "");
    }

    public boolean sr() {
        String[] strArr;
        synchronized (this.ux) {
            if (this.ux.size() == 0) {
                this.ux.add(new q(this.f26720w, this.xv));
                this.ux.add(new ls(this.f26720w));
                this.ux.add(new gb(this.f26720w, this.xv));
                this.ux.add(new z(this.f26720w));
                this.ux.add(new y(this.f26720w));
                this.ux.add(new eq(this.f26720w, this.xv));
                this.ux.add(new me(this.f26720w));
                this.ux.add(new xk(this.f26720w, this.xv));
                this.ux.add(new yu(this.f26720w, this.xv));
                this.ux.add(new wx());
                this.ux.add(new pr(this.xv));
                this.ux.add(new bw(this.f26720w));
                this.ux.add(new x(this.f26720w));
                this.ux.add(new m(this.f26720w, this.xv));
                this.ux.add(new fz(this.f26720w, this.xv));
                this.ux.add(new wv(this.f26720w, this.xv));
                this.ux.add(new j(this.f26720w, this.xv));
            }
        }
        JSONObject a4 = a();
        JSONObject jSONObject = new JSONObject();
        g.w(jSONObject, a4);
        Iterator<i> it = this.ux.iterator();
        boolean z3 = true;
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            i next = it.next();
            if (!next.f26746c || next.xv || c(next)) {
                try {
                    next.f26746c = next.c(jSONObject);
                } catch (SecurityException e4) {
                    if (!next.f26747w) {
                        i4++;
                        be.w("loadHeader, " + this.ev, e4);
                        if (!next.f26746c && this.ev > 10) {
                            next.f26746c = true;
                        }
                    }
                } catch (JSONException e5) {
                    be.w(e5);
                }
                if (!next.f26746c && !next.f26747w) {
                    i5++;
                }
            }
            z3 &= next.f26746c || next.f26747w;
        }
        if (z3) {
            int length = f26717f.length;
            for (int i6 = 0; i6 < length; i6++) {
                z3 &= !TextUtils.isEmpty(jSONObject.optString(strArr[i6]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.sr = jSONObject;
        this.f26718c = z3;
        if (be.f26702w) {
            be.c("loadHeader, " + this.f26718c + ", " + this.ev + ", " + this.sr.toString(), null);
        } else {
            be.sr("loadHeader, " + this.f26718c + ", " + this.ev, null);
        }
        if (i4 > 0 && i4 == i5) {
            this.ev++;
            if (gd() != 0) {
                this.ev += 10;
            }
        }
        if (this.f26718c) {
            c.p().onIdLoaded(ux(), f(), r());
        }
        return this.f26718c;
    }

    public String ux() {
        return a().optString("device_id", "");
    }

    public int w() {
        int optInt = this.f26718c ? a().optInt("version_code", -1) : -1;
        for (int i4 = 0; i4 < 3 && optInt == -1; i4++) {
            sr();
            optInt = this.f26718c ? a().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String xv() {
        String optString = this.f26718c ? a().optString("app_version", null) : null;
        for (int i4 = 0; i4 < 3 && optString == null; i4++) {
            sr();
            optString = this.f26718c ? a().optString("app_version", null) : null;
        }
        return optString;
    }

    @Nullable
    public <T> T c(String str, T t3) {
        JSONObject a4 = a();
        Object obj = (a4 == null || (obj = a4.opt(str)) == null) ? null : null;
        return obj == null ? t3 : (T) obj;
    }

    private boolean c(i iVar) {
        boolean z3 = !this.xv.ia() && iVar.sr;
        if (be.f26702w) {
            be.c("needSyncFromSub " + iVar + " " + z3, null);
        }
        return z3;
    }

    private synchronized void w(JSONObject jSONObject) {
        if (jSONObject == null) {
            be.w("null abconfig", null);
            return;
        }
        String optString = a().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> keys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e4) {
                            be.w(e4);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            w("ab_version", c(hashSet));
        }
    }

    public void c(JSONObject jSONObject) {
        this.xv.xv(jSONObject);
        w(jSONObject);
    }

    private String c(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void c(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = a().optJSONObject("custom");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e4) {
                be.w(e4);
            }
        }
        if (w("custom", jSONObject)) {
            this.xv.w(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private boolean w(String str, Object obj) {
        boolean z3;
        Object opt = a().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z3 = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.sr;
                    JSONObject jSONObject2 = new JSONObject();
                    g.w(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.sr = jSONObject2;
                } catch (JSONException e4) {
                    be.w(e4);
                }
            }
            z3 = true;
        }
        be.c("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z3;
    }

    public boolean c(JSONObject jSONObject, String str, String str2, String str3) {
        boolean w3;
        int i4;
        boolean z3;
        boolean z4;
        if (be.f26702w) {
            be.c("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean w4 = w(str);
        boolean w5 = w(str2);
        try {
            w3 = w(str3);
            i4 = this.f26719r.getInt("version_code", 0);
        } catch (JSONException e4) {
            e = e4;
        }
        try {
            int optInt = a().optInt("version_code", 0);
            SharedPreferences.Editor edit = this.f26719r.edit();
            if (i4 != optInt) {
                edit.putInt("version_code", optInt);
            }
            if (w4) {
                long currentTimeMillis = System.currentTimeMillis();
                edit.putLong("register_time", currentTimeMillis);
                w("register_time", Long.valueOf(currentTimeMillis));
            } else if (!w4) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                c.c("tt_fetch_did_error", jSONObject2);
            }
            String optString = a().optString("device_id", "");
            if (w4 && w("device_id", str)) {
                edit.putString("device_id", str);
                z3 = true;
            } else {
                z3 = false;
            }
            String optString2 = a().optString("install_id", "");
            if (w5 && w("install_id", str2)) {
                edit.putString("install_id", str2);
                z3 = true;
            }
            String optString3 = a().optString("ssid", "");
            if (w3 && w("ssid", str3)) {
                edit.putString("ssid", str3);
                z4 = true;
            } else {
                z4 = z3;
            }
            c.p().onRemoteIdGet(z4, optString, str, optString2, str2, optString3, str3);
            edit.apply();
        } catch (JSONException e5) {
            e = e5;
            be.w(e);
            if (w4) {
            }
        }
        return !w4 && w5;
    }

    public static boolean w(String str) {
        boolean z3 = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= str.length()) {
                z3 = true;
                break;
            } else if (str.charAt(i4) != '0') {
                break;
            } else {
                i4++;
            }
        }
        return !z3;
    }
}

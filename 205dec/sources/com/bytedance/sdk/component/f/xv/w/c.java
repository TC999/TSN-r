package com.bytedance.sdk.component.f.xv.w;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, c> f29801c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private SharedPreferences f29802w;

    private c(String str, Context context) {
        if (context != null) {
            this.f29802w = com.bytedance.sdk.openadsdk.api.plugin.w.w(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, 0);
        }
    }

    public static c c(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        c cVar = f29801c.get(str);
        if (cVar == null) {
            c cVar2 = new c(str, context);
            f29801c.put(str, cVar2);
            return cVar2;
        }
        return cVar;
    }

    public String w(String str, String str2) {
        try {
            return this.f29802w.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int w(String str, int i4) {
        try {
            return this.f29802w.getInt(str, i4);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public long w(String str, long j4) {
        try {
            return this.f29802w.getLong(str, j4);
        } catch (Throwable unused) {
            return j4;
        }
    }

    public float w(String str, float f4) {
        try {
            return this.f29802w.getFloat(str, f4);
        } catch (Throwable unused) {
            return f4;
        }
    }

    public void c(String str, String str2) {
        try {
            this.f29802w.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public boolean w(String str, boolean z3) {
        try {
            return this.f29802w.getBoolean(str, z3);
        } catch (Throwable unused) {
            return z3;
        }
    }

    public void c(String str, int i4) {
        try {
            this.f29802w.edit().putInt(str, i4).apply();
        } catch (Throwable unused) {
        }
    }

    public Set<String> w(String str, Set<String> set) {
        try {
            return this.f29802w.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void c(String str, long j4) {
        try {
            this.f29802w.edit().putLong(str, j4).apply();
        } catch (Throwable unused) {
        }
    }

    public void w() {
        try {
            this.f29802w.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, float f4) {
        try {
            this.f29802w.edit().putFloat(str, f4).apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, boolean z3) {
        try {
            this.f29802w.edit().putBoolean(str, z3).apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, Set<String> set) {
        try {
            this.f29802w.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    public Map<String, ?> c() {
        try {
            return this.f29802w.getAll();
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    public void c(String str) {
        try {
            this.f29802w.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}

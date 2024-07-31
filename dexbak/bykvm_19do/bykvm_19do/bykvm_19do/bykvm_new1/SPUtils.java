package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SPUtils {

    /* renamed from: b */
    private static Map<String, SPUtils> f678b = new HashMap();

    /* renamed from: a */
    private SharedPreferences f679a;

    private SPUtils(String str, Context context) {
        if (context != null) {
            this.f679a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0);
        }
    }

    /* renamed from: a */
    public static SPUtils m59131a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        SPUtils sPUtils = f678b.get(str);
        if (sPUtils == null) {
            SPUtils sPUtils2 = new SPUtils(str, context);
            f678b.put(str, sPUtils2);
            return sPUtils2;
        }
        return sPUtils;
    }

    /* renamed from: b */
    public String m59128b() {
        return m59130a("any_door_id", (String) null);
    }

    /* renamed from: c */
    public long m59121c(@NonNull String str) {
        return m59132a(str, -1L);
    }

    /* renamed from: d */
    public String m59120d(@NonNull String str) {
        try {
            return m59130a(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    public void m59119e(String str) {
        m59123b("any_door_id", str);
    }

    /* renamed from: f */
    public void m59118f(@NonNull String str) {
        try {
            this.f679a.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public void m59123b(@NonNull String str, @NonNull String str2) {
        try {
            this.f679a.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public void m59125b(@NonNull String str, int i) {
        try {
            this.f679a.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public int m59127b(@NonNull String str) {
        return m59133a(str, -1);
    }

    /* renamed from: a */
    public String m59130a(@NonNull String str, @NonNull String str2) {
        try {
            return this.f679a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: b */
    public void m59124b(@NonNull String str, long j) {
        try {
            this.f679a.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public int m59133a(@NonNull String str, int i) {
        try {
            return this.f679a.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: b */
    public void m59126b(@NonNull String str, float f) {
        try {
            this.f679a.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public long m59132a(@NonNull String str, long j) {
        try {
            return this.f679a.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    /* renamed from: b */
    public void m59122b(@NonNull String str, boolean z) {
        try {
            this.f679a.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public float m59134a(@NonNull String str, float f) {
        try {
            return this.f679a.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    /* renamed from: a */
    public boolean m59135a(@NonNull String str) {
        return m59129a(str, false);
    }

    /* renamed from: a */
    public boolean m59129a(@NonNull String str, boolean z) {
        try {
            return this.f679a.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    /* renamed from: a */
    public void m59136a() {
        try {
            this.f679a.edit().clear().commit();
        } catch (Throwable unused) {
        }
    }
}

package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SPUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class r {

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, r> f671b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f672a;

    private r(String str, Context context) {
        if (context != null) {
            this.f672a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, 0);
        }
    }

    public static r a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        r rVar = f671b.get(str);
        if (rVar == null) {
            r rVar2 = new r(str, context);
            f671b.put(str, rVar2);
            return rVar2;
        }
        return rVar;
    }

    public String b() {
        return a("any_door_id", (String) null);
    }

    public long c(@NonNull String str) {
        return a(str, -1L);
    }

    public String d(@NonNull String str) {
        try {
            return a(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void e(String str) {
        b("any_door_id", str);
    }

    public void f(@NonNull String str) {
        try {
            this.f672a.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, @NonNull String str2) {
        try {
            this.f672a.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, int i4) {
        try {
            this.f672a.edit().putInt(str, i4).apply();
        } catch (Throwable unused) {
        }
    }

    public int b(@NonNull String str) {
        return a(str, -1);
    }

    public String a(@NonNull String str, @NonNull String str2) {
        try {
            return this.f672a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void b(@NonNull String str, long j4) {
        try {
            this.f672a.edit().putLong(str, j4).apply();
        } catch (Throwable unused) {
        }
    }

    public int a(@NonNull String str, int i4) {
        try {
            return this.f672a.getInt(str, i4);
        } catch (Throwable unused) {
            return i4;
        }
    }

    public void b(@NonNull String str, float f4) {
        try {
            this.f672a.edit().putFloat(str, f4).apply();
        } catch (Throwable unused) {
        }
    }

    public long a(@NonNull String str, long j4) {
        try {
            return this.f672a.getLong(str, j4);
        } catch (Throwable unused) {
            return j4;
        }
    }

    public void b(@NonNull String str, boolean z3) {
        try {
            this.f672a.edit().putBoolean(str, z3).apply();
        } catch (Throwable unused) {
        }
    }

    public float a(@NonNull String str, float f4) {
        try {
            return this.f672a.getFloat(str, f4);
        } catch (Throwable unused) {
            return f4;
        }
    }

    public boolean a(@NonNull String str) {
        return a(str, false);
    }

    public boolean a(@NonNull String str, boolean z3) {
        try {
            return this.f672a.getBoolean(str, z3);
        } catch (Throwable unused) {
            return z3;
        }
    }

    public void a() {
        try {
            this.f672a.edit().clear().commit();
        } catch (Throwable unused) {
        }
    }
}

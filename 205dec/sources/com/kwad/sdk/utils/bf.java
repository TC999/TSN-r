package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bf {
    static final String TAG = "bf";

    /* renamed from: com.kwad.sdk.utils.bf$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 extends az {
        final /* synthetic */ String aHZ;
        final /* synthetic */ String aRh;
        final /* synthetic */ Context gq;

        AnonymousClass1(Context context, String str, String str2) {
            this.gq = context;
            this.aRh = str;
            this.aHZ = str2;
        }

        public final void doTask() {
            bf.j(this.gq, this.aRh, this.aHZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, int i4) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putInt(str2, i4).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void au(String str, String str2) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().remove(str2).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(String str, String str2, int i4) {
        SharedPreferences gO = gO(str);
        return gO == null ? i4 : gO.getInt(str2, i4);
    }

    @Nullable
    public static SharedPreferences gO(String str) {
        try {
            return ServiceProvider.KO().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences gO = gO(str);
            if (gO != null && (string = gO.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !com.kwad.sdk.core.a.c.dJ(string)) ? string : com.kwad.sdk.core.a.c.dI(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(String str, String str2, String str3) {
        if (com.kwad.sdk.core.a.c.dJ(str)) {
            return;
        }
        i(str2, str3, com.kwad.sdk.core.a.c.dH(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(String str, String str2, boolean z3) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putBoolean(str2, z3).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m(String str, String str2, boolean z3) {
        SharedPreferences gO = gO(str);
        return gO == null ? z3 : gO.getBoolean(str2, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, long j4) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        gO.edit().putLong(str2, j4).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(String str, String str2, long j4) {
        SharedPreferences gO = gO(str);
        return gO == null ? j4 : gO.getLong(str2, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3, boolean z3) {
        try {
            SharedPreferences gO = gO(str);
            if (gO == null) {
                return;
            }
            if (z3 && !com.kwad.sdk.core.a.c.dJ(str3)) {
                gO.edit().putString(str2, com.kwad.sdk.core.a.c.dH(str3)).apply();
                return;
            }
            gO.edit().putString(str2, str3).apply();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences gO = gO(str);
        if (gO == null) {
            return;
        }
        SharedPreferences.Editor edit = gO.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}

package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* renamed from: com.kwad.sdk.utils.bf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11052bf {
    static final String TAG = "bf";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m23938a(String str, String str2, int i) {
        SharedPreferences m23931gO = m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        m23931gO.edit().putInt(str2, i).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: au */
    public static void m23934au(String str, String str2) {
        SharedPreferences m23931gO = m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        m23931gO.edit().remove(str2).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static int m23933b(String str, String str2, int i) {
        SharedPreferences m23931gO = m23931gO(str);
        return m23931gO == null ? i : m23931gO.getInt(str2, i);
    }

    @Nullable
    /* renamed from: gO */
    public static SharedPreferences m23931gO(String str) {
        try {
            return ServiceProvider.m24363KO().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static void m23930i(String str, String str2, String str3) {
        m23936a(str, str2, str3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static String m23929j(String str, String str2, String str3) {
        String string;
        try {
            SharedPreferences m23931gO = m23931gO(str);
            if (m23931gO != null && (string = m23931gO.getString(str2, str3)) != null && !TextUtils.isEmpty(string)) {
                return (TextUtils.equals(string, str3) || !C9886c.m27437dJ(string)) ? string : C9886c.m27438dI(string);
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static void m23928k(String str, String str2, String str3) {
        if (C9886c.m27437dJ(str)) {
            return;
        }
        m23930i(str2, str3, C9886c.m27439dH(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static void m23927l(String str, String str2, boolean z) {
        SharedPreferences m23931gO = m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        m23931gO.edit().putBoolean(str2, z).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static boolean m23926m(String str, String str2, boolean z) {
        SharedPreferences m23931gO = m23931gO(str);
        return m23931gO == null ? z : m23931gO.getBoolean(str2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m23937a(String str, String str2, long j) {
        SharedPreferences m23931gO = m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        m23931gO.edit().putLong(str2, j).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static long m23932b(String str, String str2, long j) {
        SharedPreferences m23931gO = m23931gO(str);
        return m23931gO == null ? j : m23931gO.getLong(str2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m23936a(String str, String str2, String str3, boolean z) {
        try {
            SharedPreferences m23931gO = m23931gO(str);
            if (m23931gO == null) {
                return;
            }
            if (z && !C9886c.m27437dJ(str3)) {
                m23931gO.edit().putString(str2, C9886c.m27439dH(str3)).apply();
                return;
            }
            m23931gO.edit().putString(str2, str3).apply();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T> void m23935a(String str, Map<String, T> map) {
        SharedPreferences m23931gO = m23931gO(str);
        if (m23931gO == null) {
            return;
        }
        SharedPreferences.Editor edit = m23931gO.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                m23939a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                C10331c.m26250e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    /* renamed from: a */
    private static void m23939a(SharedPreferences.Editor editor, String str, Object obj) {
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

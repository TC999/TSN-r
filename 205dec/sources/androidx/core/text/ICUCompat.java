package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            if (i4 < 24) {
                try {
                    sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e4) {
                    throw new IllegalStateException(e4);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            sGetScriptMethod = cls.getMethod("getScript", String.class);
            sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e5) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            Log.w("ICUCompat", e5);
        }
    }

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e4) {
            Log.w("ICUCompat", e4);
        } catch (InvocationTargetException e5) {
            Log.w("ICUCompat", e5);
        }
        return locale2;
    }

    private static String getScript(String str) {
        try {
            Method method = sGetScriptMethod;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e4) {
            Log.w("ICUCompat", e4);
        } catch (InvocationTargetException e5) {
            Log.w("ICUCompat", e5);
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i4 >= 21) {
            try {
                return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e4) {
                Log.w("ICUCompat", e4);
                return locale.getScript();
            } catch (InvocationTargetException e5) {
                Log.w("ICUCompat", e5);
                return locale.getScript();
            }
        }
        String addLikelySubtags = addLikelySubtags(locale);
        if (addLikelySubtags != null) {
            return getScript(addLikelySubtags);
        }
        return null;
    }
}

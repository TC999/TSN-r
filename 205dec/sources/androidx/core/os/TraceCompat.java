package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 18 || i4 >= 29) {
            return;
        }
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e4) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e4);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Trace.beginAsyncSection(str, i4);
        } else if (i5 >= 18) {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i4));
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Trace.endAsyncSection(str, i4);
        } else if (i5 >= 18) {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i4));
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            return Trace.isEnabled();
        }
        if (i4 >= 18) {
            try {
                return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Trace.setCounter(str, i4);
        } else if (i5 >= 18) {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i4));
            } catch (Exception unused) {
                Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}

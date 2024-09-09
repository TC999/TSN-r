package cn.jiguang.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.bq.d;
import cn.jiguang.f.c;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    private static int f2514b = 1048576;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2515a;

    /* renamed from: c  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2516c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f2517d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.jiguang.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class C0053a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f2518a = new a();
    }

    private a() {
        this.f2516c = null;
        this.f2515a = true;
        this.f2517d = new Object();
        this.f2515a = f(JConstants.getAppContext(null));
    }

    public static a a() {
        return C0053a.f2518a;
    }

    private JSONArray a(Context context, Throwable th) {
        String d4 = c.d(c.a(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int i4 = 0;
        if (!TextUtils.isEmpty(d4)) {
            try {
                JSONArray jSONArray2 = new JSONArray(d4);
                try {
                    i4 = d4.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i4, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i4, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + cn.jiguang.d.b.c(context);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i5 = 0;
        while (true) {
            jSONObject = null;
            try {
                if (i5 >= jSONArray.length()) {
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i5);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i5++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", b(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", cn.jiguang.f.a.m(context));
            PackageInfo a4 = cn.jiguang.f.a.a(context, 1);
            if (a4 != null) {
                String str = a4.versionName;
                if (str == null) {
                    str = "null";
                }
                jSONObject2.put("versionname", str);
                jSONObject2.put("versioncode", a4.versionCode + "");
            }
            if (i4 + jSONObject2.toString().length() < f2514b) {
                jSONArray.put(jSONObject2);
            } else {
                long j4 = -1;
                int i6 = 0;
                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("crashtime");
                        if (j4 == -1 || optLong < j4) {
                            i6 = i7;
                            j4 = optLong;
                        }
                    }
                }
                jSONArray.put(i6, jSONObject2);
            }
        }
        return jSONArray;
    }

    private void a(Context context, JSONArray jSONArray) {
        File a4;
        String jSONArray2 = jSONArray != null ? jSONArray.toString() : null;
        if (TextUtils.isEmpty(jSONArray2) || (a4 = c.a(context, "jpush_uncaughtexception_file")) == null) {
            return;
        }
        c.c(a4, jSONArray2);
    }

    private static void a(Context context, boolean z3) {
        try {
            context.getSharedPreferences("cn.jiguang.crash", 0).edit().putBoolean("KEY_IS_INIT", z3).apply();
        } catch (Throwable unused) {
        }
    }

    private void a(Throwable th) {
        if (this.f2515a) {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                d.l("JPushCrashHandler", "handleException failed: context is null");
                return;
            }
            JSONArray a4 = a(appContext, th);
            d(appContext);
            a(appContext, a4);
        }
    }

    private String b(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length > 1) {
                for (int length = split.length - 1; length >= 0; length--) {
                    if (!split[length].endsWith("Exception") && !split[length].endsWith("Error")) {
                    }
                    return split[length];
                }
                return th2;
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    public static JSONArray c(Context context) {
        String d4 = c.d(c.a(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(d4)) {
            return null;
        }
        try {
            return new JSONArray(d4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void d(Context context) {
        if (context == null) {
            d.i("JPushCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            c.a(c.a(context, "jpush_uncaughtexception_file"));
        }
    }

    private static boolean f(Context context) {
        try {
            return context.getSharedPreferences("cn.jiguang.crash", 0).getBoolean("KEY_IS_INIT", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void a(long j4) {
        synchronized (this.f2517d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (j4 < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (j4 == 0) {
                while (cn.jiguang.cm.d.b("FUTURE_TASK")) {
                    this.f2517d.wait(0L);
                }
            } else {
                long j5 = 0;
                while (cn.jiguang.cm.d.b("FUTURE_TASK")) {
                    long j6 = j4 - j5;
                    if (j6 <= 0) {
                        break;
                    }
                    this.f2517d.wait(j6);
                    j5 = System.currentTimeMillis() - currentTimeMillis;
                }
            }
        }
    }

    public void a(Context context) {
        if (this.f2515a) {
            return;
        }
        this.f2515a = true;
        d.c("JPushCrashHandler", "init caughtException");
        a(JConstants.getAppContext(context), this.f2515a);
    }

    public void b() {
        if (this.f2516c == null) {
            this.f2516c = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b(Context context) {
        if (this.f2515a) {
            d.c("JPushCrashHandler", "stop caughtException");
            this.f2515a = false;
            a(JConstants.getAppContext(context), this.f2515a);
        }
    }

    public void e(Context context) {
        if (context == null) {
            d.i("JPushCrashHandler", "Action - reportCrashLog context is null");
        } else if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.cm.d.a("FUTURE_TASK", new b());
            } catch (Throwable th) {
                d.l("JPushCrashHandler", "report crash e:" + th);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.f2515a) {
            d.a("JPushCrashHandler", "enable crash report");
            a(th);
            try {
                cn.jiguang.cm.d.a("FUTURE_TASK", new b());
                a(2000L);
            } catch (Throwable th2) {
                d.l("JPushCrashHandler", "report crash e:" + th2);
            }
        } else {
            d.a("JPushCrashHandler", "disable crash report");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2516c;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}

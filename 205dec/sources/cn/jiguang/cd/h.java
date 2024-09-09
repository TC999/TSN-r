package cn.jiguang.cd;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.ce.h;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.Thread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static h f3291a = new h();

    /* renamed from: c  reason: collision with root package name */
    private String f3293c;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3292b = null;

    /* renamed from: d  reason: collision with root package name */
    private g f3294d = new g();

    private h() {
    }

    public static h a() {
        return f3291a;
    }

    private JSONObject a(Context context, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "sentry_crash_log");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a4 = d.a(context, th);
            if (a4 != null && a4.length() != 0) {
                jSONObject2.put("sentry_envelope_item_header", d.a("event"));
                jSONObject2.put("sentry_envelope_item", a4);
                jSONArray.put(jSONObject2);
                jSONObject.put("sentry_envelope_header", d.a(true));
                JSONObject jSONObject3 = new JSONObject();
                cn.jiguang.ce.h a5 = this.f3294d.a();
                a5.a(h.a.Crashed, "", true);
                jSONObject3.put("sentry_envelope_item_header", d.a("session"));
                jSONObject3.put("sentry_envelope_item", d.a(context, a5));
                jSONArray.put(jSONObject3);
                jSONObject.put("sentry_envelope_items", jSONArray);
                return jSONObject;
            }
            return null;
        } catch (Throwable th2) {
            cn.jiguang.bq.d.l("SentryCrashHandler", "generalJSONLog error : " + th2.getMessage());
            return null;
        }
    }

    private Throwable b(Thread thread, Throwable th) {
        cn.jiguang.ce.b bVar = new cn.jiguang.ce.b();
        bVar.a(Boolean.FALSE);
        bVar.a("UncaughtExceptionHandler");
        return new c(bVar, th, thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, JSONObject jSONObject, String str) {
        File a4;
        String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
        if (TextUtils.isEmpty(jSONObject2) || (a4 = cn.jiguang.f.c.a(context, str)) == null) {
            return;
        }
        cn.jiguang.f.c.c(a4, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return "sentry" + File.separator + cn.jiguang.f.b.a() + ".envelope";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject c(Context context, String str) {
        String d4 = cn.jiguang.f.c.d(cn.jiguang.f.c.a(context, str));
        if (TextUtils.isEmpty(d4)) {
            return null;
        }
        try {
            return new JSONObject(d4);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        if (context == null) {
            cn.jiguang.bq.d.i("SentryCrashHandler", "Action - deleteCrashLog context is null");
        } else {
            cn.jiguang.f.c.a(cn.jiguang.f.c.a(context, str));
        }
    }

    public void a(final Context context) {
        cn.jiguang.bq.d.c("SentryCrashHandler", "init");
        this.f3294d.b();
        cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cd.h.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    cn.jiguang.ce.h a4 = h.this.f3294d.a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sentry_envelope_header", d.a(false));
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sentry_envelope_item_header", d.a("session"));
                    jSONObject2.put("sentry_envelope_item", d.a(context, a4));
                    jSONArray.put(jSONObject2);
                    jSONObject.put("sentry_envelope_items", jSONArray);
                    jSONObject.put("type", "sentry_crash_log");
                    cn.jiguang.bq.d.c("SentryCrashHandler", "session is " + jSONObject.toString());
                    h hVar = h.this;
                    hVar.f3293c = hVar.c();
                    h hVar2 = h.this;
                    hVar2.b(context, jSONObject, hVar2.f3293c);
                    h hVar3 = h.this;
                    hVar3.a(context, jSONObject, hVar3.f3293c);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void a(final Context context, final JSONObject jSONObject, final String str) {
        if (context == null) {
            cn.jiguang.bq.d.i("SentryCrashHandler", "Action - reportCrashLog context is null");
        } else if (cn.jiguang.d.b.a(context)) {
            try {
                cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cd.h.3
                    @Override // cn.jiguang.cm.b
                    public void a() {
                        cn.jiguang.bs.f.a(context, jSONObject, new ReportCallBack() { // from class: cn.jiguang.cd.h.3.1
                            @Override // cn.jiguang.api.ReportCallBack
                            public void onFinish(int i4) {
                                if (i4 == 0) {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    h.d(context, str);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("SentryCrashHandler", "report crash e:" + th);
            }
        }
    }

    public void a(Thread thread, Throwable th) {
        cn.jiguang.bq.d.c("SentryCrashHandler", "handleException catch exception");
        a(th);
    }

    public void a(Throwable th) {
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            cn.jiguang.bq.d.i("SentryCrashHandler", "handleException context is null");
            return;
        }
        d.b(appContext, th);
        if (i.a()) {
            try {
                JSONObject a4 = a(appContext, th);
                if (a4 == null) {
                    return;
                }
                cn.jiguang.bq.d.c("SentryCrashHandler", "crash log is : " + a4.toString());
                String c4 = c();
                this.f3293c = c4;
                b(appContext, a4, c4);
                a(appContext, a4, this.f3293c);
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        cn.jiguang.bq.d.c("SentryCrashHandler", "setUncaughtExceptionHandler");
        if (this.f3292b == null) {
            this.f3292b = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b(final Context context) {
        cn.jiguang.cm.d.a("DELAY_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cd.h.2
            @Override // cn.jiguang.cm.b
            public void a() {
                File[] listFiles;
                File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + "sentry");
                if (file.exists() && file.isDirectory() && file.canWrite() && file.canRead()) {
                    for (File file2 : file.listFiles(new FilenameFilter() { // from class: cn.jiguang.cd.h.2.1
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file3, String str) {
                            return str.endsWith(".envelope");
                        }
                    })) {
                        String str = "sentry" + File.separator + file2.getName();
                        JSONObject c4 = h.c(context, str);
                        if (c4 != null) {
                            h.this.a(context, c4, str);
                        }
                    }
                }
            }
        }, 10000);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        cn.jiguang.bq.d.c("SentryCrashHandler", "uncaughtException");
        a(b(thread, th));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3292b;
        if (uncaughtExceptionHandler == this || uncaughtExceptionHandler == null) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}

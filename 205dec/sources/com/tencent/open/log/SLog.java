package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.log.d;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f51751c;
    public static SLog instance;

    /* renamed from: a  reason: collision with root package name */
    protected a f51752a;

    /* renamed from: b  reason: collision with root package name */
    private Tracer f51753b;

    private SLog() {
    }

    private void d() {
        this.f51752a = new a(new b(a(), c.f51790m, c.f51784g, c.f51785h, c.f51780c, c.f51786i, 10, c.f51782e, c.f51791n));
    }

    public static final void e(String str, String str2) {
        getInstance().a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    SLog sLog = new SLog();
                    instance = sLog;
                    sLog.d();
                    f51751c = true;
                }
            }
        }
        return instance;
    }

    public static final void i(String str, String str2) {
        getInstance().a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static final void u(String str, String str2) {
        getInstance().a(32, str, str2, null);
    }

    public static final void v(String str, String str2) {
        getInstance().a(1, str, str2, null);
    }

    public static final void w(String str, String str2) {
        getInstance().a(8, str, str2, null);
    }

    protected void a(int i4, String str, String str2, Throwable th) {
        if (f51751c) {
            String b4 = com.tencent.open.utils.g.b();
            if (!TextUtils.isEmpty(b4)) {
                String str3 = b4 + " SDK_VERSION:3.5.13.lite";
                if (this.f51752a == null) {
                    return;
                }
                e.f51796a.a(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f51752a.a(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f51751c = false;
            }
        }
        e.f51796a.a(i4, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.f51779b, i4)) {
            a aVar = this.f51752a;
            if (aVar == null) {
                return;
            }
            aVar.a(i4, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
        Tracer tracer = this.f51753b;
        if (tracer != null) {
            try {
                tracer.a(i4, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
            } catch (Exception e4) {
                Log.e(str, "Exception", e4);
            }
        }
    }

    protected void b() {
        a aVar = this.f51752a;
        if (aVar != null) {
            aVar.a();
            this.f51752a.b();
            this.f51752a = null;
        }
    }

    protected void c() {
        a aVar = this.f51752a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f51753b = tracer;
    }

    public static final void e(String str, String str2, Throwable th) {
        getInstance().a(16, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        getInstance().a(4, str, str2, th);
    }

    public static final void u(String str, String str2, Throwable th) {
        getInstance().a(32, str, str2, th);
    }

    public static final void v(String str, String str2, Throwable th) {
        getInstance().a(1, str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        getInstance().a(8, str, str2, th);
    }

    public static final void d(String str, String str2) {
        getInstance().a(2, str, str2, null);
    }

    public static final void d(String str, String str2, Throwable th) {
        getInstance().a(2, str, str2, th);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "" : d.a(str) ? "xxxxxx" : str;
    }

    protected static File a() {
        String str = c.f51781d;
        try {
            d.c b4 = d.b.b();
            if (b4 != null && b4.c() > c.f51783f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.g.c(), str);
        } catch (Throwable th) {
            e("openSDK_LOG", "getLogFilePath:", th);
            return null;
        }
    }
}

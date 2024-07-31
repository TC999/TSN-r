package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.C13039d;
import com.tencent.open.utils.C13061g;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c */
    private static boolean f37351c;
    public static SLog instance;

    /* renamed from: a */
    protected C13036a f37352a;

    /* renamed from: b */
    private Tracer f37353b;

    private SLog() {
    }

    /* renamed from: d */
    private void m15132d() {
        this.f37352a = new C13036a(new C13037b(m15137a(), C13038c.f37390m, C13038c.f37384g, C13038c.f37385h, C13038c.f37380c, C13038c.f37386i, 10, C13038c.f37382e, C13038c.f37391n));
    }

    /* renamed from: e */
    public static final void m15129e(String str, String str2) {
        getInstance().m15136a(16, str, str2, null);
    }

    public static void flushLogs() {
        getInstance().m15133c();
    }

    public static SLog getInstance() {
        if (instance == null) {
            synchronized (SLog.class) {
                if (instance == null) {
                    SLog sLog = new SLog();
                    instance = sLog;
                    sLog.m15132d();
                    f37351c = true;
                }
            }
        }
        return instance;
    }

    /* renamed from: i */
    public static final void m15127i(String str, String str2) {
        getInstance().m15136a(4, str, str2, null);
    }

    public static void release() {
        synchronized (SLog.class) {
            getInstance().m15134b();
            if (instance != null) {
                instance = null;
            }
        }
    }

    /* renamed from: u */
    public static final void m15125u(String str, String str2) {
        getInstance().m15136a(32, str, str2, null);
    }

    /* renamed from: v */
    public static final void m15123v(String str, String str2) {
        getInstance().m15136a(1, str, str2, null);
    }

    /* renamed from: w */
    public static final void m15121w(String str, String str2) {
        getInstance().m15136a(8, str, str2, null);
    }

    /* renamed from: a */
    protected void m15136a(int i, String str, String str2, Throwable th) {
        if (f37351c) {
            String m15024b = C13061g.m15024b();
            if (!TextUtils.isEmpty(m15024b)) {
                String str3 = m15024b + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f37352a == null) {
                    return;
                }
                C13044e.f37396a.m15118a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                this.f37352a.m15118a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                f37351c = false;
            }
        }
        C13044e.f37396a.m15118a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (C13039d.C13040a.m15083a(C13038c.f37379b, i)) {
            C13036a c13036a = this.f37352a;
            if (c13036a == null) {
                return;
            }
            c13036a.m15118a(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
        Tracer tracer = this.f37353b;
        if (tracer != null) {
            try {
                tracer.m15118a(i, Thread.currentThread(), System.currentTimeMillis(), str, m15135a(str2), th);
            } catch (Exception e) {
                Log.e(str, "Exception", e);
            }
        }
    }

    /* renamed from: b */
    protected void m15134b() {
        C13036a c13036a = this.f37352a;
        if (c13036a != null) {
            c13036a.m15113a();
            this.f37352a.m15109b();
            this.f37352a = null;
        }
    }

    /* renamed from: c */
    protected void m15133c() {
        C13036a c13036a = this.f37352a;
        if (c13036a != null) {
            c13036a.m15113a();
        }
    }

    public void setCustomLogger(Tracer tracer) {
        this.f37353b = tracer;
    }

    /* renamed from: e */
    public static final void m15128e(String str, String str2, Throwable th) {
        getInstance().m15136a(16, str, str2, th);
    }

    /* renamed from: i */
    public static final void m15126i(String str, String str2, Throwable th) {
        getInstance().m15136a(4, str, str2, th);
    }

    /* renamed from: u */
    public static final void m15124u(String str, String str2, Throwable th) {
        getInstance().m15136a(32, str, str2, th);
    }

    /* renamed from: v */
    public static final void m15122v(String str, String str2, Throwable th) {
        getInstance().m15136a(1, str, str2, th);
    }

    /* renamed from: w */
    public static final void m15120w(String str, String str2, Throwable th) {
        getInstance().m15136a(8, str, str2, th);
    }

    /* renamed from: d */
    public static final void m15131d(String str, String str2) {
        getInstance().m15136a(2, str, str2, null);
    }

    /* renamed from: d */
    public static final void m15130d(String str, String str2, Throwable th) {
        getInstance().m15136a(2, str, str2, th);
    }

    /* renamed from: a */
    private String m15135a(String str) {
        return TextUtils.isEmpty(str) ? "" : C13039d.m15085a(str) ? "xxxxxx" : str;
    }

    /* renamed from: a */
    protected static File m15137a() {
        String str = C13038c.f37381d;
        try {
            C13039d.C13042c m15081b = C13039d.C13041b.m15081b();
            if (m15081b != null && m15081b.m15074c() > C13038c.f37383f) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(C13061g.m15023c(), str);
        } catch (Throwable th) {
            m15128e(TAG, "getLogFilePath:", th);
            return null;
        }
    }
}

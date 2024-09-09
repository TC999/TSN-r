package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.bytedance.sdk.component.ats_api.IEmbedAppLog;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f28328c = "";
    private static boolean sr = true;

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f28329w = "";
    private static volatile ExecutorService xv;

    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            sr = false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(f28328c)) {
            return f28328c;
        }
        if (TextUtils.isEmpty(f28328c)) {
            f();
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "-------------did = " + f28328c);
        return f28328c;
    }

    private static void f() {
        IEmbedAppLog iEmbedAppLog = (IEmbedAppLog) AutoService.c(IEmbedAppLog.class);
        if (iEmbedAppLog != null) {
            f28328c = iEmbedAppLog.getDid();
            c(f28328c);
        }
    }

    private static void r() {
        IEmbedAppLog iEmbedAppLog = (IEmbedAppLog) AutoService.c(IEmbedAppLog.class);
        if (iEmbedAppLog != null) {
            f28329w = iEmbedAppLog.getOAID();
        }
    }

    private static void ux() {
        if (xv == null) {
            synchronized (ia.class) {
                if (xv == null) {
                    xv = com.bytedance.msdk.adapter.sr.f.c("applog", 5, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.f.ia.1
                        @Override // java.util.concurrent.RejectedExecutionHandler
                        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                        }
                    });
                }
            }
        }
    }

    public static String w() {
        if (!TextUtils.isEmpty(f28329w)) {
            return f28329w;
        }
        if (TextUtils.isEmpty(f28329w)) {
            r();
        }
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "-------------oaid = " + f28329w);
        return f28329w;
    }

    public static boolean xv() {
        com.bytedance.msdk.adapter.sr.xv.w("TMe", "applogSOLoadSuccess = " + sr);
        return sr;
    }

    public static byte[] c(byte[] bArr, int i4) {
        IEmbedAppLog iEmbedAppLog = (IEmbedAppLog) AutoService.c(IEmbedAppLog.class);
        return iEmbedAppLog != null ? iEmbedAppLog.encrypt(bArr, i4) : new byte[0];
    }

    private static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ux();
        try {
            xv.execute(new Runnable() { // from class: com.bytedance.msdk.f.ia.2
                @Override // java.lang.Runnable
                public void run() {
                    ls.c(com.bytedance.msdk.core.c.getContext(), ia.f28328c);
                    if (TextUtils.isEmpty(ia.f28328c)) {
                        return;
                    }
                    com.bytedance.msdk.sr.sr.c();
                    com.bytedance.msdk.sr.sr.xv();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

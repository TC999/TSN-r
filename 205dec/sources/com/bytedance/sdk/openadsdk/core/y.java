package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class y {

    /* renamed from: f  reason: collision with root package name */
    private static w f35642f;

    /* renamed from: c  reason: collision with root package name */
    public static String f35641c = Environment.DIRECTORY_DCIM;

    /* renamed from: w  reason: collision with root package name */
    private static String f35644w = Environment.DIRECTORY_PICTURES;
    private static String xv = "Screenshots";
    private static volatile boolean sr = false;
    private static volatile boolean ux = false;

    /* renamed from: r  reason: collision with root package name */
    private static long f35643r = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(String str);
    }

    private static File f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ux() {
        if (sr) {
            return;
        }
        com.bytedance.sdk.component.utils.a.c("SSO start");
        File f4 = f();
        if (f4 == null) {
            return;
        }
        f35642f = w.c(f4, new c() { // from class: com.bytedance.sdk.openadsdk.core.y.2
            @Override // com.bytedance.sdk.openadsdk.core.y.c
            public void c(String str) {
                long unused = y.f35643r = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.a.c("Update sso");
            }
        });
        sr = true;
        StringBuilder sb = new StringBuilder();
        sb.append("SSO File exist: ");
        sb.append(f4.exists());
        sb.append(", has started: ");
        sb.append(f35642f != null);
        com.bytedance.sdk.component.utils.a.c(sb.toString());
        w wVar = f35642f;
        if (wVar != null) {
            wVar.startWatching();
        }
    }

    public static void w() {
        ux = true;
        if (sr) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (ls.getContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.gd.ev.sr(new com.bytedance.sdk.component.gd.p("sso") { // from class: com.bytedance.sdk.openadsdk.core.y.1
            @Override // java.lang.Runnable
            public void run() {
                y.ux();
            }
        });
    }

    public static long xv() {
        return f35643r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w extends FileObserver {

        /* renamed from: c  reason: collision with root package name */
        private c f35660c;

        private w(String str, int i4, c cVar) {
            super(str, i4);
            this.f35660c = cVar;
        }

        static w c(File file, c cVar) {
            if (file == null || cVar == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return new w(file, 256, cVar);
            }
            return new w(file.getAbsolutePath(), 256, cVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i4, String str) {
            c cVar = this.f35660c;
            if (cVar != null) {
                cVar.c(str);
            }
        }

        private w(File file, int i4, c cVar) {
            super(file, i4);
            this.f35660c = cVar;
        }
    }

    public static void c() {
        if (!ux || sr) {
            return;
        }
        try {
            w();
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("ScreenShotObserver", "\u6743\u9650\u68c0\u67e5\u51fa\u9519\u65f6,\u5f02\u5e38\u4ee3\u7801\uff1a" + e4);
        }
    }
}

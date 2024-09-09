package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.s;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static void c(final Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.component.f.xv.c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (s.c(context)) {
                    com.bytedance.sdk.openadsdk.n.f.c(new p("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.sr.1
                        @Override // java.lang.Runnable
                        public void run() {
                            sr.xv(context);
                        }
                    });
                    return;
                }
                String w3 = s.w(context);
                try {
                    if (TextUtils.isEmpty(w3)) {
                        w3 = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(w3);
                } catch (IllegalStateException unused) {
                    c(w3);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            a.xv(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(Context context) {
        String str;
        RandomAccessFile randomAccessFile;
        Throwable th;
        String c4 = c();
        if (TextUtils.isEmpty(c4)) {
            str = "webview";
        } else {
            str = "webview_" + c4;
        }
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(context, str, 0).getPath(), "webview_data.lock");
        a.xv("TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock tryLock = randomAccessFile.getChannel().tryLock();
                    if (tryLock != null) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            tryLock.close();
                        }
                    } else {
                        c(file, file.delete());
                    }
                    com.bytedance.sdk.component.ux.xv.xv.w.c(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    c(file, file.exists() ? file.delete() : false);
                    com.bytedance.sdk.component.ux.xv.xv.w.c(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.ux.xv.xv.w.c(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th3) {
                randomAccessFile = randomAccessFile2;
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private static void c(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(File file, boolean z3) {
        if (!z3 || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private static String c() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}

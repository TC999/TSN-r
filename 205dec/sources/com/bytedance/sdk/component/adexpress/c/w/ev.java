package com.bytedance.sdk.component.adexpress.c.w;

import com.bytedance.sdk.component.utils.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    private static com.bytedance.sdk.component.adexpress.c.xv.c f29023c;

    public static void c() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(ux.r(), "temp_pkg_info.json");
                Long valueOf = Long.valueOf(file.length());
                if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        com.bytedance.sdk.component.adexpress.c.xv.c c4 = com.bytedance.sdk.component.adexpress.c.xv.c.c(new JSONObject(new String(bArr, "utf-8")));
                        if (c4 != null) {
                            f29023c = c4;
                            a.w("Version", "old version read success: " + f29023c.xv());
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            a.xv("Version", "version init error", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th3;
                        }
                    }
                } else {
                    a.w("Version", "version pkg json file does not exist");
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException unused2) {
        }
    }

    public static void sr() {
        xv.w(ux.r(), w(), "temp_pkg_info.json");
        f29023c = null;
    }

    public static synchronized com.bytedance.sdk.component.adexpress.c.xv.c w() {
        com.bytedance.sdk.component.adexpress.c.xv.c cVar;
        synchronized (ev.class) {
            cVar = f29023c;
        }
        return cVar;
    }

    public static void xv() {
        xv.c(ux.r(), w(), "temp_pkg_info.json");
    }

    public static boolean w(com.bytedance.sdk.component.adexpress.c.xv.c cVar) {
        return xv.xv(w(), cVar);
    }

    public static synchronized void c(com.bytedance.sdk.component.adexpress.c.xv.c cVar) {
        synchronized (ev.class) {
            if (cVar != null) {
                if (cVar.f()) {
                    f29023c = cVar;
                }
            }
        }
    }

    public static boolean c(String str) {
        return xv.c(w(), str);
    }
}

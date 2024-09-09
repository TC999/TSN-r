package com.kwad.components.core.h;

import android.content.Context;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static final class C0634a {
        private static final a LT = new a((byte) 0);
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    private static File Z(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    public static a oE() {
        return C0634a.LT;
    }

    public final void Y(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        g.schedule(new Runnable() { // from class: com.kwad.components.core.h.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(context, currentTimeMillis);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j4) {
        File[] listFiles = Z(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.h.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(".apk");
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j5 = 0;
        for (File file : listFiles) {
            j5 = Math.max(j5, file.lastModified());
        }
        long min = Math.min(j4, j5);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }
}

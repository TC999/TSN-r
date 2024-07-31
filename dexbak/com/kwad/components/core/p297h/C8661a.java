package com.kwad.components.core.p297h;

import android.content.Context;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11095g;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.components.core.h.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8661a {

    /* renamed from: com.kwad.components.core.h.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static final class C8664a {

        /* renamed from: LT */
        private static final C8661a f28322LT = new C8661a((byte) 0);
    }

    /* synthetic */ C8661a(byte b) {
        this();
    }

    /* renamed from: Z */
    private static File m30053Z(Context context) {
        return new File(context.getApplicationInfo().dataDir, "ksad_dynamic");
    }

    /* renamed from: oE */
    public static C8661a m30050oE() {
        return C8664a.f28322LT;
    }

    /* renamed from: Y */
    public final void m30054Y(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        C11095g.schedule(new Runnable() { // from class: com.kwad.components.core.h.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C8661a.this.m30052a(context, currentTimeMillis);
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private C8661a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30052a(Context context, long j) {
        File[] listFiles = m30053Z(context).listFiles(new FileFilter() { // from class: com.kwad.components.core.h.a.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                String name = file.getName();
                return name.startsWith("dynamic-") && name.endsWith(".apk");
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        long j2 = 0;
        for (File file : listFiles) {
            j2 = Math.max(j2, file.lastModified());
        }
        long min = Math.min(j, j2);
        for (File file2 : listFiles) {
            if (file2.exists() && file2.lastModified() < min) {
                file2.delete();
            }
        }
    }
}

package com.kwad.sdk.crash.utils;

import android.os.Build;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* renamed from: com.kwad.sdk.crash.utils.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10742f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.crash.utils.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractC10743a {
        private AbstractC10743a() {
        }

        /* renamed from: Ie */
        abstract Object mo24997Ie();

        abstract void println(Object obj);

        /* synthetic */ AbstractC10743a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.crash.utils.f$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10744b extends AbstractC10743a {
        private final PrintWriter aHN;

        C10744b(PrintWriter printWriter) {
            super((byte) 0);
            this.aHN = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.C10742f.AbstractC10743a
        /* renamed from: Ie */
        final Object mo24997Ie() {
            return this.aHN;
        }

        @Override // com.kwad.sdk.crash.utils.C10742f.AbstractC10743a
        final void println(Object obj) {
            this.aHN.println(obj);
        }
    }

    /* renamed from: a */
    public static void m24998a(Throwable th, PrintWriter printWriter) {
        m25000a(th, new C10744b(printWriter));
    }

    /* renamed from: a */
    private static void m25000a(Throwable th, AbstractC10743a abstractC10743a) {
        StackTraceElement[] stackTrace;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        synchronized (abstractC10743a.mo24997Ie()) {
            abstractC10743a.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                abstractC10743a.println("\tat " + stackTraceElement);
            }
            int i = Build.VERSION.SDK_INT;
            Throwable cause = th.getCause();
            if (cause != null) {
                m24999a(cause, abstractC10743a, "Caused by: ", "", newSetFromMap);
            }
        }
    }

    /* renamed from: a */
    private static void m24999a(Throwable th, AbstractC10743a abstractC10743a, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            abstractC10743a.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                abstractC10743a.println(str2 + "\tat " + stackTraceElement);
            }
            int i = Build.VERSION.SDK_INT;
            th = th.getCause();
            if (th == null) {
                return;
            }
            str = "Caused by: ";
        }
        abstractC10743a.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }
}

package com.kwad.components.core.p318p;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import com.kwad.sdk.service.C10973b;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.kwad.components.core.p.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8770b {

    /* renamed from: Se */
    private static volatile C8770b f28477Se = null;

    /* renamed from: Sf */
    private static volatile int f28478Sf = 204800;

    /* renamed from: Sg */
    static volatile boolean f28479Sg = true;

    /* renamed from: Sh */
    static volatile boolean f28480Sh;

    /* renamed from: Si */
    static volatile Set<C8771c> f28481Si = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: a */
    public static synchronized void m29883a(C8771c c8771c) {
        synchronized (C8770b.class) {
            if (f28481Si.contains(c8771c)) {
                f28481Si.remove(c8771c);
            }
        }
    }

    /* renamed from: f */
    public static void m29882f(boolean z, int i) {
        if (i > 0) {
            f28478Sf = i * 1024;
        }
        f28479Sg = z;
    }

    /* renamed from: qA */
    public static C8770b m29881qA() {
        if (f28477Se == null) {
            synchronized (C8770b.class) {
                if (f28477Se == null) {
                    f28477Se = new C8770b();
                }
            }
        }
        return f28477Se;
    }

    /* renamed from: qB */
    public static boolean m29880qB() {
        return f28479Sg;
    }

    /* renamed from: qC */
    public static int m29879qC() {
        return f28478Sf / 1024;
    }

    @InvokeBy(invokerClass = C10973b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            C10973b.m24290b(SpeedLimitApi.class, C8769a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        C8771c c8771c;
        synchronized (C8770b.class) {
            c8771c = new C8771c(inputStream, f28478Sf / (f28481Si.size() + 1));
            f28481Si.add(c8771c);
        }
        return c8771c;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    /* renamed from: qD */
    public final synchronized int m29878qD() {
        int i;
        i = 0;
        try {
            for (C8771c c8771c : f28481Si) {
                i += (int) c8771c.m29875qE();
            }
        } catch (Exception unused) {
        }
        return i;
    }
}

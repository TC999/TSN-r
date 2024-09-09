package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {
    private static volatile b Se = null;
    private static volatile int Sf = 204800;
    static volatile boolean Sg = true;
    static volatile boolean Sh;
    static volatile Set<c> Si = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (Si.contains(cVar)) {
                Si.remove(cVar);
            }
        }
    }

    public static void f(boolean z3, int i4) {
        if (i4 > 0) {
            Sf = i4 * 1024;
        }
        Sg = z3;
    }

    public static b qA() {
        if (Se == null) {
            synchronized (b.class) {
                if (Se == null) {
                    Se = new b();
                }
            }
        }
        return Se;
    }

    public static boolean qB() {
        return Sg;
    }

    public static int qC() {
        return Sf / 1024;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, Sf / (Si.size() + 1));
            Si.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int qD() {
        int i4;
        i4 = 0;
        try {
            for (c cVar : Si) {
                i4 += (int) cVar.qE();
            }
        } catch (Exception unused) {
        }
        return i4;
    }
}

package com.kwad.sdk.core.response.p409b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11031aw;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.nio.charset.Charset;

/* renamed from: com.kwad.sdk.core.response.b.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10488f {
    private static volatile C10488f azT;
    private String azU = m25620Fk();

    private C10488f() {
    }

    /* renamed from: Fi */
    public static C10488f m25622Fi() {
        if (azT == null) {
            synchronized (C10488f.class) {
                if (azT == null) {
                    azT = new C10488f();
                }
            }
        }
        return azT;
    }

    @Nullable
    @WorkerThread
    /* renamed from: Fk */
    private static String m25620Fk() {
        try {
            return C11122q.m23729a(new File(C11031aw.m23991cP(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }

    @WorkerThread
    /* renamed from: er */
    private static void m25618er(String str) {
        try {
            C11122q.m23730a(new File(C11031aw.m23991cP(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    @Nullable
    @WorkerThread
    /* renamed from: Fj */
    public final String m25621Fj() {
        return this.azU;
    }

    @WorkerThread
    /* renamed from: eq */
    public final void m25619eq(String str) {
        if (C11053bg.isEquals(this.azU, str)) {
            return;
        }
        this.azU = str;
        m25618er(str);
    }
}

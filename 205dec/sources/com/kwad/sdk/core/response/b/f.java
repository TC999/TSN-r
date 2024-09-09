package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f {
    private static volatile f azT;
    private String azU = Fk();

    private f() {
    }

    public static f Fi() {
        if (azT == null) {
            synchronized (f.class) {
                if (azT == null) {
                    azT = new f();
                }
            }
        }
        return azT;
    }

    @Nullable
    @WorkerThread
    private static String Fk() {
        try {
            return q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return null;
        }
    }

    @WorkerThread
    private static void er(String str) {
        try {
            q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
        }
    }

    @Nullable
    @WorkerThread
    public final String Fj() {
        return this.azU;
    }

    @WorkerThread
    public final void eq(String str) {
        if (bg.isEquals(this.azU, str)) {
            return;
        }
        this.azU = str;
        er(str);
    }
}

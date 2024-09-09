package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.m;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class u {
    private static final AtomicBoolean ank = new AtomicBoolean();

    private static String Al() {
        String ca = com.kwad.sdk.api.c.ca("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(ca) ? ca : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.c.zW()) {
            return;
        }
        AtomicBoolean atomicBoolean = ank;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.b.a(new com.kwad.sdk.api.a.a() { // from class: com.kwad.sdk.api.loader.u.1
            @Override // com.kwad.sdk.api.a.a
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - t.x(context, "lastUpdateTime")) < t.x(context, "interval") * 1000) {
                        return;
                    }
                    m.Aj().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                        @Override // com.kwad.sdk.api.loader.v
                        public final String Am() {
                            return u.access$000();
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final IKsAdSDK An() {
                            return iKsAdSDK;
                        }

                        @Override // com.kwad.sdk.api.loader.v
                        public final Context getContext() {
                            return context;
                        }
                    }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                        private static void c(Boolean bool) {
                            a.a.a(bool);
                        }

                        @Override // com.kwad.sdk.api.loader.m.c
                        public final /* synthetic */ void g(Boolean bool) {
                            c(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void aF(Context context) {
        g.m(context, "");
    }

    static /* synthetic */ String access$000() {
        return Al();
    }
}

package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        g.execute(new ay() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0691a dp = com.kwad.sdk.core.diskcache.a.a.this.dp(str2);
                    if (dp != null) {
                        outputStream = dp.cZ(0);
                        if (b.a(str, outputStream, new a.C0699a())) {
                            dp.commit();
                        } else {
                            dp.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.m91do(str);
            if (cVar != null) {
                try {
                    File dc = cVar.dc(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dc;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0699a c0699a) {
        boolean z3 = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0691a dp = aVar.dp(str2);
                if (dp != null) {
                    outputStream = dp.cZ(0);
                    if (a(str, outputStream, c0699a)) {
                        dp.commit();
                        z3 = true;
                    } else {
                        dp.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e4) {
                c0699a.msg = e4.getMessage();
            }
            return z3;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0699a c0699a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0699a, -1L, null);
    }
}

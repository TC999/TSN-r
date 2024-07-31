package com.kwad.sdk.core.diskcache.p394b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.p393a.C10281a;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.kwad.sdk.core.diskcache.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10293b {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m26387a(@NonNull final C10281a c10281a, @NonNull final String str, @NonNull final String str2) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    C10281a.C10285a m26424dp = C10281a.this.m26424dp(str2);
                    if (m26424dp != null) {
                        outputStream = m26424dp.m26413cZ(0);
                        if (C10293b.m26385a(str, outputStream, new C10404a.C10405a())) {
                            m26424dp.commit();
                        } else {
                            m26424dp.abort();
                        }
                        C10281a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    C10738b.closeQuietly(outputStream);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static File m26388a(@NonNull C10281a c10281a, @NonNull String str) {
        C10281a.C10288c c10288c;
        C10281a.C10288c c10288c2 = null;
        try {
            c10288c = c10281a.m26425do(str);
            if (c10288c != null) {
                try {
                    File m26398dc = c10288c.m26398dc(0);
                    C10738b.closeQuietly(c10288c);
                    return m26398dc;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    c10288c2 = c10288c;
                    C10738b.closeQuietly(c10288c2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            c10288c = null;
        } catch (Throwable th2) {
            th = th2;
        }
        C10738b.closeQuietly(c10288c);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m26386a(@NonNull C10281a c10281a, @NonNull String str, @NonNull String str2, C10404a.C10405a c10405a) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                C10281a.C10285a m26424dp = c10281a.m26424dp(str2);
                if (m26424dp != null) {
                    outputStream = m26424dp.m26413cZ(0);
                    if (m26385a(str, outputStream, c10405a)) {
                        m26424dp.commit();
                        z = true;
                    } else {
                        m26424dp.abort();
                    }
                    c10281a.flush();
                }
            } catch (IOException e) {
                c10405a.msg = e.getMessage();
            }
            return z;
        } finally {
            C10738b.closeQuietly(outputStream);
        }
    }

    /* renamed from: a */
    public static boolean m26385a(String str, OutputStream outputStream, C10404a.C10405a c10405a) {
        return C10404a.m26173a(str, outputStream, c10405a, -1L, null);
    }
}

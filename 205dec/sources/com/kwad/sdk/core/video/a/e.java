package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private static boolean TL = false;
    private static AtomicBoolean aBq = null;
    private static int aBr = -1;
    private static final AtomicBoolean aBs = new AtomicBoolean(false);
    private static final AtomicBoolean aBt = new AtomicBoolean(false);
    private static int aBu;

    private static boolean Ax() {
        return aBt.get() || com.kwad.framework.a.a.Iv.booleanValue();
    }

    public static int Gf() {
        return aBu;
    }

    private static boolean Gg() {
        AtomicBoolean atomicBoolean = aBq;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aBq = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(@NonNull Context context, boolean z3, boolean z4, boolean z5, int i4) {
        boolean z6;
        b bVar;
        b bVar2;
        try {
            if (Ax() && z4 && Gg()) {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i4);
                aBu = 2;
                dVar.bn(z3);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.e.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aBu = 1;
                bVar2 = bVar3;
            }
            z6 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!TL) {
                TL = true;
                com.kwad.sdk.service.c.gatherException(th);
            }
            b bVar4 = new b();
            aBu = 1;
            z6 = true;
            bVar = bVar4;
        }
        int a4 = an.a(Ax(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp(), z4, Gg(), z6, z5, bVar.getMediaPlayerType());
        com.kwad.sdk.core.e.c.T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a4));
        if (aBr != a4) {
            aBr = a4;
            dq(a4);
        }
        return bVar;
    }

    private static void dq(int i4) {
        n nVar = new n(10212L);
        nVar.ayp = i4;
        g.a2(nVar);
    }
}

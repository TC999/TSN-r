package com.kwad.sdk.core.video.p411a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.report.C10455g;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11021an;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.core.video.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10535e {

    /* renamed from: TL */
    private static boolean f29595TL = false;
    private static AtomicBoolean aBq = null;
    private static int aBr = -1;
    private static final AtomicBoolean aBs = new AtomicBoolean(false);
    private static final AtomicBoolean aBt = new AtomicBoolean(false);
    private static int aBu;

    /* renamed from: Ax */
    private static boolean m25528Ax() {
        return aBt.get() || C9425a.f29472Iv.booleanValue();
    }

    /* renamed from: Gf */
    public static int m25527Gf() {
        return aBu;
    }

    /* renamed from: Gg */
    private static boolean m25526Gg() {
        AtomicBoolean atomicBoolean = aBq;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aBq = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static InterfaceC10522c m25525a(@NonNull Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        C10520b c10520b;
        C10520b c10520b2;
        try {
            if (m25528Ax() && z2 && m25526Gg()) {
                C10331c.m26248i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                C10532d c10532d = new C10532d(i);
                aBu = 2;
                c10532d.m25530bn(z);
                c10520b2 = c10532d;
            } else {
                C10331c.m26248i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                C10520b c10520b3 = new C10520b();
                aBu = 1;
                c10520b2 = c10520b3;
            }
            z4 = false;
            c10520b = c10520b2;
        } catch (Throwable th) {
            C10331c.m26249e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!f29595TL) {
                f29595TL = true;
                C10974c.gatherException(th);
            }
            C10520b c10520b4 = new C10520b();
            aBu = 1;
            z4 = true;
            c10520b = c10520b4;
        }
        int m24093a = C11021an.m24093a(m25528Ax(), ServiceProvider.get(InterfaceC10968f.class) != null && ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24339yp(), z2, m25526Gg(), z4, z3, c10520b.getMediaPlayerType());
        C10331c.m26257T("KwaiPlayHelper", "player v=" + Integer.toBinaryString(m24093a));
        if (aBr != m24093a) {
            aBr = m24093a;
            m25524dq(m24093a);
        }
        return c10520b;
    }

    /* renamed from: dq */
    private static void m25524dq(int i) {
        C10464n c10464n = new C10464n(10212L);
        c10464n.ayp = i;
        C10455g.m26032a(c10464n);
    }
}

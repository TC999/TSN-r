package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.z;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong ayZ = new AtomicLong(-1);
    protected final l<T> axm;
    protected final b<T, R> aza;
    protected final AtomicInteger azb;
    protected final Context mContext;

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.axm = lVar;
        this.aza = bVar;
        this.azb = atomicInteger;
    }

    private void A(@NonNull List<T> list) {
        List d4 = z.d(list, 200);
        int size = d4.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i4 = 0; i4 < size; i4++) {
            this.aza.a((List) d4.get(i4), atomicBoolean);
        }
    }

    private void EX() {
        long MU = bi.MU();
        if (MU >= ayZ.get() * 2) {
            try {
                List<T> EI = this.axm.EI();
                if (EI.isEmpty()) {
                    return;
                }
                A(EI);
            } catch (OutOfMemoryError e4) {
                ayZ.set(MU);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e4);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.azb.get() > 0 || !ag.isNetworkConnected(this.mContext)) {
            return;
        }
        EX();
    }
}

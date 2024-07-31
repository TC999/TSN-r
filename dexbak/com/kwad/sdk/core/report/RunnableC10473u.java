package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.report.AbstractC10453e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11139z;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.kwad.sdk.core.report.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RunnableC10473u<T extends AbstractC10453e, R extends InterfaceC10420f> implements Runnable {
    private static AtomicLong ayZ = new AtomicLong(-1);
    protected final InterfaceC10462l<T> axm;
    protected final AbstractC10444b<T, R> aza;
    protected final AtomicInteger azb;
    protected final Context mContext;

    public RunnableC10473u(Context context, InterfaceC10462l<T> interfaceC10462l, AbstractC10444b<T, R> abstractC10444b, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.axm = interfaceC10462l;
        this.aza = abstractC10444b;
        this.azb = atomicInteger;
    }

    /* renamed from: A */
    private void m25999A(@NonNull List<T> list) {
        List m23566d = C11139z.m23566d(list, 200);
        int size = m23566d.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.aza.m26052a((List) m23566d.get(i), atomicBoolean);
        }
    }

    /* renamed from: EX */
    private void m25998EX() {
        long m23913MU = C11059bi.m23913MU();
        if (m23913MU >= ayZ.get() * 2) {
            try {
                List<T> mo26020EI = this.axm.mo26020EI();
                if (mo26020EI.isEmpty()) {
                    return;
                }
                m25999A(mo26020EI);
            } catch (OutOfMemoryError e) {
                ayZ.set(m23913MU);
                ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(e);
            } catch (Throwable th) {
                ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.azb.get() > 0 || !C11013ag.isNetworkConnected(this.mContext)) {
            return;
        }
        m25998EX();
    }
}

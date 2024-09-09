package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private final List<a> Rp;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void qp();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.request.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0648b {
        private static final b Rq = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    public static b qn() {
        return C0648b.Rq;
    }

    public final void a(a aVar) {
        this.Rp.add(aVar);
    }

    public final void b(a aVar) {
        this.Rp.remove(aVar);
    }

    public final void qo() {
        for (a aVar : this.Rp) {
            if (aVar != null) {
                try {
                    aVar.qp();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private b() {
        this.Rp = new CopyOnWriteArrayList();
    }
}

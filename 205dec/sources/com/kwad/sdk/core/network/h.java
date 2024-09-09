package com.kwad.sdk.core.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h {
    private static volatile h avN;
    private List<a> avM = new CopyOnWriteArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(f fVar, int i4);
    }

    private h() {
    }

    public static h DN() {
        if (avN == null) {
            synchronized (h.class) {
                if (avN == null) {
                    avN = new h();
                }
            }
        }
        return avN;
    }

    public final void a(a aVar) {
        this.avM.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(f fVar, int i4) {
        for (a aVar : this.avM) {
            aVar.a(fVar, i4);
        }
    }
}

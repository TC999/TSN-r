package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {
    private Map<Integer, AdResultData> Je = new ConcurrentHashMap();
    private AtomicInteger Jf = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        static f Jg = new f();
    }

    public static f mE() {
        return a.Jg;
    }

    public final AdResultData d(int i4, boolean z3) {
        AdResultData adResultData = this.Je.get(Integer.valueOf(i4));
        this.Je.remove(Integer.valueOf(i4));
        return adResultData;
    }

    public final int i(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.Jf.incrementAndGet();
        this.Je.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}

package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {
    private Map<String, List<AdTemplate>> qe;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final i qf = new i((byte) 0);
    }

    /* synthetic */ i(byte b4) {
        this();
    }

    public static i gj() {
        return a.qf;
    }

    public final void B(String str) {
        this.qe.remove(str);
    }

    private i() {
        this.qe = new ConcurrentHashMap();
    }
}

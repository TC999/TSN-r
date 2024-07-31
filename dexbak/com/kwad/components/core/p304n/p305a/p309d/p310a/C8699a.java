package com.kwad.components.core.p304n.p305a.p309d.p310a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.core.n.a.d.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8699a {

    /* renamed from: Mw */
    private static final Map<Integer, WeakReference<AdResultData>> f28364Mw = new HashMap();

    /* renamed from: a */
    public static void m30006a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        f28364Mw.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    /* renamed from: at */
    public static AdResultData m30005at(int i) {
        WeakReference<AdResultData> weakReference = f28364Mw.get(Integer.valueOf(i));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}

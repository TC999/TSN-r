package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cm {
    @InvokeBy(invokerClass = ft.class, methodId = "registerHolder")
    public static void Dz() {
        ft.DA().put(ImpInfo.class, new fb());
        ft.DA().put(b.a.class, new bi());
    }
}

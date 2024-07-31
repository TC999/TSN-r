package com.kwad.sdk.core.network.p405b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;

/* renamed from: com.kwad.sdk.core.network.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10413c {
    /* renamed from: Ej */
    public static InterfaceC10412b m26155Ej() {
        InterfaceC10970h interfaceC10970h = (InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class);
        if (interfaceC10970h != null && interfaceC10970h.mo24314yJ()) {
            return new C10414d();
        }
        return new C10411a();
    }
}

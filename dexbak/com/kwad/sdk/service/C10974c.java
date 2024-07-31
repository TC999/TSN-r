package com.kwad.sdk.service;

import com.kwad.sdk.service.p449a.InterfaceC10965c;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.service.p449a.InterfaceC10969g;

/* renamed from: com.kwad.sdk.service.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10974c {
    /* renamed from: G */
    public static void m24287G(String str, String str2) {
        InterfaceC10967e interfaceC10967e = (InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class);
        if (interfaceC10967e != null) {
            interfaceC10967e.mo24347G(str, str2);
        }
    }

    /* renamed from: a */
    public static void m24286a(InterfaceC10969g interfaceC10969g) {
        InterfaceC10967e interfaceC10967e = (InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class);
        if (interfaceC10967e != null) {
            interfaceC10967e.mo24345a(interfaceC10969g);
        }
    }

    /* renamed from: b */
    public static void m24285b(InterfaceC10965c interfaceC10965c) {
        InterfaceC10967e interfaceC10967e = (InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class);
        if (interfaceC10967e != null) {
            interfaceC10967e.mo24346a(interfaceC10965c);
        }
    }

    public static void gatherException(Throwable th) {
        InterfaceC10967e interfaceC10967e = (InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class);
        if (interfaceC10967e != null) {
            interfaceC10967e.gatherException(th);
        }
    }
}

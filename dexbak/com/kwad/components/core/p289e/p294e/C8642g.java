package com.kwad.components.core.p289e.p294e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.e.e.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8642g {

    /* renamed from: Lu */
    private final List<InterfaceC8641f> f28285Lu;

    /* renamed from: com.kwad.components.core.e.e.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8643a {

        /* renamed from: Lv */
        private static final C8642g f28286Lv = new C8642g((byte) 0);
    }

    /* synthetic */ C8642g(byte b) {
        this();
    }

    /* renamed from: or */
    public static C8642g m30090or() {
        return C8643a.f28286Lv;
    }

    /* renamed from: a */
    public final void m30092a(InterfaceC8641f interfaceC8641f) {
        this.f28285Lu.add(interfaceC8641f);
    }

    /* renamed from: b */
    public final void m30091b(InterfaceC8641f interfaceC8641f) {
        if (interfaceC8641f != null) {
            this.f28285Lu.remove(interfaceC8641f);
        }
    }

    /* renamed from: os */
    public final void m30089os() {
        for (InterfaceC8641f interfaceC8641f : this.f28285Lu) {
            interfaceC8641f.show();
        }
    }

    /* renamed from: ot */
    public final void m30088ot() {
        for (InterfaceC8641f interfaceC8641f : this.f28285Lu) {
            interfaceC8641f.dismiss();
        }
    }

    private C8642g() {
        this.f28285Lu = new CopyOnWriteArrayList();
    }
}

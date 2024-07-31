package com.kwad.sdk.p443m.p444a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.m.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10860a {
    private final List<InterfaceC10861b> aNf = new ArrayList();

    public final void addBackPressable(InterfaceC10861b interfaceC10861b) {
        if (interfaceC10861b != null) {
            this.aNf.add(interfaceC10861b);
        }
    }

    public final boolean onBackPressed() {
        for (InterfaceC10861b interfaceC10861b : this.aNf) {
            if (interfaceC10861b.onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(InterfaceC10861b interfaceC10861b) {
        if (interfaceC10861b != null) {
            this.aNf.remove(interfaceC10861b);
        }
    }

    public final void addBackPressable(InterfaceC10861b interfaceC10861b, int i) {
        if (interfaceC10861b != null) {
            this.aNf.add(i, interfaceC10861b);
        }
    }
}

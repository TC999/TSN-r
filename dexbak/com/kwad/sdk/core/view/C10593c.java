package com.kwad.sdk.core.view;

import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.sdk.core.view.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10593c {
    private List<InterfaceC10592b> aDH = new CopyOnWriteArrayList();

    /* renamed from: a */
    public final void m25359a(InterfaceC10592b interfaceC10592b) {
        this.aDH.add(interfaceC10592b);
    }

    /* renamed from: b */
    public final void m25358b(InterfaceC10592b interfaceC10592b) {
        this.aDH.remove(interfaceC10592b);
    }

    /* renamed from: j */
    public final void m25357j(View view, boolean z) {
        for (InterfaceC10592b interfaceC10592b : this.aDH) {
            interfaceC10592b.mo25360i(view, z);
        }
    }
}

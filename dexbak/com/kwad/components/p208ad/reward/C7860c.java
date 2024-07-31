package com.kwad.components.p208ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7893m;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.components.ad.reward.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7860c {

    /* renamed from: oo */
    private final Set<InterfaceC7893m> f26472oo;

    /* renamed from: com.kwad.components.ad.reward.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7862a {

        /* renamed from: or */
        private static final C7860c f26475or = new C7860c((byte) 0);
    }

    /* synthetic */ C7860c(byte b) {
        this();
    }

    /* renamed from: fe */
    public static C7860c m32139fe() {
        return C7862a.f26475or;
    }

    /* renamed from: b */
    public final void m32142b(InterfaceC7893m interfaceC7893m) {
        this.f26472oo.remove(interfaceC7893m);
    }

    /* renamed from: c */
    public final void m32140c(@Nullable final C9256q c9256q) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C7860c.this.m32141b(c9256q);
            }
        });
    }

    private C7860c() {
        this.f26472oo = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m32141b(@Nullable C9256q c9256q) {
        if (this.f26472oo.size() == 0) {
            return;
        }
        for (InterfaceC7893m interfaceC7893m : this.f26472oo) {
            interfaceC7893m.mo31254a(c9256q);
        }
    }

    /* renamed from: a */
    public final void m32143a(InterfaceC7893m interfaceC7893m) {
        if (interfaceC7893m != null) {
            this.f26472oo.add(interfaceC7893m);
        }
    }
}

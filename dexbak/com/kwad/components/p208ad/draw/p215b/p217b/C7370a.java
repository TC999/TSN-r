package com.kwad.components.p208ad.draw.p215b.p217b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.draw.b.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7370a {

    /* renamed from: cF */
    private InterfaceC7371a f25302cF;
    @Nullable

    /* renamed from: cG */
    private InterfaceC7372b f25303cG;

    /* renamed from: cH */
    private boolean f25304cH = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7371a {
        /* renamed from: aq */
        void mo33400aq();
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7372b {
        /* renamed from: ar */
        boolean mo33377ar();
    }

    public C7370a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    /* renamed from: a */
    public final void m33410a(InterfaceC7371a interfaceC7371a) {
        this.f25302cF = interfaceC7371a;
    }

    /* renamed from: ap */
    public final void m33408ap() {
        InterfaceC7371a interfaceC7371a;
        if (this.f25304cH) {
            return;
        }
        this.f25304cH = true;
        if (C10487e.m25641dQ(this.mAdTemplate).status == 1 || C10487e.m25641dQ(this.mAdTemplate).status == 2 || C10487e.m25641dQ(this.mAdTemplate).status == 3) {
            return;
        }
        InterfaceC7372b interfaceC7372b = this.f25303cG;
        if ((interfaceC7372b == null || !interfaceC7372b.mo33377ar()) && (interfaceC7371a = this.f25302cF) != null) {
            interfaceC7371a.mo33400aq();
        }
    }

    @MainThread
    /* renamed from: a */
    public final void m33409a(InterfaceC7372b interfaceC7372b) {
        this.f25303cG = interfaceC7372b;
    }
}

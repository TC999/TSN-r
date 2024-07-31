package com.kwad.sdk.core.p403h;

/* renamed from: com.kwad.sdk.core.h.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10384b implements InterfaceC10385c {
    private boolean aDI = false;

    /* renamed from: Mi */
    private boolean f29553Mi = false;

    /* renamed from: Mj */
    private boolean f29554Mj = false;

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        this.aDI = true;
        if (this.f29554Mj) {
            return;
        }
        mo26184ah();
        this.f29554Mj = true;
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        if (this.aDI && !this.f29553Mi) {
            mo26183ai();
            this.f29553Mi = true;
        }
    }

    /* renamed from: ah */
    protected abstract void mo26184ah();

    /* renamed from: ai */
    protected abstract void mo26183ai();
}

package com.kwad.sdk.core.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b implements c {
    private boolean aDI = false;
    private boolean Mi = false;
    private boolean Mj = false;

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.aDI = true;
        if (this.Mj) {
            return;
        }
        ah();
        this.Mj = true;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        if (this.aDI && !this.Mi) {
            ai();
            this.Mi = true;
        }
    }

    protected abstract void ah();

    protected abstract void ai();
}

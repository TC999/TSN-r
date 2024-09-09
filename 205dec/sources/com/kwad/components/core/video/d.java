package com.kwad.components.core.video;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private boolean UC = false;
    private boolean UD = false;
    private boolean UE = false;
    private boolean UF = false;
    private boolean UG = false;
    private int UH = -1;

    public final void aN(int i4) {
        this.UH = i4;
    }

    public final void aR(boolean z3) {
        this.UE = z3;
    }

    public final boolean rB() {
        return this.UH > 0;
    }

    public final int rC() {
        return this.UH;
    }

    public final boolean rD() {
        return this.UC;
    }

    public final boolean rE() {
        return this.UD;
    }

    public final boolean rF() {
        return this.UE;
    }

    public final boolean rG() {
        return this.UF;
    }

    public final boolean rH() {
        return this.UG;
    }

    public final void setAd(boolean z3) {
        this.UD = z3;
    }

    public final void setFillXY(boolean z3) {
        this.UG = z3;
    }

    public final void setForce(boolean z3) {
        this.UC = z3;
    }

    public final void setHorizontalVideo(boolean z3) {
        this.UF = z3;
    }
}

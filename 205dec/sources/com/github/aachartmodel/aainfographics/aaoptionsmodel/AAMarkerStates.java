package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAMarker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerStates;", "", "()V", "hover", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerHover;", "getHover", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerHover;", "setHover", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarkerHover;)V", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAMarkerStates {
    @Nullable
    private AAMarkerHover hover;

    @Nullable
    public final AAMarkerHover getHover() {
        return this.hover;
    }

    @NotNull
    public final AAMarkerStates hover(@Nullable AAMarkerHover aAMarkerHover) {
        this.hover = aAMarkerHover;
        return this;
    }

    public final void setHover(@Nullable AAMarkerHover aAMarkerHover) {
        this.hover = aAMarkerHover;
    }
}

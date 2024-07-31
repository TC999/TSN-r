package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAStates.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0011J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "", "()V", "enabled", "", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "opacity", "", "getOpacity", "()Ljava/lang/Number;", "setOpacity", "(Ljava/lang/Number;)V", "prop", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAInactive {
    @Nullable
    private Boolean enabled;
    @Nullable
    private Number opacity;

    @NotNull
    public final AAInactive enabled(@Nullable Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @Nullable
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Number getOpacity() {
        return this.opacity;
    }

    @NotNull
    public final AAInactive opacity(@Nullable Number number) {
        this.opacity = number;
        return this;
    }

    public final void setEnabled(@Nullable Boolean bool) {
        this.enabled = bool;
    }

    public final void setOpacity(@Nullable Number number) {
        this.opacity = number;
    }
}

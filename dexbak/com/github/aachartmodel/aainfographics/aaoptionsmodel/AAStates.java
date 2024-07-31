package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAStates.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "", "()V", "hover", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "getHover", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "setHover", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;)V", "inactive", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "getInactive", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "setInactive", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;)V", "select", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "getSelect", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "setSelect", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;)V", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAStates {
    @Nullable
    private AAHover hover;
    @Nullable
    private AAInactive inactive;
    @Nullable
    private AASelect select;

    @Nullable
    public final AAHover getHover() {
        return this.hover;
    }

    @Nullable
    public final AAInactive getInactive() {
        return this.inactive;
    }

    @Nullable
    public final AASelect getSelect() {
        return this.select;
    }

    @NotNull
    public final AAStates hover(@Nullable AAHover aAHover) {
        this.hover = aAHover;
        return this;
    }

    @NotNull
    public final AAStates inactive(@Nullable AAInactive aAInactive) {
        this.inactive = aAInactive;
        return this;
    }

    @NotNull
    public final AAStates select(@Nullable AASelect aASelect) {
        this.select = aASelect;
        return this;
    }

    public final void setHover(@Nullable AAHover aAHover) {
        this.hover = aAHover;
    }

    public final void setInactive(@Nullable AAInactive aAInactive) {
        this.inactive = aAInactive;
    }

    public final void setSelect(@Nullable AASelect aASelect) {
        this.select = aASelect;
    }
}

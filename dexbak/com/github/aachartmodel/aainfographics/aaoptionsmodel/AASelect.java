package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAStates.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "", "()V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "color", "getColor", "setColor", "halo", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "getHalo", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "setHalo", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;)V", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AASelect {
    @Nullable
    private String borderColor;
    @Nullable
    private String color;
    @Nullable
    private AAHalo halo;

    @NotNull
    public final AASelect borderColor(@Nullable String str) {
        this.borderColor = str;
        return this;
    }

    @NotNull
    public final AASelect color(@Nullable String str) {
        this.color = str;
        return this;
    }

    @Nullable
    public final String getBorderColor() {
        return this.borderColor;
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final AAHalo getHalo() {
        return this.halo;
    }

    @NotNull
    public final AASelect halo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
        return this;
    }

    public final void setBorderColor(@Nullable String str) {
        this.borderColor = str;
    }

    public final void setColor(@Nullable String str) {
        this.color = str;
    }

    public final void setHalo(@Nullable AAHalo aAHalo) {
        this.halo = aAHalo;
    }
}

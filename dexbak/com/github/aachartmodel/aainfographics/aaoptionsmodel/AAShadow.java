package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAShadow.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAShadow;", "", "()V", "color", "", "offsetX", "", "offsetY", "opacity", "", "Ljava/lang/Float;", "width", "prop", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAShadow;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAShadow {
    private String color;
    private Number offsetX;
    private Number offsetY;
    private Float opacity;
    private Number width;

    @NotNull
    public final AAShadow color(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAShadow offsetX(@Nullable Number number) {
        this.offsetX = number;
        return this;
    }

    @NotNull
    public final AAShadow offsetY(@Nullable Number number) {
        this.offsetY = number;
        return this;
    }

    @NotNull
    public final AAShadow opacity(@Nullable Float f) {
        this.opacity = f;
        return this;
    }

    @NotNull
    public final AAShadow width(@Nullable Number number) {
        this.width = number;
        return this;
    }
}

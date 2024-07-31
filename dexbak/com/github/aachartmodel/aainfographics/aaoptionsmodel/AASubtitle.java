package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.baidu.mobads.sdk.internal.C2573a;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AASubtitle.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0012J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "", "()V", "align", "", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", C2573a.f8443b, "userHTML", "", "Ljava/lang/Boolean;", "verticalAlign", "x", "", "y", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AASubtitle {
    private String align;
    private AAStyle style;
    private String text;
    private Boolean userHTML;
    private String verticalAlign;

    /* renamed from: x */
    private Number f23536x;

    /* renamed from: y */
    private Number f23537y;

    @NotNull
    public final AASubtitle align(@Nullable AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @NotNull
    public final AASubtitle style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AASubtitle text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AASubtitle userHTML(@Nullable Boolean bool) {
        this.userHTML = bool;
        return this;
    }

    @NotNull
    public final AASubtitle verticalAlign(@NotNull AAChartVerticalAlignType prop) {
        C14342f0.m8184p(prop, "prop");
        this.verticalAlign = prop.toString();
        return this;
    }

    @NotNull
    /* renamed from: x */
    public final AASubtitle m35506x(@Nullable Number number) {
        this.f23536x = number;
        return this;
    }

    @NotNull
    /* renamed from: y */
    public final AASubtitle m35505y(@Nullable Number number) {
        this.f23537y = number;
        return this;
    }
}

package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AATitle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0012J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "", "()V", "align", "", "style", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "text", "userHTML", "", "Ljava/lang/Boolean;", "verticalAlign", "x", "", "y", "prop", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AATitle {
    private String align;
    private AAStyle style;
    private String text;
    private Boolean userHTML;
    private String verticalAlign;

    /* renamed from: x  reason: collision with root package name */
    private Number f37130x;

    /* renamed from: y  reason: collision with root package name */
    private Number f37131y;

    @NotNull
    public final AATitle align(@NotNull AAChartAlignType prop) {
        f0.p(prop, "prop");
        this.align = prop.toString();
        return this;
    }

    @NotNull
    public final AATitle style(@Nullable AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @NotNull
    public final AATitle text(@Nullable String str) {
        this.text = str;
        return this;
    }

    @NotNull
    public final AATitle userHTML(@Nullable Boolean bool) {
        this.userHTML = bool;
        return this;
    }

    @NotNull
    public final AATitle verticalAlign(@NotNull AAChartVerticalAlignType prop) {
        f0.p(prop, "prop");
        this.verticalAlign = prop.toString();
        return this;
    }

    @NotNull
    public final AATitle x(@Nullable Number number) {
        this.f37130x = number;
        return this;
    }

    @NotNull
    public final AATitle y(@Nullable Number number) {
        this.f37131y = number;
        return this;
    }
}

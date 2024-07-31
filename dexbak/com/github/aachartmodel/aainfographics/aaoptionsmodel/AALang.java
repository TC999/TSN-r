package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AALang.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "", "()V", "resetZoom", "", "getResetZoom", "()Ljava/lang/String;", "setResetZoom", "(Ljava/lang/String;)V", "thousandsSep", "getThousandsSep", "setThousandsSep", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AALang {
    @Nullable
    private String resetZoom;
    @Nullable
    private String thousandsSep;

    @Nullable
    public final String getResetZoom() {
        return this.resetZoom;
    }

    @Nullable
    public final String getThousandsSep() {
        return this.thousandsSep;
    }

    @NotNull
    public final AALang resetZoom(@Nullable String str) {
        this.resetZoom = str;
        return this;
    }

    public final void setResetZoom(@Nullable String str) {
        this.resetZoom = str;
    }

    public final void setThousandsSep(@Nullable String str) {
        this.thousandsSep = str;
    }

    @NotNull
    public final AALang thousandsSep(@Nullable String str) {
        this.thousandsSep = str;
        return this;
    }
}

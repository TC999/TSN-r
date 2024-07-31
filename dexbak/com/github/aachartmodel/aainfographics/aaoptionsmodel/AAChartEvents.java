package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAChart.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0013"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "", "()V", "load", "", "getLoad", "()Ljava/lang/String;", "setLoad", "(Ljava/lang/String;)V", "redraw", "getRedraw", "setRedraw", "render", "getRender", "setRender", "selection", "getSelection", "setSelection", "prop", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAChartEvents {
    @Nullable
    private String load;
    @Nullable
    private String redraw;
    @Nullable
    private String render;
    @Nullable
    private String selection;

    @Nullable
    public final String getLoad() {
        return this.load;
    }

    @Nullable
    public final String getRedraw() {
        return this.redraw;
    }

    @Nullable
    public final String getRender() {
        return this.render;
    }

    @Nullable
    public final String getSelection() {
        return this.selection;
    }

    @NotNull
    public final AAChartEvents load(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.load = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents redraw(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.redraw = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents render(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.render = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    @NotNull
    public final AAChartEvents selection(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.selection = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(prop);
        return this;
    }

    public final void setLoad(@Nullable String str) {
        this.load = str;
    }

    public final void setRedraw(@Nullable String str) {
        this.redraw = str;
    }

    public final void setRender(@Nullable String str) {
        this.render = str;
    }

    public final void setSelection(@Nullable String str) {
        this.selection = str;
    }
}

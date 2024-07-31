package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AAPlotBandsElement.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\n\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "", "()V", "borderColor", "", "borderWidth", "", "className", "color", Constants.FROM, "index", "", "Ljava/lang/Integer;", TTDownloadField.TT_LABEL, "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "to", "prop", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AAPlotBandsElement {
    private String borderColor;
    private Number borderWidth;
    private String className;
    private Object color;
    private Number from;
    private Integer index;
    private AALabel label;

    /* renamed from: to */
    private Number f23533to;

    @NotNull
    public final AAPlotBandsElement borderColor(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.borderColor = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement borderWidth(@Nullable Number number) {
        this.borderWidth = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement className(@NotNull String prop) {
        C14342f0.m8184p(prop, "prop");
        this.className = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement color(@NotNull Object prop) {
        C14342f0.m8184p(prop, "prop");
        this.color = prop;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement from(@Nullable Number number) {
        this.from = number;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement index(@Nullable Integer num) {
        this.index = num;
        return this;
    }

    @NotNull
    public final AAPlotBandsElement label(@NotNull AALabel prop) {
        C14342f0.m8184p(prop, "prop");
        this.label = prop;
        return this;
    }

    @NotNull
    /* renamed from: to */
    public final AAPlotBandsElement m35508to(@Nullable Number number) {
        this.f23533to = number;
        return this;
    }
}

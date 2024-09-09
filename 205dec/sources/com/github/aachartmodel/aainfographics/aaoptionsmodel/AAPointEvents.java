package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AASeries.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPointEvents;", "", "()V", "click", "", "getClick", "()Ljava/lang/String;", "setClick", "(Ljava/lang/String;)V", "legendItemClick", "getLegendItemClick", "setLegendItemClick", "mouseOut", "getMouseOut", "setMouseOut", "mouseOver", "getMouseOver", "setMouseOver", "remove", "getRemove", "setRemove", "select", "getSelect", "setSelect", "unselect", "getUnselect", "setUnselect", "update", "getUpdate", "setUpdate", "prop", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AAPointEvents {
    @Nullable
    private String click;
    @Nullable
    private String legendItemClick;
    @Nullable
    private String mouseOut;
    @Nullable
    private String mouseOver;
    @Nullable
    private String remove;
    @Nullable
    private String select;
    @Nullable
    private String unselect;
    @Nullable
    private String update;

    @NotNull
    public final AAPointEvents click(@Nullable String str) {
        this.click = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @Nullable
    public final String getClick() {
        return this.click;
    }

    @Nullable
    public final String getLegendItemClick() {
        return this.legendItemClick;
    }

    @Nullable
    public final String getMouseOut() {
        return this.mouseOut;
    }

    @Nullable
    public final String getMouseOver() {
        return this.mouseOver;
    }

    @Nullable
    public final String getRemove() {
        return this.remove;
    }

    @Nullable
    public final String getSelect() {
        return this.select;
    }

    @Nullable
    public final String getUnselect() {
        return this.unselect;
    }

    @Nullable
    public final String getUpdate() {
        return this.update;
    }

    @NotNull
    public final AAPointEvents legendItemClick(@Nullable String str) {
        this.legendItemClick = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents mouseOut(@Nullable String str) {
        this.mouseOut = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents mouseOver(@Nullable String str) {
        this.mouseOver = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents remove(@Nullable String str) {
        this.remove = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents select(@Nullable String str) {
        this.select = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    public final void setClick(@Nullable String str) {
        this.click = str;
    }

    public final void setLegendItemClick(@Nullable String str) {
        this.legendItemClick = str;
    }

    public final void setMouseOut(@Nullable String str) {
        this.mouseOut = str;
    }

    public final void setMouseOver(@Nullable String str) {
        this.mouseOver = str;
    }

    public final void setRemove(@Nullable String str) {
        this.remove = str;
    }

    public final void setSelect(@Nullable String str) {
        this.select = str;
    }

    public final void setUnselect(@Nullable String str) {
        this.unselect = str;
    }

    public final void setUpdate(@Nullable String str) {
        this.update = str;
    }

    @NotNull
    public final AAPointEvents unselect(@Nullable String str) {
        this.unselect = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @NotNull
    public final AAPointEvents update(@Nullable String str) {
        this.update = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }
}

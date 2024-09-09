package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.bytedance.msdk.adapter.util.TTLogUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AAStates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "", "()V", TTLogUtil.TAG_EVENT_FILL, "", "getFill", "()Ljava/lang/String;", "setFill", "(Ljava/lang/String;)V", "stroke", "getStroke", "setStroke", "strokeWidth", "", "getStrokeWidth", "()Ljava/lang/Number;", "setStrokeWidth", "(Ljava/lang/Number;)V", "prop", "toDic", "", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class AASVGAttributes {
    @Nullable
    private String fill;
    @Nullable
    private String stroke;
    @Nullable
    private Number strokeWidth;

    @NotNull
    public final AASVGAttributes fill(@Nullable String str) {
        this.fill = str;
        return this;
    }

    @Nullable
    public final String getFill() {
        return this.fill;
    }

    @Nullable
    public final String getStroke() {
        return this.stroke;
    }

    @Nullable
    public final Number getStrokeWidth() {
        return this.strokeWidth;
    }

    public final void setFill(@Nullable String str) {
        this.fill = str;
    }

    public final void setStroke(@Nullable String str) {
        this.stroke = str;
    }

    public final void setStrokeWidth(@Nullable Number number) {
        this.strokeWidth = number;
    }

    @NotNull
    public final AASVGAttributes stroke(@Nullable String str) {
        this.stroke = str;
        return this;
    }

    @NotNull
    public final AASVGAttributes strokeWidth(@Nullable Number number) {
        this.strokeWidth = number;
        return this;
    }

    @NotNull
    public final Map<String, Object> toDic() {
        HashMap hashMap = new HashMap();
        Number number = this.strokeWidth;
        if (number != null) {
            hashMap.put("stroke-width", number);
        }
        String str = this.fill;
        if (str != null) {
            hashMap.put(TTLogUtil.TAG_EVENT_FILL, str);
        }
        String str2 = this.stroke;
        if (str2 != null) {
            hashMap.put("stroke", str2);
        }
        return hashMap;
    }
}

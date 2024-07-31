package com.github.aachartmodel.aainfographics.aachartcreator;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: AAChartModel.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m12616d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Solid", "ShortDash", "ShortDot", "ShortDashDot", "ShortDashDotDot", "Dot", "Dash", "LongDash", "DashDot", "LongDashDot", "LongDashDotDot", "charts_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public enum AAChartLineDashStyleType {
    Solid("Solid"),
    ShortDash("ShortDash"),
    ShortDot("ShortDot"),
    ShortDashDot("ShortDashDot"),
    ShortDashDotDot("ShortDashDotDot"),
    Dot("Dot"),
    Dash("Dash"),
    LongDash("LongDash"),
    DashDot("DashDot"),
    LongDashDot("LongDashDot"),
    LongDashDotDot("LongDashDotDot");
    
    @NotNull
    private final String value;

    AAChartLineDashStyleType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}

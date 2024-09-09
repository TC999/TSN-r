package xyz.adscope.ad.tool.monitor.impression.inner;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ImpressionInterface {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}

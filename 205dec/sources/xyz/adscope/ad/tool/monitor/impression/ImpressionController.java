package xyz.adscope.ad.tool.monitor.impression;

import android.view.View;
import xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class ImpressionController implements ImpressionInterface {
    private static final int DEFAULT_IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    private static final int DEFAULT_IMPRESSION_MIN_TIME_VIEWED_MS = 1000;
    private int mImpressionMinPercentageViewed;
    private int mImpressionMinTimeViewed;
    private Integer mImpressionMinVisiblePx;
    private boolean mImpressionRecorded;

    public ImpressionController() {
        this.mImpressionMinTimeViewed = 1000;
        this.mImpressionMinPercentageViewed = 50;
        this.mImpressionMinVisiblePx = null;
    }

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return this.mImpressionMinPercentageViewed;
    }

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public final Integer getImpressionMinVisiblePx() {
        return this.mImpressionMinVisiblePx;
    }

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.mImpressionRecorded;
    }

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public abstract void recordImpression(View view);

    @Override // xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
    public final void setImpressionRecorded() {
        this.mImpressionRecorded = true;
    }

    public ImpressionController(int i4, int i5) {
        this.mImpressionMinTimeViewed = i4;
        this.mImpressionMinPercentageViewed = i5;
        this.mImpressionMinVisiblePx = null;
    }
}

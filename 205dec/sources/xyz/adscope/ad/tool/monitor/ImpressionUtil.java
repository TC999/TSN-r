package xyz.adscope.ad.tool.monitor;

import android.view.View;
import xyz.adscope.ad.tool.monitor.impression.ImpressionController;
import xyz.adscope.ad.tool.monitor.impression.ImpressionTracker;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ImpressionUtil {
    private static final int DEFAULT_MIN_TIME = 10;
    private ImpressionTracker mImpressionTracker;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface ImpressionCallback {
        void impressionCallback();
    }

    public void destory() {
        ImpressionTracker impressionTracker = this.mImpressionTracker;
        if (impressionTracker != null) {
            impressionTracker.destroy();
            this.mImpressionTracker = null;
        }
    }

    public void registerImpressionTracker(int i4, View view, final ImpressionCallback impressionCallback) {
        ImpressionController impressionController = new ImpressionController(10, i4) { // from class: xyz.adscope.ad.tool.monitor.ImpressionUtil.1
            @Override // xyz.adscope.ad.tool.monitor.impression.ImpressionController, xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface
            public void recordImpression(View view2) {
                LogUtil.e("ImpressionUtil", "recordImpression :");
                ImpressionCallback impressionCallback2 = impressionCallback;
                if (impressionCallback2 != null) {
                    impressionCallback2.impressionCallback();
                }
            }
        };
        if (this.mImpressionTracker == null) {
            this.mImpressionTracker = new ImpressionTracker(view.getContext(), 0);
        }
        this.mImpressionTracker.addView(view, impressionController);
    }
}

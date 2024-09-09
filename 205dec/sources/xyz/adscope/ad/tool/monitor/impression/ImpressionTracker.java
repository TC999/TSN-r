package xyz.adscope.ad.tool.monitor.impression;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import xyz.adscope.ad.tool.monitor.impression.VisibilityTracker;
import xyz.adscope.ad.tool.monitor.impression.inner.ImpressionInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ImpressionTracker {
    private static final int PERIOD = 250;
    private final Handler mPollHandler;
    private final PollingRunnable mPollingRunnable;
    private final Map<View, TimestampWrapper<ImpressionInterface>> mPollingViews;
    private final Map<View, ImpressionInterface> mTrackedViews;
    private final VisibilityTracker.VisibilityChecker mVisibilityChecker;
    private final VisibilityTracker mVisibilityTracker;
    private VisibilityTracker.VisibilityTrackerListener mVisibilityTrackerListener;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class PollingRunnable implements Runnable {
        private final ArrayList<View> mRemovedViews = new ArrayList<>();

        public PollingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry entry : ImpressionTracker.this.mPollingViews.entrySet()) {
                View view = (View) entry.getKey();
                TimestampWrapper timestampWrapper = (TimestampWrapper) entry.getValue();
                boolean hasRequiredTimeElapsed = ImpressionTracker.this.mVisibilityChecker.hasRequiredTimeElapsed(timestampWrapper.mCreatedTimestamp, ((ImpressionInterface) timestampWrapper.mInstance).getImpressionMinTimeViewed());
                LogUtil.e("ImpressionUtil", "recordImpression flag:" + hasRequiredTimeElapsed);
                if (hasRequiredTimeElapsed) {
                    ((ImpressionInterface) timestampWrapper.mInstance).recordImpression(view);
                    ((ImpressionInterface) timestampWrapper.mInstance).setImpressionRecorded();
                    this.mRemovedViews.add(view);
                }
            }
            Iterator<View> it = this.mRemovedViews.iterator();
            while (it.hasNext()) {
                ImpressionTracker.this.removeView(it.next());
            }
            this.mRemovedViews.clear();
            if (ImpressionTracker.this.mPollingViews.isEmpty()) {
                return;
            }
            ImpressionTracker.this.scheduleNextPoll();
        }
    }

    public ImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(context), new Handler(Looper.getMainLooper()));
    }

    private void removePollingView(View view) {
        this.mPollingViews.remove(view);
    }

    public void addView(View view, ImpressionInterface impressionInterface) {
        if (this.mTrackedViews.get(view) == impressionInterface) {
            return;
        }
        removeView(view);
        if (impressionInterface.isImpressionRecorded()) {
            return;
        }
        this.mTrackedViews.put(view, impressionInterface);
        this.mVisibilityTracker.addView(view, impressionInterface.getImpressionMinPercentageViewed(), impressionInterface.getImpressionMinVisiblePx());
    }

    public void clear() {
        this.mTrackedViews.clear();
        this.mPollingViews.clear();
        this.mVisibilityTracker.clear();
        this.mPollHandler.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.mVisibilityTracker.destroy();
        this.mVisibilityTrackerListener = null;
    }

    @Deprecated
    public VisibilityTracker.VisibilityTrackerListener getVisibilityTrackerListener() {
        return this.mVisibilityTrackerListener;
    }

    public void removeView(View view) {
        this.mTrackedViews.remove(view);
        removePollingView(view);
        this.mVisibilityTracker.removeView(view);
    }

    public void scheduleNextPoll() {
        if (this.mPollHandler.hasMessages(0)) {
            return;
        }
        this.mPollHandler.postDelayed(this.mPollingRunnable, 250L);
    }

    public ImpressionTracker(Context context, int i4) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker.VisibilityChecker(), new VisibilityTracker(context, i4), new Handler(Looper.getMainLooper()));
    }

    public ImpressionTracker(Map<View, ImpressionInterface> map, Map<View, TimestampWrapper<ImpressionInterface>> map2, VisibilityTracker.VisibilityChecker visibilityChecker, VisibilityTracker visibilityTracker, Handler handler) {
        this.mTrackedViews = map;
        this.mPollingViews = map2;
        this.mVisibilityChecker = visibilityChecker;
        this.mVisibilityTracker = visibilityTracker;
        VisibilityTracker.VisibilityTrackerListener visibilityTrackerListener = new VisibilityTracker.VisibilityTrackerListener() { // from class: xyz.adscope.ad.tool.monitor.impression.ImpressionTracker.1
            @Override // xyz.adscope.ad.tool.monitor.impression.VisibilityTracker.VisibilityTrackerListener
            public void onVisibilityChanged(List<View> list, List<View> list2) {
                for (View view : list) {
                    ImpressionInterface impressionInterface = (ImpressionInterface) ImpressionTracker.this.mTrackedViews.get(view);
                    if (impressionInterface == null) {
                        ImpressionTracker.this.removeView(view);
                    } else {
                        TimestampWrapper timestampWrapper = (TimestampWrapper) ImpressionTracker.this.mPollingViews.get(view);
                        if (timestampWrapper == null || !impressionInterface.equals(timestampWrapper.mInstance)) {
                            ImpressionTracker.this.mPollingViews.put(view, new TimestampWrapper(impressionInterface));
                        }
                    }
                }
                for (View view2 : list2) {
                    ImpressionTracker.this.mPollingViews.remove(view2);
                }
                ImpressionTracker.this.scheduleNextPoll();
            }
        };
        this.mVisibilityTrackerListener = visibilityTrackerListener;
        visibilityTracker.setVisibilityTrackerListener(visibilityTrackerListener);
        this.mPollHandler = handler;
        this.mPollingRunnable = new PollingRunnable();
    }
}

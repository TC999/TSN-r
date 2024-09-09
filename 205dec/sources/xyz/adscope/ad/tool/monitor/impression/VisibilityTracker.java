package xyz.adscope.ad.tool.monitor.impression;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
class VisibilityTracker {
    public static final int NUM_ACCESSES_BEFORE_TRIMMING = 50;
    private static int VISIBILITY_THROTTLE_MILLIS = 1000;
    private long mAccessCounter;
    private boolean mIsVisibilityScheduled;
    public final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private final Map<View, TrackingInfo> mTrackedViews;
    private final ArrayList<View> mTrimmedViews;
    private final VisibilityChecker mVisibilityChecker;
    private final Handler mVisibilityHandler;
    private final VisibilityRunnable mVisibilityRunnable;
    private VisibilityTrackerListener mVisibilityTrackerListener;
    public WeakReference<ViewTreeObserver> mWeakViewTreeObserver;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class TrackingInfo {
        public long mAccessOrder;
        public int mMaxInvisiblePercent;
        public int mMinViewablePercent;
        public Integer mMinVisiblePx;
        public View mRootView;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class VisibilityChecker {
        private final Rect mClipRect = new Rect();

        public boolean hasRequiredTimeElapsed(long j4, int i4) {
            return SystemClock.uptimeMillis() - j4 >= ((long) i4);
        }

        public boolean isVisible(View view, View view2, int i4, Integer num) {
            if (view2 == null || view2.getVisibility() != 0 || view == null || view.getParent() == null || !view2.getGlobalVisibleRect(this.mClipRect)) {
                return false;
            }
            long height = this.mClipRect.height() * this.mClipRect.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 <= 0) {
                return false;
            }
            return (num == null || num.intValue() <= 0) ? height * 100 >= ((long) i4) * height2 : height >= ((long) num.intValue());
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class VisibilityRunnable implements Runnable {
        private final ArrayList<View> mInvisibleViews = new ArrayList<>();
        private final ArrayList<View> mVisibleViews = new ArrayList<>();

        public VisibilityRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VisibilityTracker.this.mIsVisibilityScheduled = false;
            for (Map.Entry entry : VisibilityTracker.this.mTrackedViews.entrySet()) {
                View view = (View) entry.getKey();
                int i4 = ((TrackingInfo) entry.getValue()).mMinViewablePercent;
                int i5 = ((TrackingInfo) entry.getValue()).mMaxInvisiblePercent;
                Integer num = ((TrackingInfo) entry.getValue()).mMinVisiblePx;
                View view2 = ((TrackingInfo) entry.getValue()).mRootView;
                if (VisibilityTracker.this.mVisibilityChecker.isVisible(view2, view, i4, num)) {
                    this.mVisibleViews.add(view);
                } else if (!VisibilityTracker.this.mVisibilityChecker.isVisible(view2, view, i5, null)) {
                    this.mInvisibleViews.add(view);
                }
            }
            if (VisibilityTracker.this.mVisibilityTrackerListener != null) {
                VisibilityTracker.this.mVisibilityTrackerListener.onVisibilityChanged(this.mVisibleViews, this.mInvisibleViews);
            }
            this.mVisibleViews.clear();
            this.mInvisibleViews.clear();
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface VisibilityTrackerListener {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    public VisibilityTracker(Context context) {
        this(context, new WeakHashMap(10), new VisibilityChecker(), new Handler(Looper.getMainLooper()));
    }

    private void setViewTreeObserver(Context context, View view) {
        ViewTreeObserver viewTreeObserver = this.mWeakViewTreeObserver.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View topmostView = Views.getTopmostView(context, view);
            if (topmostView == null) {
                LogUtil.d("VisibilityTracker", "Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                LogUtil.d("VisibilityTracker", "Visibility Tracker was unable to track views because the root view tree observer was not alive");
                return;
            }
            this.mWeakViewTreeObserver = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    private void trimTrackedViews(long j4) {
        for (Map.Entry<View, TrackingInfo> entry : this.mTrackedViews.entrySet()) {
            if (entry.getValue().mAccessOrder < j4) {
                this.mTrimmedViews.add(entry.getKey());
            }
        }
        Iterator<View> it = this.mTrimmedViews.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.mTrimmedViews.clear();
    }

    public void addView(View view, int i4, Integer num) {
        addView(view, view, i4, num);
    }

    public void clear() {
        this.mTrackedViews.clear();
        this.mVisibilityHandler.removeMessages(0);
        this.mIsVisibilityScheduled = false;
    }

    public void destroy() {
        clear();
        ViewTreeObserver viewTreeObserver = this.mWeakViewTreeObserver.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mWeakViewTreeObserver.clear();
        this.mVisibilityTrackerListener = null;
    }

    public void removeView(View view) {
        this.mTrackedViews.remove(view);
    }

    public void scheduleVisibilityCheck() {
        if (this.mIsVisibilityScheduled) {
            return;
        }
        this.mIsVisibilityScheduled = true;
        this.mVisibilityHandler.postDelayed(this.mVisibilityRunnable, VISIBILITY_THROTTLE_MILLIS);
    }

    public void setVisibilityTrackerListener(VisibilityTrackerListener visibilityTrackerListener) {
        this.mVisibilityTrackerListener = visibilityTrackerListener;
    }

    public void addView(View view, View view2, int i4, Integer num) {
        addView(view, view2, i4, i4, num);
    }

    public void addView(View view, View view2, int i4, int i5, Integer num) {
        try {
            setViewTreeObserver(view2.getContext(), view2);
            TrackingInfo trackingInfo = this.mTrackedViews.get(view2);
            if (trackingInfo == null) {
                trackingInfo = new TrackingInfo();
                this.mTrackedViews.put(view2, trackingInfo);
                scheduleVisibilityCheck();
            }
            int min = Math.min(i5, i4);
            trackingInfo.mRootView = view;
            trackingInfo.mMinViewablePercent = i4;
            trackingInfo.mMaxInvisiblePercent = min;
            long j4 = this.mAccessCounter;
            trackingInfo.mAccessOrder = j4;
            trackingInfo.mMinVisiblePx = num;
            long j5 = j4 + 1;
            this.mAccessCounter = j5;
            if (j5 % 50 == 0) {
                trimTrackedViews(j5 - 50);
            }
        } catch (Throwable unused) {
        }
    }

    public VisibilityTracker(Context context, int i4) {
        this(context, new WeakHashMap(10), new VisibilityChecker(), new Handler(Looper.getMainLooper()));
        VISIBILITY_THROTTLE_MILLIS = i4;
    }

    public VisibilityTracker(Context context, Map<View, TrackingInfo> map, VisibilityChecker visibilityChecker, Handler handler) {
        this.mAccessCounter = 0L;
        this.mTrackedViews = map;
        this.mVisibilityChecker = visibilityChecker;
        this.mVisibilityHandler = handler;
        this.mVisibilityRunnable = new VisibilityRunnable();
        this.mTrimmedViews = new ArrayList<>(50);
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: xyz.adscope.ad.tool.monitor.impression.VisibilityTracker.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                VisibilityTracker.this.scheduleVisibilityCheck();
                return true;
            }
        };
        this.mWeakViewTreeObserver = new WeakReference<>(null);
        setViewTreeObserver(context, null);
    }
}

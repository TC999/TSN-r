package com.umeng.socialize.shareboard.widgets;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class ViewCompat {
    private static final long FAKE_FRAME_TIME = 10;
    private static final ViewCompatImpl IMPL;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class Api24ViewCompatImpl extends MarshmallowViewCompatImpl {
        private Api24ViewCompatImpl() {
            super();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class BaseViewCompatImpl implements ViewCompatImpl {
        BaseViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i4) {
            return false;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        long getFrameTime() {
            return 10L;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.invalidate();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @TargetApi(11)
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class HCViewCompatImpl extends BaseViewCompatImpl {
        HCViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl
        long getFrameTime() {
            return ValueAnimator.getFrameDelay();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class ICSMr1ViewCompatImpl extends ICSViewCompatImpl {
        ICSMr1ViewCompatImpl() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @TargetApi(14)
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class ICSViewCompatImpl extends HCViewCompatImpl {
        ICSViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public boolean canScrollHorizontally(View view, int i4) {
            return view.canScrollHorizontally(i4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @TargetApi(16)
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class JBViewCompatImpl extends ICSMr1ViewCompatImpl {
        JBViewCompatImpl() {
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        private JbMr1ViewCompatImpl() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class JbMr2ViewCompatImpl extends JbMr1ViewCompatImpl {
        private JbMr2ViewCompatImpl() {
            super();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class KitKatViewCompatImpl extends JbMr2ViewCompatImpl {
        private KitKatViewCompatImpl() {
            super();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    @TargetApi(20)
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class LollipopViewCompatImpl extends KitKatViewCompatImpl {
        private LollipopViewCompatImpl() {
            super();
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(dispatchApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return WindowInsetsCompat.wrap(onApplyWindowInsets(view, WindowInsetsCompat.unwrap(windowInsetsCompat)));
        }

        @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.BaseViewCompatImpl, com.umeng.socialize.shareboard.widgets.ViewCompat.ViewCompatImpl
        public void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            final OnApplyWindowInsetsListenerBridge onApplyWindowInsetsListenerBridge = new OnApplyWindowInsetsListenerBridge() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.1
                @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.OnApplyWindowInsetsListenerBridge
                public Object onApplyWindowInsets(View view2, Object obj) {
                    return WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view2, WindowInsetsCompat.wrap(obj)));
                }
            };
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.umeng.socialize.shareboard.widgets.ViewCompat.LollipopViewCompatImpl.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return (WindowInsets) onApplyWindowInsetsListenerBridge.onApplyWindowInsets(view2, windowInsets);
                }
            });
        }

        private static Object dispatchApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            return dispatchApplyWindowInsets != windowInsets ? new WindowInsets(dispatchApplyWindowInsets) : obj;
        }

        private static Object onApplyWindowInsets(View view, Object obj) {
            WindowInsets windowInsets = (WindowInsets) obj;
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return onApplyWindowInsets != windowInsets ? new WindowInsets(onApplyWindowInsets) : obj;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class MarshmallowViewCompatImpl extends LollipopViewCompatImpl {
        private MarshmallowViewCompatImpl() {
            super();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface OnApplyWindowInsetsListenerBridge {
        Object onApplyWindowInsets(View view, Object obj);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    interface ViewCompatImpl {
        boolean canScrollHorizontally(View view, int i4);

        WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat);

        void postInvalidateOnAnimation(View view);

        void postOnAnimation(View view, Runnable runnable);

        void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener);
    }

    static {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            IMPL = new Api24ViewCompatImpl();
        } else if (i4 >= 23) {
            IMPL = new MarshmallowViewCompatImpl();
        } else if (i4 >= 21) {
            IMPL = new LollipopViewCompatImpl();
        } else if (i4 >= 19) {
            IMPL = new KitKatViewCompatImpl();
        } else if (i4 >= 18) {
            IMPL = new JbMr2ViewCompatImpl();
        } else {
            IMPL = new JbMr1ViewCompatImpl();
        }
    }

    ViewCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canScrollHorizontally(View view, int i4) {
        return IMPL.canScrollHorizontally(view, i4);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }
}
package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.C0241R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static Field sAccessibilityDelegateField;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {C0241R.C0244id.accessibility_custom_action_0, C0241R.C0244id.accessibility_custom_action_1, C0241R.C0244id.accessibility_custom_action_2, C0241R.C0244id.accessibility_custom_action_3, C0241R.C0244id.accessibility_custom_action_4, C0241R.C0244id.accessibility_custom_action_5, C0241R.C0244id.accessibility_custom_action_6, C0241R.C0244id.accessibility_custom_action_7, C0241R.C0244id.accessibility_custom_action_8, C0241R.C0244id.accessibility_custom_action_9, C0241R.C0244id.accessibility_custom_action_10, C0241R.C0244id.accessibility_custom_action_11, C0241R.C0244id.accessibility_custom_action_12, C0241R.C0244id.accessibility_custom_action_13, C0241R.C0244id.accessibility_custom_action_14, C0241R.C0244id.accessibility_custom_action_15, C0241R.C0244id.accessibility_custom_action_16, C0241R.C0244id.accessibility_custom_action_17, C0241R.C0244id.accessibility_custom_action_18, C0241R.C0244id.accessibility_custom_action_19, C0241R.C0244id.accessibility_custom_action_20, C0241R.C0244id.accessibility_custom_action_21, C0241R.C0244id.accessibility_custom_action_22, C0241R.C0244id.accessibility_custom_action_23, C0241R.C0244id.accessibility_custom_action_24, C0241R.C0244id.accessibility_custom_action_25, C0241R.C0244id.accessibility_custom_action_26, C0241R.C0244id.accessibility_custom_action_27, C0241R.C0244id.accessibility_custom_action_28, C0241R.C0244id.accessibility_custom_action_29, C0241R.C0244id.accessibility_custom_action_30, C0241R.C0244id.accessibility_custom_action_31};
    private static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 16);
                }
                this.mPanesToVisible.put(view, Boolean.valueOf(z2));
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        void addAccessibilityPane(View view) {
            this.mPanesToVisible.put(view, Boolean.valueOf(view.getVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                registerForLayoutCallback(view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet()) {
                checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @RequiresApi(19)
        void removeAccessibilityPane(View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static abstract class AccessibilityViewProperty<T> {
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        private boolean extrasAvailable() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean frameworkAvailable() {
            return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        }

        boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        abstract T frameworkGet(View view);

        abstract void frameworkSet(View view, T t);

        T get(View view) {
            if (frameworkAvailable()) {
                return frameworkGet(view);
            }
            if (extrasAvailable()) {
                T t = (T) view.getTag(this.mTagKey);
                if (this.mType.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        void set(View view, T t) {
            if (frameworkAvailable()) {
                frameworkSet(view, t);
            } else if (extrasAvailable() && shouldUpdate(get(view), t)) {
                ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
                view.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
            }
        }

        boolean shouldUpdate(T t, T t2) {
            return !t2.equals(t);
        }

        AccessibilityViewProperty(int i, Class<T> cls, int i2, int i3) {
            this.mTagKey = i;
            this.mType = cls;
            this.mFrameworkMinimumSdk = i3;
        }
    }

    @RequiresApi(21)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect));
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }
    }

    @RequiresApi(23)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsets getRootWindowInsets(View view) {
            return view.getRootWindowInsets();
        }
    }

    @RequiresApi(29)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class Api29Impl {
        private Api29Impl() {
        }

        static void saveAttributeDataForStyleable(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface NestedScrollType {
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface ScrollIndicators {
    }

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        UnhandledKeyEventManager() {
        }

        /* renamed from: at */
        static UnhandledKeyEventManager m60023at(View view) {
            int i = C0241R.C0244id.tag_unhandled_key_event_manager;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(i);
            if (unhandledKeyEventManager == null) {
                UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view.setTag(i, unhandledKeyEventManager2);
                return unhandledKeyEventManager2;
            }
            return unhandledKeyEventManager;
        }

        @Nullable
        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (dispatchInOrder != null) {
                            return dispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C0241R.C0244id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference<>(view));
            }
        }

        static void unregisterListeningView(View view) {
            synchronized (sViewsWithListeners) {
                int i = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i).get() == view) {
                        arrayList.remove(i);
                        return;
                    }
                    i++;
                }
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View dispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
                }
            }
            return dispatchInOrder != null;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
                if (keyEvent.getAction() == 1 && (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = capturedKeys.valueAt(indexOfKey);
                    capturedKeys.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = capturedKeys.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && ViewCompat.isAttachedToWindow(view)) {
                        onUnhandledKeyEvent(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    protected ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(C0241R.C0244id.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            int i = C0241R.C0244id.tag_unhandled_key_listeners;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i, simpleArrayMap);
            }
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.ViewCompat.2
                @Override // android.view.View.OnUnhandledKeyEventListener
                public boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            return;
        }
        int i2 = C0241R.C0244id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(i2, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e) {
            Log.e("ViewCompat", "Couldn't find method", e);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    private static void compatOffsetLeftAndRight(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect) : windowInsetsCompat;
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        return (Build.VERSION.SDK_INT < 21 || (windowInsets = windowInsetsCompat.toWindowInsets()) == null || view.dispatchApplyWindowInsets(windowInsets).equals(windowInsets)) ? windowInsetsCompat : WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e);
                return;
            }
        }
        view.onFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedFling(f, f2, z);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedFling(f, f2, z);
        }
        return false;
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreFling(f, f2);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedPreFling(f, f2);
        }
        return false;
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        return false;
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Exception e) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e);
                return;
            }
        }
        view.onStartTemporaryDetach();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.m60023at(view).dispatch(view, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.m60023at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            getOrCreateAccessibilityDelegateCompat(view);
        }
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return getAccessibilityDelegateThroughReflection(view);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View view) {
        return paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        int i = C0241R.C0244id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        int i = 0;
        int i2 = -1;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i >= iArr.length || i2 != -1) {
                break;
            }
            int i3 = iArr[i];
            boolean z = true;
            for (int i4 = 0; i4 < actionList.size(); i4++) {
                z &= actionList.get(i4).getId() != i3;
            }
            if (z) {
                i2 = i3;
            }
            i++;
        }
        return i2;
    }

    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    @Nullable
    public static Display getDisplay(@NonNull View view) {
        return view.getDisplay();
    }

    public static float getElevation(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static boolean getFitsSystemWindows(@NonNull View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(@NonNull View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int getLabelFor(@NonNull View view) {
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View view) {
        return view.getLayoutDirection();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(@NonNull View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getNextClusterForwardId();
        }
        return -1;
    }

    static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        return accessibilityDelegate;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @InterfaceC0075Px
    public static int getPaddingEnd(@NonNull View view) {
        return view.getPaddingEnd();
    }

    @InterfaceC0075Px
    public static int getPaddingStart(@NonNull View view) {
        return view.getPaddingStart();
    }

    public static ViewParent getParentForAccessibility(@NonNull View view) {
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return WindowInsetsCompat.toWindowInsetsCompat(Api23Impl.getRootWindowInsets(view));
        }
        return null;
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getScrollIndicators();
        }
        return 0;
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getSystemGestureExclusionRects();
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = sTransitionNameMap;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static int getWindowSystemUiVisibility(@NonNull View view) {
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        return getAccessibilityDelegateInternal(view) != null;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.hasExplicitFocusable();
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.hasNestedScrollingParent();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).hasNestedScrollingParent();
        }
        return false;
    }

    public static boolean hasOnClickListeners(@NonNull View view) {
        return view.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(@NonNull View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(@NonNull View view) {
        return view.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(View view) {
        Boolean bool = accessibilityHeadingProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isAttachedToWindow(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isFocusedByDefault();
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isImportantForAccessibility();
        }
        return true;
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isImportantForAutofill();
        }
        return true;
    }

    public static boolean isInLayout(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isKeyboardNavigationCluster();
        }
        return false;
    }

    public static boolean isLaidOut(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLayoutDirectionResolved();
        }
        return false;
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).isNestedScrollingEnabled();
        }
        return false;
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View view) {
        return view.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View view) {
        Boolean bool = screenReaderFocusableProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }
        return null;
    }

    @RequiresApi(19)
    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = getAccessibilityPaneTitle(view) != null;
            if (getAccessibilityLiveRegion(view) == 0 && (!z || view.getVisibility() != 0)) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(z ? 32 : 2048);
            obtain.setContentChangeTypes(i);
            view.sendAccessibilityEventUnchecked(obtain);
        }
    }

    public static void offsetLeftAndRight(@NonNull View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
        } else if (i2 >= 21) {
            Rect emptyTempRect = getEmptyTempRect();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            compatOffsetLeftAndRight(view, i);
            if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(emptyTempRect);
            }
        } else {
            compatOffsetLeftAndRight(view, i);
        }
    }

    public static void offsetTopAndBottom(@NonNull View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
        } else if (i2 >= 21) {
            Rect emptyTempRect = getEmptyTempRect();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            compatOffsetTopAndBottom(view, i);
            if (z && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(emptyTempRect);
            }
        } else {
            compatOffsetTopAndBottom(view, i);
        }
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsets = windowInsetsCompat.toWindowInsets()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(C0241R.C0244id.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public CharSequence frameworkGet(View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean performAccessibilityAction(@NonNull View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void postInvalidateOnAnimation(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(@NonNull View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(@NonNull View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void removeAccessibilityAction(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            removeActionWithId(i, view);
            notifyViewAccessibilityStateChangedIfNeeded(view, 0);
        }
    }

    private static void removeActionWithId(int i, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i2 = 0; i2 < actionList.size(); i2++) {
            if (actionList.get(i2).getId() == i) {
                actionList.remove(i2);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        if (Build.VERSION.SDK_INT >= 28) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(C0241R.C0244id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(C0241R.C0244id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            view.requestFitSystemWindows();
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) view.requireViewById(i);
        }
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.restoreDefaultFocus();
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(C0241R.C0244id.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static void setAccessibilityDelegate(@NonNull View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
    }

    @UiThread
    public static void setAccessibilityHeading(View view, boolean z) {
        accessibilityHeadingProperty().set(view, Boolean.valueOf(z));
    }

    public static void setAccessibilityLiveRegion(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            paneTitleProperty().set(view, charSequence);
            if (charSequence != null) {
                sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
            } else {
                sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
            }
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, m60036to = 1.0d) float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(@NonNull View view, ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void setBackgroundTintMode(@NonNull View view, PorterDuff.Mode mode) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setBackgroundTintMode(mode);
            if (i == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }

    public static void setClipBounds(@NonNull View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void setElevation(@NonNull View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z);
        }
    }

    public static void setHasTransientState(@NonNull View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static void setImportantForAccessibility(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i);
            return;
        }
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public static void setImportantForAutofill(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z);
        }
    }

    public static void setLabelFor(@NonNull View view, @IdRes int i) {
        view.setLabelFor(i);
    }

    public static void setLayerPaint(@NonNull View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void setLayoutDirection(@NonNull View view, int i) {
        view.setLayoutDirection(i);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
        }
    }

    public static void setNextClusterForwardId(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return OnApplyWindowInsetsListener.this.onApplyWindowInsets(view2, WindowInsetsCompat.toWindowInsetsCompat(windowInsets)).toWindowInsets();
                    }
                });
            }
        }
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void setPaddingRelative(@NonNull View view, @InterfaceC0075Px int i, @InterfaceC0075Px int i2, @InterfaceC0075Px int i3, @InterfaceC0075Px int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(@NonNull View view, PointerIconCompat pointerIconCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    @UiThread
    public static void setScreenReaderFocusable(View view, boolean z) {
        screenReaderFocusableProperty().set(view, Boolean.valueOf(z));
    }

    public static void setScrollIndicators(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i);
        }
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (sTransitionNameMap == null) {
            sTransitionNameMap = new WeakHashMap<>();
        }
        sTransitionNameMap.put(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(@NonNull View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f);
        }
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(@NonNull View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f);
        }
    }

    public static boolean startDragAndDrop(@NonNull View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }
        return view.startDrag(clipData, dragShadowBuilder, obj, i);
    }

    public static boolean startNestedScroll(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.startNestedScroll(i);
        }
        if (view instanceof NestedScrollingChild) {
            return ((NestedScrollingChild) view).startNestedScroll(i);
        }
        return false;
    }

    public static void stopNestedScroll(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(@NonNull View view, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    public static void postInvalidateOnAnimation(@NonNull View view, int i, int i2, int i3, int i4) {
        view.postInvalidateOnAnimation(i, i2, i3, i4);
    }

    public static void setScrollIndicators(@NonNull View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    private static void addAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            getOrCreateAccessibilityDelegateCompat(view);
            removeActionWithId(accessibilityActionCompat.getId(), view);
            getActionList(view).add(accessibilityActionCompat);
            notifyViewAccessibilityStateChangedIfNeeded(view, 0);
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        if (i3 == 0) {
            return dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
        }
        return false;
    }

    public static void dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        } else {
            dispatchNestedScroll(view, i, i2, i3, i4, iArr, i5);
        }
    }

    public static boolean hasNestedScrollingParent(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
            return false;
        } else if (i == 0) {
            return hasNestedScrollingParent(view);
        } else {
            return false;
        }
    }

    public static boolean startNestedScroll(@NonNull View view, int i, int i2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        if (i2 == 0) {
            return startNestedScroll(view, i);
        }
        return false;
    }

    public static void stopNestedScroll(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
        } else if (i == 0) {
            stopNestedScroll(view);
        }
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        if (i5 == 0) {
            return dispatchNestedScroll(view, i, i2, i3, i4, iArr);
        }
        return false;
    }
}

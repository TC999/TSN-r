package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    @NonNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    private Parcelable[] mBackStackToRestore;
    private final Context mContext;
    private boolean mDeepLinkHandled;
    NavGraph mGraph;
    private NavInflater mInflater;
    private LifecycleOwner mLifecycleOwner;
    private Bundle mNavigatorStateToRestore;
    private NavControllerViewModel mViewModel;
    final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    private NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    private final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.mGraph != null) {
                for (NavBackStackEntry navBackStackEntry : navController.mBackStack) {
                    navBackStackEntry.handleLifecycleEvent(event);
                }
            }
        }
    };
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) { // from class: androidx.navigation.NavController.2
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    private boolean mEnableOnBackPressedCallback = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public NavController(@NonNull Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    private boolean dispatchOnDestinationChanged() {
        while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof NavGraph) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
        }
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        NavDestination destination = this.mBackStack.peekLast().getDestination();
        NavDestination navDestination = null;
        if (destination instanceof FloatingWindow) {
            Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                NavDestination destination2 = descendingIterator.next().getDestination();
                if (!(destination2 instanceof NavGraph) && !(destination2 instanceof FloatingWindow)) {
                    navDestination = destination2;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<NavBackStackEntry> descendingIterator2 = this.mBackStack.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry next = descendingIterator2.next();
            Lifecycle.State maxLifecycle = next.getMaxLifecycle();
            NavDestination destination3 = next.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (maxLifecycle != state) {
                    hashMap.put(next, state);
                }
                destination = destination.getParent();
            } else if (navDestination != null && destination3.getId() == navDestination.getId()) {
                if (maxLifecycle == Lifecycle.State.RESUMED) {
                    next.setMaxLifecycle(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (maxLifecycle != state2) {
                        hashMap.put(next, state2);
                    }
                }
                navDestination = navDestination.getParent();
            } else {
                next.setMaxLifecycle(Lifecycle.State.CREATED);
            }
        }
        for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry);
            if (state3 != null) {
                navBackStackEntry.setMaxLifecycle(state3);
            } else {
                navBackStackEntry.updateState();
            }
        }
        NavBackStackEntry peekLast = this.mBackStack.peekLast();
        Iterator<OnDestinationChangedListener> it = this.mOnDestinationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        return true;
    }

    @Nullable
    private String findInvalidDestinationDisplayNameInDeepLink(@NonNull int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        int i4 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i4 >= iArr.length) {
                return null;
            }
            int i5 = iArr[i4];
            if (i4 == 0) {
                if (this.mGraph.getId() == i5) {
                    navDestination = this.mGraph;
                }
            } else {
                navDestination = navGraph2.findNode(i5);
            }
            if (navDestination == null) {
                return NavDestination.getDisplayName(this.mContext, i5);
            }
            if (i4 != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i4++;
        }
    }

    private int getDestinationCountOnBackStack() {
        int i4 = 0;
        for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
            if (!(navBackStackEntry.getDestination() instanceof NavGraph)) {
                i4++;
            }
        }
        return i4;
    }

    private void onGraphCreated(@Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.mNavigatorStateToRestore;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.mNavigatorProvider.getNavigator(next);
                Bundle bundle3 = this.mNavigatorStateToRestore.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.mBackStackToRestore;
        boolean z3 = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    Bundle args = navBackStackEntryState.getArgs();
                    if (args != null) {
                        args.setClassLoader(this.mContext.getClassLoader());
                    }
                    this.mBackStack.add(new NavBackStackEntry(this.mContext, findDestination, args, this.mLifecycleOwner, this.mViewModel, navBackStackEntryState.getUUID(), navBackStackEntryState.getSavedState()));
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.getDisplayName(this.mContext, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.mBackStackToRestore = null;
        }
        if (this.mGraph != null && this.mBackStack.isEmpty()) {
            if (!this.mDeepLinkHandled && (activity = this.mActivity) != null && handleDeepLink(activity.getIntent())) {
                z3 = true;
            }
            if (z3) {
                return;
            }
            navigate(this.mGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
            return;
        }
        dispatchOnDestinationChanged();
    }

    private void updateOnBackPressedCallbackEnabled() {
        boolean z3 = true;
        this.mOnBackPressedCallback.setEnabled((!this.mEnableOnBackPressedCallback || getDestinationCountOnBackStack() <= 1) ? false : false);
    }

    public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.mBackStack.isEmpty()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.mOnDestinationChangedListeners.add(onDestinationChangedListener);
    }

    @NonNull
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableOnBackPressed(boolean z3) {
        this.mEnableOnBackPressedCallback = z3;
        updateOnBackPressedCallbackEnabled();
    }

    NavDestination findDestination(@IdRes int i4) {
        NavGraph destination;
        NavGraph parent;
        NavGraph navGraph = this.mGraph;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.getId() == i4) {
            return this.mGraph;
        }
        if (this.mBackStack.isEmpty()) {
            destination = this.mGraph;
        } else {
            destination = this.mBackStack.getLast().getDestination();
        }
        if (destination instanceof NavGraph) {
            parent = destination;
        } else {
            parent = destination.getParent();
        }
        return parent.findNode(i4);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Deque<NavBackStackEntry> getBackStack() {
        return this.mBackStack;
    }

    @NonNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i4) {
        NavBackStackEntry navBackStackEntry;
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = descendingIterator.next();
            if (navBackStackEntry.getDestination().getId() == i4) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException("No destination with ID " + i4 + " is on the NavController's back stack. The current destination is " + getCurrentDestination());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public NavBackStackEntry getCurrentBackStackEntry() {
        if (this.mBackStack.isEmpty()) {
            return null;
        }
        return this.mBackStack.getLast();
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @NonNull
    public NavGraph getGraph() {
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @NonNull
    public NavInflater getNavInflater() {
        if (this.mInflater == null) {
            this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
        }
        return this.mInflater;
    }

    @NonNull
    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    @Nullable
    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            NavBackStackEntry next = descendingIterator.next();
            if (!(next.getDestination() instanceof NavGraph)) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i4) {
        if (this.mViewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i4);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException("No NavGraph with ID " + i4 + " is on the NavController's back stack");
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
    }

    public boolean handleDeepLink(@Nullable Intent intent) {
        NavDestination.DeepLinkMatch matchDeepLink;
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(intent))) != null) {
            NavDestination destination = matchDeepLink.getDestination();
            int[] buildDeepLinkIds = destination.buildDeepLinkIds();
            bundle.putAll(destination.addInDefaultArgs(matchDeepLink.getMatchingArgs()));
            intArray = buildDeepLinkIds;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String findInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (findInvalidDestinationDisplayNameInDeepLink != null) {
            Log.i("NavController", "Could not find destination " + findInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.finish();
                this.mActivity.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i4 != 0) {
            if (!this.mBackStack.isEmpty()) {
                popBackStackInternal(this.mGraph.getId(), true);
            }
            int i5 = 0;
            while (i5 < intArray.length) {
                int i6 = i5 + 1;
                int i7 = intArray[i5];
                NavDestination findDestination = findDestination(i7);
                if (findDestination != null) {
                    navigate(findDestination, bundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                    i5 = i6;
                } else {
                    String displayName = NavDestination.getDisplayName(this.mContext, i7);
                    throw new IllegalStateException("Deep Linking failed: destination " + displayName + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            return true;
        } else {
            NavGraph navGraph2 = this.mGraph;
            int i8 = 0;
            while (i8 < intArray.length) {
                int i9 = intArray[i8];
                NavDestination findNode = i8 == 0 ? this.mGraph : navGraph2.findNode(i9);
                if (findNode != null) {
                    if (i8 != intArray.length - 1) {
                        while (true) {
                            navGraph = (NavGraph) findNode;
                            if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                                break;
                            }
                            findNode = navGraph.findNode(navGraph.getStartDestination());
                        }
                        navGraph2 = navGraph;
                    } else {
                        navigate(findNode, findNode.addInDefaultArgs(bundle), new NavOptions.Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                    }
                    i8++;
                } else {
                    String displayName2 = NavDestination.getDisplayName(this.mContext, i9);
                    throw new IllegalStateException("Deep Linking failed: destination " + displayName2 + " cannot be found in graph " + navGraph2);
                }
            }
            this.mDeepLinkHandled = true;
            return true;
        }
    }

    public void navigate(@IdRes int i4) {
        navigate(i4, (Bundle) null);
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() == 1) {
            NavDestination currentDestination = getCurrentDestination();
            int id = currentDestination.getId();
            for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
                if (parent.getStartDestination() != id) {
                    Bundle bundle = new Bundle();
                    Activity activity = this.mActivity;
                    if (activity != null && activity.getIntent() != null && this.mActivity.getIntent().getData() != null) {
                        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.mActivity.getIntent());
                        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(this.mActivity.getIntent()));
                        if (matchDeepLink != null) {
                            bundle.putAll(matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs()));
                        }
                    }
                    new NavDeepLinkBuilder(this).setDestination(parent.getId()).setArguments(bundle).createTaskStackBuilder().startActivities();
                    Activity activity2 = this.mActivity;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return true;
                }
                id = parent.getId();
            }
            return false;
        }
        return popBackStack();
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    boolean popBackStackInternal(@IdRes int i4, boolean z3) {
        boolean z4;
        boolean z5 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z4 = false;
                break;
            }
            NavDestination destination = descendingIterator.next().getDestination();
            Navigator navigator = this.mNavigatorProvider.getNavigator(destination.getNavigatorName());
            if (z3 || destination.getId() != i4) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i4) {
                z4 = true;
                break;
            }
        }
        if (!z4) {
            String displayName = NavDestination.getDisplayName(this.mContext, i4);
            Log.i("NavController", "Ignoring popBackStack to destination " + displayName + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry removeLast = this.mBackStack.removeLast();
            if (removeLast.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                removeLast.setMaxLifecycle(Lifecycle.State.DESTROYED);
            }
            NavControllerViewModel navControllerViewModel = this.mViewModel;
            if (navControllerViewModel != null) {
                navControllerViewModel.clear(removeLast.mId);
            }
            z5 = true;
        }
        updateOnBackPressedCallbackEnabled();
        return z5;
    }

    public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.mContext.getClassLoader());
        this.mNavigatorStateToRestore = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.mBackStackToRestore = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.mDeepLinkHandled = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    @Nullable
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.mNavigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!this.mBackStack.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.mBackStack.size()];
            int i4 = 0;
            for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
                parcelableArr[i4] = new NavBackStackEntryState(navBackStackEntry);
                i4++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.mDeepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.mDeepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    public void setGraph(@NavigationRes int i4) {
        setGraph(i4, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == this.mLifecycleOwner) {
            return;
        }
        this.mLifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@NonNull NavigatorProvider navigatorProvider) {
        if (this.mBackStack.isEmpty()) {
            this.mNavigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.mLifecycleOwner != null) {
            this.mOnBackPressedCallback.remove();
            onBackPressedDispatcher.addCallback(this.mLifecycleOwner, this.mOnBackPressedCallback);
            this.mLifecycleOwner.getLifecycle().removeObserver(this.mLifecycleObserver);
            this.mLifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        if (this.mViewModel == NavControllerViewModel.getInstance(viewModelStore)) {
            return;
        }
        if (this.mBackStack.isEmpty()) {
            this.mViewModel = NavControllerViewModel.getInstance(viewModelStore);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public void navigate(@IdRes int i4, @Nullable Bundle bundle) {
        navigate(i4, bundle, (NavOptions) null);
    }

    @CallSuper
    public void setGraph(@NavigationRes int i4, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i4), bundle);
    }

    public void navigate(@IdRes int i4, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i4, bundle, navOptions, (Navigator.Extras) null);
    }

    public boolean popBackStack(@IdRes int i4, boolean z3) {
        return popBackStackInternal(i4, z3) && dispatchOnDestinationChanged();
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void navigate(@IdRes int i4, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination destination;
        int i5;
        if (this.mBackStack.isEmpty()) {
            destination = this.mGraph;
        } else {
            destination = this.mBackStack.getLast().getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(i4);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i5 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i5 = i4;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i5 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
                return;
            } else if (i5 != 0) {
                NavDestination findDestination = findDestination(i5);
                if (findDestination == null) {
                    String displayName = NavDestination.getDisplayName(this.mContext, i5);
                    if (action != null) {
                        throw new IllegalArgumentException("Navigation destination " + displayName + " referenced from action " + NavDestination.getDisplayName(this.mContext, i4) + " cannot be found from the current destination " + destination);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
                }
                navigate(findDestination, bundle2, navOptions, extras);
                return;
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        }
        throw new IllegalStateException("no current navigation node");
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph, @Nullable Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            popBackStackInternal(navGraph2.getId(), true);
        }
        this.mGraph = navGraph;
        onGraphCreated(bundle);
    }

    public void navigate(@NonNull Uri uri) {
        navigate(new NavDeepLinkRequest(uri, null, null));
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions, extras);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions) {
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            Bundle addInDefaultArgs = matchDeepLink.getDestination().addInDefaultArgs(matchDeepLink.getMatchingArgs());
            if (addInDefaultArgs == null) {
                addInDefaultArgs = new Bundle();
            }
            NavDestination destination = matchDeepLink.getDestination();
            Intent intent = new Intent();
            intent.setDataAndType(navDeepLinkRequest.getUri(), navDeepLinkRequest.getMimeType());
            intent.setAction(navDeepLinkRequest.getAction());
            addInDefaultArgs.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
            navigate(destination, addInDefaultArgs, navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this.mGraph);
    }

    private void navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        boolean z3 = false;
        boolean popBackStackInternal = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : popBackStackInternal(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.getNavigatorName());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        NavDestination navigate = navigator.navigate(navDestination, addInDefaultArgs, navOptions, extras);
        if (navigate != null) {
            if (!(navigate instanceof FloatingWindow)) {
                while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof FloatingWindow) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (navDestination instanceof NavGraph) {
                NavGraph navGraph = navigate;
                while (true) {
                    NavGraph parent = navGraph.getParent();
                    if (parent != null) {
                        arrayDeque.addFirst(new NavBackStackEntry(this.mContext, parent, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
                        if (!this.mBackStack.isEmpty() && this.mBackStack.getLast().getDestination() == parent) {
                            popBackStackInternal(parent.getId(), true);
                        }
                    }
                    if (parent == null || parent == navDestination) {
                        break;
                    }
                    navGraph = parent;
                }
            }
            NavGraph destination = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getFirst()).getDestination();
            while (destination != null && findDestination(destination.getId()) == null) {
                destination = destination.getParent();
                if (destination != null) {
                    arrayDeque.addFirst(new NavBackStackEntry(this.mContext, destination, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
                }
            }
            NavDestination destination2 = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getLast()).getDestination();
            while (!this.mBackStack.isEmpty() && (this.mBackStack.getLast().getDestination() instanceof NavGraph) && ((NavGraph) this.mBackStack.getLast().getDestination()).findNode(destination2.getId(), false) == null && popBackStackInternal(this.mBackStack.getLast().getDestination().getId(), true)) {
            }
            this.mBackStack.addAll(arrayDeque);
            if (this.mBackStack.isEmpty() || this.mBackStack.getFirst().getDestination() != this.mGraph) {
                this.mBackStack.addFirst(new NavBackStackEntry(this.mContext, this.mGraph, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel));
            }
            this.mBackStack.add(new NavBackStackEntry(this.mContext, navigate, navigate.addInDefaultArgs(addInDefaultArgs), this.mLifecycleOwner, this.mViewModel));
        } else if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            if (peekLast != null) {
                peekLast.replaceArguments(addInDefaultArgs);
            }
            z3 = true;
        }
        updateOnBackPressedCallbackEnabled();
        if (popBackStackInternal || navigate != null || z3) {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(@NonNull NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(@NonNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(@NonNull NavDirections navDirections, @NonNull Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }
}

package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.C0581R;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class NavHostFragment extends Fragment implements NavHost {
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    private static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    private static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean mDefaultNavHost;
    private int mGraphId;
    private Boolean mIsPrimaryBeforeOnCreate = null;
    private NavHostController mNavController;
    private View mViewParent;

    @NonNull
    public static NavHostFragment create(@NavigationRes int i) {
        return create(i, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).getNavController();
            }
            Fragment primaryNavigationFragment = fragment2.getParentFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof NavHostFragment) {
                return ((NavHostFragment) primaryNavigationFragment).getNavController();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return Navigation.findNavController(view);
        }
        Dialog dialog = fragment instanceof DialogFragment ? ((DialogFragment) fragment).getDialog() : null;
        if (dialog != null && dialog.getWindow() != null) {
            return Navigation.findNavController(dialog.getWindow().getDecorView());
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int getContainerId() {
        int id = getId();
        return (id == 0 || id == -1) ? C0603R.C0606id.nav_host_fragment_container : id;
    }

    @NonNull
    @Deprecated
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        return new FragmentNavigator(requireContext(), getChildFragmentManager(), getContainerId());
    }

    @Override // androidx.navigation.NavHost
    @NonNull
    public final NavController getNavController() {
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            return navHostController;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.mDefaultNavHost) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        ((DialogFragmentNavigator) this.mNavController.getNavigatorProvider().getNavigator(DialogFragmentNavigator.class)).onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        NavHostController navHostController = new NavHostController(requireContext());
        this.mNavController = navHostController;
        navHostController.setLifecycleOwner(this);
        this.mNavController.setOnBackPressedDispatcher(requireActivity().getOnBackPressedDispatcher());
        NavHostController navHostController2 = this.mNavController;
        Boolean bool = this.mIsPrimaryBeforeOnCreate;
        navHostController2.enableOnBackPressed(bool != null && bool.booleanValue());
        this.mIsPrimaryBeforeOnCreate = null;
        this.mNavController.setViewModelStore(getViewModelStore());
        onCreateNavController(this.mNavController);
        if (bundle != null) {
            bundle2 = bundle.getBundle(KEY_NAV_CONTROLLER_STATE);
            if (bundle.getBoolean(KEY_DEFAULT_NAV_HOST, false)) {
                this.mDefaultNavHost = true;
                getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
            }
            this.mGraphId = bundle.getInt(KEY_GRAPH_ID);
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.mNavController.restoreState(bundle2);
        }
        int i = this.mGraphId;
        if (i != 0) {
            this.mNavController.setGraph(i);
        } else {
            Bundle arguments = getArguments();
            int i2 = arguments != null ? arguments.getInt(KEY_GRAPH_ID) : 0;
            Bundle bundle3 = arguments != null ? arguments.getBundle(KEY_START_DESTINATION_ARGS) : null;
            if (i2 != 0) {
                this.mNavController.setGraph(i2, bundle3);
            }
        }
        super.onCreate(bundle);
    }

    @CallSuper
    protected void onCreateNavController(@NonNull NavController navController) {
        navController.getNavigatorProvider().addNavigator(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.getNavigatorProvider().addNavigator(createFragmentNavigator());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(getContainerId());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.mViewParent;
        if (view != null && Navigation.findNavController(view) == this.mNavController) {
            Navigation.setViewNavController(this.mViewParent, null);
        }
        this.mViewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0581R.styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(C0581R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.mGraphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0603R.styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(C0603R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.mDefaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPrimaryNavigationFragmentChanged(boolean z) {
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            navHostController.enableOnBackPressed(z);
        } else {
            this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle saveState = this.mNavController.saveState();
        if (saveState != null) {
            bundle.putBundle(KEY_NAV_CONTROLLER_STATE, saveState);
        }
        if (this.mDefaultNavHost) {
            bundle.putBoolean(KEY_DEFAULT_NAV_HOST, true);
        }
        int i = this.mGraphId;
        if (i != 0) {
            bundle.putInt(KEY_GRAPH_ID, i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            Navigation.setViewNavController(view, this.mNavController);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.mViewParent = view2;
                if (view2.getId() == getId()) {
                    Navigation.setViewNavController(this.mViewParent, this.mNavController);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }

    @NonNull
    public static NavHostFragment create(@NavigationRes int i, @Nullable Bundle bundle) {
        Bundle bundle2;
        if (i != 0) {
            bundle2 = new Bundle();
            bundle2.putInt(KEY_GRAPH_ID, i);
        } else {
            bundle2 = null;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBundle(KEY_START_DESTINATION_ARGS, bundle);
        }
        NavHostFragment navHostFragment = new NavHostFragment();
        if (bundle2 != null) {
            navHostFragment.setArguments(bundle2);
        }
        return navHostFragment;
    }
}
package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    private Bundle mArgs;
    private final Context mContext;
    private ViewModelProvider.Factory mDefaultFactory;
    private final NavDestination mDestination;
    private Lifecycle.State mHostLifecycle;
    @NonNull
    final UUID mId;
    private final LifecycleRegistry mLifecycle;
    private Lifecycle.State mMaxLifecycle;
    private NavControllerViewModel mNavControllerViewModel;
    private SavedStateHandle mSavedStateHandle;
    private final SavedStateRegistryController mSavedStateRegistryController;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* renamed from: androidx.navigation.NavBackStackEntry$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        NavResultSavedStateFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
        }

        @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
        @NonNull
        protected <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle) {
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class SavedStateViewModel extends ViewModel {
        private SavedStateHandle mHandle;

        SavedStateViewModel(SavedStateHandle savedStateHandle) {
            this.mHandle = savedStateHandle;
        }

        public SavedStateHandle getHandle() {
            return this.mHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel) {
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), null);
    }

    @NonNull
    private static Lifecycle.State getStateAfter(@NonNull Lifecycle.Event event) {
        switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
            case 1:
            case 2:
                return Lifecycle.State.CREATED;
            case 3:
            case 4:
                return Lifecycle.State.STARTED;
            case 5:
                return Lifecycle.State.RESUMED;
            case 6:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    @Nullable
    public Bundle getArguments() {
        return this.mArgs;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory((Application) this.mContext.getApplicationContext(), this, this.mArgs);
        }
        return this.mDefaultFactory;
    }

    @NonNull
    public NavDestination getDestination() {
        return this.mDestination;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Lifecycle.State getMaxLifecycle() {
        return this.mMaxLifecycle;
    }

    @NonNull
    public SavedStateHandle getSavedStateHandle() {
        if (this.mSavedStateHandle == null) {
            this.mSavedStateHandle = ((SavedStateViewModel) new ViewModelProvider(this, new NavResultSavedStateFactory(this, null)).get(SavedStateViewModel.class)).getHandle();
        }
        return this.mSavedStateHandle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.mNavControllerViewModel;
        if (navControllerViewModel != null) {
            return navControllerViewModel.getViewModelStore(this.mId);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        this.mHostLifecycle = getStateAfter(event);
        updateState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceArguments(@Nullable Bundle bundle) {
        this.mArgs = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveState(@NonNull Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxLifecycle(@NonNull Lifecycle.State state) {
        this.mMaxLifecycle = state;
        updateState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateState() {
        if (this.mHostLifecycle.ordinal() < this.mMaxLifecycle.ordinal()) {
            this.mLifecycle.setCurrentState(this.mHostLifecycle);
        } else {
            this.mLifecycle.setCurrentState(this.mMaxLifecycle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel, @NonNull UUID uuid, @Nullable Bundle bundle2) {
        this.mLifecycle = new LifecycleRegistry(this);
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = create;
        this.mHostLifecycle = Lifecycle.State.CREATED;
        this.mMaxLifecycle = Lifecycle.State.RESUMED;
        this.mContext = context;
        this.mId = uuid;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        create.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.mHostLifecycle = lifecycleOwner.getLifecycle().getCurrentState();
        }
    }
}

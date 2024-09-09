package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class NavHostController extends NavController {
    public NavHostController(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.navigation.NavController
    public final void enableOnBackPressed(boolean z3) {
        super.enableOnBackPressed(z3);
    }

    @Override // androidx.navigation.NavController
    public final void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.navigation.NavController
    public final void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        super.setOnBackPressedDispatcher(onBackPressedDispatcher);
    }

    @Override // androidx.navigation.NavController
    public final void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        super.setViewModelStore(viewModelStore);
    }
}

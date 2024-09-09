package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ViewModelStores {
    private ViewModelStores() {
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull Fragment fragment) {
        return fragment.getViewModelStore();
    }
}

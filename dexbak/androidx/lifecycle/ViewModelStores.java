package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ViewModelStores {
    private ViewModelStores() {
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m60014of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.getViewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    /* renamed from: of */
    public static ViewModelStore m60015of(@NonNull Fragment fragment) {
        return fragment.getViewModelStore();
    }
}

package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter mGeneratedAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.mGeneratedAdapter = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.mGeneratedAdapter.callMethods(lifecycleOwner, event, false, null);
        this.mGeneratedAdapter.callMethods(lifecycleOwner, event, true, null);
    }
}

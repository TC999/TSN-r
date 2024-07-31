package androidx.lifecycle;

import androidx.annotation.NonNull;

@Deprecated
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}

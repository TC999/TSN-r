package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface ObservableReference<T> {
    void addListener(T t3);

    WeakListener<T> getListener();

    void removeListener(T t3);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);
}

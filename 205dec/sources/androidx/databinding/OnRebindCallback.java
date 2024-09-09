package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t3) {
    }

    public void onCanceled(T t3) {
    }

    public boolean onPreBind(T t3) {
        return true;
    }
}
